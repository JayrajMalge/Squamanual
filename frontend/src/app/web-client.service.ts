import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../environments/environment.development';
import { firstValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WebClientService {

  TOKEN='';

  constructor(private http:HttpClient) { }

  public get<T>(url:string)
  {
    return this.http.get<T>(environment.API_ENDPOINT+url,{headers:{TOKEN:this.TOKEN}});
  }
  
  public delete<T>(url:string)
  {
    return this.http.delete<T>(environment.API_ENDPOINT+url,{headers:{TOKEN:this.TOKEN}});
  }
  
  public post<T,R>(url:string, data:T)
  {
    return this.http.post<R>(environment.API_ENDPOINT+url,data,{headers:{TOKEN:this.TOKEN}});
  }

  
  public put<T,R>(url:string, data:T)
  {
    return this.http.put<R>(environment.API_ENDPOINT+url,data,{headers:{TOKEN:this.TOKEN}});
  }

}
