import { HttpClient } from '@angular/common/http';
import { Component, inject, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CustomerService } from '../../services/customer.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  dataSource: any[] = [];
  // http: HttpClient = inject(HttpClient);
  dialog: MatDialog = inject(MatDialog);
  fb: FormBuilder = inject(FormBuilder);

  displayedColumns: string[] = ['id', 'name', 'address', 'accounts', 'actions'];

  constructor(private customerService: CustomerService) {
  }

  ngOnInit() {
    this.displayCustomers();
  }

  displayCustomers() {
    this.customerService.getAllCustomers().subscribe({
      next: (res) => { //this is for the successful response
        this.dataSource = res; //sets our table template variable to be a list of all customers
        console.table(res);
      },
      error: (err) => { //this is in case theres an error
        console.error('Error displaying customers: ', err);
      }
    });
  }

  openUpdateDialog(customer: any): void {
    const dialogRef = this.dialog.open(UpdateCustomerDialog, { //opens dialog box
      width: '400px',
      data: { customer } //this is our dialog field, we pass the customer data to the dialog
    });

    dialogRef.afterClosed().subscribe(result => {// afterClosed returns observable that emits a value, subscribe used to handle the value
      if (result) {  //if updatedcustomer is "submmited" not "cancelled"/null then we can use the updatedcus fields to update cus
        this.updateCustomer(result);
      }
    });
  }

  updateCustomer(customer: any): void {
    this.customerService.updateCustomer(customer)
      .subscribe({
        next: (res) => {
          console.table(res);
          this.displayCustomers(); // "refresh" the table after update
        },
        error: (err) => {
          console.error('Error occurred while updating customer:', err);
        }
      });
  }
  deleteCustomer(customer: any): void { //we take in a customer obj
    this.customerService.deleteCustomer(customer) //just use the customerid to delete it
      .subscribe(() =>{
        this.displayCustomers();
      });
  }
}


@Component({
  selector: 'update-customer-dialog',
  template: `
    <h1 mat-dialog-title>Update Customer</h1>
    <div mat-dialog-content>
      <form [formGroup]="updateForm">
        <div class="form-group">
          <label for="name">Customer Name</label>
          <input type="text" id="name" formControlName="name" class="form-control" readonly>
        </div>

        <div formGroupName="address">
          <div class="form-group">
            <label for="streetNumber">Street Number</label>
            <input type="text" id="streetNumber" formControlName="streetNumber" class="form-control" readonly>
          </div>

          <div class="form-group">
            <label for="postalCode">Postal Code</label>
            <input type="text" id="postalCode" formControlName="postalCode" class="form-control">
          </div>

          <div class="form-group">
            <label for="city">City</label>
            <input type="text" id="city" formControlName="city" class="form-control">
          </div>

          <div class="form-group">
            <label for="providence">Providence</label>
            <input type="text" id="providence" formControlName="providence" class="form-control">
          </div>
        </div>
      </form>
    </div>
    <div mat-dialog-actions>
      <button mat-button (click)="onNoClick()">Cancel</button>
      <button mat-button [mat-dialog-close]="updateForm.value" cdkFocusInitial>Update</button>
    </div>
  `
})
export class UpdateCustomerDialog {
  updateForm: FormGroup;

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<UpdateCustomerDialog>
  ) {
    this.updateForm = this.fb.group({
      customerId: [data.customer.customerId],
      name: [data.customer.name],
      address: this.fb.group({
        addressId: [data.customer.address.addressId],
        streetNumber: [data.customer.address.streetNumber],
        postalCode: [data.customer.address.postalCode],
        city: [data.customer.address.city],
        providence: [data.customer.address.providence],
      })
    });
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}

