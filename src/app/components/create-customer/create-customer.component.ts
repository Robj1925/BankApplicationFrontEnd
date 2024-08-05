import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrl: './create-customer.component.css'
})
export class CreateCustomerComponent {
  http: HttpClient = inject(HttpClient);
  router: Router = inject(Router);
  onCreateCustomer(form: any) {
    const customerForm = {
      name: form.name,
      customerType: form.customerType,
      address: {
        streetNumber: form.streetNumber,
        postalCode: form.postalCode
      }
    };
    this.http.post('http://localhost:8084/customer', customerForm).subscribe((res) => {
      console.table(res);
      alert('Customer created successfully!');
      this.router.navigate(['/home']);
    });  }

}
