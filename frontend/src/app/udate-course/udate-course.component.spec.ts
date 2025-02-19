import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UdateCourseComponent } from './udate-course.component';

describe('UdateCourseComponent', () => {
  let component: UdateCourseComponent;
  let fixture: ComponentFixture<UdateCourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UdateCourseComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UdateCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
