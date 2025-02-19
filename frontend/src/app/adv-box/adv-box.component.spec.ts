import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdvBoxComponent } from './adv-box.component';

describe('AdvBoxComponent', () => {
  let component: AdvBoxComponent;
  let fixture: ComponentFixture<AdvBoxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdvBoxComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AdvBoxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
