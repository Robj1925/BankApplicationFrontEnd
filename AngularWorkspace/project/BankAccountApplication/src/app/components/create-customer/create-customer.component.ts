import { Component } from '@angular/core';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrl: './create-customer.component.css'
})
export class CreateCustomerComponent {
  onSubmit(customerForm: any) {
    console.log(customerForm.value);
  }

}
