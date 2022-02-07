import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LocatedMeetUpDisplayComponent } from './located-meet-up-display.component';

describe('LocatedMeetUpDisplayComponent', () => {
  let component: LocatedMeetUpDisplayComponent;
  let fixture: ComponentFixture<LocatedMeetUpDisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LocatedMeetUpDisplayComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LocatedMeetUpDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
