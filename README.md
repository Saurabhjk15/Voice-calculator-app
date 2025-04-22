# Voice-Controlled Calculator

A sleek and innovative Android application that lets you perform calculations using voice commands or manual input.

---

## 📱 Overview

The **Voice-Controlled Calculator** is an Android mobile application developed using **Android Studio (Java)**. It allows users to perform mathematical operations using voice commands like “five plus three” or via traditional button input. It includes a 10-second timeout for voice input, advanced math functions, and a clean interface that works well on devices.

---

## ✨ Features

- 🎙️ **Voice Control**: Perform calculations using natural voice commands (e.g., "ten divided by two").
- 🔢 **Manual Input**: Use on-screen buttons for digits, operators, and advanced math functions.
- 🧮 **Advanced Operations**: Addition, subtraction, multiplication, division, modulus, square root, and square.
- ⏱️ **Timeout Feature**: Microphone turns off after 10 seconds of silence.
- ⚠️ **Error Handling**: Friendly messages for invalid input or division by zero.
- 📱 **Cross-Device Compatibility**: Works on Android devices with Google Play Services (API 21+).

---

## 🛠 Installation

### ✅ Prerequisites
- Android Studio (latest version recommended)
- An Android device or emulator with Google Play Services
- Basic knowledge of Android and Git

### 🚀 Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/Saurabhjk15/Voice-calculator-app.git
2. Open in Android Studio
- Launch Android Studio.
- Select "Open an existing project".
- Navigate to the cloned folder.
- Configure the Project
- Make sure the minimum SDK is set to API 21 in build.gradle.
- Connect your Android device or use an emulator with USB debugging enabled.
- Build and Run
- Click Run in Android Studio.
- Grant microphone permissions when prompted.

🎤 Usage
Voice Input
- Tap the "Speak" button.
- Say commands like:
  - “five plus three”
  - “four square root”

- The result will display within 10 seconds. If no voice is detected, the mic will turn off.

Manual Input
- Use the on-screen buttons (0-9, +, -, *, /, %, √, x²).
- Tap “=” to calculate.
- Tap “C” to clear and reset.

🔢 Example Commands
Voice Command	Result
- "Five plus three"  	8
- "Four square root"	 2.0
- "Six times six mod three"  	0.0

## 🗂 Project Structure
```

Voice-Controlled-Calculator/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/voicecalculator/
│   │   │   │   └── MainActivity.java          # Main application logic
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   └── activity_main.xml      # UI layout
│   │   │   │   └── values/
│   │   │   │       └── strings.xml            # Strings and resources
│   │   │   └── AndroidManifest.xml            # Permissions and configuration
│   └── build.gradle                           # Project dependencies
├── README.md                                  # Project documentation
└── LICENSE                                    # License (if applicable)
```


🧰 Technologies Used
- Language: Java

- Framework: Android SDK

- Tools: Android Studio

- Voice Recognition: Google Speech Recognition (RecognizerIntent)

- Version Control: Git

🤝 Contributing

- We welcome contributions to enhance this project!

- Fork the repository

- Create a new branch : git checkout -b feature-branch
- Make changes and commit : git commit -m "Add new feature"
- Push to your fork : git push origin feature-branch
- Open a Pull Request on GitHub

- Please follow the Contributor Covenant Code of Conduct.







