# Mobile Android Engineer Coding Challenge

# Restaurant Reservation App

This project is a restaurant reservation application built using Kotlin and Jetpack Compose. It follows Clean Architecture principles and features a layered architecture, separating concerns into domain, data, and presentation layers. The first thing that was worked on was the architecture, transitioning entirely to Compose. This brought about some issues that were resolved, such as outdated Gradle versions, as well as dependencies and plugins.

Regarding the architecture, Clean Architecture and Layered Feature were used. A domain layer was created for the business logic, a data layer for the implementation of interfaces and external connections, and a presentation layer for the UI where all the composables are located. Furthermore, this is separated by feature, in this case, reservations. This app is designed to continue growing.

Imagine we want to add a new feature for online orders or customer service. It would be as simple as adding a new module with the name of the feature and within it, create the separation that Clean Architecture recommends (presenter - data - domain).

## Architecture
- **Domain Layer**: Contains the business logic of the application, including entities, use cases, and repository interfaces.
- **Data Layer**: Implements the repository interfaces defined in the domain layer. It handles data retrieval and manipulation, including API calls and database operations.
- **Core Layer**: The core layer is designed for shared resources such as drawable resources and string resources.
- **Presentation Layer**: Handles the UI components of the application, implemented using Jetpack Compose. It includes screens, composables, and view models.

## Features
- **Reservation List**: Displays a list of tables, indicating their availability. Green indicates an available table, while red indicates a reserved table.
- **Table Reservation**: Allows users to reserve a table by selecting a customer to assign to the table.
- **Reservation Deletion**: Provides the ability to delete a reservation, updating the table's status accordingly.
- **Offline Support**: Utilizes caching to store data retrieved from the API, allowing offline access to reservation information.


## Test
The project has UI tests and unit tests.
Tools for test: MockK, Moshi
- **UI Test**: We can find them in the app androidTest directory
- **Unit Test Use Cases**: Use cases test are located in domain unit test directory
- **Unit Test Repository**: The repository cases are located in data layer unit test directory

## Future Improvements
- **View Model Unit Test**: Add more Unit tests for the View models

## Contributing
Contributions are welcome! If you have any suggestions, bug fixes, or feature requests, please let me know.


![Tables List](mobile-android-engineer/core/src/main/res/drawable/tables_screen.png)
![Customers List](mobile-android-engineer/core/src/main/res/drawable/customers_list.png)
![Dialog](mobile-android-engineer/core/src/main/res/drawable/customers_list.png)
