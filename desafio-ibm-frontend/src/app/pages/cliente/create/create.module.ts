import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreateRoutingModule } from './create-routing.module';
import { NgxMaskDirective, NgxMaskPipe, provideNgxMask } from 'ngx-mask';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    CreateRoutingModule,
    NgxMaskDirective, 
    NgxMaskPipe,
  ],
  providers: [provideNgxMask()]
})
export class CreateModule { }
