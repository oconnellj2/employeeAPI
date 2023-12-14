# Employee API
> An introduction to RESTful API development using Spring Boot.

## Objectives
- [x] Build and understand basic RESTful API development.
- [x] Understand Web MVC.
- [x] Integrate embedded H2 database and access via JPA.
- [ ] Implement data abstraction with DTO mapping.
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

**Functional Test (in another terminal window):**
```bash
curl http://localhost:8080/employees
```

## Contributing
James O'Connell - jdoconnell@pm.me