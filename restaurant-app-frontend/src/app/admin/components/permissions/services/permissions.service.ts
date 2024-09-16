import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../../../environment/environment";
import {Permission} from "../model/permission";
import {Observable} from "rxjs";
import {GenericHttpClientService} from "../../../../services/generic-http-client.service";

@Injectable({
  providedIn: 'root'
})
export class PermissionsService {
  private endpoint: string = '/permissions';

  constructor(private httpClient: HttpClient, private genericHttpClientService: GenericHttpClientService) {
  }

  create(permissionName: string): Observable<Permission> {
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
    return this.genericHttpClientService.getPagedList<Permission>(0, 10, this.endpoint);
  }

  findAllPaged(page: number, pageSize: number) {
    return this.genericHttpClientService.getPagedList<Permission>(page, pageSize, this.endpoint);
  }
}
