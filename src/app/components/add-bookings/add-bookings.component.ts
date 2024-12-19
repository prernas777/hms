import { Component } from '@angular/core';
import { BookingService } from 'src/app/services/booking.service';

@Component({
  selector: 'app-add-bookings',
  templateUrl: './add-bookings.component.html',
  styleUrls: ['./add-bookings.component.css'],
})
export class AddBookingsComponent {
  constructor(private bookingService: BookingService) {}

  addBooking(value: any) {
    this.bookingService.addBooking(value).subscribe(data=>{
      // console.log(data);
    })
  }
}
