import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../../services/customer.service';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent {

  constructor(private router: Router, private customerService: CustomerService) {}

  onCreateCustomer(form: any) {
    if (form.invalid) {
      // If the form is invalid, do not submit it
      return;
    }
    
    const customerForm = {
      name: form.value.name,
      customerType: form.value.customerType,
      address: {
        streetNumber: form.value.streetNumber,
        postalCode: form.value.postalCode
      }
    };

    this.customerService.post(customerForm).subscribe({
      next: (res) => {
        console.table(res);
        alert('Customer created successfully!');
        this.router.navigate(['/home']);
      },
      error: (err) => {
        console.error('Error creating customer:', err);
        alert('Failed to create customer. Please try again.');
      }
    });
  }
}
