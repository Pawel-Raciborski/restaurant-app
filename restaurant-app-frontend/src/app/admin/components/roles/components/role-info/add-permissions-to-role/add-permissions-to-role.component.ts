import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Permission} from "../../../../permissions/model/permission";
import {PermissionsService} from "../../../../permissions/services/permissions.service";

@Component({
  selector: 'app-add-permissions-to-role',
  standalone: true,
  imports: [],
  templateUrl: './add-permissions-to-role.component.html',
  styleUrl: './add-permissions-to-role.component.css'
})
export class AddPermissionsToRoleComponent implements OnInit{
  availablePermissions: Permission[] = [];
  selectedPermissions: Permission[] = [];
  @Output() selectedPermissionsEmitter: EventEmitter<Permission[]> = new EventEmitter<Permission[]>();
  @Input({required:true}) assignedPermissionNames!: string[];
  page=0;
  pageSize= 10;
  lastLoadedPageSize= 0;

  constructor(private permissionService: PermissionsService) {}

  ngOnInit(): void {
        this.permissionService.findAllPaged(this.page,this.pageSize).subscribe(respData => {
          respData = this.filterData(respData);
          this.availablePermissions.push(...respData);
          this.lastLoadedPageSize = respData.length;
          this.incrementPage();
        })
    }

  private filterData(permissions: Permission[]) {
    return permissions.filter(p => !this.assignedPermissionNames.includes(p.name));
  }

  private incrementPage() {
    if(this.lastLoadedPageSize === this.pageSize){
      this.page++;
    }
  }

  addToSelected(permission: Permission) {
    this.availablePermissions = this.availablePermissions.filter(p => p !== permission);
    this.selectedPermissions.push(permission);
  }

  removeFromSelected(permissionToRemove: Permission) {
    this.selectedPermissions = this.selectedPermissions.filter(p => p !== permissionToRemove);
    this.availablePermissions.push(permissionToRemove);
  }

  addSelected() {
    this.selectedPermissionsEmitter.emit(this.selectedPermissions);
  }
}
