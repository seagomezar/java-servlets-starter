# Changelog

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