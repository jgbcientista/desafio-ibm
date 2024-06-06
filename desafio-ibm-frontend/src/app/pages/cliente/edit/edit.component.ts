import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { FormGroup, FormBuilder } from '@angular/forms';
import { Cliente } from '../../../modelos/cliente.model';
import { ClienteService } from '../../../services/cliente.service';
import { Extrato } from '../../../modelos/extrato.model';

 @Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css'],
})
export class EditComponent implements OnInit {

  id!: number;
  cliente!: Cliente;
  extrato!: Extrato;
  submitted = false;
  messageErro = '';
  loaded = false;

  constructor(
    public service: ClienteService,
    private route: ActivatedRoute,
    private router: Router,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.extrato = {}
    this.id = this.route.snapshot.params['postId'];

    if (this.id) {
      this.loadObjetoById(this.id);
    }
  }

  loadObjetoById(id: number) {
    this.loaded = true;

    this.service.find(id).subscribe((data: Cliente) => {
      this.cliente = data;
      this.loaded = false;
    });
  }

 debitar(): void {
    this.loaded = true;
    this.submitted = true;
   
    if (!this.extrato.valor) {
      alert('Informe o valor que deseja debitar.')
      this.loaded = false;
      return;
    }

    this.extrato.operacao ='debitar';
    this.service.creditarDebitar(this.id, this.extrato).subscribe({
      next: (response) => {
          this.submitted = true;
          this.loaded = false;
          this.ngOnInit();
          this.router.navigateByUrl('/cliente/' + this.id +  '/edit');   
      },
      error: (e) => {
        this.messageErro = 'Erro ao processar. ';
        this.loaded = false
      }
    });
  }
 
  creditar(): void {
 
    this.loaded = true;
    this.submitted = true;
 
    if (!this.extrato.valor) {
      alert('Informe o valor que deseja creditar.')
      this.loaded = false;
      return;
    }

    this.extrato.operacao ='creditar';
    this.service.creditarDebitar(this.id, this.extrato).subscribe({
      next: (response) => {
          this.submitted = true;
          this.loaded = false;
          this.ngOnInit();
          this.router.navigateByUrl('/cliente/' + this.id +  '/edit');    
      },
      error: (e) => {
        this.messageErro = 'Erro ao processar. ';
        this.loaded = false
      }
    });
  }

}
