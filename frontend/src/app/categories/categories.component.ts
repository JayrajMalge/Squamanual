import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from '../header/header.component';
import { FooterComponent } from '../footer/footer.component';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';
import { response } from 'express';
import { error } from 'console';
import { Course ,topic,Concept } from '../entities';
import { SafeResourceUrl } from '@angular/platform-browser';
import { CategoryCourseComponent } from "../category-course/category-course.component";

@Component({
  selector: 'app-categories',
  standalone: true,
  imports: [CommonModule, FormsModule, HeaderComponent, FooterComponent, CategoryCourseComponent],
  templateUrl: './categories.component.html',
  styleUrl: './categories.component.css'
})
export class CategoriesComponent implements OnInit{
  constructor(private router : ActivatedRoute,private userservice : UserService){}
  courses : Course[] = []

  topics : topic[] = []
  concepts : Concept[] = []
  imgid : string = ''
  imgurl : SafeResourceUrl = ''

   ngOnInit(): void {
     const category = Number(this.router.snapshot.paramMap.get("categoryid"))
     console.log(category)
     this.userservice.getcategoriescoursesfromcategory(category).subscribe(
      (response)=>{
        this.courses = response
        console.log(this.courses)
      },(error)=>{
        console.log(error)
      }
     )
   } 
}
