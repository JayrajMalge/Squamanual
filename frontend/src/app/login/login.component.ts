import { CommonModule } from '@angular/common';
import { Component, OnInit ,EventEmitter,Input,Output} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { User } from '../entities';
import { WebClientService } from '../web-client.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{
  constructor(private webclinet : WebClientService,private users : UserService,private router : Router){}

  @Input() isOpen: boolean = true;
  @Output() close = new EventEmitter<void>();
  @Output() formSubmit = new EventEmitter<string>();
  
  closeDialog(){
    this.isOpen = false;
    this.close.emit();
  }
  ngOnInit(): void {
    (window as any).handleCredentialResponse = (response: any) => {
      this.handleGoogleSignIn(response);
    };
  }
  
handleGoogleSignIn(response: any): void {
  try {
    if (!response?.credential) {
      throw new Error('No credential found in response');
    }

    const decodedToken = this.parseJwt(response.credential);
    
    if (!decodedToken?.email) {
      throw new Error('Invalid token - missing email');
    }

    console.log('Decoded Token:', decodedToken);

    const user: User = new User();
    user.email = decodedToken.email
    user.createat = new Date()
    user.active = 1
    user.role = "User"
    user.name = decodedToken.name
    user.username = decodedToken.given_name
    this.users.createuser(user).subscribe(
      (response)=>{
          this.router.navigate(['/'])
          window.localStorage.setItem("elearning",decodedToken.email)
          console.log(response)
        },(error)=>{console.log(error)}
    )
  } catch (error) {}
}

private parseJwt(token: string): any {
  try {
    const base64Url = token.split('.')[1];
    if (!base64Url) throw new Error('Invalid token format');
    
    const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    const jsonPayload = decodeURIComponent(
      atob(base64)
        .split('')
        .map(c => '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2))
        .join('')
    );
    
    return JSON.parse(jsonPayload);
  } catch (error) {
    console.error('Error parsing JWT:', error);
    throw error; // Re-throw to be caught in the calling function
  }
}
  
}