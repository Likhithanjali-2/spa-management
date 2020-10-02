import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
import { GalleryComponent } from './gallery/gallery.component';
import { UserpageComponent } from './userpage/userpage.component';
import { BookslotComponent } from './bookslot/bookslot.component';
import { StatusComponent } from './status/status.component';
import { MyBookingsComponent } from './my-bookings/my-bookings.component';
import { AddslotComponent } from './addslot/addslot.component';

const routes: Routes = [
  { path: '', redirectTo: 'gallery', pathMatch: 'full' },
  { path: 'gallery', component: GalleryComponent },
  { path: 'userpage', component: UserpageComponent },
  { path: 'bookslot', component: BookslotComponent },
  { path: 'status', component: StatusComponent },
  { path: 'mybookings', component: MyBookingsComponent},
  { path: 'addslot', component: AddslotComponent},

  { path: 'experts', component: EmployeeListComponent },
  { path: 'add', component: CreateEmployeeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegistrationComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'update/:id', component: UpdateEmployeeComponent },
  { path: 'details/:id', component: EmployeeDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
