/*
 *  Copyright (c) 2022, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.wso2.carbon.caching.impl;

/**
 * This is used for tenant related caching operations
 */
public interface TenantCacheManager {

    /**
     * Remove cache manager stored for a tenant domain. This can be used for special requirements such as tenant
     * deletion.
     *
     * @param tenantDomain tenant domain. Value should not be null
     */
    void removeCacheManagerMap(String tenantDomain);
}
