import { CommonModule } from '@angular/common';
import { Component, OnInit,Inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { FooterComponent } from '../footer/footer.component';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { User } from '../entities';
import { ErrorBoxComponent } from "../error-box/error-box.component";
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, FooterComponent, ErrorBoxComponent,HeaderComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{
  selectedTab : string = 'User';
  selectTab(usertype : string){
    this.selectedTab = usertype
  }

  constructor(private userservice : UserService,private router : Router,@Inject(PLATFORM_ID) private platformId: Object){}
  username : string = '';
  password : string = '';
  user : any = new User()

  forgetpass : boolean = false

  ngOnInit(): void {
    if (isPlatformBrowser(this.platformId)) {
      (window as any).handleCredentialResponse = (response: any) => {
        this.handleGoogleSignIn(response);
      };
    }
  }
  

  userlogin(){
    if(this.username!='' && this.password!=''){
        this.userservice.usermanuallogin(this.username,this.password).subscribe(
          (response)=>{
            if(response==null){
              this.errormessage = 'Incorrect Password' ;
              this.openDialog()
            } else{
              this.user = response;
              window.localStorage.setItem("elearning",this.user.email);
              this.router.navigate(['/main'])
            }
          },(error)=>{

          }
        )
     }else{
      alert("Invalid account")
     }
  }

  error = {
    errormessage : '',
    status : false
  }

  forgetpassword(){
    this.forgetpass = true
  }

  otpsendstatus : boolean = true
  succesotp : boolean = false
  sendotp(){
      this.otpsendstatus = false
      this.userservice.sendotp(this.username).subscribe(
        (response)=>{if(!response){this.errormessage = 'You Have not registered Yet' ;this.openDialog()}
        this.succesotp = true;this.otpsendstatus=false;this.forgetpass=false
      },(error)=>{}
      )
  }

  otp : string = '';

  newdetail : boolean = false
  verifyotp(){
      this.otpsendstatus = false
      this.userservice.verifyotp(this.username,this.otp).subscribe(
        (response)=>{if(this.olduser==null){this.errormessage = 'Invaild OTP' ;this.openDialog()}
        this.olduser = response;console.log(this.olduser);this.otpsendstatus = false;this.succesotp=false;this.newdetail=true
      },(error)=>{this.errormessage = 'Invaild OTP' ;this.openDialog()}
      )
  }

  newuser : User = new User()
  olduser : any = new User()

  passwordhashed : string = '';
  updateuser(){
    this.newuser.active = 1
    this.newuser.email = this.username
    this.newuser.name = this.username.split("@")[0]
    this.newuser.role = this.olduser.role
    this.newuser.createat = new Date()
    this.newuser.updateat = new Date()
    this.newuser.username = this.olduser.username
    this.newuser.passwordhashsalted = this.passwordhashed
    this.newuser.userid = this.olduser.userid
    this.userservice.setnewpassword(this.newuser).subscribe(
      (response)=>{this.newdetail = false,this.forgetpass = false;this.succesotp = false},(error)=>{this.errormessage = 'Failed to Set new Password'}
    )
  }

  registerform(){
    this.registerstatus = true
  }
  registerstatus : boolean = false
  confirmpassword : string = ''
  register(){
    if(this.password==this.confirmpassword)
    {
      if(this.username!='' && this.password!=''){
        this.userservice.usermanuallogin(this.username,this.password).subscribe(
          (response)=>{
            if(response==null){
              this.errormessage = 'Incorrect Password' ;
              this.openDialog()
            } else{
              this.user = response;
              window.localStorage.setItem("elearning",this.user.email);
              this.router.navigate(['/main'])
            }
          },(error)=>{

          }
        )
     }else{
      alert("Invalid account")
     }
    }else{
      this.errormessage = "Password not Matches with Confirm password"
      this.openDialog()
    }
  } 

  handleGoogleSignIn(response: any) {
    const decodedToken = this.parseJwt(response.credential);
    console.log('Decoded Token:', decodedToken);
    let user : User = new User()
    user.email = decodedToken.email
    user.role = 'User'
    user.updateat = new Date()
    user.createat = new Date()
    user.username = decodedToken.email
    this.userservice.googleauthlogin(user).subscribe(
      (response)=>{
        if (isPlatformBrowser(this.platformId)) {
          window.localStorage.setItem("elearning",decodedToken.email)
         this.router.navigate(["/main"])
        }
        },(error)=>{}
    )
  }

  parseJwt(token: string) {
    const base64Url = token.split('.')[1];
    const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    const jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
      return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));
    return JSON.parse(jsonPayload);
  }

  isDialogOpen: boolean = false;
  errormessage : string = ''
  openDialog() {
    this.isDialogOpen = true;
  }

  handleConfirm() {
    console.log('Confirmed!');
    this.isDialogOpen = false;
  }

  handleClose() {
    console.log('Dialog closed');
    this.isDialogOpen = false;
  }

}
