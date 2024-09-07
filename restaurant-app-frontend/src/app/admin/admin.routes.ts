import {Routes} from "@angular/router";
import {AdminPanelComponent} from "./components/admin/admin-panel/admin-panel.component";
import {EmployeesComponent} from "./components/users/employees/employees.component";
import {RolesComponent} from "./components/roles/roles.component";
import {ClientsComponent} from "./components/clients/clients.component";
import {ReportsComponent} from "./components/reports/reports.component";

export const adminRoutes: Routes = [
  {
    path: 'employees',
    component: EmployeesComponent
  },
  {
    path: 'roles',
    component: RolesComponent
  },
  {
    path: 'clients',
    component: ClientsComponent
  },
  {
    path: 'reports',
    component: ReportsComponent
  }
];
