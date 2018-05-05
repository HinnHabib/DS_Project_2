import {Injectable} from '@angular/core';
import {CommunicationService} from '../communication.service';
import {CustomerInterface} from './customer.interface';

@Injectable()
export class CustomersListService {

  constructor(public communicationService: CommunicationService) {
  }

  public getAllUsers() {
    return this.communicationService.getRequest('user/users');
  }

  public deleteUser(userId) {
    return this.communicationService.deleteRequest('user/delete/' + userId);
  }

  public addNewCustomer(customer: CustomerInterface){
    return this.communicationService.postRequest('user/signup', customer);
  }
}
