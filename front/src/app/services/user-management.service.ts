import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { catchError, lastValueFrom } from 'rxjs';
import { User } from '../types/User';

@Injectable({
  providedIn: 'root'
})
export class UserManagementService {
  readonly httpClient = inject(HttpClient);

  users = signal<User[] | null>(null);

  async search() {
    await lastValueFrom(
      this.httpClient
        .get<User[]>(`/listar`)
        .pipe(
          catchError((error) => {
            throw error;
          }),
        ),
    ).then(async (res) => {
      this.users.set(res);
    });
  }

  async create(data: unknown) {
    await lastValueFrom(
      this.httpClient
        .post<{
          result: unknown;
        }>(`/crear`, data)
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
        }>(`/editar/${data.id}`, data)
        .pipe(
          catchError((error) => {
            throw error;
          }),
        ),
    );
  }



}
