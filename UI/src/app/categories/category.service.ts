import {Injectable} from '@angular/core';
import {CommunicationService} from '../communication.service';

@Injectable()
export class CategoryService {

  constructor(public communicationService: CommunicationService) {
  }

  addNewCategroy(categoryName: string, categoryImage: String) {
    const body = {
      'name': categoryName,
      'picture': categoryImage
    };
    return this.communicationService.postRequest('category/', body);
  }


  getAllCategories() {
    return this.communicationService.getRequest('category/all');
  }

  deleteCategories(catId) {
    return this.communicationService.deleteRequest('category/delete/' + catId);
  }

}
