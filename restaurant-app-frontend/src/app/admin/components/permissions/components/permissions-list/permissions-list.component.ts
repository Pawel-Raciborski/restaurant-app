import {Component, input, Input, OnInit} from '@angular/core';
import {Permission} from "../../model/permission";
import {PermissionsService} from "../../services/permissions.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-permissions-list',
  standalone: true,
  imports: [],
  templateUrl: './permissions-list.component.html',
  styleUrl: './permissions-list.component.css'
})
export class PermissionsListComponent{
  @Input() page = 1;
  @Input() pageSize = 10;
  @Input({required: true}) permissions!: Permission[];
  lastLoadedPageSize = 10;

  constructor(private permissionService: PermissionsService) {}

  loadMore() {
    this.permissionService.findAllPaged(this.page, this.pageSize).subscribe(data => {
      this.permissions.push(...data);
      this.lastLoadedPageSize = data.length;
      this.incrementPage();
    })
  }

  private incrementPage() {
    console.log(this.lastLoadedPageSize);
    if(this.lastLoadedPageSize == 10){
      this.page++;
    }
  }
}
