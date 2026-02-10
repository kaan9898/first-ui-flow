First UI Flow + Spring Security


Project Description


This project is a Spring Boot application that demonstrates:
A simple item list and create flow
In-memory storage (no database)
Spring Security login system
Role-based access control (USER and ADMIN)


Remember Me functionality


Features


Practical 1 – UI Flow


GET /items → Shows list of items
GET /items/new → Shows create item form
POST /items → Saves item in memory and redirects to list
Items are stored in memory using a Map (no database).


Practical 2 – Login & Roles


In-memory users:
admin / admin → ROLE_ADMIN
user / user → ROLE_USER
Access rules:
/items → Accessible after login
/items/new → ADMIN only
POST /items → ADMIN only
USER cannot access the create flow (both UI and backend restricted).


Security


Form-based login
BCrypt password encoding
Custom 403 (Access Denied) page
Remember Me functionality enabled on backend


Remember Me


Users can select "Remember Me" during login
Login session is stored in a cookie
User remains authenticated even after browser restart (for configured duration)


Technologies Used


Java
Spring Boot
Spring MVC
Spring Security
Thymeleaf
Maven


How to Run


Run the Spring Boot application
Open browser:
http://localhost:8080/login


Result


✔ Working list and create flow
✔ Login system implemented
✔ Role-based restrictions working
✔ Remember Me functionality enabled
✔ In-memory storage
