import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EditRoutingModule } from './edit-routing.module';
import { NgxMaskDirective, NgxMaskPipe, provideNgxMask } from 'ngx-mask';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    EditRoutingModule,
    NgxMaskDirective, 
    NgxMaskPipe,

  ],
  providers: [provideNgxMask()]
})
export class EditModule { }
