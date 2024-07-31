import { Component } from '@angular/core';
import { Employee } from './Employee';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-employee',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent {
  employee1: Employee = new Employee("Rob J", 17);
  employee2: Employee = new Employee("Kevin Q", 20);
  employee3: Employee = new Employee("Sean B", 18);
  ageIsShown: boolean = false;

  employees: Employee[] = [this.employee1, this.employee2, this.employee3];
  toggleAge() {
    this.ageIsShown = !this.ageIsShown;
    console.log(this.ageIsShown)
  }

}
console.log();

