import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UdateCourseFormComponent } from './udate-course-form.component';

describe('UdateCourseFormComponent', () => {
  let component: UdateCourseFormComponent;
  let fixture: ComponentFixture<UdateCourseFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UdateCourseFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UdateCourseFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
