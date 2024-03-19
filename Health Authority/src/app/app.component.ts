import { Component } from '@angular/core';
import * as firebase from 'firebase';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor (){
    firebase.auth().signInWithEmailAndPassword('shashankpanwar@outect.com','123456')
  }

}
