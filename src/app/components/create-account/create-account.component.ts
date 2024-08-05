import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent {
  accountType: string = 'savings';
  http: HttpClient = inject(HttpClient);
  router: Router = inject(Router);

  onAccountTypeChange(event: Event) {
    const selectElement = event.target as HTMLSelectElement;
    this.accountType = selectElement.value;
  }

  onCreateAccount(account: { balance: number; accountType: string; customerId: number; interestRate?: number; nextCheckNumber?: number }) {
    this.http.post('http://localhost:8084/accounts', account).subscribe((res) => {
      console.table(res);
      alert('Account created successfully!');
      this.router.navigate(['/home']);
    });
  }
}
