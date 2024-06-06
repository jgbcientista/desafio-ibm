import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarComponent } from './list/list.component';
import { EditComponent } from './edit/edit.component';
 
 
 const routes: Routes = [
  { path: '', component: ListarComponent, children: [
    
    {path: 'create-cliente',
      loadChildren: () => import(`./create/create.module`)
        .then(mod => mod.CreateModule)
    },
    
    { path: '', component: EditComponent, children: [] },

  ]
},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClienteRoutingModule { }