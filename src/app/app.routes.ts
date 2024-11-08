// src/app/app.routes.ts
import { Routes } from '@angular/router';
import { UserManagementComponent } from './pages/user-management/user-management.component';
import { EventManagementComponent } from './pages/event-management/event-management.component';
import { SupportServicesComponent } from './pages/support-services/support-services.component';
import { DataAnalysisComponent } from './pages/data-analysis/data-analysis.component';
import { AuthGuard } from './guards/auth.guard';
import { LoginComponent } from './pages/login/login.component';

export const routes: Routes = [
  { path: 'login', loadComponent: () => LoginComponent },
    { path: 'user-management', loadComponent: () => UserManagementComponent, canActivate: [AuthGuard] },
    { path: 'event-management', loadComponent: () => EventManagementComponent, canActivate: [AuthGuard] },
    { path: 'support-services', loadComponent: () => SupportServicesComponent, canActivate: [AuthGuard] },
    { path: 'data-analysis', loadComponent: () => DataAnalysisComponent, canActivate: [AuthGuard] },
    { path: '**', redirectTo: 'login' } 
  ];