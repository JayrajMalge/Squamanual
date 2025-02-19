import { Component, Input } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-enroll-course-box',
  standalone: true,
  imports: [],
  templateUrl: './enroll-course-box.component.html',
  styleUrl: './enroll-course-box.component.css'
})
export class EnrollCourseBoxComponent {

  @Input() course : any;

  constructor(private userservice : UserService,private router : Router){}
  gotofullscreencourse(){
       this.router.navigate(['/enrolledcourse/'+this.course.courseid])
  }
}
