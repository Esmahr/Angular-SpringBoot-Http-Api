import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewUserComponent } from './view-user/view-user.component';
import { AddUserComponent } from './add-user/add-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';

const routes: Routes = [
  { path: '', component: ViewUserComponent, title: 'Home' },
  { path: 'add', component: AddUserComponent, title: 'Add Page' },
  { path: 'update/:id', component: UpdateUserComponent, title: 'Update Page' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
