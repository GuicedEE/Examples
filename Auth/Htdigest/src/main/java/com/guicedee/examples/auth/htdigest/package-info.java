/**
 * htdigest authentication example.
 * <p>
 * Uses an Apache-style htdigest file for HTTP Digest authentication.
 * Generate the file with: {@code htdigest -c .htdigest "realm" username}
 * <p>
 * htdigest provides AuthN only.
 */
@HtdigestAuthOptions(path = ".htdigest")
package com.guicedee.examples.auth.htdigest;

import com.guicedee.vertx.auth.htdigest.HtdigestAuthOptions;

