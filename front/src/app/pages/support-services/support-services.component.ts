import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';

interface Ticket {
  id: number;
  customerName: string;
  bicycleType: string;
  issueDescription: string;
  status: string; // Ejemplo: 'Abierto', 'En Proceso', 'Cerrado'
}


@Component({
  selector: 'app-support-services',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './support-services.component.html',
  styleUrl: './support-services.component.css'
})
export class SupportServicesComponent {
  tickets: Ticket[] = [
    {
      id: 1,
      customerName: 'Carlos López',
      bicycleType: 'Montaña',
      issueDescription: 'Falla en los frenos',
      status: 'Abierto'
    },
    {
      id: 2,
      customerName: 'Ana Martínez',
      bicycleType: 'Urbana',
      issueDescription: 'Cadena rota',
      status: 'En Proceso'
    }
  ];

  // Método para agregar un nuevo ticket
  openAddTicket() {
    const newTicket: Ticket = {
      id: this.tickets.length + 1,
      customerName: prompt('Ingrese el nombre del cliente') || 'Cliente desconocido',
      bicycleType: prompt('Ingrese el tipo de bicicleta') || 'Tipo desconocido',
      issueDescription: prompt('Describa el problema') || 'Sin descripción',
      status: 'Abierto'
    };
    this.tickets.push(newTicket);
  }

  // Método para editar un ticket existente
  openEditTicket(ticket: Ticket) {
    const updatedCustomerName = prompt('Actualizar nombre del cliente', ticket.customerName);
    const updatedBicycleType = prompt('Actualizar tipo de bicicleta', ticket.bicycleType);
    const updatedIssueDescription = prompt('Actualizar descripción del problema', ticket.issueDescription);
    const updatedStatus = prompt('Actualizar estado (Abierto, En Proceso, Cerrado)', ticket.status);

    if (updatedCustomerName && updatedBicycleType && updatedIssueDescription && updatedStatus) {
      ticket.customerName = updatedCustomerName;
      ticket.bicycleType = updatedBicycleType;
      ticket.issueDescription = updatedIssueDescription;
      ticket.status = updatedStatus;
    }
  }

  // Método para eliminar un ticket
  deleteTicket(id: number) {
    this.tickets = this.tickets.filter(ticket => ticket.id !== id);
  }
}
