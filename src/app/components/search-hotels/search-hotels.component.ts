import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Hotels } from 'src/app/model/hotels';
import { HotelsService } from 'src/app/services/hotels.service';

@Component({
  selector: 'app-search-hotels',
  templateUrl: './search-hotels.component.html',
  styleUrls: ['./search-hotels.component.css']
})
export class SearchHotelsComponent implements OnInit {
  hotelSearchList: Hotels[] = [];
  searchInput: string = '';

  constructor(private route: ActivatedRoute, private hotelService: HotelsService) {}
  
  ngOnInit(): void {
    this.route.params.subscribe((param) => {
      this.searchInput = param['input'];
      this.searchHotels(); // Perform search based on the input
    });
  }

  searchHotels(): void {
    if (this.isNumeric(this.searchInput)) {
      // If the search input is numeric, search by rating
      this.searchHotelsByRating();
      this.searchHotelsById();
    } else {
      // If the search input is a string, search by city
      this.searchHotelsByCity();
    }
  }

  searchHotelsByCity(): void {
    this.hotelService.findByCity(this.searchInput).subscribe(
      (list) => {
        this.hotelSearchList = Array.isArray(list) ? list : [list];
        console.log('Hotel search list by City:', this.hotelSearchList);
      },
      (error) => {
        console.error('Error fetching hotel data by City', error);
      }
    );
  }

  searchHotelsByRating(): void {
    this.hotelService.findByRating(this.searchInput).subscribe(
      (list) => {
        this.hotelSearchList = Array.isArray(list) ? list : [list];
        console.log('Hotel search list by Rating:', this.hotelSearchList);
      },
      (error) => {
        console.error('Error fetching hotel data by Rating', error);
      }
    );
  }
  searchHotelsById(): void {
    this.hotelService.findByHotelsById(this.searchInput).subscribe(
      (list) => {
        this.hotelSearchList = Array.isArray(list) ? list : [list];
        console.log('Hotel search list by Rating:', this.hotelSearchList);
      },
      (error) => {
        console.error('Error fetching hotel data by Rating', error);
      }
    );
  }

  // Helper function to check if the input is numeric
  isNumeric(value: string): boolean {
    return !isNaN(Number(value)); // Returns true if it's a numeric value
  }
}
