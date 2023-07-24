import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs'
import { User } from './User';

@Injectable({
  providedIn: 'root'
})
export class AppService {
  getUser(userId: string | null) {
    throw new Error('Method not implemented.');
  }

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

  // Get User by username - Read
  getUserByUserName(username: string): Observable<any> {
    return this.http.get<any>(`${this.url}/${username}`)
  }

  //Get user by id - read
  getUserById(id: number): Observable<any> {
    const userUrl = `${this.url}/id/${id}`;
    return this.http.get<any>(userUrl);
  }
  // Update User - Update
  updateUser(id: number, body: User): Observable<User> {
    return this.http.put<User>(`${this.url}/${id}`, body)
  }

  // Delete User - Delete
  deleteUser(id: number): Observable<any> {
    return this.http.delete<any>(`${this.url}/${id}`)
  }

}