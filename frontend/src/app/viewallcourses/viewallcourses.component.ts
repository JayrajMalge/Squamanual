import { Component, OnInit } from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { FooterComponent } from "../footer/footer.component";
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserService } from '../user.service';
import { Course, category, categorywithcourse } from '../entities';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { CourseBoxComponent } from "../course-box/course-box.component";

@Component({
  selector: 'app-viewallcourses',
  standalone: true,
  imports: [HeaderComponent, FooterComponent, CommonModule, FormsModule, CourseBoxComponent,MatButtonModule,MatCardModule,MatIconModule,MatInputModule,MatProgressSpinnerModule],
  templateUrl: './viewallcourses.component.html',
  styleUrl: './viewallcourses.component.css'
})
export class ViewallcoursesComponent implements OnInit{
   search : string = ''

   constructor(private userservice : UserService){}
   courses : Course[] = []
   categories : category[] = []
   catcourse : categorywithcourse[] = []

   searchcourse : Course[] = []
   ngOnInit(): void {
     this.userservice.getallcategories().subscribe(
      (response)=>{
          this.categories = response
          this.userservice.getallcourses().subscribe(
            (response)=>{
               this.courses = response
               for(let i=0;i<this.categories.length;i++){
                  const catcou : categorywithcourse = new categorywithcourse()
                  catcou.course = this.courses.filter((co)=>{return co.category.categoryid==this.categories[i].categoryid})
                  catcou.category = this.categories[i]
                  this.catcourse.push(catcou)
               }
            },(error)=>{}
           )
      },(error)=>{}
     )
   }
   
   searched : boolean = false
   searchspe(){
      if(this.search!=''){
         this.userservice.getcoursesimilartoname(this.search).subscribe(
            (response)=>{this.searchcourse = response;this.searched= true},(error)=>{}
           )
      }else{
         this.searched = false
      }
   }
}
