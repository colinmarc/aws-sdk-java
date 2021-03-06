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
package com.amazonaws.services.route53;

import org.w3c.dom.*;

import java.net.*;
import java.util.*;
import java.util.Map.Entry;

import com.amazonaws.*;
import com.amazonaws.auth.*;
import com.amazonaws.handlers.*;
import com.amazonaws.http.*;
import com.amazonaws.internal.*;
import com.amazonaws.metrics.*;
import com.amazonaws.regions.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.*;
import com.amazonaws.util.AWSRequestMetrics.Field;

import com.amazonaws.services.route53.model.*;
import com.amazonaws.services.route53.model.transform.*;

/**
 * Client for accessing AmazonRoute53.  All service calls made
 * using this client are blocking, and will not return until the service call
 * completes.
 * <p>
 * 
 */
public class AmazonRoute53Client extends AmazonWebServiceClient implements AmazonRoute53 {

    /** Provider for AWS credentials. */
    private AWSCredentialsProvider awsCredentialsProvider;

    /**
     * List of exception unmarshallers for all AmazonRoute53 exceptions.
     */
    protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers
            = new ArrayList<Unmarshaller<AmazonServiceException, Node>>();

    /**
     * Constructs a new client to invoke service methods on
     * AmazonRoute53.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonRoute53Client() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonRoute53.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonRoute53
     *                       (ex: proxy settings, retry counts, etc.).
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonRoute53Client(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonRoute53 using the specified AWS account credentials.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     */
    public AmazonRoute53Client(AWSCredentials awsCredentials) {
        this(awsCredentials, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonRoute53 using the specified AWS account credentials
     * and client configuration options.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonRoute53
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonRoute53Client(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
        init();
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonRoute53 using the specified AWS account credentials provider.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     */
    public AmazonRoute53Client(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonRoute53 using the specified AWS account credentials
     * provider and client configuration options.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonRoute53
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonRoute53Client(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(awsCredentialsProvider, clientConfiguration, null);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonRoute53 using the specified AWS account credentials
     * provider, client configuration options, and request metric collector.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonRoute53
     *                       (ex: proxy settings, retry counts, etc.).
     * @param requestMetricCollector optional request metric collector
     */
    public AmazonRoute53Client(AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration,
            RequestMetricCollector requestMetricCollector) {
        super(clientConfiguration, requestMetricCollector);
        this.awsCredentialsProvider = awsCredentialsProvider;
        init();
    }

    private void init() {
        exceptionUnmarshallers.add(new NoSuchChangeExceptionUnmarshaller());
        exceptionUnmarshallers.add(new HealthCheckAlreadyExistsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TooManyTrafficPolicyInstancesExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidArgumentExceptionUnmarshaller());
        exceptionUnmarshallers.add(new ConflictingTypesExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidInputExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TrafficPolicyAlreadyExistsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TrafficPolicyInUseExceptionUnmarshaller());
        exceptionUnmarshallers.add(new NoSuchHostedZoneExceptionUnmarshaller());
        exceptionUnmarshallers.add(new NoSuchGeoLocationExceptionUnmarshaller());
        exceptionUnmarshallers.add(new HostedZoneAlreadyExistsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TooManyHostedZonesExceptionUnmarshaller());
        exceptionUnmarshallers.add(new HostedZoneNotEmptyExceptionUnmarshaller());
        exceptionUnmarshallers.add(new NoSuchTrafficPolicyExceptionUnmarshaller());
        exceptionUnmarshallers.add(new IncompatibleVersionExceptionUnmarshaller());
        exceptionUnmarshallers.add(new ConflictingDomainExistsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new ConcurrentModificationExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidVPCIdExceptionUnmarshaller());
        exceptionUnmarshallers.add(new NoSuchTrafficPolicyInstanceExceptionUnmarshaller());
        exceptionUnmarshallers.add(new PublicZoneVPCAssociationExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidDomainNameExceptionUnmarshaller());
        exceptionUnmarshallers.add(new LimitsExceededExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TooManyHealthChecksExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidTrafficPolicyDocumentExceptionUnmarshaller());
        exceptionUnmarshallers.add(new NoSuchDelegationSetExceptionUnmarshaller());
        exceptionUnmarshallers.add(new ThrottlingExceptionUnmarshaller());
        exceptionUnmarshallers.add(new VPCAssociationNotFoundExceptionUnmarshaller());
        exceptionUnmarshallers.add(new PriorRequestNotCompleteExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DelegationSetAlreadyCreatedExceptionUnmarshaller());
        exceptionUnmarshallers.add(new HealthCheckInUseExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidChangeBatchExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TooManyTrafficPoliciesExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DelegationSetInUseExceptionUnmarshaller());
        exceptionUnmarshallers.add(new HealthCheckVersionMismatchExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DelegationSetAlreadyReusableExceptionUnmarshaller());
        exceptionUnmarshallers.add(new NoSuchHealthCheckExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TrafficPolicyInstanceAlreadyExistsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new LastVPCAssociationExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DelegationSetNotAvailableExceptionUnmarshaller());
        exceptionUnmarshallers.add(new HostedZoneNotFoundExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DelegationSetNotReusableExceptionUnmarshaller());
        
        exceptionUnmarshallers.add(new StandardErrorUnmarshaller());
        
        // calling this.setEndPoint(...) will also modify the signer accordingly
        this.setEndpoint("route53.amazonaws.com");
        
        HandlerChainFactory chainFactory = new HandlerChainFactory();
        requestHandler2s.addAll(chainFactory.newRequestHandlerChain(
                "/com/amazonaws/services/route53/request.handlers"));
        requestHandler2s.addAll(chainFactory.newRequestHandler2Chain(
                "/com/amazonaws/services/route53/request.handler2s"));
    }

    /**
     * <p>
     * Gets information about a specified traffic policy instance.
     * </p>
     * <p>
     * To get information about the traffic policy instance, send a
     * <code>GET</code> request to the
     * <code>2013-04-01/trafficpolicyinstance</code> resource.
     * </p>
     * <p>
     * <b>NOTE:</b>After you submit a CreateTrafficPolicyInstance or an
     * UpdateTrafficPolicyInstance request, there's a brief delay while
     * Amazon Route 53 creates the resource record sets that are specified in
     * the traffic policy definition. For more information, see the State
     * response element.
     * </p>
     *
     * @param getTrafficPolicyInstanceRequest Container for the necessary
     *           parameters to execute the GetTrafficPolicyInstance service method on
     *           AmazonRoute53.
     * 
     * @return The response from the GetTrafficPolicyInstance service method,
     *         as returned by AmazonRoute53.
     * 
     * @throws InvalidInputException
     * @throws NoSuchTrafficPolicyInstanceException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetTrafficPolicyInstanceResult getTrafficPolicyInstance(GetTrafficPolicyInstanceRequest getTrafficPolicyInstanceRequest) {
        ExecutionContext executionContext = createExecutionContext(getTrafficPolicyInstanceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetTrafficPolicyInstanceRequest> request = null;
        Response<GetTrafficPolicyInstanceResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetTrafficPolicyInstanceRequestMarshaller().marshall(super.beforeMarshalling(getTrafficPolicyInstanceRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetTrafficPolicyInstanceResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Creates a traffic policy, which you use to create multiple DNS
     * resource record sets for one domain name (such as example.com) or one
     * subdomain name (such as www.example.com).
     * </p>
     * <p>
     * To create a traffic policy, send a <code>POST</code> request to the
     * <code>2013-04-01/trafficpolicy</code> resource. The request body must
     * include an XML document with a <code>CreateTrafficPolicyRequest</code>
     * element. The response includes the
     * <code>CreateTrafficPolicyResponse</code> element, which contains
     * information about the new traffic policy.
     * </p>
     *
     * @param createTrafficPolicyRequest Container for the necessary
     *           parameters to execute the CreateTrafficPolicy service method on
     *           AmazonRoute53.
     * 
     * @return The response from the CreateTrafficPolicy service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws InvalidTrafficPolicyDocumentException
     * @throws InvalidInputException
     * @throws TrafficPolicyAlreadyExistsException
     * @throws TooManyTrafficPoliciesException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateTrafficPolicyResult createTrafficPolicy(CreateTrafficPolicyRequest createTrafficPolicyRequest) {
        ExecutionContext executionContext = createExecutionContext(createTrafficPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateTrafficPolicyRequest> request = null;
        Response<CreateTrafficPolicyResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateTrafficPolicyRequestMarshaller().marshall(super.beforeMarshalling(createTrafficPolicyRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new CreateTrafficPolicyResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Updates the comment for a specified traffic policy version.
     * </p>
     * <p>
     * To update the comment, send a <code>POST</code> request to the
     * <code>/2013-04-01/trafficpolicy/</code> resource.
     * </p>
     * <p>
     * The request body must include an XML document with an
     * <code>UpdateTrafficPolicyCommentRequest</code> element.
     * </p>
     *
     * @param updateTrafficPolicyCommentRequest Container for the necessary
     *           parameters to execute the UpdateTrafficPolicyComment service method on
     *           AmazonRoute53.
     * 
     * @return The response from the UpdateTrafficPolicyComment service
     *         method, as returned by AmazonRoute53.
     * 
     * @throws ConcurrentModificationException
     * @throws NoSuchTrafficPolicyException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public UpdateTrafficPolicyCommentResult updateTrafficPolicyComment(UpdateTrafficPolicyCommentRequest updateTrafficPolicyCommentRequest) {
        ExecutionContext executionContext = createExecutionContext(updateTrafficPolicyCommentRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateTrafficPolicyCommentRequest> request = null;
        Response<UpdateTrafficPolicyCommentResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateTrafficPolicyCommentRequestMarshaller().marshall(super.beforeMarshalling(updateTrafficPolicyCommentRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new UpdateTrafficPolicyCommentResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve the delegation set for a hosted zone, send a
     * <code>GET</code> request to the <code>2013-04-01/hostedzone/hosted
     * zone ID </code> resource. The delegation set is the four Amazon Route
     * 53 name servers that were assigned to the hosted zone when you created
     * it.
     * </p>
     *
     * @param getHostedZoneRequest Container for the necessary parameters to
     *           execute the GetHostedZone service method on AmazonRoute53.
     * 
     * @return The response from the GetHostedZone service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws NoSuchHostedZoneException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetHostedZoneResult getHostedZone(GetHostedZoneRequest getHostedZoneRequest) {
        ExecutionContext executionContext = createExecutionContext(getHostedZoneRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetHostedZoneRequest> request = null;
        Response<GetHostedZoneResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetHostedZoneRequestMarshaller().marshall(super.beforeMarshalling(getHostedZoneRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetHostedZoneResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * This action returns the current status of a change batch request. The
     * status is one of the following values:
     * </p>
     * <p>
     * - <code>PENDING</code> indicates that the changes in this request
     * have not replicated to all Amazon Route 53 DNS servers. This is the
     * initial status of all change batch requests.
     * </p>
     * <p>
     * - <code>INSYNC</code> indicates that the changes have replicated to
     * all Amazon Route 53 DNS servers.
     * </p>
     *
     * @param getChangeRequest Container for the necessary parameters to
     *           execute the GetChange service method on AmazonRoute53.
     * 
     * @return The response from the GetChange service method, as returned by
     *         AmazonRoute53.
     * 
     * @throws NoSuchChangeException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetChangeResult getChange(GetChangeRequest getChangeRequest) {
        ExecutionContext executionContext = createExecutionContext(getChangeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetChangeRequest> request = null;
        Response<GetChangeResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetChangeRequestMarshaller().marshall(super.beforeMarshalling(getChangeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetChangeResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Updates the resource record sets in a specified hosted zone that were
     * created based on the settings in a specified traffic policy version.
     * </p>
     * <p>
     * <b>IMPORTANT:</b>The DNS type of the resource record sets that you're
     * updating must match the DNS type in the JSON document that is
     * associated with the traffic policy version that you're using to update
     * the traffic policy instance.
     * </p>
     * <p>
     * When you update a traffic policy instance, Amazon Route 53 continues
     * to respond to DNS queries for the root resource record set name (such
     * as example.com) while it replaces one group of resource record sets
     * with another. Amazon Route 53 performs the following operations:
     * </p>
     * <ol> <li>Amazon Route 53 creates a new group of resource record sets
     * based on the specified traffic policy. This is true regardless of how
     * substantial the differences are between the existing resource record
     * sets and the new resource record sets. </li>
     * <li>When all of the new resource record sets have been created,
     * Amazon Route 53 starts to respond to DNS queries for the root resource
     * record set name (such as example.com) by using the new resource record
     * sets.</li>
     * <li>Amazon Route 53 deletes the old group of resource record sets
     * that are associated with the root resource record set name.</li>
     * </ol> <p>
     * To update a traffic policy instance, send a <code>POST</code> request
     * to the <code>/2013-04-01/trafficpolicyinstance/traffic policy ID
     * </code> resource. The request body must include an XML document with
     * an <code>UpdateTrafficPolicyInstanceRequest</code> element.
     * </p>
     *
     * @param updateTrafficPolicyInstanceRequest Container for the necessary
     *           parameters to execute the UpdateTrafficPolicyInstance service method
     *           on AmazonRoute53.
     * 
     * @return The response from the UpdateTrafficPolicyInstance service
     *         method, as returned by AmazonRoute53.
     * 
     * @throws PriorRequestNotCompleteException
     * @throws ConflictingTypesException
     * @throws NoSuchTrafficPolicyException
     * @throws InvalidInputException
     * @throws NoSuchTrafficPolicyInstanceException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public UpdateTrafficPolicyInstanceResult updateTrafficPolicyInstance(UpdateTrafficPolicyInstanceRequest updateTrafficPolicyInstanceRequest) {
        ExecutionContext executionContext = createExecutionContext(updateTrafficPolicyInstanceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateTrafficPolicyInstanceRequest> request = null;
        Response<UpdateTrafficPolicyInstanceResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateTrafficPolicyInstanceRequestMarshaller().marshall(super.beforeMarshalling(updateTrafficPolicyInstanceRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new UpdateTrafficPolicyInstanceResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve a single geo location, send a <code>GET</code> request to
     * the <code>2013-04-01/geolocation</code> resource with one of these
     * options: continentcode | countrycode | countrycode and
     * subdivisioncode.
     * </p>
     *
     * @param getGeoLocationRequest Container for the necessary parameters to
     *           execute the GetGeoLocation service method on AmazonRoute53.
     * 
     * @return The response from the GetGeoLocation service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws NoSuchGeoLocationException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetGeoLocationResult getGeoLocation(GetGeoLocationRequest getGeoLocationRequest) {
        ExecutionContext executionContext = createExecutionContext(getGeoLocationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetGeoLocationRequest> request = null;
        Response<GetGeoLocationResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetGeoLocationRequestMarshaller().marshall(super.beforeMarshalling(getGeoLocationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetGeoLocationResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To update the hosted zone comment, send a <code>POST</code> request
     * to the <code>2013-04-01/hostedzone/hosted zone ID </code> resource.
     * The request body must include an XML document with a
     * <code>UpdateHostedZoneCommentRequest</code> element. The response to
     * this request includes the modified <code>HostedZone</code> element.
     * </p>
     * <p>
     * <b>NOTE:</b> The comment can have a maximum length of 256 characters.
     * </p>
     *
     * @param updateHostedZoneCommentRequest Container for the necessary
     *           parameters to execute the UpdateHostedZoneComment service method on
     *           AmazonRoute53.
     * 
     * @return The response from the UpdateHostedZoneComment service method,
     *         as returned by AmazonRoute53.
     * 
     * @throws NoSuchHostedZoneException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public UpdateHostedZoneCommentResult updateHostedZoneComment(UpdateHostedZoneCommentRequest updateHostedZoneCommentRequest) {
        ExecutionContext executionContext = createExecutionContext(updateHostedZoneCommentRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateHostedZoneCommentRequest> request = null;
        Response<UpdateHostedZoneCommentResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateHostedZoneCommentRequestMarshaller().marshall(super.beforeMarshalling(updateHostedZoneCommentRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new UpdateHostedZoneCommentResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Gets information about all of the versions for a specified traffic
     * policy. <code>ListTrafficPolicyVersions</code> lists only versions
     * that have not been deleted.
     * </p>
     * <p>
     * Amazon Route 53 returns a maximum of 100 items in each response. If
     * you have a lot of traffic policies, you can use the
     * <code>maxitems</code> parameter to list them in groups of up to 100.
     * </p>
     * <p>
     * The response includes three values that help you navigate from one
     * group of <code>maxitems</code> maxitems traffic policies to the next:
     * </p>
     * 
     * <ul>
     * <li> <b>IsTruncated</b> </li>
     * <p>
     * If the value of <code>IsTruncated</code> in the response is
     * <code>true</code> , there are more traffic policy versions associated
     * with the specified traffic policy.
     * </p>
     * <p>
     * If <code>IsTruncated</code> is <code>false</code> , this response
     * includes the last traffic policy version that is associated with the
     * specified traffic policy.
     * </p>
     * <li> <b>TrafficPolicyVersionMarker</b> </li>
     * <p>
     * The ID of the next traffic policy version that is associated with the
     * current AWS account. If you want to list more traffic policies, make
     * another call to <code>ListTrafficPolicyVersions</code> , and specify
     * the value of the <code>TrafficPolicyVersionMarker</code> element in
     * the <code>TrafficPolicyVersionMarker</code> request parameter.
     * </p>
     * <p>
     * If <code>IsTruncated</code> is <code>false</code> , Amazon Route 53
     * omits the <code>TrafficPolicyVersionMarker</code> element from the
     * response.
     * </p>
     * <li> <b>MaxItems</b> </li>
     * <p>
     * The value that you specified for the <code>MaxItems</code> parameter
     * in the request that produced the current response.
     * </p>
     * 
     * </ul>
     *
     * @param listTrafficPolicyVersionsRequest Container for the necessary
     *           parameters to execute the ListTrafficPolicyVersions service method on
     *           AmazonRoute53.
     * 
     * @return The response from the ListTrafficPolicyVersions service
     *         method, as returned by AmazonRoute53.
     * 
     * @throws NoSuchTrafficPolicyException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListTrafficPolicyVersionsResult listTrafficPolicyVersions(ListTrafficPolicyVersionsRequest listTrafficPolicyVersionsRequest) {
        ExecutionContext executionContext = createExecutionContext(listTrafficPolicyVersionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListTrafficPolicyVersionsRequest> request = null;
        Response<ListTrafficPolicyVersionsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListTrafficPolicyVersionsRequestMarshaller().marshall(super.beforeMarshalling(listTrafficPolicyVersionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListTrafficPolicyVersionsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * This action deletes a health check. To delete a health check, send a
     * <code>DELETE</code> request to the <code>2013-04-01/healthcheck/health
     * check ID </code> resource.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> You can delete a health check only if there are no
     * resource record sets associated with this health check. If resource
     * record sets are associated with this health check, you must
     * disassociate them before you can delete your health check. If you try
     * to delete a health check that is associated with resource record sets,
     * Amazon Route 53 will deny your request with a HealthCheckInUse error.
     * For information about disassociating the records from your health
     * check, see ChangeResourceRecordSets.
     * </p>
     *
     * @param deleteHealthCheckRequest Container for the necessary parameters
     *           to execute the DeleteHealthCheck service method on AmazonRoute53.
     * 
     * @return The response from the DeleteHealthCheck service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws NoSuchHealthCheckException
     * @throws HealthCheckInUseException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DeleteHealthCheckResult deleteHealthCheck(DeleteHealthCheckRequest deleteHealthCheckRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteHealthCheckRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteHealthCheckRequest> request = null;
        Response<DeleteHealthCheckResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteHealthCheckRequestMarshaller().marshall(super.beforeMarshalling(deleteHealthCheckRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new DeleteHealthCheckResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     *
     * @param listTagsForResourcesRequest Container for the necessary
     *           parameters to execute the ListTagsForResources service method on
     *           AmazonRoute53.
     * 
     * @return The response from the ListTagsForResources service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws PriorRequestNotCompleteException
     * @throws NoSuchHealthCheckException
     * @throws ThrottlingException
     * @throws NoSuchHostedZoneException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListTagsForResourcesResult listTagsForResources(ListTagsForResourcesRequest listTagsForResourcesRequest) {
        ExecutionContext executionContext = createExecutionContext(listTagsForResourcesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListTagsForResourcesRequest> request = null;
        Response<ListTagsForResourcesResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListTagsForResourcesRequestMarshaller().marshall(super.beforeMarshalling(listTagsForResourcesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListTagsForResourcesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Imagine all the resource record sets in a zone listed out in front of
     * you. Imagine them sorted lexicographically first by DNS name (with the
     * labels reversed, like "com.amazon.www" for example), and secondarily,
     * lexicographically by record type. This operation retrieves at most
     * MaxItems resource record sets from this list, in order, starting at a
     * position specified by the Name and Type arguments:
     * </p>
     * 
     * <ul>
     * <li>If both Name and Type are omitted, this means start the results
     * at the first RRSET in the HostedZone.</li>
     * <li>If Name is specified but Type is omitted, this means start the
     * results at the first RRSET in the list whose name is greater than or
     * equal to Name. </li>
     * <li>If both Name and Type are specified, this means start the results
     * at the first RRSET in the list whose name is greater than or equal to
     * Name and whose type is greater than or equal to Type.</li>
     * <li>It is an error to specify the Type but not the Name.</li>
     * 
     * </ul>
     * <p>
     * Use ListResourceRecordSets to retrieve a single known record set by
     * specifying the record set's name and type, and setting MaxItems = 1
     * </p>
     * <p>
     * To retrieve all the records in a HostedZone, first pause any
     * processes making calls to ChangeResourceRecordSets. Initially call
     * ListResourceRecordSets without a Name and Type to get the first page
     * of record sets. For subsequent calls, set Name and Type to the
     * NextName and NextType values returned by the previous response.
     * </p>
     * <p>
     * In the presence of concurrent ChangeResourceRecordSets calls, there
     * is no consistency of results across calls to ListResourceRecordSets.
     * The only way to get a consistent multi-page snapshot of all RRSETs in
     * a zone is to stop making changes while pagination is in progress.
     * </p>
     * <p>
     * However, the results from ListResourceRecordSets are consistent
     * within a page. If MakeChange calls are taking place concurrently, the
     * result of each one will either be completely visible in your results
     * or not at all. You will not see partial changes, or changes that do
     * not ultimately succeed. (This follows from the fact that MakeChange is
     * atomic)
     * </p>
     * <p>
     * The results from ListResourceRecordSets are strongly consistent with
     * ChangeResourceRecordSets. To be precise, if a single process makes a
     * call to ChangeResourceRecordSets and receives a successful response,
     * the effects of that change will be visible in a subsequent call to
     * ListResourceRecordSets by that process.
     * </p>
     *
     * @param listResourceRecordSetsRequest Container for the necessary
     *           parameters to execute the ListResourceRecordSets service method on
     *           AmazonRoute53.
     * 
     * @return The response from the ListResourceRecordSets service method,
     *         as returned by AmazonRoute53.
     * 
     * @throws NoSuchHostedZoneException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListResourceRecordSetsResult listResourceRecordSets(ListResourceRecordSetsRequest listResourceRecordSetsRequest) {
        ExecutionContext executionContext = createExecutionContext(listResourceRecordSetsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListResourceRecordSetsRequest> request = null;
        Response<ListResourceRecordSetsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListResourceRecordSetsRequestMarshaller().marshall(super.beforeMarshalling(listResourceRecordSetsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListResourceRecordSetsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Deletes a traffic policy instance and all of the resource record sets
     * that Amazon Route 53 created when you created the instance.
     * </p>
     * <p>
     * To delete a traffic policy instance, send a <code>DELETE</code>
     * request to the <code>2013-04-01/trafficpolicy/traffic policy instance
     * ID </code> resource.
     * </p>
     * <p>
     * <b>IMPORTANT:</b>When you delete a traffic policy instance, Amazon
     * Route 53 also deletes all of the resource record sets that were
     * created when you created the traffic policy instance.
     * </p>
     *
     * @param deleteTrafficPolicyInstanceRequest Container for the necessary
     *           parameters to execute the DeleteTrafficPolicyInstance service method
     *           on AmazonRoute53.
     * 
     * @return The response from the DeleteTrafficPolicyInstance service
     *         method, as returned by AmazonRoute53.
     * 
     * @throws PriorRequestNotCompleteException
     * @throws InvalidInputException
     * @throws NoSuchTrafficPolicyInstanceException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DeleteTrafficPolicyInstanceResult deleteTrafficPolicyInstance(DeleteTrafficPolicyInstanceRequest deleteTrafficPolicyInstanceRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteTrafficPolicyInstanceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteTrafficPolicyInstanceRequest> request = null;
        Response<DeleteTrafficPolicyInstanceResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteTrafficPolicyInstanceRequestMarshaller().marshall(super.beforeMarshalling(deleteTrafficPolicyInstanceRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new DeleteTrafficPolicyInstanceResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Gets information about the traffic policy instances that you created
     * in a specified hosted zone.
     * </p>
     * <p>
     * <b>NOTE:</b>After you submit an UpdateTrafficPolicyInstance request,
     * there's a brief delay while Amazon Route 53 creates the resource
     * record sets that are specified in the traffic policy definition. For
     * more information, see the State response element.
     * </p>
     * <p>
     * To get information about the traffic policy instances that you
     * created in a specified hosted zone, send a <code>GET</code> request to
     * the <code>2013-04-01/trafficpolicyinstance</code> resource and include
     * the ID of the hosted zone.
     * </p>
     * <p>
     * Amazon Route 53 returns a maximum of 100 items in each response. If
     * you have a lot of traffic policy instances, you can use the
     * <code>MaxItems</code> parameter to list them in groups of up to 100.
     * </p>
     * <p>
     * The response includes four values that help you navigate from one
     * group of <code>MaxItems</code> traffic policy instances to the next:
     * </p>
     * 
     * <ul>
     * <li> <b>IsTruncated</b> </li>
     * <p>
     * If the value of <code></code> IsTruncated in the response is
     * <code>true</code> , there are more traffic policy instances associated
     * with the current AWS account.
     * </p>
     * <p>
     * If <code>IsTruncated</code> is <code>false</code> , this response
     * includes the last traffic policy instance that is associated with the
     * current account.
     * </p>
     * <li> <b>MaxItems</b> </li>
     * <p>
     * The value that you specified for the <code>MaxItems</code> parameter
     * in the request that produced the current response.
     * </p>
     * <li> <b>TrafficPolicyInstanceNameMarker</b> and
     * <b>TrafficPolicyInstanceTypeMarker</b> </li>
     * <p>
     * If <code>IsTruncated</code> is <code>true</code> , these two values
     * in the response represent the first traffic policy instance in the
     * next group of <code>MaxItems</code> traffic policy instances. To list
     * more traffic policy instances, make another call to
     * <code>ListTrafficPolicyInstancesByHostedZone</code> , and specify
     * these values in the corresponding request parameters.
     * </p>
     * <p>
     * If <code>IsTruncated</code> is <code>false</code> , all three
     * elements are omitted from the response.
     * </p>
     * 
     * </ul>
     *
     * @param listTrafficPolicyInstancesByHostedZoneRequest Container for the
     *           necessary parameters to execute the
     *           ListTrafficPolicyInstancesByHostedZone service method on
     *           AmazonRoute53.
     * 
     * @return The response from the ListTrafficPolicyInstancesByHostedZone
     *         service method, as returned by AmazonRoute53.
     * 
     * @throws NoSuchHostedZoneException
     * @throws InvalidInputException
     * @throws NoSuchTrafficPolicyInstanceException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListTrafficPolicyInstancesByHostedZoneResult listTrafficPolicyInstancesByHostedZone(ListTrafficPolicyInstancesByHostedZoneRequest listTrafficPolicyInstancesByHostedZoneRequest) {
        ExecutionContext executionContext = createExecutionContext(listTrafficPolicyInstancesByHostedZoneRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListTrafficPolicyInstancesByHostedZoneRequest> request = null;
        Response<ListTrafficPolicyInstancesByHostedZoneResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListTrafficPolicyInstancesByHostedZoneRequestMarshaller().marshall(super.beforeMarshalling(listTrafficPolicyInstancesByHostedZoneRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListTrafficPolicyInstancesByHostedZoneResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * This action deletes a reusable delegation set. To delete a reusable
     * delegation set, send a <code>DELETE</code> request to the
     * <code>2013-04-01/delegationset/delegation set ID </code> resource.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> You can delete a reusable delegation set only if
     * there are no associated hosted zones. If your reusable delegation set
     * contains associated hosted zones, you must delete them before you can
     * delete your reusable delegation set. If you try to delete a reusable
     * delegation set that contains associated hosted zones, Amazon Route 53
     * will deny your request with a DelegationSetInUse error.
     * </p>
     *
     * @param deleteReusableDelegationSetRequest Container for the necessary
     *           parameters to execute the DeleteReusableDelegationSet service method
     *           on AmazonRoute53.
     * 
     * @return The response from the DeleteReusableDelegationSet service
     *         method, as returned by AmazonRoute53.
     * 
     * @throws NoSuchDelegationSetException
     * @throws DelegationSetInUseException
     * @throws DelegationSetNotReusableException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DeleteReusableDelegationSetResult deleteReusableDelegationSet(DeleteReusableDelegationSetRequest deleteReusableDelegationSetRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteReusableDelegationSetRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteReusableDelegationSetRequest> request = null;
        Response<DeleteReusableDelegationSetResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteReusableDelegationSetRequestMarshaller().marshall(super.beforeMarshalling(deleteReusableDelegationSetRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new DeleteReusableDelegationSetResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * This action returns the status and changes of a change batch request.
     * </p>
     *
     * @param getChangeDetailsRequest Container for the necessary parameters
     *           to execute the GetChangeDetails service method on AmazonRoute53.
     * 
     * @return The response from the GetChangeDetails service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws NoSuchChangeException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetChangeDetailsResult getChangeDetails(GetChangeDetailsRequest getChangeDetailsRequest) {
        ExecutionContext executionContext = createExecutionContext(getChangeDetailsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetChangeDetailsRequest> request = null;
        Response<GetChangeDetailsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetChangeDetailsRequestMarshaller().marshall(super.beforeMarshalling(getChangeDetailsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetChangeDetailsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve the health check, send a <code>GET</code> request to the
     * <code>2013-04-01/healthcheck/health check ID </code> resource.
     * </p>
     *
     * @param getHealthCheckRequest Container for the necessary parameters to
     *           execute the GetHealthCheck service method on AmazonRoute53.
     * 
     * @return The response from the GetHealthCheck service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws NoSuchHealthCheckException
     * @throws IncompatibleVersionException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetHealthCheckResult getHealthCheck(GetHealthCheckRequest getHealthCheckRequest) {
        ExecutionContext executionContext = createExecutionContext(getHealthCheckRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetHealthCheckRequest> request = null;
        Response<GetHealthCheckResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetHealthCheckRequestMarshaller().marshall(super.beforeMarshalling(getHealthCheckRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetHealthCheckResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * This action creates a reusable delegationSet.
     * </p>
     * <p>
     * To create a new reusable delegationSet, send a <code>POST</code>
     * request to the <code>2013-04-01/delegationset</code> resource. The
     * request body must include an XML document with a
     * <code>CreateReusableDelegationSetRequest</code> element. The response
     * returns the <code>CreateReusableDelegationSetResponse</code> element
     * that contains metadata about the delegationSet.
     * </p>
     * <p>
     * If the optional parameter HostedZoneId is specified, it marks the
     * delegationSet associated with that particular hosted zone as reusable.
     * </p>
     *
     * @param createReusableDelegationSetRequest Container for the necessary
     *           parameters to execute the CreateReusableDelegationSet service method
     *           on AmazonRoute53.
     * 
     * @return The response from the CreateReusableDelegationSet service
     *         method, as returned by AmazonRoute53.
     * 
     * @throws DelegationSetAlreadyCreatedException
     * @throws HostedZoneNotFoundException
     * @throws DelegationSetNotAvailableException
     * @throws InvalidInputException
     * @throws InvalidArgumentException
     * @throws LimitsExceededException
     * @throws DelegationSetAlreadyReusableException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateReusableDelegationSetResult createReusableDelegationSet(CreateReusableDelegationSetRequest createReusableDelegationSetRequest) {
        ExecutionContext executionContext = createExecutionContext(createReusableDelegationSetRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateReusableDelegationSetRequest> request = null;
        Response<CreateReusableDelegationSetResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateReusableDelegationSetRequestMarshaller().marshall(super.beforeMarshalling(createReusableDelegationSetRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new CreateReusableDelegationSetResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve a list of the IP ranges used by Amazon Route 53 health
     * checkers to check the health of your resources, send a
     * <code>GET</code> request to the
     * <code>2013-04-01/checkeripranges</code> resource. You can use these IP
     * addresses to configure router and firewall rules to allow health
     * checkers to check the health of your resources.
     * </p>
     *
     * @param getCheckerIpRangesRequest Container for the necessary
     *           parameters to execute the GetCheckerIpRanges service method on
     *           AmazonRoute53.
     * 
     * @return The response from the GetCheckerIpRanges service method, as
     *         returned by AmazonRoute53.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetCheckerIpRangesResult getCheckerIpRanges(GetCheckerIpRangesRequest getCheckerIpRangesRequest) {
        ExecutionContext executionContext = createExecutionContext(getCheckerIpRangesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetCheckerIpRangesRequest> request = null;
        Response<GetCheckerIpRangesResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetCheckerIpRangesRequestMarshaller().marshall(super.beforeMarshalling(getCheckerIpRangesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetCheckerIpRangesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * This action disassociates a VPC from an hosted zone.
     * </p>
     * <p>
     * To disassociate a VPC to a hosted zone, send a <code>POST</code>
     * request to the <code>2013-04-01/hostedzone/hosted zone
     * ID/disassociatevpc</code> resource. The request body must include an
     * XML document with a <code>DisassociateVPCFromHostedZoneRequest</code>
     * element. The response returns the
     * <code>DisassociateVPCFromHostedZoneResponse</code> element that
     * contains <code>ChangeInfo</code> for you to track the progress of the
     * <code>DisassociateVPCFromHostedZoneRequest</code> you made. See
     * <code>GetChange</code> operation for how to track the progress of your
     * change.
     * </p>
     *
     * @param disassociateVPCFromHostedZoneRequest Container for the
     *           necessary parameters to execute the DisassociateVPCFromHostedZone
     *           service method on AmazonRoute53.
     * 
     * @return The response from the DisassociateVPCFromHostedZone service
     *         method, as returned by AmazonRoute53.
     * 
     * @throws InvalidVPCIdException
     * @throws NoSuchHostedZoneException
     * @throws LastVPCAssociationException
     * @throws InvalidInputException
     * @throws VPCAssociationNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DisassociateVPCFromHostedZoneResult disassociateVPCFromHostedZone(DisassociateVPCFromHostedZoneRequest disassociateVPCFromHostedZoneRequest) {
        ExecutionContext executionContext = createExecutionContext(disassociateVPCFromHostedZoneRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DisassociateVPCFromHostedZoneRequest> request = null;
        Response<DisassociateVPCFromHostedZoneResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DisassociateVPCFromHostedZoneRequestMarshaller().marshall(super.beforeMarshalling(disassociateVPCFromHostedZoneRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new DisassociateVPCFromHostedZoneResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * This action gets the list of ChangeBatches in a given time period for
     * a given hosted zone and RRSet.
     * </p>
     *
     * @param listChangeBatchesByRRSetRequest Container for the necessary
     *           parameters to execute the ListChangeBatchesByRRSet service method on
     *           AmazonRoute53.
     * 
     * @return The response from the ListChangeBatchesByRRSet service method,
     *         as returned by AmazonRoute53.
     * 
     * @throws NoSuchHostedZoneException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListChangeBatchesByRRSetResult listChangeBatchesByRRSet(ListChangeBatchesByRRSetRequest listChangeBatchesByRRSetRequest) {
        ExecutionContext executionContext = createExecutionContext(listChangeBatchesByRRSetRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListChangeBatchesByRRSetRequest> request = null;
        Response<ListChangeBatchesByRRSetResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListChangeBatchesByRRSetRequestMarshaller().marshall(super.beforeMarshalling(listChangeBatchesByRRSetRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListChangeBatchesByRRSetResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * If you want to learn why a health check is currently failing or why
     * it failed most recently (if at all), you can get the failure reason
     * for the most recent failure. Send a <code>GET</code> request to the
     * <code>2013-04-01/healthcheck/health check ID/lastfailurereason</code>
     * resource.
     * </p>
     *
     * @param getHealthCheckLastFailureReasonRequest Container for the
     *           necessary parameters to execute the GetHealthCheckLastFailureReason
     *           service method on AmazonRoute53.
     * 
     * @return The response from the GetHealthCheckLastFailureReason service
     *         method, as returned by AmazonRoute53.
     * 
     * @throws NoSuchHealthCheckException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetHealthCheckLastFailureReasonResult getHealthCheckLastFailureReason(GetHealthCheckLastFailureReasonRequest getHealthCheckLastFailureReasonRequest) {
        ExecutionContext executionContext = createExecutionContext(getHealthCheckLastFailureReasonRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetHealthCheckLastFailureReasonRequest> request = null;
        Response<GetHealthCheckLastFailureReasonResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetHealthCheckLastFailureReasonRequestMarshaller().marshall(super.beforeMarshalling(getHealthCheckLastFailureReasonRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetHealthCheckLastFailureReasonResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve a list of your health checks, send a <code>GET</code>
     * request to the <code>2013-04-01/healthcheck</code> resource. The
     * response to this request includes a <code>HealthChecks</code> element
     * with zero, one, or multiple <code>HealthCheck</code> child elements.
     * By default, the list of health checks is displayed on a single page.
     * You can control the length of the page that is displayed by using the
     * <code>MaxItems</code> parameter. You can use the <code>Marker</code>
     * parameter to control the health check that the list begins with.
     * </p>
     * <p>
     * <b>NOTE:</b> Amazon Route 53 returns a maximum of 100 items. If you
     * set MaxItems to a value greater than 100, Amazon Route 53 returns only
     * the first 100.
     * </p>
     *
     * @param listHealthChecksRequest Container for the necessary parameters
     *           to execute the ListHealthChecks service method on AmazonRoute53.
     * 
     * @return The response from the ListHealthChecks service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws IncompatibleVersionException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListHealthChecksResult listHealthChecks(ListHealthChecksRequest listHealthChecksRequest) {
        ExecutionContext executionContext = createExecutionContext(listHealthChecksRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListHealthChecksRequest> request = null;
        Response<ListHealthChecksResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListHealthChecksRequestMarshaller().marshall(super.beforeMarshalling(listHealthChecksRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListHealthChecksResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve a list of supported geo locations, send a
     * <code>GET</code> request to the <code>2013-04-01/geolocations</code>
     * resource. The response to this request includes a
     * <code>GeoLocationDetailsList</code> element with zero, one, or
     * multiple <code>GeoLocationDetails</code> child elements. The list is
     * sorted by country code, and then subdivision code, followed by
     * continents at the end of the list.
     * </p>
     * <p>
     * By default, the list of geo locations is displayed on a single page.
     * You can control the length of the page that is displayed by using the
     * <code>MaxItems</code> parameter. If the list is truncated,
     * <code>IsTruncated</code> will be set to <i>true</i> and a combination
     * of <code>NextContinentCode, NextCountryCode,
     * NextSubdivisionCode</code> will be populated. You can pass these as
     * parameters to <code>StartContinentCode, StartCountryCode,
     * StartSubdivisionCode</code> to control the geo location that the list
     * begins with.
     * </p>
     *
     * @param listGeoLocationsRequest Container for the necessary parameters
     *           to execute the ListGeoLocations service method on AmazonRoute53.
     * 
     * @return The response from the ListGeoLocations service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListGeoLocationsResult listGeoLocations(ListGeoLocationsRequest listGeoLocationsRequest) {
        ExecutionContext executionContext = createExecutionContext(listGeoLocationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListGeoLocationsRequest> request = null;
        Response<ListGeoLocationsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListGeoLocationsRequestMarshaller().marshall(super.beforeMarshalling(listGeoLocationsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListGeoLocationsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * This action creates a new health check.
     * </p>
     * <p>
     * To create a new health check, send a <code>POST</code> request to the
     * <code>2013-04-01/healthcheck</code> resource. The request body must
     * include an XML document with a <code>CreateHealthCheckRequest</code>
     * element. The response returns the
     * <code>CreateHealthCheckResponse</code> element that contains metadata
     * about the health check.
     * </p>
     *
     * @param createHealthCheckRequest Container for the necessary parameters
     *           to execute the CreateHealthCheck service method on AmazonRoute53.
     * 
     * @return The response from the CreateHealthCheck service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws HealthCheckAlreadyExistsException
     * @throws InvalidInputException
     * @throws TooManyHealthChecksException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateHealthCheckResult createHealthCheck(CreateHealthCheckRequest createHealthCheckRequest) {
        ExecutionContext executionContext = createExecutionContext(createHealthCheckRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateHealthCheckRequest> request = null;
        Response<CreateHealthCheckResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateHealthCheckRequestMarshaller().marshall(super.beforeMarshalling(createHealthCheckRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new CreateHealthCheckResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve a count of all your health checks, send a
     * <code>GET</code> request to the
     * <code>2013-04-01/healthcheckcount</code> resource.
     * </p>
     *
     * @param getHealthCheckCountRequest Container for the necessary
     *           parameters to execute the GetHealthCheckCount service method on
     *           AmazonRoute53.
     * 
     * @return The response from the GetHealthCheckCount service method, as
     *         returned by AmazonRoute53.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetHealthCheckCountResult getHealthCheckCount(GetHealthCheckCountRequest getHealthCheckCountRequest) {
        ExecutionContext executionContext = createExecutionContext(getHealthCheckCountRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetHealthCheckCountRequest> request = null;
        Response<GetHealthCheckCountResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetHealthCheckCountRequestMarshaller().marshall(super.beforeMarshalling(getHealthCheckCountRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetHealthCheckCountResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     *
     * @param changeTagsForResourceRequest Container for the necessary
     *           parameters to execute the ChangeTagsForResource service method on
     *           AmazonRoute53.
     * 
     * @return The response from the ChangeTagsForResource service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws PriorRequestNotCompleteException
     * @throws NoSuchHealthCheckException
     * @throws ThrottlingException
     * @throws NoSuchHostedZoneException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ChangeTagsForResourceResult changeTagsForResource(ChangeTagsForResourceRequest changeTagsForResourceRequest) {
        ExecutionContext executionContext = createExecutionContext(changeTagsForResourceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ChangeTagsForResourceRequest> request = null;
        Response<ChangeTagsForResourceResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ChangeTagsForResourceRequestMarshaller().marshall(super.beforeMarshalling(changeTagsForResourceRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ChangeTagsForResourceResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Creates resource record sets in a specified hosted zone based on the
     * settings in a specified traffic policy version. In addition,
     * <code>CreateTrafficPolicyInstance</code> associates the resource
     * record sets with a specified domain name (such as example.com) or
     * subdomain name (such as www.example.com). Amazon Route 53 responds to
     * DNS queries for the domain or subdomain name by using the resource
     * record sets that <code>CreateTrafficPolicyInstance</code> created.
     * </p>
     * <p>
     * To create a traffic policy instance, send a <code>POST</code> request
     * to the <code>2013-04-01/trafficpolicyinstance</code> resource. The
     * request body must include an XML document with a
     * <code>CreateTrafficPolicyRequest</code> element. The response returns
     * the <code>CreateTrafficPolicyInstanceResponse</code> element, which
     * contains information about the traffic policy instance.
     * </p>
     *
     * @param createTrafficPolicyInstanceRequest Container for the necessary
     *           parameters to execute the CreateTrafficPolicyInstance service method
     *           on AmazonRoute53.
     * 
     * @return The response from the CreateTrafficPolicyInstance service
     *         method, as returned by AmazonRoute53.
     * 
     * @throws NoSuchTrafficPolicyException
     * @throws TrafficPolicyInstanceAlreadyExistsException
     * @throws NoSuchHostedZoneException
     * @throws TooManyTrafficPolicyInstancesException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateTrafficPolicyInstanceResult createTrafficPolicyInstance(CreateTrafficPolicyInstanceRequest createTrafficPolicyInstanceRequest) {
        ExecutionContext executionContext = createExecutionContext(createTrafficPolicyInstanceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateTrafficPolicyInstanceRequest> request = null;
        Response<CreateTrafficPolicyInstanceResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateTrafficPolicyInstanceRequestMarshaller().marshall(super.beforeMarshalling(createTrafficPolicyInstanceRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new CreateTrafficPolicyInstanceResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Gets information about the traffic policy instances that you created
     * by using the current AWS account.
     * </p>
     * <p>
     * <b>NOTE:</b>After you submit an UpdateTrafficPolicyInstance request,
     * there's a brief delay while Amazon Route 53 creates the resource
     * record sets that are specified in the traffic policy definition. For
     * more information, see the State response element.
     * </p>
     * <p>
     * To get information about the traffic policy instances that are
     * associated with the current AWS account, send a <code>GET</code>
     * request to the <code>2013-04-01/trafficpolicyinstance</code> resource.
     * </p>
     * <p>
     * Amazon Route 53 returns a maximum of 100 items in each response. If
     * you have a lot of traffic policy instances, you can use the
     * <code>MaxItems</code> parameter to list them in groups of up to 100.
     * </p>
     * <p>
     * The response includes five values that help you navigate from one
     * group of <code>MaxItems</code> traffic policy instances to the next:
     * </p>
     * 
     * <ul>
     * <li> <b>IsTruncated</b> </li>
     * <p>
     * If the value of <code>IsTruncated</code> in the response is
     * <code>true</code> , there are more traffic policy instances associated
     * with the current AWS account.
     * </p>
     * <p>
     * If <code>IsTruncated</code> is <code>false</code> , this response
     * includes the last traffic policy instance that is associated with the
     * current account.
     * </p>
     * <li> <b>MaxItems</b> </li>
     * <p>
     * The value that you specified for the <code>MaxItems</code> parameter
     * in the request that produced the current response.
     * </p>
     * <li> <b>HostedZoneIdMarker</b> ,
     * <b>TrafficPolicyInstanceNameMarker</b> , and
     * <b>TrafficPolicyInstanceTypeMarker</b> </li>
     * <p>
     * If <code>IsTruncated</code> is <code>true</code> , these three values
     * in the response represent the first traffic policy instance in the
     * next group of <code>MaxItems</code> traffic policy instances. To list
     * more traffic policy instances, make another call to
     * <code>ListTrafficPolicyInstances</code> , and specify these values in
     * the corresponding request parameters.
     * </p>
     * <p>
     * If <code>IsTruncated</code> is <code>false</code> , all three
     * elements are omitted from the response.
     * </p>
     * 
     * </ul>
     *
     * @param listTrafficPolicyInstancesRequest Container for the necessary
     *           parameters to execute the ListTrafficPolicyInstances service method on
     *           AmazonRoute53.
     * 
     * @return The response from the ListTrafficPolicyInstances service
     *         method, as returned by AmazonRoute53.
     * 
     * @throws InvalidInputException
     * @throws NoSuchTrafficPolicyInstanceException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListTrafficPolicyInstancesResult listTrafficPolicyInstances(ListTrafficPolicyInstancesRequest listTrafficPolicyInstancesRequest) {
        ExecutionContext executionContext = createExecutionContext(listTrafficPolicyInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListTrafficPolicyInstancesRequest> request = null;
        Response<ListTrafficPolicyInstancesResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListTrafficPolicyInstancesRequestMarshaller().marshall(super.beforeMarshalling(listTrafficPolicyInstancesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListTrafficPolicyInstancesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Gets information about the latest version for every traffic policy
     * that is associated with the current AWS account. To get the
     * information, send a <code>GET</code> request to the
     * <code>2013-04-01/trafficpolicy</code> resource.
     * </p>
     * <p>
     * Amazon Route 53 returns a maximum of 100 items in each response. If
     * you have a lot of traffic policies, you can use the
     * <code>maxitems</code> parameter to list them in groups of up to 100.
     * </p>
     * <p>
     * The response includes three values that help you navigate from one
     * group of <code>maxitems</code> traffic policies to the next:
     * </p>
     * 
     * <ul>
     * <li> <b>IsTruncated</b> </li>
     * <p>
     * If the value of <code>IsTruncated</code> in the response is
     * <code>true</code> , there are more traffic policies associated with
     * the current AWS account.
     * </p>
     * <p>
     * If <code>IsTruncated</code> is <code>false</code> , this response
     * includes the last traffic policy that is associated with the current
     * account.
     * </p>
     * <li> <b>TrafficPolicyIdMarker</b> </li>
     * <p>
     * If <code>IsTruncated</code> is <code>true</code> ,
     * <code>TrafficPolicyIdMarker</code> is the ID of the first traffic
     * policy in the next group of <code>MaxItems</code> traffic policies. If
     * you want to list more traffic policies, make another call to
     * <code>ListTrafficPolicies</code> , and specify the value of the
     * <code>TrafficPolicyIdMarker</code> element from the response in the
     * <code>TrafficPolicyIdMarker</code> request parameter.
     * </p>
     * <p>
     * If <code>IsTruncated</code> is <code>false</code> , the
     * <code>TrafficPolicyIdMarker</code> element is omitted from the
     * response.
     * </p>
     * <li> <b>MaxItems</b> </li>
     * <p>
     * The value that you specified for the <code>MaxItems</code> parameter
     * in the request that produced the current response.
     * </p>
     * 
     * </ul>
     *
     * @param listTrafficPoliciesRequest Container for the necessary
     *           parameters to execute the ListTrafficPolicies service method on
     *           AmazonRoute53.
     * 
     * @return The response from the ListTrafficPolicies service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListTrafficPoliciesResult listTrafficPolicies(ListTrafficPoliciesRequest listTrafficPoliciesRequest) {
        ExecutionContext executionContext = createExecutionContext(listTrafficPoliciesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListTrafficPoliciesRequest> request = null;
        Response<ListTrafficPoliciesResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListTrafficPoliciesRequestMarshaller().marshall(super.beforeMarshalling(listTrafficPoliciesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListTrafficPoliciesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve the health check status, send a <code>GET</code> request
     * to the <code>2013-04-01/healthcheck/health check ID/status</code>
     * resource. You can use this call to get a health check's current
     * status.
     * </p>
     *
     * @param getHealthCheckStatusRequest Container for the necessary
     *           parameters to execute the GetHealthCheckStatus service method on
     *           AmazonRoute53.
     * 
     * @return The response from the GetHealthCheckStatus service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws NoSuchHealthCheckException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetHealthCheckStatusResult getHealthCheckStatus(GetHealthCheckStatusRequest getHealthCheckStatusRequest) {
        ExecutionContext executionContext = createExecutionContext(getHealthCheckStatusRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetHealthCheckStatusRequest> request = null;
        Response<GetHealthCheckStatusResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetHealthCheckStatusRequestMarshaller().marshall(super.beforeMarshalling(getHealthCheckStatusRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetHealthCheckStatusResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve a list of your hosted zones, send a <code>GET</code>
     * request to the <code>2013-04-01/hostedzone</code> resource. The
     * response to this request includes a <code>HostedZones</code> element
     * with zero, one, or multiple <code>HostedZone</code> child elements. By
     * default, the list of hosted zones is displayed on a single page. You
     * can control the length of the page that is displayed by using the
     * <code>MaxItems</code> parameter. You can use the <code>Marker</code>
     * parameter to control the hosted zone that the list begins with.
     * </p>
     * <p>
     * <b>NOTE:</b> Amazon Route 53 returns a maximum of 100 items. If you
     * set MaxItems to a value greater than 100, Amazon Route 53 returns only
     * the first 100.
     * </p>
     *
     * @param listHostedZonesRequest Container for the necessary parameters
     *           to execute the ListHostedZones service method on AmazonRoute53.
     * 
     * @return The response from the ListHostedZones service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws NoSuchDelegationSetException
     * @throws DelegationSetNotReusableException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListHostedZonesResult listHostedZones(ListHostedZonesRequest listHostedZonesRequest) {
        ExecutionContext executionContext = createExecutionContext(listHostedZonesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListHostedZonesRequest> request = null;
        Response<ListHostedZonesResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListHostedZonesRequestMarshaller().marshall(super.beforeMarshalling(listHostedZonesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListHostedZonesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve a count of all your hosted zones, send a <code>GET</code>
     * request to the <code>2013-04-01/hostedzonecount</code> resource.
     * </p>
     *
     * @param getHostedZoneCountRequest Container for the necessary
     *           parameters to execute the GetHostedZoneCount service method on
     *           AmazonRoute53.
     * 
     * @return The response from the GetHostedZoneCount service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetHostedZoneCountResult getHostedZoneCount(GetHostedZoneCountRequest getHostedZoneCountRequest) {
        ExecutionContext executionContext = createExecutionContext(getHostedZoneCountRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetHostedZoneCountRequest> request = null;
        Response<GetHostedZoneCountResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetHostedZoneCountRequestMarshaller().marshall(super.beforeMarshalling(getHostedZoneCountRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetHostedZoneCountResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * This action updates an existing health check.
     * </p>
     * <p>
     * To update a health check, send a <code>POST</code> request to the
     * <code>2013-04-01/healthcheck/health check ID </code> resource. The
     * request body must include an XML document with an
     * <code>UpdateHealthCheckRequest</code> element. The response returns an
     * <code>UpdateHealthCheckResponse</code> element, which contains
     * metadata about the health check.
     * </p>
     *
     * @param updateHealthCheckRequest Container for the necessary parameters
     *           to execute the UpdateHealthCheck service method on AmazonRoute53.
     * 
     * @return The response from the UpdateHealthCheck service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws HealthCheckVersionMismatchException
     * @throws NoSuchHealthCheckException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public UpdateHealthCheckResult updateHealthCheck(UpdateHealthCheckRequest updateHealthCheckRequest) {
        ExecutionContext executionContext = createExecutionContext(updateHealthCheckRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateHealthCheckRequest> request = null;
        Response<UpdateHealthCheckResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateHealthCheckRequestMarshaller().marshall(super.beforeMarshalling(updateHealthCheckRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new UpdateHealthCheckResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve the reusable delegation set, send a <code>GET</code>
     * request to the <code>2013-04-01/delegationset/delegation set ID
     * </code> resource.
     * </p>
     *
     * @param getReusableDelegationSetRequest Container for the necessary
     *           parameters to execute the GetReusableDelegationSet service method on
     *           AmazonRoute53.
     * 
     * @return The response from the GetReusableDelegationSet service method,
     *         as returned by AmazonRoute53.
     * 
     * @throws NoSuchDelegationSetException
     * @throws DelegationSetNotReusableException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetReusableDelegationSetResult getReusableDelegationSet(GetReusableDelegationSetRequest getReusableDelegationSetRequest) {
        ExecutionContext executionContext = createExecutionContext(getReusableDelegationSetRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetReusableDelegationSetRequest> request = null;
        Response<GetReusableDelegationSetResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetReusableDelegationSetRequestMarshaller().marshall(super.beforeMarshalling(getReusableDelegationSetRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetReusableDelegationSetResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve a list of your hosted zones in lexicographic order, send
     * a <code>GET</code> request to the
     * <code>2013-04-01/hostedzonesbyname</code> resource. The response to
     * this request includes a <code>HostedZones</code> element with zero or
     * more <code>HostedZone</code> child elements lexicographically ordered
     * by DNS name. By default, the list of hosted zones is displayed on a
     * single page. You can control the length of the page that is displayed
     * by using the <code>MaxItems</code> parameter. You can use the
     * <code>DNSName</code> and <code>HostedZoneId</code> parameters to
     * control the hosted zone that the list begins with.
     * </p>
     * <p>
     * <b>NOTE:</b> Amazon Route 53 returns a maximum of 100 items. If you
     * set MaxItems to a value greater than 100, Amazon Route 53 returns only
     * the first 100.
     * </p>
     *
     * @param listHostedZonesByNameRequest Container for the necessary
     *           parameters to execute the ListHostedZonesByName service method on
     *           AmazonRoute53.
     * 
     * @return The response from the ListHostedZonesByName service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws InvalidInputException
     * @throws InvalidDomainNameException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListHostedZonesByNameResult listHostedZonesByName(ListHostedZonesByNameRequest listHostedZonesByNameRequest) {
        ExecutionContext executionContext = createExecutionContext(listHostedZonesByNameRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListHostedZonesByNameRequest> request = null;
        Response<ListHostedZonesByNameResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListHostedZonesByNameRequestMarshaller().marshall(super.beforeMarshalling(listHostedZonesByNameRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListHostedZonesByNameResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Gets information about a specific traffic policy version. To get the
     * information, send a <code>GET</code> request to the
     * <code>2013-04-01/trafficpolicy</code> resource.
     * </p>
     *
     * @param getTrafficPolicyRequest Container for the necessary parameters
     *           to execute the GetTrafficPolicy service method on AmazonRoute53.
     * 
     * @return The response from the GetTrafficPolicy service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws NoSuchTrafficPolicyException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetTrafficPolicyResult getTrafficPolicy(GetTrafficPolicyRequest getTrafficPolicyRequest) {
        ExecutionContext executionContext = createExecutionContext(getTrafficPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetTrafficPolicyRequest> request = null;
        Response<GetTrafficPolicyResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetTrafficPolicyRequestMarshaller().marshall(super.beforeMarshalling(getTrafficPolicyRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetTrafficPolicyResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Deletes a traffic policy. To delete a traffic policy, send a
     * <code>DELETE</code> request to the
     * <code>2013-04-01/trafficpolicy</code> resource.
     * </p>
     *
     * @param deleteTrafficPolicyRequest Container for the necessary
     *           parameters to execute the DeleteTrafficPolicy service method on
     *           AmazonRoute53.
     * 
     * @return The response from the DeleteTrafficPolicy service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws ConcurrentModificationException
     * @throws NoSuchTrafficPolicyException
     * @throws TrafficPolicyInUseException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DeleteTrafficPolicyResult deleteTrafficPolicy(DeleteTrafficPolicyRequest deleteTrafficPolicyRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteTrafficPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteTrafficPolicyRequest> request = null;
        Response<DeleteTrafficPolicyResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteTrafficPolicyRequestMarshaller().marshall(super.beforeMarshalling(deleteTrafficPolicyRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new DeleteTrafficPolicyResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Gets the number of traffic policy instances that are associated with
     * the current AWS account.
     * </p>
     * <p>
     * To get the number of traffic policy instances, send a
     * <code>GET</code> request to the
     * <code>2013-04-01/trafficpolicyinstancecount</code> resource.
     * </p>
     *
     * @param getTrafficPolicyInstanceCountRequest Container for the
     *           necessary parameters to execute the GetTrafficPolicyInstanceCount
     *           service method on AmazonRoute53.
     * 
     * @return The response from the GetTrafficPolicyInstanceCount service
     *         method, as returned by AmazonRoute53.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetTrafficPolicyInstanceCountResult getTrafficPolicyInstanceCount(GetTrafficPolicyInstanceCountRequest getTrafficPolicyInstanceCountRequest) {
        ExecutionContext executionContext = createExecutionContext(getTrafficPolicyInstanceCountRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetTrafficPolicyInstanceCountRequest> request = null;
        Response<GetTrafficPolicyInstanceCountResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetTrafficPolicyInstanceCountRequestMarshaller().marshall(super.beforeMarshalling(getTrafficPolicyInstanceCountRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new GetTrafficPolicyInstanceCountResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * This action deletes a hosted zone. To delete a hosted zone, send a
     * <code>DELETE</code> request to the <code>2013-04-01/hostedzone/hosted
     * zone ID </code> resource.
     * </p>
     * <p>
     * For more information about deleting a hosted zone, see
     * <a href="http://docs.aws.amazon.com/Route53/latest/DeveloperGuide/DeleteHostedZone.html"> Deleting a Hosted Zone </a>
     * in the <i>Amazon Route 53 Developer Guide</i> .
     * </p>
     * <p>
     * <b>IMPORTANT:</b> You can delete a hosted zone only if there are no
     * resource record sets other than the default SOA record and NS resource
     * record sets. If your hosted zone contains other resource record sets,
     * you must delete them before you can delete your hosted zone. If you
     * try to delete a hosted zone that contains other resource record sets,
     * Amazon Route 53 will deny your request with a HostedZoneNotEmpty
     * error. For information about deleting records from your hosted zone,
     * see ChangeResourceRecordSets.
     * </p>
     *
     * @param deleteHostedZoneRequest Container for the necessary parameters
     *           to execute the DeleteHostedZone service method on AmazonRoute53.
     * 
     * @return The response from the DeleteHostedZone service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws PriorRequestNotCompleteException
     * @throws HostedZoneNotEmptyException
     * @throws NoSuchHostedZoneException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DeleteHostedZoneResult deleteHostedZone(DeleteHostedZoneRequest deleteHostedZoneRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteHostedZoneRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteHostedZoneRequest> request = null;
        Response<DeleteHostedZoneResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteHostedZoneRequestMarshaller().marshall(super.beforeMarshalling(deleteHostedZoneRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new DeleteHostedZoneResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * This action creates a new hosted zone.
     * </p>
     * <p>
     * To create a new hosted zone, send a <code>POST</code> request to the
     * <code>2013-04-01/hostedzone</code> resource. The request body must
     * include an XML document with a <code>CreateHostedZoneRequest</code>
     * element. The response returns the
     * <code>CreateHostedZoneResponse</code> element that contains metadata
     * about the hosted zone.
     * </p>
     * <p>
     * Amazon Route 53 automatically creates a default SOA record and four
     * NS records for the zone. The NS records in the hosted zone are the
     * name servers you give your registrar to delegate your domain to. For
     * more information about SOA and NS records, see
     * <a href="http://docs.aws.amazon.com/Route53/latest/DeveloperGuide/SOA-NSrecords.html"> NS and SOA Records that Amazon Route 53 Creates for a Hosted Zone </a>
     * in the <i>Amazon Route 53 Developer Guide</i> .
     * </p>
     * <p>
     * When you create a zone, its initial status is <code>PENDING</code> .
     * This means that it is not yet available on all DNS servers. The status
     * of the zone changes to <code>INSYNC</code> when the NS and SOA records
     * are available on all Amazon Route 53 DNS servers.
     * </p>
     * <p>
     * When trying to create a hosted zone using a reusable delegation set,
     * you could specify an optional DelegationSetId, and Route53 would
     * assign those 4 NS records for the zone, instead of alloting a new one.
     * </p>
     *
     * @param createHostedZoneRequest Container for the necessary parameters
     *           to execute the CreateHostedZone service method on AmazonRoute53.
     * 
     * @return The response from the CreateHostedZone service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws ConflictingDomainExistsException
     * @throws TooManyHostedZonesException
     * @throws NoSuchDelegationSetException
     * @throws InvalidVPCIdException
     * @throws DelegationSetNotAvailableException
     * @throws DelegationSetNotReusableException
     * @throws InvalidDomainNameException
     * @throws InvalidInputException
     * @throws HostedZoneAlreadyExistsException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateHostedZoneResult createHostedZone(CreateHostedZoneRequest createHostedZoneRequest) {
        ExecutionContext executionContext = createExecutionContext(createHostedZoneRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateHostedZoneRequest> request = null;
        Response<CreateHostedZoneResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateHostedZoneRequestMarshaller().marshall(super.beforeMarshalling(createHostedZoneRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new CreateHostedZoneResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * This action associates a VPC with an hosted zone.
     * </p>
     * <p>
     * To associate a VPC with an hosted zone, send a <code>POST</code>
     * request to the <code>2013-04-01/hostedzone/hosted zone
     * ID/associatevpc</code> resource. The request body must include an XML
     * document with a <code>AssociateVPCWithHostedZoneRequest</code>
     * element. The response returns the
     * <code>AssociateVPCWithHostedZoneResponse</code> element that contains
     * <code>ChangeInfo</code> for you to track the progress of the
     * <code>AssociateVPCWithHostedZoneRequest</code> you made. See
     * <code>GetChange</code> operation for how to track the progress of your
     * change.
     * </p>
     *
     * @param associateVPCWithHostedZoneRequest Container for the necessary
     *           parameters to execute the AssociateVPCWithHostedZone service method on
     *           AmazonRoute53.
     * 
     * @return The response from the AssociateVPCWithHostedZone service
     *         method, as returned by AmazonRoute53.
     * 
     * @throws ConflictingDomainExistsException
     * @throws InvalidVPCIdException
     * @throws NoSuchHostedZoneException
     * @throws PublicZoneVPCAssociationException
     * @throws InvalidInputException
     * @throws LimitsExceededException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public AssociateVPCWithHostedZoneResult associateVPCWithHostedZone(AssociateVPCWithHostedZoneRequest associateVPCWithHostedZoneRequest) {
        ExecutionContext executionContext = createExecutionContext(associateVPCWithHostedZoneRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AssociateVPCWithHostedZoneRequest> request = null;
        Response<AssociateVPCWithHostedZoneResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AssociateVPCWithHostedZoneRequestMarshaller().marshall(super.beforeMarshalling(associateVPCWithHostedZoneRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new AssociateVPCWithHostedZoneResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     *
     * @param listTagsForResourceRequest Container for the necessary
     *           parameters to execute the ListTagsForResource service method on
     *           AmazonRoute53.
     * 
     * @return The response from the ListTagsForResource service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws PriorRequestNotCompleteException
     * @throws NoSuchHealthCheckException
     * @throws ThrottlingException
     * @throws NoSuchHostedZoneException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListTagsForResourceResult listTagsForResource(ListTagsForResourceRequest listTagsForResourceRequest) {
        ExecutionContext executionContext = createExecutionContext(listTagsForResourceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListTagsForResourceRequest> request = null;
        Response<ListTagsForResourceResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListTagsForResourceRequestMarshaller().marshall(super.beforeMarshalling(listTagsForResourceRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListTagsForResourceResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve a list of your reusable delegation sets, send a
     * <code>GET</code> request to the <code>2013-04-01/delegationset</code>
     * resource. The response to this request includes a
     * <code>DelegationSets</code> element with zero, one, or multiple
     * <code>DelegationSet</code> child elements. By default, the list of
     * delegation sets is displayed on a single page. You can control the
     * length of the page that is displayed by using the
     * <code>MaxItems</code> parameter. You can use the <code>Marker</code>
     * parameter to control the delegation set that the list begins with.
     * </p>
     * <p>
     * <b>NOTE:</b> Amazon Route 53 returns a maximum of 100 items. If you
     * set MaxItems to a value greater than 100, Amazon Route 53 returns only
     * the first 100.
     * </p>
     *
     * @param listReusableDelegationSetsRequest Container for the necessary
     *           parameters to execute the ListReusableDelegationSets service method on
     *           AmazonRoute53.
     * 
     * @return The response from the ListReusableDelegationSets service
     *         method, as returned by AmazonRoute53.
     * 
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListReusableDelegationSetsResult listReusableDelegationSets(ListReusableDelegationSetsRequest listReusableDelegationSetsRequest) {
        ExecutionContext executionContext = createExecutionContext(listReusableDelegationSetsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListReusableDelegationSetsRequest> request = null;
        Response<ListReusableDelegationSetsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListReusableDelegationSetsRequestMarshaller().marshall(super.beforeMarshalling(listReusableDelegationSetsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListReusableDelegationSetsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * This action gets the list of ChangeBatches in a given time period for
     * a given hosted zone.
     * </p>
     *
     * @param listChangeBatchesByHostedZoneRequest Container for the
     *           necessary parameters to execute the ListChangeBatchesByHostedZone
     *           service method on AmazonRoute53.
     * 
     * @return The response from the ListChangeBatchesByHostedZone service
     *         method, as returned by AmazonRoute53.
     * 
     * @throws NoSuchHostedZoneException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListChangeBatchesByHostedZoneResult listChangeBatchesByHostedZone(ListChangeBatchesByHostedZoneRequest listChangeBatchesByHostedZoneRequest) {
        ExecutionContext executionContext = createExecutionContext(listChangeBatchesByHostedZoneRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListChangeBatchesByHostedZoneRequest> request = null;
        Response<ListChangeBatchesByHostedZoneResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListChangeBatchesByHostedZoneRequestMarshaller().marshall(super.beforeMarshalling(listChangeBatchesByHostedZoneRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListChangeBatchesByHostedZoneResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Use this action to create or change your authoritative DNS
     * information. To use this action, send a <code>POST</code> request to
     * the <code>2013-04-01/hostedzone/hosted Zone ID/rrset</code> resource.
     * The request body must include an XML document with a
     * <code>ChangeResourceRecordSetsRequest</code> element.
     * </p>
     * <p>
     * Changes are a list of change items and are considered transactional.
     * For more information on transactional changes, also known as change
     * batches, see
     * <a href="http://docs.aws.amazon.com/Route53/latest/APIReference/"> POST ChangeResourceRecordSets </a>
     * in the <i>Amazon Route 53 API Reference</i> .
     * </p>
     * <p>
     * <b>IMPORTANT:</b>Due to the nature of transactional changes, you
     * cannot delete the same resource record set more than once in a single
     * change batch. If you attempt to delete the same change batch more than
     * once, Amazon Route 53 returns an InvalidChangeBatch error.
     * </p>
     * <p>
     * In response to a <code>ChangeResourceRecordSets</code> request, your
     * DNS data is changed on all Amazon Route 53 DNS servers. Initially, the
     * status of a change is <code>PENDING</code> . This means the change has
     * not yet propagated to all the authoritative Amazon Route 53 DNS
     * servers. When the change is propagated to all hosts, the change
     * returns a status of <code>INSYNC</code> .
     * </p>
     * <p>
     * Note the following limitations on a
     * <code>ChangeResourceRecordSets</code> request:
     * </p>
     * 
     * <ul>
     * <li>A request cannot contain more than 100 Change elements.</li>
     * <li> A request cannot contain more than 1000 ResourceRecord
     * elements.</li>
     * <li>The sum of the number of characters (including spaces) in all
     * <code>Value</code> elements in a request cannot exceed 32,000
     * characters.</li>
     * 
     * </ul>
     *
     * @param changeResourceRecordSetsRequest Container for the necessary
     *           parameters to execute the ChangeResourceRecordSets service method on
     *           AmazonRoute53.
     * 
     * @return The response from the ChangeResourceRecordSets service method,
     *         as returned by AmazonRoute53.
     * 
     * @throws PriorRequestNotCompleteException
     * @throws NoSuchHealthCheckException
     * @throws NoSuchHostedZoneException
     * @throws InvalidInputException
     * @throws InvalidChangeBatchException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ChangeResourceRecordSetsResult changeResourceRecordSets(ChangeResourceRecordSetsRequest changeResourceRecordSetsRequest) {
        ExecutionContext executionContext = createExecutionContext(changeResourceRecordSetsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ChangeResourceRecordSetsRequest> request = null;
        Response<ChangeResourceRecordSetsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ChangeResourceRecordSetsRequestMarshaller().marshall(super.beforeMarshalling(changeResourceRecordSetsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ChangeResourceRecordSetsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Creates a new version of an existing traffic policy. When you create
     * a new version of a traffic policy, you specify the ID of the traffic
     * policy that you want to update and a JSON-formatted document that
     * describes the new version.
     * </p>
     * <p>
     * You use traffic policies to create multiple DNS resource record sets
     * for one domain name (such as example.com) or one subdomain name (such
     * as www.example.com).
     * </p>
     * <p>
     * To create a new version, send a <code>POST</code> request to the
     * <code>2013-04-01/trafficpolicy/</code> resource. The request body
     * includes an XML document with a
     * <code>CreateTrafficPolicyVersionRequest</code> element. The response
     * returns the <code>CreateTrafficPolicyVersionResponse</code> element,
     * which contains information about the new version of the traffic
     * policy.
     * </p>
     *
     * @param createTrafficPolicyVersionRequest Container for the necessary
     *           parameters to execute the CreateTrafficPolicyVersion service method on
     *           AmazonRoute53.
     * 
     * @return The response from the CreateTrafficPolicyVersion service
     *         method, as returned by AmazonRoute53.
     * 
     * @throws ConcurrentModificationException
     * @throws InvalidTrafficPolicyDocumentException
     * @throws NoSuchTrafficPolicyException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateTrafficPolicyVersionResult createTrafficPolicyVersion(CreateTrafficPolicyVersionRequest createTrafficPolicyVersionRequest) {
        ExecutionContext executionContext = createExecutionContext(createTrafficPolicyVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateTrafficPolicyVersionRequest> request = null;
        Response<CreateTrafficPolicyVersionResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateTrafficPolicyVersionRequestMarshaller().marshall(super.beforeMarshalling(createTrafficPolicyVersionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new CreateTrafficPolicyVersionResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Gets information about the traffic policy instances that you created
     * by using a specify traffic policy version.
     * </p>
     * <p>
     * <b>NOTE:</b>After you submit a CreateTrafficPolicyInstance or an
     * UpdateTrafficPolicyInstance request, there's a brief delay while
     * Amazon Route 53 creates the resource record sets that are specified in
     * the traffic policy definition. For more information, see the State
     * response element.
     * </p>
     * <p>
     * To get information about the traffic policy instances that you
     * created by using a specify traffic policy version, send a
     * <code>GET</code> request to the
     * <code>2013-04-01/trafficpolicyinstance</code> resource and include the
     * ID and version of the traffic policy.
     * </p>
     * <p>
     * Amazon Route 53 returns a maximum of 100 items in each response. If
     * you have a lot of traffic policy instances, you can use the
     * <code>MaxItems</code> parameter to list them in groups of up to 100.
     * </p>
     * <p>
     * The response includes five values that help you navigate from one
     * group of <code>MaxItems</code> traffic policy instances to the next:
     * </p>
     * 
     * <ul>
     * <li> <b>IsTruncated</b> <p>
     * If the value of <code>IsTruncated</code> in the response is
     * <code>true</code> , there are more traffic policy instances associated
     * with the specified traffic policy.
     * </p>
     * <p>
     * If <code>IsTruncated</code> is <code>false</code> , this response
     * includes the last traffic policy instance that is associated with the
     * specified traffic policy.
     * </p>
     * </li>
     * <li> <b>MaxItems</b> <p>
     * The value that you specified for the <code>MaxItems</code> parameter
     * in the request that produced the current response.
     * </p>
     * </li>
     * <li> <b>HostedZoneIdMarker</b> ,
     * <b>TrafficPolicyInstanceNameMarker</b> , and
     * <b>TrafficPolicyInstanceTypeMarker</b> <p>
     * If <code>IsTruncated</code> is <code>true</code> , these values in
     * the response represent the first traffic policy instance in the next
     * group of <code>MaxItems</code> traffic policy instances. To list more
     * traffic policy instances, make another call to
     * <code>ListTrafficPolicyInstancesByPolicy</code> , and specify these
     * values in the corresponding request parameters.
     * </p>
     * <p>
     * If <code>IsTruncated</code> is <code>false</code> , all three
     * elements are omitted from the response.
     * </p>
     * </li>
     * 
     * </ul>
     *
     * @param listTrafficPolicyInstancesByPolicyRequest Container for the
     *           necessary parameters to execute the ListTrafficPolicyInstancesByPolicy
     *           service method on AmazonRoute53.
     * 
     * @return The response from the ListTrafficPolicyInstancesByPolicy
     *         service method, as returned by AmazonRoute53.
     * 
     * @throws NoSuchTrafficPolicyException
     * @throws InvalidInputException
     * @throws NoSuchTrafficPolicyInstanceException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListTrafficPolicyInstancesByPolicyResult listTrafficPolicyInstancesByPolicy(ListTrafficPolicyInstancesByPolicyRequest listTrafficPolicyInstancesByPolicyRequest) {
        ExecutionContext executionContext = createExecutionContext(listTrafficPolicyInstancesByPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListTrafficPolicyInstancesByPolicyRequest> request = null;
        Response<ListTrafficPolicyInstancesByPolicyResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListTrafficPolicyInstancesByPolicyRequestMarshaller().marshall(super.beforeMarshalling(listTrafficPolicyInstancesByPolicyRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            response = invoke(request, new ListTrafficPolicyInstancesByPolicyResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();

        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve a single geo location, send a <code>GET</code> request to
     * the <code>2013-04-01/geolocation</code> resource with one of these
     * options: continentcode | countrycode | countrycode and
     * subdivisioncode.
     * </p>
     * 
     * @return The response from the GetGeoLocation service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws NoSuchGeoLocationException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetGeoLocationResult getGeoLocation() throws AmazonServiceException, AmazonClientException {
        return getGeoLocation(new GetGeoLocationRequest());
    }
    
    /**
     * <p>
     * To retrieve a list of the IP ranges used by Amazon Route 53 health
     * checkers to check the health of your resources, send a
     * <code>GET</code> request to the
     * <code>2013-04-01/checkeripranges</code> resource. You can use these IP
     * addresses to configure router and firewall rules to allow health
     * checkers to check the health of your resources.
     * </p>
     * 
     * @return The response from the GetCheckerIpRanges service method, as
     *         returned by AmazonRoute53.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetCheckerIpRangesResult getCheckerIpRanges() throws AmazonServiceException, AmazonClientException {
        return getCheckerIpRanges(new GetCheckerIpRangesRequest());
    }
    
    /**
     * <p>
     * To retrieve a list of your health checks, send a <code>GET</code>
     * request to the <code>2013-04-01/healthcheck</code> resource. The
     * response to this request includes a <code>HealthChecks</code> element
     * with zero, one, or multiple <code>HealthCheck</code> child elements.
     * By default, the list of health checks is displayed on a single page.
     * You can control the length of the page that is displayed by using the
     * <code>MaxItems</code> parameter. You can use the <code>Marker</code>
     * parameter to control the health check that the list begins with.
     * </p>
     * <p>
     * <b>NOTE:</b> Amazon Route 53 returns a maximum of 100 items. If you
     * set MaxItems to a value greater than 100, Amazon Route 53 returns only
     * the first 100.
     * </p>
     * 
     * @return The response from the ListHealthChecks service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws IncompatibleVersionException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListHealthChecksResult listHealthChecks() throws AmazonServiceException, AmazonClientException {
        return listHealthChecks(new ListHealthChecksRequest());
    }
    
    /**
     * <p>
     * To retrieve a list of supported geo locations, send a
     * <code>GET</code> request to the <code>2013-04-01/geolocations</code>
     * resource. The response to this request includes a
     * <code>GeoLocationDetailsList</code> element with zero, one, or
     * multiple <code>GeoLocationDetails</code> child elements. The list is
     * sorted by country code, and then subdivision code, followed by
     * continents at the end of the list.
     * </p>
     * <p>
     * By default, the list of geo locations is displayed on a single page.
     * You can control the length of the page that is displayed by using the
     * <code>MaxItems</code> parameter. If the list is truncated,
     * <code>IsTruncated</code> will be set to <i>true</i> and a combination
     * of <code>NextContinentCode, NextCountryCode,
     * NextSubdivisionCode</code> will be populated. You can pass these as
     * parameters to <code>StartContinentCode, StartCountryCode,
     * StartSubdivisionCode</code> to control the geo location that the list
     * begins with.
     * </p>
     * 
     * @return The response from the ListGeoLocations service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListGeoLocationsResult listGeoLocations() throws AmazonServiceException, AmazonClientException {
        return listGeoLocations(new ListGeoLocationsRequest());
    }
    
    /**
     * <p>
     * To retrieve a count of all your health checks, send a
     * <code>GET</code> request to the
     * <code>2013-04-01/healthcheckcount</code> resource.
     * </p>
     * 
     * @return The response from the GetHealthCheckCount service method, as
     *         returned by AmazonRoute53.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetHealthCheckCountResult getHealthCheckCount() throws AmazonServiceException, AmazonClientException {
        return getHealthCheckCount(new GetHealthCheckCountRequest());
    }
    
    /**
     * <p>
     * Gets information about the traffic policy instances that you created
     * by using the current AWS account.
     * </p>
     * <p>
     * <b>NOTE:</b>After you submit an UpdateTrafficPolicyInstance request,
     * there's a brief delay while Amazon Route 53 creates the resource
     * record sets that are specified in the traffic policy definition. For
     * more information, see the State response element.
     * </p>
     * <p>
     * To get information about the traffic policy instances that are
     * associated with the current AWS account, send a <code>GET</code>
     * request to the <code>2013-04-01/trafficpolicyinstance</code> resource.
     * </p>
     * <p>
     * Amazon Route 53 returns a maximum of 100 items in each response. If
     * you have a lot of traffic policy instances, you can use the
     * <code>MaxItems</code> parameter to list them in groups of up to 100.
     * </p>
     * <p>
     * The response includes five values that help you navigate from one
     * group of <code>MaxItems</code> traffic policy instances to the next:
     * </p>
     * 
     * <ul>
     * <li> <b>IsTruncated</b> </li>
     * <p>
     * If the value of <code>IsTruncated</code> in the response is
     * <code>true</code> , there are more traffic policy instances associated
     * with the current AWS account.
     * </p>
     * <p>
     * If <code>IsTruncated</code> is <code>false</code> , this response
     * includes the last traffic policy instance that is associated with the
     * current account.
     * </p>
     * <li> <b>MaxItems</b> </li>
     * <p>
     * The value that you specified for the <code>MaxItems</code> parameter
     * in the request that produced the current response.
     * </p>
     * <li> <b>HostedZoneIdMarker</b> ,
     * <b>TrafficPolicyInstanceNameMarker</b> , and
     * <b>TrafficPolicyInstanceTypeMarker</b> </li>
     * <p>
     * If <code>IsTruncated</code> is <code>true</code> , these three values
     * in the response represent the first traffic policy instance in the
     * next group of <code>MaxItems</code> traffic policy instances. To list
     * more traffic policy instances, make another call to
     * <code>ListTrafficPolicyInstances</code> , and specify these values in
     * the corresponding request parameters.
     * </p>
     * <p>
     * If <code>IsTruncated</code> is <code>false</code> , all three
     * elements are omitted from the response.
     * </p>
     * 
     * </ul>
     * 
     * @return The response from the ListTrafficPolicyInstances service
     *         method, as returned by AmazonRoute53.
     * 
     * @throws InvalidInputException
     * @throws NoSuchTrafficPolicyInstanceException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListTrafficPolicyInstancesResult listTrafficPolicyInstances() throws AmazonServiceException, AmazonClientException {
        return listTrafficPolicyInstances(new ListTrafficPolicyInstancesRequest());
    }
    
    /**
     * <p>
     * Gets information about the latest version for every traffic policy
     * that is associated with the current AWS account. To get the
     * information, send a <code>GET</code> request to the
     * <code>2013-04-01/trafficpolicy</code> resource.
     * </p>
     * <p>
     * Amazon Route 53 returns a maximum of 100 items in each response. If
     * you have a lot of traffic policies, you can use the
     * <code>maxitems</code> parameter to list them in groups of up to 100.
     * </p>
     * <p>
     * The response includes three values that help you navigate from one
     * group of <code>maxitems</code> traffic policies to the next:
     * </p>
     * 
     * <ul>
     * <li> <b>IsTruncated</b> </li>
     * <p>
     * If the value of <code>IsTruncated</code> in the response is
     * <code>true</code> , there are more traffic policies associated with
     * the current AWS account.
     * </p>
     * <p>
     * If <code>IsTruncated</code> is <code>false</code> , this response
     * includes the last traffic policy that is associated with the current
     * account.
     * </p>
     * <li> <b>TrafficPolicyIdMarker</b> </li>
     * <p>
     * If <code>IsTruncated</code> is <code>true</code> ,
     * <code>TrafficPolicyIdMarker</code> is the ID of the first traffic
     * policy in the next group of <code>MaxItems</code> traffic policies. If
     * you want to list more traffic policies, make another call to
     * <code>ListTrafficPolicies</code> , and specify the value of the
     * <code>TrafficPolicyIdMarker</code> element from the response in the
     * <code>TrafficPolicyIdMarker</code> request parameter.
     * </p>
     * <p>
     * If <code>IsTruncated</code> is <code>false</code> , the
     * <code>TrafficPolicyIdMarker</code> element is omitted from the
     * response.
     * </p>
     * <li> <b>MaxItems</b> </li>
     * <p>
     * The value that you specified for the <code>MaxItems</code> parameter
     * in the request that produced the current response.
     * </p>
     * 
     * </ul>
     * 
     * @return The response from the ListTrafficPolicies service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListTrafficPoliciesResult listTrafficPolicies() throws AmazonServiceException, AmazonClientException {
        return listTrafficPolicies(new ListTrafficPoliciesRequest());
    }
    
    /**
     * <p>
     * To retrieve a list of your hosted zones, send a <code>GET</code>
     * request to the <code>2013-04-01/hostedzone</code> resource. The
     * response to this request includes a <code>HostedZones</code> element
     * with zero, one, or multiple <code>HostedZone</code> child elements. By
     * default, the list of hosted zones is displayed on a single page. You
     * can control the length of the page that is displayed by using the
     * <code>MaxItems</code> parameter. You can use the <code>Marker</code>
     * parameter to control the hosted zone that the list begins with.
     * </p>
     * <p>
     * <b>NOTE:</b> Amazon Route 53 returns a maximum of 100 items. If you
     * set MaxItems to a value greater than 100, Amazon Route 53 returns only
     * the first 100.
     * </p>
     * 
     * @return The response from the ListHostedZones service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws NoSuchDelegationSetException
     * @throws DelegationSetNotReusableException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListHostedZonesResult listHostedZones() throws AmazonServiceException, AmazonClientException {
        return listHostedZones(new ListHostedZonesRequest());
    }
    
    /**
     * <p>
     * To retrieve a count of all your hosted zones, send a <code>GET</code>
     * request to the <code>2013-04-01/hostedzonecount</code> resource.
     * </p>
     * 
     * @return The response from the GetHostedZoneCount service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetHostedZoneCountResult getHostedZoneCount() throws AmazonServiceException, AmazonClientException {
        return getHostedZoneCount(new GetHostedZoneCountRequest());
    }
    
    /**
     * <p>
     * To retrieve a list of your hosted zones in lexicographic order, send
     * a <code>GET</code> request to the
     * <code>2013-04-01/hostedzonesbyname</code> resource. The response to
     * this request includes a <code>HostedZones</code> element with zero or
     * more <code>HostedZone</code> child elements lexicographically ordered
     * by DNS name. By default, the list of hosted zones is displayed on a
     * single page. You can control the length of the page that is displayed
     * by using the <code>MaxItems</code> parameter. You can use the
     * <code>DNSName</code> and <code>HostedZoneId</code> parameters to
     * control the hosted zone that the list begins with.
     * </p>
     * <p>
     * <b>NOTE:</b> Amazon Route 53 returns a maximum of 100 items. If you
     * set MaxItems to a value greater than 100, Amazon Route 53 returns only
     * the first 100.
     * </p>
     * 
     * @return The response from the ListHostedZonesByName service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws InvalidInputException
     * @throws InvalidDomainNameException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListHostedZonesByNameResult listHostedZonesByName() throws AmazonServiceException, AmazonClientException {
        return listHostedZonesByName(new ListHostedZonesByNameRequest());
    }
    
    /**
     * <p>
     * Gets the number of traffic policy instances that are associated with
     * the current AWS account.
     * </p>
     * <p>
     * To get the number of traffic policy instances, send a
     * <code>GET</code> request to the
     * <code>2013-04-01/trafficpolicyinstancecount</code> resource.
     * </p>
     * 
     * @return The response from the GetTrafficPolicyInstanceCount service
     *         method, as returned by AmazonRoute53.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetTrafficPolicyInstanceCountResult getTrafficPolicyInstanceCount() throws AmazonServiceException, AmazonClientException {
        return getTrafficPolicyInstanceCount(new GetTrafficPolicyInstanceCountRequest());
    }
    
    /**
     * <p>
     * To retrieve a list of your reusable delegation sets, send a
     * <code>GET</code> request to the <code>2013-04-01/delegationset</code>
     * resource. The response to this request includes a
     * <code>DelegationSets</code> element with zero, one, or multiple
     * <code>DelegationSet</code> child elements. By default, the list of
     * delegation sets is displayed on a single page. You can control the
     * length of the page that is displayed by using the
     * <code>MaxItems</code> parameter. You can use the <code>Marker</code>
     * parameter to control the delegation set that the list begins with.
     * </p>
     * <p>
     * <b>NOTE:</b> Amazon Route 53 returns a maximum of 100 items. If you
     * set MaxItems to a value greater than 100, Amazon Route 53 returns only
     * the first 100.
     * </p>
     * 
     * @return The response from the ListReusableDelegationSets service
     *         method, as returned by AmazonRoute53.
     * 
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListReusableDelegationSetsResult listReusableDelegationSets() throws AmazonServiceException, AmazonClientException {
        return listReusableDelegationSets(new ListReusableDelegationSetsRequest());
    }

    /**
     * Returns additional metadata for a previously executed successful, request, typically used for
     * debugging issues where a service isn't acting as expected.  This data isn't considered part
     * of the result data returned by an operation, so it's available through this separate,
     * diagnostic interface.
     * <p>
     * Response metadata is only cached for a limited period of time, so if you need to access
     * this extra diagnostic information for an executed request, you should use this method
     * to retrieve it as soon as possible after executing the request.
     *
     * @param request
     *            The originally executed request
     *
     * @return The response metadata for the specified request, or null if none
     *         is available.
     */
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
        return client.getResponseMetadataForRequest(request);
    }

    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request,
            Unmarshaller<X, StaxUnmarshallerContext> unmarshaller,
            ExecutionContext executionContext)
    {
        request.setEndpoint(endpoint);
        request.setTimeOffset(timeOffset);
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();

        AWSCredentials credentials = awsCredentialsProvider.getCredentials();
        if (originalRequest.getRequestCredentials() != null) {
            credentials = originalRequest.getRequestCredentials();
        }

        executionContext.setCredentials(credentials);
        
        StaxResponseHandler<X> responseHandler = new StaxResponseHandler<X>(unmarshaller);
        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);
        return client.execute(request, responseHandler, errorResponseHandler, executionContext);
    }
}
        