import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogContent} from "@angular/material/dialog";
import {Role} from "../../model/role";
import {RoleService} from "../../services/role.service";
import {RolePermissionsComponent} from "../../components/role-info/role-permissions/role-permissions.component";
import {PermissionsListComponent} from "../../../permissions/components/permissions-list/permissions-list.component";
import {PermissionsService} from "../../../permissions/services/permissions.service";
import {
  AddPermissionsToRoleComponent
} from "../../components/role-info/add-permissions-to-role/add-permissions-to-role.component";
import {Permission} from "../../../permissions/model/permission";

@Component({
  selector: 'app-role-info',
  standalone: true,
  imports: [
    MatDialogContent,
    RolePermissionsComponent,
    PermissionsListComponent,
    AddPermissionsToRoleComponent
  ],
  templateUrl: './role-info.component.html',
  styleUrl: './role-info.component.css'
})
export class RoleInfoComponent {
  clicked = false;
  constructor(
    @Inject(MAT_DIALOG_DATA) public role: Role,
    private roleService: RoleService,
    public permissionService: PermissionsService
  ) {

  }
}
