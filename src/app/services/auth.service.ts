// src/app/services/auth.service.ts
import { Injectable } from '@angular/core';
import { Plans } from '../plans.config';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private userPlan = 'PREMIUM';
  private isAuthenticated = false;


  login(email: string, password: string): boolean {
    if (email === 'jose@mail.com' && password === '123123') {
      this.isAuthenticated = true;
      return true;
    }
    return false;
  }

  logout() {
    this.isAuthenticated = false;
  }

  isLoggedIn(): boolean {
    return this.isAuthenticated;
  }
  canAccess(page: string): boolean {
    return Plans[this.userPlan].includes(page);
  }

  getUserPlan(): string {
    return this.userPlan;
  }
}
