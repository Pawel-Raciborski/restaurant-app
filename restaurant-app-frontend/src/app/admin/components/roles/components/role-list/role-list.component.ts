import {Component, Input, OnInit} from '@angular/core';
import {Role} from "../../model/role";

@Component({
  selector: 'app-role-list',
  standalone: true,
  imports: [],
  templateUrl: './role-list.component.html',
  styleUrl: './role-list.component.css'
})
export class RoleListComponent implements OnInit{
  @Input({required: true}) roles!: Role[];
  lastLoadedPageSize: number = 0;
  ngOnInit(): void {
    this.lastLoadedPageSize = this.roles.length;
  }

  loadMore() {

  }
}
