/*
 * Copyright 2012 Pellucid and Zenexity
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

package aws.sns

import play.api.libs.json._
import play.api.libs.ws.Response
import aws.core._
import aws.core.parsers._

object SNSParsers {
  import scala.xml.Node
  import language.postfixOps

  implicit def snsMetaParser = Parser[SNSMeta] { r =>
    Success(SNSMeta(r.xml \\ "RequestId" text))
  }

  implicit def listTopicsResultParser = Parser[ListTopics] { r: Response =>
    Success(ListTopics(
      (r.xml \\ "TopicArn").map(_.text),
      (r.xml \\ "NextToken").headOption.map(_.text)))
  }

  def createTopicsParser = Parser[String] { r: Response =>
    Success((r.xml \\ "TopicArn").text)
  }

  def createTopicsResultParser = safeResultParser(createTopicsParser)

  def subscribeParser = Parser[String] { r: Response =>
    Success((r.xml \\ "SubscriptionArn").text)
  }

  def subscribeResultParser = safeResultParser(subscribeParser)

  def publishParser = Parser[String] { r: Response =>
    Success((r.xml \\ "MessageId").text)
  }

  def publishResultParser = safeResultParser(publishParser)

  implicit def topicAttributesResultParser = Parser[TopicAttributes] { r: Response =>
    val entries = parseAttributes(r.xml \\ "Attributes" head)
    Success(TopicAttributes(
      entries("TopicArn"),
      entries("Owner"),
      entries("DisplayName"),
      entries("SubscriptionsPending").toInt,
      entries("SubscriptionsConfirmed").toInt,
      entries("SubscriptionsDeleted").toInt,
      entries.get("Policy").map(Json.parse(_)),
      entries.get("DeliveryPolicy").map(Json.parse(_)),
      entries.get("EffectiveDeliveryPolicy").map(Json.parse(_))))
  }

  implicit def subscriptionAttributesResultParser = Parser[SubscriptionAttributes] { r: Response =>
    val entries = parseAttributes(r.xml \\ "Attributes" head)
    Success(SubscriptionAttributes(
      entries("SubscriptionArn"),
      entries("TopicArn"),
      entries("Owner"),
      entries.get("ConfirmationWasAuthenticated").map(_.toLowerCase == "true").getOrElse(false),
      entries.get("DeliveryPolicy").map(Json.parse(_)),
      entries.get("EffectiveDeliveryPolicy").map(Json.parse(_))))
  }

  implicit def subscriptionListResultParser = Parser[SubscriptionList] { r: Response =>
    Success(
      SubscriptionList(
        (r.xml \\ "Subscriptions").map(parseSubscription(_)).flatten,
        (r.xml \\ "NextToken").headOption.map(_.text)))
  }

  implicit def safeResultParser[T](implicit p: Parser[T]): Parser[Result[SNSMeta, T]] =
    Parser.xmlErrorParser[SNSMeta].or(Parser.resultParser(snsMetaParser, p))

  // Transform a set of <entry><key>xxx</key><value>yyy</value></entry> into a Map
  private def parseAttributes(node: Node): Map[String, String] = {
    (node \ "entry").map { n =>
      ((n \ "key").text) -> (n \ "value").text
    }.toMap
  }

  private def parseSubscription(node: Node): Option[Subscription] = for (
    topicArn <- (node \\ "TopicArn").headOption.map(_.text);
    subscriptionArn <- (node \\ "SubscriptionArn").headOption.map(_.text);
    owner <- (node \\ "Owner").headOption.map(_.text);
    endpoint <- (node \\ "Endpoint").headOption.map(_.text);
    protocol <- (node \\ "Protocol").headOption.map(_.text)
  ) yield Subscription(topicArn, subscriptionArn, owner, Endpoint(endpoint, protocol))

}