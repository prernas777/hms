import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UsersService } from './services/users.service';
import { Observable } from 'rxjs/internal/Observable';
import { Users } from './model/Users';

@Injectable({
  providedIn: 'root'
})
export class JwtClientService {
  private token: string | null = null;
  private baseURL: string = 'http://localhost:8080/api/rooms/';
  private baseURLUsers: string = 'http://localhost:8080/api/users/';

  constructor(private http: HttpClient) { }

  setToken(token: string): void {
    this.token = token;
  }

  getToken(): string | null {
    return this.token;
  }

  // Getting the token from login response
  getGeneratedToken(requestBody: any): Observable<any> {
    return this.http.post(this.baseURLUsers+"login/authenticate", requestBody, { responseType: 'text' as 'json' });
  }

  authorizationTest(userId: number, token: string): Observable<any> {
    // Prepare the token for the Authorization header
    const tokenString = `Bearer ${token}`;
    
    // Set the headers with the Authorization token
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': tokenString,
      'Access-Control-Allow-Origin': 'http://localhost:4200'
    });
  
    // Send a DELETE request to the API with the userId and token
    return this.http.delete<string>(`${this.baseURL}delete/${userId}`, { headers ,
      responseType: 'text' as 'json'});
  }
  updateCapacity(capacity: number, id: number, token: string): Observable<any> {
    // Prepare the token for the Authorization header
    const tokenString = `Bearer ${token}`;
  
    // Set the headers with the Authorization token
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': tokenString,
      'Access-Control-Allow-Origin': 'http://localhost:4200'
    });
  
    // Send a PUT request to the API with the capacity and ID
    return this.http.put<string>(
      `${this.baseURL}updateCapacity/${capacity}/${id}`, 
      null, // No body required for this PUT endpoint
      { headers, responseType: 'text' as 'json' }
    );
  }
  updatePricePerNight(price: number, id: number, token: string): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    });

    return this.http.put<string>(
      `${this.baseURL}updatePricePerNight/${price}/${id}`,
      null,
      { headers }
    );
  }
  updatePassword(oldPassword: string, newPassword: string, token: string): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    });

    const body = { oldPassword, newPassword };
    return this.http.put<any>(`${this.baseURLUsers}updatePassword`, body, { headers });
  }


}

