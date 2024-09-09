import {Component} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {AddPermissionComponent} from "../modals/add-permission/add-permission.component";
import {Observable} from "rxjs";
import {Permission} from "../model/permission";
import {CreatePermissionDto} from "../dto/create-permission-dto";
import {PermissionsService} from "../services/permissions.service";

@Component({
  selector: 'app-permissions',
  standalone: true,
  imports: [],
  templateUrl: './permissions.component.html',
  styleUrl: './permissions.component.css'
})
export class PermissionsComponent {
  permissions: Permission[] = [];
  constructor(private matDialog: MatDialog, private permissionService: PermissionsService) {
  }

  addPermission() {
    const addPermissionDialog = this.matDialog.open(AddPermissionComponent, {});

    addPermissionDialog.afterClosed()
      .subscribe((data: CreatePermissionDto) => {
        this.permissionService.create(data.permissionName)
          .subscribe(responseData => {
            this.permissions.push(responseData);
          });
      });
  }
}
