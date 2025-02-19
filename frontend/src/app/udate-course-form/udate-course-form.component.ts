import { Component, OnInit } from '@angular/core';
import { Concept, Course, question, topic } from '../entities';
import { UserService } from '../user.service';
import { CommonModule } from '@angular/common';
import { FormArray, FormBuilder, FormGroup, FormsModule, Validators } from '@angular/forms';
import { HeaderComponent } from '../header/header.component';
import { FooterComponent } from "../footer/footer.component";
import { ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-udate-course-form',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule, HeaderComponent,FooterComponent],
  templateUrl: './udate-course-form.component.html',
  styleUrl: './udate-course-form.component.css'
})
export class UdateCourseFormComponent implements OnInit{
  constructor(private userservice : UserService,private formbuilder : FormBuilder,private router : Router,private route : ActivatedRoute){}

  course : Course = new Course()
  topics : topic[] = []
  conceptarray : Concept[] = []
  questionarray : question[] = []
  cat : number = 0;
  ngOnInit(): void {
    const courseId = Number(this.route.snapshot.paramMap.get('courseid')) 
    this.userservice.getcoursefromcourseid(courseId).subscribe(
      (response)=>{
        this.course = response
        this.cat = this.course.category.categoryid
        this.userservice.gettopicfromcourse("gettopicsfromcourseid",courseId).subscribe(
          (response)=>{
            this.topics = response
          },
          (error)=>{
              console.log(error)
          }
        )

      },(error)=>{
          console.log(error)
      }
    )
  }

  topicstatus : boolean = false
  selectedtopicid : number = 0
  selectedtopicobject : topic = new topic()
  selectedtopic(){
    this.selectedtopicobject = this.topics.filter((top)=>{
      return top.topicid==this.selectedtopicid
    })[0]
    this.userservice.getconceptsfromtopicid("conceptsfromtopicid",this.selectedtopicid).subscribe(
      (response)=>{
        this.conceptarray = response
        this.topicstatus = true
      },(error)=>{}
    )
  }

  selectedconceptid : number = 0
  conceptstatus : boolean = false
  hasquestion : boolean = false
  selectedconceptobject : Concept = new Concept()
  seletedconcept(){
    this.selectedconceptobject = this.conceptarray.filter((con)=>{
      return con.conceptid==this.selectedconceptid
    })[0]
    this.conceptstatus = true
    this.userservice.getquestionfromconcept(this.selectedconceptobject.conceptid).subscribe(
      (response)=>{
        this.questionarray = response
        if(this.questionarray.length > 0){
          this.hasquestion = true
        }
      },(error)=>{}
    )
  }

  selectedquestionid : number = 0
  selectedquestionobject : question = new question()
  options : any[] = []
  questionstatus  = false
  seletedquestion(){
   this.selectedquestionobject =  this.questionarray.filter((que)=>{
      return que.questionid==this.selectedquestionid
    })[0]
    this.options = this.selectedquestionobject.answermarkup.split(",")
    this.questionstatus = true
  }

  changestatus(operation : string)
  {
    if(operation=='topic'){
        this.topictoaddstatus = true
    }else if(operation=='concept'){
        this.concepttoaddstatus = true
    }else if(operation=='question'){
        this.questiontoaddstatus = true
    }
  }
  topictoadd : topic = new topic()
  topictoaddstatus : boolean = false
  addtopic(){
    this.topictoadd.active = 1
    this.topictoadd.course = this.course.courseid
    this.topictoadd.createat = new Date()
    this.topictoadd.updatedat = new Date()
    this.userservice.addtopicinotdb("addtopics",this.topictoadd).subscribe(
      (response)=>{this.topictoaddstatus = false},(error)=>{}
    )
  }
  concepttoadd : Concept = new Concept()
  concepttoaddstatus : boolean = false
  addconcept(){
     this.concepttoadd.active = 1
     this.concepttoadd.creatat = new Date()
     this.concepttoadd.updateat = new Date()
     this.concepttoadd.topic = this.selectedtopicobject.topicid
     this.userservice.addconceptinotdb("addconcepts",this.concepttoadd).subscribe(
      (response)=>{this.concepttoaddstatus = false},(error)=>{}
    )
  }
  questiontoadd : question = new question()
  questiontoaddstatus : boolean = false
  optiontoadd : string = ''
  singleotion : string = ''
  optionadding(){
    this.optiontoadd = this.singleotion + ','
  }
  addquestion(){
      this.questiontoadd.active = 1
      this.questiontoadd.concept = this.selectedconceptobject
      this.questiontoadd.createat = new Date()
      this.questiontoadd.answermarkup = this.options[0] + "," + this.options[1] + "," + this.options[2] + "," + this.options[3]
      this.questiontoadd.update = new Date()
      this.questiontoadd.answermarkup = this.optiontoadd
      this.userservice.addquestionfromconceptid("addquestion",this.questiontoadd).subscribe(
        (response)=>{this.questiontoaddstatus = false},(error)=>{}
      )
  }

  updatecourse(){
    this.userservice.addcourseintodatabase("addcourseintodatabase",this.course).subscribe(
      (response)=>{alert("Updated Sucessfully")},(error)=>{}
    )
  }

  updatetopic(){
    this.userservice.addtopicinotdb("addtopics",this.selectedtopicobject).subscribe(
      (response)=>{this.topicstatus = false},(error)=>{}
    )
  }

  updateconcept(){
    this.userservice.addconceptinotdb("addconcepts",this.selectedconceptobject).subscribe(
      (response)=>{this.conceptstatus = false},(error)=>{}
    )
  }

  updatequestion(){
    this.userservice.addquestionfromconceptid("addquestion",this.selectedquestionobject).subscribe(
      (response)=>{this.questionstatus = false},(error)=>{}
    )
  }
}


