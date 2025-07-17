import { CommonModule } from '@angular/common';
import { Component, OnInit,Inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { LoginComponent } from "../login/login.component";



@Component({
  selector: 'app-header',
  standalone: true,
  imports: [FormsModule, CommonModule, LoginComponent],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit{
  isMenuOpen = false;

  constructor(private router : Router,public userservice : UserService,@Inject(PLATFORM_ID) private platformId: Object){} 
  toggleMenu() {
    this.isMenuOpen = !this.isMenuOpen;
  }

  loginStatus : boolean = false;
  ngOnInit(): void {
    if (isPlatformBrowser(this.platformId)) {
      const email = window.localStorage.getItem("elearning")??''
      if(email.length > 0 && email!=''){
        this.loginStatus = true
      }
    }
    this.router.events.subscribe(() => {
      this.checklogging ();
    });
  }
  checklogging(){
  }   
  sign_in(){ 
    this.router.navigate(['/login'])
  }

  selectfromcategory(category : number){
    this.router.navigate(['category/'+category])
  }

  isOpen = false;
  selectedOption: string | null = null;
  options = ['Option 1', 'Option 2', 'Option 3'];

  toggleDropdown() {
    this.isOpen = !this.isOpen;
  }

  selectOption(option: string) {
    this.selectedOption = option;
    this.isOpen = false;
  }

  selectSubOption(subOption: string) {
    this.selectedOption = subOption;
    this.isOpen = false;
  }
  

  isprofile: boolean = false;
  openprofiledialog() {
    this.isprofile = true;
  }
  handleprofile() {
    this.isprofile = false;
  }

  handleprofilesubmit() {
    this.isprofile = false;
  }

}
