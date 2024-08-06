import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http: HttpClient) { }
  post(account: { balance: number; accountType: string; customerId: number; interestRate?: number; nextCheckNumber?: number }) {
    this.http.post('http://localhost:8084/accounts', account).subscribe((res) => {
      console.table(res);
      alert('Account created successfully!');
     // this.router.navigate(['/home']);
    });
  }
}
