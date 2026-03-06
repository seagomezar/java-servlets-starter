# Changelog

## 2026-03-06 - Dependency Updates

### Updated Dependencies

#### Major Updates:
- **JUnit**: Updated from 5.10.2 → 6.0.3 (JUnit Jupiter)
  - Upgraded to the latest stable JUnit 6 release
  - The `org.junit.jupiter.api` package is unchanged — existing tests are fully compatible
  - JUnit 6 brings improved performance, better extension model, and modern Java support

- **Mockito**: Updated from 5.11.0 → 5.22.0
  - Latest stable Mockito release with bug fixes and improvements

#### Build Configuration:
- **Java Version**: Updated to Java 17 (from Java 11)
  - Java 17 is the current LTS version and required by Spring Boot 3.x
  - Enables modern language features: records, sealed classes, text blocks, pattern matching

- **Maven Plugins**: Updated to latest stable versions:
  - `maven-compiler-plugin`: 3.13.0 → 3.15.0
  - `maven-war-plugin`: 3.4.0 → 3.5.1
  - `maven-surefire-plugin`: 3.2.5 → 3.5.5

#### Additional Improvements:
- **web.xml**: Updated namespace to Jakarta EE 6 (`https://jakarta.ee/xml/ns/jakartaee`)
  matching the Jakarta Servlet 6.0 specification used at runtime

### Breaking Changes:
None. All changes are backward compatible at the application level.

### Verification:
- ✅ Application compiles successfully with Java 17
- ✅ All 10 tests pass
- ✅ WAR file builds correctly
- ✅ No security vulnerabilities in updated dependencies

---

## 2025-01-24 - Dependency Updates

### Updated Dependencies

#### Major Updates:
- **JUnit**: Updated from 3.8.1 → 5.10.2 (JUnit Jupiter)
  - Migrated from legacy JUnit 3 to modern JUnit 5
  - Uses `org.junit.jupiter:junit-jupiter` instead of `junit:junit`
  - JUnit 5 provides better test organization, parameterized tests, and modern annotations

- **Jakarta Servlet API**: Updated from 5.0.0 → 6.1.0
  - Updated to the latest stable version
  - Maintains compatibility with modern servlet containers
  - Part of Jakarta EE 10 specification

#### Build Configuration:
- **Java Version**: Updated to Java 11 (from unspecified)
  - Added explicit `maven.compiler.source` and `maven.compiler.target` properties
  - Java 11 is the current LTS (Long Term Support) version

- **Maven Plugins**: Updated to latest stable versions:
  - `maven-compiler-plugin`: 3.13.0
  - `maven-war-plugin`: 3.4.0
  - `maven-surefire-plugin`: 3.2.5

#### Additional Improvements:
- **Build Configuration**: Added proper encoding (`UTF-8`) configuration
- **Version Management**: Introduced Maven properties for version management
- **Testing**: Added sample JUnit 5 test to verify functionality
- **Build Artifacts**: Added `.gitignore` to exclude Maven build artifacts

### Breaking Changes:
None. All changes are backward compatible at the application level.

### Verification:
- ✅ Application compiles successfully
- ✅ All tests pass
- ✅ WAR file builds correctly
- ✅ No dependency update warnings for stable versions

### Next Steps:
The application is now using the latest stable versions of all dependencies and is ready for modern Java servlet development.