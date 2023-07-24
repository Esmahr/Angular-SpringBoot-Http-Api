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
        firstName: this.user?.firstName;
        lastName: this.user?.lastName;
        username: this.user?.username;
        mail: this.user?.mail;
        password: this.user?.password;
      },
      (error) => {
        console.error('Kullanıcı alınırken bir hata oluştu:', error);
      }
    );
  }

  form = new FormGroup({
    firstName: new FormControl('', [Validators.required]),
    lastName: new FormControl('', [Validators.required]),
    username: new FormControl('', [Validators.required]),
    mail: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required])
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