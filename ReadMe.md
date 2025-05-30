# ⚽ Football App

A native Android application built with Kotlin to display football standings form past seasons. Powered by the [API-Football](https://www.api-football.com/).

---

## 🚀 Features

- 🔎 Search teams and leagues
- 📅 Past Seasons
- 📊 League standings
- 🧑‍🤝‍🧑 Team details
- 📄 Statistics

---

## 🛠️ Tech Stack


- **Kotlin**
- **Jetpack Compose**
- **Jetpack Navigation**
- **Retrofit**
- **Football-Data.org API**
- **Architecture**: MVVM (Model-View-ViewModel)
- **Networking**: Retrofit + OkHttp
- **Jetpack Components**: ViewModel, LiveData, Navigation Component
- **Others**: Coroutines

---

## 📦 Getting Started

### Step 1: Clone the Repository

```bash
git clone https://github.com/Android-Course-UPB/project-Alex250801
cd football-app
```

### Step 2: Open in Android Studio
```
File > Open > Navigate to the cloned directory
```

### Step 3: Add API Credentials

```
app/src/main/java/com/example.footballapp/util/Constants.kt
```

Update the API constants:
```
object Constants {
    const val BASE_URL = "https://v3.football.api-sports.io/"
    const val API_KEY = "your_actual_api_key"
    const val API_HOST = "v3.football.api-sports.io"
}
```
### Step 4: Run the app

Connect your device or start an emulator, then click Run ▶️ in Android Studio.







