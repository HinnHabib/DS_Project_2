import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {


  cars: any[];

  selectedCar: any;

  displayDialog: boolean;

  constructor() {
  }

  ngOnInit() {
    this.cars = [
      {
        'vin': 'ee8a89d8',
        'brand': 'Fiat',
        'year': 1987,
        'color': 'Maroon'
      },
      {
        'vin': '642b3edc',
        'brand': 'Renault',
        'year': 1968,
        'color': 'White'
      },
      {
        'vin': '19ec7580',
        'brand': 'Renault',
        'year': 1981,
        'color': 'Black'
      },
      {
        'vin': '39980f30',
        'brand': 'VW',
        'year': 1986,
        'color': 'Red'
      },
      {
        'vin': 'ec9cc4e4',
        'brand': 'Fiat',
        'year': 1981,
        'color': 'Brown'
      },
      {
        'vin': '09a06548',
        'brand': 'VW',
        'year': 1965,
        'color': 'Green'
      },
      {
        'vin': '05c47246',
        'brand': 'Mercedes',
        'year': 2007,
        'color': 'Blue'
      },
      {
        'vin': 'a9cb87aa',
        'brand': 'Fiat',
        'year': 1962,
        'color': 'Green'
      },
      {
        'vin': 'eae758fa',
        'brand': 'BMW',
        'year': 1999,
        'color': 'Yellow'
      },
      {
        'vin': '1241c403',
        'brand': 'Jaguar',
        'year': 1964,
        'color': 'Yellow'
      },
      {
        'vin': '13f853a7',
        'brand': 'Honda',
        'year': 2006,
        'color': 'White'
      },
      {
        'vin': '447d9ed9',
        'brand': 'Jaguar',
        'year': 2005,
        'color': 'Orange'
      },
      {
        'vin': '78fa052e',
        'brand': 'Jaguar',
        'year': 1990,
        'color': 'Orange'
      },
      {
        'vin': '8b77772a',
        'brand': 'Mercedes',
        'year': 1991,
        'color': 'Blue'
      },
      {
        'vin': '23ba7e86',
        'brand': 'Honda',
        'year': 1975,
        'color': 'Yellow'
      }
    ];
  }

  selectCar(car: any) {
    this.selectedCar = car;
    this.displayDialog = true;
  }

  onDialogHide() {
    this.selectedCar = null;
  }

}
