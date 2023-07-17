import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs';
import { AppService } from 'src/app/app.service';

@Component({
  selector: 'app-view-user',
  templateUrl: './view-user.component.html',
  styleUrls: ['./view-user.component.css']
})
export class ViewUserComponent implements OnInit {

  name = 'First Name';
  surname = 'Last Name';
  username = 'User Name';
  mail = 'Email';
  password = 'Password';

  users: any[] | undefined
  filteredUsers: any[] | undefined;

  constructor(private service: AppService, private router: Router) {

  }

  ngOnInit(): void {
    this.service.getUsers().subscribe(data => {
      this.users = data;
      this.filteredUsers = this.users; // Tüm kullanıcıları filtrelenmiş kullanıcılar listesine ata
    });
  }
  

  deleteUser(id: number) {
    this.service.deleteUser(id).subscribe(data => {
      this.users = this.users?.filter(user => user.id !== id);
      location.reload(); // Sayfayı yenile
    })
  }

  updateUser(id: number) {
    this.router.navigate(['update', id]);
  }

  getUserByUserName(username: string) {
    if (username) {
      this.filteredUsers = this.users?.filter(user => user.username.toLowerCase().includes(username.toLowerCase()));
    } else {
      this.filteredUsers = this.users;
    }
  }

}