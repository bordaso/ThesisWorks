import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValueCalcModalComponent } from './value-calc-modal.component';

describe('ValueCalcModalComponent', () => {
  let component: ValueCalcModalComponent;
  let fixture: ComponentFixture<ValueCalcModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ValueCalcModalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ValueCalcModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
