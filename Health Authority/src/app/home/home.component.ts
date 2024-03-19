import { Component, OnInit } from '@angular/core';
import * as firebase from 'firebase';
import {generateRandomNumber} from '../commonFunctions/generateRandom';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  usersArray = []
  generatedNo = 'jhdkf';

  constructor() { }

  ngOnInit() {
    this.getAllUsers();
  }
  
  // users list
  getAllUsers = () => {
    // this.loader = true;
    firebase.firestore().collection('user').onSnapshot((users) => {
      if(!users.empty) {
        users.forEach(user => {    
          this.usersArray.push(user.data()); 
        });
      }   
    })
  }

  generateRandomNo = () => {
    const randomNo = generateRandomNumber();
    (<HTMLInputElement>document.getElementById('showGenerate')).value = randomNo
  }

}
