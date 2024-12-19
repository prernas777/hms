import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class BookingService {
    baseURL: string = 'http://localhost:8080/bookings/';

  constructor(private http: HttpClient) {}

  addBooking(data : any) {
    return this.http.post(this.baseURL + 'create',data);
    // this.mockBookings.push(data);
  }

  getAllBookings() {
    // return this.http.get<Hotels[]>(this.baseURL + 'getall');
    return this.mockBookings;
  }
  findByStatus(data: string) {
    console.log(data);
    // return this.http.get(this.baseURL + `getByCity/${data}`);
  }
  findByBookingId(data: string) {
    console.log(data);
    // return this.http.get<Hotels[]>(this.baseURL + `getbyid/${data}`);
  }

  mockBookings = [
    {
      bookingId: 101,
      checkInDate: '2024-12-01',
      checkOutDate: '2024-12-05',
      totalAmount: 1200.5,
      bookingStatus: 'CONFIRMED',
      bookingDate: '2024-11-20',
      numberOfGuests: 2,
      specialRequests: 'Late check-in',
      userId: 101,
      hotelId: 202,
      roomId: 303,
    },
    {
      bookingId: 102,
      checkInDate: '2024-12-10',
      checkOutDate: '2024-12-15',
      totalAmount: 1500.75,
      bookingStatus: 'PENDING',
      bookingDate: '2024-11-25',
      numberOfGuests: 4,
      specialRequests: 'Sea view room',
      userId: 102,
      hotelId: 203,
      roomId: 304,
    },
    {
      bookingId: 103,
      checkInDate: '2024-12-20',
      checkOutDate: '2024-12-25',
      totalAmount: 2000.0,
      bookingStatus: 'CANCELLED',
      bookingDate: '2024-11-30',
      numberOfGuests: 3,
      specialRequests: 'Extra bed',
      userId: 103,
      hotelId: 204,
      roomId: 305,
    },
    {
      bookingId: 104,
      checkInDate: '2025-01-05',
      checkOutDate: '2025-01-10',
      totalAmount: 1000.0,
      bookingStatus: 'CONFIRMED',
      bookingDate: '2024-12-10',
      numberOfGuests: 1,
      specialRequests: 'Early check-in',
      userId: 104,
      hotelId: 205,
      roomId: 306,
    },
    {
      bookingId: 105,
      checkInDate: '2025-01-12',
      checkOutDate: '2025-01-15',
      totalAmount: 750.5,
      bookingStatus: 'PENDING',
      bookingDate: '2024-12-12',
      numberOfGuests: 2,
      specialRequests: 'Non-smoking room',
      userId: 105,
      hotelId: 206,
      roomId: 307,
    },
    {
      bookingId: 106,
      checkInDate: '2025-02-01',
      checkOutDate: '2025-02-05',
      totalAmount: 1700.0,
      bookingStatus: 'CONFIRMED',
      bookingDate: '2025-01-15',
      numberOfGuests: 4,
      specialRequests: 'Poolside room',
      userId: 106,
      hotelId: 207,
      roomId: 308,
    },
    {
      bookingId: 107,
      checkInDate: '2025-02-10',
      checkOutDate: '2025-02-15',
      totalAmount: 800.0,
      bookingStatus: 'CANCELLED',
      bookingDate: '2025-01-20',
      numberOfGuests: 3,
      specialRequests: 'High floor',
      userId: 107,
      hotelId: 208,
      roomId: 309,
    },
    {
      bookingId: 108,
      checkInDate: '2025-03-01',
      checkOutDate: '2025-03-05',
      totalAmount: 2200.0,
      bookingStatus: 'CONFIRMED',
      bookingDate: '2025-02-10',
      numberOfGuests: 5,
      specialRequests: 'Quiet room',
      userId: 108,
      hotelId: 209,
      roomId: 310,
    },
    {
      bookingId: 109,
      checkInDate: '2025-03-10',
      checkOutDate: '2025-03-15',
      totalAmount: 1800.0,
      bookingStatus: 'PENDING',
      bookingDate: '2025-02-20',
      numberOfGuests: 2,
      specialRequests: 'Near elevator',
      userId: 109,
      hotelId: 210,
      roomId: 311,
    },
    {
      bookingId: 110,
      checkInDate: '2025-03-20',
      checkOutDate: '2025-03-25',
      totalAmount: 1200.0,
      bookingStatus: 'CONFIRMED',
      bookingDate: '2025-03-01',
      numberOfGuests: 4,
      specialRequests: 'Accessible room',
      userId: 110,
      hotelId: 211,
      roomId: 312,
    },
  ];
}
