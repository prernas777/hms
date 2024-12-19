import { Component } from '@angular/core';
import { JwtClientService } from 'src/app/jwt-clientservice';
import { AuthRequest } from 'src/app/model/authrequest';
import { Users } from 'src/app/model/Users';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-security',
  templateUrl: './security.component.html',
  styleUrls: ['./security.component.css']
})
export class SecurityComponent {
  [x: string]: any;
  response: any;
  authRequest: AuthRequest = new AuthRequest();
  userList: Users[] = [];
  token: string = '';

  constructor(private userService: UsersService, private jwtService: JwtClientService) {}

  ngOnInit(): void {
    this.getAllUsers(); // Fetch all users initially when the component loads
  }

  // Fetch all users
  getAllUsers() {
    this.userService.getAll().subscribe(
      (list) => {
        this.userList = list; // Store the list of users
        console.log('User List:', list);
      },
      (error) => {
        console.error('Error fetching users:', error); // Handle errors if fetching users fails
      }
    );
  }

  // Handle form submission and pass data to getAccessToken for login
  readFormData(formData: any): void {
    this.authRequest.username = formData.form.value.username;
    this.authRequest.password = formData.form.value.password;
    this.getAccessToken(this.authRequest); // Get token after login form submission
  }

  // Retrieve token and call accessApi for delete operation
  public getAccessToken(authRequest: any) {
    // Call getGeneratedToken method to get the token
    this.jwtService.getGeneratedToken(authRequest).subscribe(
      (genToken) => {
        this.token = genToken; // Assign the token after successful generation
        console.log('Generated Token:', genToken);

        // Now token is available, ready to delete users
      },
      (error) => {
        console.error('Error generating token:', error); // Handle errors if token generation fails
      }
    );
  }

  // Call authorizationTest with userId and token for delete operation
  public accessApiForDelete(userId: number, token: string) {
    console.log('Authorization Token:', token);

    // Call authorizationTest with the correct userId and token for delete
    this.jwtService.authorizationTest(userId, token).subscribe(
      (responseData) => {
        console.log('Response from API (delete):', responseData);
        this.response = responseData;
      },
      (error) => {
        console.error('Error in delete API call:', error);
      }
    );
  }

  deleteById(userId: number): void {
    if (!this.token) {
      console.error('Token is not available!');
      return;
    }
  
    console.log('Attempting to delete user with ID:', userId);
  
    this.jwtService.authorizationTest(userId, this.token).subscribe(
      (response) => {
        console.log(`User with ID ${userId} has been deleted successfully.`);
        this.getAllUsers(); // Refresh the user list
      },
      (error) => {
        console.error('Error occurred while deleting the user:', error);
      }
    );
  }
  // Perform updateCapacity operation
// public updateRoomCapacity(capacity: number, id: number): void {
//   if (!this.token) {
//     console.error('Token is not available!');
//     return;
//   }

//   console.log(`Attempting to update capacity of room ID: ${id} to ${capacity}`);
  
//   this.jwtService.updateCapacity(capacity, id, this.token).subscribe(
//     (response) => {
//       console.log(`Room ID ${id} capacity updated successfully to ${capacity}.`);
//       this.response = response;
//       this.getAllUsers(); // Refresh the user list or relevant data
//     },
//     (error) => {
//       console.error('Error occurred while updating capacity:', error);
//     }
//   );
// }

  
}
