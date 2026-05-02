/**
 * Property File authentication and authorization example.
 * <p>
 * Uses an Apache Shiro-style properties file for user credentials and role assignments.
 * Provides both AuthN and AuthZ from a single file.
 *
 * @see #auth.properties for user/role definitions
 */
@PropertyFileAuthOptions(path = "auth.properties")
package com.guicedee.examples.auth.properties;

import com.guicedee.vertx.auth.properties.PropertyFileAuthOptions;

