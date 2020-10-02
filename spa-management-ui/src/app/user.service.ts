import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'http://localhost:8080/api/v1/users';
  private loginUrl = 'http://localhost:8080/api/v1/auth/login';

  constructor(private http: HttpClient) { 
    
  }


  getUser(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createUser(user: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, user);
  }

  updateUser(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getEUserList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  login(user: Object): Observable<any> {
    return this.http.post(`${this.loginUrl}`, user);
  }
}
