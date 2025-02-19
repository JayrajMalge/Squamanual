import { Component,Input } from '@angular/core';
import { Review } from '../entities';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card'; 
import { MatChipsModule } from '@angular/material/chips'
import { trigger, state, style, transition, animate } from '@angular/animations';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-review-box',
  standalone: true,
  imports: [MatCardModule,MatChipsModule,CommonModule,FormsModule],
  templateUrl: './review-box.component.html',
  styleUrl: './review-box.component.css',
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
export class ReviewBoxComponent {
  @Input() review : Review = new Review()
  hoverState = 'normal';

  onHover() {
    this.hoverState = 'hovered';
  }

  onLeave() {
    this.hoverState = 'normal';
  }
}
