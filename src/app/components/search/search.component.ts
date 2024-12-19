import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Hotels } from 'src/app/model/hotels';
import { Users } from 'src/app/model/Users';
import { HotelsService } from 'src/app/services/hotels.service';
import { RoomsService } from 'src/app/services/rooms.service';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit{
  userSearchList: Users[] = [];
  hotelSearchList: Hotels[] = [];
  searchInput: string = '';

  constructor(
    private route: ActivatedRoute,
    private userService: UsersService,
    private hotelService: HotelsService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((param) => {
      this.searchInput = param['input'];
      this.findUsers();   // Search by User
      //this.findHotels();  // Search by Hotel
    });
  }

  findUsers(): void {
    // Check if searchInput is numeric for user search
    if (this.isNumeric(this.searchInput)) {
      this.userService.findById(this.searchInput).subscribe(
        (list) => {
          this.userSearchList = Array.isArray(list) ? list : [list];
          console.log('User search list:', this.userSearchList);  // Log user search results
        },
        (error) => {
          console.error('Error fetching user data by ID', error);
        }
      );
    } else {
      this.userService.findByName(this.searchInput).subscribe(
        (list) => {
          this.userSearchList = Array.isArray(list) ? list : [list];
          console.log('User search list by Name:', this.userSearchList);  // Log user search results by name
        },
        (error) => {
          console.error('Error fetching user data by Name', error);
        }
      );
    }
  }



  // Helper function to check if a string is numeric
  isNumeric(value: string): boolean {
    return !isNaN(Number(value));  // Returns true if it's a numeric value
  }
}


 
 
 
  
