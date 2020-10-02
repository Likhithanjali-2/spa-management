import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { AdminComponent } from './admin/admin.component';
import { GalleryComponent } from './gallery/gallery.component';
import { UserpageComponent } from './userpage/userpage.component';
import { BookslotComponent } from './bookslot/bookslot.component';
import { StatusComponent } from './status/status.component';
import { MyBookingsComponent } from './my-bookings/my-bookings.component';
import { AddslotComponent } from './addslot/addslot.component';

import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from '../app/auth/token.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    CreateEmployeeComponent,
    EmployeeDetailsComponent,
    EmployeeListComponent,
    UpdateEmployeeComponent,
    LoginComponent,
    RegistrationComponent,
    AdminComponent,
    GalleryComponent,
    UserpageComponent,
    BookslotComponent,
    StatusComponent,
    MyBookingsComponent,
    AddslotComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
