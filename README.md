# Check-in platform for attending classes by keeping a safe distance

## General

The application provides the possibility to add students and classrooms (including the maximum capacity in order to keep a safe distance).The classes will also be defined as taking place in a certain classroom at a certain date and time period and students can register for a certain class and date. When the maximum capacity is reached, registering is not possible anymore. The application displays a list of classes and classrooms along with occupancy rate for a time period.

## Main specifications

* Multiple user roles: Guest (not logged in user), Student, Teacher, Admin.
* Start page (default): calendar with classes for this week. The classes will be displayed with minimum details: day and hour, classroom, teacher, capacity level.
* As a guest, when clicking on a class you are able to see its details. All the actions are disabled.
* As a student, when clicking on a class you are able to see its details and you are able to reserve your spot if it has free capacity.
* As a teacher, when clicking on a class you are able to see its details and you are able to edit some details (course name, classroom, etc.).
* As an admin, when clicking on a class you are able to see its details and you are able to edit all details.
* As an admin / teacher, when clicking on a class you are able to see its details and you are able to delete the item.
* As an admin / teacher you have the option to click on the calendar and create a new entry.

## Tools

* [Java SE 16][2]

* [Spring Boot][3]

* [Swagger][4]

* [H2 Database][1]

* [Gradle][5]

* [GIT][6]

* [Angular][7]

* [NodeJS + NPM][8]

[1]: https://www.h2database.com/html/main.html
[2]: https://www.oracle.com/java/technologies/javase/jdk16-archive-downloads.html
[3]: https://start.spring.io/
[4]: https://editor.swagger.io/
[5]: https://gradle.org/install/
[6]: https://git-scm.com/
[7]: https://angular.io/start
[8]: https://nodejs.org/en/
