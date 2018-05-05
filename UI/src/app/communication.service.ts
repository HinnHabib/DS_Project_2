import {Injectable} from '@angular/core';

import {HttpClient} from '@angular/common/http';
import {environment} from '../environments/environment';
import {catchError, map} from 'rxjs/operators';
import {Observable} from 'rxjs/Observable';
import {of} from 'rxjs/observable/of';


@Injectable()
export class CommunicationService {
  public displayErrorDialog = false;
  public displayErrorDialogMessage: String = '';

  constructor(private http: HttpClient) {
  }

  postRequest(url: string, body: any) {
    this.displayErrorDialog = false;
    return this.http.post(this.buildUrl(url), body)
      .pipe(
        map(data => data),
        catchError(this.handleErrors('Post Request'))
      );

  }


  getRequest(url: string) {
    this.displayErrorDialog = false;
    return this.http.get(this.buildUrl(url))
      .pipe(
        map(data => data),
        catchError(this.handleErrors('get Request'))
      );
  }


  buildUrl(url) {
    return environment.URL + environment.PATH_URL + url;
  }


  private handleErrors<T>(operation = 'operation', result?: T) {
    this.displayErrorDialog = true;

    return (error: any): Observable<T> => {

      this.displayErrorDialogMessage = `${error.status},\n` + `${error.message}`;

      // // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
      //
      // // TODO: better job of transforming error for user consumption
      // this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  // private handleErrors(error: HttpErrorResponse) {
  //   this.displayErrorDialog = true;
  //   if (error.error instanceof ErrorEvent) {
  //     // A client-side or network error occurred. Handle it accordingly.
  //     // console.error('An error occurred:', error.error.message);
  //     this.displayErrorDialogMessage = 'An error occurred:' + error.error.message;
  //
  //   } else {
  //     // The backend returned an unsuccessful response code.
  //     // The response body may contain clues as to what went wrong,
  //     // console.error(
  //     //   `Backend returned code ${error.status}, ` +
  //     //   `body was: ${error.error}`);
  //     this.displayErrorDialogMessage = `Backend returned code ${error.status}, ` + `body was: ${error.error}`;
  //
  //   }
  //   this.displayErrorDialog = true;
  //   // return an observable with a user-facing error message
  //   return throwError(
  //     'Something bad happened; please try again later.');
  // }

  // public setHeaders(objectToSetHeadersTo: Headers) {
  //   objectToSetHeadersTo.append('Access-Control-Allow-Credentials', 'true');
  //   objectToSetHeadersTo.append('Access-Control-Allow-Origin', '*');
  //   objectToSetHeadersTo.append('Allow-access-expose-headers', 'headers');
  // }

  deleteRequest(url: string) {
    this.displayErrorDialog = false;
    return this.http.delete(this.buildUrl(url))
      .pipe(
        catchError(this.handleErrors('Delete Request'))
      );

  }


}
