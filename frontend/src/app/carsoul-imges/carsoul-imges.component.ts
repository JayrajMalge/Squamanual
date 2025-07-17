import { Component, OnInit ,ElementRef} from '@angular/core';
import Lottie from 'lottie-web';


@Component({
  selector: 'app-carsoul-imges',
  standalone: true,
  imports: [],
  templateUrl: './carsoul-imges.component.html',
  styleUrl: './carsoul-imges.component.css',
})
export class CarsoulImgesComponent implements OnInit{
  constructor(private el : ElementRef){}
  async ngOnInit() {
    this.playConfettiAnimation()
  }
  playConfettiAnimation() {
      /*const container = this.el.nativeElement.querySelector('.animation');
      const animation = Lottie.loadAnimation({
        container: container,
        renderer: 'svg',
        loop: true,
        autoplay: true,
        path: 'assets/desktop.json'
      });*/
  }
  
}

/*
ngOnInit() {
    this.playConfettiAnimation()
  }

  playConfettiAnimation() {
    const animation = Lottie.loadAnimation({
      container: this.el.nativeElement.querySelector('.animation'),
      renderer: 'svg',
      loop: false,
      autoplay: true,
      path: 'assets/desktop.json'
    });
  }*/