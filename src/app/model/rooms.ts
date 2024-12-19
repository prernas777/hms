export enum RoomType {
    SINGLE, DOUBLE, SUITE
}

export enum AvailabilityStatus {
    AVAILABLE, BOOKED
}

export class Rooms
{
    roomId:number=0;
    roomNumber:number=0;
    roomType:RoomType | null = null;
    pricePerNight:number=0;
    availabilityStatus:AvailabilityStatus| null = null;
    capacity:string='';
    description:string='';
    hotelId:number=0;

}