import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class AccountService {
  connectUrl="http://localhost:8080/login";
  signUpUrl="http://localhost:8080/signup"
  getUserUrl="http://localhost:8080/users"
  constructor(private http: HttpClient) { }
  
  connect(email:any,password:any){
    var parameted_url=this.connectUrl+'?email='+email+'&password='+password;
    
    return this.http.get(<any>(parameted_url));
  }

  signup(formContent:any){
    console.log('envoie de la requete avec les infos '+ formContent)
    return this.http.post(<any>(this.signUpUrl),formContent);
  }

  getUser(id:any){
    var parameted_url=this.getUserUrl+'/'+id;
    console.log('chargement du profile avec les infos '+ id)
    return this.http.get(<any>(parameted_url));
  }
}
