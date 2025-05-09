/*
 *  Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.wso2.carbon.esb.getprocessor.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.carbon.automation.test.utils.http.client.HttpsResponse;
import org.wso2.carbon.automation.test.utils.http.client.HttpsURLConnectionClient;
import org.wso2.esb.integration.common.utils.CarbonLogReader;
import org.wso2.esb.integration.common.utils.ESBIntegrationTest;

import java.io.IOException;

public class FaviconTest extends ESBIntegrationTest {
    CarbonLogReader carbonLogReader = new CarbonLogReader();

    @BeforeClass(alwaysRun = true)
    protected void init() throws Exception {
        super.init();
        carbonLogReader.start();
    }

    @Test(groups = {"wso2.esb"}, description = "Test for ClosedChannel Exception")
    public void faviconTest() throws Exception {
        HttpsResponse response = HttpsURLConnectionClient.
                getRequest("https://localhost:8443/" + "favicon.ico", null);
        Assert.assertEquals(response.getResponseCode(), 404, "Response code mismatch");
        boolean exceptionFound = carbonLogReader.checkForLog("ClosedChannelException", DEFAULT_TIMEOUT);
        carbonLogReader.stop();
        Assert.assertTrue(!exceptionFound, "ClosedChannelException occurred while retrieving favicon.ico");
    }
}
