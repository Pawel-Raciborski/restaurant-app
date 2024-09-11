import {Component, viewChild, ViewChild} from '@angular/core';
import {FormGroup, FormsModule, NgForm} from "@angular/forms";
import {
  MatDialogActions,
  MatDialogContainer,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
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
  constructor(private currentModal: MatDialogRef<AddPermissionComponent>) {
  }
  onPermissionFormSubmit(permissionForm: NgForm): void {
    if(!permissionForm.valid){
      return;
    }else {
      this.currentModal.close(permissionForm.value);
    }
  }

  closeModal() {
    this.currentModal.close();
  }
}
