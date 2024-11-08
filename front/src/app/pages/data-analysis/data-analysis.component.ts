import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { BaseChartDirective } from 'ng2-charts';
import { Chart, PieController, BarController, LineController, RadarController, BubbleController, ScatterController, PolarAreaController, DoughnutController, ArcElement, BarElement, PointElement, LineElement, CategoryScale, LinearScale, RadialLinearScale, Tooltip, Legend, ChartType, ChartData } from 'chart.js';

// Registra los controladores y elementos necesarios para los gráficos
Chart.register(PieController, BarController, LineController, RadarController, BubbleController, ScatterController, PolarAreaController, DoughnutController, ArcElement, BarElement, PointElement, LineElement, CategoryScale, LinearScale, RadialLinearScale, Tooltip, Legend);

@Component({
  selector: 'app-data-analysis',
  standalone: true,
  imports: [FormsModule, CommonModule, BaseChartDirective],
  templateUrl: './data-analysis.component.html',
  styleUrl: './data-analysis.component.css'
})
export class DataAnalysisComponent {
  chartOptions: any = {
    responsive: true,
    plugins: {
      legend: {
        position: 'top',
      },
    }
  };

  // Gráficos con datos numéricos para representar métricas relevantes
  pieChartType: ChartType = 'pie';
  ticketsStatusData: ChartData<'pie', number[], unknown> = {
    labels: ['Abierto', 'En Proceso', 'Cerrado'],
    datasets: [{ data: [40, 30, 20], backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56'] }]
  };

  barChartType: ChartType = 'bar';
  bicycleTypeData: ChartData<'bar', number[], unknown> = {
    labels: ['Montaña', 'Ruta', 'Urbana', 'BMX'],
    datasets: [{ label: 'Tickets por Tipo de Bicicleta', data: [15, 20, 25, 10], backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56', '#4BC0C0'] }]
  };

  lineChartType: ChartType = 'line';
  lineChartData: ChartData<'line', number[], unknown> = {
    labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio'],
    datasets: [{ label: 'Eventos Registrados Mensualmente', data: [5, 10, 8, 15, 20, 18], borderColor: '#42A5F5', fill: false }]
  };

  areaChartType: ChartType = 'line';
  areaChartData: ChartData<'line', number[], unknown> = {
    labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio'],
    datasets: [{ label: 'Usuarios Activos Mensualmente', data: [60, 75, 90, 120, 140, 160], backgroundColor: 'rgba(66, 165, 245, 0.5)', borderColor: '#42A5F5', fill: true }]
  };

  radarChartType: ChartType = 'radar';
  radarChartData: ChartData<'radar', number[], unknown> = {
    labels: ['Soporte', 'Eventos', 'Usuarios', 'Tickets'],
    datasets: [
      { label: 'Nivel de Actividad', data: [80, 70, 90, 60], backgroundColor: 'rgba(179, 181, 198, 0.2)', borderColor: 'rgba(179, 181, 198, 1)' },
      { label: 'Capacidad', data: [100, 80, 120, 70], backgroundColor: 'rgba(255, 99, 132, 0.2)', borderColor: 'rgba(255, 99, 132, 1)' }
    ]
  };

  polarChartType: ChartType = 'polarArea';
  polarChartData: ChartData<'polarArea', number[], unknown> = {
    labels: ['Soporte', 'Eventos', 'Usuarios'],
    datasets: [{ data: [60, 40, 80], backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56'] }]
  };

  doughnutChartType: ChartType = 'doughnut';
  doughnutChartData: ChartData<'doughnut', number[], unknown> = {
    labels: ['Plan Básico', 'Plan Estándar', 'Plan Premium'],
    datasets: [{ data: [50, 30, 20], backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56'] }]
  };

  // Gráficos complejos: métricas de soporte por tiempo de resolución y tipo de ticket
  bubbleChartType: ChartType = 'bubble';
  bubbleChartData: ChartData<'bubble'> = {
    datasets: [
      {
        label: 'Tiempo de Resolución de Tickets',
        data: [{ x: 10, y: 5, r: 15 }, { x: 20, y: 10, r: 10 }, { x: 30, y: 15, r: 25 }],
        backgroundColor: '#FF6384'
      }
    ]
  };

  scatterChartType: ChartType = 'scatter';
  scatterChartData: ChartData<'scatter'> = {
    datasets: [
      {
        label: 'Relación entre Número de Eventos y Usuarios',
        data: [{ x: 5, y: 60 }, { x: 10, y: 75 }, { x: 15, y: 90 }, { x: 20, y: 120 }, { x: 25, y: 140 }],
        backgroundColor: '#36A2EB'
      }
    ]
  };

  // Arrays separados para gráficos simples y complejos
  simpleCharts = [
    { title: 'Tickets por Estado', data: this.ticketsStatusData, type: this.pieChartType },
    { title: 'Tickets por Tipo de Bicicleta', data: this.bicycleTypeData, type: this.barChartType },
    { title: 'Eventos Registrados Mensualmente', data: this.lineChartData, type: this.lineChartType },
    { title: 'Usuarios Activos Mensualmente', data: this.areaChartData, type: this.areaChartType },
    { title: 'Actividad en Módulos', data: this.radarChartData, type: this.radarChartType },
    { title: 'Distribución por Módulo', data: this.polarChartData, type: this.polarChartType },
    { title: 'Distribución por Plan', data: this.doughnutChartData, type: this.doughnutChartType }
  ];

  complexCharts = [
    { title: 'Tiempo de Resolución de Tickets', data: this.bubbleChartData, type: this.bubbleChartType },
    { title: 'Eventos vs Usuarios', data: this.scatterChartData, type: this.scatterChartType }
  ];
}
