import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AppService } from 'src/app/app.service';
import { User } from 'src/app/User';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {
  user?: User
  data: any
  users: any[] | undefined
  filteredUsers: any[] | undefined;

  constructor(
    private service: AppService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    this.service.getUserById(id).subscribe(
      (data) => {
        this.user = data;
        this.form.setValue({
          firstName: this.user?.firstName ?? null,
          lastName: this.user?.lastName ?? null,
          username: this.user?.username ?? null,
          mail: this.user?.mail ?? null,
          password: this.user?.password ?? null
        });
      },
      (error) => {
        console.error('Kullanıcı alınırken bir hata oluştu:', error);
      }
    );
  }

  form = new FormGroup({
    firstName: new FormControl(),
    lastName: new FormControl(),
    username: new FormControl(),
    mail: new FormControl(),
    password: new FormControl()
  });

  submit() {
    this.data = this.form.value;
    const id = this.route.snapshot.params['id'];
    this.service.updateUser(id, this.data).subscribe(data => {
      console.log(data)
    })
    this.router.navigate(['/']);
  }

}