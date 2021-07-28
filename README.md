# iJobs 👨‍💼

**iJobs** is a sample  Android application 📱 showing IT jobs of the world 👓 built to demonstrate use of *Modern Android development* tools. Dedicated to all Android Developers with ❤️. 


## About 
### Some edge cases that will come in future
It simply loads **Jobs** data from API. Jobs will be always loaded from Remote data (from API). 
- [x] Handle Network State Changes
- [x] Clean and Simple Material UI.
- [x] Clean and Simple Architecture(MVVVM).
- [ ] This makes it offline capable 😃.
- [ ] Pagination
- [ ] Unit test/Integrated Testing



*Dummy API is used in this app. JSON response is statically hosted [here](https://remotive.io/api/remote-jobs)*.


## Built With 🛠
- [SharedElements](https://developer.android.com/training/transitions/start-activity) - Shared elemnts between fragments with Navigation Component.
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..
- [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/) - A cold asynchronous data stream that sequentially emits values and completes normally or with an exception.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
  - [Room](https://developer.android.com/topic/libraries/architecture/room) - SQLite object mapping library.
- [Dependency Injection](https://developer.android.com/training/dependency-injection) - 
  - [`Koin`](https://insert-koin.io/) DI Version 🗡️
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
- [Moshi](https://github.com/square/moshi) - A modern JSON library for Kotlin and Java.
- [Moshi Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/moshi) - A Converter which uses Moshi for serialization to and from JSON.
- [Glide](https://github.com/bumptech/glide) - An image loading library for Android backed by Kotlin Coroutines.
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.
- [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) - For writing Gradle build scripts using Kotlin.



**Contributed By:** [islam elhady](https://github.com/islamelhady)

# Package Structure
    
    com.elhady.ijobs            # Root Package
    .
    ├── data                    # For data handling.
    │   ├── model               # Model classes.
    │   │   ├── dto             # Data Models 
    │   ├── local               # Local Persistence Database. Room (SQLite) database.
    |   │   └── dao             # Data Access Object for Room.
    |   ├── remote              # Remote Data Handlers.  
    |   │   └── api             # Retrofit API for remote end point.
    │   └── repository          # Single source of data.
    |      
    ├── di                      # Dependency Injection             
    │   ├── builder             # Activity Builder
    │   ├── component           # DI Components       
    │   └── module              # DI Modules
    |
    ├── ui                      # Activity/View layer
    │   ├── adapter             # Base Adapters Package
    |   │   ├  IjobAdapter      # Main adapter with ViewHolder for Jobs Items
    |   │   ├  Movies           # adapter with ViewHolder for Actor Movies
    |   │   └─ Images           # adapter with ViewHodler for Actor Images
    │   ├── view                # ui
    │   │   ├── home            # Main Screen Activity & ViewModel
    |   │   │   ├──Fragment     # Fragment
    |   │   │   └── viewmodel   # ViewModel for Main Fragmnet
    │   │   ├── details         # Detail Screen Fragment and ViewModel
    |   │   │   ├─ Fragment     # Fragment
    |   │   │   └─ viewmodel    # ViewModel for Details Fragmnet 
    │   │   ├── search          # Search Screen Fragment and ViewModel
    |   │   │   ├─ Fragment     # Fragment
    |   │   │   └─ viewmodel    # ViewModel for Details Fragmnet 
    │   │   ├── apply           # Apply Screen Fragment and ViewModel
    |   │   │   ├─ Fragment     # Fragment
    |   │   │   └─ viewmodel    # ViewModel for Details Fragmnet 
    │   │   ├── favourite       # Favourite Screen Fragment and ViewModel
    |   │   │   ├─ Fragment     # Fragment
    |   │   │   └─ viewmodel    # ViewModel for Details Fragmnet 
    |   
    └── utils                   # Utility Classes / Kotlin extensions
    
    
    
    

## Architecture
This app uses [***MVVM (Model View View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture.

![](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)

## Soon 🎈💪
 - Jobs will be always loaded from local database. Remote data (from API) and Local data is always synchronized.
 -  Try with [Hilt-Dagger](https://dagger.dev/hilt/) - Standard library to incorporate Dagger dependency injection into an Android application.
 



