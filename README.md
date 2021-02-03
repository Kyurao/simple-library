# simple-library
A simple REST application with CRUD for the test task.

Create a RESTful Spring Boot application that will represent a simple "Library" system with two main entities - User and Book. A user can have many books and a book can only belong to 1 user. A book can be free (allowed to be taken by other users) or taken (not allowed to be taken by other users)

Rest controllers should allow to:
- CRUD user
- CRUD book
- Take a book (a book will become taken by a certain user)
- Return book (a book will be free for another user to take)
- (Optional) Get information about the users and the books they currently have 

No UI is needed.
Use any ORM you like