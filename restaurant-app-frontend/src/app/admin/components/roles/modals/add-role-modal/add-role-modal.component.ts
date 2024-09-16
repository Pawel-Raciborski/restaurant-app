import { Component } from '@angular/core';
import {FormsModule, NgForm, ReactiveFormsModule} from "@angular/forms";
import {MatDialogContent, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-add-role-modal',
  standalone: true,
    imports: [
        FormsModule,
        MatDialogContent,
        ReactiveFormsModule
    ],
  templateUrl: './add-role-modal.component.html',
  styleUrl: './add-role-modal.component.css'
})
export class AddRoleModalComponent {

  constructor(private currentModal: MatDialogRef<AddRoleModalComponent>) {
  }

  onRoleFormSubmit(roleForm: NgForm) {
    if(roleForm.valid){
      this.currentModal.close(
        roleForm.value
      );
    }
  }

  closeModal() {
    this.currentModal.close();
  }
}
