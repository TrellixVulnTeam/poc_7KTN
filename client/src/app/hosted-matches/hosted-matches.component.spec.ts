import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HostedMatchesComponent } from './hosted-matches.component';

describe('HostedMatchesComponent', () => {
  let component: HostedMatchesComponent;
  let fixture: ComponentFixture<HostedMatchesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HostedMatchesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HostedMatchesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
