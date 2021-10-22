# Jobs App 👨‍💼

**Jobs App** is a sample  Android application 📱 showing IT jobs of the world 👓 built to demonstrate use of *Modern Android development* tools. Dedicated to all Android Developers with ❤️. 


## About
It simply loads **IT Jobs** data from API. 
- Clean and Simple Material UI.
- Clean and Simple Architecture(MVVM).

### Some edge cases that will come in future
It simply loads **Jobs** data from API. Jobs will be always loaded from Remote data (from API). 
- [x] Handle Network State Changes
- [x] Clean and Simple Material UI.
- [x] Clean and Simple Architecture(MVVM).
- [x] This makes it offline capable.
- [ ] Pagination
- [ ] Unit test/Integrated Testing


*Dummy API is used in this app. JSON response is statically hosted [here](https://remotive.io/api/remote-jobs)*.


## Architecture
This app uses [***MVVM (Model View View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture.

![](https://miro.medium.com/max/3000/1*TTKpvdzyNXfPBhVyRqD6EA.png)

## Built With 🛠
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..
- [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/) - A cold asynchronous data stream that sequentially emits values and completes normally or with an exception.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [StateView](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow) - Flow APIs that enable flows to optimally emit state updates and emit values to multiple consumers.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
  - [DataBinding](https://developer.android.com/topic/libraries/data-binding) - that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.
  - [Room](https://developer.android.com/topic/libraries/architecture/room) - SQLite object mapping library.
- [Dependency Injection](https://developer.android.com/training/dependency-injection) - 
  - [`Koin`](https://insert-koin.io/) DI Version 🗡️
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
- [Moshi](https://github.com/square/moshi) - A modern JSON library for Kotlin and Java.
- [Moshi Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/moshi) - A Converter which uses Moshi for serialization to and from JSON.
- [Glide](https://github.com/bumptech/glide) - An image loading library for Android backed by Kotlin Coroutines.
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.


## Soon 💪
 - Jobs will be always loaded from local database. Remote data (from API) and Local data is always synchronized.
 - Try with [Hilt-Dagger](https://dagger.dev/hilt/) - Standard library to incorporate Dagger dependency injection into an Android application.


## Find this repository useful? 
Support it by joining __[stargazers](https://github.com/islamelhady/jobapp/stargazers)__ for this repository. :star: <br>
And __[follow](https://github.com/islamelhady)__ me for my next creations

**Contributed By:** [islam elhady](https://github.com/islamelhady)
