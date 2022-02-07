import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators,  } from '@angular/forms';
import { MeetupService } from '../meetup.service';
import { UserService } from '../user.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-meet-up-form',
  templateUrl: './meet-up-form.component.html',
  styleUrls: ['./meet-up-form.component.css']
})
export class MeetUpFormComponent implements OnInit {
  currentUserId=-1;
  subscription:Subscription=new Subscription();
  MeetUpForm:FormGroup =new FormGroup({
    date:new FormControl(''),
    firstTeam:new FormControl(''),
    secondTeam:new FormControl(''),
    location:new FormControl('')
  })

  constructor(private meetUpService: MeetupService,private userService:UserService) { }

  ngOnInit(): void {
    this.subscription = this.userService.currentUser.subscribe(userID => this.currentUserId = userID)
  }

  onMeetUp():void{
    this.meetUpService.createMeetUp(this.currentUserId,this.MeetUpForm.value)
    .subscribe((data)=>{
      console.log(data);
    })
  }



  
}