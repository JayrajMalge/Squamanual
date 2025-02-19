import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CourseBoxComponent } from './course-box/course-box.component';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CarsoulImgesComponent } from './carsoul-imges/carsoul-imges.component';
import { HeaderComponent } from './header/header.component';
import { AdvBoxComponent } from './adv-box/adv-box.component';
import { FooterComponent } from './footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { ReviewBoxComponent } from './review-box/review-box.component';
import { FaqComponent } from './faq/faq.component';
import { UserService } from './user.service';
import { Course, User ,Review, Wishcourse } from './entities';
import { FullScreenCourseComponent } from './full-screen-course/full-screen-course.component';
import { LoginComponent } from './login/login.component';
import { Router } from '@angular/router';
import { MainPageComponent } from './main-page/main-page.component';
import { ReactiveFormsModule } from '@angular/forms';


@Component({
  selector: 'app-root',
  standalone: true,
  imports : [MainPageComponent,RouterOutlet,CourseBoxComponent,CarsoulImgesComponent,HeaderComponent,AdvBoxComponent,FooterComponent,ReviewBoxComponent,FormsModule,CommonModule,HttpClientModule,FaqComponent,FullScreenCourseComponent,LoginComponent,ReactiveFormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {

  users$: Promise<User[]>|null=null;
  trendingcourse : Course[] = []
  reviews : Review[] = []
  wishlistcourses : Wishcourse[] = []  

  useremail : string = ''
  constructor(private userservice:UserService,private router : Router)
  {}

  ngOnInit(): void {
    //this.users$=this.userService.getAllUsers();

    /*this.userService.register({
      userid: null,
      username: 'xyz1',
      passwordhash: 'pqr',
      active: 1
    }).then(console.log);*/
  }

  getuseremail(){
    return this.useremail
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
