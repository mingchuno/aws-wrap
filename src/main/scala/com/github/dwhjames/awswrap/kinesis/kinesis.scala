/*
 * Copyright 2012-2015 Pellucid Analytics
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

package com.github.dwhjames.awswrap
package kinesis

import java.nio.ByteBuffer

import com.amazonaws.services.kinesis.AmazonKinesisAsync
import com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehoseAsync

import scala.collection.JavaConversions._
import scala.concurrent.Future

class AmazonKinesisAsyncScala(val client: AmazonKinesisAsync) {
  
  import com.amazonaws.services.kinesis.model._
  
  def addTagsToStreamAsync(
    addTagsToStreamRequest: AddTagsToStreamRequest
  ): Future[AddTagsToStreamResult] =
    wrapAsyncMethod[AddTagsToStreamRequest, AddTagsToStreamResult](client.addTagsToStreamAsync, addTagsToStreamRequest)

  def addTagsToStreamAsync(
    streamName: String,
    tags: Map[String, String]
  ): Future[AddTagsToStreamResult] =
    wrapAsyncMethod[AddTagsToStreamRequest, AddTagsToStreamResult](client.addTagsToStreamAsync,
      new AddTagsToStreamRequest().withStreamName(streamName).withTags(tags))

  def createStreamAsync(
    createStreamRequest: CreateStreamRequest
  ): Future[CreateStreamResult] =
    wrapAsyncMethod[CreateStreamRequest, CreateStreamResult](client.createStreamAsync, createStreamRequest)

  def createStreamAsync(
    streamName: String,
    shardCount: Int
  ): Future[CreateStreamResult] =
    wrapAsyncMethod[CreateStreamRequest, CreateStreamResult](client.createStreamAsync,
      new CreateStreamRequest().withStreamName(streamName).withShardCount(shardCount))

  def decreaseStreamRetentionPeriodAsync(
    decreaseStreamRetentionPeriodRequest: DecreaseStreamRetentionPeriodRequest
  ): Future[DecreaseStreamRetentionPeriodResult] =
    wrapAsyncMethod[DecreaseStreamRetentionPeriodRequest, DecreaseStreamRetentionPeriodResult](
      client.decreaseStreamRetentionPeriodAsync, decreaseStreamRetentionPeriodRequest
    )

  def decreaseStreamRetentionPeriodAsync(
    streamName: String,
    retentionPeriodHours: Int
  ): Future[DecreaseStreamRetentionPeriodResult] =
    wrapAsyncMethod[DecreaseStreamRetentionPeriodRequest, DecreaseStreamRetentionPeriodResult](
      client.decreaseStreamRetentionPeriodAsync,
      new DecreaseStreamRetentionPeriodRequest().withRetentionPeriodHours(retentionPeriodHours).withStreamName(streamName)
    )

  def deleteStreamAsync(
    deleteStreamRequest: DeleteStreamRequest
  ): Future[DeleteStreamResult] =
    wrapAsyncMethod[DeleteStreamRequest, DeleteStreamResult](client.deleteStreamAsync, deleteStreamRequest)

  def deleteStreamAsync(
    streamName: String
  ): Future[DeleteStreamResult] =
    wrapAsyncMethod[DeleteStreamRequest, DeleteStreamResult](
      client.deleteStreamAsync, new DeleteStreamRequest().withStreamName(streamName)
    )

  def describeLimitsAsync(
    describeLimitsRequest: DescribeLimitsRequest
  ): Future[DescribeLimitsResult] =
    wrapAsyncMethod[DescribeLimitsRequest, DescribeLimitsResult](client.describeLimitsAsync, describeLimitsRequest)

  def describeLimitsAsync(): Future[DescribeLimitsResult] =
    wrapAsyncMethod[DescribeLimitsRequest, DescribeLimitsResult](client.describeLimitsAsync, new DescribeLimitsRequest())

  def describeStreamAsync(
    describeStreamRequest: DescribeStreamRequest
  ): Future[DescribeStreamResult] =
    wrapAsyncMethod[DescribeStreamRequest, DescribeStreamResult](client.describeStreamAsync, describeStreamRequest)

  def describeStreamAsync(
    streamName: String
  ): Future[DescribeStreamResult] =
    wrapAsyncMethod[DescribeStreamRequest, DescribeStreamResult](
      client.describeStreamAsync, new DescribeStreamRequest().withStreamName(streamName)
    )

  def describeStreamAsync(
    streamName: String,
    exclusiveShardId: String,
    limit: Int
  ): Future[DescribeStreamResult] =
    wrapAsyncMethod[DescribeStreamRequest, DescribeStreamResult](
      client.describeStreamAsync, new DescribeStreamRequest().withStreamName(streamName).withExclusiveStartShardId(exclusiveShardId).withLimit(limit)
    )

  def describeStreamAsync(
    streamName: String,
    exclusiveShardId: String
  ): Future[DescribeStreamResult] =
    wrapAsyncMethod[DescribeStreamRequest, DescribeStreamResult](
      client.describeStreamAsync, new DescribeStreamRequest().withStreamName(streamName).withExclusiveStartShardId(exclusiveShardId)
    )

  def describeStreamAsync(
    streamName: String,
    limit: Int
  ): Future[DescribeStreamResult] =
    wrapAsyncMethod[DescribeStreamRequest, DescribeStreamResult](
      client.describeStreamAsync, new DescribeStreamRequest().withStreamName(streamName).withLimit(limit)
    )

  def disableEnhancedMonitoringAsync(
    disableEnhancedMonitoringRequest: DisableEnhancedMonitoringRequest
  ): Future[DisableEnhancedMonitoringResult] =
    wrapAsyncMethod[DisableEnhancedMonitoringRequest, DisableEnhancedMonitoringResult](
      client.disableEnhancedMonitoringAsync, disableEnhancedMonitoringRequest
    )

  def disableEnhancedMonitoringAsync(
    streamName: String
  ): Future[DisableEnhancedMonitoringResult] =
    wrapAsyncMethod[DisableEnhancedMonitoringRequest, DisableEnhancedMonitoringResult](
      client.disableEnhancedMonitoringAsync, new DisableEnhancedMonitoringRequest().withStreamName(streamName)
    )

  def enableEnhancedMonitoringAsync(
    enableEnhancedMonitoringRequest: EnableEnhancedMonitoringRequest
  ): Future[EnableEnhancedMonitoringResult] =
    wrapAsyncMethod[EnableEnhancedMonitoringRequest, EnableEnhancedMonitoringResult](
      client.enableEnhancedMonitoringAsync, enableEnhancedMonitoringRequest
    )

  def enableEnhancedMonitoringAsync(
    streamName: String
  ): Future[EnableEnhancedMonitoringResult] =
    wrapAsyncMethod[EnableEnhancedMonitoringRequest, EnableEnhancedMonitoringResult](
      client.enableEnhancedMonitoringAsync, new EnableEnhancedMonitoringRequest().withStreamName(streamName)
    )

  def getRecordsAsync(
    getRecordsRequest: GetRecordsRequest
  ): Future[GetRecordsResult] =
    wrapAsyncMethod[GetRecordsRequest, GetRecordsResult](
      client.getRecordsAsync, getRecordsRequest
    )

  def getRecordsAsync(
    shardIterator: String,
    limit: Int
  ): Future[GetRecordsResult] =
    wrapAsyncMethod[GetRecordsRequest, GetRecordsResult](
      client.getRecordsAsync, new GetRecordsRequest().withShardIterator(shardIterator).withLimit(limit)
    )

  def getShardIteratorAsync(
    getShardIteratorRequest: GetShardIteratorRequest
  ): Future[GetShardIteratorResult] =
    wrapAsyncMethod[GetShardIteratorRequest, GetShardIteratorResult](
      client.getShardIteratorAsync, getShardIteratorRequest
    )

  def getShardIteratorAsync(
    streamName: String,
    shardId: String,
    shardIteratorType: String
  ): Future[GetShardIteratorResult] =
    wrapAsyncMethod[GetShardIteratorRequest, GetShardIteratorResult](
      client.getShardIteratorAsync, new GetShardIteratorRequest().withStreamName(streamName).withShardId(shardId).withShardIteratorType(shardIteratorType)
    )

  def getShardIteratorAsync(
    streamName: String,
    shardId: String,
    shardIteratorType: String,
    startingSequenceNumber: String
  ): Future[GetShardIteratorResult] =
    wrapAsyncMethod[GetShardIteratorRequest, GetShardIteratorResult](
      client.getShardIteratorAsync,
      new GetShardIteratorRequest().withStreamName(streamName).withShardId(shardId).withShardIteratorType(shardIteratorType).withStartingSequenceNumber(startingSequenceNumber)
    )

  def increaseStreamRetentionPeriodAsync(
    increaseStreamRetentionPeriodRequest: IncreaseStreamRetentionPeriodRequest
  ): Future[IncreaseStreamRetentionPeriodResult] =
    wrapAsyncMethod[IncreaseStreamRetentionPeriodRequest, IncreaseStreamRetentionPeriodResult](
      client.increaseStreamRetentionPeriodAsync, increaseStreamRetentionPeriodRequest
    )

  def increaseStreamRetentionPeriodAsync(
    streamName: String,
    retentionPeriodHours: Int
  ): Future[IncreaseStreamRetentionPeriodResult] =
    wrapAsyncMethod[IncreaseStreamRetentionPeriodRequest, IncreaseStreamRetentionPeriodResult](
      client.increaseStreamRetentionPeriodAsync,
      new IncreaseStreamRetentionPeriodRequest().withRetentionPeriodHours(retentionPeriodHours).withStreamName(streamName)
    )

  def listStreamsAsync(
    listStreamsRequest: ListStreamsRequest
  ): Future[ListStreamsResult] =
    wrapAsyncMethod[ListStreamsRequest, ListStreamsResult](
      client.listStreamsAsync, listStreamsRequest
    )

  def listStreamsAsync(
    exclusiveStartStreamName: String
  ): Future[ListStreamsResult] =
    wrapAsyncMethod[ListStreamsRequest, ListStreamsResult](
      client.listStreamsAsync, new ListStreamsRequest().withExclusiveStartStreamName(exclusiveStartStreamName)
    )

  def listStreamsAsync(
    exclusiveStartStreamName: String,
    limit: Int
  ): Future[ListStreamsResult] =
    wrapAsyncMethod[ListStreamsRequest, ListStreamsResult](
      client.listStreamsAsync, new ListStreamsRequest().withExclusiveStartStreamName(exclusiveStartStreamName).withLimit(limit)
    )

  def listTagsForStreamAsync(
    listTagsForStreamRequest: ListTagsForStreamRequest
  ): Future[ListTagsForStreamResult] =
    wrapAsyncMethod[ListTagsForStreamRequest, ListTagsForStreamResult](
      client.listTagsForStreamAsync, listTagsForStreamRequest
    )

  def listTagsForStreamAsync(
    withExclusiveStartTagKey: String
  ): Future[ListTagsForStreamResult] =
    wrapAsyncMethod[ListTagsForStreamRequest, ListTagsForStreamResult](
      client.listTagsForStreamAsync, new ListTagsForStreamRequest().withExclusiveStartTagKey(withExclusiveStartTagKey)
    )

  def listTagsForStreamAsync(
    withExclusiveStartTagKey: String,
    limit: Int
  ): Future[ListTagsForStreamResult] =
    wrapAsyncMethod[ListTagsForStreamRequest, ListTagsForStreamResult](
      client.listTagsForStreamAsync, new ListTagsForStreamRequest().withExclusiveStartTagKey(withExclusiveStartTagKey).withLimit(limit)
    )

  def mergeShardsAsync(
    mergeShardsRequest: MergeShardsRequest
  ): Future[MergeShardsResult] =
    wrapAsyncMethod[MergeShardsRequest, MergeShardsResult](
      client.mergeShardsAsync, mergeShardsRequest
    )

  def mergeShardsAsync(
    streamName: String,
    shardToMerge: String,
    adjacentShardToMerge: String
  ): Future[MergeShardsResult] =
    wrapAsyncMethod[MergeShardsRequest, MergeShardsResult](
      client.mergeShardsAsync,
      new MergeShardsRequest().withStreamName(streamName).withShardToMerge(shardToMerge).withAdjacentShardToMerge(adjacentShardToMerge)
    )

  def putRecordAsync(
    putRecordRequest: PutRecordRequest
  ): Future[PutRecordResult] =
    wrapAsyncMethod[PutRecordRequest, PutRecordResult](
      client.putRecordAsync, putRecordRequest
    )

  def putRecordAsync(
    streamName: String,
    data: ByteBuffer,
    partitionKey: String
  ): Future[PutRecordResult] =
    wrapAsyncMethod[PutRecordRequest, PutRecordResult](
      client.putRecordAsync, new PutRecordRequest().withStreamName(streamName).withData(data).withPartitionKey(partitionKey)
    )

  def putRecordAsync(
    streamName: String,
    data: ByteBuffer,
    partitionKey: String,
    sequenceNumberForOrdering: String
  ): Future[PutRecordResult] =
    wrapAsyncMethod[PutRecordRequest, PutRecordResult](
      client.putRecordAsync,
      new PutRecordRequest().withStreamName(streamName).withData(data).withPartitionKey(partitionKey).withSequenceNumberForOrdering(sequenceNumberForOrdering)
    )

  def putRecordsAsync(
    putRecordsRequest: PutRecordsRequest
  ): Future[PutRecordsResult] =
    wrapAsyncMethod[PutRecordsRequest, PutRecordsResult](
      client.putRecordsAsync, putRecordsRequest
    )

  def removeTagsFromStreamAsync(
    removeTagsFromStreamRequest: RemoveTagsFromStreamRequest
  ): Future[RemoveTagsFromStreamResult] =
    wrapAsyncMethod[RemoveTagsFromStreamRequest, RemoveTagsFromStreamResult](
      client.removeTagsFromStreamAsync, removeTagsFromStreamRequest
    )
  
  def removeTagsFromStreamAsync(
    streamName: String,
    tagKeys: List[String]
  ): Future[RemoveTagsFromStreamResult] =
    wrapAsyncMethod[RemoveTagsFromStreamRequest, RemoveTagsFromStreamResult](client.removeTagsFromStreamAsync,
      new RemoveTagsFromStreamRequest().withStreamName(streamName).withTagKeys(tagKeys)
    )

  def splitShardAsync(
    splitShardRequest: SplitShardRequest
  ): Future[SplitShardResult] =
    wrapAsyncMethod[SplitShardRequest, SplitShardResult](
      client.splitShardAsync, splitShardRequest
    )

  def splitShardAsync(
    streamName: String,
    shardToSplit: String,
    newStartingHashKey: String
  ): Future[SplitShardResult] =
    wrapAsyncMethod[SplitShardRequest, SplitShardResult](
      client.splitShardAsync,
      new SplitShardRequest().withStreamName(streamName).withShardToSplit(shardToSplit).withNewStartingHashKey(newStartingHashKey)
    )
  
  def updateShardCountAsync(
    updateShardCountRequest: UpdateShardCountRequest
  ): Future[UpdateShardCountResult] =
    wrapAsyncMethod[UpdateShardCountRequest, UpdateShardCountResult](
      client.updateShardCountAsync, updateShardCountRequest
    )

  def updateShardCountAsync(
    streamName: String,
    scalingType: String,
    targetShardCount: Int
  ): Future[UpdateShardCountResult] =
    wrapAsyncMethod[UpdateShardCountRequest, UpdateShardCountResult](
      client.updateShardCountAsync,
      new UpdateShardCountRequest().withStreamName(streamName).withScalingType(scalingType).withTargetShardCount(targetShardCount)
    )
}

class AmazonKinesisFirehoseAsyncScala(val client: AmazonKinesisFirehoseAsync) {
  import com.amazonaws.services.kinesisfirehose.model._
  
  def createDeliveryStreamAsync(
    createDeliveryStreamRequest: CreateDeliveryStreamRequest
  ): Future[CreateDeliveryStreamResult] =
    wrapAsyncMethod[CreateDeliveryStreamRequest, CreateDeliveryStreamResult](client.createDeliveryStreamAsync, createDeliveryStreamRequest)
  
  def deleteDeliveryStreamAsync(
    deleteDeliveryStreamRequest: DeleteDeliveryStreamRequest
  ): Future[DeleteDeliveryStreamResult] =
    wrapAsyncMethod[DeleteDeliveryStreamRequest, DeleteDeliveryStreamResult](client.deleteDeliveryStreamAsync, deleteDeliveryStreamRequest)
  
  def describeDeliveryStreamAsync(
    describeDeliveryStreamRequest: DescribeDeliveryStreamRequest
  ): Future[DescribeDeliveryStreamResult] =
    wrapAsyncMethod[DescribeDeliveryStreamRequest, DescribeDeliveryStreamResult](client.describeDeliveryStreamAsync, describeDeliveryStreamRequest)
  
  def listDeliveryStreamsAsync(
    listDeliveryStreamsRequest: ListDeliveryStreamsRequest
  ): Future[ListDeliveryStreamsResult] =
    wrapAsyncMethod[ListDeliveryStreamsRequest, ListDeliveryStreamsResult](client.listDeliveryStreamsAsync, listDeliveryStreamsRequest)

  def putRecordAsync(
    putRecordRequest: PutRecordRequest
  ): Future[PutRecordResult] =
    wrapAsyncMethod[PutRecordRequest, PutRecordResult](client.putRecordAsync, putRecordRequest)
  
  def putRecordBatchAsync(
    putRecordBatchRequest: PutRecordBatchRequest
  ): Future[PutRecordBatchResult] =
    wrapAsyncMethod[PutRecordBatchRequest, PutRecordBatchResult](client.putRecordBatchAsync, putRecordBatchRequest)

  def updateDestinationAsync(
    updateDestinationRequest: UpdateDestinationRequest
  ): Future[UpdateDestinationResult] =
    wrapAsyncMethod[UpdateDestinationRequest, UpdateDestinationResult](client.updateDestinationAsync, updateDestinationRequest)
  
  
}

