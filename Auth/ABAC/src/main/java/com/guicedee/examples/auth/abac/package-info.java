/**
 * ABAC (Attribute-Based Access Control) authorization example.
 * <p>
 * Uses inline JSON policies to define authorization rules.
 * ABAC is AuthZ only — pair with JWT or another AuthN provider.
 * <p>
 * The inline policy below grants the "web:DELETE" permission only to users
 * who authenticated with MFA.
 */
@AbacOptions(policies = {
    """
    {
      "name": "Admin full access",
      "attributes": {
        "/principal/groups": {"contains": "admin"}
      },
      "authorizations": [
        {"type": "wildcard", "permission": "*"}
      ]
    }
    """,
    """
    {
      "name": "Developer read-only",
      "attributes": {
        "/principal/groups": {"contains": "developer"}
      },
      "authorizations": [
        {"type": "wildcard", "permission": "web:GET"}
      ]
    }
    """
})
@JwtAuthOptions(
    keystorePath = "keystore.jceks",
    keystoreType = "jceks",
    keystorePassword = "${JWT_KEYSTORE_PASSWORD:secret}",
    algorithm = "HS256",
    issuer = "guicedee-example"
)
package com.guicedee.examples.auth.abac;

import com.guicedee.vertx.auth.abac.AbacOptions;
import com.guicedee.vertx.auth.jwt.JwtAuthOptions;

