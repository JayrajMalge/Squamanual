import { Component, OnInit,Inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { UserService } from '../user.service';
import { Course, User } from '../entities';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { FooterComponent } from '../footer/footer.component';
import { EnrollCourseBoxComponent } from '../enroll-course-box/enroll-course-box.component';
import { HeaderComponent } from "../header/header.component";

@Component({
  selector: 'app-mylearning',
  standalone: true,
  imports: [CommonModule, FormsModule, FooterComponent, EnrollCourseBoxComponent, HeaderComponent],
  templateUrl: './mylearning.component.html',
  styleUrl: './mylearning.component.css'
})
export class MylearningComponent implements OnInit {
  constructor(private userservice : UserService,@Inject(PLATFORM_ID) private platformId: Object){}
  usercourses : any[] = []
  usercourse : Course[] = []
  user : User = new User()
      ngOnInit(): void {
        if (isPlatformBrowser(this.platformId)) {
          const email = window.localStorage.getItem("elearning")??''
          console.log(email)
          this.userservice.getuserfromemail(email).subscribe(
          (response)=>{
             this.user = response;
             this.userservice.getusercourses("usercoursefromuserid",this.user.userid || 0).subscribe(
              (response)=>{
                this.usercourses = response
                console.log(this.usercourses)
                this.usercourses.map((course)=>{
                  this.userservice.getcoursefromcourseid(course.course.courseid).subscribe(
                    (response)=>{
                      this.usercourse.push(response)
                      console.log(this.usercourse)
                    },(error)=>{
                      console.log(error)
                    }
                  )
                })
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
}
