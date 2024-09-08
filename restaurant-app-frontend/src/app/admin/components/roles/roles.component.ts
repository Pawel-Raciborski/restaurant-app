import { Component } from '@angular/core';
import {PermissionsComponent} from "../permissions/permissions/permissions.component";

@Component({
  selector: 'app-roles',
  standalone: true,
  imports: [
    PermissionsComponent
  ],
  templateUrl: './roles.component.html',
  styleUrl: './roles.component.css'
})
export class RolesComponent {

}
