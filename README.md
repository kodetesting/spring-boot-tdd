# Test Automation

### References
* [https://blog.jetbrains.com/idea/2020/09/writing-tests-with-junit-5/](https://blog.jetbrains.com/idea/2020/09/writing-tests-with-junit-5/)
* [https://www.baeldung.com/junit-5](https://www.baeldung.com/junit-5)

### Important Notes
* For the Test Suites -> Rule is Test Class must be suffixed with Test. while using SelectPackages

### TDD Reference Documentation
For further reference, please consider the following sections:

* Spring Boot Application with
  * SpringBootTest
  * Test with Different Spring Profiles
* Web Layer with
  * WebMvcTest
  * Reactive Test Later
* Data Layer with
  * DataJpaTest (Sql/NoSql)
* Service layer with
  * Mockito
* Kafka Testing
* Assert4J
* TestNG
* TestContainer


### Guides
Integration with CI/CD
* CI/CD with Github Action
* Linting with SonarQube
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



