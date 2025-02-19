import { Component, OnInit,Inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { HeaderComponent } from '../header/header.component';
import { FooterComponent } from '../footer/footer.component';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { Course, Faquestion, User } from '../entities';
import { UserService } from '../user.service';
import { FormBuilder, FormGroup, FormArray, FormControl } from '@angular/forms';
import {UdateCourseComponent} from "../udate-course/udate-course.component"

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [HeaderComponent,FooterComponent,FormsModule,CommonModule,UdateCourseComponent],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent implements OnInit{
  userName: string = '';
  userEmail: string = '';
  userrole : string = '';
  user : User = new User();

  editprofileoption : boolean = false
  newusername : string = '';
  newemail : string = '';
  userquestion : string = ''

  constructor(private route : Router,private userservice : UserService,private fb: FormBuilder,@Inject(PLATFORM_ID) private platformId: Object
  ){  }
  faqs: Faquestion[] = []

  ngOnInit(): void {
    if (isPlatformBrowser(this.platformId)) {
      const email = window.localStorage.getItem("elearning")??''
      this.userservice.getuserfromemail(email).subscribe(
        (response)=>{
          this.user = response
          this.userrole = this.user.role
          this.userservice.getfaqbyuserid(this.user.userid).subscribe(
            (response)=>{
              this.faqs = response
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

  askdout : boolean = false
  toggleFaq(faqId: number): void {
    this.faqs = this.faqs.map(faq => {
      if (faq.faquestionid === faqId) {
        faq.isopen = !faq.isopen;
      }
      return faq;
    });
  }

  askdoutsetup(){
    this.askdout = true
  }

  editProfile(): void {}

  logOut(): void {
    if(isPlatformBrowser(this.platformId)){
      window.localStorage.removeItem("elearning")
    }
    alert("your are logged out")
    this.route.navigate(['/main'])
  }

  openeditprofilesetup(){
    this.editprofileoption = true
  }

  editprofile(){
    this.user.name = this.newusername;
    this.user.email = this.newemail
    this.userservice.updateusernameandemail(this.user).subscribe(
      (response)=>{
         this.editprofileoption = false
         window.localStorage.setItem("elearning",this.user.email)
      },(error)=>{
          console.log(error)
      }
    )
  }

  addfaq(){
    const faq = new Faquestion()
    faq.question = this.userquestion
    faq.answer = ''
    faq.createat = new Date()
    faq.user = this.user.userid
    faq.updatedat = new Date()
    this.userservice.addfaquestion("addfaquestion",faq).subscribe(
      (response)=>{
        console.log(response)
      },(error)=>{
        console.log(error)
      }
    )
  }

  updatecourseoption : boolean = false;
  courses : Course[] = []
  updatecourse(){
    this.userservice.getallcourses().subscribe(
      (response)=>{
          this.courses = response
          this.updatecourseoption = true
      },(error)=>{}
    )
  }
}


/*
import { isPlatformBrowser } from '@angular/common';
,@Inject(PLATFORM_ID) private platformId: Object
if (isPlatformBrowser(this.platformId)) {
  const email = window.localStorage.getItem("elearning")??''
  if(email.length > 0 && email!=''){
    this.loginStatus = true
  }
}*/