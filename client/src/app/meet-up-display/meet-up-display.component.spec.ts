import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MeetUpDisplayComponent } from './meet-up-display.component';

describe('MeetUpDisplayComponent', () => {
  let component: MeetUpDisplayComponent;
  let fixture: ComponentFixture<MeetUpDisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MeetUpDisplayComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MeetUpDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
