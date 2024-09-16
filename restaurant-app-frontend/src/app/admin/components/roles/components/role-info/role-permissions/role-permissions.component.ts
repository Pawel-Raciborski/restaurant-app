import {Component, Inject, Input, OnInit} from '@angular/core';
import {Role} from "../../../model/role";
import {RoleService} from "../../../services/role.service";
import {constants} from "../../../../../../../constants/constants";
import {AddPermissionsToRoleComponent} from "../add-permissions-to-role/add-permissions-to-role.component";
import {Permission} from "../../../../permissions/model/permission";

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
  rolePermissionsName: string[] = [];
  page= 0;
  pageSize= constants.defaultSize;
  lastLoadedPageSize = 0;
  clicked =false;
  constructor(private roleService: RoleService) {
  }

  ngOnInit(): void {
        this.roleService.getRolePermissions(this.role,this.page,this.pageSize)
          .subscribe(rolePermissionsName => {
            this.rolePermissionsName.push(...rolePermissionsName);
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

    // TODO add httpClient
    console.log(permissionsToAdd);
    this.clicked = false;
  }
}
