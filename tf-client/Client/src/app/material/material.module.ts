import { NgModule } from '@angular/core';
import {MatButtonModule, MatToolbarModule, MatIconModule, MatCardModule, MatFormFieldModule, MatInputModule, MatCheckboxModule} from '@angular/material';


const materials = [
  MatButtonModule,
  MatToolbarModule,
  MatIconModule,
  MatCardModule,
  MatFormFieldModule,
  MatInputModule,
  MatCheckboxModule
];

@NgModule({
  imports: [materials],
  exports: [materials]
})
export class MaterialModule { }
