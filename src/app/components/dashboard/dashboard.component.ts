import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { HotelsService } from 'src/app/services/hotels.service';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent {
  findByBookingsId(_t141: NgForm) {
    throw new Error('Method not implemented.');
  }

  data: string = '';

  constructor(
    private userService: UsersService,
    private router: Router,
    private hotelService: HotelsService
  ) {}
  findById(idSearchForm: any): void {
    const searchTerm = idSearchForm.form.value.data;
    this.router.navigate(['users/search', searchTerm]);
    console.log('Search Term:', searchTerm);
  }
  findByName(nameSearchForm: any): void {
    const searchTerm = nameSearchForm.form.value.data;
    this.router.navigate(['users/search', searchTerm]);
    console.log('Search Term:', searchTerm);
  }

  findHotelsByCity(citySearchForm: any): void {
    const searchTerm = citySearchForm.form.value.data;
    this.router.navigate(['hotels/search', searchTerm]); // navigate to the search page with the input term
    console.log('Search by City:', searchTerm);
  }

  findHotelsByRating(ratingSearchForm: any): void {
    const searchTerm = ratingSearchForm.form.value.data;
    this.router.navigate(['hotels/search', searchTerm]); // navigate to the search page with the input term
    console.log('Search by Rating:', searchTerm);
  }
  findByHotelsId(idHotelsSearchForm: any): void {
    const searchTerm = idHotelsSearchForm.form.value.data;
    this.router.navigate(['hotels/search', searchTerm]);
    console.log('Search Term:', searchTerm);
  }
  findByRoomsId(idRoomsSearchForm: any): void {
    const searchTerm = idRoomsSearchForm.form.value.data;
    this.router.navigate(['rooms/search', searchTerm]);
    console.log('Search Term:', searchTerm);
  }
  updatePhoneNumber(idForm: any): void {
    const id = idForm.form.value.id; // Extract user ID from the form
    const phoneNumber = idForm.form.value.phoneNumber; // Extract phone number from the form

    // Check if the id and phoneNumber are valid
    console.log('User ID:', id);
    console.log('Phone Number:', phoneNumber);

    if (id && phoneNumber) {
      // Navigate only if both id and phoneNumber are defined
      this.router.navigate(['users/updatePhoneNumber', id, phoneNumber]);
      console.log(
        `Navigating to update phone number for User ID: ${id}, Phone Number: ${phoneNumber}`
      );
    } else {
      console.error('Invalid form data:', id, phoneNumber);
      alert('Please provide both User ID and Phone Number');
    }
  }
}
