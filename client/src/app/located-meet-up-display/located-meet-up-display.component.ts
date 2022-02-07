import { Component, OnInit } from '@angular/core';
import { MeetupService } from '../meetup.service';
import { UserService } from '../user.service';
import { Subscription } from 'rxjs';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-located-meet-up-display',
  templateUrl: './located-meet-up-display.component.html',
  styleUrls: ['./located-meet-up-display.component.css']
})
export class LocatedMeetUpDisplayComponent implements OnInit {
  near:any;
  subscription:Subscription=new Subscription();
  currentUserId=-1;
  address="";
  user:any;
  constructor(private userService:UserService,private meetUpService:MeetupService,private accountService:AccountService) { }

  ngOnInit(): void {
    this.subscription = this.userService.currentUser.subscribe(userID =>{
      this.currentUserId = userID;
      this.accountService.getUser(this.currentUserId).subscribe((data)=>{
        this.user=data;
        this.address=this.user.address
        console.log(this.user)
        console.log(this.address)
        this.meetUpService.getSameCityMeetUps(this.address).subscribe((data)=>{
          this.near=data;
          console.log(this.near)
        });
      })
      
    });
  }

}
