import { Component, inject } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ApoyoManagementService } from '../../services/apoyo-management.service';
import { Apoyo } from '../../types/Apoyo';

@Component({
  selector: 'app-support-services',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './support-services.component.html',
  styleUrl: './support-services.component.css'
})
export class SupportServicesComponent {

  readonly apoyoService = inject(ApoyoManagementService);

  readonly servicios = this.apoyoService.servicios;

  async ngOnInit(): Promise<void> {
    await this.apoyoService.search();    
  }

  // Método para agregar un nuevo ticket
  async openAddTicket() {
    const newTicket: Apoyo = {
      nombreDelCliente: prompt('Ingrese el nombre del cliente') || 'Cliente desconocido',
      tipoDeBicicleta: prompt('Ingrese el tipo de bicicleta') || 'Tipo desconocido',
      descripcionProblema: prompt('Describa el problema') || 'Sin descripción',
      estado: 'pendiente'
    };
    await this.apoyoService.create(newTicket);
    await this.apoyoService.search();
  }

  // Método para editar un ticket existente
  async openEditTicket(ticket: Apoyo) {
    const updatedCustomerName = prompt('Actualizar nombre del cliente', ticket.nombreDelCliente);
    const updatedBicycleType = prompt('Actualizar tipo de bicicleta', ticket.tipoDeBicicleta);
    const updatedIssueDescription = prompt('Actualizar descripción del problema', ticket.descripcionProblema);
    const updatedStatus = prompt('Actualizar estado (pendiente, en_progreso, resuelto)', ticket.estado);

    if (updatedCustomerName && updatedBicycleType && updatedIssueDescription && updatedStatus) {
      ticket.nombreDelCliente = updatedCustomerName;
      ticket.tipoDeBicicleta = updatedBicycleType;
      ticket.descripcionProblema = updatedIssueDescription;
      ticket.estado = updatedStatus;
    }
    await this.apoyoService.update(ticket);
    await this.apoyoService.search();
  }

  async deleteTicket(id: number) {
    await this.apoyoService.delete(id);
    await this.apoyoService.search();
  }
}
