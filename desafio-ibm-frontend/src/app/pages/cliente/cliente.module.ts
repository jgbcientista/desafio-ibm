import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';[] 
import { NgxPaginationModule } from 'ngx-pagination';
import { ClienteRoutingModule } from './cliente-routing.module';
import { ListarComponent } from './list/list.component';
import { CreateComponent } from './create/create.component';
import { EditComponent } from './edit/edit.component';
import { NgxMaskDirective, NgxMaskPipe, provideNgxMask } from 'ngx-mask';
import { BrowserModule } from '@angular/platform-browser';

@NgModule({
  imports: [
    CommonModule,
    ClienteRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    NgxMaskDirective, 
    NgxMaskPipe,
    BrowserModule
      ],
  exports: [
    ListarComponent, CreateComponent, EditComponent
  ],
  declarations: [
    ListarComponent, CreateComponent, EditComponent
  ],
  providers: [
    CreateComponent, EditComponent, ClienteRoutingModule, provideNgxMask()
  ],
})
export class ClienteModule { }