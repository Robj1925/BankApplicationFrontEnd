import { Component } from '@angular/core';

@Component({
  selector: 'app-accountsdirectory',
  templateUrl: './accountsdirectory.component.html',
  styleUrl: './accountsdirectory.component.css'
})
export class AccountsdirectoryComponent {
  displayedColumns: string[] = ["id", "balance", "customerName", "actions"]
  dataSource = [1, 2, 3];
}
