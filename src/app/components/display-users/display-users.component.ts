import { Component } from '@angular/core';
import { JwtClientService } from 'src/app/jwt-clientservice';
import { UserRole, Users } from 'src/app/model/Users';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-display-users',
  templateUrl: './display-users.component.html',
  styleUrls: ['./display-users.component.css']
})
export class DisplayUsersComponent {

  userList:Users[]=[];
  constructor(private userService:UsersService,private jwtService:JwtClientService){}
  token: string = '';
  //userRole = Object.values(UserRole).filter(key => isNaN(Number(key)));; 

  ngOnInit():void{

      this.getAllUsers();

  }
  getAllUsers(){
    
    this.userService.getAll().subscribe( 
                              (list)=>{ this.userList = list;  console.log(list)}
                              
                                );

}
// deleteById(userId: number): void {
//   // Retrieve the token stored after login
//   const token = this.jwtService.getToken();

//   // Ensure userId is being retrieved correctly (this could come from JWT or UserService)
//   userId = this.userService['getUserId']();  // Use index signature if it's not directly available

//   if (token && userId) {
//     // Ensure the authorizationTest method accepts both userId and token
//     this.jwtService.authorizationTest(userId, token).subscribe(
//       (response) => {
//         // Handle the response
//         // If it's a list, you can store it in the userList or perform any other action
//         this.userList = response;
//         console.log('User List:', response);
//       },
//       (error) => {
//         // Error handling
//         console.error('Error during API request:', error);
//       }
//     );
//   } else {
//     // Token or userId is missing, log an error
//     console.error('Token or userId is not available!');
//   }
// }





// deleteById(userId: number) {
//   //const token = this.token; // Assume `this.token` holds the current valid JWT token

//   this.userService.delete(userId).subscribe(
//     (msg) => {
//       console.log("Deleted: " + msg);
//       //this.getAllUsers(); // Refresh the user list after successful deletion
//     },
//     (error) => {
//       console.error("Error deleting user:", error);
//     }
//   );
// }


}
