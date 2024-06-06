import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from '../../environments/environment.development';
import { Cliente } from '../modelos/cliente.model';

@Injectable({
  providedIn: 'root'
})

export class ClienteService {

  public apiURL = environment.config.api_url_Dev + '/api/cliente';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<any> {
    return this.httpClient.get(this.apiURL + '/clientes')
      .pipe(
        catchError(this.errorHandler)
      )
  }



  create(obj: Cliente): Observable<any> {
    return this.httpClient.post(this.apiURL + '/', obj, this.httpOptions)
      .pipe(
        catchError(this.errorHandler)
      )
  }

  find(id: number): Observable<any> {
    return this.httpClient.get(this.apiURL + '/' + id)
      .pipe(
        catchError(this.errorHandler)
      )
  }

  update(id: number, obj: Cliente): Observable<any> {
    return this.httpClient.put(this.apiURL + '/' + id, obj, this.httpOptions)
      .pipe(
        catchError(this.errorHandler)
      )
  }

  creditarDebitar(id: number, obj: Cliente): Observable<any> {
    return this.httpClient.put(this.apiURL + '/' + id, obj, this.httpOptions)
      .pipe(
        catchError(this.errorHandler)
      )
  }

  delete(id: number) {
    return this.httpClient.delete(this.apiURL + '/' + id, this.httpOptions)
      .pipe(
        catchError(this.errorHandler)
      )
  }

  errorHandler(error: any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      alert(errorMessage)
      errorMessage = error.error.message;
    } else {
      errorMessage = `Código de erro: ${error.status}\nMensagem: ${error.message}`;
    }
    return throwError(errorMessage);
  }
}
