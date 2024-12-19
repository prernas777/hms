
export enum UserRole {
   GUEST='GUEST',
   HOTELOWNER='HOTELOWNER' , 
   ADMIN='ADMIN'
  }
  
  export class Users
  {
      userId:number=0;
      email:string='';
      password:string='';
      name:string='';
      phoneNumber:number=0;
      dateCreated:Date=new Date() ;
      userRole: string='';
      updatedAt:Date=new Date();
  }