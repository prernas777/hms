import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Users } from '../model/Users';


@Injectable({
  providedIn: 'root'
})
export class UsersService {
  [x: string]: any;

    baseURL:string = "http://localhost:8080/api/users/";

  constructor(private  http:HttpClient) {

   }

      addUser(user:Users):Observable<Users>{


          return  this.http.post<Users>(this.baseURL+"insert",user);

      }

      updateUser(user:Users):Observable<Users>{


        return  this.http.put<Users>(this.baseURL+"update",user);

    }
      getAll():Observable<Users[]>{

        return  this.http.get<Users[]>(this.baseURL+"getall");

    }
    updatePhoneNumber(id: number, phno: number): Observable<any> {
      
      const url = `${this.baseURL}updatePhoneNumber/${phno}/${id}`;
      
      return this.http.put<any>(url, {});
  }
  
    updatePassword(id: number,pword: string): Observable<number> {
      return this.http.put<number>(`${this.baseURL}updatePassword/${pword}/${id}`, {});
    }
 
  findById(data:string):Observable<Users[]>{


    console.log(data)
   return this.http.get<Users[]>(this.baseURL+`getbyid/${data}`);

  }
  findByName(data:string):Observable<Users[]>{


    console.log(data)
   return this.http.get<Users[]>(this.baseURL+`getByName/${data}`);

  }
 

 
  }
    
    