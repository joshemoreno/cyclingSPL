import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  email = '';
  password = '';

  constructor(private authService: AuthService, private router: Router) {}

  async onLogin() {
    const isLoggedIn = await this.authService.login({email:this.email , password:this.password});
    console.log(isLoggedIn);
    
    if (isLoggedIn) {
      this.router.navigate(['/user-management']);
    } else {
      alert('Credenciales incorrectas. Inténtalo de nuevo.');
    }
  }
}
