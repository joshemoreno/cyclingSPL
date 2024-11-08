import { Component } from '@angular/core';

interface User {
  id: number;
  name: string;
  email: string;
  role: string;
}

@Component({
  selector: 'app-user-management',
  standalone: true,
  imports: [],
  templateUrl: './user-management.component.html',
  styleUrl: './user-management.component.css'
})
export class UserManagementComponent {
  users: User[] = [
    { id: 1, name: 'Juan Pérez', email: 'juan@example.com', role: 'admin'  },
    { id: 2, name: 'María Gómez', email: 'maria@example.com', role: 'editor'  },
  ];

  openAddUser() {
    const newUser: User = {
      id: this.users.length + 1,
      name: prompt("Ingrese el nombre del usuario") || "Nuevo Usuario",
      email: prompt("Ingrese el email del usuario") || "correo@example.com",
      role: prompt("Ingrese el rol del usuario (admin, editor, viewer)") || "viewer"
    };
    this.users.push(newUser);
  }

  openEditUser(user: User) {
    const updatedName = prompt("Actualizar nombre del usuario", user.name);
    const updatedEmail = prompt("Actualizar email del usuario", user.email);
    const updatedRole = prompt("Actualizar rol del usuario (admin, editor, viewer)", user.role);
    if (updatedName && updatedEmail && updatedRole) {
      user.name = updatedName;
      user.email = updatedEmail;
      user.role = updatedRole;
    }
  }

  deleteUser(id: number) {
    this.users = this.users.filter(user => user.id !== id);
  }
}
