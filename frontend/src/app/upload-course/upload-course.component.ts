import { Component, OnInit } from '@angular/core';
import { Concept, Course, question, topic } from '../entities';
import { UserService } from '../user.service';
import { CommonModule } from '@angular/common';
import { FormArray, FormBuilder, FormGroup, FormsModule, Validators } from '@angular/forms';
import { HeaderComponent } from '../header/header.component';
import { FooterComponent } from "../footer/footer.component";
import { ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';



@Component({
  selector: 'app-upload-course',
  standalone: true,
  imports: [CommonModule, FormsModule, HeaderComponent, FooterComponent,ReactiveFormsModule],
  templateUrl: './upload-course.component.html',
  styleUrl: './upload-course.component.css'
})
export class UploadCourseComponent implements OnInit{

  courseForm : FormGroup
  constructor(private userservice : UserService,private formbuilder : FormBuilder,private route : Router){
    this.courseForm = this.formbuilder.group({
       "name" : ['',Validators.required],
       "description":['',Validators.required],
       "courseCategory":[0,Validators.required],
       "level":[0,Validators.required],
       "topics":this.formbuilder.array([])
     });
  }

  get topic()
  {
   return this.courseForm.get("topics") as FormArray
  }

  addnewtopic(){
    this.topic.push(this.formbuilder.group({
      "topicname":['',Validators.required],
      "topicconcepts":this.formbuilder.array([])
    }))
  }

  getconcept(index : number){
    return this.topic.at(index).get("topicconcepts") as FormArray
  }
  addnewconcepts(index : number){
    this.getconcept(index).push(this.formbuilder.group({
      "conceptname":['',Validators.required],
      "conceptdescription":['',Validators.required],
      "conceptquestions":this.formbuilder.array([])
    }))
  }

  getquestionbyindex(index1 : number,index2 : number){
    return this.getconcept(index1).at(index2).get("conceptquestions") as FormArray
  }
  
  addnewquestion(index1 : number,index2 : number){
    this.getquestionbyindex(index1,index2).push(this.formbuilder.group({
      "question":['',Validators.required],
      "option1":['',Validators.required],
      "option2":['',Validators.required],
      "option3":['',Validators.required],
      "option4":['',Validators.required],
      "difficulty":['',Validators.required],
      "answer":['',Validators.required]
    }))
  }

  spinnerstatus : boolean = true
  submitformgroup(){
    this.spinnerstatus = false
    const value = this.courseForm.value
    const topics : any[] = value.topics
      this.coursetocreate.name = value.name;
      this.coursetocreate.descriptionmarkup = value.description
      this.coursetocreate.difficulty = value.level;
      this.coursetocreate.points = 100;
      this.coursetocreate.active = 1
      this.coursetocreate.category = Number(value.courseCategory);
      this.coursetocreate.createat = new Date()
      this.coursetocreate.updatedat = new Date()
      this.coursetocreate.isfree = 1;
      this.userservice.addcourseintodatabase("addcourseintodatabase",this.coursetocreate).subscribe(
        (response)=>{
          const courseadded : any = response
          topics.map((topic)=>{
              const concepts : any[] = topic.topicconcepts
              this.singletopic.active = 1;
              this.singletopic.course = courseadded.courseid
              this.singletopic.name = topic.topicname
              this.singletopic.createat = new Date()
              this.singletopic.updatedat = new Date()
              this.userservice.addtopicinotdb("addtopics",this.singletopic).subscribe(
                (response)=>{
                  const addedtopic : any = response
                  concepts.map((concept)=>{
                      const questions : any[] = concept.conceptquestions
                      this.singleconcept.title = concept.conceptname;
                      this.singleconcept.descriptionmarkup = concept.conceptdescription
                      this.singleconcept.topic = addedtopic.topicid
                      this.singleconcept.creatat = new Date()
                      this.singleconcept.updateat = new Date()
                      this.singleconcept.active = 1
                      this.userservice.addconceptinotdb("addconcepts",this.singleconcept).subscribe(
                        (response)=>{
                          const addedconcept : any = response
                          questions.map((que)=>{
                              this.singlequestion.concept = addedconcept.conceptid
                              this.singlequestion.active = 1
                              this.singlequestion.questionmarkup = que.question
                              this.singlequestion.correctoption = que.answer
                              this.singlequestion.answermarkup = que.option1 + "," + que.option2 + "," + que.option3 + "," + que.option4
                              this.singleconcept.creatat = new Date();
                              this.singlequestion.diffculty = que.difficulty
                            this.userservice.addquestionfromconceptid("addquestion",this.singlequestion).subscribe(
                              (response)=>{
                                this.spinnerstatus = true
                                 this.route.navigate(['/uploadcourse'])
                              },(error)=>{}
                            )

                          })
                        },(error)=>{}
                      )
                  })
                },(error)=>{}
              ) 
          })
        },(error)=>{}
      )
  }
  
  coursetocreate : any = new Course()
  addcourse : any = new Course();
  singletopic : any = new topic();
  addtopic : any = new topic();
  conceptstoadd : any = new Concept();
  singleconcept : any = new Concept();
  singlequestion : any = new question();

  
  removeTopic(topicIndex: number) {
    this.topic.removeAt(topicIndex)
  }

  removeConcept(topicIndex: number, conceptIndex: number) {
    this.getconcept(topicIndex).removeAt(conceptIndex)
  }

  removeQuestion(topicIndex: number, conceptIndex: number, questionIndex: number) {
    this.getquestionbyindex(topicIndex,conceptIndex).removeAt(questionIndex)
  }

   ngOnInit(): void {
     
   }
}
