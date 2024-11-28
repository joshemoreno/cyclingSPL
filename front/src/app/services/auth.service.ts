// src/app/services/auth.service.ts
import { Inject, inject, Injectable, PLATFORM_ID } from '@angular/core';
import { Plans } from '../plans.config';
import { lastValueFrom } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { JwtService } from './jwt.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  readonly httpClient = inject(HttpClient);
  readonly jwtService = inject(JwtService);
  private userPlan = 'PREMIUM';
  private readonly TOKEN_KEY = 'authToken';

  async login(data: unknown): Promise<boolean> {
    try {
      const response = await lastValueFrom(
        this.httpClient.post<{ token: string }>(`/api/auth/login`, data)
      );
     
      if (response && response.token) {
        this.setToken(response.token);
        return true;
      }
      return false;
    } catch (error) {
      console.error('Error durante el login:', error);
      return false; 
    }
  }

  logout(): void {
    this.removeToken();
  }

  isLoggedIn(): boolean {
    if(this.getToken()){
      return true;
    }else{
      return false;
    }
  }
  canAccess(page: string): boolean {
    this.getUserPlan();
    return Plans[this.userPlan].includes(page);
  }

  canAccessPlan(plans: String[]): boolean {
    if(plans.includes(this.userPlan)){
      return true; 
    }
    return false;
  }

  getUserPlan() {
    const token = this.getToken();
    if (token) {
      const decoded = this.jwtService.decodeToken(token);
      this.userPlan = decoded.plan;
    }
  }

  setToken(token: string): void {
    if (typeof localStorage !== 'undefined') {
      localStorage.setItem(this.TOKEN_KEY, token);
    }
  }

  getToken(): string | null {
    if (typeof localStorage !== 'undefined') {
      return localStorage.getItem(this.TOKEN_KEY);
    }
    return null;
  }

  removeToken(): void {
    if (typeof localStorage !== 'undefined') {
      localStorage.removeItem(this.TOKEN_KEY);
    }
  }
}
