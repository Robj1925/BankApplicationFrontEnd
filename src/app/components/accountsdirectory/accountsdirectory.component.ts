import { Component, OnInit } from '@angular/core';
import { AccountService } from '../../services/account.service';

@Component({
  selector: 'app-accountsdirectory',
  templateUrl: './accountsdirectory.component.html',
  styleUrls: ['./accountsdirectory.component.css']
})
export class AccountsdirectoryComponent implements OnInit {
  displayedColumns: string[] = ['id', 'balance', 'customerName'];
  dataSource: any[] = [];

  constructor(private accountService: AccountService) {}

  ngOnInit(): void {
    this.loadAccounts();
  }

  loadAccounts(): void {
    this.accountService.getAllAccounts().subscribe({
      next: (accounts) => {
        this.dataSource = accounts.map((account: any) => ({
          id: account.id,
          balance: account.balance,
          customerName: account.customer?.name || 'Unknown'
        }));
      },
      error: (err) => {
        console.error('Error fetching accounts:', err);
      }
    });
  }
}
