import { Component, OnInit } from "@angular/core";
import { ClienteService } from "../../../services/cliente.service";
import { Cliente } from "../../../modelos/cliente.model";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})

 export class ListarComponent implements OnInit {

  paginaAtual = 1;
  clientes: Cliente[] = [];
  possuiRegistros = true;
  loaded: boolean;
  modal: any;
  habilitarExportacao = true;

constructor(public service: ClienteService) {
  this.loaded = false;
}

ngOnInit(): void {
  this.findAll();
};

findAll(){

  this.loaded = true;
  this.service.getAll().subscribe((data: Cliente[]) => {
    this.clientes = data
    if(this.clientes.length>0){
      this.possuiRegistros = true;
    }
    this.loaded = false;
  });
}

  
  limpar(){
    this.clientes = [];
    this.possuiRegistros = false;
    this.loaded = false;
  }

 

}


