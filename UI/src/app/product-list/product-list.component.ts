import {Component, OnInit} from '@angular/core';
import {ProductService} from './product.service';
import {SelectItem} from 'primeng/api';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  displayDialog: boolean;

  products: any[];

  selectedProduct: any;

  sortOptions: SelectItem[];

  sortKey: string;

  sortField: string;

  sortOrder: number;

  loading: boolean = true;
  constructor(public productService: ProductService) {

  }

  ngOnInit() {
    this.productService.getAllProduct()
      .subscribe(data => {
          this.products = data as any[];
          this.loading = false;
        }
      );


    this.sortOptions = [
      {label: 'Newest First', value: '!added'},
      {label: 'Oldest First', value: 'added'},
      {label: 'Name', value: 'name'}
    ];
  }

  selectProduct(event: Event, product: any) {
    this.selectedProduct = product;
    this.displayDialog = true;
    event.preventDefault();
  }

  onSortChange(event) {
    let value = event.value;

    if (value.indexOf('!') === 0) {
      this.sortOrder = -1;
      this.sortField = value.substring(1, value.length);
    }
    else {
      this.sortOrder = 1;
      this.sortField = value;
    }
  }

  onDialogHide() {
    this.selectedProduct = null;
  }

}
