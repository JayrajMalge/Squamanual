import { Component, OnInit,Inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { CourseBoxComponent } from '../course-box/course-box.component';
import { CarsoulImgesComponent } from '../carsoul-imges/carsoul-imges.component';
import { HeaderComponent } from '../header/header.component';
import { AdvBoxComponent } from '../adv-box/adv-box.component';
import { FooterComponent } from '../footer/footer.component';
import { ReviewBoxComponent } from '../review-box/review-box.component';
import { LoginComponent } from '../login/login.component';
import { FullScreenCourseComponent } from '../full-screen-course/full-screen-course.component';
import { FaqComponent } from '../faq/faq.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Course, Faquestion, User } from '../entities';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { Review } from '../entities';
import { trigger, state, style, transition, animate } from '@angular/animations';


@Component({
  selector: 'app-main-page',
  standalone: true,
  imports : [RouterOutlet,CourseBoxComponent,CarsoulImgesComponent,HeaderComponent,AdvBoxComponent,FooterComponent,ReviewBoxComponent,FormsModule,CommonModule,HttpClientModule,FaqComponent,FullScreenCourseComponent,LoginComponent],
  templateUrl: './main-page.component.html',
  styleUrl: './main-page.component.css',
})
export class MainPageComponent implements OnInit {


  trendingcourse : Course[] = []
  reviews : Review[] = []
  user : User = new User()
  faquestions : Faquestion[] = []

  constructor(private userservice:UserService,private router : Router,@Inject(PLATFORM_ID) private platformId: Object)
  {}

  ngOnInit(): void {
    //this.users$=this.userService.getAllUsers();

    /*this.userService.register({
      userid: null,
      username: 'xyz1',
      passwordhash: 'pqr',
      active: 1
    }).then(console.log);*/
    if (isPlatformBrowser(this.platformId)) {
      const email = window.localStorage.getItem("elearning")??''
      if (email.length > 0) {
        this.userservice.getuserfromemail(email).subscribe(
          (response) => {
            this.user = response;
            this.userservice.setUser(this.user);
          },
          (error) => {
          }
        );
      }
    }
    this.userservice.getTreadingcourse("trendingcourse",100).subscribe(
      (response)=>{
        this.trendingcourse = response;
      },(error)=>{
        console.log(error);
      }
    )
    this.userservice.getreviews("getreviews").subscribe(
      (response)=>{
        this.reviews = response;
      },(error)=>{console.log(error)})
      this.userservice.getfaqs().subscribe(
        (response)=>{
              this.faquestions = response
        },(error)=>{
        }
    )
  }
  fullScreenAllow = {
    showscreen : false,
    coursetosee : new Course()
  }
  showfullscreencourse(Course : any){
     this.fullScreenAllow.coursetosee = Course;
     this.fullScreenAllow.showscreen = true;
  }
}
