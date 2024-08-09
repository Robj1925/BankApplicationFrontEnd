import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CreateCustomerComponent } from './create-customer.component';
import { Router } from '@angular/router';
import { CustomerService } from '../../services/customer.service';
import { of, throwError } from 'rxjs';
import { FormsModule } from '@angular/forms';

describe('CreateCustomerComponent', () => {
  let component: CreateCustomerComponent;
  let fixture: ComponentFixture<CreateCustomerComponent>;
  let customerService: jasmine.SpyObj<CustomerService>;
  let router: jasmine.SpyObj<Router>;

  beforeEach(async () => {
    const customerServiceSpy = jasmine.createSpyObj('CustomerService', ['post']);
    const routerSpy = jasmine.createSpyObj('Router', ['navigate']);

    await TestBed.configureTestingModule({
      declarations: [CreateCustomerComponent],
      imports: [FormsModule],
      providers: [
        { provide: CustomerService, useValue: customerServiceSpy },
        { provide: Router, useValue: routerSpy }
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(CreateCustomerComponent);
    component = fixture.componentInstance;
    customerService = TestBed.inject(CustomerService) as jasmine.SpyObj<CustomerService>;
    router = TestBed.inject(Router) as jasmine.SpyObj<Router>;
  //  fixture.detectChanges();
  });

  fit('should create', () => {
    expect(component).toBeTruthy();
  });

  fit('should not submit the form if invalid', () => {
    const form = { invalid: true, value: {} };
    component.onCreateCustomer(form);

    expect(customerService.post).not.toHaveBeenCalled();
    expect(router.navigate).not.toHaveBeenCalled();
  });

  fit('should submit the form if valid', () => {
    const form = {
      invalid: false,
      value: {
        name: 'John Doe',
        customerType: 'person',
        streetNumber: '123',
        postalCode: '12345'
      }
    };

    const mockResponse = { success: true };
    customerService.post.and.returnValue(of(mockResponse));

    component.onCreateCustomer(form);

    expect(customerService.post).toHaveBeenCalledWith({
      name: 'John Doe',
      customerType: 'person',
      address: {
        streetNumber: '123',
        postalCode: '12345'
      }
    });
    expect(router.navigate).toHaveBeenCalledWith(['/home']);
  });

  fit('should handle error when submitting the form', () => {
    const form = {
      invalid: false,
      value: {
        name: 'John Doe',
        customerType: 'person',
        streetNumber: '123',
        postalCode: '12345'
      }
    };

    const consoleSpy = spyOn(console, 'error');
    customerService.post.and.returnValue(throwError(() => new Error('error')));

    component.onCreateCustomer(form);

    expect(customerService.post).toHaveBeenCalled();
    expect(consoleSpy).toHaveBeenCalledWith('Error creating customer:', new Error('error'));
    expect(router.navigate).not.toHaveBeenCalled();
  });
});
