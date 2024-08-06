import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  post(customerForm: any): Observable<any> {
    return this.http.post('http://localhost:8084/customer', customerForm)
    .pipe(
      catchError((error) => { //catches error
        console.error('Error occurred:', error);
        alert('Failed to create customer. Please try again.'); //alert shows error
        throw error; //rethrows it to progate to subscriber
      })
    );
  }
  getCustomerById(id: number): Observable<any> {
    return this.http.get(`http://localhost:8084/customer/${id}`);
  }
  getAllCustomers(): Observable<any> {
    return  this.http.get('http://localhost:8084/customers');
  }
  updateCustomer(updatedCustomer: any): Observable<any> {
    return this.http.put(`http://localhost:8084/customer/${updatedCustomer.customerId}`, updatedCustomer);
  }
}
