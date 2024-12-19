import { Component } from '@angular/core';
import { Hotels } from 'src/app/model/hotels';
import { HotelsService } from 'src/app/services/hotels.service';

@Component({
  selector: 'app-add-hotels',
  templateUrl: './add-hotels.component.html',
  styleUrls: ['./add-hotels.component.css']
})
export class AddHotelsComponent {

   
  constructor(private  service:HotelsService){

  }

  addHotel(hotel:Hotels){

            this.service.addHotel(hotel).subscribe(

                (response)=>{  console.log(response)

                  alert(response.hotelId +" Hotel added successfully")
                } ,

                (err)=>{ console.log(err)}



            );
}

}
