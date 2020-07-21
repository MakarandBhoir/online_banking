import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './Component/login/login.component';
import {HomeComponent} from './Component/home/home.component';
import { UserRegistrationComponent } from './Component/User/user-registration/user-registration.component';
import { AccountRequestComponent } from './Component/account-request/account-request.component';
import { AdminViewComponent } from './Component/admin/admin-view/admin-view.component';
import { AdminApproveComponent } from './Component/admin/admin-approve/admin-approve.component';
import { UserHomeComponent } from './Component/user/user-home/user-home.component';
import { NotFoundComponent } from './Component/not-found/not-found.component';
import { CustomerCheckComponent } from './Component/Customer/customer-check/customer-check.component';
import { AdminLoginComponent } from './Component/Admin/admin-login/admin-login.component';
import { ViewBeneficiariesComponent } from './Component/beneficiary/view-beneficiaries/view-beneficiaries.component';
import { AddBeneficiaryComponent } from './Component/beneficiary/add-beneficiary/add-beneficiary.component';
import { UserTransactions } from './Model/user-transactions';
import { TransactionComponent } from './Component/transaction/transaction.component';
import { MiniStatementComponent } from './Component/mini-statement/mini-statement.component';
import { CustomerprofileComponent } from './Component/customermodule/customerprofile/customerprofile.component';
import { AccountsummaryComponent } from './Component/customermodule/accountsummary/accountsummary.component';

const routes: Routes = [
  { path:'', component: HomeComponent , pathMatch: 'full'},
  { path:'login', component: LoginComponent},
  { path:'home', component: HomeComponent},
  { path:'check', component: CustomerCheckComponent},
  { path:'register', component: UserRegistrationComponent},
  { path:'openAC', component: AccountRequestComponent},
  { path:'ACrequest', component: AdminViewComponent},
  { path:'viewPayees', component: ViewBeneficiariesComponent},
  { path:'payeedetails/:id', component: AddBeneficiaryComponent},
  { path:'addPayee', component: AddBeneficiaryComponent},
  { path:'update/:id', component: AddBeneficiaryComponent},
  { path:'adminlogin', component: AdminLoginComponent},
  { path:'userHome', component: UserHomeComponent},
  { path:'fund', component: TransactionComponent},
  { path:'cust', component:CustomerprofileComponent},
  { path:'acSummary', component:AccountsummaryComponent},

  { path:'statement', component: MiniStatementComponent},
  { path: 'details/:id', component: AdminApproveComponent },
  { path: '**', component: NotFoundComponent }

   
  

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
