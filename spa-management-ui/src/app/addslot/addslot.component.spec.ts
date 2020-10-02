import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddslotComponent } from './addslot.component';

describe('AddslotComponent', () => {
  let component: AddslotComponent;
  let fixture: ComponentFixture<AddslotComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddslotComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddslotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
