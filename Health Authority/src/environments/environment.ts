// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  firebaseConfig: {
    apiKey: 'process.env.FIREBASE_API_KEY',
    authDomain: 'uploaddata-6d580.firebaseapp.com',
    databaseURL: 'https://uploaddata-6d580.firebaseio.com',
    projectId: 'uploaddata-6d580',
    storageBucket: 'uploaddata-6d580.appspot.com',
    messagingSenderId: '69241741850',
    appId: '1:69241741850:web:61603503e3c2eb08b8e7a3',
    measurementId: 'G-G563MFMZSY',
  },
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
