import { Component ,Input, OnInit} from '@angular/core';
import { Course,topic,Concept } from '../entities';
import { UserService } from '../user.service';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { MatCard, MatCardModule } from '@angular/material/card'; 
import { MatChipsModule } from '@angular/material/chips'
import { trigger, state, style, transition, animate } from '@angular/animations';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-category-course',
  standalone: true,
  imports: [MatCardModule,MatChipsModule,MatCard,CommonModule,FormsModule],
  templateUrl: './category-course.component.html',
  styleUrl: './category-course.component.css',
  animations: [
    trigger('hoverAnimation', [
      state('normal', style({
        transform: 'scale(1)',
        boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)'
      })),
      state('hovered', style({
        transform: 'scale(1.05)',
        boxShadow: '0 8px 16px rgba(0, 0, 0, 0.2)'
      })),
      transition('normal <=> hovered', animate('200ms ease-in-out'))
    ])
  ]
})
export class CategoryCourseComponent implements OnInit{
     @Input() course : Course = new Course()
     topics : topic[] = []
     concepts : Concept[] = []
     imgid : string = ''
     imgurl : SafeResourceUrl = ''
     constructor(private userservice : UserService,private sanitizer : DomSanitizer){}
     ngOnInit(): void {
      this.userservice.gettopicfromcourse("gettopicsfromcourseid",this.course.courseid).subscribe(
        (response)=>{
          this.topics = response;
          this.userservice.getconceptsfromtopicid("conceptsfromtopicid",this.topics[0].topicid).subscribe((response)=>{
            this.concepts = response;
            this.imgid = this.concepts[0].descriptionmarkup.split("/")[4]
            this.imgid = this.imgid.split("?")[0]
            const url = `https://img.youtube.com/vi/${this.imgid}/0.jpg`
            this.imgurl = this.sanitizer.bypassSecurityTrustResourceUrl(url);
          },(error)=>{})
              
        },(error)=>{
  
        }
      )
     }

     hoverState = 'normal';

     onHover() {
       this.hoverState = 'hovered';
     }
   
     onLeave() {
       this.hoverState = 'normal';
     }
   
     getDifficultyClass(difficulty: string): string {
       return difficulty.toLowerCase();
     }
}
