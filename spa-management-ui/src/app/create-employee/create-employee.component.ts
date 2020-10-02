import { EmployeeService } from '../employee.service';
import { Expert } from '../employee';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Expert = new Expert();
  submitted = false;

  constructor(private employeeService: EmployeeService,
    private router: Router) { }

  ngOnInit() {
  }

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Expert();
  }

  save() {
    this.employeeService
    .createEmployee(this.employee).subscribe(data => {
      console.log(data)
      this.employee = new Expert();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/experts']);
  }
}
