import { Component } from '@angular/core';
import { AvailabilityStatus, Rooms, RoomType } from 'src/app/model/rooms';
import { RoomsService } from 'src/app/services/rooms.service';

@Component({
  selector: 'app-update-rooms',
  templateUrl: './update-rooms.component.html',
  styleUrls: ['./update-rooms.component.css']
})
export class UpdateRoomsComponent {

   constructor(private  service:RoomsService){
  
    }
   roomTypes = Object.values(RoomType).filter(key => isNaN(Number(key)));; 
    availabilityStatuses = Object.values(AvailabilityStatus).filter(key => isNaN(Number(key)));;
    room: Rooms = new Rooms();
  
  
    updateRoom(room:Rooms){
  
              this.service.updateRoom(room).subscribe(
  
                  (response)=>{  console.log(response)
  
                    alert(response.roomId +" room updated successfully")
                  } ,
  
                  (err)=>{ console.log(err)}
  
  
  
              );
  }
  }


