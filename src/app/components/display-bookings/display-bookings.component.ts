import { Component } from '@angular/core';
import { BookingService } from 'src/app/services/booking.service';

@Component({
  selector: 'app-display-bookings',
  templateUrl: './display-bookings.component.html',
  styleUrls: ['./display-bookings.component.css'],
})
export class DisplayBookingsComponent {
  selectedOption!: string;
  searchTerm: any;
  allBookings: any;
  filteredBookings: any;
  filter = true;
  constructor(private bookingService: BookingService) {}
  ngOnInit() {
    this.filteredBookings = [];
    this.selectedOption = 'bookingId';
    this.allBookings = this.getBookings();
  }

  searchBookings() {
    if (this.selectedOption != '') {
      this.filter = false;
      if (this.selectedOption === 'bookingId') {
        this.filteredBookings = [];
        this.searchTerm = parseInt(this.searchTerm);
        this.allBookings.forEach((booking: any) => {
          if (booking.bookingId === this.searchTerm) {
            this.filteredBookings.push(booking);
          }
        });
      } else if ((this.selectedOption = 'bookingStatus')) {
        this.filteredBookings = [];
        this.searchTerm = this.searchTerm.toUpperCase();
        this.allBookings.forEach((booking: any) => {
          if (booking.bookingStatus === this.searchTerm) {
            this.filteredBookings.push(booking);
          }
        });
      } else {
        alert('Please select correct option!!');
        this.filteredBookings = [];
      }
    }
  }

  getBookings() {
    return this.bookingService.getAllBookings();
  }
}
