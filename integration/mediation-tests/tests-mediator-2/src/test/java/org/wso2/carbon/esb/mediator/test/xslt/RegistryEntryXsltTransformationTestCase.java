/*
 *Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *WSO2 Inc. licenses this file to you under the Apache License,
 *Version 2.0 (the "License"); you may not use this file except
 *in compliance with the License.
 *You may obtain a copy of the License at
 *
 *http://www.apache.org/licenses/LICENSE-2.0
 *
 *Unless required by applicable law or agreed to in writing,
 *software distributed under the License is distributed on an
 *"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *KIND, either express or implied.  See the License for the
 *specific language governing permissions and limitations
 *under the License.
 */
package org.wso2.carbon.esb.mediator.test.xslt;

import org.apache.axiom.om.OMElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.esb.integration.common.clients.registry.ResourceAdminServiceClient;
import org.wso2.esb.integration.common.utils.ESBIntegrationTest;

import java.net.URL;
import javax.activation.DataHandler;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class RegistryEntryXsltTransformationTestCase extends ESBIntegrationTest {
    @BeforeClass(alwaysRun = true)
    public void uploadSynapseConfig() throws Exception {
        super.init();
    }

    @Test(groups = {
            "wso2.esb" }, description = "Do XSLT transformation  by selecting the xslt file from config registry.")
    public void xsltTransformationFromConfigRegistry() throws Exception {
        OMElement response;

        response = axis2Client
                .sendCustomQuoteRequest(getProxyServiceURLHttp("xsltInConfRegistryTestProxy"), null, "IBM");
        assertNotNull(response, "Response message null");
        assertTrue(response.toString().contains("Code"), "Response does not contain the key word: Code");
        assertTrue(response.toString().contains("IBM"), "Response does not contain the key word: IBM");

    }

    @Test(groups = {
            "wso2.esb" }, description = "Do XSLT transformation by selecting the xslt file from governance registry.y")
    public void xsltTransformationFromGovernanceRegistry() throws Exception {
        OMElement response;
        response = axis2Client
                .sendCustomQuoteRequest(getProxyServiceURLHttp("xsltInGovRegistryTestProxy"), null, "IBM");
        assertNotNull(response, "Response message null");
        assertTrue(response.toString().contains("Code"), "Response does not contain the key word: Code");
        assertTrue(response.toString().contains("IBM"), "Response does not contain the key word: IBM");
    }

    @Test(groups = {
            "wso2.esb" }, description = "Do XSLT transformation by selecting the xslt file from resources.")
    public void xsltTransformationFromResources() throws Exception {
        OMElement response = axis2Client
                .sendCustomQuoteRequest(getProxyServiceURLHttp("xsltInResourcesTestProxy"), null, "IBM");
        assertNotNull(response, "Response message null");
        assertTrue(response.toString().contains("Code"), "Response does not contain the key word: Code");
        assertTrue(response.toString().contains("IBM"), "Response does not contain the key word: IBM");
    }
}
