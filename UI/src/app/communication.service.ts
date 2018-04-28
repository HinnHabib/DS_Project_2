import {Injectable} from '@angular/core';

import {HttpClient} from '@angular/common/http';
import {environment} from '../environments/environment';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';


@Injectable()
export class CommunicationService {

  constructor(private http: HttpClient) {
  }

  postJsonRequest(url: string, body: any) {
    return this.http.post(this.buildUrl(url), body)
      .map((res: Response) => {
        return res.json();
      })
      .catch(this.handleErrors());

  }


  getRequest(url: string): Observable<Response> {
    return this.http.get(this.buildUrl(url))
      .map((data: Response) => data.text())
      .catch(this.handleErrors());
  }


  buildUrl(url) {
    return environment.URL + environment.PATH_URL + url;

  }

  public handleErrors() {
    return (res: Response) => {
      console.log('Error!!!', res);
      if (res.status === 401 || res.status === 403 || res.status === 500) {
      }
      return Observable.throw(res);
    };
  }

  public setHeaders(objectToSetHeadersTo: Headers) {
    objectToSetHeadersTo.append('Access-Control-Allow-Credentials', 'true');
    objectToSetHeadersTo.append('Access-Control-Allow-Origin', '*');
    objectToSetHeadersTo.append('Allow-access-expose-headers', 'headers');
  }


}
