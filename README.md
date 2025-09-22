# 📱 Cryptocurrency Dashboard Tracker (CryptoTrackr)  

![Kotlin](https://img.shields.io/badge/Kotlin-1.9-blue?logo=kotlin)  
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-%F0%9F%92%8C-brightgreen)  
![Firebase](https://img.shields.io/badge/Firebase-Auth%20%26%20Firestore-orange?logo=firebase)  
![Retrofit](https://img.shields.io/badge/Retrofit-Networking-red)  
![License](https://img.shields.io/badge/License-MIT-lightgrey)  

---

## 📖 Description  
This is a mobile application developed for the **Mastercraft program**, designed to track cryptocurrency prices in real-time using the **CoinGecko API**. Built with **Kotlin** and **Jetpack Compose**, it offers a modern, responsive UI for users to monitor market trends.  

---

## 🚀 Features  
- 🔄 Real-time cryptocurrency price updates (CoinGecko API)  
- 📊 Interactive dashboard for market insights  
- 🧭 Bottom navigation with **Home, Transact, Services, and Grow** screens  
- ❤️ Save favorite coins (Firebase integration)  
- 🔑 User authentication with Firebase (Email/Google)  
- 🌙 Modern UI built on Material Design 3
-  

---

## 🛠 Tech Stack  
- **Kotlin** (100% Kotlin codebase)  
- **Jetpack Compose** (Declarative UI)  
- **MVVM Architecture** + Repository Pattern  
- **Hilt** (Dependency Injection)  
- **Retrofit & OkHttp3** (API Calls)  
- **Firebase Auth + Firestore** (Authentication & Database)  
- **Gradle (KTS)**  

---

## ⚙️ Setup Instructions  


### 1. Clone the Repository  
```bash
git clone https://github.com/yourusername/CryptoTrackr.git
cd CryptoTrackr

plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler) // ✅ new line
    alias(libs.plugins.google.gms.googleServices)
}

