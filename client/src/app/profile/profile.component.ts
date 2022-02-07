import { Component, OnInit } from '@angular/core';
import { EmailValidator } from '@angular/forms';
import { UserService } from '../user.service';
import { Subscription } from 'rxjs';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  currentUserId=-1;
  currentUser:any;
  subscription:Subscription=new Subscription();
  constructor(private userService:UserService,private accountService:AccountService) { 
  }
   

  ngOnInit(): void {
    this.subscription = this.userService.currentUser
    .subscribe((userID) => {
      this.currentUserId = userID
      this.accountService.getUser(this.currentUserId)
        .subscribe((user)=>{
        this.currentUser=user;
        console.log(user)
      })
    })
  }  
}
