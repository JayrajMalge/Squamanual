import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { MainPageComponent } from './main-page/main-page.component';
import { FullScreenCourseComponent } from './full-screen-course/full-screen-course.component';
import { ProfileComponent } from './profile/profile.component';
import { MylearningComponent } from './mylearning/mylearning.component';
import { EnrollCourseComponent } from './enroll-course/enroll-course.component';
import { WishlistComponent } from './wishlist/wishlist.component';
import { UdateCourseComponent } from './udate-course/udate-course.component';
import { CategoriesComponent } from './categories/categories.component';
import { UdateCourseFormComponent } from './udate-course-form/udate-course-form.component';
import { UploadCourseComponent } from './upload-course/upload-course.component';
import { ViewallcoursesComponent } from './viewallcourses/viewallcourses.component';

export const routes: Routes = [ 
    {path : "",component : MainPageComponent},
    {path : "main",component : MainPageComponent},
    {path : "login",component : LoginComponent},
    {path : "fullScreencourse/:courseid",component : FullScreenCourseComponent},
    {path : "profile",component : ProfileComponent},
    {path : 'mylearning',component : MylearningComponent},
    {path : "enrolledcourse/:courseid",component : EnrollCourseComponent},
    {path : "wishlistedcourses",component : WishlistComponent},
    {path : "category/:categoryid",component : CategoriesComponent},
    {path : "updatecourse/:courseid",component : UdateCourseFormComponent},
    {path : "uploadcourse",component : UploadCourseComponent},
    {path : "viewcourses",component : ViewallcoursesComponent}
    //{ path: '', redirectTo: '/login', pathMatch: 'full' }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }