# Employee API
> An introduction to RESTful API development using Spring Boot.

## Objectives
- [x] Build and understand basic RESTful API development.
- [x] Integrate embedded H2 database and access via JPA.
- [x] Implement basic CRUD operations.
- [x] Implement Docker containerization.
- [x] Implement Helm Charts.
- [x] Deploy to a Kubernetes cluster using Helm charts.
> Note: Successful deployment to a local Kubernetes cluster, however network challanges prevent hitting the API at the address/port. Using port forwarding to 8080 seems to do the trick... but thats about as far as we go here...


## Dependencies
- Java v20
- Docker Desktop install (and logged in)
  - K8s
  - oscarfonts/h2
- Helm (used Homebrew for dependencies on Mac OSX)
- kubectl (controls the Kubernetes cluster manager)

## Running Locally

**Build:**
```bash
./gradlew clean build
```

**Run:**
```bash
./gradlew bootRun
```

## Running With Docker
> Note: `jdoconnell` is simply my Docker Hub username. Substitue with your username.

**Build:**
```bash
docker build -t jdoconnell/employee-api:1.0.0 .
```

**Run:**
```bash
docker run -p 8080:8080 jdoconnell/employee-api:1.0.0
```

## Push to Docker Hub (to deploy with k8s)

**Login:**
```bash
docker login
```

**Push:**
```bash
docker push jdoconnell/employee-api:1.0.0
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