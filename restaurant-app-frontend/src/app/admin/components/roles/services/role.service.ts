import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {environment} from "../../../../../environment/environment";
import {Role} from "../model/role";
import {GenericHttpClientService} from "../../../../services/generic-http-client.service";
import {PermissionsService} from "../../permissions/services/permissions.service";
import {RolePermissions} from "../model/role-permissions";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RoleService {
  private roles: string = "/roles";
  private rolePermissions: string = "/role/permissions";

  constructor(
    private httpClient: HttpClient,
    private genericHttpClientService: GenericHttpClientService,
  ) {
  }


  create(roleName: string) {
    return this.httpClient.post<Role>(
      `${environment.apiUrl}${this.roles}/create`,
      {},
      {
        params: {
          roleName: roleName
        }
      }
    )
  }

  getFirstPage() {
    return this.genericHttpClientService.getPagedList<Role>(0, 10, this.roles);
  }

  getPagedRoles(page: number, pageSize: number) {
    return this.genericHttpClientService.getPagedList<Role>(page, pageSize, this.roles);
  }

  getRolePermissions(role: Role, page: number, pageSize: number) {
    return this.httpClient.get<string[]>(
      `${environment.apiUrl}${this.rolePermissions}`,
      {
        params: {
          page: page,
          pageSize: pageSize,
          roleName: role.name
        }
      }
    );
  }

  assignPermissionsToRole(permissionNames: string[], role: Role) {
    let rolePermissionsDto: RolePermissions = {
      roleName: role.name,
      permissionNames: permissionNames
    };

    return this.httpClient.post<RolePermissions>(
      `${environment.apiUrl}${this.rolePermissions}`,
      rolePermissionsDto
    );
  }

  removeRolePermission(rolePermissionName: string, role: Role): Observable<HttpResponse<void>> {
    return this.httpClient.delete<void>(
      `${environment.apiUrl}${this.rolePermissions}`,
      {
        params: {
          permissionName: rolePermissionName,
          roleName: role.name
        },
        observe: 'response'
      }
    )
  }
}
