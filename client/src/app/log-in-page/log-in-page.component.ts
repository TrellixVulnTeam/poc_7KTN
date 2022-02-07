import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AccountService } from '../account.service';
import { UserService } from '../user.service';
import { Subscription } from 'rxjs';
import * as bcrypt from 'bcryptjs';

@Component({
  selector: 'app-log-in-page',
  templateUrl: './log-in-page.component.html',
  styleUrls: ['./log-in-page.component.css']
})
export class LogInPageComponent implements OnInit {
  currentUserId=-1;
  subscription:Subscription=new Subscription();
  loginForm:FormGroup =new FormGroup({
    email:new FormControl(''),
    pswd:new FormControl('')
    
  })
  showPswd:String='password';
  constructor(private accountService:AccountService, private userService:UserService) {
   }

  ngOnInit(): void {
    this.subscription = this.userService.currentUser.subscribe(userID => this.currentUserId = userID)
 
  }
  onShowPswd():void{
    if(this.showPswd=='password'){
      this.showPswd='text';
    }
    else{
      this.showPswd='password';
    }
    console.log(this.showPswd);
  }
  onConnect():void{
    var email=this.loginForm.value.email;
    var pswd=this.loginForm.value.pswd;
    console.log('attempting to connect with email : ' +email + 'and pswd : '+pswd);
    //var hashed=bcrypt.hashSync(pswd);
    
    
    this.accountService.connect(email,pswd)
    .subscribe((data:any) =>  {
    
      this.userService.changeUser(data)
    
    console.log(this.currentUserId);
    alert('vous êtes connecté ! votre userID : ' +this.currentUserId);
    });

  };

  onNewAccnt():void{
    console.log('clic sur le bouton new account')
  }

  onFrgtPswd():void{
    console.log('clic sur le bouton forgot password')
  }
}
