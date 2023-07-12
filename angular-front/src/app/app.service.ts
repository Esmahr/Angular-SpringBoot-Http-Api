import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs'
import { User } from './User';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private url = "http://193.164.6.74:8088/user";

  constructor(private http: HttpClient) { }

  // Add User - Create
  adduser(user: User) {
    return this.http.post<User>(`${this.url}`, user)
  }

  // Get Users - Read
  getUsers(): Observable<any[]> {
    return this.http.get<any[]>(this.url)
  }

  // Get User by Id - Read
  getUserById(id: number): Observable<User> {
    return this.http.get<User>(`${this.url}user/${id}`)
  }

  // Update User - Update
  updateUser(user: User): Observable<any> {
    return this.http.put<User>(`${this.url}`,user)
  }

  // Delete User - Delete
  deleteUser(id: number): Observable<any> {
    return this.http.delete<any>(`${this.url}delete/${id}`)
  }
  
}