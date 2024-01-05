# Employee API
> An introduction to RESTful API development using Spring Boot.

## Objectives
- [x] Build and understand basic RESTful API development.
- [x] Integrate embedded H2 database and access via JPA.
- [x] Implement basic CRUD operations.
- [x] Implement Docker containerization.
- [x] Implement Helm Charts.
- [x] Deploy to a Kubernetes cluster using Helm charts.

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

## Install helm charts to deploy to k8s

**Install:**
```bash
helm install employeeapi-release ./helm
```
> You should now see Kubernetes deployment(s) and Pod(s) on your Docker desktop or via CLI

**Check your pods:**
```bash
kubectl get pods
```
> Check out more kubectl commands you can use to manage your deployment (i.e. describe, logs, get deployments...).

**Validate with port forwarding**
- I had some timeout issues that I suspect are related to network firewalls on my machine when hitting `http://10.1.0.52:32312/employees`.
- Therefore, I simply forwarded the port to 8080 to validate:
```bash
kubectl port-forward service/employee-api-service 8080:32312
```
- Now:
```bash
curl -v http://localhost:8080/employees | json_pp

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