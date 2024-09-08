import { Component } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {AddPermissionComponent} from "../modals/add-permission/add-permission.component";

@Component({
  selector: 'app-permissions',
  standalone: true,
  imports: [],
  templateUrl: './permissions.component.html',
  styleUrl: './permissions.component.css'
})
export class PermissionsComponent {

  constructor(private matDialog: MatDialog) {
  }
  addPermission() {
    const addPermissionDialog = this.matDialog.open(AddPermissionComponent, {});

    addPermissionDialog.afterClosed()
      .subscribe(data => console.log(data));
  }
}
