package com.github.dwhjames.awswrap.kinesis

import java.nio.ByteBuffer

import com.amazonaws.services.kinesis.model.{PutRecordsRequest, PutRecordsRequestEntry}
import org.scalatest.FlatSpec

import scala.concurrent.duration._
import scala.concurrent.Await
import scala.util.{Failure, Success, Try}
import scala.collection.JavaConverters._
import scala.language.postfixOps

class KinesisSpec
  extends FlatSpec
    with KinesisClientHelper {

  behavior of "Kinesis"

  val streamName = "test"
  override val streamNames = Seq(streamName)
  val testValue = "{\"someKey\": \"someValue\"}"
  val partitionKey = "aPartitionKey"

  it should "put a value" in {
    val put = client.putRecordAsync(
      streamName,
      ByteBuffer.wrap(testValue.getBytes("UTF-8")),
      partitionKey
    )

    println("Putting value")

    Try(Await.result(put, 5 seconds)) match {
      case x: Success[_] =>
        println("Success")
        succeed
      case x: Failure[_] => fail(s"Error putting value", x.exception)
    }
  }

  it should "put multiple values" in {
    val putRecordRequest = new PutRecordsRequestEntry()
      .withData(ByteBuffer.wrap(testValue.getBytes("UTF-8")))
      .withPartitionKey(partitionKey)

    val records = Seq( putRecordRequest, putRecordRequest, putRecordRequest ).asJava

    val put = client.putRecordsAsync( new PutRecordsRequest()
      .withStreamName(streamName)
      .withRecords(records)
    )

    println("Putting values")

    Try(Await.result(put, 5 seconds)) match {
      case x: Success[_] =>
        println("Success")
        succeed
      case x: Failure[_] => fail(s"Error putting values", x.exception)
    }
  }

}
