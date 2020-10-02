import { Component, OnInit } from '@angular/core';
import { BookSlotService } from '../services/bookslot.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-status',
  templateUrl: './status.component.html',
  styleUrls: ['./status.component.css']
})
export class StatusComponent implements OnInit {

  id: number;
  status: string;

  submitted = false;

  constructor(private bookingService: BookSlotService,
    private router: Router) { }

  ngOnInit() {
  }

  fetchSatus() {
    this.bookingService
      .getSlot(this.id).subscribe(data => {
        console.log(data, "after adding booking");
        this.status = data["status"];
      },
        error => {
          this.status = "Not found";
        });
  }

  onSubmit() {
    this.submitted = true;
    this.fetchSatus();
  }

}


