/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
*/
package grails.plugins.orm.auditable

import groovy.transform.CompileStatic
import org.springframework.core.NamedThreadLocal

/**
 * ThreadLocals for AuditLog
 *
 * User: Robert Oschwald
 * Date: 24.04.2014 05:57:44
 */
@CompileStatic
class AuditLogListenerState {
    public static final ThreadLocal<Boolean> auditLogEnabledThreadLocal = new NamedThreadLocal<>("auditLog.disabled")
    public static final ThreadLocal<Boolean> auditLogVerboseThreadLocal = new NamedThreadLocal<>("auditLog.nonVerbose")

    static void setAuditLogDisabled(boolean enabled) {
        auditLogEnabledThreadLocal.set(enabled)
    }

    static boolean getAuditLogDisabled() {
        auditLogEnabledThreadLocal.get()
    }

    static void clearAuditLogDisabled() {
        auditLogEnabledThreadLocal.remove()
    }

    static void setAuditLogNonVerbose(boolean enabled) {
        auditLogVerboseThreadLocal.set(enabled)
    }

    static boolean getAuditLogNonVerbose() {
        auditLogVerboseThreadLocal.get()
    }

    static void clearAuditLogNonVerbose() {
        auditLogVerboseThreadLocal.remove()
    }
}