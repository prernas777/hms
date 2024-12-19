import { Component } from '@angular/core';
import { JwtClientService } from 'src/app/jwt-clientservice';
import { AuthRequest } from 'src/app/model/authrequest';

@Component({
  selector: 'app-update-password',
  templateUrl: './update-password.component.html',
  styleUrls: ['./update-password.component.css']
})
export class UpdatePasswordComponent {
  authRequest: AuthRequest = new AuthRequest();
  token: string = ''; // Store token for API requests
  response: any;

  constructor(private jwtService: JwtClientService) {}

  // Handle login and retrieve token
  readFormData(formData: any): void {
    this.authRequest.username = formData.form.value.username;
    this.authRequest.password = formData.form.value.password;
    this.getAccessToken(this.authRequest);
  }

  public getAccessToken(authRequest: any): void {
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

  // Update password
  public updatePassword(oldPassword: string, newPassword: string): void {
    if (!this.token) {
      console.error('Token is not available!');
      return;
    }

    if (!oldPassword || !newPassword) {
      console.error('Please provide both old and new passwords');
      return;
    }

    console.log(`Attempting to update password for user with token ${this.token}`);

    // Call the API to update the password (replace with the actual API endpoint)
    this.jwtService.updatePassword(oldPassword, newPassword, this.token).subscribe(
      (response) => {
        this.response = response;
        console.log('Password updated successfully:', response);
        alert('Password updated successfully!');
      },
      (error) => {
        console.error('Error occurred while updating password:', error);
        alert('Failed to update password. Please try again.');
      }
    );
  }
}
