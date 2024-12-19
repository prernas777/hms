import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AddUsersComponent } from './components/add-users/add-users.component';
import { AddHotelsComponent } from './components/add-hotels/add-hotels.component';
import { AddRoomsComponent } from './components/add-rooms/add-rooms.component';
import { DisplayHotelsComponent } from './components/display-hotels/display-hotels.component';
import { DisplayRoomsComponent } from './components/display-rooms/display-rooms.component';
import { DisplayUsersComponent } from './components/display-users/display-users.component';
import { SearchComponent } from './components/search/search.component';
import { SearchHotelsComponent } from './components/search-hotels/search-hotels.component';
import { SearchRoomsComponent } from './components/search-rooms/search-rooms.component';
import { SecurityComponent } from './components/security/security.component';
import { UpdateUsersComponent } from './components/update-users/update-users.component';
import { UpdateRoomsComponent } from './components/update-rooms/update-rooms.component';
import { UpdateHotelsComponent } from './components/update-hotels/update-hotels.component';
import { UpdatePhoneNumberComponent } from './components/update-phone-number/update-phone-number.component';
import { UpdataCapacityComponent } from './components/updata-capacity/updata-capacity.component';
import { UpdatePricePerNightComponent } from './components/update-price-per-night/update-price-per-night.component';
import { UpdatePasswordComponent } from './components/update-password/update-password.component';
import { AddBookingsComponent } from './components/add-bookings/add-bookings.component';
import { DisplayBookingsComponent } from './components/display-bookings/display-bookings.component';
import { SearchBookingsComponent } from './components/search-bookings/search-bookings.component';
import { UpdateBookingsComponent } from './components/update-bookings/update-bookings.component';


const routes: Routes = [

  {path:'home',component:AppComponent},
  {path:'login',children:[
  { path: 'login', component: SecurityComponent},]
  },
  //{ path: 'register', component: RegistrationComponent },
  {
    path: 'users', children: [
      { path: 'add', component: AddUsersComponent },      
      { path: 'display', component: DisplayUsersComponent }, 
      {path:'search/:input',component:SearchComponent},
      //{ path: 'updatePhoneNumber/:id/:phoneNumber', component: UpdateUsersComponent },
      {path:'update',component:UpdateUsersComponent},
      { path: 'updatePhoneNumber', component: UpdatePhoneNumberComponent },
      {path:'updatePassword',component:UpdatePasswordComponent}

    ]
  },
  {
    path: 'rooms', children: [
      { path: 'add', component: AddRoomsComponent },      
      { path: 'display', component: DisplayRoomsComponent }, 
      {path:'search/:input',component:SearchRoomsComponent},
      {path:'update',component:UpdateRoomsComponent},
      {path:'updateCapacity',component:UpdataCapacityComponent},
      {path:'updatePricePerNight',component:UpdatePricePerNightComponent}
     
      
    ]
  },
  {
    path: 'hotels', children: [
      { path: 'add', component: AddHotelsComponent },      
      { path: 'display', component: DisplayHotelsComponent }, 
      {path:'search/:input',component:SearchHotelsComponent},
      {path:'update',component:UpdateHotelsComponent},
    ]
  },


  {
    path: 'bookings', children: [
      { path: 'add', component: AddBookingsComponent },      
      { path: 'display', component: DisplayBookingsComponent }, 
      {path:'search/:input',component:SearchBookingsComponent},
      {path:'update',component:UpdateBookingsComponent},
    ]
  },
  
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
