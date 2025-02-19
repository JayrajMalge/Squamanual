import { Component } from '@angular/core';
import { trigger, state, style, transition, animate } from '@angular/animations';


@Component({
  selector: 'app-adv-box',
  standalone: true,
  imports: [],
  templateUrl: './adv-box.component.html',
  styleUrls: ['./adv-box.component.css'],
})
export class AdvBoxComponent{
  
}
/*
ngOnInit() {
    this.playConfettiAnimation()
  }

  playConfettiAnimation() {
    this.ngzone.runOutsideAngular(()=>{
      const container = this.el.nativeElement.querySelector('.animation');
      const animation = lottie.loadAnimation({
        container: container,
        renderer: 'svg',
        loop: true,
        autoplay: true,
        path: 'assets/login.json'
      });
    })
  }*/