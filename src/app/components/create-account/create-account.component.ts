import { Component } from '@angular/core';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrl: './create-account.component.css'
})
export class CreateAccountComponent {
  accountType: string = 'savings';

  onAccountTypeChange(event: Event) {
    const selectElement = event.target as HTMLSelectElement;
    this.accountType = selectElement.value;
  }

  onSubmit() {
    console.log('Form submitted');
  }

}
