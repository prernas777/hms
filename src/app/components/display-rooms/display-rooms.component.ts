import { Component } from '@angular/core';
import { Rooms } from 'src/app/model/rooms';
import { RoomsService } from 'src/app/services/rooms.service';

@Component({
  selector: 'app-display-rooms',
  templateUrl: './display-rooms.component.html',
  styleUrls: ['./display-rooms.component.css']
})
export class DisplayRoomsComponent {

  roomList:Rooms[]=[];
  constructor(private roomService:RoomsService){}


  ngOnInit(){

      this.getAllRooms();

  }
  getAllRooms(){
    
    this.roomService.getAll().subscribe( 
                              (list)=>{ this.roomList = list;  console.log(list)}
                              
                                );

        

}
deleteById(roomId:number){

  this.roomService.delete(roomId).subscribe( (msg)=>{ console.log("Deleted "+msg);});


  this.getAllRooms(); 
}

}
