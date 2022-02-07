import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-forgot-pswd-page',
  templateUrl: './forgot-pswd-page.component.html',
  styleUrls: ['./forgot-pswd-page.component.css']
})
export class ForgotPswdPageComponent implements OnInit {
  retrieveForm:FormGroup=new FormGroup({
    email:new FormControl('')
  })
  constructor() { }

  ngOnInit(): void {
  }

  onRetrieve():void{
    alert("email de recuperation a implementer \n envoie a l'adresse : " +this.retrieveForm.value.email)
  }
}
