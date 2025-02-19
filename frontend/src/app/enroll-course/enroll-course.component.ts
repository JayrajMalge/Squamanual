import { Component, OnInit,Inject, PLATFORM_ID} from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user.service';
import { Concept, Course, Review, User, topic ,question,test} from '../entities';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from "../header/header.component";
import { trigger, state, style, transition, animate } from '@angular/animations';
import { FooterComponent } from "../footer/footer.component";
import {MatRadioButton} from "@angular/material/radio"
import { MatCard } from '@angular/material/card';
import { MatFormField } from '@angular/material/form-field';
import { MatAccordion, MatExpansionPanel, MatExpansionPanelHeader, MatExpansionPanelTitle } from '@angular/material/expansion';
import {MatProgressBar} from "@angular/material/progress-bar"
import {MatTabGroup,MatTab, MatTabsModule} from "@angular/material/tabs"



@Component({
  selector: 'app-enroll-course',
  standalone: true,
  imports: [MatTabsModule,FormsModule, CommonModule,MatFormField ,HeaderComponent, FooterComponent,MatRadioButton,MatCard,MatAccordion,MatExpansionPanel,MatExpansionPanelHeader,MatExpansionPanelTitle,MatProgressBar],
  templateUrl: './enroll-course.component.html',
  styleUrl: './enroll-course.component.css',
  animations: [
    trigger('expandCollapse', [
      state('collapsed', style({ height: '0', opacity: '0', overflow: 'hidden' })),
      state('expanded', style({ height: '*', opacity: '1' })),
      transition('collapsed <=> expanded', animate('200ms ease-in-out'))
    ])
  ],
})
export class EnrollCourseComponent implements OnInit{
      constructor(private route : ActivatedRoute,private userservice : UserService,private sanitizer : DomSanitizer,@Inject(PLATFORM_ID) private platformId: Object){}
      courseId : number = 0
      topics : topic[] = []
      conceptarray : Concept[] = []
      course : Course = new Course();
      imgid : string = ''
      imgurl : SafeResourceUrl|null = null
      user : User = new User()
      reviews : any = new Review()

      ngOnInit(): void {
        this.courseId = Number(this.route.snapshot.paramMap.get('courseid')) 
            this.userservice.getcoursefromcourseid(this.courseId).subscribe(
              (response)=>{
                this.course = response
                this.userservice.gettopicfromcourse("gettopicsfromcourseid",this.courseId).subscribe(
                  (response)=>{
                    this.topics = response
                      this.userservice.getconceptsfromtopicid("conceptsfromtopicid",response[0].topicid).subscribe(
                        (response)=>{
                          this.conceptarray = response
                          console.log(this.conceptquestions)
                          this.imgurl =  this.sanitizer.bypassSecurityTrustResourceUrl(this.conceptarray[0].descriptionmarkup)
                        },(error)=>{
                          console.log(error)
                        }
                      )
                  },
                  (error)=>{
                      console.log(error)
                  }
                )
              },(error)=>{

              }
            )
            if (isPlatformBrowser(this.platformId)) {
              const email = window.localStorage.getItem("elearning")??''
              this.userservice.getuserfromemail(email).subscribe(
              (response)=>{
                 this.user = response
                 this.userservice.getreviewsbycourseanduser(this.courseId,this.user.userid).subscribe(
                  (response)=>{
                     this.reviews = response
                     console.log(this.reviews)
                
                  },(error)=>{
                       console.log(error)
                  }
                 )
              },(error)=>{
                console.log(error)
              }
            )
          }
      }

      dropdown = {
        status : false
      }

      userReview: string = '';
      userRating: number = 0;
      submitReview() {
         const review = new Review()
         review.course = this.course;
         review.descriptionmarkup = this.userReview
         review.user = this.user
         this.userservice.addreview("addreview",review).subscribe(
          (response)=>{
            this.reviews = response
          },(error)=>{
            console.log(error)
          }
         )
      }

      concept : Concept = new Concept()
      toggleSubtopics(topic: topic) {
        topic.isOpen = !topic.isOpen
        this.topics.map((top)=>{
          if(top.topicid != topic.topicid){
                top.isOpen = false;
          }
        })
        this.userservice.getconceptsfromtopicid("conceptsfromtopicid",topic.topicid).subscribe(
          (response)=>{
            this.conceptarray = response
          },(error)=>{

          }
        )
      }

      playvideo(topic : topic,concept : Concept){
        this.imgurl = this.sanitizer.bypassSecurityTrustResourceUrl(concept.descriptionmarkup);
        this.userservice.getquestionfromconcept(concept.conceptid).subscribe(
          (response)=>{
            this.conceptquestions = response
            console.log(this.conceptquestions)
          },(error)=>{
            console.log(error)
          }
        )
      }



  givequizoption : boolean = false;
  showmark : boolean = false
  marks : number = 0;
  

  currentQuestionIndex = 0;
  selectedAnswer: number | null = null;
  useranswer : number[] = [] 
  conceptquestions : question[] = []
  completedtest : test = new test()
  selectedTopic : topic = new topic()

  nextQuestion() {
    if (this.currentQuestionIndex < this.conceptquestions.length - 1) {
      this.currentQuestionIndex++;
      const selecteduseranswer = this.selectedAnswer?.valueOf();
      this.useranswer.push(selecteduseranswer ?? 0)
      this.selectedAnswer = null;
      console.log(this.currentQuestionIndex)

    } else {
      this.buttontext = 'Submit'
      this.currentQuestionIndex++
      this.submitQuiz();
    }
  }

  previousQuestion() {
    if (this.currentQuestionIndex > 0) {
      this.currentQuestionIndex--;
      this.selectedAnswer = null;
    }
  }

  submitQuiz() {
    let index = 0;
    this.conceptquestions.map((question)=>{
       this.useranswer[index]++
       if(question.correctoption == this.useranswer[index])
       {
        this.marks++
       }
       index = index + 1
    })
    this.showmark = true
    //this.playConfettiAnimation()
    this.completedtest.course = this.course;
    this.completedtest.topic = this.selectedTopic;
    this.completedtest.user = this.user
    this.completedtest.datetime = new Date()
    this.completedtest.createat = new Date()
    this.completedtest.noofquestions = this.conceptquestions.length
    console.log(this.completedtest)
    let test : any;
    this.userservice.addtestcompletedtest("addtestcompletion",this.completedtest).subscribe(
      (response)=>{
        test = response;
        this.givequizoption = false
        this.completedtest = test
        console.log(test)
      },(error)=>{
        console.log(error)
      }
    )
  }

  givequiz()
  {
    this.givequizoption = true;
  }
   
  retest(){
    this.currentQuestionIndex = 0
    this.useranswer = []
    this.givequizoption = true
    this.showmark = false
  }

  tabs = [
    { label: 'Overview', content : 'Experience'},
    { label: 'Reviews', content: 'Education' },
    { label: 'Quiz', content: 'Treatment' },
  ];

  buttontext : string = ''
  selectTab(index: number): void {
    this.activeTab = index;
    if(this.activeTab==2){
      this.givequizoption = true
      this.currentQuestionIndex = 0
      this.buttontext = 'Next'
    }
  }
  activeTab = 0;
}
