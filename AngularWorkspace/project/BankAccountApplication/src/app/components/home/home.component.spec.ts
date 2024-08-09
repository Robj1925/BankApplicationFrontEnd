import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MatDialog } from '@angular/material/dialog';
import { of, throwError } from 'rxjs';
import { CustomerService } from '../../services/customer.service';
import { HomeComponent } from './home.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';


describe('HomeComponent', () => {
  let component: HomeComponent;
  let fixture: ComponentFixture<HomeComponent>;
  let customerService: jasmine.SpyObj<CustomerService>;
  let matDialog: jasmine.SpyObj<MatDialog>;

  beforeEach(async () => {
    const customerServiceSpy = jasmine.createSpyObj('CustomerService', ['getAllCustomers', 'updateCustomer', 'deleteCustomer']);
    const matDialogSpy = jasmine.createSpyObj('MatDialog', ['open']);

    await TestBed.configureTestingModule({
      declarations: [HomeComponent],
      providers: [
        { provide: CustomerService, useValue: customerServiceSpy },
        { provide: MatDialog, useValue: matDialogSpy },
      ]
    }).compileComponents();

     fixture = TestBed.createComponent(HomeComponent);
     component = fixture.componentInstance;
     customerService = TestBed.inject(CustomerService) as jasmine.SpyObj<CustomerService>;
     matDialog = TestBed.inject(MatDialog) as jasmine.SpyObj<MatDialog>;

   // fixture.detectChanges();
  });

  fit('should create', () => {
    expect(component).toBeTruthy();
  });

  fit('should display customers on initialization', () => {
    const mockCustomers = [{ id: 1, name: 'John Doe', address: {}, accounts: [] }];
    customerService.getAllCustomers.and.returnValue(of(mockCustomers));

    component.ngOnInit();

    expect(customerService.getAllCustomers).toHaveBeenCalled();
    expect(component.dataSource.length).toEqual(mockCustomers.length);
  });

  fit('should handle error when displaying customers', () => {
    const consoleSpy = spyOn(console, 'error');
    customerService.getAllCustomers.and.returnValue(throwError(() => new Error('error')));
  
    component.displayCustomers();
  
    expect(consoleSpy).toHaveBeenCalledWith('Error displaying customers: ', new Error('error'));
  });
  

  fit('should open the update dialog and update the customer if confirmed', () => {
    const mockCustomer = { customerId: 1, name: 'John Doe', address: {} };
    const dialogRefSpyObj = jasmine.createSpyObj({ afterClosed: of(mockCustomer) });
    
    matDialog.open.and.returnValue(dialogRefSpyObj);
    
    customerService.updateCustomer.and.returnValue(of(mockCustomer));
    
    customerService.getAllCustomers.and.returnValue(of([]));
    //Actual
    component.openUpdateDialog(mockCustomer);
  
    // Expectations
    expect(matDialog.open).toHaveBeenCalled();
    expect(customerService.updateCustomer).toHaveBeenCalledWith(mockCustomer);
  });
  

  fit('should not update the customer if dialog is closed without confirmation', () => {
    const mockCustomer = { customerId: 1, name: 'John Doe', address: {} };
    const dialogRefSpyObj = jasmine.createSpyObj({ afterClosed: of(null) });
    matDialog.open.and.returnValue(dialogRefSpyObj);

    component.openUpdateDialog(mockCustomer);

    expect(matDialog.open).toHaveBeenCalled();
    expect(customerService.updateCustomer).not.toHaveBeenCalled();
  });

  fit('should delete customer and refresh the list', () => {
    const mockCustomer = { customerId: 1, name: 'John Doe', address: {} };
    const displayCustomersSpy = spyOn(component, 'displayCustomers');
    customerService.deleteCustomer.and.returnValue(of({}));

    component.deleteCustomer(mockCustomer);

    expect(customerService.deleteCustomer).toHaveBeenCalledWith(mockCustomer);
    expect(displayCustomersSpy).toHaveBeenCalled();
  });
});
