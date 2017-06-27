/*
 * Copyright 2015 Daniel W. H. James
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dwhjames.awswrap.kinesis

import com.amazonaws.{ClientConfiguration, Protocol}
import com.amazonaws.auth.{AWSStaticCredentialsProvider, BasicAWSCredentials}
import com.amazonaws.regions.Regions
import com.amazonaws.services.kinesis.AmazonKinesisAsyncClientBuilder
import com.amazonaws.services.kinesis.AmazonKinesisAsync
import com.amazonaws.services.kinesis.model.CreateStreamRequest
import org.scalatest.{BeforeAndAfterAll, Suite}
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.util.{Failure, Success, Try}
import scala.language.postfixOps


trait KinesisClientHelper
  extends BeforeAndAfterAll
{ self: Suite =>

  private val logger: Logger = LoggerFactory.getLogger(self.getClass)

  val client: AmazonKinesisAsyncScala = {
    val credentialsProvider = new AWSStaticCredentialsProvider(new BasicAWSCredentials("FAKE_ACCESS_KEY", "FAKE_SECRET_KEY"))
    val clientConfiguration = new ClientConfiguration()
      .withProtocol(Protocol.HTTP)
      .withProxyHost("localhost")
      .withProxyPort(4567)


    val kinesisJavaClient: AmazonKinesisAsync = AmazonKinesisAsyncClientBuilder.standard()
      .withCredentials(credentialsProvider)
      .withRegion(Regions.US_EAST_1)
      .withClientConfiguration(clientConfiguration)
      .build()

    new AmazonKinesisAsyncScala(kinesisJavaClient)
  }

  val streamNames: Seq[String]

  override def beforeAll(): Unit = {
    System.setProperty("com.amazonaws.sdk.disableCbor","1")

    streamNames foreach { name =>
      logger.info(s"Creating stream $name")
      val request: CreateStreamRequest = new CreateStreamRequest()
        .withStreamName(name)
        .withShardCount(1)

      Try(Await.result(client.createStreamAsync(request), 5 seconds)) match {
        case x: Success[_] =>
          logger.info("Success")
          Thread.sleep(2000)
        case x: Failure[_] => x.exception
      }

    }

    super.beforeAll()
  }

  override def afterAll(): Unit = {
    try {
      super.afterAll()
      streamNames foreach { name =>
        logger.info(s"Deleting stream $name")
        client.deleteStreamAsync(name)
      }
    } finally {
      client.client.shutdown()
      val clearProperty: String = System.clearProperty("com.amazonaws.sdk.disableCbor")
    }
  }
}
