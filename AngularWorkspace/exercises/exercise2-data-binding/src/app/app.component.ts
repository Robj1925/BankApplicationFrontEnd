import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Exercise2DataBindingComponent } from './components/exercise2-data-binding/exercise2-data-binding.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, Exercise2DataBindingComponent], 
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'exercise2-data-binding';
}
