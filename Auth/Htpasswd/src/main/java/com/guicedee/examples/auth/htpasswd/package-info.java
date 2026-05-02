/**
 * htpasswd authentication example.
 * <p>
 * Uses an Apache-style htpasswd file for password-based authentication.
 * Generate the file with: {@code htpasswd -c .htpasswd username}
 * <p>
 * htpasswd provides AuthN only.
 */
@HtpasswdAuthOptions(path = ".htpasswd", plainTextEnabled = false)
package com.guicedee.examples.auth.htpasswd;

import com.guicedee.vertx.auth.htpasswd.HtpasswdAuthOptions;

