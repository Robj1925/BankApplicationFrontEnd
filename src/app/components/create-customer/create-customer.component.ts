import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../../services/customer.service';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrl: './create-customer.component.css'
})
export class CreateCustomerComponent {
//  http: HttpClient = inject(HttpClient);
 // router: Router = inject(Router);
  constructor(private  http: HttpClient, private router: Router, private customerService: CustomerService) {}

  onCreateCustomer(form: any) {
    const customerForm = { //creating a form based on the form.values passed in, 
      name: form.name,
      customerType: form.customerType,
      address: {
        streetNumber: form.streetNumber,
        postalCode: form.postalCode
      }
    };
    this.customerService.post(customerForm).subscribe({
      next: (res) => { //this is for the successful response
        console.table(res);
        alert('Customer created successfully!');
        this.router.navigate(['/home']);
      },
      error: (err) => { //this is in case theres an error
        console.error('Error creating customer:', err);
      }
    });
  }

}
