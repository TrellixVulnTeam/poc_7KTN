import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ForgotPswdPageComponent } from './forgot-pswd-page.component';

describe('ForgotPswdPageComponent', () => {
  let component: ForgotPswdPageComponent;
  let fixture: ComponentFixture<ForgotPswdPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ForgotPswdPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ForgotPswdPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
