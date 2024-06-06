import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, Validators, FormBuilder} from '@angular/forms';
import { ClienteService } from '../../../services/cliente.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  form!: FormGroup;
  submitted = false;
  msgErro = false;
  msgSucesso = false;
  operacao = "Cadastro";
  infoErro = ''
  TITULO_PAGINA_CREATE = 'Ficha de cadastro de cliente';

  constructor(
    public service: ClienteService,
    private fb: FormBuilder,
    private router: Router
  ) { }


  ngOnInit(): void {
    this.nova();
  }

  get f(){
    return this.form.controls;
  }

  onSubmit(): void {
		this.submitted = true;
    if(this.form.invalid) {
      this.msgErro = true;
      this.infoErro = 'Todos os campos são de preenchimento obrigatórios.'
      alert('Todos os campos são de preenchimento obrigatórios.')
			return;
		}

    this.operacao = "Edição";
    if (!this.form.valid) {
      this.msgErro = true;
      this.msgSucesso = false;
      console.log(this.msgErro);
      return;
    }

   this.service.create(this.form.value).subscribe({
      next: (res) => {
        console.log(res);
        this.submitted = true;
        this.msgErro = false;
        this.msgSucesso = true;
        this.router.navigateByUrl('list-cliente');
      },
      error: (e) => console.error(e),
    });
  }

  limpar(){
    this.nova();
  }

  nova(): void {
    this.form = this.fb.group({
      nome: ['', Validators.required],
      email: ['', Validators.required],
      idade: ['', Validators.required],
      numeroConta: ['', Validators.required],
      saldo: ['', Validators.required],
    });
  }

}
