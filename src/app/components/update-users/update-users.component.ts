import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserRole, Users } from 'src/app/model/Users';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-update-users',
  templateUrl: './update-users.component.html',
  styleUrls: ['./update-users.component.css']
})
export class UpdateUsersComponent {
  userRoles = Object.values(UserRole).filter(key => isNaN(Number(key)));; 

  
  constructor(private  service:UsersService){

  }



  updateUser(user:Users){

            this.service.updateUser(user).subscribe(

                (response)=>{  console.log(response)

                  alert(response.userId +" user updated successfully")
                } ,

                (err)=>{ console.log(err)}



            );
}
}

//   userRole = Object.values( UserRole); 


//   constructor(private service: UsersService,private route: ActivatedRoute) {}

//   id!: number;
//   phoneNumber!: number ;
//   updatePhoneNumber(idSearchForm: any): void {
//     // Log the form data
//     console.log(idSearchForm.form.value);
  
//     // Extract the values correctly
//     const formValues = idSearchForm.form.value;
//     const id = formValues.id;           // Extract user ID
//     const phoneNumber = formValues.phoneNumber; // Extract phone number
  
//     console.log('User ID:', id);
//     console.log('Phone Number:', phoneNumber);
  
//     // Proceed with API call
//     if (id && phoneNumber) {
//       this.service.updatePhoneNumber(id, phoneNumber).subscribe(
//         (response) => {
//           console.log(response);
//           alert(`User ID ${id} updated successfully with new phone number: ${phoneNumber}`);
//         },
//         (error) => {
//           console.error(error);
//           alert('Failed to update phone number');
//         }
//       );
//     } else {
//       console.error('Invalid form data:', id, phoneNumber);
//       alert('Please provide both User ID and Phone Number');
//     }
//   }
// }  
 


  


