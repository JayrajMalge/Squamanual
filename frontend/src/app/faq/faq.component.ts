import { Component, Input, OnInit } from '@angular/core';
import { Faquestion } from '../entities';
import { CommonModule } from '@angular/common';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatAccordion } from '@angular/material/expansion';
import { MatExpansionPanelHeader } from '@angular/material/expansion';
import { FormsModule } from '@angular/forms';
import { UserService } from '../user.service';


@Component({
  selector: 'app-faq',
  standalone: true,
  imports: [CommonModule,FormsModule,MatExpansionModule],
  templateUrl: './faq.component.html',
  styleUrl: './faq.component.css'
})
export class FaqComponent implements OnInit{
   
  constructor(private userservice : UserService){}
  faqs : Faquestion[] = []
  ngOnInit(): void {
    this.userservice.getfaqs().subscribe(
      (response)=>{
            this.faqs = response
      },(error)=>{
          console.log(error)
      }
  )
  }

  toggleAnswer(index: number): void {
    this.faqs[index].isopen = !this.faqs[index].isopen;
    
  }
}
