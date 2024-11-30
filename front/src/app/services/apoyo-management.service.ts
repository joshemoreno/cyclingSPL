import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { catchError, lastValueFrom } from 'rxjs';
import { Apoyo } from '../types/Apoyo';

@Injectable({
  providedIn: 'root'
})
export class ApoyoManagementService {
  readonly httpClient = inject(HttpClient);

  servicios = signal<Apoyo[] | null>(null);

  readonly controller = '/api/servicios-apoyo';

  async search() {
    await lastValueFrom(
      this.httpClient
        .get<Apoyo[]>(`${this.controller}/obtenerTodos`)
        .pipe(
          catchError((error) => {
            throw error;
          }),
        ),
    ).then(async (res) => {
      this.servicios.set(res);
    });
  }

  async create(data: unknown) {
    await lastValueFrom(
      this.httpClient
        .post<{
          result: unknown;
        }>(`${this.controller}`, data)
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
        }>(`${this.controller}/actualizar`, data)
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
        }>(`${this.controller}/${id}`)
        .pipe(
          catchError((error) => {
            throw error;
          }),
        ),
    );
  }



}
