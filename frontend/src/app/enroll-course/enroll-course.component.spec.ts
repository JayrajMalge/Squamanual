import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnrollCourseComponent } from './enroll-course.component';

describe('EnrollCourseComponent', () => {
  let component: EnrollCourseComponent;
  let fixture: ComponentFixture<EnrollCourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EnrollCourseComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EnrollCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
