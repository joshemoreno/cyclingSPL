import { Component, inject, OnInit } from '@angular/core';
import { LoadingService } from '../../services/loading.service';

@Component({
  selector: 'app-spin',
  standalone: true,
  imports: [],
  templateUrl: './spin.component.html',
  styleUrl: './spin.component.css',
})
export class SpinComponent implements OnInit {
  isLoading = false;

  private readonly loadingService = inject(LoadingService);

  ngOnInit(): void {
    this.loadingService.loading$.subscribe((loading) => {
      this.isLoading = loading;
    });
  }
}
