import { Component } from '@angular/core';
import { Hotels } from 'src/app/model/hotels';
import { HotelsService } from 'src/app/services/hotels.service';

@Component({
  selector: 'app-update-hotels',
  templateUrl: './update-hotels.component.html',
  styleUrls: ['./update-hotels.component.css']
})
export class UpdateHotelsComponent {
   
    constructor(private  service:HotelsService){
  
    }
  
  
  
    updateHotel(hotel:Hotels){
  
              this.service.updateHotel(hotel).subscribe(
  
                  (response)=>{  console.log(response)
  
                    alert(response.hotelId +" hotel updated successfully")
                  } ,
  
                  (err)=>{ console.log(err)}
  
  
  
              );
  }

}
