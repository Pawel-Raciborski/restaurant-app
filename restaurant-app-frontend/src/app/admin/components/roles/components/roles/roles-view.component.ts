import {Component, OnInit} from '@angular/core';
import {Role} from "../../model/role";
import {PermissionsListComponent} from "../../../permissions/components/permissions-list/permissions-list.component";
import {RoleService} from "../../services/role.service";
import {MatDialog} from "@angular/material/dialog";
import {AddRoleModalComponent} from "../../modals/add-role-modal/add-role-modal.component";
import {AddRole} from "../../model/add-role";
import {RoleListComponent} from "../role-list/role-list.component";

@Component({
  selector: 'app-roles-view',
  standalone: true,
  imports: [
    PermissionsListComponent,
    RoleListComponent
  ],
  templateUrl: './roles-view.component.html',
  styleUrl: './roles-view.component.css'
})
export class RolesViewComponent implements OnInit{
  roles : Role[] = [];

  constructor(private roleService: RoleService, private matDialog: MatDialog) {
  }

  ngOnInit(): void {
        this.roleService.getFirstPage().subscribe(roles => {
          this.roles.push(...roles);
        })
    }

  addRole() {
    let openDialog = this.matDialog.open(AddRoleModalComponent);

    openDialog.afterClosed().subscribe((role: AddRole) => {
      if(role){
        this.roleService.create(role.roleName).subscribe(createdRole => {
          this.roles.push(createdRole);
        })
      }
    });
    console.log(this.roles);
  }
}
