import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';


import {MatTableModule} from '@angular/material/table';
import {MatTabsModule} from '@angular/material/tabs';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatPaginatorModule} from '@angular/material/paginator';

import {DialogModule} from 'primeng/Dialog';
import {TableModule} from 'primeng/table';
import {CarouselModule} from 'primeng/carousel';
import {ButtonModule} from 'primeng/button';
import {TabViewModule} from 'primeng/tabview';
import {DataGridModule} from 'primeng/datagrid';
import {PanelModule} from 'primeng/panel';
import {DataViewModule} from 'primeng/dataview';
import {DropdownModule} from 'primeng/dropdown';

import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {CustomersListComponent} from './customers-list/customers-list.component';
import {HttpClientModule} from '@angular/common/http';
import {ProductListComponent} from './product-list/product-list.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatInputModule} from '@angular/material';
import {CommunicationService} from './communication.service';
import {CustomersListService} from './customers-list/customers-list.service';
import {CategoriesComponent} from './categories/categories.component';
import {CategoryService} from './categories/category.service';
import {HomePageComponent} from './home-page/home-page.component';
import {CouponsComponent} from './coupons/coupons.component';
import {ProductService} from './product-list/product.service';

const appRoutes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomePageComponent},
  {path: 'customer', component: CustomersListComponent},
  {path: 'product', component: ProductListComponent},
  {path: 'category', component: CategoriesComponent},
  {path: 'coupon', component: CouponsComponent}
];


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CustomersListComponent,
    ProductListComponent,
    CategoriesComponent,
    HomePageComponent,
    CouponsComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    MatTableModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    DialogModule,
    TableModule,
    CarouselModule,
    ButtonModule,
    TabViewModule,
    MatTabsModule,
    DataGridModule,
    PanelModule,
    DataViewModule,
    DropdownModule,
    MatPaginatorModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [CommunicationService, CustomersListService, CategoryService, ProductService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
