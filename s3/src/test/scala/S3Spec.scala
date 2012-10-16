package aws.s3

import scala.concurrent.Future
import play.api.libs.ws._
import play.api.libs.ws.WS._

import aws.core._
import aws.s3.models._
import aws.s3.S3.Parameters.Permisions._
import org.specs2.mutable._

import scala.concurrent._
import scala.concurrent.util._
import java.util.concurrent.TimeUnit._

import scala.concurrent.ExecutionContext.Implicits.global

object TestUtils extends Specification { // Evil hack to access Failure
  implicit val region = S3Region.EU_WEST_1

  def checkResult[M <: Metadata, T](r: Result[M, T]) = r match {
    case Errors(errors) => failure(errors.toString)
    case Result(_, _) => success
  }

  def waitFor[T](f: Future[T]) = Await.result(f, Duration(30, SECONDS))

  def del(name: String) = {
    val delete = waitFor(Bucket.delete(name))
    checkResult(delete)
  }
}

import TestUtils._

object BucketSpec extends Specification {

  "S3 Bucket API" should {

    "Create and delete a bucket" in {
      val bucketName = AWS.key + "testBucketCreate"
      val create = waitFor(Bucket.create(bucketName))
      checkResult(create)
      del(bucketName)
    }

    "Create a private bucket using canned ACL" in {
      import aws.s3.S3.Parameters.Permisions.ACLs._
      val bucketName = AWS.key + "testBucketAcl"
      val res = waitFor(Bucket.create(bucketName, Some(PRIVATE)))
      checkResult(res)
      del(bucketName)
    }

    "Create a private bucket with explicit permisions" in {
      import Grantees._
      val bucketName = AWS.key + "testBucketPerms"
      val perms =
        GRANT_READ(Email("erwan.loisant@pellucid.com"), Email("dustin.whitney@pellucid.com")) ::
        GRANT_WRITE(Email("erwan.loisant@pellucid.com")) ::
        GRANT_READ_ACP(Email("erwan.loisant@pellucid.com")) :: Nil

      val res = waitFor(Bucket.create(bucketName, permissions = perms))
      checkResult(res)
      del(bucketName)
    }

    "List buckets" in {
      val res = waitFor(Bucket.list())
      checkResult(res)
    }
  }
}

object LoggingSpec extends Specification {
  "S3 Bucket Logging API" should {

    "Enable Logging" in {
      import Grantees._
      val ps =
        GRANT_WRITE(Uri("http://acs.amazonaws.com/groups/s3/LogDelivery")) ::
        GRANT_READ_ACP(Uri("http://acs.amazonaws.com/groups/s3/LogDelivery")) :: Nil

      val target = AWS.key + "testBucketLoggingTarget"
      val t = waitFor(Bucket.create(target, permissions = ps))

      val logged = AWS.key + "testBucketLogging"
      waitFor(Bucket.create(logged))

      val res = waitFor(Logging.enable(logged, target))

      del(logged)
      del(target)

      checkResult(res)
    }

    "Show Logging Statuses" in {
      val bucketName = AWS.key + "testBucketLoggingStatuses"
      waitFor(Bucket.create(bucketName))
      val res = waitFor(Logging.get(bucketName))
      checkResult(res)
      del(bucketName)
    }

  }
}

object TagSpec extends Specification {
  "S3 Bucket Tagging API" should {
    "create tags" in {
      val tagged = AWS.key + "testBucketLoggingTagged"
      val c = waitFor(Bucket.create(tagged))
      val res = waitFor(Tag.create(tagged, Tag("Project", "Project One"), Tag("User", "jsmith")))
      del(tagged)
      checkResult(res)
    }

    "list tags" in {
      val tagged = AWS.key + "testBucketLoggingTaggedList"
      val c = waitFor(Bucket.create(tagged))
      val tags = Seq(Tag("Project", "Project One"), Tag("User", "jsmith"))
      waitFor(Tag.create(tagged, tags: _*))

      val res = waitFor(Tag.get(tagged))

      del(tagged)

      checkResult(res)
      res.body must haveSize(2)
      res.body must containAllOf(tags)
    }

    "delete tags" in {
      val tagged = AWS.key + "testBucketLoggingTaggedDelete"
      val c = waitFor(Bucket.create(tagged))
      val tags = Seq(Tag("Project", "Project One"), Tag("User", "jsmith"))
      waitFor(Tag.create(tagged, tags: _*))
      val res = waitFor(Tag.delete(tagged))
      // get returns "AWSError(NoSuchTagSet,The TagSet does not exist)"
      //val res = Await.result(Tag.get(tagged), Duration(30, SECONDS))
      del(tagged)
      checkResult(res)
    }
  }
}

object CORSSpec extends Specification {

  import S3.HTTPMethods._

  "S3 Bucket CORS API" should {
    "create cors" in {
      val cors = AWS.key + "testBucketCors"
      val cr = waitFor(Bucket.create(cors))

      val rules = Seq(
        CORSRule(
          origins = Seq("http://*.zenexity.com"),
          methods = PUT :: POST :: GET :: Nil))

      val res = waitFor(CORSRule.create(cors, rules: _*))
      //del(cors)
      checkResult(res)
    }
  }
}