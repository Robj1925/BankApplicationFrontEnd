import { Component } from '@angular/core';

@Component({
  selector: 'app-exercise2-data-binding',
  standalone: true,
  imports: [],
  templateUrl: './exercise2-data-binding.component.html',
  styleUrl: './exercise2-data-binding.component.css'
})
export class Exercise2DataBindingComponent {
title: string = "Categories";
cat1: string = "Home";
cat2: string = "Electronics";
cat3: string = "Fashion";
}
