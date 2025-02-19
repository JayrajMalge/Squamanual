import { Component,Input, OnInit } from '@angular/core';
import { Course ,topic,Concept} from '../entities';
import { UserService } from '../user.service';
import { DomSanitizer } from '@angular/platform-browser';
import { SafeResourceUrl } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-udate-course',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './udate-course.component.html',
  styleUrl: './udate-course.component.css'
})
export class UdateCourseComponent implements OnInit{
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
}
