# Employee API
> An introduction to RESTful API development using Spring Boot.

## Objectives
- [x] Build and understand basic RESTful API development.
- [x] Integrate embedded H2 database and access via JPA.
- [x] Implement basic CRUD operations.
- [ ] Implement Databse abstraction with DTO mapping.
- [ ] Implement Kubernetes containerization.
- [ ] Implement API documentation
- [ ] Implement Role-based security :shrug:


## Dependencies
- Java v20
- *More to be added as I try to remember how I setup my env.*

## Running Locally

**Build:**
```bash
./gradlew clean build
```

**Run:**
```bash
./gradlew bootRun
```

## Basic Functional Tests

`GET /employees` -> Retrieve all employees.
```bash
curl -v http://localhost:8080/employees | json_pp
```

`GET /employees/{id}` -> Retrieve an employee by id.
```bash
curl -v http://localhost:8080/employees/2 | json_pp
```

`POST /employees` -> Insert a new employee.
```bash
curl -X POST \
  -H "Content-Type: application/json" \
  -d '{"name": "Gandalf", "role": "wizard}"' \
  http://localhost:8080/employees
```

`PUT /employees/{id}` -> Update an existing employee by id.
```bash
curl -X PUT \
  -H "Content-Type: application/json" \
  -d '{"role": "Software Engineer"}' \ 
  http://localhost:8080/employees/1
```

`DELETE /employees/{id}` -> Remove an existing employee by id.
```bash
curl -X DELETE http://localhost:8080/employees/1
```

## Contributing
James O'Connell - jdoconnell@pm.me