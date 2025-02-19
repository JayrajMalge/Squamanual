import { Component ,Input} from '@angular/core';
import { Course, Wishcourse } from '../entities';

@Component({
  selector: 'app-wishcourse',
  standalone: true,
  imports: [],
  templateUrl: './wishcourse.component.html',
  styleUrl: './wishcourse.component.css'
})
export class WishcourseComponent {
  @Input() course : any = new Wishcourse()
  gotofullscreencourse(){

  }
}
