import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../../../environment/environment";
import {Role} from "../model/role";
import {GenericHttpClientService} from "../../../../services/generic-http-client.service";

@Injectable({
  providedIn: 'root'
})
export class RoleService {
  private endpoint: string = "/roles";

  constructor(private httpClient: HttpClient, private genericHttpClientService: GenericHttpClientService) { }


  create(roleName: string) {
    return this.httpClient.post<Role>(
      `${environment.apiUrl}${this.endpoint}/create`,
      {},
      {
        params: {
          roleName: roleName
        }
      }
    )
  }

  getFirstPage() {
    return this.genericHttpClientService.getPagedList<Role>(0,10,this.endpoint);
  }
}
