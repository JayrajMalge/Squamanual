import { Component, OnInit,Inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { UserService } from '../user.service';
import { Wishcourse } from '../entities';
import { WishcourseComponent } from '../wishcourse/wishcourse.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from "../header/header.component";
import { FooterComponent } from "../footer/footer.component";

@Component({
  selector: 'app-wishlist',
  standalone: true,
  imports: [WishcourseComponent, CommonModule, FormsModule, HeaderComponent, FooterComponent],
  templateUrl: './wishlist.component.html',
  styleUrl: './wishlist.component.css'
})
export class WishlistComponent implements OnInit{
  constructor(private userservice : UserService,@Inject(PLATFORM_ID) private platformId: Object
  ){}
  wishlistedcourses : Wishcourse[] = []
   ngOnInit(): void {
    if (isPlatformBrowser(this.platformId)) {
      const email = window.localStorage.getItem("elearning")??''
      this.userservice.getuserfromemail(email).subscribe(
        (response)=>{
            this.userservice.getwishlistedcourse("wishlistedcoursefromuserid",response.userid || 0).subscribe(
              (response)=>{
                this.wishlistedcourses = response;
                console.log(this.wishlistedcourses)
              },(error)=>{
                console.log(error)
              }
            )
        },(error)=>{
          console.log(error)
        }
      )
      }
   }
}

