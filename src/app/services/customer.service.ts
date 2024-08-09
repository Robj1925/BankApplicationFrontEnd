import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';

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
    return this.http.get(`http://localhost:8084/customer/${id}`)
      .pipe(
        catchError((error) => { 
          console.error('Error occurred:', error); // Logs the error to the console
          alert('Failed to fetch customer details. Please try again.'); 
          return error;
        })
      );
  }
  getAllCustomers(): Observable<any> {
    return  this.http.get('http://localhost:8084/customers')
      .pipe(
        catchError((error) => {
          console.error("Error occurrred: ", error);
          alert("Could not retrieve all customers information!");
          return error;
        })
      );
  }
  updateCustomer(updatedCustomer: any): Observable<any> {
    return this.http.put(`http://localhost:8084/customer/${updatedCustomer.customerId}`, updatedCustomer)
      .pipe(
        catchError((error) => {
          console.error("Error occurred: ", error);
          alert("Could not update customer!");
          return error;
        })
      );
  }
  deleteCustomer(customer: any): Observable<any> {
    return this.http.delete(`http://localhost:8084/customer/${customer.customerId}`)
  }
 }
