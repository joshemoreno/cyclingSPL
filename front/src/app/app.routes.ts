// src/app/app.routes.ts
import { Routes } from '@angular/router';
import { UserManagementComponent } from './pages/user-management/user-management.component';
import { EventManagementComponent } from './pages/event-management/event-management.component';
import { SupportServicesComponent } from './pages/support-services/support-services.component';
import { DataAnalysisComponent } from './pages/data-analysis/data-analysis.component';
import { LoginComponent } from './pages/login/login.component';
import { AnonymusGuard } from './guards/anonymus.guard';
import { BasicGuard } from './guards/basic.guard';
import { PremiumGuard } from './guards/premium.guard';
import { StandardGuard } from './guards/standard.guard';

export const routes: Routes = [
  { path: 'login', loadComponent: () => LoginComponent, canActivate: [AnonymusGuard] },
    { path: 'user-management', loadComponent: () => UserManagementComponent, canActivate: [BasicGuard] },
    { path: 'event-management', loadComponent: () => EventManagementComponent, canActivate: [BasicGuard] },
    { path: 'support-services', loadComponent: () => SupportServicesComponent, canActivate: [StandardGuard] },
    { path: 'data-analysis', loadComponent: () => DataAnalysisComponent, canActivate: [PremiumGuard] },
    { path: '**', redirectTo: 'login' } 
  ];