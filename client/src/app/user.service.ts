import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private userSource = new BehaviorSubject(-1);
  currentUser = this.userSource.asObservable();
  constructor() { }
  changeUser(userID: number) {
    console.log(userID)
    this.userSource.next(userID)
  }
  
}
