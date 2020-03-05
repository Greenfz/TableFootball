import { NgModule } from '@angular/core';
import {MatButtonModule, MatToolbarModule, MatIconModule, MatCardModule, MatTooltipModule, MatTabsModule ,MatOptionModule, MatSelectModule, 
    MatInputModule, MatCheckboxModule, MatDividerModule, MatListModule} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field'; 

const materials = [
  MatButtonModule,
  MatToolbarModule,
  MatIconModule,
  MatCardModule,
  MatFormFieldModule,
  MatInputModule,
  MatCheckboxModule,
  MatDividerModule,
  MatListModule,
  MatTooltipModule,
  MatTabsModule,
  BrowserAnimationsModule,
  FormsModule,
  ReactiveFormsModule,
  MatOptionModule,
  MatSelectModule
];

@NgModule({
  imports: [materials],
  exports: [materials]
})
export class MaterialModule { }
