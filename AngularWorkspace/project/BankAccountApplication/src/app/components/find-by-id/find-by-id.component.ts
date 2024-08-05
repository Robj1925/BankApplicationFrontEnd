import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';

@Component({
  selector: 'app-find-by-id',
  templateUrl: './find-by-id.component.html',
  styleUrl: './find-by-id.component.css'
})
export class FindByIdComponent {
  http: HttpClient = inject(HttpClient);
  retrieved: boolean = false;
  id: string = "";
  customer: any = null;

  retrieveCustomerByID() {
    this.http.get(`http://localhost:8084/customer/${this.id}`).subscribe((response: any) => {
      this.customer = response;
      console.table(response);
    });
  }
}
