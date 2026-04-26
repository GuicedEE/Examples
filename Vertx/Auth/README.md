# Vert.x Auth Example

Demonstrates **JWT authentication** + **property-file authorization** with GuicedEE.

## What's inside

| File | Purpose |
|---|---|
| `package-info.java` | `@JwtAuthOptions` + `@PropertyFileAuthOptions` annotations |
| `AuthResource.java` | REST endpoints: login, protected, admin-only |
| `auth.properties` | Users, passwords, roles, permissions (Shiro format) |
| `auth-keystore.jceks` | HS256 key for JWT signing |

## How to run

```bash
# Set the keystore password
export JWT_KEYSTORE_PASSWORD=secret

# Build and run
mvn clean compile exec:java -Dexec.mainClass=com.guicedee.examples.vertx.auth.AuthExample
```

## Endpoints

### Login
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"tim","password":"mypassword"}'
```
Returns: `{"token":"eyJ...","type":"Bearer"}`

### Protected (any authenticated user)
```bash
curl http://localhost:8080/api/auth/me \
  -H "Authorization: Bearer <token>"
```

### Admin only (@RolesAllowed)
```bash
curl http://localhost:8080/api/auth/admin \
  -H "Authorization: Bearer <token>"
```
Only works for `tim` (who has `administrator` role).

## Users (from auth.properties)

| User | Password | Roles |
|---|---|---|
| tim | mypassword | administrator, developer |
| bob | hispassword | developer |
| joe | anotherpassword | manager |

## Switching providers

To use **OAuth2** instead, replace the annotation in `package-info.java`:

```java
@OAuth2Options(
    flow = OAuth2Options.FlowType.AUTH_CODE,
    clientId = "${OAUTH2_CLIENT_ID}",
    clientSecret = "${OAUTH2_CLIENT_SECRET}",
    discoveryUrl = "https://accounts.google.com/.well-known/openid-configuration"
)
package com.guicedee.examples.vertx.auth;
```

Other available providers: `@AbacOptions`, `@OtpAuthOptions`, `@LdapAuthOptions`,
`@HtpasswdAuthOptions`, `@HtdigestAuthOptions`.

