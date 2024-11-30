import { DatePipe } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { EventManagementService } from '../../services/event-management.service';
import { Events } from '../../types/Events';

@Component({
  selector: 'app-event-management',
  standalone: true,
  imports: [DatePipe],
  templateUrl: './event-management.component.html',
  styleUrl: './event-management.component.css'
})
export class EventManagementComponent implements OnInit{

  readonly enventService = inject(EventManagementService);

  readonly events = this.enventService.events;

  async ngOnInit(): Promise<void> {
    await this.enventService.search();    
  }

  async openAddEvent() {
    const newEvent: Events = {
      id: this.events.length + 1,
      nombreDelEvento: prompt("Ingrese el nombre del evento") || "Nuevo Evento",
      fecha: new Date(prompt("Ingrese la fecha del evento (YYYY-MM-DD)") || new Date().toISOString()),
      ubicacion: prompt("Ingrese la ubicación del evento") || "Ubicación desconocida"
    };
    await this.enventService.create(newEvent);
    await this.enventService.search();
  }

  async openEditEvent(event: Events) {
    const aux = event.fecha.toString();
    const updatedName = prompt("Actualizar nombre del evento", event.nombreDelEvento);
    const updatedDate = prompt("Actualizar fecha del evento (YYYY-MM-DD)", aux.substring(0, 10));
    const updatedLocation = prompt("Actualizar ubicación del evento", event.ubicacion);
    if (updatedName && updatedDate && updatedLocation) {
      event.nombreDelEvento = updatedName;
      event.fecha = new Date(updatedDate);
      event.ubicacion = updatedLocation;
    }
    await this.enventService.create(event);
    await this.enventService.search();
  }

  async deleteEvent(id: number) {
    await this.enventService.delete(id);
    await this.enventService.search();
  }
}
