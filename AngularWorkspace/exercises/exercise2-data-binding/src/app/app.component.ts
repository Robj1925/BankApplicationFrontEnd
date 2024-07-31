import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Exercise2DataBindingComponent } from './components/exercise2-data-binding/exercise2-data-binding.component';
import { Exercise31EventBindingComponent } from './components/exercise3-1-event-binding/exercise3-1-event-binding.component';
import { FormsModule } from '@angular/forms';
import { UpperCasePipe } from '@angular/common';
import { EmployeeComponent } from "./components/employee/employee.component";
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, Exercise2DataBindingComponent, Exercise31EventBindingComponent, FormsModule, UpperCasePipe, EmployeeComponent], 
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'exercise2-data-binding';
}
