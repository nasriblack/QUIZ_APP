# Java & Spring Boot Learning Roadmap

> This README is my personal learning guide to become a mid-to-senior Java backend engineer.  
> I will use it to track what I learn, take notes, follow projects, and link useful resources.


## Environment Setup

### To-Do
- [X] Install Java 25 (LTS)
- [X] Install IntelliJ IDEA (Community Edition)
- [X] Install Maven
- [X] Install Docker + Docker Compose

### Notes
- Docker Compose will be used for Redis, RabbitMQ, Postgres

### Links
#### Youtube
- [Channel SpringBoot : Telusko](https://www.youtube.com/@Telusko/playlists)
- [Channel SpringBoot: Programming Techie](https://www.youtube.com/@ProgrammingTechie/videos)
- [Spring tutorial ](https://www.youtube.com/watch?v=Zxwq3aW9ctU&list=PLsyeobzWxl7qbKoSgR5ub6jolI8-ocxCF)
- [Spring boot with redis example](https://www.youtube.com/watch?v=j65P_-yOX8g&t=130s)
- [Spring boot with Kafka example](https://www.youtube.com/watch?v=gpx7smdUkgU)
- [Spring boot Playlist !!](https://www.youtube.com/watch?v=h6aDu9e2L_s&list=PLsyeobzWxl7q6oUFts2erdot6jxF_lisP&index=11)


#### Other
- [Github examples spring6](https://github.com/navinreddy20/spring6-course)
- [Github Microservice (index=11)](https://github.com/navinreddy20/MicroserviceTutorials)
- [Github Java notes](https://github.com/navinreddy20/Javacode)


---


## Shortcut Intellij IDEA
  Ctrl+Shift+Backspace = it will navigate to the last edit position
  alt + 4 = bring up the console 
  Shift + Ctrl + Enter = auto complete ? 
  what => ctrl + w => it's like shift ctrl right or left cursor!
  ctrl + e => recently opened 
  alt + j => select the occurance and update
  `Shift+Shift` → search everything
  `Ctrl+Shift+A` → find actions
  `Ctrl+Alt+L` → format code
  `Alt+Insert` → generate code
  alt + & => it's like ctr + b in vscode => toggle the left bar

  alt + shif + up or down => it's like shift + up or down => move the ligne up and down 

## Core Java Essentials


## Notes

@Respository => tell spring this class is responsable for Data access .

```java
@Repository
public interface QuestionDao extends JpaRepository<Question,Integer>{

}
```
=> Question is the Model , Integer is the ID or the primary key

### To-Do
- [ ] Learn immutability & final keyword
- [ ] Learn Optional
- [ ] Learn Streams API (map/filter/reduce)
- [ ] Learn CompletableFuture
- [ ] Learn Records (Java 16+)
- [ ] Understand exceptions (checked vs unchecked)

### Notes
- Streams vs loops: Streams are expressive but not always performant
- CompletableFuture: async processing without blocking threads
- Optional: never return null, always use Optional in APIs

### Links
- [Java Streams Guide](https://www.baeldung.com/java-8-streams)
- [CompletableFuture](https://www.baeldung.com/java-completablefuture)
- [Records in Java](https://openjdk.org/jeps/395)

---

## Spring Boot Basics

### To-Do
- [ ] Learn @Configuration, @Bean, Constructor Injection
- [ ] Learn Profiles and application.yml
- [ ] Learn Spring Boot Actuator
- [ ] Build first small service: transform events from REST endpoint

### Notes
- Constructor injection > field injection
- Use profiles for dev/test/prod
- Actuator gives health, metrics, and environment info

### Links
- [Spring Boot Reference](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Spring Guides: Building RESTful Web Service](https://spring.io/guides/gs/rest-service/)

---

## Project: Event Processing Platform

### Idea
- 3 microservices:
  1. Producer Service → sends events to RabbitMQ
  2. Processor Service → consumes, applies rules, caches in Redis
  3. Consumer Service → reads from Redis, exposes API
- Learn async processing, caching, message retry, idempotency

### To-Do
- [ ] Design folder structure for services
- [ ] Setup RabbitMQ & Redis in Docker
- [ ] Build Producer Service
- [ ] Build Processor Service
- [ ] Build Consumer Service

### Notes
- Use correlation IDs for tracing
- DLQ = Dead Letter Queue for failed messages
- Keep services stateless as much as possible

### Links
- [Spring AMQP](https://spring.io/projects/spring-amqp)
- [Redis Spring Data](https://spring.io/projects/spring-data-redis)
- [Microservices with Spring Boot](https://spring.io/microservices)

---

## Messaging & Caching

### To-Do
- [ ] Learn RabbitMQ exchanges, queues, routing keys
- [ ] Implement retry & dead-letter queues
- [ ] Learn Redis caching strategies & TTL

### Notes
- Messages may arrive out of order → design processors accordingly
- Redis TTL = cache expiration
- Retry logic should be idempotent

### Links
- [RabbitMQ Tutorials](https://www.rabbitmq.com/getstarted.html)
- [Redis TTL & Caching](https://redis.io/docs/manual/)

---

## Spring Cloud & Microservices

### To-Do
- [ ] Learn Eureka Service Discovery
- [ ] Learn Spring Cloud Config Server
- [ ] Learn OpenFeign for service-to-service calls
- [ ] Add Resilience4j for circuit breakers & retries

### Notes
- Service discovery avoids hardcoding URLs
- Config server centralizes app configs
- Circuit breakers prevent cascading failures

### Links
- [Spring Cloud Docs](https://spring.io/projects/spring-cloud)
- [Resilience4j Guide](https://resilience4j.readme.io/)

---

## Observability & Metrics

### To-Do
- [ ] Add structured logging (JSON)
- [ ] Add correlation IDs
- [ ] Add Micrometer metrics
- [ ] Learn health checks

### Notes
- Correlation IDs = trace requests across services
- Metrics + logging = essential for debugging prod

### Links
- [Micrometer Docs](https://micrometer.io/)
- [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)

---

## Testing & Quality

### To-Do
- [ ] Learn integration tests (Spring Boot Test)
- [ ] Learn Testcontainers for Docker-based tests
- [ ] Learn contract testing
- [ ] Skip 100% unit tests obsession

### Notes
- Test async flows thoroughly
- Use containerized dependencies for integration tests

### Links
- [Spring Boot Testing](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing)
- [Testcontainers](https://www.testcontainers.org/)

---

## Extra Notes & Links

- Always read Spring source code for understanding  
- Break your own system on purpose → learn resilience  
- Practice refactoring safely  
- Keep README updated with every lesson  

### Useful Blogs / Resources
- [Baeldung Java & Spring](https://www.baeldung.com/)
- [Spring.io Guides](https://spring.io/guides)
- [Martin Fowler – Microservices](https://martinfowler.com/microservices/)

---

## How to Use This README

1. **Pick a To-Do**  
2. **Work hands-on** (write code, break it, debug it)  
3. **Take notes in the Notes section**  
4. **Add new links or tips as you discover them**  
5. **Repeat until you feel confident in each section**

> Treat this README as both your roadmap **and your personal cheat sheet**.
