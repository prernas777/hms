import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatePricePerNightComponent } from './update-price-per-night.component';

describe('UpdatePricePerNightComponent', () => {
  let component: UpdatePricePerNightComponent;
  let fixture: ComponentFixture<UpdatePricePerNightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdatePricePerNightComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdatePricePerNightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
