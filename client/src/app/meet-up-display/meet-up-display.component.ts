import { Component, OnInit } from '@angular/core';
import { MeetupService } from '../meetup.service';
import { UserService } from '../user.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-meet-up-display',
  templateUrl: './meet-up-display.component.html',
  styleUrls: ['./meet-up-display.component.css']
})
export class MeetUpDisplayComponent implements OnInit {
  matches:any;
  reservedMatch:any;
  currentUserId=-1;
  subscription:Subscription=new Subscription();
  constructor(private meetUpService:MeetupService,private userService:UserService) { }

  ngOnInit(): void {
    this.subscription = this.userService.currentUser.subscribe(userID => this.currentUserId = userID)
  }

  onRefresh():void{
    this.meetUpService.getMeetUps()
    .subscribe((data)=>{
    this.matches=data;
    console.log(data)});
  }

  onReserve(id:number):void{
    console.log('reservation pour le match : '+id
    +'\n pour le user : '+this.currentUserId );
    var content={"id":0};
    content.id=this.currentUserId;
    this.meetUpService.addGuest(id,content)
    .subscribe((data)=>{
      console.log(data)});
  }
  

}
