import {Routes} from '@angular/router';
import {adminRoutes} from "./admin/admin.routes";
import {AdminPanelComponent} from "./admin/components/admin/admin-panel/admin-panel.component";
import {EmployeeComponent} from "./admin/components/users/employee/employee.component";

export const routes: Routes = [
  {
    path: 'admin-panel',
    component: AdminPanelComponent,
    children: adminRoutes
  },
  {
    path: 'employee/:id',
    component: EmployeeComponent
  }
];
