import {Component, Inject, Input, OnInit} from '@angular/core';
import {Role} from "../../../model/role";
import {RoleService} from "../../../services/role.service";
import {constants} from "../../../../../../../constants/constants";
import {AddPermissionsToRoleComponent} from "../add-permissions-to-role/add-permissions-to-role.component";
import {Permission} from "../../../../permissions/model/permission";
import {HttpStatusCode} from "@angular/common/http";

@Component({
  selector: 'app-role-permissions',
  standalone: true,
  imports: [
    AddPermissionsToRoleComponent
  ],
  templateUrl: './role-permissions.component.html',
  styleUrl: './role-permissions.component.css'
})
export class RolePermissionsComponent implements OnInit {
  @Input({required: true}) role!: Role;
  rolePermissionNames: string[] = [];
  page= 0;
  pageSize= constants.defaultSize;
  lastLoadedPageSize = 0;
  clicked = false;
  constructor(private roleService: RoleService) {
  }

  ngOnInit(): void {
        this.roleService.getRolePermissions(this.role,this.page,this.pageSize)
          .subscribe(rolePermissionsName => {
            this.rolePermissionNames.push(...rolePermissionsName);
            this.lastLoadedPageSize = rolePermissionsName.length;
            this.incrementPage();
        })
  }

  private incrementPage() {
    if(this.lastLoadedPageSize == this.pageSize){
      this.page++;
    }
  }

  showPermissions() {
    this.clicked = true;
  }

  addPermissions(permissions:Permission[]) {
    let permissionsToAdd = permissions.map(p => p.name);

    this.roleService.assignPermissionsToRole(permissionsToAdd,this.role)
      .subscribe(createdRolePermissions => {
        this.rolePermissionNames.push(...createdRolePermissions.permissionNames);
      });
    this.clicked = false;
  }

  removePermission(rolePermissionName: string) {
    this.roleService.removeRolePermission(rolePermissionName,this.role).subscribe(httpResponse => {
      if(httpResponse.status === HttpStatusCode.Ok){
        this.rolePermissionNames = this.rolePermissionNames.filter(p => p !== rolePermissionName);
      }
    })
  }
}
