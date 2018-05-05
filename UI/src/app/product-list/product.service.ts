import {Injectable} from '@angular/core';
import {CommunicationService} from '../communication.service';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class ProductService {

  constructor(public communicationService: CommunicationService, public http: HttpClient) {
  }


  public getAllProduct() {
    return this.http.get('http://f96773bb.ngrok.io/api/v1/product/all');
  }


}
