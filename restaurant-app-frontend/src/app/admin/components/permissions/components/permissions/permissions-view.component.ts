import {Component, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {AddPermissionComponent} from "../../modals/add-permission/add-permission.component";
import {Observable} from "rxjs";
import {Permission} from "../../model/permission";
import {CreatePermissionDto} from "../../dto/create-permission-dto";
import {PermissionsService} from "../../services/permissions.service";
import {PermissionsListComponent} from "../permissions-list/permissions-list.component";

@Component({
  selector: 'app-permissions',
  standalone: true,
  imports: [
    PermissionsListComponent
  ],
  templateUrl: './permissions-view.component.html',
  styleUrl: './permissions-view.component.css'
})
export class PermissionsViewComponent implements OnInit {
  permissions: Permission[] = [];

  constructor(private matDialog: MatDialog, private permissionService: PermissionsService) {
  }

  ngOnInit(): void {
    this.permissionService.getFirstPage().subscribe(data => {
      this.permissions = data;
    });
  }

  addPermission() {
    const addPermissionDialog = this.matDialog.open(AddPermissionComponent, {});

    addPermissionDialog.afterClosed()
      .subscribe((data: CreatePermissionDto) => {
        if (data) {
          this.permissionService.create(data.permissionName)
            .subscribe(responseData => {
              this.permissions.push(responseData);
            });
        }
      });
  }
}
