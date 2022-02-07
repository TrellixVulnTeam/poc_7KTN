import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MeetUpFormComponent } from './meet-up-form.component';

describe('MeetUpFormComponent', () => {
  let component: MeetUpFormComponent;
  let fixture: ComponentFixture<MeetUpFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MeetUpFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MeetUpFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
