import { Component, OnInit } from '@angular/core';
import { MeetupService } from '../meetup.service';
import { UserService } from '../user.service';
import { Subscription } from 'rxjs';


@Component({
  selector: 'app-hosted-matches',
  templateUrl: './hosted-matches.component.html',
  styleUrls: ['./hosted-matches.component.css']
})
export class HostedMatchesComponent implements OnInit {
  subscription:Subscription=new Subscription();
  currentUserId=-1;
  hosted:any;

  constructor(private userService:UserService, private meetUpService:MeetupService) { }

  ngOnInit(): void {
    this.subscription = this.userService.currentUser.subscribe(userID =>{
      this.currentUserId = userID;
      this.meetUpService.getUserHostedtUps(userID).subscribe((data)=>{
        this.hosted=data;
        console.log(this.hosted)
      });
    });
  }

}
