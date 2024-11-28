import { Component, inject } from '@angular/core';
import { Router, RouterLink, RouterModule } from '@angular/router';
import { AuthService } from './services/auth.service';
import { SpinComponent } from "./shared/spin/spin.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterLink, RouterModule, SpinComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
 readonly authService = inject(AuthService);
 readonly router = inject(Router);
  title = 'angular-app';

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
