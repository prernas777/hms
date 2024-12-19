import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdataCapacityComponent } from './updata-capacity.component';

describe('UpdataCapacityComponent', () => {
  let component: UpdataCapacityComponent;
  let fixture: ComponentFixture<UpdataCapacityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdataCapacityComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdataCapacityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
