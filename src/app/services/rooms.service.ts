import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hotels } from '../model/hotels';
import { Rooms } from '../model/rooms';


@Injectable({
  providedIn: 'root'
})
export class RoomsService {

    baseURL:string = "http://localhost:8080/api/rooms/";

    constructor(private  http:HttpClient) {

    }
    addRoom(room: Rooms):Observable<Rooms>{

        return  this.http.post<Rooms>(this.baseURL+"insert",room);

    }
    updateRoom(room: Rooms):Observable<Rooms>{

      return  this.http.put<Rooms>(this.baseURL+"update",room);

  }
    
    getAll():Observable<Rooms[]>{

        return  this.http.get<Rooms[]>(this.baseURL+"getall");

    }
    delete(roomId:number):Observable<string>{

        return  this.http.delete<string>(this.baseURL+"delete/"+roomId);
  
      }
      findByRoomsId(data:string):Observable<Rooms[]>{


        console.log(data)
       return this.http.get<Rooms[]>(this.baseURL+`getbyid/${data}`);
    
      }

      
}