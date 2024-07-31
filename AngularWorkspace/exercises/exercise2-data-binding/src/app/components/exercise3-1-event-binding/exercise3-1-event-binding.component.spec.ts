import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Exercise31EventBindingComponent } from './exercise3-1-event-binding.component';
import { FormsModule } from '@angular/forms';
import { EmployeeComponent } from '../employee/employee.component';

describe('Exercise31EventBindingComponent', () => {
  let component: Exercise31EventBindingComponent;
  let fixture: ComponentFixture<Exercise31EventBindingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Exercise31EventBindingComponent, FormsModule, EmployeeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Exercise31EventBindingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
