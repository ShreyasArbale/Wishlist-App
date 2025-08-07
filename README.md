# Wishlist App

# 🎯 Wishlist App – Jetpack Compose Android App

<p><strong>Tech Stack:</strong> Kotlin, Room, MVVM</p>

<p>
  The Wishlist App is a modern Android application built using Jetpack Compose and MVVM architecture. It allows users to create, update, and manage their personal wishlists — whether for birthdays, shopping goals, travel plans, or anything they aspire to buy or achieve.
</p>

<p>
  <strong>Key Features:</strong>
  <ul>
    <li>✅ <strong>Add New Wishes:</strong> Enter the title, description, and priority of your wish.</li>
    <li>📝 <strong>Edit or Delete Wishes:</strong> Modify or remove wishes anytime.</li>
    <li>🎨 <strong>Clean UI:</strong> Designed using Jetpack Compose with smooth animations and Material 3 theming.</li>
    <li>☁️ <strong>Room Database Integration:</strong> All data is stored locally and persists between sessions.</li>
    <li>🧠 <strong>MVVM Pattern:</strong> Clean architecture using ViewModel, Repository, and Room.</li>
  </ul>
</p>

# ✨ Design

<div align="center">
  <div>
    <img src="https://github.com/user-attachments/assets/b20705d6-962d-4236-8d0e-acfb9eadbdf7" alt="Home Screen Without Premium" width="180"/>
    <img src="https://github.com/user-attachments/assets/15544f40-b880-4f84-8516-3c0cbf2b0919" alt="Home Screen With Premium" width="180"/>
    <img src="https://github.com/user-attachments/assets/01856637-08fe-4ae6-9864-7b1483b201a8" alt="Cotton Price List Screen" width="180"/>
    <img src="https://github.com/user-attachments/assets/1efa2316-01e8-4534-af07-9567e3f913cb" alt="Cotton Price Details Screen" width="180"/>
  </div>
  <div style="margin-top: 10px;">
    <img src="https://github.com/user-attachments/assets/87fbf339-b48f-499b-8cf3-da639ff5829d" alt="Yarn Price Details Screen" width="180"/>
    <img src="https://github.com/user-attachments/assets/6737e634-1ec3-4dd8-b1f9-33edbac1b685" alt="Yarn Price Details Screen 2" width="180"/>
    <img src="https://github.com/user-attachments/assets/3d6e4f98-1425-4d09-90ae-4207c48ba92d" alt="Calculator Options Screen" width="180"/>
  </div>
  <div style="margin-top: 10px;">
    <img src="https://github.com/user-attachments/assets/b00a464f-9c9a-4cfe-83f2-15b4ab8b379e" alt="Newsletter Screen" width="180"/>
    <img src="https://github.com/user-attachments/assets/82ca67c1-2c87-4f1a-ac46-5d920ece1148" alt="Newsletter Screen 2" width="180"/>
    <img src="https://github.com/user-attachments/assets/07631d0a-f528-41e2-a9cd-a1ca0f26c977" alt="Germenting Choice Screen" width="180"/>
    <img src="https://github.com/user-attachments/assets/7e1ddfbb-1d87-4e2b-9f3a-df9830c7cd59" alt="Sub-Newsletter Screen" width="180"/>
  </div>
  <div style="margin-top: 10px;">
    <img src="https://github.com/user-attachments/assets/b64ea2d0-4b8b-4923-b13f-7660543c926b" alt="Newsletter Details Screen" width="180"/>
    <img src="https://github.com/user-attachments/assets/ecd5b053-a3ba-47f8-91b2-94e4dde236d5" alt="Newsletter Details Screen 2" width="180"/>
    <img src="https://github.com/user-attachments/assets/9cb7ad9d-dcf4-499d-b03e-6f0539fbf773" alt="Newsletter Details Screen 3" width="180"/>
  </div>
  <div style="margin-top: 10px;">
    <img src="https://github.com/user-attachments/assets/023caf81-7e22-4906-86c3-74d2643e6af1" alt="Register Screen" width="180"/>
    <img src="https://github.com/user-attachments/assets/3b057680-e392-43ab-9ec6-30bcbafed769" alt="Login Screen" width="180"/>
    <img src="https://github.com/user-attachments/assets/998ff397-dd85-434f-9965-6be8939a54a0" alt="Skip Login Dialog" width="180"/>
    <img src="https://github.com/user-attachments/assets/6cd32d4b-46ac-4403-99e8-b3df305e82e9" alt="Logout Dialog" width="180"/>
  </div>
  <div style="margin-top: 10px;">
    <img src="https://github.com/user-attachments/assets/7bfcd4d4-422f-4b92-9b53-090e48695fdb" alt="Reset Password Screen" width="180"/>
    <img src="https://github.com/user-attachments/assets/0e89c1da-082e-4641-b8d4-009db89e902e" alt="Edit Profile Screen" width="180"/>
    <img src="https://github.com/user-attachments/assets/ea91f684-ecb5-4b03-94ce-e325e9792b2e" alt="Profile Screen" width="180"/>
    <img src="https://github.com/user-attachments/assets/09c98745-ed1c-49ae-9dbe-4c9322553838" alt="Settings Screen" width="180"/>
  </div>
  <div style="margin-top: 10px;">
    <img src="https://github.com/user-attachments/assets/6935b5b1-107a-4798-9391-33bca170090a" alt="Premium Screen" width="180"/>
    <img src="https://github.com/user-attachments/assets/62210031-f544-4091-b590-9a6cc4967bc1" alt="Feedback Screen" width="180"/>
    <img src="https://github.com/user-attachments/assets/62a730d3-5c91-4c01-a532-e4e8c8b6c5af" alt="Data Not Found Dialog" width="180"/>
  </div>
</div>
  
# 🛠 Made With 

- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous calls and tasks to utilize threads.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
  - [Room](https://developer.android.com/topic/libraries/architecture/room) - Room is an Android library which is an ORM that wraps Android's native SQLite database.

# 👷‍♂️ Architecture 

This app uses [MVVM(Model View View-Model)](https://developer.android.com/topic/architecture#recommended-app-arch) architecture.

![Architecture_Flow](https://user-images.githubusercontent.com/80090908/216841302-97243bc3-3df4-4416-8f1f-dc22398c86b1.png)


## Contact 📞
If you need any help, you can connect with me [here](https://www.linkedin.com/in/shreyas-arbale-11047b238/).
