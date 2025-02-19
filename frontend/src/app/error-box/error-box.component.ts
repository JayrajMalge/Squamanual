import { CommonModule } from '@angular/common';
import { Component ,EventEmitter,Input,Output} from '@angular/core';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-error-box',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './error-box.component.html',
  styleUrl: './error-box.component.css'
})
export class ErrorBoxComponent {
  @Input() isOpen: boolean = false;
  @Input() conetnt : string = ''
  @Output() close = new EventEmitter<void>();
  currentImageIndex: number = 0;

  closeDialog() {
    this.isOpen = false;
    this.close.emit();
  }

}
