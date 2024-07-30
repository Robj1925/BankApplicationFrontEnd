import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Exercise2DataBindingComponent } from './exercise2-data-binding.component';

describe('Exercise2DataBindingComponent', () => {
  let component: Exercise2DataBindingComponent;
  let fixture: ComponentFixture<Exercise2DataBindingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Exercise2DataBindingComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Exercise2DataBindingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
