import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { catchError, lastValueFrom } from 'rxjs';
import { Events } from '../types/Events';

@Injectable({
  providedIn: 'root'
})
export class EventManagementService {
  readonly httpClient = inject(HttpClient);

  events = signal<Events[] | null>(null);

  readonly controller = '/api/eventos';

  async search() {
    await lastValueFrom(
      this.httpClient
        .get<Events[]>(`${this.controller}`)
        .pipe(
          catchError((error) => {
            throw error;
          }),
        ),
    ).then(async (res) => {
      this.events.set(res);
    });
  }

  async create(data: unknown) {
    await lastValueFrom(
      this.httpClient
        .post<{
          result: unknown;
        }>(`${this.controller}/crear`, data)
        .pipe(
          catchError((error) => {
            throw error;
          }),
        ),
    );
  }

  async update(data: any) {
    await lastValueFrom(
      this.httpClient
        .put<{
          result: unknown;
        }>(`${this.controller}/actualizar/${data.id}`, data)
        .pipe(
          catchError((error) => {
            throw error;
          }),
        ),
    );
  }

  async delete(id: number) {
    await lastValueFrom(
      this.httpClient
        .delete<{
          result: unknown;
        }>(`${this.controller}/eliminar/${id}`)
        .pipe(
          catchError((error) => {
            throw error;
          }),
        ),
    );
  }



}
