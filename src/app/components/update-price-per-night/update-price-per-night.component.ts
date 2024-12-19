import { Component } from '@angular/core';
import { JwtClientService } from 'src/app/jwt-clientservice';
import { AuthRequest } from 'src/app/model/authrequest';

@Component({
  selector: 'app-update-price-per-night',
  templateUrl: './update-price-per-night.component.html',
  styleUrls: ['./update-price-per-night.component.css']
})
export class UpdatePricePerNightComponent {

  response: any;
  authRequest: AuthRequest = new AuthRequest();
  token: string = ''; // Store token for API requests

  constructor(private jwtService: JwtClientService) {}

  // Handle login and retrieve token
  readFormData(formData: any): void {
    this.authRequest.username = formData.form.value.username;
    this.authRequest.password = formData.form.value.password;
    this.getAccessToken(this.authRequest);
  }

  public getAccessToken(authRequest: any) {
    this.jwtService.getGeneratedToken(authRequest).subscribe(
      (genToken) => {
        this.token = genToken; // Store token for subsequent API calls
        console.log('Generated Token:', genToken);
      },
      (error) => {
        console.error('Error generating token:', error);
      }
    );
  }

  // Update price per night for a specific room
  public updatePriceperNight(price: number, id: number): void {
    if (!this.token) {
      console.error('Token is not available!');
      return;
    }

    console.log(`Attempting to update price of room ID: ${id} to ${price}`);

    this.jwtService.updatePricePerNight(price, id, this.token).subscribe(
      (response) => {
        console.log(`Room ID ${id} price updated successfully to ${price}.`);
        alert(`Room ID ${id} price updated successfully.`);
      },
      (error) => {
        console.error('Error occurred while updating price:', error);
      }
    );
  }


}
