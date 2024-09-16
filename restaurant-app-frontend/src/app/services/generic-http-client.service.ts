import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environment/environment";

@Injectable({
  providedIn: 'root'
})
export class GenericHttpClientService {

  constructor(private http: HttpClient) { }

  getPagedList<T>(page:number,pageSize:number,endpoint: string){
    return this.http.get<T[]>(
      `${environment.apiUrl}${endpoint}`,
      {
        params: {
          page: page,
          pageSize: pageSize
        },
      }
    );
  }

}
