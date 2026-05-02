/**
 * LDAP authentication example.
 * <p>
 * Configures Vert.x LDAP authentication against an LDAP directory.
 * Set the LDAP URL via the {@code VERTX_AUTH_LDAP_URL} environment variable.
 * <p>
 * LDAP provides AuthN only — combine with ABAC or another provider for AuthZ.
 */
@LdapAuthOptions(
    url = "${LDAP_URL:ldap://localhost:389}",
    authenticationQuery = "uid={0},ou=users,dc=example,dc=com",
    authenticationMechanism = "simple",
    referral = "follow"
)
package com.guicedee.examples.auth.ldap;

import com.guicedee.vertx.auth.ldap.LdapAuthOptions;

