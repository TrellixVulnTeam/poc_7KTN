import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MeetupService {
  MeetUpsUrl="http://localhost:8080/meetups";
  addGuestUrl="http://localhost:8080/addGuest?id=";
  getHostedMeetUpUrl="http://localhost:8080/hostedMeetup?id=";
  getSameCityMeetUpUrl="http://localhost:8080/sameCityMeetUp?location=";

  constructor(private http: HttpClient) {}
  getMeetUps(){
    return this.http.get<any>(this.MeetUpsUrl)
  }

  createMeetUp(id:any,infos:any){
    var parametedUrl=this.MeetUpsUrl+'?id='+id;
    return this.http.post<any>(parametedUrl,infos);
  }

  getMeetUpById(id:any){
    return this.http.get<any>(this.MeetUpsUrl,{params:{id}})
  }

  addGuest(meetUpId:any,guestId:any){
    var parametedUrl =this.addGuestUrl+meetUpId;
    return this.http.put<any>(parametedUrl,guestId);
  }

  getUserHostedtUps(userId:any){
    var parametedUrl =this.getHostedMeetUpUrl+userId;
    return this.http.get<any>(parametedUrl);
  }

  getSameCityMeetUps(location:any){
    var parametedUrl =this.getSameCityMeetUpUrl+location;
    return this.http.get<any>(parametedUrl);
  }


}
