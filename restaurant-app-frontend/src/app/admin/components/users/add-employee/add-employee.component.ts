import {Component} from '@angular/core';
import {MatDialogContent} from "@angular/material/dialog";
import {AbstractControl, FormControl, FormGroup, ValidatorFn} from "@angular/forms";

function validatePasswordConfirmation(): ValidatorFn {
  return (control: AbstractControl) => {
    const password = control.get('password')?.value;
    const confirmPassword = control.get('confirmPassword')?.value;

    return password === confirmPassword ? null: {passwordMismatch: true};
  }
}

function isValidPesel() {
  return (control : AbstractControl) => {
    const pesel: string = control.get('pesel')?.value;

    if(!pesel){
      return {invalidPassword: true};
    }

    const hasOnlyDigits = /^\d+$/.test(pesel);
    const hasLengthEqual11 = pesel.length === 11;

    return hasOnlyDigits && hasLengthEqual11 ? null : {invalidPassword: true};
  };
}

@Component({
  selector: 'app-add-employee',
  standalone: true,
  imports: [
    MatDialogContent
  ],
  templateUrl: './add-employee.component.html',
  styleUrl: './add-employee.component.css'
})
export class AddEmployeeComponent {
  formGroup: FormGroup = new FormGroup({
    personalDetails: new FormGroup({
      firstName: new FormControl<string>(''),
      surname: new FormControl<string>(''),
      email: new FormControl<string>(''),
      password: new FormControl<string>(''),
      confirmPassword: new FormControl<string>('', {
        validators: [
          validatePasswordConfirmation()
        ]
      })
    }),
    pesel: new FormControl<string>('', {
      validators: [
        isValidPesel()
      ]
    }),
    hourlyRate: new FormControl<string>(''),
    roles: new FormControl<string[]>([])
  });
}
