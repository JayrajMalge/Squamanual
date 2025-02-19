import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FullScreenCourseComponent } from './full-screen-course.component';

describe('FullScreenCourseComponent', () => {
  let component: FullScreenCourseComponent;
  let fixture: ComponentFixture<FullScreenCourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FullScreenCourseComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FullScreenCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
