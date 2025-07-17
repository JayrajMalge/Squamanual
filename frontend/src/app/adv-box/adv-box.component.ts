import { Component, ElementRef, OnInit } from '@angular/core';
import { NgZone } from '@angular/core';
import Lottie from 'lottie-web';

@Component({
  selector: 'app-adv-box',
  standalone: true,
  imports: [],
  templateUrl: './adv-box.component.html',
  styleUrls: ['./adv-box.component.css'],
})
export class AdvBoxComponent implements OnInit{
  constructor(){}
  ngOnInit() {
  }
  /*playConfettiAnimation() {
      const container = this.el.nativeElement.querySelector('.animation');
      const animation = Lottie.loadAnimation({
        container: container,
        renderer: 'svg',
        loop: true,
        autoplay: true,
        path: 'assets/login.json'
      });
  }*/
}
/*

  }*/