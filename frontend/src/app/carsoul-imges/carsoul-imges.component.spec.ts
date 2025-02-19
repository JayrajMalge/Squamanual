import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarsoulImgesComponent } from './carsoul-imges.component';

describe('CarsoulImgesComponent', () => {
  let component: CarsoulImgesComponent;
  let fixture: ComponentFixture<CarsoulImgesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CarsoulImgesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CarsoulImgesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
