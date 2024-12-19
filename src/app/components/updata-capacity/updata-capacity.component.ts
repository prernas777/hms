import { Component } from '@angular/core';
import { JwtClientService } from 'src/app/jwt-clientservice';
import { AuthRequest } from 'src/app/model/authrequest';

@Component({
  selector: 'app-updata-capacity',
  templateUrl: './updata-capacity.component.html',
  styleUrls: ['./updata-capacity.component.css']
})
export class UpdataCapacityComponent {
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

  // Update capacity for a specific room
  public updateRoomCapacity(capacity: number, id: number): void {
    if (!this.token) {
      console.error('Token is not available!');
      return;
    }

    console.log(`Attempting to update capacity of room ID: ${id} to ${capacity}`);

    this.jwtService.updateCapacity(capacity, id, this.token).subscribe(
      (response) => {
        console.log(`Room ID ${id} capacity updated successfully to ${capacity}.`);
        alert(`Room ID ${id} updated successfully.`);
      },
      (error) => {
        console.error('Error occurred while updating capacity:', error);
      }
    );
  }
}
