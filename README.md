# Project Name: Game Catalogue

Game Catalogue is an Android application that allows users to browse and discover various games, view them by categories or platfomrs.


## Overview

The Game Catalogue app provides the following features:
- Browse a list of games
- View games by category
- View games by platform


## Setup Instructions

1. Clone the repository:

2. Open the project in Android Studio:
- Launch Android Studio.
- Select "Open an existing Android Studio project."
- Navigate to the directory where you cloned the repository and select the build.gradle file.

3. Configure SDK and Dependencies:
- Ensure you have the necessary SDK versions installed.
- Sync the project with Gradle files to download dependencies.

4. Run the Project:
- Connect an Android device or start an emulator.
- Click the "Run" button in Android Studio.

## API Documentation

Used api: https://www.freetogame.com/api/


#### 1. Get All Games

- Endpoint: @GET("games/")
- Description: Retrieve a list of all games available on FreeToGame.

#### 2. Get Games by Category

- Endpoint:  @GET("games/")
- Description: Retrieve a list of games filtered by category.
- Parameters:
  - category (string): The category to filter games by.

#### 3. Get Games by Platform

- Endpoint:  @GET("games/")
- Description: Retrieve a list of games filtered by platform.
- Parameters:
  - platform (string): The platform to filter games by.
