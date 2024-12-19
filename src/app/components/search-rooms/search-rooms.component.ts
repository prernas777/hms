import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Rooms } from 'src/app/model/rooms';
import { RoomsService } from 'src/app/services/rooms.service';

@Component({
  selector: 'app-search-rooms',
  templateUrl: './search-rooms.component.html',
  styleUrls: ['./search-rooms.component.css']
})
export class SearchRoomsComponent {
roomSearchList: Rooms[] = [];
  searchInput: string = '';

  constructor(private route: ActivatedRoute, private roomService: RoomsService) {}
  
  ngOnInit(): void {
    this.route.params.subscribe((param) => {
      this.searchInput = param['input'];
      this.searchRooms(); // Perform search based on the input
    });
  }
  searchRooms(): void {
    if (this.isNumeric(this.searchInput)) {
      
      this.searchRoomsById();
    } else {
      
      //this.searchHotelsByCity();
    }
  }
  searchRoomsById(): void {
    this.roomService.findByRoomsId(this.searchInput).subscribe(
      (list) => {
        this.roomSearchList = Array.isArray(list) ? list : [list];
        console.log('Room search list by id:', this.roomSearchList);
      },
      (error) => {
        console.error('Error fetching room data by id', error);
      }
    );
  }
  isNumeric(value: string): boolean {
    return !isNaN(Number(value)); // Returns true if it's a numeric value
  }
}
