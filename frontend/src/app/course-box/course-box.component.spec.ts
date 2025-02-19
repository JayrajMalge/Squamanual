import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseBoxComponent } from './course-box.component';

describe('CourseBoxComponent', () => {
  let component: CourseBoxComponent;
  let fixture: ComponentFixture<CourseBoxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseBoxComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CourseBoxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
