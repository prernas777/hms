import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserRole, Users } from 'src/app/model/Users';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-add-users',
  templateUrl: './add-users.component.html',
  styleUrls: ['./add-users.component.css']
})
//export class AddUsersComponent implements OnInit {

//   userRoles = Object.values(UserRole).filter(key => isNaN(Number(key)));
//   userForm!: FormGroup;

//   constructor(private fb: FormBuilder, private service: UsersService,private router: Router) { 
//   {this.userForm = this.fb.group({
//     userId: ['', [Validators.required,Validators.min(1), Validators.pattern('^[0-9]*$')]],
//     email: ['', [Validators.required, Validators.email]],
//     name: ['',[ Validators.required, Validators.minLength(3)]],
//     phoneNumber: ['', [Validators.required, Validators.pattern('^[0-9]{10}$')]],
//     password: ['', Validators.required],
//     dateCreated: ['', Validators.required],
//     userRole: ['', Validators.required],
//     updatedAt: ['', Validators.required],
//   });
// }
//   }
//   ngOnInit(): void {
 
//   }

//   addUser(): void {
//     if (this.userForm.valid) {
//       this.service.addUser(this.userForm.value).subscribe({
//           next: () => {
//               alert('User added successfully');
//               this.router.navigate(['/displayall']);
//           },
//           error: (err) => {
//               console.error('Error adding user:', err);
//           }
//       });
//   } else {
//       alert('Please fill in all required fields');
//   }
// }
  //   if (this.userForm.valid) {
  //     const user: Users = this.userForm.value;
  //     this.service.addUser(user).subscribe(
  //       (response) => {
  //         console.log(response);
  //         alert(response.userId + " user added successfully");
  //       },
  //       (err) => {
  //         console.log(err);
  //       }
  //     );
  //   }
  // }

export class AddUsersComponent {


  userRole = Object.values(UserRole).filter(key => isNaN(Number(key)));; 

  
  constructor(private  service:UsersService){

  }
  formData: any = {
    userRole: null, // Ensure it starts with a null or empty value
  };


  addUser(user:Users){

            this.service.addUser(user).subscribe(

                (response)=>{  console.log(response)

                  alert(response.userId +" user added successfully")
                } ,

                (err)=>{ console.log(err)}



            );
}


}