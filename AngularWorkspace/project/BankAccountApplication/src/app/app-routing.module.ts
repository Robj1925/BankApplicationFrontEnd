import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AccountsdirectoryComponent } from './components/accountsdirectory/accountsdirectory.component';
import { CreateCustomerComponent } from './components/create-customer/create-customer.component';
import { CreateAccountComponent } from './components/create-account/create-account.component';
import { FindByIdComponent } from './components/find-by-id/find-by-id.component';

const routes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' },
  {path: 'home', component: HomeComponent},
  {path: 'view-all-accounts', component: AccountsdirectoryComponent},
  {path: 'create-customer', component: CreateCustomerComponent}, 
  {path: 'create-account', component: CreateAccountComponent},
  {path: 'find-by-id', component: FindByIdComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
