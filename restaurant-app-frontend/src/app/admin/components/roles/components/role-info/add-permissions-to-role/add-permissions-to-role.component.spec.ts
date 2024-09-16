import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPermissionsToRoleComponent } from './add-permissions-to-role.component';

describe('AddPermissionsToRoleComponent', () => {
  let component: AddPermissionsToRoleComponent;
  let fixture: ComponentFixture<AddPermissionsToRoleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddPermissionsToRoleComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddPermissionsToRoleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
