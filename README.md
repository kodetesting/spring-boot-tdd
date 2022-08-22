# Test Automation

### References
* [https://blog.jetbrains.com/idea/2020/09/writing-tests-with-junit-5/](https://blog.jetbrains.com/idea/2020/09/writing-tests-with-junit-5/)
* [https://www.baeldung.com/junit-5](https://www.baeldung.com/junit-5)
* [https://spring.io/guides/gs/testing-web/](https://spring.io/guides/gs/testing-web/)
* [https://www.digitalocean.com/community/tutorials/spring-boot-mongodb](https://www.digitalocean.com/community/tutorials/spring-boot-mongodb)
* [https://jschmitz.dev/posts/how_to_test_the_data_layer_of_your_spring_boot_application_with_dataMongotest/](https://jschmitz.dev/posts/how_to_test_the_data_layer_of_your_spring_boot_application_with_dataMongotest/)


### Important Notes
* For the Test Suites -> Rule is Test Class must be suffixed with Test. while using SelectPackages

### TDD Reference Documentation
First starts with basic handson on the following
* Junit 5 
* TestSuite
* Assert4J
* Mockito
* TestNG
* TestContainer

For further reference, please consider the following sections:
* Spring Boot Application with
  * SpringBootTest
  * Test with Different Spring Profiles
* Web Layer with
  * WebMvcTest
  * Reactive Test Later
* Data Layer with
  * DataJpaTest (Sql/NoSql)
  * Spring Data with Embeded Mongo
    * create `application.properties` in test/resources folder
    * Add following property, after that `SpringBootTest` will start working. 
    ```
      spring.mongodb.embedded.version=3.6.5
      mongo.db.name=testdb
      mongo.db.url=localhost
      mongo.db.port=12345
    ```
    * Adding `@AutoConfigureDataMongo` is optional till this commit. 
* Service layer with
  * Mockito
* Kafka Testing
* Assert4J
* TestNG
* TestContainer


### Guides
Integration with CI/CD
* CI/CD with Github Action
* Code Quality - Linting with SonarQube
* CodeCoverage with Jococo
* Build Image - Docker/RPM
* Monitoring with - Prometheus/Grafna


## Junit Annotations Summary
Basic Annotation
* @DisplayName – defines a custom display name for a test class or a test method
* @Disable – disables a test class or method (previously @Ignore)
* @Tag – declares tags for filtering tests

Advance Annotation
* @Nested – denotes that the annotated class is a nested, non-static test class
* @ExtendWith – registers custom extensions

Life Cycle Annotation 
* @BeforeEach – denotes that the annotated method will be executed before each test method (previously @Before)
* @AfterEach – denotes that the annotated method will be executed after each test method (previously @After)
* @BeforeAll – denotes that the annotated method will be executed before all test methods in the current class (previously @BeforeClass)
* @AfterAll – denotes that the annotated method will be executed after all test methods in the current class (previously @AfterClass)



# SPRING DATA MONGO
```
let devdb = db.getSiblingDB('dev_db')
devdb.createUser({user:"dev_user", pwd:"dev_user",roles: ["readWrite","dbAdmin"]});
```

