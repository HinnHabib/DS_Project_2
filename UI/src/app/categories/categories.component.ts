import {Component, OnInit, ViewChild} from '@angular/core';
import {CategoryService} from './category.service';
import {NgForm} from '@angular/forms';
import {Category} from './category';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {
  @ViewChild('createNewCategory') categoryFrom: NgForm;


  displayDialog: boolean;

  category: Category = {};

  selectedCat: Category;

  newCat: boolean;

  categoryList: Category[];

  cols: any[];

  constructor(public categoryService: CategoryService) {
  }

  ngOnInit() {
    this.categoryService.getAllCategories().subscribe(cars => this.categoryList = cars as Category[]);

    this.cols = [
      {field: 'id', header: 'ID'},
      {field: 'name', header: 'Name'},
      {field: 'picture', header: 'Image'},
    ];
  }


  addNewCategory(name, image) {
    this.categoryService.addNewCategroy(name, image)
      .subscribe((data) => {
        console.log(data);
      });
  }

  deleteCategory(catId) {
    this.categoryService.deleteCategories(catId)
      .subscribe(() => {

      });
  }

  // onSubmit() {
  //   console.log(this.categoryFrom.value.name);
  //   console.log(this.categoryFrom.value.image);
  // }

  showDialogToAdd() {
    this.newCat = true;
    this.category = {};
    this.displayDialog = true;
  }

  save() {
    const categories = [...this.categoryList];
    if (this.newCat) {
      categories.push(this.category);
      this.addNewCategory(this.category.name, this.category.picture);
    } else {
      categories[this.categoryList.indexOf(this.selectedCat)] = this.category;
    }

    this.categoryList = categories;
    this.category = null;
    this.displayDialog = false;
  }

  delete() {
    const index = this.categoryList.indexOf(this.selectedCat);
    this.deleteCategory(this.categoryList[index].id);
    this.categoryList = this.categoryList.filter((val, i) => i !== index);
    this.category = null;
    this.displayDialog = false;
  }

  onRowSelect(event) {
    this.newCat = false;
    this.category = this.cloneCar(event.data);
    this.displayDialog = true;
  }

  cloneCar(c) {
    const car = {};
    for (let prop in c) {
      car[prop] = c[prop];
    }
    return car;
  }

}
