import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountsdirectoryComponent } from './accountsdirectory.component';

describe('AccountsdirectoryComponent', () => {
  let component: AccountsdirectoryComponent;
  let fixture: ComponentFixture<AccountsdirectoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AccountsdirectoryComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AccountsdirectoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
