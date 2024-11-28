import { Component, inject, OnInit } from '@angular/core';
import { UserManagementService } from '../../services/user-management.service';
import { User } from '../../types/User';

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

  openAddUser() {
    const newUser: User = {
      id: this.users.length + 1,
      nombre: prompt("Ingrese el nombre del usuario") || "Nuevo Usuario",
      email: prompt("Ingrese el email del usuario") || "correo@example.com",
      plan: prompt("Ingrese el rol del usuario (admin, editor, viewer)") || "viewer"
    };
    // this.users.push(newUser);
  }

  openEditUser(user: User) {
    const updatedName = prompt("Actualizar nombre del usuario", user.nombre);
    const updatedEmail = prompt("Actualizar email del usuario", user.email);
    const updatedRole = prompt("Actualizar rol del usuario (admin, editor, viewer)", user.plan);
    if (updatedName && updatedEmail && updatedRole) {
      user.nombre = updatedName;
      user.email = updatedEmail;
      user.plan = updatedRole;
    }
  }

  deleteUser(id: number) {
    console.log(id);
    
    // this.users = this.users.filter(user => user.id !== id);
  }
}
