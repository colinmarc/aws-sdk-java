/*
 * Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.services.config.model.transform;

import static com.amazonaws.util.StringUtils.UTF8;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.config.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.*;

/**
 * ConfigRuleMarshaller
 */
public class ConfigRuleJsonMarshaller {

    /**
     * Marshall the given parameter object, and output to a JSONWriter
     */
    public void marshall(ConfigRule configRule, JSONWriter jsonWriter) {
        if (configRule == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(...)");
        }

        try {
            jsonWriter.object();

            if (configRule.getConfigRuleName() != null) {
                jsonWriter.key("ConfigRuleName").value(
                        configRule.getConfigRuleName());
            }

            if (configRule.getConfigRuleArn() != null) {
                jsonWriter.key("ConfigRuleArn").value(
                        configRule.getConfigRuleArn());
            }

            if (configRule.getConfigRuleId() != null) {
                jsonWriter.key("ConfigRuleId").value(
                        configRule.getConfigRuleId());
            }

            if (configRule.getDescription() != null) {
                jsonWriter.key("Description")
                        .value(configRule.getDescription());
            }

            if (configRule.getScope() != null) {
                jsonWriter.key("Scope");
                ScopeJsonMarshaller.getInstance().marshall(
                        configRule.getScope(), jsonWriter);
            }

            if (configRule.getSource() != null) {
                jsonWriter.key("Source");
                SourceJsonMarshaller.getInstance().marshall(
                        configRule.getSource(), jsonWriter);
            }

            if (configRule.getInputParameters() != null) {
                jsonWriter.key("InputParameters").value(
                        configRule.getInputParameters());
            }

            if (configRule.getMaximumExecutionFrequency() != null) {
                jsonWriter.key("MaximumExecutionFrequency").value(
                        configRule.getMaximumExecutionFrequency());
            }

            if (configRule.getConfigRuleState() != null) {
                jsonWriter.key("ConfigRuleState").value(
                        configRule.getConfigRuleState());
            }

            jsonWriter.endObject();
        } catch (Throwable t) {
            throw new AmazonClientException(
                    "Unable to marshall request to JSON: " + t.getMessage(), t);
        }
    }

    private static ConfigRuleJsonMarshaller instance;

    public static ConfigRuleJsonMarshaller getInstance() {
        if (instance == null)
            instance = new ConfigRuleJsonMarshaller();
        return instance;
    }

}
