import { Component, inject, OnInit } from '@angular/core';
import { UserManagementService } from '../../services/user-management.service';
import { User } from '../../types/User';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-user-management',
  standalone: true,
  imports: [],
  templateUrl: './user-management.component.html',
  styleUrl: './user-management.component.css'
})
export class UserManagementComponent implements OnInit {
  readonly userService = inject(UserManagementService);

  readonly users = this.userService.users;

  async ngOnInit(): Promise<void> {
    await this.userService.search();    
  }

  async openAddUser() {
    const newUser: User = {
      nombre: prompt("Ingrese el nombre del usuario") || "Nuevo Usuario",
      email: prompt("Ingrese el email del usuario") || "correo@example.com",
      plan: prompt("Ingrese el plan del usuario (BASIC, STANDARD, PREMIUM)") || "BASIC",
      password: environment.passDefault
    };
    await this.userService.create(newUser);
    await this.userService.search();
  }

  async openEditUser(user: User) {
    const updatedName = prompt("Actualizar nombre del usuario", user.nombre);
    const updatedEmail = prompt("Actualizar email del usuario", user.email);
    const updatedRole = prompt("Ingrese el plan del usuario (BASIC, STANDARD, PREMIUM)", user.plan);
    if (updatedName && updatedEmail && updatedRole) {
      user.nombre = updatedName;
      user.email = updatedEmail;
      user.plan = updatedRole;
    }
    await this.userService.update(user);
    await this.userService.search();
  }

}
