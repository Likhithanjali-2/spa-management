import { Component, OnInit } from '@angular/core';
import { Booking } from '../services/booking';
import { BookSlotService } from '../services/bookslot.service';
import { Router } from '@angular/router';
import { Expert } from '../employee';
import { Observable } from 'rxjs';
import { EmployeeService } from '../employee.service';
import { SlotService } from '../services/slots.service';
import { Slot } from '../services/slot';

@Component({
  selector: 'app-bookslot',
  templateUrl: './bookslot.component.html',
  styleUrls: ['./bookslot.component.css']
})
export class BookslotComponent implements OnInit {

  experts: Observable<Expert[]>;
  booking: Booking = new Booking();
  availableSlots: Observable<Slot[]>;


  submitted = false;

  constructor(private bookingService: BookSlotService, private employeeService: EmployeeService,
     private slotService: SlotService,
    private router: Router) { }

  ngOnInit() {
    this.reloadExperts();
  }

  reloadExperts() {
    this.experts= this.employeeService.getEmployeesList();
  }

  fetchAvailableSlotsForExpert(): void{
    this.availableSlots = this.slotService.getAvaiableSlotsForExpert(this.booking.expertId, this.booking.date);
  }

  newEmployee(): void {
    this.submitted = false;
    this.booking = new Booking();
  }

  save() {
    this.booking.userId = 12;
    this.bookingService
      .createSlot(this.booking).subscribe(data => {
        console.log(data, "after adding booking");
        this.booking = new Booking();
        // this.gotoList();
        this.booking.id = data["id"];
      },
        error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoUserPage() {
    this.router.navigate(['/userpage']);
  }

}

