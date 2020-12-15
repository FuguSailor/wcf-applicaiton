import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WcfComponent } from './wcf.component';

describe('WcfComponent', () => {
  let component: WcfComponent;
  let fixture: ComponentFixture<WcfComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WcfComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WcfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
