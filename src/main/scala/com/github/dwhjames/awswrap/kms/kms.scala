package com.github.dwhjames.awswrap
package kms

import com.amazonaws.services.kms.AWSKMSAsync
import com.amazonaws.services.kms.model._

import scala.concurrent.Future

class AWSKMSAsyncScala(val client: AWSKMSAsync) {

  def cancelKeyDeletionAsync(
      cancelKeyDeletionRequest: CancelKeyDeletionRequest
  ): Future[CancelKeyDeletionResult] =
    wrapAsyncMethod[CancelKeyDeletionRequest, CancelKeyDeletionResult](
      client.cancelKeyDeletionAsync,
      cancelKeyDeletionRequest)

  def createAliasAsync(
      createAliasRequest: CreateAliasRequest
  ): Future[CreateAliasResult] =
    wrapAsyncMethod[CreateAliasRequest, CreateAliasResult](
      client.createAliasAsync,
      createAliasRequest)

  def createGrantAsync(
      createAliasRequest: CreateGrantRequest
  ): Future[CreateGrantResult] =
    wrapAsyncMethod[CreateGrantRequest, CreateGrantResult](
      client.createGrantAsync,
      createAliasRequest)

  def createKeyAsync(
      createKeyRequest: CreateKeyRequest
  ): Future[CreateKeyResult] =
    wrapAsyncMethod[CreateKeyRequest, CreateKeyResult](client.createKeyAsync,
                                                       createKeyRequest)

  def decryptAsync(
      decryptRequest: DecryptRequest
  ): Future[DecryptResult] =
    wrapAsyncMethod[DecryptRequest, DecryptResult](client.decryptAsync,
                                                   decryptRequest)

  def deleteAliasAsync(
      deleteAliasRequest: DeleteAliasRequest
  ): Future[DeleteAliasResult] =
    wrapAsyncMethod[DeleteAliasRequest, DeleteAliasResult](
      client.deleteAliasAsync,
      deleteAliasRequest)

  def deleteImportedKeyMaterialAsync(
      deleteImportedKeyMaterialRequest: DeleteImportedKeyMaterialRequest
  ): Future[DeleteImportedKeyMaterialResult] =
    wrapAsyncMethod[DeleteImportedKeyMaterialRequest,
                    DeleteImportedKeyMaterialResult](
      client.deleteImportedKeyMaterialAsync,
      deleteImportedKeyMaterialRequest)

  def describeKeyAsync(
      describeKeyRequest: DescribeKeyRequest
  ): Future[DescribeKeyResult] =
    wrapAsyncMethod[DescribeKeyRequest, DescribeKeyResult](
      client.describeKeyAsync,
      describeKeyRequest)

  def disableKeyAsync(
      disableKeyRequest: DisableKeyRequest
  ): Future[DisableKeyResult] =
    wrapAsyncMethod[DisableKeyRequest, DisableKeyResult](
      client.disableKeyAsync,
      disableKeyRequest)

  def disableKeyRotationAsync(
      disableKeyRotationRequest: DisableKeyRotationRequest
  ): Future[DisableKeyRotationResult] =
    wrapAsyncMethod[DisableKeyRotationRequest, DisableKeyRotationResult](
      client.disableKeyRotationAsync,
      disableKeyRotationRequest)

  def enableKeyAsync(
      enableKeyRequest: EnableKeyRequest
  ): Future[EnableKeyResult] =
    wrapAsyncMethod[EnableKeyRequest, EnableKeyResult](client.enableKeyAsync,
                                                       enableKeyRequest)

  def enableKeyRotationAsync(
      enableKeyRotationRequest: EnableKeyRotationRequest
  ): Future[EnableKeyRotationResult] =
    wrapAsyncMethod[EnableKeyRotationRequest, EnableKeyRotationResult](
      client.enableKeyRotationAsync,
      enableKeyRotationRequest)

  def encryptAsync(
      encryptRequest: EncryptRequest
  ): Future[EncryptResult] =
    wrapAsyncMethod[EncryptRequest, EncryptResult](client.encryptAsync,
                                                   encryptRequest)

  def generateDataKeyAsync(
      generateDataKeyRequest: GenerateDataKeyRequest
  ): Future[GenerateDataKeyResult] =
    wrapAsyncMethod[GenerateDataKeyRequest, GenerateDataKeyResult](
      client.generateDataKeyAsync,
      generateDataKeyRequest)

  def generateDataKeyWithoutPlaintextAsync(
      generateDataKeyWithoutPlaintextRequest: GenerateDataKeyWithoutPlaintextRequest
  ): Future[GenerateDataKeyWithoutPlaintextResult] =
    wrapAsyncMethod[GenerateDataKeyWithoutPlaintextRequest,
                    GenerateDataKeyWithoutPlaintextResult](
      client.generateDataKeyWithoutPlaintextAsync,
      generateDataKeyWithoutPlaintextRequest)

  def generateRandomAsync(
      generateRandomRequest: GenerateRandomRequest
  ): Future[GenerateRandomResult] =
    wrapAsyncMethod[GenerateRandomRequest, GenerateRandomResult](
      client.generateRandomAsync,
      generateRandomRequest)

  def getKeyPolicyAsync(
      getKeyPolicyRequest: GetKeyPolicyRequest
  ): Future[GetKeyPolicyResult] =
    wrapAsyncMethod[GetKeyPolicyRequest, GetKeyPolicyResult](
      client.getKeyPolicyAsync,
      getKeyPolicyRequest)

  def getKeyRotationStatusAsync(
      getKeyRotationStatusRequest: GetKeyRotationStatusRequest
  ): Future[GetKeyRotationStatusResult] =
    wrapAsyncMethod[GetKeyRotationStatusRequest, GetKeyRotationStatusResult](
      client.getKeyRotationStatusAsync,
      getKeyRotationStatusRequest)

  def getParametersForImportAsync(
      getParametersForImportRequest: GetParametersForImportRequest
  ): Future[GetParametersForImportResult] =
    wrapAsyncMethod[GetParametersForImportRequest,
                    GetParametersForImportResult](
      client.getParametersForImportAsync,
      getParametersForImportRequest)

  def importKeyMaterialAsync(
      importKeyMaterialRequest: ImportKeyMaterialRequest
  ): Future[ImportKeyMaterialResult] =
    wrapAsyncMethod[ImportKeyMaterialRequest, ImportKeyMaterialResult](
      client.importKeyMaterialAsync,
      importKeyMaterialRequest)

  def listAliasesAsync(
      listAliasesRequest: ListAliasesRequest
  ): Future[ListAliasesResult] =
    wrapAsyncMethod[ListAliasesRequest, ListAliasesResult](
      client.listAliasesAsync,
      listAliasesRequest)

  def listGrantsAsync(
      listGrantsRequest: ListGrantsRequest
  ): Future[ListGrantsResult] =
    wrapAsyncMethod[ListGrantsRequest, ListGrantsResult](
      client.listGrantsAsync,
      listGrantsRequest)

  def listKeyPoliciesAsync(
      listKeyPoliciesRequest: ListKeyPoliciesRequest
  ): Future[ListKeyPoliciesResult] =
    wrapAsyncMethod[ListKeyPoliciesRequest, ListKeyPoliciesResult](
      client.listKeyPoliciesAsync,
      listKeyPoliciesRequest)

  def listKeysAsync(
      listKeysRequest: ListKeysRequest
  ): Future[ListKeysResult] =
    wrapAsyncMethod[ListKeysRequest, ListKeysResult](client.listKeysAsync,
                                                     listKeysRequest)

  def listResourceTagsAsync(
      listResourceTagsRequest: ListResourceTagsRequest
  ): Future[ListResourceTagsResult] =
    wrapAsyncMethod[ListResourceTagsRequest, ListResourceTagsResult](
      client.listResourceTagsAsync,
      listResourceTagsRequest)

  def listRetirableGrantsAsync(
      listRetirableGrantsRequest: ListRetirableGrantsRequest
  ): Future[ListRetirableGrantsResult] =
    wrapAsyncMethod[ListRetirableGrantsRequest, ListRetirableGrantsResult](
      client.listRetirableGrantsAsync,
      listRetirableGrantsRequest)

  def putKeyPolicyAsync(
      putKeyPolicyRequest: PutKeyPolicyRequest
  ): Future[PutKeyPolicyResult] =
    wrapAsyncMethod[PutKeyPolicyRequest, PutKeyPolicyResult](
      client.putKeyPolicyAsync,
      putKeyPolicyRequest)

  def reEncryptAsync(
      reEncryptRequest: ReEncryptRequest
  ): Future[ReEncryptResult] =
    wrapAsyncMethod[ReEncryptRequest, ReEncryptResult](client.reEncryptAsync,
                                                       reEncryptRequest)

  def retireGrantAsync(
      retireGrantRequest: RetireGrantRequest
  ): Future[RetireGrantResult] =
    wrapAsyncMethod[RetireGrantRequest, RetireGrantResult](
      client.retireGrantAsync,
      retireGrantRequest)

  def revokeGrantAsync(
      revokeGrantRequest: RevokeGrantRequest
  ): Future[RevokeGrantResult] =
    wrapAsyncMethod[RevokeGrantRequest, RevokeGrantResult](
      client.revokeGrantAsync,
      revokeGrantRequest)

  def scheduleKeyDeletionAsync(
      scheduleKeyDeletionRequest: ScheduleKeyDeletionRequest
  ): Future[ScheduleKeyDeletionResult] =
    wrapAsyncMethod[ScheduleKeyDeletionRequest, ScheduleKeyDeletionResult](
      client.scheduleKeyDeletionAsync,
      scheduleKeyDeletionRequest)

  def tagResourceAsync(
      tagResourceRequest: TagResourceRequest
  ): Future[TagResourceResult] =
    wrapAsyncMethod[TagResourceRequest, TagResourceResult](
      client.tagResourceAsync,
      tagResourceRequest)

  def untagResourceAsync(
      untagResourceRequest: UntagResourceRequest
  ): Future[UntagResourceResult] =
    wrapAsyncMethod[UntagResourceRequest, UntagResourceResult](
      client.untagResourceAsync,
      untagResourceRequest)

  def updateAliasAsync(
      updateAliasRequest: UpdateAliasRequest
  ): Future[UpdateAliasResult] =
    wrapAsyncMethod[UpdateAliasRequest, UpdateAliasResult](
      client.updateAliasAsync,
      updateAliasRequest)

  def updateKeyDescriptionAsync(
      updateKeyDescriptionRequest: UpdateKeyDescriptionRequest
  ): Future[UpdateKeyDescriptionResult] =
    wrapAsyncMethod[UpdateKeyDescriptionRequest, UpdateKeyDescriptionResult](
      client.updateKeyDescriptionAsync,
      updateKeyDescriptionRequest)

}
