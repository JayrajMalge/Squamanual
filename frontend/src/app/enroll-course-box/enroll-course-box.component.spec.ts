import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnrollCourseBoxComponent } from './enroll-course-box.component';

describe('EnrollCourseBoxComponent', () => {
  let component: EnrollCourseBoxComponent;
  let fixture: ComponentFixture<EnrollCourseBoxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EnrollCourseBoxComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EnrollCourseBoxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
