import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../../services/customer.service';
import { AccountService } from '../../services/account.service';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent {
  accountType: string = 'savings';
//  http: HttpClient = inject(HttpClient);
//  router: Router = inject(Router);

  constructor(private accountService: AccountService, private router: Router ) {
  }
  onAccountTypeChange(event: Event) {
    const selectElement = event.target as HTMLSelectElement;
    this.accountType = selectElement.value;
  }

  onCreateAccount(account: { balance: number; accountType: string; customerId: number; interestRate?: number; nextCheckNumber?: number }) {
    this.accountService.post(account).subscribe({
      next: (account) => {
        console.table(account);
        this.router.navigate(['/view-all-accounts']);

      },
      error: (err) => {
        console.error('Error creating account:', err);
      }
    });
  // this.router.navigate(['/home']);

  }
}
