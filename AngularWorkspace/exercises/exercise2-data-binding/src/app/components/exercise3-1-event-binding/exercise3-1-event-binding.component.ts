import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UppercasePipe } from '../../pipes/uppercase.pipe';

@Component({
  selector: 'app-exercise3-1-event-binding',
  standalone: true,
  imports: [FormsModule, UppercasePipe],
  templateUrl: './exercise3-1-event-binding.component.html',
  styleUrl: './exercise3-1-event-binding.component.css'
})
export class Exercise31EventBindingComponent {
  loginOutput = ""
  login(username: string, password: string) {
    console.log("Login method called with", username, password);
    if (username === "FDMUser" && password === "1234") {
      this.loginOutput =  "Welcome FDMUser!"
    } else {
      this.loginOutput =  "Wrong Username/Password!"
    }
  }
}
