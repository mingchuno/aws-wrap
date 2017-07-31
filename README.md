# Asynchronous Scala Clients for Amazon Web Services

[![Build Status](https://travis-ci.org/mingchuno/aws-wrap.svg?branch=master)](https://travis-ci.org/mingchuno/aws-wrap)
[![Download](https://api.bintray.com/packages/mingchuno/maven/aws-wrap/images/download.svg?version=0.12.1)](https://bintray.com/mingchuno/maven/aws-wrap/0.12.1/link)

**This is an active maintained fork from dwhjames/aws-wrap since it is unmaintained.**

Asynchronous clients are provided for the following services:

 * DynamoDB
 * CloudWatch
 * Simple Storage Service (S3)
 * Simple Email Service (SES)
 * SimpleDB
 * Simple Notification Service (SNS)
 * Simple Queue Service (SQS)
 * Kinesis
 * Kinesis Firehose
 * KMS

## Install

aws-wrap is built for Scala 2.10.x, 2.11.x and 2.12.x against AWS Java SDK 1.11.x (for AWS Java SDK 1.10.x, 1.9.x and 1.8.x series we recommend you upgrade before using this library). Binary releases are available from [Bintray]('https://bintray.com/mingchuno/maven/aws-wrap/view?source=watch').

If you are using SBT, simply add the following to your `build.sbt` file:

```
resolvers += Resolver.bintrayRepo("mingchuno", "maven")

libraryDependencies += "com.github.dwhjames" %% "aws-wrap" % "0.12.1"
```

## Usage

Basically this libary is a thin wrap around official AWS Java SDK. Take SNS as an example

```
val javaClient = new AmazonSNSAsyncClient() // AWS Java Client
val scalaClient = new AmazonSNSScalaClient(javaClient)
val request = new CreateTopicRequest("topic_name") // good old AWS request type
val result: Future[CreateTopicResult] = scalaClient.createTopic(request) // It return a future
val result2: Future[CreateTopicResult] = scalaClient.createTopic("topic_name") // This is a shortcut

```

## Changelog

Major change will be in here for easy reference since 0.9.2.

### 0.12.1

- add KMS support (#16)

### 0.12.0

- add Kinesis and Firehose support (#15 #13)

### 0.11.0

- update AWS java SDK version and remove usage of some deprecated functions (#12)

### 0.10.0

- fix Boolean implicit conversion in Dynamo V1 and add Dynamo V2 support (#10 #11)

### 0.9.2

- cross build Scala 2.12.0
- client can now supply config on dynamodb

## Develop

`sbt compile test` for the core project. If you want to run the integration test `bundle install && sbt awsWrapTest/it:compile && sbt awsWrapTest/it:test`

## License

Copyright © 2012-2015 Pellucid Analytics.
Copyright © 2015 Daniel W. H. James.
Copyright © 2016 M.C. Or.

This software is distributed under the [Apache License, Version 2.0](LICENSE).
