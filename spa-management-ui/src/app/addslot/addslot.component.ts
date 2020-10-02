import { Component, OnInit } from '@angular/core';
import { SlotService } from '../services/slots.service';
import { Slot } from '../services/slot';

@Component({
  selector: 'app-addslot',
  templateUrl: './addslot.component.html',
  styleUrls: ['./addslot.component.css']
})
export class AddslotComponent implements OnInit {

  slot: Slot = new Slot();
  submitted = false;
  constructor(private slotService: SlotService) { }

  ngOnInit() {
  }

  save(): void{

    this.slotService.createSlot(this.slot).subscribe(data=>{
      this.submitted = true;
      console.log("slot added");
    }, error=>{
      console.log(error);
    })

  }
  onSubmit(): void{
    this.save();
    
  }

}
