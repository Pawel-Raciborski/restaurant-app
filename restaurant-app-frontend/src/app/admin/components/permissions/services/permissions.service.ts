import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../../../environment/environment";
import {Permission} from "../model/permission";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PermissionsService {
  private endpoint: string = '/permissions';

  constructor(private httpClient: HttpClient) {}

  create(permissionName: string): Observable<Permission>{
    return this.httpClient.post<Permission>(
      `${environment.apiUrl}${this.endpoint}/create`,
      {},
      {
        params: {
          name: permissionName
        }
      }
    );
  }

  getFirstPage(): Observable<Permission[]> {
    return this.findAllPaged(0,10);
  }

  findAllPaged(pageNumber: number, pageSize: number): Observable<Permission[]> {
    return this.httpClient.get<Permission[]>(
      `${environment.apiUrl}${this.endpoint}`,
      {
        params: {
          page: pageNumber,
          pageSize: pageSize
        }
      }
    )
  }
}
