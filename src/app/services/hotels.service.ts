import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hotels } from '../model/hotels';


@Injectable({
  providedIn: 'root'
})
export class HotelsService {

    baseURL:string = "http://localhost:8080/api/hotels/";

    constructor(private  http:HttpClient) {

    }
    addHotel(hotel:Hotels):Observable<Hotels>{

        return  this.http.post<Hotels>(this.baseURL+"insert",hotel);

    }
    updateHotel(hotel:Hotels):Observable<Hotels>{

        return  this.http.put<Hotels>(this.baseURL+"update",hotel);

    }

    getAll():Observable<Hotels[]>{

        return  this.http.get<Hotels[]>(this.baseURL+"getall");

    }
    delete(hotelId:number):Observable<string>{

        return  this.http.delete<string>(this.baseURL+"delete/"+hotelId);
  
      }
    findByCity(data:string):Observable<Hotels[]>{


        console.log(data)
       return this.http.get<Hotels[]>(this.baseURL+`getByCity/${data}`);
    
    }
    findByHotelsById(data:string):Observable<Hotels[]>{


        console.log(data)
       return this.http.get<Hotels[]>(this.baseURL+`getbyid/${data}`);
    
    }
    findByRating(data:string):Observable<Hotels[]>{

        console.log(data)
       return this.http.get<Hotels[]>(this.baseURL+`getByRating/${data}`);
    
    }

}