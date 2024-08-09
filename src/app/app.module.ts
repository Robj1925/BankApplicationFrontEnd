import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { HomeComponent, UpdateCustomerDialog } from './components/home/home.component';
import { MatTableModule } from '@angular/material/table';
import { MatMenuModule } from '@angular/material/menu';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AccountsdirectoryComponent } from './components/accountsdirectory/accountsdirectory.component';
import { CreateCustomerComponent } from './components/create-customer/create-customer.component';
import { CreateAccountComponent } from './components/create-account/create-account.component';
import { FindByIdComponent } from './components/find-by-id/find-by-id.component';
import { HttpClient, provideHttpClient } from '@angular/common/http';
// import { provideHttpClientTesting } from '@angular/common/http/testing';

import { MatDialogModule } from '@angular/material/dialog';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    AccountsdirectoryComponent,
    CreateCustomerComponent,
    CreateAccountComponent,
    FindByIdComponent,
    UpdateCustomerDialog
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatButtonModule,
    MatTableModule,
    MatMenuModule,
    FormsModule,
    ReactiveFormsModule,
    MatDialogModule,
    
  ],
  providers: [
    provideClientHydration(),
    provideHttpClient()
   // provideHttpClientTesting(),

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
