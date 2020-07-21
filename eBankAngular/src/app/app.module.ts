import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { TransactionComponent } from './Component/transaction/transaction.component';
import { BankAccountComponent } from './Component/bank-account/bank-account.component';
import { AccountRequestComponent } from './Component/account-request/account-request.component';

import { AdminViewComponent } from './Component/admin/admin-view/admin-view.component';
import { AdminApproveComponent } from './Component/admin/admin-approve/admin-approve.component';
import { AddBeneficiaryComponent } from './Component/beneficiary/add-beneficiary/add-beneficiary.component';
import { ViewBeneficiariesComponent } from './Component/beneficiary/view-beneficiaries/view-beneficiaries.component';

import { UserRegistrationComponent } from './Component/User/user-registration/user-registration.component';
import { MenuComponent} from './Component/menu/menu.component';
import { NotFoundComponent } from './Component/not-found/not-found.component';
import { HomeComponent } from './Component/home/home.component';
import { LoginComponent } from './Component/login/login.component';
import { UserChangePasswordComponent } from './Component/User/user-change-password/user-change-password.component';
import { UserService } from './Services/user.service ';
import { AdminService } from './Services/admin.service';
import { StoreService } from './Services/store.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { AdminLoginComponent } from './Component/Admin/admin-login/admin-login.component';
import { LogoutComponent } from './Component/logout/logout.component';
import { UserHomeComponent } from './Component/user/user-home/user-home.component';
import { CustomerCheckComponent } from './Component/Customer/customer-check/customer-check.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MiniStatementComponent } from './Component/mini-statement/mini-statement.component';
import { CustomerprofileComponent } from './Component/customermodule/customerprofile/customerprofile.component';
import {AccountsummaryComponent} from './Component/customermodule/accountsummary/accountsummary.component';
//import { MatToolbarModule, MatIconModule, MatSidenavModule, MatListModule, MatButtonModule } from  '@angular/material';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    AccountsummaryComponent,
    TransactionComponent,
    BankAccountComponent,
    AccountRequestComponent,
  
    AdminViewComponent,
    AdminApproveComponent,
    AddBeneficiaryComponent,
    ViewBeneficiariesComponent,
    
    UserRegistrationComponent,
    NotFoundComponent,
    HomeComponent,
    LoginComponent,
    UserChangePasswordComponent,
    AdminLoginComponent,
    LogoutComponent,
    UserHomeComponent,
    CustomerCheckComponent,
    MiniStatementComponent,
    CustomerprofileComponent
  ],
  imports: [
    
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,
   // MatToolbarModule,
   // MatSidenavModule,
  //  MatListModule,
  //  MatButtonModule,
   // MatIconModule
  ],
  
  providers: [UserService,AdminService,StoreService],
  bootstrap: [AppComponent]
})
export class AppModule { }
