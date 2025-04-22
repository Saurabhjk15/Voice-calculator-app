Voice-Controlled Calculator


A sleek and innovative Android application that lets you perform calculations using voice commands or manual input.

Overview
The Voice-Controlled Calculator is an Android mobile application developed using Android Studio with Java. This app allows users to perform mathematical calculations by speaking commands (e.g., "five plus three") or using a traditional button-based interface. It features a 10-second timeout for voice input, advanced operations like square root and power, and a user-friendly design compatible with devices like the Realme Narzo 10.

Features
Voice Control: Perform calculations using natural voice commands (e.g., "ten divided by two").
Manual Input: Use on-screen buttons for digits, operators, and advanced functions.
Advanced Operations: Supports addition, subtraction, multiplication, division, modulus, square root, and square.
Timeout Feature: Microphone turns off after 10 seconds of silence during voice input.
Error Handling: Displays clear error messages for invalid inputs or division by zero.
Cross-Device Compatibility: Works on Android devices with Google Play Services (API 21+).
Installation
Prerequisites
Android Studio (latest version recommended).
An Android device (e.g., Realme Narzo 10) or emulator with Google Play Services.
Basic knowledge of Android development and Git.
Steps
Clone the Repository:
bash

Copy
git clone https://github.com/your-username/Voice-Controlled-Calculator.git
Replace your-username with your GitHub username.
Open in Android Studio:
Launch Android Studio and select "Open an existing project."
Navigate to the cloned directory and open it.
Configure the Project:
Ensure the minimum SDK is set to API 21 in build.gradle.
Connect your Android device via USB or use an emulator with USB debugging enabled.
Build and Run:
Click "Run" in Android Studio to build and install the app on your device.
Grant microphone permissions when prompted.
Usage
Voice Input
Tap the "Speak" button to activate voice input.
Say a command (e.g., "five plus three" or "four square root").
Results will display within 10 seconds; the microphone will turn off if no voice is detected after 10 seconds.
Manual Input
Use the number buttons (0-9) and decimal point to enter values.
Select operators (+, -, *, /, %, √, x²) and press "=" to calculate.
Press "C" to clear the input and reset.
Example Commands
"Five plus three" → Displays "8"
"Four square root" → Displays "2.0"
"Six times six mod three" → Displays "0.0"
Project Structure
text

Copy
Voice-Controlled-Calculator/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/voicecalculator/
│   │   │   │   └── MainActivity.java    # Main application logic
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   └── activity_main.xml # UI layout
│   │   │   │   └── values/
│   │   │   │       └── strings.xml      # Strings and resources
│   │   │   └── AndroidManifest.xml      # Permissions and configuration
│   └── build.gradle                    # Project dependencies
├── README.md                           # This file
└── LICENSE                             # Open-source license (if applicable)
Technologies Used
Language: Java
Framework: Android SDK
Tools: Android Studio
Speech Recognition: Google Speech Recognition via RecognizerIntent
Version Control: Git
Contributing
We welcome contributions to enhance this project! To contribute:

Fork the repository.
Create a new branch (git checkout -b feature-branch).
Make your changes and commit them (git commit -m "Add new feature").
Push to the branch (git push origin feature-branch).
Open a pull request with a detailed description of your changes.
Please adhere to the Contributor Covenant Code of Conduct.

Issues and Support
Report bugs or suggest features by opening an issue on the GitHub Issues page.
For support, contact the maintainer at your-email@example.com (replace with your email).
