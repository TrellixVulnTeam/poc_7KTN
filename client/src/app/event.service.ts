import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EventService {
  getEventsUrl=""
  getEventsLightUrl=""
  getEventsDetailUrl=""
  constructor(private http: HttpClient) { }

  getEvents(){
    return this.http.get<any>(this.getEventsUrl);
  }
  
  getEventsLight(){
    return this.http.get<any>(this.getEventsLightUrl);
  }

  getEventDetail(id:any){
    return this.http.get<any>(this.getEventsDetailUrl,{params:{id}});
  }
}
