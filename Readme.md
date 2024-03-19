# CovidGuard

Contact tracing using Bluetooth Low Energy (BLE) beacons, along with technologies such as Java and smartphones, is a powerful tool in effectively managing the spread of infectious diseases. By leveraging BLE technology, smartphones can detect and record the presence of nearby beacons, enabling the tracking of close contacts between individuals. This data, managed through Java-based applications on smartphones, allows for the rapid identification of potentially exposed individuals and the implementation of targeted interventions, such as quarantine or testing. Overall, contact tracing using these technologies is a key strategy in controlling the spread of diseases and protecting public health

Here's how contact tracing using BLE beacons typically works:

- Beacon Deployment: BLE beacons are deployed in various locations, such as public buildings, transportation hubs, and workplaces. These beacons are placed in strategic locations to ensure adequate coverage of the area.

- User Interaction: Users who have a contact tracing app installed on their smartphones can opt-in to participate in the contact tracing program. The app continuously scans for nearby BLE beacons and records the identifiers of the beacons it detects.

- Data Collection: When two smartphones with contact tracing apps installed come into close proximity (usually within a few meters) for a certain period of time, their apps exchange and record the identifiers of the beacons detected by the respective devices.

- Data Storage: The recorded beacon identifiers, along with the timestamps and proximity information, are stored locally on the user's device in a secure and privacy-preserving manner. The data is typically encrypted to protect user privacy.

- Contact Identification: If a user tests positive for an infectious disease, such as COVID-19, they can choose to share their contact tracing data with public health authorities. The authorities can then use this data to identify and notify individuals who may have been in close contact with the infected person.

- Privacy Considerations: Contact tracing using BLE beacons is designed with privacy in mind. The system does not collect or store any personally identifiable information (PII) about the users. The beacon identifiers are random and change frequently to prevent tracking of individual users.

- Notifications: If a user is identified as having been in close contact with an infected person, they may receive a notification from the contact tracing app advising them to self-isolate or seek medical advice.

## Table of Contents

- [Description](#description)
- [Screenshots](#screenshots)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Features](#features)

## Installation

Clone this repository and import into **Android Studio**

```bash
git clone https://github.com/MwangiR/CovidGuard
```

## Instructions to run the app (Method 1)

- Click on **Run** button ▶ in **Android Studio**

## Instructions to run the app (Method 2)

1. Move into the cloned directory
2. Run gradle command to build an apk
3. Install the apk into virtual device

```bash
gradlew build
gradlew install# Contact Tracing App
```

## Description

The Contact Tracing App is designed to utilize Bluetooth Low Energy (BLE) technology for contact tracing, helping to track and prevent the spread of infectious diseases such as COVID-19.

## Screenshots

![Sample User Data](./screenshots/1.png)
![Sample Collection of Single User Data](./screenshots/2.png)

## Technologies Used

- Android SDK
- BLE Framework
- Firebase Authentication
- Firestore
- Java

## Installation

1. Clone the repository.
2. Set up Firebase project and add the google-services.json file to the Android app.
3. Install dependencies (`npm install`).
4. Run the Android application on an emulator or physical device.

## Features

- Utilizes BLE technology for contact tracing.
- Stores user-specific data in Firestore.
- Registers devices for notifications and stores FCM tokens in Firestore.

## Usage Information

1. Clone the repository.
2. Set up Firebase project and add the google-services.json file to the Android app.
3. Install dependencies (`npm install`).
4. Run the Android application on an emulator or physical device.
5. Ensure Bluetooth is enabled on the device to enable contact tracing.

## Suggested Future Development

- Implement more advanced contact tracing algorithms.
- Enhance user interface for better user experience.

## Contribution Guidelines

- Fork the repository.
- Create a new branch (`git checkout -b feature/xyz`).
- Make your changes.
- Commit your changes (`git commit -am 'Add new feature'`).
- Push to the branch (`git push origin feature/xyz`).
- Create a new Pull Request.

## Test Instructions

- Use the app in various scenarios to ensure accurate contact tracing.
- Test Bluetooth connectivity and data transmission.

## License

This project is licensed under the [MIT] - see the LICENSE.md file for details.

## Questions

For any questions or support

```

## Basic Features of the App:

- Onboard page
- Firebase login authentication
- Google authentication
- Covid Stats
- Clickable location cards with description

## Screenshots of Application

<img src="https://github.com/MwangiR/CovidGuard/blob/master/readme_images/Screenshot_1636114577.png" width="30%" height="30%"/> <img src="https://github.com/MwangiR/CovidGuard/blob/master/readme_images/Screenshot_1636114686.png" width="30%" height="30%"/> <img src="https://github.com/MwangiR/CovidGuard/blob/master/readme_images/Screenshot_1636114702.png" width="30%" height="30%"/>

## Contributing

1. Fork it
2. Create your feature branch (git checkout -b my-new-feature)
3. Commit your changes (git commit -m 'Add some feature')
4. Push your branch (git push origin my-new-feature)
5. Create a new Pull Request
```
