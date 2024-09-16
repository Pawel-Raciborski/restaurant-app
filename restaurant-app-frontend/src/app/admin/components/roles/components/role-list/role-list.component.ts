import {Component, Input, OnInit} from '@angular/core';
import {Role} from "../../model/role";
import {RoleService} from "../../services/role.service";
import {constants} from "../../../../../../constants/constants";
import {MatDialog} from "@angular/material/dialog";
import {RoleInfoComponent} from "../../modals/role-info/role-info.component";

@Component({
  selector: 'app-role-list',
  standalone: true,
  imports: [],
  templateUrl: './role-list.component.html',
  styleUrl: './role-list.component.css'
})
export class RoleListComponent implements OnInit{
  @Input({required: true}) roles!: Role[];
  page= 1;
  pageSize = constants.defaultSize;
  lastLoadedPageSize: number = 0;

  constructor(
    private roleService: RoleService,
    private dialog: MatDialog
  ) {
  }

  ngOnInit(): void {
    this.lastLoadedPageSize = this.roles.length;
  }

  loadMore() {
    this.roleService.getPagedRoles(this.page,this.pageSize).subscribe(data => {
      this.roles.push(...data);
      this.lastLoadedPageSize = data.length;
    });
  }

  showMoreInfo(role: Role) {
    this.dialog.open(RoleInfoComponent,{
      data: role,
    });
  }
}
