import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {MatTableModule} from '@angular/material/table';
import {MatFormFieldModule} from '@angular/material/form-field';



import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {CustomersListComponent} from './customers-list/customers-list.component';
import {HttpClientModule} from '@angular/common/http';
import {ProductListComponent} from './product-list/product-list.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatInputModule} from '@angular/material';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CustomersListComponent,
    ProductListComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    MatTableModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
