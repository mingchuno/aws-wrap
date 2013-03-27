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

package aws.sqs

import scala.annotation.implicitNotFound

import aws.core.AWSRegion

@implicitNotFound("You need to import a region to specify which datacenter you want to use.")
trait SQSRegion extends AWSRegion

object SQSRegion {

  import AWSRegion._

  private val NAME = "sqs"

  /**
   * US East (Northern Virginia)
   */
  val US_EAST_1 = new AWSRegion(US_EAST_1_NAME, US_EAST_1_DOMAIN, NAME) with SQSRegion

  /**
   * US West (Northern California)
   */
  val US_WEST_1 = new AWSRegion(US_WEST_1_NAME, US_WEST_1_DOMAIN, NAME) with SQSRegion

  /**
   * US West (Oregon)
   */
  val US_WEST_2 = new AWSRegion(US_WEST_2_NAME, US_WEST_2_DOMAIN, NAME) with SQSRegion

  /**
   * EU (Ireland)
   */
  val EU_WEST_1 = new AWSRegion(EU_WEST_1_NAME, EU_WEST_1_DOMAIN, NAME) with SQSRegion

  /**
   * Asia Pacific (Singapore)
   */
  val ASIA_SOUTHEAST_1 = new AWSRegion(ASIA_SOUTHEAST_1_NAME, ASIA_SOUTHEAST_1_DOMAIN, NAME) with SQSRegion

  /**
   * Asia Pacific (Tokyo)
   */
  val ASIA_NORTHEAST_1 = new AWSRegion(ASIA_NORTHEAST_1_NAME, ASIA_NORTHEAST_1_DOMAIN, NAME) with SQSRegion

  /**
   * South America (Sao Paulo)
   */
  val SA_EAST_1 = new AWSRegion(SA_EAST_1_NAME, SA_EAST_1_DOMAIN, NAME) with SQSRegion

  /**
   * Default to US_EAST_1
   */
  implicit val DEFAULT = US_EAST_1
}