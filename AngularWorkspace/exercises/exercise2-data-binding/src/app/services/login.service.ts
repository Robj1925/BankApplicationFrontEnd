import { Injectable } from '@angular/core';
import { User } from './User';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor() { }
  loginOutput = ""
  login(user: User): string {
    console.log("Login method called with", user.getUsername(), user.getPassword());
    if (user.getUsername() === "FDMUser" && user.getPassword() === "1234") {
      this.loginOutput =  "Welcome FDMUser!"
    } else {
      this.loginOutput =  "Wrong Username/Password!"
    }
    return this.loginOutput;
  }
}
