# Release Note: Improve SonarQube Duplicate Detection
 Date: 2025-07-23
## Summary
This update improves SonarQube configuration to ensure code duplication is detected and reported correctly in analysis reports.

##  What was changed?

### 1. Updated `sonar-project.properties`
```properties
sonar.projectKey=apitest
sonar.projectName=apitest
sonar.host.url=http://localhost:9000
sonar.login=sqa_****************************

sonar.sources=src/main/java
sonar.java.binaries=target/classes
sonar.inclusions=**/*.ts,**/*.java
```
### 2. change @Autowire is Constructor Injection
`TokenController`
```
    @Autowire
    private final TokenService tokenService;

```
```
    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }
```
`TokenService`
```
    @Autowire
    private final SsoUserRepository repository;

```
```
    private final SsoUserRepository repository;

    public TokenService(SsoUserRepository repository) {
        this.repository = repository;
    }
```
## Result
<img width="1705" height="911" alt="image" src="https://github.com/user-attachments/assets/e9dfe4ce-3f61-4cfc-ad6a-66a035351ebd" />


