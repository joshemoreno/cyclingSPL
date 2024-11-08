import { DatePipe } from '@angular/common';
import { Component } from '@angular/core';

interface Event {
  id: number;
  name: string;
  date: Date;
  location: string;
}

@Component({
  selector: 'app-event-management',
  standalone: true,
  imports: [DatePipe],
  templateUrl: './event-management.component.html',
  styleUrl: './event-management.component.css'
})
export class EventManagementComponent {
  events: Event[] = [
    { id: 1, name: 'Ruta 5KM', date: new Date('2023-08-15'), location: 'Pance' },
    { id: 2, name: 'Ruta 50KM', date: new Date('2022-09-10'), location: 'Bogotá' },
  ];

  openAddEvent() {
    const newEvent: Event = {
      id: this.events.length + 1,
      name: prompt("Ingrese el nombre del evento") || "Nuevo Evento",
      date: new Date(prompt("Ingrese la fecha del evento (YYYY-MM-DD)") || new Date().toISOString()),
      location: prompt("Ingrese la ubicación del evento") || "Ubicación desconocida"
    };
    this.events.push(newEvent);
  }

  openEditEvent(event: Event) {
    const updatedName = prompt("Actualizar nombre del evento", event.name);
    const updatedDate = prompt("Actualizar fecha del evento (YYYY-MM-DD)", event.date.toISOString().substring(0, 10));
    const updatedLocation = prompt("Actualizar ubicación del evento", event.location);
    if (updatedName && updatedDate && updatedLocation) {
      event.name = updatedName;
      event.date = new Date(updatedDate);
      event.location = updatedLocation;
    }
  }

  deleteEvent(id: number) {
    this.events = this.events.filter(event => event.id !== id);
  }
}
