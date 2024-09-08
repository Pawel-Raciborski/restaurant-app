import { Component } from '@angular/core';
import {FormGroup, FormsModule, NgForm} from "@angular/forms";
import {MatDialogActions, MatDialogContainer, MatDialogContent, MatDialogTitle} from "@angular/material/dialog";
import {MatButton} from "@angular/material/button";
import {MatFormField} from "@angular/material/form-field";

@Component({
  selector: 'app-add-permission',
  standalone: true,
  imports: [
    MatDialogContainer,
    MatDialogContent,
    FormsModule,
    MatDialogActions,
    MatButton,
    MatFormField,
    MatDialogTitle
  ],
  templateUrl: './add-permission.component.html',
  styleUrl: './add-permission.component.css'
})
export class AddPermissionComponent {
  onPermissionFormSubmit(permissionForm: NgForm) {
    console.log(permissionForm);
  }
}
