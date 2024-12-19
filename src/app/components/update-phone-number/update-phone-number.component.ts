import { Component } from '@angular/core';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-update-phone-number',
  templateUrl: './update-phone-number.component.html',
  styleUrls: ['./update-phone-number.component.css']
})
export class UpdatePhoneNumberComponent {

  phoneNumber!: number;  // For the phone number input
  userId!: number;  // For the user ID input
  message!: string;  // To display success or error message

  constructor(private userService: UsersService) {}

  // Method to call the updatePhoneNumber service method
  updatePhoneNumber(): void {
    if (this.userId && this.phoneNumber) {
      this.userService.updatePhoneNumber(this.userId, this.phoneNumber)
        .subscribe(
          response => {
            console.log('Phone number updated successfully!', response);
          },
          error => {
            console.error('Error updating phone number:', error);
          }
        );
    } else {
      console.error('Invalid user ID or phone number');
    }
  }

}
