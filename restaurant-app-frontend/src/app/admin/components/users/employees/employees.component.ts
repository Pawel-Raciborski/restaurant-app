import { Component } from '@angular/core';
import {RouterLink} from "@angular/router";
import {MatDialog} from "@angular/material/dialog";
import {AddEmployeeComponent} from "../add-employee/add-employee.component";

@Component({
  selector: 'app-employees',
  standalone: true,
  imports: [
    RouterLink
  ],
  templateUrl: './employees.component.html',
  styleUrl: './employees.component.css'
})
export class EmployeesComponent {

  constructor(private dialog: MatDialog) {
  }
  addEmployee() {
    this.dialog.open(AddEmployeeComponent);
  }
}
