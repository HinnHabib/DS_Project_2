import {Component, OnInit, ViewChild} from '@angular/core';
import {CustomerInterface} from './customer.interface';
import {NgForm} from '@angular/forms';
import {CustomersListService} from './customers-list.service';

@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.css']
})

export class CustomersListComponent implements OnInit {
  @ViewChild('customerForm') customerForm: NgForm;

  constructor(public customerService: CustomersListService) {
  }

  columnsToDisplay = ['userId', 'name', 'email', 'operations'];

  dataSource: CustomerInterface[] = [];

  ngOnInit() {
    this.customerService.getAllUsers()
      .subscribe((data: CustomerInterface[]) => {
        console.log(data);
        this.dataSource = data;
      });
  }

  onSubmit(e: Event) {
    e.preventDefault();
    const newCustomer: CustomerInterface = {};
    newCustomer.username = this.customerForm.value.username;
    newCustomer.name = this.customerForm.value.name;
    newCustomer.email = this.customerForm.value.email;
    newCustomer.password = this.customerForm.value.password;
    this.customerService.addNewCustomer(newCustomer).subscribe();
  }

  deleteUser(userId) {
    const index = this.dataSource.findIndex(x => x.id === userId);
    this.dataSource = this.dataSource.filter((val, i) => i !== index);
    this.customerService.deleteUser(userId)
      .subscribe(() => {
      });
  }

}
