import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UppercasePipe } from '../../pipes/uppercase.pipe';
import {LoginService} from '../../services/login.service'
import { User } from '../../services/User'

@Component({
  selector: 'app-exercise3-1-event-binding',
  standalone: true,
  imports: [FormsModule, UppercasePipe],
  templateUrl: './exercise3-1-event-binding.component.html',
  styleUrl: './exercise3-1-event-binding.component.css'
})
export class Exercise31EventBindingComponent {
  private loginService: LoginService;
  constructor(loginService: LoginService) {
    this.loginService = loginService;
  }
  input = "why"
  loginOutput = ""
  login(username: string, password: string) {
    const user = new User(username, password);
    this.loginOutput = this.loginService.login(user);
    
  }
}
