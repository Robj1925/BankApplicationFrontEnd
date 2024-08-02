import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  dataSource: string[] = ['Customer1', "c2", "c3", "c4","test","hello"];

  public displayedColumns: string[] = ['id', 'name', 'address', 'accounts', 'actions'];
  

}
