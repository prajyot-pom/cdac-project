import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ContactComponent } from './contact/contact.component';
import { DataService } from './data.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { AuthService } from './auth.service';
import { BookComponent } from './book/book.component';
import { AddBookComponent } from './add-book/add-book.component';
import { RegisterComponent } from './register/register.component';
import { LoggedUserComponent } from './logged-user/logged-user.component';
import { PasswordComponent } from './password/password.component';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { CartComponent } from './cart/cart.component';
import { RegisterAdminComponent } from './register-admin/register-admin.component';
import { AboutComponent } from './about/about.component';
import { OrderComponent } from './order/order.component';
import { PaymentComponent } from './payment/payment.component';
import { EditBookComponent } from './edit-book/edit-book.component';
import { EditUserComponent } from './edit-user/edit-user.component';
import { AddressComponent } from './address/address.component';
import { AddAddressComponent } from './add-address/add-address.component';
import { EditAddressComponent } from './edit-address/edit-address.component';
import { SearchBookComponent } from './search-book/search-book.component';
import { SearchBookAdminComponent } from './search-book-admin/search-book-admin.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ContactComponent,
    LoginComponent,
    AdminComponent,
    UserComponent,
    BookComponent,
    AddBookComponent,
    RegisterComponent,
    LoggedUserComponent,
    PasswordComponent,
    BookDetailComponent,
    CartComponent,
    RegisterAdminComponent,
    AboutComponent,
    OrderComponent,
    PaymentComponent,
    EditBookComponent,
    EditUserComponent,
    AddressComponent,
    AddAddressComponent,
    EditAddressComponent,
    SearchBookComponent,
    SearchBookAdminComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot([
      {path:"",component:HomeComponent},
      {path:'home',component:HomeComponent},
      {path:'contact',component:ContactComponent},
      {path:'login',component:LoginComponent},
      {path:'admin',component:AdminComponent, canActivate:[AuthService]},
      {path:'user',component:UserComponent},
      {path:'book',component:BookComponent},
      {path:'addBook',component:AddBookComponent},
      {path:'register',component:RegisterComponent},
      {path:'loggedUser',component:LoggedUserComponent, canActivate:[AuthService]},
      {path:'password',component:PasswordComponent},
      {path:'bookDetail/:b_id',component:BookDetailComponent},
      {path:'cart',component:CartComponent},
      {path:'registerAdmin',component:RegisterAdminComponent},
      {path:'about',component:AboutComponent},
      {path:'order',component:OrderComponent},
      {path:'payment',component:PaymentComponent},
      {path:'editBook/:b_id',component:EditBookComponent},
      {path:'editUser',component:EditUserComponent},
      {path:'address',component:AddressComponent},
      {path:'addAddress',component:AddAddressComponent},
      {path:'editAddress/:a_id',component:EditAddressComponent},
      {path:'searchBook',component:SearchBookComponent},
      {path:'searchBookAdmin',component:SearchBookAdminComponent},

    ])
    
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
