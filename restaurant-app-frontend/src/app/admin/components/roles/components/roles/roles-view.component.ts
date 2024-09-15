import { Component } from '@angular/core';
import {Role} from "../../model/role";
import {PermissionsListComponent} from "../../../permissions/components/permissions-list/permissions-list.component";

@Component({
  selector: 'app-roles-view',
  standalone: true,
  imports: [
    PermissionsListComponent
  ],
  templateUrl: './roles-view.component.html',
  styleUrl: './roles-view.component.css'
})
export class RolesViewComponent {
  roles : Role[] = [];

  constructor() {
  }

  addRole() {

  }
}
