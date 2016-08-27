<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.amazonaws.*" %>
<%@ page import="com.amazonaws.auth.*" %>
<%@ page import="com.amazonaws.services.ec2.*" %>
<%@ page import="com.amazonaws.services.ec2.model.*" %>
<%@ page import="com.amazonaws.services.s3.*" %>
<%@ page import="com.amazonaws.services.s3.model.*" %>
<%@ page import="com.amazonaws.services.simpledb.*" %>
<%@ page import="com.amazonaws.services.simpledb.model.*" %>
<%@ page import="com.amazonaws.services.sqs.*" %>
<%@ page import="com.amazonaws.services.sqs.model.*" %>
<%@ page import="com.amazonaws.services.sns.*" %>
<%@ page import="com.amazonaws.services.sns.model.*" %>

<%! // Share the client objects across threads to
    // avoid creating new clients for each web request
    private AmazonEC2      ec2;
    private AmazonS3        s3;
    private AmazonSimpleDB sdb;
    private AmazonSQS	   sqs;
    private AmazonSNS	   sns;
 %>

<%
    /*
     * AWS Elastic Beanstalk checks your application's health by periodically
     * sending an HTTP HEAD request to a resource in your application. By
     * default, this is the root or default resource in your application,
     * but can be configured for each environment.
     *
     * Here, we report success as long as the app server is up, but skip
     * generating the whole page since this is a HEAD request only. You
     * can employ more sophisticated health checks in your application.
     */
    if (request.getMethod().equals("HEAD")) return;
%>

<%
    if (ec2 == null) {
    	AWSCredentials credentials = new BasicAWSCredentials (
    		     "", "");
        //AWSCredentials credentials = new BasicAWSCredentials (
        //	getServletContext().getInitParameter("awsAccessKey"), 
        //	getServletContext().getInitParameter("awsSecretKey"));
     
        ec2 = new AmazonEC2Client(credentials);
        s3  = new AmazonS3Client(credentials);
        sdb = new AmazonSimpleDBClient(credentials);
        sqs = new AmazonSQSClient(credentials);
        sns = new AmazonSNSClient(credentials);
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <title>Hello AWS Web World!</title>
    <link rel="stylesheet" href="styles/styles.css" type="text/css" media="screen">
</head>
<body>
    <div id="content" class="container">
        <div class="section grid grid15 s3">
            <h2>Amazon S3 Buckets:</h2>
            <ul>
            
            
            </ul>
        </div>

        <div class="section grid grid15 sdb">
            <h2>Amazon SimpleDB Domains:</h2>
            <ul>
            </ul>
        </div>

        <div class="section grid grid15 sqs">
            <h2>Amazon SQS Queues:</h2>
            <ul>
            </ul>
        </div>

        <div class="section grid grid15 sns">
            <h2>Amazon SNS Topics:</h2>
            <ul>
            </ul>
        </div> 
        
        <div class="section grid grid15 gridlast ec2">
            <h2>Amazon EC2 Instances:</h2>
            <ul>
            </ul>
        </div>
    </div>
</body>
</html>
