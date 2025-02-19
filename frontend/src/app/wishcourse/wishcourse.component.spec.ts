import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WishcourseComponent } from './wishcourse.component';

describe('WishcourseComponent', () => {
  let component: WishcourseComponent;
  let fixture: ComponentFixture<WishcourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WishcourseComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(WishcourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
