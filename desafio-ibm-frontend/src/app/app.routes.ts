import { Routes } from '@angular/router';
import { ListarComponent } from './pages/cliente/list/list.component';

export const routes: Routes = [
  {
    path: 'list-cliente',
    component: ListarComponent
  },
     // configuracao do cliente
     {
      path: 'list-cliente',
      loadChildren: () => import('./pages/cliente/cliente.module')
        .then(mod => mod.ClienteModule), //canActivate: [authGuard]
    },
    {
      path: 'create-cliente',
      loadChildren: () => import('./pages/cliente/create/create.module')
        .then(mod => mod.CreateModule)
    },
    {
      path: 'cliente/:postId/edit',
      loadChildren: () => import('./pages/cliente/edit/edit.module')
        .then(mod => mod.EditModule)
    },


  { path: '**', redirectTo: '' }
];
