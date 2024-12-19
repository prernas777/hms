import { Component } from '@angular/core';
import { AvailabilityStatus, Rooms, RoomType } from 'src/app/model/rooms';
import { RoomsService } from 'src/app/services/rooms.service';

@Component({
  selector: 'app-add-rooms',
  templateUrl: './add-rooms.component.html',
  styleUrls: ['./add-rooms.component.css']
})
export class AddRoomsComponent {
  roomTypes = Object.values(RoomType).filter(key => isNaN(Number(key)));; 
  availabilityStatuses = Object.values(AvailabilityStatus).filter(key => isNaN(Number(key)));;
  room: Rooms = new Rooms();
  
  
  constructor(private  service:RoomsService){

  }



  addRoom(room:Rooms){

            this.service.addRoom(room).subscribe(

                (response)=>{  console.log(response)

                  alert(response.roomId +" Room added successfully")
                } ,

                (err)=>{ console.log(err)}



            );
}

}
