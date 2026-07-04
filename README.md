# arivoli-maan-core

Lightweight reusable core framework library for Spring Boot applications.

## Overview

`arivoli-maan-core` provides shared API models, exceptions, audit helpers, validation utilities, and constants that can be reused across multiple services without pulling in database, security, or application-specific dependencies.

## Requirements

- Java 21+
- Gradle 8.x (wrapper included)

## Installation

### Gradle

```gradle
dependencies {
    implementation 'com.arivoliacademy:arivoli-maan-core:0.1.0'
}
```

### Maven

```xml
<dependency>
    <groupId>com.arivoliacademy</groupId>
    <artifactId>arivoli-maan-core</artifactId>
    <version>0.1.0</version>
</dependency>
```

## Package Structure

| Package | Purpose |
|---------|---------|
| `com.arivoliacademy.maan.core.api` | Standard API response wrappers |
| `com.arivoliacademy.maan.core.exception` | Shared runtime exceptions |
| `com.arivoliacademy.maan.core.model` | Common enums and domain models |
| `com.arivoliacademy.maan.core.audit` | Audit metadata types |
| `com.arivoliacademy.maan.core.util` | General-purpose utilities |
| `com.arivoliacademy.maan.core.validation` | Validation helpers |
| `com.arivoliacademy.maan.core.constants` | Shared constants |

## Usage Examples

### Success response

```java
import com.arivoliacademy.maan.core.api.ApiResponse;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @GetMapping("/{id}")
    public ApiResponse<CourseDto> getCourse(@PathVariable Long id) {
        CourseDto course = courseService.findById(id);
        return ApiResponse.success("Course retrieved", course);
    }
}
```

### Error response mapping

```java
import com.arivoliacademy.maan.core.api.ErrorResponse;
import com.arivoliacademy.maan.core.exception.MaanException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MaanException.class)
    public ResponseEntity<ErrorResponse> handleMaanException(MaanException ex) {
        ErrorResponse body = ErrorResponse.of(
                ex.getHttpStatus(),
                HttpStatus.valueOf(ex.getHttpStatus()).getReasonPhrase(),
                ex.getMessage(),
                ex.getErrorCode()
        );
        return ResponseEntity.status(ex.getHttpStatus()).body(body);
    }
}
```

### Pagination

```java
import com.arivoliacademy.maan.core.api.PageResponse;

PageResponse<CourseDto> page = PageResponse.of(courses, pageNumber, pageSize, totalCount);
return ApiResponse.success(page);
```

### Operation result without exceptions

```java
import com.arivoliacademy.maan.core.api.OperationResult;

OperationResult<UserDto> result = userService.tryCreate(request);
if (result.success()) {
    return ApiResponse.success(result.data());
}
return ApiResponse.failure(result.message());
```

### Throwing domain exceptions

```java
import com.arivoliacademy.maan.core.exception.ResourceNotFoundException;
import com.arivoliacademy.maan.core.exception.ConflictException;

public CourseDto findById(Long id) {
    return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Course", id));
}

public void create(CreateCourseRequest request) {
    if (repository.existsByCode(request.code())) {
        throw new ConflictException("Course code already exists");
    }
}
```

### Audit metadata

Standard audit field names: `createdBy`, `createdAt`, `updatedBy`, `updatedAt`, `deletedBy`, `deletedAt`.

```java
import com.arivoliacademy.maan.core.audit.AuditInfo;
import com.arivoliacademy.maan.core.audit.Auditable;

public class CourseDto implements Auditable {
    private AuditInfo auditInfo;

    @Override
    public AuditInfo getAuditInfo() {
        return auditInfo;
    }

    @Override
    public void setAuditInfo(AuditInfo auditInfo) {
        this.auditInfo = auditInfo;
    }
}

AuditInfo created = AuditInfo.created("admin@example.com");
AuditInfo updated = created.withUpdated("editor@example.com");
```

### Utilities

```java
import com.arivoliacademy.maan.core.util.DateTimeUtils;
import com.arivoliacademy.maan.core.util.IdUtils;
import com.arivoliacademy.maan.core.util.StringUtils;
import com.arivoliacademy.maan.core.validation.ValidationUtils;

String requestId = IdUtils.generateUuid();
ValidationUtils.requireNonBlank(requestId, "requestId");
String slug = StringUtils.toSlug("Introduction to Java");
String timestamp = DateTimeUtils.formatInstant(DateTimeUtils.nowUtc());
```

## Build

```bash
./gradlew clean build
```

## Publish to Maven Central

Configure credentials and signing keys as environment variables or Gradle properties:

```properties
mavenCentralUsername=your-username
mavenCentralPassword=your-password
signingKey=your-armored-private-key
signingPassword=your-key-password
```

Then publish:

```bash
./gradlew publish
```

## Design Principles

- No JPA or database dependencies
- No Spring Security or JWT dependencies
- No customer-specific or internal business logic
- Small, composable building blocks for service modules

## License

Apache License 2.0. See [LICENSE](LICENSE).
