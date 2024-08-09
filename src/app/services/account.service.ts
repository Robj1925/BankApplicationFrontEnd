import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http: HttpClient) { }

  post(account: { balance: number; accountType: string; customerId: number; interestRate?: number; nextCheckNumber?: number }): Observable<any> {
    return this.http.post('http://localhost:8084/accounts', account)
      .pipe(
        catchError((error) => {
          console.error("Error occurred: ", error);
          alert("Could create customer account. Please try again!");
          return error;
        })
      );
  }
  getAllAccounts(): Observable<any> {
    return this.http.get('http://localhost:8084/accounts')
      .pipe(
        catchError((error) => {
          console.error("Error occurred: ", error);
          alert("Could not retrieve accounts!");
          return error; 
        })
      );
  }
}
