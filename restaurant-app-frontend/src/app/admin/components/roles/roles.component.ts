import { Component } from '@angular/core';
import {PermissionsViewComponent} from "../permissions/components/permissions/permissions-view.component";
import {RolesViewComponent} from "./components/roles/roles-view.component";

@Component({
  selector: 'app-roles',
  standalone: true,
  imports: [
    PermissionsViewComponent,
    RolesViewComponent
  ],
  templateUrl: './roles.component.html',
  styleUrl: './roles.component.css'
})
export class RolesComponent {

}
