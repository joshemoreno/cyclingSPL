import { HttpInterceptorFn } from '@angular/common/http';

import { inject } from '@angular/core';
import { finalize } from 'rxjs';
import { environment } from '../environments/environment';
import { LoadingService } from './services/loading.service';
import { AuthService } from './services/auth.service';

export const apiInterceptor: HttpInterceptorFn = (request, next) => {
  const authService = inject(AuthService);
  const loadingService = inject(LoadingService);
  const token = authService.getToken();
  let clonedReq = request.clone({
    url: `${environment.apiUrl}${request.url}`,
  });

  if(token){
    clonedReq = clonedReq.clone({
      setHeaders: {
        Authorization: `Bearer ${token}`,
      },
    });
  }

  return next(clonedReq).pipe(
    finalize(() => {
      loadingService.hide();
    }),
  );
};
