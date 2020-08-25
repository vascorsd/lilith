package lilith.protocol

import caliban.client.CalibanClientError.DecodingError
import caliban.client.FieldBuilder._
import caliban.client.SelectionBuilder._
import caliban.client._
import caliban.client.Operations._
import caliban.client.Value._

object Schema {

  type Json = io.circe.Json
  type CountryCode = String

  type FuzzyDateInt = String

  sealed trait ActivitySort extends scala.Product with scala.Serializable
  object ActivitySort {
    case object ID extends ActivitySort
    case object ID_DESC extends ActivitySort

    implicit val decoder: ScalarDecoder[ActivitySort] = {
      case StringValue("ID")      => Right(ActivitySort.ID)
      case StringValue("ID_DESC") => Right(ActivitySort.ID_DESC)
      case other =>
        Left(DecodingError(s"Can't build ActivitySort from input $other"))
    }
    implicit val encoder: ArgEncoder[ActivitySort] =
      new ArgEncoder[ActivitySort] {
        override def encode(value: ActivitySort): Value = value match {
          case ActivitySort.ID      => EnumValue("ID")
          case ActivitySort.ID_DESC => EnumValue("ID_DESC")
        }
        override def typeName: String = "ActivitySort"
      }
  }

  sealed trait ActivityType extends scala.Product with scala.Serializable
  object ActivityType {
    case object ANIME_LIST extends ActivityType
    case object MANGA_LIST extends ActivityType
    case object MEDIA_LIST extends ActivityType
    case object MESSAGE extends ActivityType
    case object TEXT extends ActivityType

    implicit val decoder: ScalarDecoder[ActivityType] = {
      case StringValue("ANIME_LIST") => Right(ActivityType.ANIME_LIST)
      case StringValue("MANGA_LIST") => Right(ActivityType.MANGA_LIST)
      case StringValue("MEDIA_LIST") => Right(ActivityType.MEDIA_LIST)
      case StringValue("MESSAGE")    => Right(ActivityType.MESSAGE)
      case StringValue("TEXT")       => Right(ActivityType.TEXT)
      case other =>
        Left(DecodingError(s"Can't build ActivityType from input $other"))
    }
    implicit val encoder: ArgEncoder[ActivityType] =
      new ArgEncoder[ActivityType] {
        override def encode(value: ActivityType): Value = value match {
          case ActivityType.ANIME_LIST => EnumValue("ANIME_LIST")
          case ActivityType.MANGA_LIST => EnumValue("MANGA_LIST")
          case ActivityType.MEDIA_LIST => EnumValue("MEDIA_LIST")
          case ActivityType.MESSAGE    => EnumValue("MESSAGE")
          case ActivityType.TEXT       => EnumValue("TEXT")
        }
        override def typeName: String = "ActivityType"
      }
  }

  sealed trait AiringSort extends scala.Product with scala.Serializable
  object AiringSort {
    case object EPISODE extends AiringSort
    case object EPISODE_DESC extends AiringSort
    case object ID extends AiringSort
    case object ID_DESC extends AiringSort
    case object MEDIA_ID extends AiringSort
    case object MEDIA_ID_DESC extends AiringSort
    case object TIME extends AiringSort
    case object TIME_DESC extends AiringSort

    implicit val decoder: ScalarDecoder[AiringSort] = {
      case StringValue("EPISODE")       => Right(AiringSort.EPISODE)
      case StringValue("EPISODE_DESC")  => Right(AiringSort.EPISODE_DESC)
      case StringValue("ID")            => Right(AiringSort.ID)
      case StringValue("ID_DESC")       => Right(AiringSort.ID_DESC)
      case StringValue("MEDIA_ID")      => Right(AiringSort.MEDIA_ID)
      case StringValue("MEDIA_ID_DESC") => Right(AiringSort.MEDIA_ID_DESC)
      case StringValue("TIME")          => Right(AiringSort.TIME)
      case StringValue("TIME_DESC")     => Right(AiringSort.TIME_DESC)
      case other =>
        Left(DecodingError(s"Can't build AiringSort from input $other"))
    }
    implicit val encoder: ArgEncoder[AiringSort] = new ArgEncoder[AiringSort] {
      override def encode(value: AiringSort): Value = value match {
        case AiringSort.EPISODE       => EnumValue("EPISODE")
        case AiringSort.EPISODE_DESC  => EnumValue("EPISODE_DESC")
        case AiringSort.ID            => EnumValue("ID")
        case AiringSort.ID_DESC       => EnumValue("ID_DESC")
        case AiringSort.MEDIA_ID      => EnumValue("MEDIA_ID")
        case AiringSort.MEDIA_ID_DESC => EnumValue("MEDIA_ID_DESC")
        case AiringSort.TIME          => EnumValue("TIME")
        case AiringSort.TIME_DESC     => EnumValue("TIME_DESC")
      }
      override def typeName: String = "AiringSort"
    }
  }

  sealed trait CharacterRole extends scala.Product with scala.Serializable
  object CharacterRole {
    case object BACKGROUND extends CharacterRole
    case object MAIN extends CharacterRole
    case object SUPPORTING extends CharacterRole

    implicit val decoder: ScalarDecoder[CharacterRole] = {
      case StringValue("BACKGROUND") => Right(CharacterRole.BACKGROUND)
      case StringValue("MAIN")       => Right(CharacterRole.MAIN)
      case StringValue("SUPPORTING") => Right(CharacterRole.SUPPORTING)
      case other =>
        Left(DecodingError(s"Can't build CharacterRole from input $other"))
    }
    implicit val encoder: ArgEncoder[CharacterRole] =
      new ArgEncoder[CharacterRole] {
        override def encode(value: CharacterRole): Value = value match {
          case CharacterRole.BACKGROUND => EnumValue("BACKGROUND")
          case CharacterRole.MAIN       => EnumValue("MAIN")
          case CharacterRole.SUPPORTING => EnumValue("SUPPORTING")
        }
        override def typeName: String = "CharacterRole"
      }
  }

  sealed trait CharacterSort extends scala.Product with scala.Serializable
  object CharacterSort {
    case object FAVOURITES extends CharacterSort
    case object FAVOURITES_DESC extends CharacterSort
    case object ID extends CharacterSort
    case object ID_DESC extends CharacterSort
    case object ROLE extends CharacterSort
    case object ROLE_DESC extends CharacterSort
    case object SEARCH_MATCH extends CharacterSort

    implicit val decoder: ScalarDecoder[CharacterSort] = {
      case StringValue("FAVOURITES") => Right(CharacterSort.FAVOURITES)
      case StringValue("FAVOURITES_DESC") =>
        Right(CharacterSort.FAVOURITES_DESC)
      case StringValue("ID")           => Right(CharacterSort.ID)
      case StringValue("ID_DESC")      => Right(CharacterSort.ID_DESC)
      case StringValue("ROLE")         => Right(CharacterSort.ROLE)
      case StringValue("ROLE_DESC")    => Right(CharacterSort.ROLE_DESC)
      case StringValue("SEARCH_MATCH") => Right(CharacterSort.SEARCH_MATCH)
      case other =>
        Left(DecodingError(s"Can't build CharacterSort from input $other"))
    }
    implicit val encoder: ArgEncoder[CharacterSort] =
      new ArgEncoder[CharacterSort] {
        override def encode(value: CharacterSort): Value = value match {
          case CharacterSort.FAVOURITES      => EnumValue("FAVOURITES")
          case CharacterSort.FAVOURITES_DESC => EnumValue("FAVOURITES_DESC")
          case CharacterSort.ID              => EnumValue("ID")
          case CharacterSort.ID_DESC         => EnumValue("ID_DESC")
          case CharacterSort.ROLE            => EnumValue("ROLE")
          case CharacterSort.ROLE_DESC       => EnumValue("ROLE_DESC")
          case CharacterSort.SEARCH_MATCH    => EnumValue("SEARCH_MATCH")
        }
        override def typeName: String = "CharacterSort"
      }
  }

  sealed trait LikeableType extends scala.Product with scala.Serializable
  object LikeableType {
    case object ACTIVITY extends LikeableType
    case object ACTIVITY_REPLY extends LikeableType
    case object THREAD extends LikeableType
    case object THREAD_COMMENT extends LikeableType

    implicit val decoder: ScalarDecoder[LikeableType] = {
      case StringValue("ACTIVITY")       => Right(LikeableType.ACTIVITY)
      case StringValue("ACTIVITY_REPLY") => Right(LikeableType.ACTIVITY_REPLY)
      case StringValue("THREAD")         => Right(LikeableType.THREAD)
      case StringValue("THREAD_COMMENT") => Right(LikeableType.THREAD_COMMENT)
      case other =>
        Left(DecodingError(s"Can't build LikeableType from input $other"))
    }
    implicit val encoder: ArgEncoder[LikeableType] =
      new ArgEncoder[LikeableType] {
        override def encode(value: LikeableType): Value = value match {
          case LikeableType.ACTIVITY       => EnumValue("ACTIVITY")
          case LikeableType.ACTIVITY_REPLY => EnumValue("ACTIVITY_REPLY")
          case LikeableType.THREAD         => EnumValue("THREAD")
          case LikeableType.THREAD_COMMENT => EnumValue("THREAD_COMMENT")
        }
        override def typeName: String = "LikeableType"
      }
  }

  sealed trait MediaFormat extends scala.Product with scala.Serializable
  object MediaFormat {
    case object MANGA extends MediaFormat
    case object MOVIE extends MediaFormat
    case object MUSIC extends MediaFormat
    case object NOVEL extends MediaFormat
    case object ONA extends MediaFormat
    case object ONE_SHOT extends MediaFormat
    case object OVA extends MediaFormat
    case object SPECIAL extends MediaFormat
    case object TV extends MediaFormat
    case object TV_SHORT extends MediaFormat

    implicit val decoder: ScalarDecoder[MediaFormat] = {
      case StringValue("MANGA")    => Right(MediaFormat.MANGA)
      case StringValue("MOVIE")    => Right(MediaFormat.MOVIE)
      case StringValue("MUSIC")    => Right(MediaFormat.MUSIC)
      case StringValue("NOVEL")    => Right(MediaFormat.NOVEL)
      case StringValue("ONA")      => Right(MediaFormat.ONA)
      case StringValue("ONE_SHOT") => Right(MediaFormat.ONE_SHOT)
      case StringValue("OVA")      => Right(MediaFormat.OVA)
      case StringValue("SPECIAL")  => Right(MediaFormat.SPECIAL)
      case StringValue("TV")       => Right(MediaFormat.TV)
      case StringValue("TV_SHORT") => Right(MediaFormat.TV_SHORT)
      case other =>
        Left(DecodingError(s"Can't build MediaFormat from input $other"))
    }
    implicit val encoder: ArgEncoder[MediaFormat] =
      new ArgEncoder[MediaFormat] {
        override def encode(value: MediaFormat): Value = value match {
          case MediaFormat.MANGA    => EnumValue("MANGA")
          case MediaFormat.MOVIE    => EnumValue("MOVIE")
          case MediaFormat.MUSIC    => EnumValue("MUSIC")
          case MediaFormat.NOVEL    => EnumValue("NOVEL")
          case MediaFormat.ONA      => EnumValue("ONA")
          case MediaFormat.ONE_SHOT => EnumValue("ONE_SHOT")
          case MediaFormat.OVA      => EnumValue("OVA")
          case MediaFormat.SPECIAL  => EnumValue("SPECIAL")
          case MediaFormat.TV       => EnumValue("TV")
          case MediaFormat.TV_SHORT => EnumValue("TV_SHORT")
        }
        override def typeName: String = "MediaFormat"
      }
  }

  sealed trait MediaListSort extends scala.Product with scala.Serializable
  object MediaListSort {
    case object ADDED_TIME extends MediaListSort
    case object ADDED_TIME_DESC extends MediaListSort
    case object FINISHED_ON extends MediaListSort
    case object FINISHED_ON_DESC extends MediaListSort
    case object MEDIA_ID extends MediaListSort
    case object MEDIA_ID_DESC extends MediaListSort
    case object MEDIA_POPULARITY extends MediaListSort
    case object MEDIA_POPULARITY_DESC extends MediaListSort
    case object MEDIA_TITLE_ENGLISH extends MediaListSort
    case object MEDIA_TITLE_ENGLISH_DESC extends MediaListSort
    case object MEDIA_TITLE_NATIVE extends MediaListSort
    case object MEDIA_TITLE_NATIVE_DESC extends MediaListSort
    case object MEDIA_TITLE_ROMAJI extends MediaListSort
    case object MEDIA_TITLE_ROMAJI_DESC extends MediaListSort
    case object PRIORITY extends MediaListSort
    case object PRIORITY_DESC extends MediaListSort
    case object PROGRESS extends MediaListSort
    case object PROGRESS_DESC extends MediaListSort
    case object PROGRESS_VOLUMES extends MediaListSort
    case object PROGRESS_VOLUMES_DESC extends MediaListSort
    case object REPEAT extends MediaListSort
    case object REPEAT_DESC extends MediaListSort
    case object SCORE extends MediaListSort
    case object SCORE_DESC extends MediaListSort
    case object STARTED_ON extends MediaListSort
    case object STARTED_ON_DESC extends MediaListSort
    case object STATUS extends MediaListSort
    case object STATUS_DESC extends MediaListSort
    case object UPDATED_TIME extends MediaListSort
    case object UPDATED_TIME_DESC extends MediaListSort

    implicit val decoder: ScalarDecoder[MediaListSort] = {
      case StringValue("ADDED_TIME") => Right(MediaListSort.ADDED_TIME)
      case StringValue("ADDED_TIME_DESC") =>
        Right(MediaListSort.ADDED_TIME_DESC)
      case StringValue("FINISHED_ON") => Right(MediaListSort.FINISHED_ON)
      case StringValue("FINISHED_ON_DESC") =>
        Right(MediaListSort.FINISHED_ON_DESC)
      case StringValue("MEDIA_ID")      => Right(MediaListSort.MEDIA_ID)
      case StringValue("MEDIA_ID_DESC") => Right(MediaListSort.MEDIA_ID_DESC)
      case StringValue("MEDIA_POPULARITY") =>
        Right(MediaListSort.MEDIA_POPULARITY)
      case StringValue("MEDIA_POPULARITY_DESC") =>
        Right(MediaListSort.MEDIA_POPULARITY_DESC)
      case StringValue("MEDIA_TITLE_ENGLISH") =>
        Right(MediaListSort.MEDIA_TITLE_ENGLISH)
      case StringValue("MEDIA_TITLE_ENGLISH_DESC") =>
        Right(MediaListSort.MEDIA_TITLE_ENGLISH_DESC)
      case StringValue("MEDIA_TITLE_NATIVE") =>
        Right(MediaListSort.MEDIA_TITLE_NATIVE)
      case StringValue("MEDIA_TITLE_NATIVE_DESC") =>
        Right(MediaListSort.MEDIA_TITLE_NATIVE_DESC)
      case StringValue("MEDIA_TITLE_ROMAJI") =>
        Right(MediaListSort.MEDIA_TITLE_ROMAJI)
      case StringValue("MEDIA_TITLE_ROMAJI_DESC") =>
        Right(MediaListSort.MEDIA_TITLE_ROMAJI_DESC)
      case StringValue("PRIORITY")      => Right(MediaListSort.PRIORITY)
      case StringValue("PRIORITY_DESC") => Right(MediaListSort.PRIORITY_DESC)
      case StringValue("PROGRESS")      => Right(MediaListSort.PROGRESS)
      case StringValue("PROGRESS_DESC") => Right(MediaListSort.PROGRESS_DESC)
      case StringValue("PROGRESS_VOLUMES") =>
        Right(MediaListSort.PROGRESS_VOLUMES)
      case StringValue("PROGRESS_VOLUMES_DESC") =>
        Right(MediaListSort.PROGRESS_VOLUMES_DESC)
      case StringValue("REPEAT")      => Right(MediaListSort.REPEAT)
      case StringValue("REPEAT_DESC") => Right(MediaListSort.REPEAT_DESC)
      case StringValue("SCORE")       => Right(MediaListSort.SCORE)
      case StringValue("SCORE_DESC")  => Right(MediaListSort.SCORE_DESC)
      case StringValue("STARTED_ON")  => Right(MediaListSort.STARTED_ON)
      case StringValue("STARTED_ON_DESC") =>
        Right(MediaListSort.STARTED_ON_DESC)
      case StringValue("STATUS")       => Right(MediaListSort.STATUS)
      case StringValue("STATUS_DESC")  => Right(MediaListSort.STATUS_DESC)
      case StringValue("UPDATED_TIME") => Right(MediaListSort.UPDATED_TIME)
      case StringValue("UPDATED_TIME_DESC") =>
        Right(MediaListSort.UPDATED_TIME_DESC)
      case other =>
        Left(DecodingError(s"Can't build MediaListSort from input $other"))
    }
    implicit val encoder: ArgEncoder[MediaListSort] =
      new ArgEncoder[MediaListSort] {
        override def encode(value: MediaListSort): Value = value match {
          case MediaListSort.ADDED_TIME       => EnumValue("ADDED_TIME")
          case MediaListSort.ADDED_TIME_DESC  => EnumValue("ADDED_TIME_DESC")
          case MediaListSort.FINISHED_ON      => EnumValue("FINISHED_ON")
          case MediaListSort.FINISHED_ON_DESC => EnumValue("FINISHED_ON_DESC")
          case MediaListSort.MEDIA_ID         => EnumValue("MEDIA_ID")
          case MediaListSort.MEDIA_ID_DESC    => EnumValue("MEDIA_ID_DESC")
          case MediaListSort.MEDIA_POPULARITY => EnumValue("MEDIA_POPULARITY")
          case MediaListSort.MEDIA_POPULARITY_DESC =>
            EnumValue("MEDIA_POPULARITY_DESC")
          case MediaListSort.MEDIA_TITLE_ENGLISH =>
            EnumValue("MEDIA_TITLE_ENGLISH")
          case MediaListSort.MEDIA_TITLE_ENGLISH_DESC =>
            EnumValue("MEDIA_TITLE_ENGLISH_DESC")
          case MediaListSort.MEDIA_TITLE_NATIVE =>
            EnumValue("MEDIA_TITLE_NATIVE")
          case MediaListSort.MEDIA_TITLE_NATIVE_DESC =>
            EnumValue("MEDIA_TITLE_NATIVE_DESC")
          case MediaListSort.MEDIA_TITLE_ROMAJI =>
            EnumValue("MEDIA_TITLE_ROMAJI")
          case MediaListSort.MEDIA_TITLE_ROMAJI_DESC =>
            EnumValue("MEDIA_TITLE_ROMAJI_DESC")
          case MediaListSort.PRIORITY         => EnumValue("PRIORITY")
          case MediaListSort.PRIORITY_DESC    => EnumValue("PRIORITY_DESC")
          case MediaListSort.PROGRESS         => EnumValue("PROGRESS")
          case MediaListSort.PROGRESS_DESC    => EnumValue("PROGRESS_DESC")
          case MediaListSort.PROGRESS_VOLUMES => EnumValue("PROGRESS_VOLUMES")
          case MediaListSort.PROGRESS_VOLUMES_DESC =>
            EnumValue("PROGRESS_VOLUMES_DESC")
          case MediaListSort.REPEAT            => EnumValue("REPEAT")
          case MediaListSort.REPEAT_DESC       => EnumValue("REPEAT_DESC")
          case MediaListSort.SCORE             => EnumValue("SCORE")
          case MediaListSort.SCORE_DESC        => EnumValue("SCORE_DESC")
          case MediaListSort.STARTED_ON        => EnumValue("STARTED_ON")
          case MediaListSort.STARTED_ON_DESC   => EnumValue("STARTED_ON_DESC")
          case MediaListSort.STATUS            => EnumValue("STATUS")
          case MediaListSort.STATUS_DESC       => EnumValue("STATUS_DESC")
          case MediaListSort.UPDATED_TIME      => EnumValue("UPDATED_TIME")
          case MediaListSort.UPDATED_TIME_DESC => EnumValue("UPDATED_TIME_DESC")
        }
        override def typeName: String = "MediaListSort"
      }
  }

  sealed trait MediaListStatus extends scala.Product with scala.Serializable
  object MediaListStatus {
    case object COMPLETED extends MediaListStatus
    case object CURRENT extends MediaListStatus
    case object DROPPED extends MediaListStatus
    case object PAUSED extends MediaListStatus
    case object PLANNING extends MediaListStatus
    case object REPEATING extends MediaListStatus

    implicit val decoder: ScalarDecoder[MediaListStatus] = {
      case StringValue("COMPLETED") => Right(MediaListStatus.COMPLETED)
      case StringValue("CURRENT")   => Right(MediaListStatus.CURRENT)
      case StringValue("DROPPED")   => Right(MediaListStatus.DROPPED)
      case StringValue("PAUSED")    => Right(MediaListStatus.PAUSED)
      case StringValue("PLANNING")  => Right(MediaListStatus.PLANNING)
      case StringValue("REPEATING") => Right(MediaListStatus.REPEATING)
      case other =>
        Left(DecodingError(s"Can't build MediaListStatus from input $other"))
    }
    implicit val encoder: ArgEncoder[MediaListStatus] =
      new ArgEncoder[MediaListStatus] {
        override def encode(value: MediaListStatus): Value = value match {
          case MediaListStatus.COMPLETED => EnumValue("COMPLETED")
          case MediaListStatus.CURRENT   => EnumValue("CURRENT")
          case MediaListStatus.DROPPED   => EnumValue("DROPPED")
          case MediaListStatus.PAUSED    => EnumValue("PAUSED")
          case MediaListStatus.PLANNING  => EnumValue("PLANNING")
          case MediaListStatus.REPEATING => EnumValue("REPEATING")
        }
        override def typeName: String = "MediaListStatus"
      }
  }

  sealed trait MediaRankType extends scala.Product with scala.Serializable
  object MediaRankType {
    case object POPULAR extends MediaRankType
    case object RATED extends MediaRankType

    implicit val decoder: ScalarDecoder[MediaRankType] = {
      case StringValue("POPULAR") => Right(MediaRankType.POPULAR)
      case StringValue("RATED")   => Right(MediaRankType.RATED)
      case other =>
        Left(DecodingError(s"Can't build MediaRankType from input $other"))
    }
    implicit val encoder: ArgEncoder[MediaRankType] =
      new ArgEncoder[MediaRankType] {
        override def encode(value: MediaRankType): Value = value match {
          case MediaRankType.POPULAR => EnumValue("POPULAR")
          case MediaRankType.RATED   => EnumValue("RATED")
        }
        override def typeName: String = "MediaRankType"
      }
  }

  sealed trait MediaRelation extends scala.Product with scala.Serializable
  object MediaRelation {
    case object ADAPTATION extends MediaRelation
    case object ALTERNATIVE extends MediaRelation
    case object CHARACTER extends MediaRelation
    case object COMPILATION extends MediaRelation
    case object CONTAINS extends MediaRelation
    case object OTHER extends MediaRelation
    case object PARENT extends MediaRelation
    case object PREQUEL extends MediaRelation
    case object SEQUEL extends MediaRelation
    case object SIDE_STORY extends MediaRelation
    case object SOURCE extends MediaRelation
    case object SPIN_OFF extends MediaRelation
    case object SUMMARY extends MediaRelation

    implicit val decoder: ScalarDecoder[MediaRelation] = {
      case StringValue("ADAPTATION")  => Right(MediaRelation.ADAPTATION)
      case StringValue("ALTERNATIVE") => Right(MediaRelation.ALTERNATIVE)
      case StringValue("CHARACTER")   => Right(MediaRelation.CHARACTER)
      case StringValue("COMPILATION") => Right(MediaRelation.COMPILATION)
      case StringValue("CONTAINS")    => Right(MediaRelation.CONTAINS)
      case StringValue("OTHER")       => Right(MediaRelation.OTHER)
      case StringValue("PARENT")      => Right(MediaRelation.PARENT)
      case StringValue("PREQUEL")     => Right(MediaRelation.PREQUEL)
      case StringValue("SEQUEL")      => Right(MediaRelation.SEQUEL)
      case StringValue("SIDE_STORY")  => Right(MediaRelation.SIDE_STORY)
      case StringValue("SOURCE")      => Right(MediaRelation.SOURCE)
      case StringValue("SPIN_OFF")    => Right(MediaRelation.SPIN_OFF)
      case StringValue("SUMMARY")     => Right(MediaRelation.SUMMARY)
      case other =>
        Left(DecodingError(s"Can't build MediaRelation from input $other"))
    }
    implicit val encoder: ArgEncoder[MediaRelation] =
      new ArgEncoder[MediaRelation] {
        override def encode(value: MediaRelation): Value = value match {
          case MediaRelation.ADAPTATION  => EnumValue("ADAPTATION")
          case MediaRelation.ALTERNATIVE => EnumValue("ALTERNATIVE")
          case MediaRelation.CHARACTER   => EnumValue("CHARACTER")
          case MediaRelation.COMPILATION => EnumValue("COMPILATION")
          case MediaRelation.CONTAINS    => EnumValue("CONTAINS")
          case MediaRelation.OTHER       => EnumValue("OTHER")
          case MediaRelation.PARENT      => EnumValue("PARENT")
          case MediaRelation.PREQUEL     => EnumValue("PREQUEL")
          case MediaRelation.SEQUEL      => EnumValue("SEQUEL")
          case MediaRelation.SIDE_STORY  => EnumValue("SIDE_STORY")
          case MediaRelation.SOURCE      => EnumValue("SOURCE")
          case MediaRelation.SPIN_OFF    => EnumValue("SPIN_OFF")
          case MediaRelation.SUMMARY     => EnumValue("SUMMARY")
        }
        override def typeName: String = "MediaRelation"
      }
  }

  sealed trait MediaSeason extends scala.Product with scala.Serializable
  object MediaSeason {
    case object FALL extends MediaSeason
    case object SPRING extends MediaSeason
    case object SUMMER extends MediaSeason
    case object WINTER extends MediaSeason

    implicit val decoder: ScalarDecoder[MediaSeason] = {
      case StringValue("FALL")   => Right(MediaSeason.FALL)
      case StringValue("SPRING") => Right(MediaSeason.SPRING)
      case StringValue("SUMMER") => Right(MediaSeason.SUMMER)
      case StringValue("WINTER") => Right(MediaSeason.WINTER)
      case other =>
        Left(DecodingError(s"Can't build MediaSeason from input $other"))
    }
    implicit val encoder: ArgEncoder[MediaSeason] =
      new ArgEncoder[MediaSeason] {
        override def encode(value: MediaSeason): Value = value match {
          case MediaSeason.FALL   => EnumValue("FALL")
          case MediaSeason.SPRING => EnumValue("SPRING")
          case MediaSeason.SUMMER => EnumValue("SUMMER")
          case MediaSeason.WINTER => EnumValue("WINTER")
        }
        override def typeName: String = "MediaSeason"
      }
  }

  sealed trait MediaSort extends scala.Product with scala.Serializable
  object MediaSort {
    case object CHAPTERS extends MediaSort
    case object CHAPTERS_DESC extends MediaSort
    case object DURATION extends MediaSort
    case object DURATION_DESC extends MediaSort
    case object END_DATE extends MediaSort
    case object END_DATE_DESC extends MediaSort
    case object EPISODES extends MediaSort
    case object EPISODES_DESC extends MediaSort
    case object FAVOURITES extends MediaSort
    case object FAVOURITES_DESC extends MediaSort
    case object FORMAT extends MediaSort
    case object FORMAT_DESC extends MediaSort
    case object ID extends MediaSort
    case object ID_DESC extends MediaSort
    case object POPULARITY extends MediaSort
    case object POPULARITY_DESC extends MediaSort
    case object SCORE extends MediaSort
    case object SCORE_DESC extends MediaSort
    case object SEARCH_MATCH extends MediaSort
    case object START_DATE extends MediaSort
    case object START_DATE_DESC extends MediaSort
    case object STATUS extends MediaSort
    case object STATUS_DESC extends MediaSort
    case object TITLE_ENGLISH extends MediaSort
    case object TITLE_ENGLISH_DESC extends MediaSort
    case object TITLE_NATIVE extends MediaSort
    case object TITLE_NATIVE_DESC extends MediaSort
    case object TITLE_ROMAJI extends MediaSort
    case object TITLE_ROMAJI_DESC extends MediaSort
    case object TRENDING extends MediaSort
    case object TRENDING_DESC extends MediaSort
    case object TYPE extends MediaSort
    case object TYPE_DESC extends MediaSort
    case object UPDATED_AT extends MediaSort
    case object UPDATED_AT_DESC extends MediaSort
    case object VOLUMES extends MediaSort
    case object VOLUMES_DESC extends MediaSort

    implicit val decoder: ScalarDecoder[MediaSort] = {
      case StringValue("CHAPTERS")        => Right(MediaSort.CHAPTERS)
      case StringValue("CHAPTERS_DESC")   => Right(MediaSort.CHAPTERS_DESC)
      case StringValue("DURATION")        => Right(MediaSort.DURATION)
      case StringValue("DURATION_DESC")   => Right(MediaSort.DURATION_DESC)
      case StringValue("END_DATE")        => Right(MediaSort.END_DATE)
      case StringValue("END_DATE_DESC")   => Right(MediaSort.END_DATE_DESC)
      case StringValue("EPISODES")        => Right(MediaSort.EPISODES)
      case StringValue("EPISODES_DESC")   => Right(MediaSort.EPISODES_DESC)
      case StringValue("FAVOURITES")      => Right(MediaSort.FAVOURITES)
      case StringValue("FAVOURITES_DESC") => Right(MediaSort.FAVOURITES_DESC)
      case StringValue("FORMAT")          => Right(MediaSort.FORMAT)
      case StringValue("FORMAT_DESC")     => Right(MediaSort.FORMAT_DESC)
      case StringValue("ID")              => Right(MediaSort.ID)
      case StringValue("ID_DESC")         => Right(MediaSort.ID_DESC)
      case StringValue("POPULARITY")      => Right(MediaSort.POPULARITY)
      case StringValue("POPULARITY_DESC") => Right(MediaSort.POPULARITY_DESC)
      case StringValue("SCORE")           => Right(MediaSort.SCORE)
      case StringValue("SCORE_DESC")      => Right(MediaSort.SCORE_DESC)
      case StringValue("SEARCH_MATCH")    => Right(MediaSort.SEARCH_MATCH)
      case StringValue("START_DATE")      => Right(MediaSort.START_DATE)
      case StringValue("START_DATE_DESC") => Right(MediaSort.START_DATE_DESC)
      case StringValue("STATUS")          => Right(MediaSort.STATUS)
      case StringValue("STATUS_DESC")     => Right(MediaSort.STATUS_DESC)
      case StringValue("TITLE_ENGLISH")   => Right(MediaSort.TITLE_ENGLISH)
      case StringValue("TITLE_ENGLISH_DESC") =>
        Right(MediaSort.TITLE_ENGLISH_DESC)
      case StringValue("TITLE_NATIVE") => Right(MediaSort.TITLE_NATIVE)
      case StringValue("TITLE_NATIVE_DESC") =>
        Right(MediaSort.TITLE_NATIVE_DESC)
      case StringValue("TITLE_ROMAJI") => Right(MediaSort.TITLE_ROMAJI)
      case StringValue("TITLE_ROMAJI_DESC") =>
        Right(MediaSort.TITLE_ROMAJI_DESC)
      case StringValue("TRENDING")        => Right(MediaSort.TRENDING)
      case StringValue("TRENDING_DESC")   => Right(MediaSort.TRENDING_DESC)
      case StringValue("TYPE")            => Right(MediaSort.TYPE)
      case StringValue("TYPE_DESC")       => Right(MediaSort.TYPE_DESC)
      case StringValue("UPDATED_AT")      => Right(MediaSort.UPDATED_AT)
      case StringValue("UPDATED_AT_DESC") => Right(MediaSort.UPDATED_AT_DESC)
      case StringValue("VOLUMES")         => Right(MediaSort.VOLUMES)
      case StringValue("VOLUMES_DESC")    => Right(MediaSort.VOLUMES_DESC)
      case other =>
        Left(DecodingError(s"Can't build MediaSort from input $other"))
    }
    implicit val encoder: ArgEncoder[MediaSort] = new ArgEncoder[MediaSort] {
      override def encode(value: MediaSort): Value = value match {
        case MediaSort.CHAPTERS           => EnumValue("CHAPTERS")
        case MediaSort.CHAPTERS_DESC      => EnumValue("CHAPTERS_DESC")
        case MediaSort.DURATION           => EnumValue("DURATION")
        case MediaSort.DURATION_DESC      => EnumValue("DURATION_DESC")
        case MediaSort.END_DATE           => EnumValue("END_DATE")
        case MediaSort.END_DATE_DESC      => EnumValue("END_DATE_DESC")
        case MediaSort.EPISODES           => EnumValue("EPISODES")
        case MediaSort.EPISODES_DESC      => EnumValue("EPISODES_DESC")
        case MediaSort.FAVOURITES         => EnumValue("FAVOURITES")
        case MediaSort.FAVOURITES_DESC    => EnumValue("FAVOURITES_DESC")
        case MediaSort.FORMAT             => EnumValue("FORMAT")
        case MediaSort.FORMAT_DESC        => EnumValue("FORMAT_DESC")
        case MediaSort.ID                 => EnumValue("ID")
        case MediaSort.ID_DESC            => EnumValue("ID_DESC")
        case MediaSort.POPULARITY         => EnumValue("POPULARITY")
        case MediaSort.POPULARITY_DESC    => EnumValue("POPULARITY_DESC")
        case MediaSort.SCORE              => EnumValue("SCORE")
        case MediaSort.SCORE_DESC         => EnumValue("SCORE_DESC")
        case MediaSort.SEARCH_MATCH       => EnumValue("SEARCH_MATCH")
        case MediaSort.START_DATE         => EnumValue("START_DATE")
        case MediaSort.START_DATE_DESC    => EnumValue("START_DATE_DESC")
        case MediaSort.STATUS             => EnumValue("STATUS")
        case MediaSort.STATUS_DESC        => EnumValue("STATUS_DESC")
        case MediaSort.TITLE_ENGLISH      => EnumValue("TITLE_ENGLISH")
        case MediaSort.TITLE_ENGLISH_DESC => EnumValue("TITLE_ENGLISH_DESC")
        case MediaSort.TITLE_NATIVE       => EnumValue("TITLE_NATIVE")
        case MediaSort.TITLE_NATIVE_DESC  => EnumValue("TITLE_NATIVE_DESC")
        case MediaSort.TITLE_ROMAJI       => EnumValue("TITLE_ROMAJI")
        case MediaSort.TITLE_ROMAJI_DESC  => EnumValue("TITLE_ROMAJI_DESC")
        case MediaSort.TRENDING           => EnumValue("TRENDING")
        case MediaSort.TRENDING_DESC      => EnumValue("TRENDING_DESC")
        case MediaSort.TYPE               => EnumValue("TYPE")
        case MediaSort.TYPE_DESC          => EnumValue("TYPE_DESC")
        case MediaSort.UPDATED_AT         => EnumValue("UPDATED_AT")
        case MediaSort.UPDATED_AT_DESC    => EnumValue("UPDATED_AT_DESC")
        case MediaSort.VOLUMES            => EnumValue("VOLUMES")
        case MediaSort.VOLUMES_DESC       => EnumValue("VOLUMES_DESC")
      }
      override def typeName: String = "MediaSort"
    }
  }

  sealed trait MediaSource extends scala.Product with scala.Serializable
  object MediaSource {
    case object ANIME extends MediaSource
    case object DOUJINSHI extends MediaSource
    case object LIGHT_NOVEL extends MediaSource
    case object MANGA extends MediaSource
    case object NOVEL extends MediaSource
    case object ORIGINAL extends MediaSource
    case object OTHER extends MediaSource
    case object VIDEO_GAME extends MediaSource
    case object VISUAL_NOVEL extends MediaSource

    implicit val decoder: ScalarDecoder[MediaSource] = {
      case StringValue("ANIME")        => Right(MediaSource.ANIME)
      case StringValue("DOUJINSHI")    => Right(MediaSource.DOUJINSHI)
      case StringValue("LIGHT_NOVEL")  => Right(MediaSource.LIGHT_NOVEL)
      case StringValue("MANGA")        => Right(MediaSource.MANGA)
      case StringValue("NOVEL")        => Right(MediaSource.NOVEL)
      case StringValue("ORIGINAL")     => Right(MediaSource.ORIGINAL)
      case StringValue("OTHER")        => Right(MediaSource.OTHER)
      case StringValue("VIDEO_GAME")   => Right(MediaSource.VIDEO_GAME)
      case StringValue("VISUAL_NOVEL") => Right(MediaSource.VISUAL_NOVEL)
      case other =>
        Left(DecodingError(s"Can't build MediaSource from input $other"))
    }
    implicit val encoder: ArgEncoder[MediaSource] =
      new ArgEncoder[MediaSource] {
        override def encode(value: MediaSource): Value = value match {
          case MediaSource.ANIME        => EnumValue("ANIME")
          case MediaSource.DOUJINSHI    => EnumValue("DOUJINSHI")
          case MediaSource.LIGHT_NOVEL  => EnumValue("LIGHT_NOVEL")
          case MediaSource.MANGA        => EnumValue("MANGA")
          case MediaSource.NOVEL        => EnumValue("NOVEL")
          case MediaSource.ORIGINAL     => EnumValue("ORIGINAL")
          case MediaSource.OTHER        => EnumValue("OTHER")
          case MediaSource.VIDEO_GAME   => EnumValue("VIDEO_GAME")
          case MediaSource.VISUAL_NOVEL => EnumValue("VISUAL_NOVEL")
        }
        override def typeName: String = "MediaSource"
      }
  }

  sealed trait MediaStatus extends scala.Product with scala.Serializable
  object MediaStatus {
    case object CANCELLED extends MediaStatus
    case object FINISHED extends MediaStatus
    case object NOT_YET_RELEASED extends MediaStatus
    case object RELEASING extends MediaStatus

    implicit val decoder: ScalarDecoder[MediaStatus] = {
      case StringValue("CANCELLED") => Right(MediaStatus.CANCELLED)
      case StringValue("FINISHED")  => Right(MediaStatus.FINISHED)
      case StringValue("NOT_YET_RELEASED") =>
        Right(MediaStatus.NOT_YET_RELEASED)
      case StringValue("RELEASING") => Right(MediaStatus.RELEASING)
      case other =>
        Left(DecodingError(s"Can't build MediaStatus from input $other"))
    }
    implicit val encoder: ArgEncoder[MediaStatus] =
      new ArgEncoder[MediaStatus] {
        override def encode(value: MediaStatus): Value = value match {
          case MediaStatus.CANCELLED        => EnumValue("CANCELLED")
          case MediaStatus.FINISHED         => EnumValue("FINISHED")
          case MediaStatus.NOT_YET_RELEASED => EnumValue("NOT_YET_RELEASED")
          case MediaStatus.RELEASING        => EnumValue("RELEASING")
        }
        override def typeName: String = "MediaStatus"
      }
  }

  sealed trait MediaTrendSort extends scala.Product with scala.Serializable
  object MediaTrendSort {
    case object DATE extends MediaTrendSort
    case object DATE_DESC extends MediaTrendSort
    case object EPISODE extends MediaTrendSort
    case object EPISODE_DESC extends MediaTrendSort
    case object ID extends MediaTrendSort
    case object ID_DESC extends MediaTrendSort
    case object MEDIA_ID extends MediaTrendSort
    case object MEDIA_ID_DESC extends MediaTrendSort
    case object POPULARITY extends MediaTrendSort
    case object POPULARITY_DESC extends MediaTrendSort
    case object SCORE extends MediaTrendSort
    case object SCORE_DESC extends MediaTrendSort
    case object TRENDING extends MediaTrendSort
    case object TRENDING_DESC extends MediaTrendSort

    implicit val decoder: ScalarDecoder[MediaTrendSort] = {
      case StringValue("DATE")          => Right(MediaTrendSort.DATE)
      case StringValue("DATE_DESC")     => Right(MediaTrendSort.DATE_DESC)
      case StringValue("EPISODE")       => Right(MediaTrendSort.EPISODE)
      case StringValue("EPISODE_DESC")  => Right(MediaTrendSort.EPISODE_DESC)
      case StringValue("ID")            => Right(MediaTrendSort.ID)
      case StringValue("ID_DESC")       => Right(MediaTrendSort.ID_DESC)
      case StringValue("MEDIA_ID")      => Right(MediaTrendSort.MEDIA_ID)
      case StringValue("MEDIA_ID_DESC") => Right(MediaTrendSort.MEDIA_ID_DESC)
      case StringValue("POPULARITY")    => Right(MediaTrendSort.POPULARITY)
      case StringValue("POPULARITY_DESC") =>
        Right(MediaTrendSort.POPULARITY_DESC)
      case StringValue("SCORE")         => Right(MediaTrendSort.SCORE)
      case StringValue("SCORE_DESC")    => Right(MediaTrendSort.SCORE_DESC)
      case StringValue("TRENDING")      => Right(MediaTrendSort.TRENDING)
      case StringValue("TRENDING_DESC") => Right(MediaTrendSort.TRENDING_DESC)
      case other =>
        Left(DecodingError(s"Can't build MediaTrendSort from input $other"))
    }
    implicit val encoder: ArgEncoder[MediaTrendSort] =
      new ArgEncoder[MediaTrendSort] {
        override def encode(value: MediaTrendSort): Value = value match {
          case MediaTrendSort.DATE            => EnumValue("DATE")
          case MediaTrendSort.DATE_DESC       => EnumValue("DATE_DESC")
          case MediaTrendSort.EPISODE         => EnumValue("EPISODE")
          case MediaTrendSort.EPISODE_DESC    => EnumValue("EPISODE_DESC")
          case MediaTrendSort.ID              => EnumValue("ID")
          case MediaTrendSort.ID_DESC         => EnumValue("ID_DESC")
          case MediaTrendSort.MEDIA_ID        => EnumValue("MEDIA_ID")
          case MediaTrendSort.MEDIA_ID_DESC   => EnumValue("MEDIA_ID_DESC")
          case MediaTrendSort.POPULARITY      => EnumValue("POPULARITY")
          case MediaTrendSort.POPULARITY_DESC => EnumValue("POPULARITY_DESC")
          case MediaTrendSort.SCORE           => EnumValue("SCORE")
          case MediaTrendSort.SCORE_DESC      => EnumValue("SCORE_DESC")
          case MediaTrendSort.TRENDING        => EnumValue("TRENDING")
          case MediaTrendSort.TRENDING_DESC   => EnumValue("TRENDING_DESC")
        }
        override def typeName: String = "MediaTrendSort"
      }
  }

  sealed trait MediaType extends scala.Product with scala.Serializable
  object MediaType {
    case object ANIME extends MediaType
    case object MANGA extends MediaType

    implicit val decoder: ScalarDecoder[MediaType] = {
      case StringValue("ANIME") => Right(MediaType.ANIME)
      case StringValue("MANGA") => Right(MediaType.MANGA)
      case other =>
        Left(DecodingError(s"Can't build MediaType from input $other"))
    }
    implicit val encoder: ArgEncoder[MediaType] = new ArgEncoder[MediaType] {
      override def encode(value: MediaType): Value = value match {
        case MediaType.ANIME => EnumValue("ANIME")
        case MediaType.MANGA => EnumValue("MANGA")
      }
      override def typeName: String = "MediaType"
    }
  }

  sealed trait ModActionType extends scala.Product with scala.Serializable
  object ModActionType {
    case object ANON extends ModActionType
    case object BAN extends ModActionType
    case object DELETE extends ModActionType
    case object EDIT extends ModActionType
    case object EXPIRE extends ModActionType
    case object NOTE extends ModActionType
    case object REPORT extends ModActionType
    case object RESET extends ModActionType

    implicit val decoder: ScalarDecoder[ModActionType] = {
      case StringValue("ANON")   => Right(ModActionType.ANON)
      case StringValue("BAN")    => Right(ModActionType.BAN)
      case StringValue("DELETE") => Right(ModActionType.DELETE)
      case StringValue("EDIT")   => Right(ModActionType.EDIT)
      case StringValue("EXPIRE") => Right(ModActionType.EXPIRE)
      case StringValue("NOTE")   => Right(ModActionType.NOTE)
      case StringValue("REPORT") => Right(ModActionType.REPORT)
      case StringValue("RESET")  => Right(ModActionType.RESET)
      case other =>
        Left(DecodingError(s"Can't build ModActionType from input $other"))
    }
    implicit val encoder: ArgEncoder[ModActionType] =
      new ArgEncoder[ModActionType] {
        override def encode(value: ModActionType): Value = value match {
          case ModActionType.ANON   => EnumValue("ANON")
          case ModActionType.BAN    => EnumValue("BAN")
          case ModActionType.DELETE => EnumValue("DELETE")
          case ModActionType.EDIT   => EnumValue("EDIT")
          case ModActionType.EXPIRE => EnumValue("EXPIRE")
          case ModActionType.NOTE   => EnumValue("NOTE")
          case ModActionType.REPORT => EnumValue("REPORT")
          case ModActionType.RESET  => EnumValue("RESET")
        }
        override def typeName: String = "ModActionType"
      }
  }

  sealed trait NotificationType extends scala.Product with scala.Serializable
  object NotificationType {
    case object ACTIVITY_LIKE extends NotificationType
    case object ACTIVITY_MENTION extends NotificationType
    case object ACTIVITY_MESSAGE extends NotificationType
    case object ACTIVITY_REPLY extends NotificationType
    case object ACTIVITY_REPLY_LIKE extends NotificationType
    case object ACTIVITY_REPLY_SUBSCRIBED extends NotificationType
    case object AIRING extends NotificationType
    case object FOLLOWING extends NotificationType
    case object RELATED_MEDIA_ADDITION extends NotificationType
    case object THREAD_COMMENT_LIKE extends NotificationType
    case object THREAD_COMMENT_MENTION extends NotificationType
    case object THREAD_COMMENT_REPLY extends NotificationType
    case object THREAD_LIKE extends NotificationType
    case object THREAD_SUBSCRIBED extends NotificationType

    implicit val decoder: ScalarDecoder[NotificationType] = {
      case StringValue("ACTIVITY_LIKE") => Right(NotificationType.ACTIVITY_LIKE)
      case StringValue("ACTIVITY_MENTION") =>
        Right(NotificationType.ACTIVITY_MENTION)
      case StringValue("ACTIVITY_MESSAGE") =>
        Right(NotificationType.ACTIVITY_MESSAGE)
      case StringValue("ACTIVITY_REPLY") =>
        Right(NotificationType.ACTIVITY_REPLY)
      case StringValue("ACTIVITY_REPLY_LIKE") =>
        Right(NotificationType.ACTIVITY_REPLY_LIKE)
      case StringValue("ACTIVITY_REPLY_SUBSCRIBED") =>
        Right(NotificationType.ACTIVITY_REPLY_SUBSCRIBED)
      case StringValue("AIRING")    => Right(NotificationType.AIRING)
      case StringValue("FOLLOWING") => Right(NotificationType.FOLLOWING)
      case StringValue("RELATED_MEDIA_ADDITION") =>
        Right(NotificationType.RELATED_MEDIA_ADDITION)
      case StringValue("THREAD_COMMENT_LIKE") =>
        Right(NotificationType.THREAD_COMMENT_LIKE)
      case StringValue("THREAD_COMMENT_MENTION") =>
        Right(NotificationType.THREAD_COMMENT_MENTION)
      case StringValue("THREAD_COMMENT_REPLY") =>
        Right(NotificationType.THREAD_COMMENT_REPLY)
      case StringValue("THREAD_LIKE") => Right(NotificationType.THREAD_LIKE)
      case StringValue("THREAD_SUBSCRIBED") =>
        Right(NotificationType.THREAD_SUBSCRIBED)
      case other =>
        Left(DecodingError(s"Can't build NotificationType from input $other"))
    }
    implicit val encoder: ArgEncoder[NotificationType] =
      new ArgEncoder[NotificationType] {
        override def encode(value: NotificationType): Value = value match {
          case NotificationType.ACTIVITY_LIKE => EnumValue("ACTIVITY_LIKE")
          case NotificationType.ACTIVITY_MENTION =>
            EnumValue("ACTIVITY_MENTION")
          case NotificationType.ACTIVITY_MESSAGE =>
            EnumValue("ACTIVITY_MESSAGE")
          case NotificationType.ACTIVITY_REPLY => EnumValue("ACTIVITY_REPLY")
          case NotificationType.ACTIVITY_REPLY_LIKE =>
            EnumValue("ACTIVITY_REPLY_LIKE")
          case NotificationType.ACTIVITY_REPLY_SUBSCRIBED =>
            EnumValue("ACTIVITY_REPLY_SUBSCRIBED")
          case NotificationType.AIRING    => EnumValue("AIRING")
          case NotificationType.FOLLOWING => EnumValue("FOLLOWING")
          case NotificationType.RELATED_MEDIA_ADDITION =>
            EnumValue("RELATED_MEDIA_ADDITION")
          case NotificationType.THREAD_COMMENT_LIKE =>
            EnumValue("THREAD_COMMENT_LIKE")
          case NotificationType.THREAD_COMMENT_MENTION =>
            EnumValue("THREAD_COMMENT_MENTION")
          case NotificationType.THREAD_COMMENT_REPLY =>
            EnumValue("THREAD_COMMENT_REPLY")
          case NotificationType.THREAD_LIKE => EnumValue("THREAD_LIKE")
          case NotificationType.THREAD_SUBSCRIBED =>
            EnumValue("THREAD_SUBSCRIBED")
        }
        override def typeName: String = "NotificationType"
      }
  }

  sealed trait RecommendationRating
      extends scala.Product
      with scala.Serializable
  object RecommendationRating {
    case object NO_RATING extends RecommendationRating
    case object RATE_DOWN extends RecommendationRating
    case object RATE_UP extends RecommendationRating

    implicit val decoder: ScalarDecoder[RecommendationRating] = {
      case StringValue("NO_RATING") => Right(RecommendationRating.NO_RATING)
      case StringValue("RATE_DOWN") => Right(RecommendationRating.RATE_DOWN)
      case StringValue("RATE_UP")   => Right(RecommendationRating.RATE_UP)
      case other =>
        Left(
          DecodingError(s"Can't build RecommendationRating from input $other")
        )
    }
    implicit val encoder: ArgEncoder[RecommendationRating] =
      new ArgEncoder[RecommendationRating] {
        override def encode(value: RecommendationRating): Value = value match {
          case RecommendationRating.NO_RATING => EnumValue("NO_RATING")
          case RecommendationRating.RATE_DOWN => EnumValue("RATE_DOWN")
          case RecommendationRating.RATE_UP   => EnumValue("RATE_UP")
        }
        override def typeName: String = "RecommendationRating"
      }
  }

  sealed trait RecommendationSort extends scala.Product with scala.Serializable
  object RecommendationSort {
    case object ID extends RecommendationSort
    case object ID_DESC extends RecommendationSort
    case object RATING extends RecommendationSort
    case object RATING_DESC extends RecommendationSort

    implicit val decoder: ScalarDecoder[RecommendationSort] = {
      case StringValue("ID")          => Right(RecommendationSort.ID)
      case StringValue("ID_DESC")     => Right(RecommendationSort.ID_DESC)
      case StringValue("RATING")      => Right(RecommendationSort.RATING)
      case StringValue("RATING_DESC") => Right(RecommendationSort.RATING_DESC)
      case other =>
        Left(DecodingError(s"Can't build RecommendationSort from input $other"))
    }
    implicit val encoder: ArgEncoder[RecommendationSort] =
      new ArgEncoder[RecommendationSort] {
        override def encode(value: RecommendationSort): Value = value match {
          case RecommendationSort.ID          => EnumValue("ID")
          case RecommendationSort.ID_DESC     => EnumValue("ID_DESC")
          case RecommendationSort.RATING      => EnumValue("RATING")
          case RecommendationSort.RATING_DESC => EnumValue("RATING_DESC")
        }
        override def typeName: String = "RecommendationSort"
      }
  }

  sealed trait ReviewRating extends scala.Product with scala.Serializable
  object ReviewRating {
    case object DOWN_VOTE extends ReviewRating
    case object NO_VOTE extends ReviewRating
    case object UP_VOTE extends ReviewRating

    implicit val decoder: ScalarDecoder[ReviewRating] = {
      case StringValue("DOWN_VOTE") => Right(ReviewRating.DOWN_VOTE)
      case StringValue("NO_VOTE")   => Right(ReviewRating.NO_VOTE)
      case StringValue("UP_VOTE")   => Right(ReviewRating.UP_VOTE)
      case other =>
        Left(DecodingError(s"Can't build ReviewRating from input $other"))
    }
    implicit val encoder: ArgEncoder[ReviewRating] =
      new ArgEncoder[ReviewRating] {
        override def encode(value: ReviewRating): Value = value match {
          case ReviewRating.DOWN_VOTE => EnumValue("DOWN_VOTE")
          case ReviewRating.NO_VOTE   => EnumValue("NO_VOTE")
          case ReviewRating.UP_VOTE   => EnumValue("UP_VOTE")
        }
        override def typeName: String = "ReviewRating"
      }
  }

  sealed trait ReviewSort extends scala.Product with scala.Serializable
  object ReviewSort {
    case object CREATED_AT extends ReviewSort
    case object CREATED_AT_DESC extends ReviewSort
    case object ID extends ReviewSort
    case object ID_DESC extends ReviewSort
    case object RATING extends ReviewSort
    case object RATING_DESC extends ReviewSort
    case object SCORE extends ReviewSort
    case object SCORE_DESC extends ReviewSort
    case object UPDATED_AT extends ReviewSort
    case object UPDATED_AT_DESC extends ReviewSort

    implicit val decoder: ScalarDecoder[ReviewSort] = {
      case StringValue("CREATED_AT")      => Right(ReviewSort.CREATED_AT)
      case StringValue("CREATED_AT_DESC") => Right(ReviewSort.CREATED_AT_DESC)
      case StringValue("ID")              => Right(ReviewSort.ID)
      case StringValue("ID_DESC")         => Right(ReviewSort.ID_DESC)
      case StringValue("RATING")          => Right(ReviewSort.RATING)
      case StringValue("RATING_DESC")     => Right(ReviewSort.RATING_DESC)
      case StringValue("SCORE")           => Right(ReviewSort.SCORE)
      case StringValue("SCORE_DESC")      => Right(ReviewSort.SCORE_DESC)
      case StringValue("UPDATED_AT")      => Right(ReviewSort.UPDATED_AT)
      case StringValue("UPDATED_AT_DESC") => Right(ReviewSort.UPDATED_AT_DESC)
      case other =>
        Left(DecodingError(s"Can't build ReviewSort from input $other"))
    }
    implicit val encoder: ArgEncoder[ReviewSort] = new ArgEncoder[ReviewSort] {
      override def encode(value: ReviewSort): Value = value match {
        case ReviewSort.CREATED_AT      => EnumValue("CREATED_AT")
        case ReviewSort.CREATED_AT_DESC => EnumValue("CREATED_AT_DESC")
        case ReviewSort.ID              => EnumValue("ID")
        case ReviewSort.ID_DESC         => EnumValue("ID_DESC")
        case ReviewSort.RATING          => EnumValue("RATING")
        case ReviewSort.RATING_DESC     => EnumValue("RATING_DESC")
        case ReviewSort.SCORE           => EnumValue("SCORE")
        case ReviewSort.SCORE_DESC      => EnumValue("SCORE_DESC")
        case ReviewSort.UPDATED_AT      => EnumValue("UPDATED_AT")
        case ReviewSort.UPDATED_AT_DESC => EnumValue("UPDATED_AT_DESC")
      }
      override def typeName: String = "ReviewSort"
    }
  }

  sealed trait RevisionHistoryAction
      extends scala.Product
      with scala.Serializable
  object RevisionHistoryAction {
    case object CREATE extends RevisionHistoryAction
    case object EDIT extends RevisionHistoryAction

    implicit val decoder: ScalarDecoder[RevisionHistoryAction] = {
      case StringValue("CREATE") => Right(RevisionHistoryAction.CREATE)
      case StringValue("EDIT")   => Right(RevisionHistoryAction.EDIT)
      case other =>
        Left(
          DecodingError(s"Can't build RevisionHistoryAction from input $other")
        )
    }
    implicit val encoder: ArgEncoder[RevisionHistoryAction] =
      new ArgEncoder[RevisionHistoryAction] {
        override def encode(value: RevisionHistoryAction): Value = value match {
          case RevisionHistoryAction.CREATE => EnumValue("CREATE")
          case RevisionHistoryAction.EDIT   => EnumValue("EDIT")
        }
        override def typeName: String = "RevisionHistoryAction"
      }
  }

  sealed trait ScoreFormat extends scala.Product with scala.Serializable
  object ScoreFormat {
    case object POINT_10 extends ScoreFormat
    case object POINT_100 extends ScoreFormat
    case object POINT_10_DECIMAL extends ScoreFormat
    case object POINT_3 extends ScoreFormat
    case object POINT_5 extends ScoreFormat

    implicit val decoder: ScalarDecoder[ScoreFormat] = {
      case StringValue("POINT_10")  => Right(ScoreFormat.POINT_10)
      case StringValue("POINT_100") => Right(ScoreFormat.POINT_100)
      case StringValue("POINT_10_DECIMAL") =>
        Right(ScoreFormat.POINT_10_DECIMAL)
      case StringValue("POINT_3") => Right(ScoreFormat.POINT_3)
      case StringValue("POINT_5") => Right(ScoreFormat.POINT_5)
      case other =>
        Left(DecodingError(s"Can't build ScoreFormat from input $other"))
    }
    implicit val encoder: ArgEncoder[ScoreFormat] =
      new ArgEncoder[ScoreFormat] {
        override def encode(value: ScoreFormat): Value = value match {
          case ScoreFormat.POINT_10         => EnumValue("POINT_10")
          case ScoreFormat.POINT_100        => EnumValue("POINT_100")
          case ScoreFormat.POINT_10_DECIMAL => EnumValue("POINT_10_DECIMAL")
          case ScoreFormat.POINT_3          => EnumValue("POINT_3")
          case ScoreFormat.POINT_5          => EnumValue("POINT_5")
        }
        override def typeName: String = "ScoreFormat"
      }
  }

  sealed trait SiteTrendSort extends scala.Product with scala.Serializable
  object SiteTrendSort {
    case object CHANGE extends SiteTrendSort
    case object CHANGE_DESC extends SiteTrendSort
    case object COUNT extends SiteTrendSort
    case object COUNT_DESC extends SiteTrendSort
    case object DATE extends SiteTrendSort
    case object DATE_DESC extends SiteTrendSort

    implicit val decoder: ScalarDecoder[SiteTrendSort] = {
      case StringValue("CHANGE")      => Right(SiteTrendSort.CHANGE)
      case StringValue("CHANGE_DESC") => Right(SiteTrendSort.CHANGE_DESC)
      case StringValue("COUNT")       => Right(SiteTrendSort.COUNT)
      case StringValue("COUNT_DESC")  => Right(SiteTrendSort.COUNT_DESC)
      case StringValue("DATE")        => Right(SiteTrendSort.DATE)
      case StringValue("DATE_DESC")   => Right(SiteTrendSort.DATE_DESC)
      case other =>
        Left(DecodingError(s"Can't build SiteTrendSort from input $other"))
    }
    implicit val encoder: ArgEncoder[SiteTrendSort] =
      new ArgEncoder[SiteTrendSort] {
        override def encode(value: SiteTrendSort): Value = value match {
          case SiteTrendSort.CHANGE      => EnumValue("CHANGE")
          case SiteTrendSort.CHANGE_DESC => EnumValue("CHANGE_DESC")
          case SiteTrendSort.COUNT       => EnumValue("COUNT")
          case SiteTrendSort.COUNT_DESC  => EnumValue("COUNT_DESC")
          case SiteTrendSort.DATE        => EnumValue("DATE")
          case SiteTrendSort.DATE_DESC   => EnumValue("DATE_DESC")
        }
        override def typeName: String = "SiteTrendSort"
      }
  }

  sealed trait StaffLanguage extends scala.Product with scala.Serializable
  object StaffLanguage {
    case object ENGLISH extends StaffLanguage
    case object FRENCH extends StaffLanguage
    case object GERMAN extends StaffLanguage
    case object HEBREW extends StaffLanguage
    case object HUNGARIAN extends StaffLanguage
    case object ITALIAN extends StaffLanguage
    case object JAPANESE extends StaffLanguage
    case object KOREAN extends StaffLanguage
    case object PORTUGUESE extends StaffLanguage
    case object SPANISH extends StaffLanguage

    implicit val decoder: ScalarDecoder[StaffLanguage] = {
      case StringValue("ENGLISH")    => Right(StaffLanguage.ENGLISH)
      case StringValue("FRENCH")     => Right(StaffLanguage.FRENCH)
      case StringValue("GERMAN")     => Right(StaffLanguage.GERMAN)
      case StringValue("HEBREW")     => Right(StaffLanguage.HEBREW)
      case StringValue("HUNGARIAN")  => Right(StaffLanguage.HUNGARIAN)
      case StringValue("ITALIAN")    => Right(StaffLanguage.ITALIAN)
      case StringValue("JAPANESE")   => Right(StaffLanguage.JAPANESE)
      case StringValue("KOREAN")     => Right(StaffLanguage.KOREAN)
      case StringValue("PORTUGUESE") => Right(StaffLanguage.PORTUGUESE)
      case StringValue("SPANISH")    => Right(StaffLanguage.SPANISH)
      case other =>
        Left(DecodingError(s"Can't build StaffLanguage from input $other"))
    }
    implicit val encoder: ArgEncoder[StaffLanguage] =
      new ArgEncoder[StaffLanguage] {
        override def encode(value: StaffLanguage): Value = value match {
          case StaffLanguage.ENGLISH    => EnumValue("ENGLISH")
          case StaffLanguage.FRENCH     => EnumValue("FRENCH")
          case StaffLanguage.GERMAN     => EnumValue("GERMAN")
          case StaffLanguage.HEBREW     => EnumValue("HEBREW")
          case StaffLanguage.HUNGARIAN  => EnumValue("HUNGARIAN")
          case StaffLanguage.ITALIAN    => EnumValue("ITALIAN")
          case StaffLanguage.JAPANESE   => EnumValue("JAPANESE")
          case StaffLanguage.KOREAN     => EnumValue("KOREAN")
          case StaffLanguage.PORTUGUESE => EnumValue("PORTUGUESE")
          case StaffLanguage.SPANISH    => EnumValue("SPANISH")
        }
        override def typeName: String = "StaffLanguage"
      }
  }

  sealed trait StaffSort extends scala.Product with scala.Serializable
  object StaffSort {
    case object FAVOURITES extends StaffSort
    case object FAVOURITES_DESC extends StaffSort
    case object ID extends StaffSort
    case object ID_DESC extends StaffSort
    case object LANGUAGE extends StaffSort
    case object LANGUAGE_DESC extends StaffSort
    case object ROLE extends StaffSort
    case object ROLE_DESC extends StaffSort
    case object SEARCH_MATCH extends StaffSort

    implicit val decoder: ScalarDecoder[StaffSort] = {
      case StringValue("FAVOURITES")      => Right(StaffSort.FAVOURITES)
      case StringValue("FAVOURITES_DESC") => Right(StaffSort.FAVOURITES_DESC)
      case StringValue("ID")              => Right(StaffSort.ID)
      case StringValue("ID_DESC")         => Right(StaffSort.ID_DESC)
      case StringValue("LANGUAGE")        => Right(StaffSort.LANGUAGE)
      case StringValue("LANGUAGE_DESC")   => Right(StaffSort.LANGUAGE_DESC)
      case StringValue("ROLE")            => Right(StaffSort.ROLE)
      case StringValue("ROLE_DESC")       => Right(StaffSort.ROLE_DESC)
      case StringValue("SEARCH_MATCH")    => Right(StaffSort.SEARCH_MATCH)
      case other =>
        Left(DecodingError(s"Can't build StaffSort from input $other"))
    }
    implicit val encoder: ArgEncoder[StaffSort] = new ArgEncoder[StaffSort] {
      override def encode(value: StaffSort): Value = value match {
        case StaffSort.FAVOURITES      => EnumValue("FAVOURITES")
        case StaffSort.FAVOURITES_DESC => EnumValue("FAVOURITES_DESC")
        case StaffSort.ID              => EnumValue("ID")
        case StaffSort.ID_DESC         => EnumValue("ID_DESC")
        case StaffSort.LANGUAGE        => EnumValue("LANGUAGE")
        case StaffSort.LANGUAGE_DESC   => EnumValue("LANGUAGE_DESC")
        case StaffSort.ROLE            => EnumValue("ROLE")
        case StaffSort.ROLE_DESC       => EnumValue("ROLE_DESC")
        case StaffSort.SEARCH_MATCH    => EnumValue("SEARCH_MATCH")
      }
      override def typeName: String = "StaffSort"
    }
  }

  sealed trait StudioSort extends scala.Product with scala.Serializable
  object StudioSort {
    case object FAVOURITES extends StudioSort
    case object FAVOURITES_DESC extends StudioSort
    case object ID extends StudioSort
    case object ID_DESC extends StudioSort
    case object NAME extends StudioSort
    case object NAME_DESC extends StudioSort
    case object SEARCH_MATCH extends StudioSort

    implicit val decoder: ScalarDecoder[StudioSort] = {
      case StringValue("FAVOURITES")      => Right(StudioSort.FAVOURITES)
      case StringValue("FAVOURITES_DESC") => Right(StudioSort.FAVOURITES_DESC)
      case StringValue("ID")              => Right(StudioSort.ID)
      case StringValue("ID_DESC")         => Right(StudioSort.ID_DESC)
      case StringValue("NAME")            => Right(StudioSort.NAME)
      case StringValue("NAME_DESC")       => Right(StudioSort.NAME_DESC)
      case StringValue("SEARCH_MATCH")    => Right(StudioSort.SEARCH_MATCH)
      case other =>
        Left(DecodingError(s"Can't build StudioSort from input $other"))
    }
    implicit val encoder: ArgEncoder[StudioSort] = new ArgEncoder[StudioSort] {
      override def encode(value: StudioSort): Value = value match {
        case StudioSort.FAVOURITES      => EnumValue("FAVOURITES")
        case StudioSort.FAVOURITES_DESC => EnumValue("FAVOURITES_DESC")
        case StudioSort.ID              => EnumValue("ID")
        case StudioSort.ID_DESC         => EnumValue("ID_DESC")
        case StudioSort.NAME            => EnumValue("NAME")
        case StudioSort.NAME_DESC       => EnumValue("NAME_DESC")
        case StudioSort.SEARCH_MATCH    => EnumValue("SEARCH_MATCH")
      }
      override def typeName: String = "StudioSort"
    }
  }

  sealed trait SubmissionSort extends scala.Product with scala.Serializable
  object SubmissionSort {
    case object ID extends SubmissionSort
    case object ID_DESC extends SubmissionSort

    implicit val decoder: ScalarDecoder[SubmissionSort] = {
      case StringValue("ID")      => Right(SubmissionSort.ID)
      case StringValue("ID_DESC") => Right(SubmissionSort.ID_DESC)
      case other =>
        Left(DecodingError(s"Can't build SubmissionSort from input $other"))
    }
    implicit val encoder: ArgEncoder[SubmissionSort] =
      new ArgEncoder[SubmissionSort] {
        override def encode(value: SubmissionSort): Value = value match {
          case SubmissionSort.ID      => EnumValue("ID")
          case SubmissionSort.ID_DESC => EnumValue("ID_DESC")
        }
        override def typeName: String = "SubmissionSort"
      }
  }

  sealed trait SubmissionStatus extends scala.Product with scala.Serializable
  object SubmissionStatus {
    case object ACCEPTED extends SubmissionStatus
    case object PARTIALLY_ACCEPTED extends SubmissionStatus
    case object PENDING extends SubmissionStatus
    case object REJECTED extends SubmissionStatus

    implicit val decoder: ScalarDecoder[SubmissionStatus] = {
      case StringValue("ACCEPTED") => Right(SubmissionStatus.ACCEPTED)
      case StringValue("PARTIALLY_ACCEPTED") =>
        Right(SubmissionStatus.PARTIALLY_ACCEPTED)
      case StringValue("PENDING")  => Right(SubmissionStatus.PENDING)
      case StringValue("REJECTED") => Right(SubmissionStatus.REJECTED)
      case other =>
        Left(DecodingError(s"Can't build SubmissionStatus from input $other"))
    }
    implicit val encoder: ArgEncoder[SubmissionStatus] =
      new ArgEncoder[SubmissionStatus] {
        override def encode(value: SubmissionStatus): Value = value match {
          case SubmissionStatus.ACCEPTED => EnumValue("ACCEPTED")
          case SubmissionStatus.PARTIALLY_ACCEPTED =>
            EnumValue("PARTIALLY_ACCEPTED")
          case SubmissionStatus.PENDING  => EnumValue("PENDING")
          case SubmissionStatus.REJECTED => EnumValue("REJECTED")
        }
        override def typeName: String = "SubmissionStatus"
      }
  }

  sealed trait ThreadCommentSort extends scala.Product with scala.Serializable
  object ThreadCommentSort {
    case object ID extends ThreadCommentSort
    case object ID_DESC extends ThreadCommentSort

    implicit val decoder: ScalarDecoder[ThreadCommentSort] = {
      case StringValue("ID")      => Right(ThreadCommentSort.ID)
      case StringValue("ID_DESC") => Right(ThreadCommentSort.ID_DESC)
      case other =>
        Left(DecodingError(s"Can't build ThreadCommentSort from input $other"))
    }
    implicit val encoder: ArgEncoder[ThreadCommentSort] =
      new ArgEncoder[ThreadCommentSort] {
        override def encode(value: ThreadCommentSort): Value = value match {
          case ThreadCommentSort.ID      => EnumValue("ID")
          case ThreadCommentSort.ID_DESC => EnumValue("ID_DESC")
        }
        override def typeName: String = "ThreadCommentSort"
      }
  }

  sealed trait ThreadSort extends scala.Product with scala.Serializable
  object ThreadSort {
    case object CREATED_AT extends ThreadSort
    case object CREATED_AT_DESC extends ThreadSort
    case object ID extends ThreadSort
    case object ID_DESC extends ThreadSort
    case object IS_STICKY extends ThreadSort
    case object REPLIED_AT extends ThreadSort
    case object REPLIED_AT_DESC extends ThreadSort
    case object REPLY_COUNT extends ThreadSort
    case object REPLY_COUNT_DESC extends ThreadSort
    case object SEARCH_MATCH extends ThreadSort
    case object TITLE extends ThreadSort
    case object TITLE_DESC extends ThreadSort
    case object UPDATED_AT extends ThreadSort
    case object UPDATED_AT_DESC extends ThreadSort
    case object VIEW_COUNT extends ThreadSort
    case object VIEW_COUNT_DESC extends ThreadSort

    implicit val decoder: ScalarDecoder[ThreadSort] = {
      case StringValue("CREATED_AT")       => Right(ThreadSort.CREATED_AT)
      case StringValue("CREATED_AT_DESC")  => Right(ThreadSort.CREATED_AT_DESC)
      case StringValue("ID")               => Right(ThreadSort.ID)
      case StringValue("ID_DESC")          => Right(ThreadSort.ID_DESC)
      case StringValue("IS_STICKY")        => Right(ThreadSort.IS_STICKY)
      case StringValue("REPLIED_AT")       => Right(ThreadSort.REPLIED_AT)
      case StringValue("REPLIED_AT_DESC")  => Right(ThreadSort.REPLIED_AT_DESC)
      case StringValue("REPLY_COUNT")      => Right(ThreadSort.REPLY_COUNT)
      case StringValue("REPLY_COUNT_DESC") => Right(ThreadSort.REPLY_COUNT_DESC)
      case StringValue("SEARCH_MATCH")     => Right(ThreadSort.SEARCH_MATCH)
      case StringValue("TITLE")            => Right(ThreadSort.TITLE)
      case StringValue("TITLE_DESC")       => Right(ThreadSort.TITLE_DESC)
      case StringValue("UPDATED_AT")       => Right(ThreadSort.UPDATED_AT)
      case StringValue("UPDATED_AT_DESC")  => Right(ThreadSort.UPDATED_AT_DESC)
      case StringValue("VIEW_COUNT")       => Right(ThreadSort.VIEW_COUNT)
      case StringValue("VIEW_COUNT_DESC")  => Right(ThreadSort.VIEW_COUNT_DESC)
      case other =>
        Left(DecodingError(s"Can't build ThreadSort from input $other"))
    }
    implicit val encoder: ArgEncoder[ThreadSort] = new ArgEncoder[ThreadSort] {
      override def encode(value: ThreadSort): Value = value match {
        case ThreadSort.CREATED_AT       => EnumValue("CREATED_AT")
        case ThreadSort.CREATED_AT_DESC  => EnumValue("CREATED_AT_DESC")
        case ThreadSort.ID               => EnumValue("ID")
        case ThreadSort.ID_DESC          => EnumValue("ID_DESC")
        case ThreadSort.IS_STICKY        => EnumValue("IS_STICKY")
        case ThreadSort.REPLIED_AT       => EnumValue("REPLIED_AT")
        case ThreadSort.REPLIED_AT_DESC  => EnumValue("REPLIED_AT_DESC")
        case ThreadSort.REPLY_COUNT      => EnumValue("REPLY_COUNT")
        case ThreadSort.REPLY_COUNT_DESC => EnumValue("REPLY_COUNT_DESC")
        case ThreadSort.SEARCH_MATCH     => EnumValue("SEARCH_MATCH")
        case ThreadSort.TITLE            => EnumValue("TITLE")
        case ThreadSort.TITLE_DESC       => EnumValue("TITLE_DESC")
        case ThreadSort.UPDATED_AT       => EnumValue("UPDATED_AT")
        case ThreadSort.UPDATED_AT_DESC  => EnumValue("UPDATED_AT_DESC")
        case ThreadSort.VIEW_COUNT       => EnumValue("VIEW_COUNT")
        case ThreadSort.VIEW_COUNT_DESC  => EnumValue("VIEW_COUNT_DESC")
      }
      override def typeName: String = "ThreadSort"
    }
  }

  sealed trait UserSort extends scala.Product with scala.Serializable
  object UserSort {
    case object CHAPTERS_READ extends UserSort
    case object CHAPTERS_READ_DESC extends UserSort
    case object ID extends UserSort
    case object ID_DESC extends UserSort
    case object SEARCH_MATCH extends UserSort
    case object USERNAME extends UserSort
    case object USERNAME_DESC extends UserSort
    case object WATCHED_TIME extends UserSort
    case object WATCHED_TIME_DESC extends UserSort

    implicit val decoder: ScalarDecoder[UserSort] = {
      case StringValue("CHAPTERS_READ") => Right(UserSort.CHAPTERS_READ)
      case StringValue("CHAPTERS_READ_DESC") =>
        Right(UserSort.CHAPTERS_READ_DESC)
      case StringValue("ID")                => Right(UserSort.ID)
      case StringValue("ID_DESC")           => Right(UserSort.ID_DESC)
      case StringValue("SEARCH_MATCH")      => Right(UserSort.SEARCH_MATCH)
      case StringValue("USERNAME")          => Right(UserSort.USERNAME)
      case StringValue("USERNAME_DESC")     => Right(UserSort.USERNAME_DESC)
      case StringValue("WATCHED_TIME")      => Right(UserSort.WATCHED_TIME)
      case StringValue("WATCHED_TIME_DESC") => Right(UserSort.WATCHED_TIME_DESC)
      case other =>
        Left(DecodingError(s"Can't build UserSort from input $other"))
    }
    implicit val encoder: ArgEncoder[UserSort] = new ArgEncoder[UserSort] {
      override def encode(value: UserSort): Value = value match {
        case UserSort.CHAPTERS_READ      => EnumValue("CHAPTERS_READ")
        case UserSort.CHAPTERS_READ_DESC => EnumValue("CHAPTERS_READ_DESC")
        case UserSort.ID                 => EnumValue("ID")
        case UserSort.ID_DESC            => EnumValue("ID_DESC")
        case UserSort.SEARCH_MATCH       => EnumValue("SEARCH_MATCH")
        case UserSort.USERNAME           => EnumValue("USERNAME")
        case UserSort.USERNAME_DESC      => EnumValue("USERNAME_DESC")
        case UserSort.WATCHED_TIME       => EnumValue("WATCHED_TIME")
        case UserSort.WATCHED_TIME_DESC  => EnumValue("WATCHED_TIME_DESC")
      }
      override def typeName: String = "UserSort"
    }
  }

  sealed trait UserStatisticsSort extends scala.Product with scala.Serializable
  object UserStatisticsSort {
    case object COUNT extends UserStatisticsSort
    case object COUNT_DESC extends UserStatisticsSort
    case object ID extends UserStatisticsSort
    case object ID_DESC extends UserStatisticsSort
    case object MEAN_SCORE extends UserStatisticsSort
    case object MEAN_SCORE_DESC extends UserStatisticsSort
    case object PROGRESS extends UserStatisticsSort
    case object PROGRESS_DESC extends UserStatisticsSort

    implicit val decoder: ScalarDecoder[UserStatisticsSort] = {
      case StringValue("COUNT")      => Right(UserStatisticsSort.COUNT)
      case StringValue("COUNT_DESC") => Right(UserStatisticsSort.COUNT_DESC)
      case StringValue("ID")         => Right(UserStatisticsSort.ID)
      case StringValue("ID_DESC")    => Right(UserStatisticsSort.ID_DESC)
      case StringValue("MEAN_SCORE") => Right(UserStatisticsSort.MEAN_SCORE)
      case StringValue("MEAN_SCORE_DESC") =>
        Right(UserStatisticsSort.MEAN_SCORE_DESC)
      case StringValue("PROGRESS") => Right(UserStatisticsSort.PROGRESS)
      case StringValue("PROGRESS_DESC") =>
        Right(UserStatisticsSort.PROGRESS_DESC)
      case other =>
        Left(DecodingError(s"Can't build UserStatisticsSort from input $other"))
    }
    implicit val encoder: ArgEncoder[UserStatisticsSort] =
      new ArgEncoder[UserStatisticsSort] {
        override def encode(value: UserStatisticsSort): Value = value match {
          case UserStatisticsSort.COUNT      => EnumValue("COUNT")
          case UserStatisticsSort.COUNT_DESC => EnumValue("COUNT_DESC")
          case UserStatisticsSort.ID         => EnumValue("ID")
          case UserStatisticsSort.ID_DESC    => EnumValue("ID_DESC")
          case UserStatisticsSort.MEAN_SCORE => EnumValue("MEAN_SCORE")
          case UserStatisticsSort.MEAN_SCORE_DESC =>
            EnumValue("MEAN_SCORE_DESC")
          case UserStatisticsSort.PROGRESS      => EnumValue("PROGRESS")
          case UserStatisticsSort.PROGRESS_DESC => EnumValue("PROGRESS_DESC")
        }
        override def typeName: String = "UserStatisticsSort"
      }
  }

  sealed trait UserTitleLanguage extends scala.Product with scala.Serializable
  object UserTitleLanguage {
    case object ENGLISH extends UserTitleLanguage
    case object ENGLISH_STYLISED extends UserTitleLanguage
    case object NATIVE extends UserTitleLanguage
    case object NATIVE_STYLISED extends UserTitleLanguage
    case object ROMAJI extends UserTitleLanguage
    case object ROMAJI_STYLISED extends UserTitleLanguage

    implicit val decoder: ScalarDecoder[UserTitleLanguage] = {
      case StringValue("ENGLISH") => Right(UserTitleLanguage.ENGLISH)
      case StringValue("ENGLISH_STYLISED") =>
        Right(UserTitleLanguage.ENGLISH_STYLISED)
      case StringValue("NATIVE") => Right(UserTitleLanguage.NATIVE)
      case StringValue("NATIVE_STYLISED") =>
        Right(UserTitleLanguage.NATIVE_STYLISED)
      case StringValue("ROMAJI") => Right(UserTitleLanguage.ROMAJI)
      case StringValue("ROMAJI_STYLISED") =>
        Right(UserTitleLanguage.ROMAJI_STYLISED)
      case other =>
        Left(DecodingError(s"Can't build UserTitleLanguage from input $other"))
    }
    implicit val encoder: ArgEncoder[UserTitleLanguage] =
      new ArgEncoder[UserTitleLanguage] {
        override def encode(value: UserTitleLanguage): Value = value match {
          case UserTitleLanguage.ENGLISH => EnumValue("ENGLISH")
          case UserTitleLanguage.ENGLISH_STYLISED =>
            EnumValue("ENGLISH_STYLISED")
          case UserTitleLanguage.NATIVE          => EnumValue("NATIVE")
          case UserTitleLanguage.NATIVE_STYLISED => EnumValue("NATIVE_STYLISED")
          case UserTitleLanguage.ROMAJI          => EnumValue("ROMAJI")
          case UserTitleLanguage.ROMAJI_STYLISED => EnumValue("ROMAJI_STYLISED")
        }
        override def typeName: String = "UserTitleLanguage"
      }
  }

  type ActivityLikeNotification
  object ActivityLikeNotification {

    /**
      * The liked activity
      */
    def activity[A](
        onListActivity: SelectionBuilder[ListActivity, A],
        onMessageActivity: SelectionBuilder[MessageActivity, A],
        onTextActivity: SelectionBuilder[TextActivity, A]
    ): SelectionBuilder[ActivityLikeNotification, Option[A]] =
      Field(
        "activity",
        OptionOf(
          ChoiceOf(
            Map(
              "ListActivity" -> Obj(onListActivity),
              "MessageActivity" -> Obj(onMessageActivity),
              "TextActivity" -> Obj(onTextActivity)
            )
          )
        )
      )

    /**
      * The id of the activity which was liked
      */
    def activityId: SelectionBuilder[ActivityLikeNotification, Int] =
      Field("activityId", Scalar())

    /**
      * The notification context text
      */
    def context: SelectionBuilder[ActivityLikeNotification, Option[String]] =
      Field("context", OptionOf(Scalar()))

    /**
      * The time the notification was created at
      */
    def createdAt: SelectionBuilder[ActivityLikeNotification, Option[Int]] =
      Field("createdAt", OptionOf(Scalar()))

    /**
      * The id of the Notification
      */
    def id: SelectionBuilder[ActivityLikeNotification, Int] =
      Field("id", Scalar())

    /**
      * The type of notification
      */
    def `type`
        : SelectionBuilder[ActivityLikeNotification, Option[NotificationType]] =
      Field("type", OptionOf(Scalar()))

    /**
      * The user who liked the activity
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ActivityLikeNotification, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))

    /**
      * The id of the user who liked to the activity
      */
    def userId: SelectionBuilder[ActivityLikeNotification, Int] =
      Field("userId", Scalar())
  }

  type ActivityMentionNotification
  object ActivityMentionNotification {

    /**
      * The liked activity
      */
    def activity[A](
        onListActivity: SelectionBuilder[ListActivity, A],
        onMessageActivity: SelectionBuilder[MessageActivity, A],
        onTextActivity: SelectionBuilder[TextActivity, A]
    ): SelectionBuilder[ActivityMentionNotification, Option[A]] =
      Field(
        "activity",
        OptionOf(
          ChoiceOf(
            Map(
              "ListActivity" -> Obj(onListActivity),
              "MessageActivity" -> Obj(onMessageActivity),
              "TextActivity" -> Obj(onTextActivity)
            )
          )
        )
      )

    /**
      * The id of the activity where mentioned
      */
    def activityId: SelectionBuilder[ActivityMentionNotification, Int] =
      Field("activityId", Scalar())

    /**
      * The notification context text
      */
    def context: SelectionBuilder[ActivityMentionNotification, Option[String]] =
      Field("context", OptionOf(Scalar()))

    /**
      * The time the notification was created at
      */
    def createdAt: SelectionBuilder[ActivityMentionNotification, Option[Int]] =
      Field("createdAt", OptionOf(Scalar()))

    /**
      * The id of the Notification
      */
    def id: SelectionBuilder[ActivityMentionNotification, Int] =
      Field("id", Scalar())

    /**
      * The type of notification
      */
    def `type`: SelectionBuilder[ActivityMentionNotification, Option[
      NotificationType
    ]] = Field("type", OptionOf(Scalar()))

    /**
      * The user who mentioned the authenticated user
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ActivityMentionNotification, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))

    /**
      * The id of the user who mentioned the authenticated user
      */
    def userId: SelectionBuilder[ActivityMentionNotification, Int] =
      Field("userId", Scalar())
  }

  type ActivityMessageNotification
  object ActivityMessageNotification {

    /**
      * The id of the activity message
      */
    def activityId: SelectionBuilder[ActivityMessageNotification, Int] =
      Field("activityId", Scalar())

    /**
      * The notification context text
      */
    def context: SelectionBuilder[ActivityMessageNotification, Option[String]] =
      Field("context", OptionOf(Scalar()))

    /**
      * The time the notification was created at
      */
    def createdAt: SelectionBuilder[ActivityMessageNotification, Option[Int]] =
      Field("createdAt", OptionOf(Scalar()))

    /**
      * The id of the Notification
      */
    def id: SelectionBuilder[ActivityMessageNotification, Int] =
      Field("id", Scalar())

    /**
      * The message activity
      */
    def message[A](
        innerSelection: SelectionBuilder[MessageActivity, A]
    ): SelectionBuilder[ActivityMessageNotification, Option[A]] =
      Field("message", OptionOf(Obj(innerSelection)))

    /**
      * The type of notification
      */
    def `type`: SelectionBuilder[ActivityMessageNotification, Option[
      NotificationType
    ]] = Field("type", OptionOf(Scalar()))

    /**
      * The user who sent the message
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ActivityMessageNotification, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))

    /**
      * The if of the user who send the message
      */
    def userId: SelectionBuilder[ActivityMessageNotification, Int] =
      Field("userId", Scalar())
  }

  type ActivityReply
  object ActivityReply {

    /**
      * The id of the parent activity
      */
    def activityId: SelectionBuilder[ActivityReply, Option[Int]] =
      Field("activityId", OptionOf(Scalar()))

    /**
      * The time the reply was created at
      */
    def createdAt: SelectionBuilder[ActivityReply, Int] =
      Field("createdAt", Scalar())

    /**
      * The id of the reply
      */
    def id: SelectionBuilder[ActivityReply, Int] = Field("id", Scalar())

    /**
      * If the currently authenticated user liked the reply
      */
    def isLiked: SelectionBuilder[ActivityReply, Option[Boolean]] =
      Field("isLiked", OptionOf(Scalar()))

    /**
      * The amount of likes the reply has
      */
    def likeCount: SelectionBuilder[ActivityReply, Int] =
      Field("likeCount", Scalar())

    /**
      * The users who liked the reply
      */
    def likes[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ActivityReply, Option[List[Option[A]]]] =
      Field("likes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The reply text
      */
    def text(
        asHtml: Option[Boolean] = None
    ): SelectionBuilder[ActivityReply, Option[String]] =
      Field(
        "text",
        OptionOf(Scalar()),
        arguments = List(Argument("asHtml", asHtml))
      )

    /**
      * The user who created reply
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ActivityReply, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))

    /**
      * The id of the replies creator
      */
    def userId: SelectionBuilder[ActivityReply, Option[Int]] =
      Field("userId", OptionOf(Scalar()))
  }

  type ActivityReplyLikeNotification
  object ActivityReplyLikeNotification {

    /**
      * The liked activity
      */
    def activity[A](
        onListActivity: SelectionBuilder[ListActivity, A],
        onMessageActivity: SelectionBuilder[MessageActivity, A],
        onTextActivity: SelectionBuilder[TextActivity, A]
    ): SelectionBuilder[ActivityReplyLikeNotification, Option[A]] =
      Field(
        "activity",
        OptionOf(
          ChoiceOf(
            Map(
              "ListActivity" -> Obj(onListActivity),
              "MessageActivity" -> Obj(onMessageActivity),
              "TextActivity" -> Obj(onTextActivity)
            )
          )
        )
      )

    /**
      * The id of the activity where the reply which was liked
      */
    def activityId: SelectionBuilder[ActivityReplyLikeNotification, Int] =
      Field("activityId", Scalar())

    /**
      * The notification context text
      */
    def context
        : SelectionBuilder[ActivityReplyLikeNotification, Option[String]] =
      Field("context", OptionOf(Scalar()))

    /**
      * The time the notification was created at
      */
    def createdAt
        : SelectionBuilder[ActivityReplyLikeNotification, Option[Int]] =
      Field("createdAt", OptionOf(Scalar()))

    /**
      * The id of the Notification
      */
    def id: SelectionBuilder[ActivityReplyLikeNotification, Int] =
      Field("id", Scalar())

    /**
      * The type of notification
      */
    def `type`: SelectionBuilder[ActivityReplyLikeNotification, Option[
      NotificationType
    ]] = Field("type", OptionOf(Scalar()))

    /**
      * The user who liked the activity reply
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ActivityReplyLikeNotification, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))

    /**
      * The id of the user who liked to the activity reply
      */
    def userId: SelectionBuilder[ActivityReplyLikeNotification, Int] =
      Field("userId", Scalar())
  }

  type ActivityReplyNotification
  object ActivityReplyNotification {

    /**
      * The liked activity
      */
    def activity[A](
        onListActivity: SelectionBuilder[ListActivity, A],
        onMessageActivity: SelectionBuilder[MessageActivity, A],
        onTextActivity: SelectionBuilder[TextActivity, A]
    ): SelectionBuilder[ActivityReplyNotification, Option[A]] =
      Field(
        "activity",
        OptionOf(
          ChoiceOf(
            Map(
              "ListActivity" -> Obj(onListActivity),
              "MessageActivity" -> Obj(onMessageActivity),
              "TextActivity" -> Obj(onTextActivity)
            )
          )
        )
      )

    /**
      * The id of the activity which was replied too
      */
    def activityId: SelectionBuilder[ActivityReplyNotification, Int] =
      Field("activityId", Scalar())

    /**
      * The notification context text
      */
    def context: SelectionBuilder[ActivityReplyNotification, Option[String]] =
      Field("context", OptionOf(Scalar()))

    /**
      * The time the notification was created at
      */
    def createdAt: SelectionBuilder[ActivityReplyNotification, Option[Int]] =
      Field("createdAt", OptionOf(Scalar()))

    /**
      * The id of the Notification
      */
    def id: SelectionBuilder[ActivityReplyNotification, Int] =
      Field("id", Scalar())

    /**
      * The type of notification
      */
    def `type`: SelectionBuilder[ActivityReplyNotification, Option[
      NotificationType
    ]] = Field("type", OptionOf(Scalar()))

    /**
      * The user who replied to the activity
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ActivityReplyNotification, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))

    /**
      * The id of the user who replied to the activity
      */
    def userId: SelectionBuilder[ActivityReplyNotification, Int] =
      Field("userId", Scalar())
  }

  type ActivityReplySubscribedNotification
  object ActivityReplySubscribedNotification {

    /**
      * The liked activity
      */
    def activity[A](
        onListActivity: SelectionBuilder[ListActivity, A],
        onMessageActivity: SelectionBuilder[MessageActivity, A],
        onTextActivity: SelectionBuilder[TextActivity, A]
    ): SelectionBuilder[ActivityReplySubscribedNotification, Option[A]] =
      Field(
        "activity",
        OptionOf(
          ChoiceOf(
            Map(
              "ListActivity" -> Obj(onListActivity),
              "MessageActivity" -> Obj(onMessageActivity),
              "TextActivity" -> Obj(onTextActivity)
            )
          )
        )
      )

    /**
      * The id of the activity which was replied too
      */
    def activityId: SelectionBuilder[ActivityReplySubscribedNotification, Int] =
      Field("activityId", Scalar())

    /**
      * The notification context text
      */
    def context: SelectionBuilder[ActivityReplySubscribedNotification, Option[
      String
    ]] = Field("context", OptionOf(Scalar()))

    /**
      * The time the notification was created at
      */
    def createdAt
        : SelectionBuilder[ActivityReplySubscribedNotification, Option[Int]] =
      Field("createdAt", OptionOf(Scalar()))

    /**
      * The id of the Notification
      */
    def id: SelectionBuilder[ActivityReplySubscribedNotification, Int] =
      Field("id", Scalar())

    /**
      * The type of notification
      */
    def `type`: SelectionBuilder[ActivityReplySubscribedNotification, Option[
      NotificationType
    ]] = Field("type", OptionOf(Scalar()))

    /**
      * The user who replied to the activity
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ActivityReplySubscribedNotification, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))

    /**
      * The id of the user who replied to the activity
      */
    def userId: SelectionBuilder[ActivityReplySubscribedNotification, Int] =
      Field("userId", Scalar())
  }

  type AiringNotification
  object AiringNotification {

    /**
      * The id of the aired anime
      */
    def animeId: SelectionBuilder[AiringNotification, Int] =
      Field("animeId", Scalar())

    /**
      * The notification context text
      */
    def contexts
        : SelectionBuilder[AiringNotification, Option[List[Option[String]]]] =
      Field("contexts", OptionOf(ListOf(OptionOf(Scalar()))))

    /**
      * The time the notification was created at
      */
    def createdAt: SelectionBuilder[AiringNotification, Option[Int]] =
      Field("createdAt", OptionOf(Scalar()))

    /**
      * The episode number that just aired
      */
    def episode: SelectionBuilder[AiringNotification, Int] =
      Field("episode", Scalar())

    /**
      * The id of the Notification
      */
    def id: SelectionBuilder[AiringNotification, Int] = Field("id", Scalar())

    /**
      * The associated media of the airing schedule
      */
    def media[A](
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[AiringNotification, Option[A]] =
      Field("media", OptionOf(Obj(innerSelection)))

    /**
      * The type of notification
      */
    def `type`: SelectionBuilder[AiringNotification, Option[NotificationType]] =
      Field("type", OptionOf(Scalar()))
  }

  type AiringProgression
  object AiringProgression {

    /**
      * The episode the stats were recorded at. .5 is the mid point between 2 episodes airing dates.
      */
    def episode: SelectionBuilder[AiringProgression, Option[Double]] =
      Field("episode", OptionOf(Scalar()))

    /**
      * The average score for the media
      */
    def score: SelectionBuilder[AiringProgression, Option[Double]] =
      Field("score", OptionOf(Scalar()))

    /**
      * The amount of users watching the anime
      */
    def watching: SelectionBuilder[AiringProgression, Option[Int]] =
      Field("watching", OptionOf(Scalar()))
  }

  type AiringSchedule
  object AiringSchedule {

    /**
      * The time the episode airs at
      */
    def airingAt: SelectionBuilder[AiringSchedule, Int] =
      Field("airingAt", Scalar())

    /**
      * The airing episode number
      */
    def episode: SelectionBuilder[AiringSchedule, Int] =
      Field("episode", Scalar())

    /**
      * The id of the airing schedule item
      */
    def id: SelectionBuilder[AiringSchedule, Int] = Field("id", Scalar())

    /**
      * The associate media of the airing episode
      */
    def media[A](
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[AiringSchedule, Option[A]] =
      Field("media", OptionOf(Obj(innerSelection)))

    /**
      * The associate media id of the airing episode
      */
    def mediaId: SelectionBuilder[AiringSchedule, Int] =
      Field("mediaId", Scalar())

    /**
      * Seconds until episode starts airing
      */
    def timeUntilAiring: SelectionBuilder[AiringSchedule, Int] =
      Field("timeUntilAiring", Scalar())
  }

  type AiringScheduleConnection
  object AiringScheduleConnection {
    def edges[A](
        innerSelection: SelectionBuilder[AiringScheduleEdge, A]
    ): SelectionBuilder[AiringScheduleConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def nodes[A](
        innerSelection: SelectionBuilder[AiringSchedule, A]
    ): SelectionBuilder[AiringScheduleConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The pagination information
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[AiringScheduleConnection, Option[A]] =
      Field("pageInfo", OptionOf(Obj(innerSelection)))
  }

  type AiringScheduleEdge
  object AiringScheduleEdge {

    /**
      * The id of the connection
      */
    def id: SelectionBuilder[AiringScheduleEdge, Option[Int]] =
      Field("id", OptionOf(Scalar()))
    def node[A](
        innerSelection: SelectionBuilder[AiringSchedule, A]
    ): SelectionBuilder[AiringScheduleEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type AniChartUser
  object AniChartUser {
    def highlights: SelectionBuilder[AniChartUser, Option[Json]] =
      Field("highlights", OptionOf(Scalar()))
    def settings: SelectionBuilder[AniChartUser, Option[Json]] =
      Field("settings", OptionOf(Scalar()))
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[AniChartUser, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))
  }

  type Character
  object Character {

    /**
      * A general description of the character
      */
    def description(
        asHtml: Option[Boolean] = None
    ): SelectionBuilder[Character, Option[String]] =
      Field(
        "description",
        OptionOf(Scalar()),
        arguments = List(Argument("asHtml", asHtml))
      )

    /**
      * The amount of user's who have favourited the character
      */
    def favourites: SelectionBuilder[Character, Option[Int]] =
      Field("favourites", OptionOf(Scalar()))

    /**
      * The id of the character
      */
    def id: SelectionBuilder[Character, Int] = Field("id", Scalar())

    /**
      * Character images
      */
    def image[A](
        innerSelection: SelectionBuilder[CharacterImage, A]
    ): SelectionBuilder[Character, Option[A]] =
      Field("image", OptionOf(Obj(innerSelection)))

    /**
      * If the character is marked as favourite by the currently authenticated user
      */
    def isFavourite: SelectionBuilder[Character, Boolean] =
      Field("isFavourite", Scalar())

    /**
      * Media that includes the character
      */
    def media[A](
        page: Option[Int] = None,
        perPage: Option[Int] = None,
        sort: Option[List[Option[MediaSort]]] = None,
        `type`: Option[MediaType] = None
    )(
        innerSelection: SelectionBuilder[MediaConnection, A]
    ): SelectionBuilder[Character, Option[A]] =
      Field(
        "media",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("page", page),
          Argument("perPage", perPage),
          Argument("sort", sort),
          Argument("type", `type`)
        )
      )

    /**
      * Notes for site moderators
      */
    def modNotes: SelectionBuilder[Character, Option[String]] =
      Field("modNotes", OptionOf(Scalar()))

    /**
      * The names of the character
      */
    def name[A](
        innerSelection: SelectionBuilder[CharacterName, A]
    ): SelectionBuilder[Character, Option[A]] =
      Field("name", OptionOf(Obj(innerSelection)))

    /**
      * The url for the character page on the AniList website
      */
    def siteUrl: SelectionBuilder[Character, Option[String]] =
      Field("siteUrl", OptionOf(Scalar()))
    @deprecated("No data available", "")
    def updatedAt: SelectionBuilder[Character, Option[Int]] =
      Field("updatedAt", OptionOf(Scalar()))
  }

  type CharacterConnection
  object CharacterConnection {
    def edges[A](
        innerSelection: SelectionBuilder[CharacterEdge, A]
    ): SelectionBuilder[CharacterConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def nodes[A](
        innerSelection: SelectionBuilder[Character, A]
    ): SelectionBuilder[CharacterConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The pagination information
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[CharacterConnection, Option[A]] =
      Field("pageInfo", OptionOf(Obj(innerSelection)))
  }

  type CharacterEdge
  object CharacterEdge {

    /**
      * The order the character should be displayed from the users favourites
      */
    def favouriteOrder: SelectionBuilder[CharacterEdge, Option[Int]] =
      Field("favouriteOrder", OptionOf(Scalar()))

    /**
      * The id of the connection
      */
    def id: SelectionBuilder[CharacterEdge, Option[Int]] =
      Field("id", OptionOf(Scalar()))

    /**
      * The media the character is in
      */
    def media[A](
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[CharacterEdge, Option[List[Option[A]]]] =
      Field("media", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def node[A](
        innerSelection: SelectionBuilder[Character, A]
    ): SelectionBuilder[CharacterEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))

    /**
      * The characters role in the media
      */
    def role: SelectionBuilder[CharacterEdge, Option[CharacterRole]] =
      Field("role", OptionOf(Scalar()))

    /**
      * The voice actors of the character
      */
    def voiceActors[A](
        language: Option[StaffLanguage] = None,
        sort: Option[List[Option[StaffSort]]] = None
    )(
        innerSelection: SelectionBuilder[Staff, A]
    ): SelectionBuilder[CharacterEdge, Option[List[Option[A]]]] =
      Field(
        "voiceActors",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("language", language), Argument("sort", sort))
      )
  }

  type CharacterImage
  object CharacterImage {

    /**
      * The character's image of media at its largest size
      */
    def large: SelectionBuilder[CharacterImage, Option[String]] =
      Field("large", OptionOf(Scalar()))

    /**
      * The character's image of media at medium size
      */
    def medium: SelectionBuilder[CharacterImage, Option[String]] =
      Field("medium", OptionOf(Scalar()))
  }

  type CharacterName
  object CharacterName {

    /**
      * Other names the character might be referred to as
      */
    def alternative
        : SelectionBuilder[CharacterName, Option[List[Option[String]]]] =
      Field("alternative", OptionOf(ListOf(OptionOf(Scalar()))))

    /**
      * The character's given name
      */
    def first: SelectionBuilder[CharacterName, Option[String]] =
      Field("first", OptionOf(Scalar()))

    /**
      * The character's full name
      */
    def full: SelectionBuilder[CharacterName, Option[String]] =
      Field("full", OptionOf(Scalar()))

    /**
      * The character's surname
      */
    def last: SelectionBuilder[CharacterName, Option[String]] =
      Field("last", OptionOf(Scalar()))

    /**
      * The character's full name in their native language
      */
    def native: SelectionBuilder[CharacterName, Option[String]] =
      Field("native", OptionOf(Scalar()))
  }

  type CharacterSubmission
  object CharacterSubmission {

    /**
      * Character that the submission is referencing
      */
    def character[A](
        innerSelection: SelectionBuilder[Character, A]
    ): SelectionBuilder[CharacterSubmission, Option[A]] =
      Field("character", OptionOf(Obj(innerSelection)))
    def createdAt: SelectionBuilder[CharacterSubmission, Option[Int]] =
      Field("createdAt", OptionOf(Scalar()))

    /**
      * The id of the submission
      */
    def id: SelectionBuilder[CharacterSubmission, Int] = Field("id", Scalar())

    /**
      * Inner details of submission status
      */
    def notes: SelectionBuilder[CharacterSubmission, Option[String]] =
      Field("notes", OptionOf(Scalar()))
    def source: SelectionBuilder[CharacterSubmission, Option[String]] =
      Field("source", OptionOf(Scalar()))

    /**
      * Status of the submission
      */
    def status
        : SelectionBuilder[CharacterSubmission, Option[SubmissionStatus]] =
      Field("status", OptionOf(Scalar()))

    /**
      * The character submission changes
      */
    def submission[A](
        innerSelection: SelectionBuilder[Character, A]
    ): SelectionBuilder[CharacterSubmission, Option[A]] =
      Field("submission", OptionOf(Obj(innerSelection)))

    /**
      * Submitter for the submission
      */
    def submitter[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[CharacterSubmission, Option[A]] =
      Field("submitter", OptionOf(Obj(innerSelection)))
  }

  type CharacterSubmissionConnection
  object CharacterSubmissionConnection {
    def edges[A](
        innerSelection: SelectionBuilder[CharacterSubmissionEdge, A]
    ): SelectionBuilder[CharacterSubmissionConnection, Option[
      List[Option[A]]
    ]] = Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def nodes[A](
        innerSelection: SelectionBuilder[CharacterSubmission, A]
    ): SelectionBuilder[CharacterSubmissionConnection, Option[
      List[Option[A]]
    ]] = Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The pagination information
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[CharacterSubmissionConnection, Option[A]] =
      Field("pageInfo", OptionOf(Obj(innerSelection)))
  }

  type CharacterSubmissionEdge
  object CharacterSubmissionEdge {
    def node[A](
        innerSelection: SelectionBuilder[CharacterSubmission, A]
    ): SelectionBuilder[CharacterSubmissionEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))

    /**
      * The characters role in the media
      */
    def role: SelectionBuilder[CharacterSubmissionEdge, Option[CharacterRole]] =
      Field("role", OptionOf(Scalar()))

    /**
      * The submitted voice actors of the character
      */
    def submittedVoiceActors[A](
        innerSelection: SelectionBuilder[StaffSubmission, A]
    ): SelectionBuilder[CharacterSubmissionEdge, Option[List[Option[A]]]] =
      Field(
        "submittedVoiceActors",
        OptionOf(ListOf(OptionOf(Obj(innerSelection))))
      )

    /**
      * The voice actors of the character
      */
    def voiceActors[A](
        innerSelection: SelectionBuilder[Staff, A]
    ): SelectionBuilder[CharacterSubmissionEdge, Option[List[Option[A]]]] =
      Field("voiceActors", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type Deleted
  object Deleted {

    /**
      * If an item has been successfully deleted
      */
    def deleted: SelectionBuilder[Deleted, Option[Boolean]] =
      Field("deleted", OptionOf(Scalar()))
  }

  type Favourites
  object Favourites {

    /**
      * Favourite anime
      */
    def anime[A](page: Option[Int] = None, perPage: Option[Int] = None)(
        innerSelection: SelectionBuilder[MediaConnection, A]
    ): SelectionBuilder[Favourites, Option[A]] =
      Field(
        "anime",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("page", page), Argument("perPage", perPage))
      )

    /**
      * Favourite characters
      */
    def characters[A](page: Option[Int] = None, perPage: Option[Int] = None)(
        innerSelection: SelectionBuilder[CharacterConnection, A]
    ): SelectionBuilder[Favourites, Option[A]] =
      Field(
        "characters",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("page", page), Argument("perPage", perPage))
      )

    /**
      * Favourite manga
      */
    def manga[A](page: Option[Int] = None, perPage: Option[Int] = None)(
        innerSelection: SelectionBuilder[MediaConnection, A]
    ): SelectionBuilder[Favourites, Option[A]] =
      Field(
        "manga",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("page", page), Argument("perPage", perPage))
      )

    /**
      * Favourite staff
      */
    def staff[A](page: Option[Int] = None, perPage: Option[Int] = None)(
        innerSelection: SelectionBuilder[StaffConnection, A]
    ): SelectionBuilder[Favourites, Option[A]] =
      Field(
        "staff",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("page", page), Argument("perPage", perPage))
      )

    /**
      * Favourite studios
      */
    def studios[A](page: Option[Int] = None, perPage: Option[Int] = None)(
        innerSelection: SelectionBuilder[StudioConnection, A]
    ): SelectionBuilder[Favourites, Option[A]] =
      Field(
        "studios",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("page", page), Argument("perPage", perPage))
      )
  }

  type FollowingNotification
  object FollowingNotification {

    /**
      * The notification context text
      */
    def context: SelectionBuilder[FollowingNotification, Option[String]] =
      Field("context", OptionOf(Scalar()))

    /**
      * The time the notification was created at
      */
    def createdAt: SelectionBuilder[FollowingNotification, Option[Int]] =
      Field("createdAt", OptionOf(Scalar()))

    /**
      * The id of the Notification
      */
    def id: SelectionBuilder[FollowingNotification, Int] = Field("id", Scalar())

    /**
      * The type of notification
      */
    def `type`
        : SelectionBuilder[FollowingNotification, Option[NotificationType]] =
      Field("type", OptionOf(Scalar()))

    /**
      * The liked activity
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[FollowingNotification, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))

    /**
      * The id of the user who followed the authenticated user
      */
    def userId: SelectionBuilder[FollowingNotification, Int] =
      Field("userId", Scalar())
  }

  type FormatStats
  object FormatStats {
    def amount: SelectionBuilder[FormatStats, Option[Int]] =
      Field("amount", OptionOf(Scalar()))
    def format: SelectionBuilder[FormatStats, Option[MediaFormat]] =
      Field("format", OptionOf(Scalar()))
  }

  type FuzzyDate
  object FuzzyDate {

    /**
      * Numeric Day (24)
      */
    def day: SelectionBuilder[FuzzyDate, Option[Int]] =
      Field("day", OptionOf(Scalar()))

    /**
      * Numeric Month (3)
      */
    def month: SelectionBuilder[FuzzyDate, Option[Int]] =
      Field("month", OptionOf(Scalar()))

    /**
      * Numeric Year (2017)
      */
    def year: SelectionBuilder[FuzzyDate, Option[Int]] =
      Field("year", OptionOf(Scalar()))
  }

  type GenreStats
  object GenreStats {
    def amount: SelectionBuilder[GenreStats, Option[Int]] =
      Field("amount", OptionOf(Scalar()))
    def genre: SelectionBuilder[GenreStats, Option[String]] =
      Field("genre", OptionOf(Scalar()))
    def meanScore: SelectionBuilder[GenreStats, Option[Int]] =
      Field("meanScore", OptionOf(Scalar()))

    /**
      * The amount of time in minutes the genre has been watched by the user
      */
    def timeWatched: SelectionBuilder[GenreStats, Option[Int]] =
      Field("timeWatched", OptionOf(Scalar()))
  }

  type InternalPage
  object InternalPage {
    def activities[A](
        createdAt: Option[Int] = None,
        createdAt_greater: Option[Int] = None,
        createdAt_lesser: Option[Int] = None,
        hasReplies: Option[Boolean] = None,
        hasRepliesOrTypeText: Option[Boolean] = None,
        id: Option[Int] = None,
        id_in: Option[List[Option[Int]]] = None,
        id_not: Option[Int] = None,
        id_not_in: Option[List[Option[Int]]] = None,
        isFollowing: Option[Boolean] = None,
        mediaId: Option[Int] = None,
        mediaId_in: Option[List[Option[Int]]] = None,
        mediaId_not: Option[Int] = None,
        mediaId_not_in: Option[List[Option[Int]]] = None,
        messengerId: Option[Int] = None,
        messengerId_in: Option[List[Option[Int]]] = None,
        messengerId_not: Option[Int] = None,
        messengerId_not_in: Option[List[Option[Int]]] = None,
        sort: Option[List[Option[ActivitySort]]] = None,
        `type`: Option[ActivityType] = None,
        type_in: Option[List[Option[ActivityType]]] = None,
        type_not: Option[ActivityType] = None,
        type_not_in: Option[List[Option[ActivityType]]] = None,
        userId: Option[Int] = None,
        userId_in: Option[List[Option[Int]]] = None,
        userId_not: Option[Int] = None,
        userId_not_in: Option[List[Option[Int]]] = None
    )(
        onListActivity: SelectionBuilder[ListActivity, A],
        onMessageActivity: SelectionBuilder[MessageActivity, A],
        onTextActivity: SelectionBuilder[TextActivity, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "activities",
        OptionOf(
          ListOf(
            OptionOf(
              ChoiceOf(
                Map(
                  "ListActivity" -> Obj(onListActivity),
                  "MessageActivity" -> Obj(onMessageActivity),
                  "TextActivity" -> Obj(onTextActivity)
                )
              )
            )
          )
        ),
        arguments = List(
          Argument("createdAt", createdAt),
          Argument("createdAt_greater", createdAt_greater),
          Argument("createdAt_lesser", createdAt_lesser),
          Argument("hasReplies", hasReplies),
          Argument("hasRepliesOrTypeText", hasRepliesOrTypeText),
          Argument("id", id),
          Argument("id_in", id_in),
          Argument("id_not", id_not),
          Argument("id_not_in", id_not_in),
          Argument("isFollowing", isFollowing),
          Argument("mediaId", mediaId),
          Argument("mediaId_in", mediaId_in),
          Argument("mediaId_not", mediaId_not),
          Argument("mediaId_not_in", mediaId_not_in),
          Argument("messengerId", messengerId),
          Argument("messengerId_in", messengerId_in),
          Argument("messengerId_not", messengerId_not),
          Argument("messengerId_not_in", messengerId_not_in),
          Argument("sort", sort),
          Argument("type", `type`),
          Argument("type_in", type_in),
          Argument("type_not", type_not),
          Argument("type_not_in", type_not_in),
          Argument("userId", userId),
          Argument("userId_in", userId_in),
          Argument("userId_not", userId_not),
          Argument("userId_not_in", userId_not_in)
        )
      )
    def activityReplies[A](
        activityId: Option[Int] = None,
        id: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[ActivityReply, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "activityReplies",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("activityId", activityId), Argument("id", id))
      )
    def airingSchedules[A](
        airingAt: Option[Int] = None,
        airingAt_greater: Option[Int] = None,
        airingAt_lesser: Option[Int] = None,
        episode: Option[Int] = None,
        episode_greater: Option[Int] = None,
        episode_in: Option[List[Option[Int]]] = None,
        episode_lesser: Option[Int] = None,
        episode_not: Option[Int] = None,
        episode_not_in: Option[List[Option[Int]]] = None,
        id: Option[Int] = None,
        id_in: Option[List[Option[Int]]] = None,
        id_not: Option[Int] = None,
        id_not_in: Option[List[Option[Int]]] = None,
        mediaId: Option[Int] = None,
        mediaId_in: Option[List[Option[Int]]] = None,
        mediaId_not: Option[Int] = None,
        mediaId_not_in: Option[List[Option[Int]]] = None,
        notYetAired: Option[Boolean] = None,
        sort: Option[List[Option[AiringSort]]] = None
    )(
        innerSelection: SelectionBuilder[AiringSchedule, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "airingSchedules",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("airingAt", airingAt),
          Argument("airingAt_greater", airingAt_greater),
          Argument("airingAt_lesser", airingAt_lesser),
          Argument("episode", episode),
          Argument("episode_greater", episode_greater),
          Argument("episode_in", episode_in),
          Argument("episode_lesser", episode_lesser),
          Argument("episode_not", episode_not),
          Argument("episode_not_in", episode_not_in),
          Argument("id", id),
          Argument("id_in", id_in),
          Argument("id_not", id_not),
          Argument("id_not_in", id_not_in),
          Argument("mediaId", mediaId),
          Argument("mediaId_in", mediaId_in),
          Argument("mediaId_not", mediaId_not),
          Argument("mediaId_not_in", mediaId_not_in),
          Argument("notYetAired", notYetAired),
          Argument("sort", sort)
        )
      )
    def characterSubmissions[A](
        characterId: Option[Int] = None,
        sort: Option[List[Option[SubmissionSort]]] = None,
        status: Option[SubmissionStatus] = None,
        userId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[CharacterSubmission, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "characterSubmissions",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("characterId", characterId),
          Argument("sort", sort),
          Argument("status", status),
          Argument("userId", userId)
        )
      )
    def characters[A](
        id: Option[Int] = None,
        id_in: Option[List[Option[Int]]] = None,
        id_not: Option[Int] = None,
        id_not_in: Option[List[Option[Int]]] = None,
        search: Option[String] = None,
        sort: Option[List[Option[CharacterSort]]] = None
    )(
        innerSelection: SelectionBuilder[Character, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "characters",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("id", id),
          Argument("id_in", id_in),
          Argument("id_not", id_not),
          Argument("id_not_in", id_not_in),
          Argument("search", search),
          Argument("sort", sort)
        )
      )
    def followers[A](sort: Option[List[Option[UserSort]]] = None, userId: Int)(
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "followers",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("sort", sort), Argument("userId", userId))
      )
    def following[A](sort: Option[List[Option[UserSort]]] = None, userId: Int)(
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "following",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("sort", sort), Argument("userId", userId))
      )
    def likes[A](
        likeableId: Option[Int] = None,
        `type`: Option[LikeableType] = None
    )(
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "likes",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments =
          List(Argument("likeableId", likeableId), Argument("type", `type`))
      )
    def media[A](
        averageScore: Option[Int] = None,
        averageScore_greater: Option[Int] = None,
        averageScore_lesser: Option[Int] = None,
        averageScore_not: Option[Int] = None,
        chapters: Option[Int] = None,
        chapters_greater: Option[Int] = None,
        chapters_lesser: Option[Int] = None,
        countryOfOrigin: Option[CountryCode] = None,
        duration: Option[Int] = None,
        duration_greater: Option[Int] = None,
        duration_lesser: Option[Int] = None,
        endDate: Option[FuzzyDateInt] = None,
        endDate_greater: Option[FuzzyDateInt] = None,
        endDate_lesser: Option[FuzzyDateInt] = None,
        endDate_like: Option[String] = None,
        episodes: Option[Int] = None,
        episodes_greater: Option[Int] = None,
        episodes_lesser: Option[Int] = None,
        format: Option[MediaFormat] = None,
        format_in: Option[List[Option[MediaFormat]]] = None,
        format_not: Option[MediaFormat] = None,
        format_not_in: Option[List[Option[MediaFormat]]] = None,
        genre: Option[String] = None,
        genre_in: Option[List[Option[String]]] = None,
        genre_not_in: Option[List[Option[String]]] = None,
        id: Option[Int] = None,
        idMal: Option[Int] = None,
        idMal_in: Option[List[Option[Int]]] = None,
        idMal_not: Option[Int] = None,
        idMal_not_in: Option[List[Option[Int]]] = None,
        id_in: Option[List[Option[Int]]] = None,
        id_not: Option[Int] = None,
        id_not_in: Option[List[Option[Int]]] = None,
        isAdult: Option[Boolean] = None,
        licensedBy: Option[String] = None,
        licensedBy_in: Option[List[Option[String]]] = None,
        minimumTagRank: Option[Int] = None,
        onList: Option[Boolean] = None,
        popularity: Option[Int] = None,
        popularity_greater: Option[Int] = None,
        popularity_lesser: Option[Int] = None,
        popularity_not: Option[Int] = None,
        search: Option[String] = None,
        season: Option[MediaSeason] = None,
        seasonYear: Option[Int] = None,
        sort: Option[List[Option[MediaSort]]] = None,
        source: Option[MediaSource] = None,
        source_in: Option[List[Option[MediaSource]]] = None,
        startDate: Option[FuzzyDateInt] = None,
        startDate_greater: Option[FuzzyDateInt] = None,
        startDate_lesser: Option[FuzzyDateInt] = None,
        startDate_like: Option[String] = None,
        status: Option[MediaStatus] = None,
        status_in: Option[List[Option[MediaStatus]]] = None,
        status_not: Option[MediaStatus] = None,
        status_not_in: Option[List[Option[MediaStatus]]] = None,
        tag: Option[String] = None,
        tagCategory: Option[String] = None,
        tagCategory_in: Option[List[Option[String]]] = None,
        tagCategory_not_in: Option[List[Option[String]]] = None,
        tag_in: Option[List[Option[String]]] = None,
        tag_not_in: Option[List[Option[String]]] = None,
        `type`: Option[MediaType] = None,
        volumes: Option[Int] = None,
        volumes_greater: Option[Int] = None,
        volumes_lesser: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "media",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("averageScore", averageScore),
          Argument("averageScore_greater", averageScore_greater),
          Argument("averageScore_lesser", averageScore_lesser),
          Argument("averageScore_not", averageScore_not),
          Argument("chapters", chapters),
          Argument("chapters_greater", chapters_greater),
          Argument("chapters_lesser", chapters_lesser),
          Argument("countryOfOrigin", countryOfOrigin),
          Argument("duration", duration),
          Argument("duration_greater", duration_greater),
          Argument("duration_lesser", duration_lesser),
          Argument("endDate", endDate),
          Argument("endDate_greater", endDate_greater),
          Argument("endDate_lesser", endDate_lesser),
          Argument("endDate_like", endDate_like),
          Argument("episodes", episodes),
          Argument("episodes_greater", episodes_greater),
          Argument("episodes_lesser", episodes_lesser),
          Argument("format", format),
          Argument("format_in", format_in),
          Argument("format_not", format_not),
          Argument("format_not_in", format_not_in),
          Argument("genre", genre),
          Argument("genre_in", genre_in),
          Argument("genre_not_in", genre_not_in),
          Argument("id", id),
          Argument("idMal", idMal),
          Argument("idMal_in", idMal_in),
          Argument("idMal_not", idMal_not),
          Argument("idMal_not_in", idMal_not_in),
          Argument("id_in", id_in),
          Argument("id_not", id_not),
          Argument("id_not_in", id_not_in),
          Argument("isAdult", isAdult),
          Argument("licensedBy", licensedBy),
          Argument("licensedBy_in", licensedBy_in),
          Argument("minimumTagRank", minimumTagRank),
          Argument("onList", onList),
          Argument("popularity", popularity),
          Argument("popularity_greater", popularity_greater),
          Argument("popularity_lesser", popularity_lesser),
          Argument("popularity_not", popularity_not),
          Argument("search", search),
          Argument("season", season),
          Argument("seasonYear", seasonYear),
          Argument("sort", sort),
          Argument("source", source),
          Argument("source_in", source_in),
          Argument("startDate", startDate),
          Argument("startDate_greater", startDate_greater),
          Argument("startDate_lesser", startDate_lesser),
          Argument("startDate_like", startDate_like),
          Argument("status", status),
          Argument("status_in", status_in),
          Argument("status_not", status_not),
          Argument("status_not_in", status_not_in),
          Argument("tag", tag),
          Argument("tagCategory", tagCategory),
          Argument("tagCategory_in", tagCategory_in),
          Argument("tagCategory_not_in", tagCategory_not_in),
          Argument("tag_in", tag_in),
          Argument("tag_not_in", tag_not_in),
          Argument("type", `type`),
          Argument("volumes", volumes),
          Argument("volumes_greater", volumes_greater),
          Argument("volumes_lesser", volumes_lesser)
        )
      )
    def mediaList[A](
        compareWithAuthList: Option[Boolean] = None,
        completedAt: Option[FuzzyDateInt] = None,
        completedAt_greater: Option[FuzzyDateInt] = None,
        completedAt_lesser: Option[FuzzyDateInt] = None,
        completedAt_like: Option[String] = None,
        id: Option[Int] = None,
        isFollowing: Option[Boolean] = None,
        mediaId: Option[Int] = None,
        mediaId_in: Option[List[Option[Int]]] = None,
        mediaId_not_in: Option[List[Option[Int]]] = None,
        notes: Option[String] = None,
        notes_like: Option[String] = None,
        sort: Option[List[Option[MediaListSort]]] = None,
        startedAt: Option[FuzzyDateInt] = None,
        startedAt_greater: Option[FuzzyDateInt] = None,
        startedAt_lesser: Option[FuzzyDateInt] = None,
        startedAt_like: Option[String] = None,
        status: Option[MediaListStatus] = None,
        status_in: Option[List[Option[MediaListStatus]]] = None,
        status_not: Option[MediaListStatus] = None,
        status_not_in: Option[List[Option[MediaListStatus]]] = None,
        `type`: Option[MediaType] = None,
        userId: Option[Int] = None,
        userId_in: Option[List[Option[Int]]] = None,
        userName: Option[String] = None
    )(
        innerSelection: SelectionBuilder[MediaList, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "mediaList",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("compareWithAuthList", compareWithAuthList),
          Argument("completedAt", completedAt),
          Argument("completedAt_greater", completedAt_greater),
          Argument("completedAt_lesser", completedAt_lesser),
          Argument("completedAt_like", completedAt_like),
          Argument("id", id),
          Argument("isFollowing", isFollowing),
          Argument("mediaId", mediaId),
          Argument("mediaId_in", mediaId_in),
          Argument("mediaId_not_in", mediaId_not_in),
          Argument("notes", notes),
          Argument("notes_like", notes_like),
          Argument("sort", sort),
          Argument("startedAt", startedAt),
          Argument("startedAt_greater", startedAt_greater),
          Argument("startedAt_lesser", startedAt_lesser),
          Argument("startedAt_like", startedAt_like),
          Argument("status", status),
          Argument("status_in", status_in),
          Argument("status_not", status_not),
          Argument("status_not_in", status_not_in),
          Argument("type", `type`),
          Argument("userId", userId),
          Argument("userId_in", userId_in),
          Argument("userName", userName)
        )
      )
    def mediaSubmissions[A](
        mediaId: Option[Int] = None,
        sort: Option[List[Option[SubmissionSort]]] = None,
        status: Option[SubmissionStatus] = None,
        submissionId: Option[Int] = None,
        `type`: Option[MediaType] = None,
        userId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[MediaSubmission, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "mediaSubmissions",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("mediaId", mediaId),
          Argument("sort", sort),
          Argument("status", status),
          Argument("submissionId", submissionId),
          Argument("type", `type`),
          Argument("userId", userId)
        )
      )
    def mediaTrends[A](
        averageScore: Option[Int] = None,
        averageScore_greater: Option[Int] = None,
        averageScore_lesser: Option[Int] = None,
        averageScore_not: Option[Int] = None,
        date: Option[Int] = None,
        date_greater: Option[Int] = None,
        date_lesser: Option[Int] = None,
        episode: Option[Int] = None,
        episode_greater: Option[Int] = None,
        episode_lesser: Option[Int] = None,
        episode_not: Option[Int] = None,
        mediaId: Option[Int] = None,
        mediaId_in: Option[List[Option[Int]]] = None,
        mediaId_not: Option[Int] = None,
        mediaId_not_in: Option[List[Option[Int]]] = None,
        popularity: Option[Int] = None,
        popularity_greater: Option[Int] = None,
        popularity_lesser: Option[Int] = None,
        popularity_not: Option[Int] = None,
        releasing: Option[Boolean] = None,
        sort: Option[List[Option[MediaTrendSort]]] = None,
        trending: Option[Int] = None,
        trending_greater: Option[Int] = None,
        trending_lesser: Option[Int] = None,
        trending_not: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[MediaTrend, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "mediaTrends",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("averageScore", averageScore),
          Argument("averageScore_greater", averageScore_greater),
          Argument("averageScore_lesser", averageScore_lesser),
          Argument("averageScore_not", averageScore_not),
          Argument("date", date),
          Argument("date_greater", date_greater),
          Argument("date_lesser", date_lesser),
          Argument("episode", episode),
          Argument("episode_greater", episode_greater),
          Argument("episode_lesser", episode_lesser),
          Argument("episode_not", episode_not),
          Argument("mediaId", mediaId),
          Argument("mediaId_in", mediaId_in),
          Argument("mediaId_not", mediaId_not),
          Argument("mediaId_not_in", mediaId_not_in),
          Argument("popularity", popularity),
          Argument("popularity_greater", popularity_greater),
          Argument("popularity_lesser", popularity_lesser),
          Argument("popularity_not", popularity_not),
          Argument("releasing", releasing),
          Argument("sort", sort),
          Argument("trending", trending),
          Argument("trending_greater", trending_greater),
          Argument("trending_lesser", trending_lesser),
          Argument("trending_not", trending_not)
        )
      )
    def modActions[A](modId: Option[Int] = None, userId: Option[Int] = None)(
        innerSelection: SelectionBuilder[ModAction, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "modActions",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("modId", modId), Argument("userId", userId))
      )
    def notifications[A](
        resetNotificationCount: Option[Boolean] = None,
        `type`: Option[NotificationType] = None,
        type_in: Option[List[Option[NotificationType]]] = None
    )(
        onActivityLikeNotification: SelectionBuilder[
          ActivityLikeNotification,
          A
        ],
        onActivityMentionNotification: SelectionBuilder[
          ActivityMentionNotification,
          A
        ],
        onActivityMessageNotification: SelectionBuilder[
          ActivityMessageNotification,
          A
        ],
        onActivityReplyLikeNotification: SelectionBuilder[
          ActivityReplyLikeNotification,
          A
        ],
        onActivityReplyNotification: SelectionBuilder[
          ActivityReplyNotification,
          A
        ],
        onActivityReplySubscribedNotification: SelectionBuilder[
          ActivityReplySubscribedNotification,
          A
        ],
        onAiringNotification: SelectionBuilder[AiringNotification, A],
        onFollowingNotification: SelectionBuilder[FollowingNotification, A],
        onRelatedMediaAdditionNotification: SelectionBuilder[
          RelatedMediaAdditionNotification,
          A
        ],
        onThreadCommentLikeNotification: SelectionBuilder[
          ThreadCommentLikeNotification,
          A
        ],
        onThreadCommentMentionNotification: SelectionBuilder[
          ThreadCommentMentionNotification,
          A
        ],
        onThreadCommentReplyNotification: SelectionBuilder[
          ThreadCommentReplyNotification,
          A
        ],
        onThreadCommentSubscribedNotification: SelectionBuilder[
          ThreadCommentSubscribedNotification,
          A
        ],
        onThreadLikeNotification: SelectionBuilder[ThreadLikeNotification, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "notifications",
        OptionOf(
          ListOf(
            OptionOf(
              ChoiceOf(
                Map(
                  "ActivityLikeNotification" -> Obj(onActivityLikeNotification),
                  "ActivityMentionNotification" -> Obj(
                    onActivityMentionNotification
                  ),
                  "ActivityMessageNotification" -> Obj(
                    onActivityMessageNotification
                  ),
                  "ActivityReplyLikeNotification" -> Obj(
                    onActivityReplyLikeNotification
                  ),
                  "ActivityReplyNotification" -> Obj(
                    onActivityReplyNotification
                  ),
                  "ActivityReplySubscribedNotification" -> Obj(
                    onActivityReplySubscribedNotification
                  ),
                  "AiringNotification" -> Obj(onAiringNotification),
                  "FollowingNotification" -> Obj(onFollowingNotification),
                  "RelatedMediaAdditionNotification" -> Obj(
                    onRelatedMediaAdditionNotification
                  ),
                  "ThreadCommentLikeNotification" -> Obj(
                    onThreadCommentLikeNotification
                  ),
                  "ThreadCommentMentionNotification" -> Obj(
                    onThreadCommentMentionNotification
                  ),
                  "ThreadCommentReplyNotification" -> Obj(
                    onThreadCommentReplyNotification
                  ),
                  "ThreadCommentSubscribedNotification" -> Obj(
                    onThreadCommentSubscribedNotification
                  ),
                  "ThreadLikeNotification" -> Obj(onThreadLikeNotification)
                )
              )
            )
          )
        ),
        arguments = List(
          Argument("resetNotificationCount", resetNotificationCount),
          Argument("type", `type`),
          Argument("type_in", type_in)
        )
      )

    /**
      * The pagination information
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[InternalPage, Option[A]] =
      Field("pageInfo", OptionOf(Obj(innerSelection)))
    def recommendations[A](
        id: Option[Int] = None,
        mediaId: Option[Int] = None,
        mediaRecommendationId: Option[Int] = None,
        onList: Option[Boolean] = None,
        rating: Option[Int] = None,
        rating_greater: Option[Int] = None,
        rating_lesser: Option[Int] = None,
        sort: Option[List[Option[RecommendationSort]]] = None,
        userId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[Recommendation, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "recommendations",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("id", id),
          Argument("mediaId", mediaId),
          Argument("mediaRecommendationId", mediaRecommendationId),
          Argument("onList", onList),
          Argument("rating", rating),
          Argument("rating_greater", rating_greater),
          Argument("rating_lesser", rating_lesser),
          Argument("sort", sort),
          Argument("userId", userId)
        )
      )
    def reports[A](
        innerSelection: SelectionBuilder[Report, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field("reports", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def reviews[A](
        id: Option[Int] = None,
        mediaId: Option[Int] = None,
        mediaType: Option[MediaType] = None,
        sort: Option[List[Option[ReviewSort]]] = None,
        userId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[Review, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "reviews",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("id", id),
          Argument("mediaId", mediaId),
          Argument("mediaType", mediaType),
          Argument("sort", sort),
          Argument("userId", userId)
        )
      )
    def revisionHistory[A](
        characterId: Option[Int] = None,
        mediaId: Option[Int] = None,
        staffId: Option[Int] = None,
        studioId: Option[Int] = None,
        userId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[RevisionHistory, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "revisionHistory",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("characterId", characterId),
          Argument("mediaId", mediaId),
          Argument("staffId", staffId),
          Argument("studioId", studioId),
          Argument("userId", userId)
        )
      )
    def staff[A](
        id: Option[Int] = None,
        id_in: Option[List[Option[Int]]] = None,
        id_not: Option[Int] = None,
        id_not_in: Option[List[Option[Int]]] = None,
        search: Option[String] = None,
        sort: Option[List[Option[StaffSort]]] = None
    )(
        innerSelection: SelectionBuilder[Staff, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "staff",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("id", id),
          Argument("id_in", id_in),
          Argument("id_not", id_not),
          Argument("id_not_in", id_not_in),
          Argument("search", search),
          Argument("sort", sort)
        )
      )
    def staffSubmissions[A](
        sort: Option[List[Option[SubmissionSort]]] = None,
        staffId: Option[Int] = None,
        status: Option[SubmissionStatus] = None,
        userId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[StaffSubmission, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "staffSubmissions",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("sort", sort),
          Argument("staffId", staffId),
          Argument("status", status),
          Argument("userId", userId)
        )
      )
    def studios[A](
        id: Option[Int] = None,
        id_in: Option[List[Option[Int]]] = None,
        id_not: Option[Int] = None,
        id_not_in: Option[List[Option[Int]]] = None,
        search: Option[String] = None,
        sort: Option[List[Option[StudioSort]]] = None
    )(
        innerSelection: SelectionBuilder[Studio, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "studios",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("id", id),
          Argument("id_in", id_in),
          Argument("id_not", id_not),
          Argument("id_not_in", id_not_in),
          Argument("search", search),
          Argument("sort", sort)
        )
      )
    def threadComments[A](
        id: Option[Int] = None,
        sort: Option[List[Option[ThreadCommentSort]]] = None,
        threadId: Option[Int] = None,
        userId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[ThreadComment, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "threadComments",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("id", id),
          Argument("sort", sort),
          Argument("threadId", threadId),
          Argument("userId", userId)
        )
      )
    def threads[A](
        categoryId: Option[Int] = None,
        id: Option[Int] = None,
        id_in: Option[List[Option[Int]]] = None,
        mediaCategoryId: Option[Int] = None,
        replyUserId: Option[Int] = None,
        search: Option[String] = None,
        sort: Option[List[Option[ThreadSort]]] = None,
        subscribed: Option[Boolean] = None,
        userId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[Thread, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "threads",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("categoryId", categoryId),
          Argument("id", id),
          Argument("id_in", id_in),
          Argument("mediaCategoryId", mediaCategoryId),
          Argument("replyUserId", replyUserId),
          Argument("search", search),
          Argument("sort", sort),
          Argument("subscribed", subscribed),
          Argument("userId", userId)
        )
      )
    def users[A](
        id: Option[Int] = None,
        name: Option[String] = None,
        search: Option[String] = None,
        sort: Option[List[Option[UserSort]]] = None
    )(
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[InternalPage, Option[List[Option[A]]]] =
      Field(
        "users",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("id", id),
          Argument("name", name),
          Argument("search", search),
          Argument("sort", sort)
        )
      )
  }

  type ListActivity
  object ListActivity {

    /**
      * The time the activity was created at
      */
    def createdAt: SelectionBuilder[ListActivity, Int] =
      Field("createdAt", Scalar())

    /**
      * The id of the activity
      */
    def id: SelectionBuilder[ListActivity, Int] = Field("id", Scalar())

    /**
      * If the currently authenticated user liked the activity
      */
    def isLiked: SelectionBuilder[ListActivity, Option[Boolean]] =
      Field("isLiked", OptionOf(Scalar()))

    /**
      * If the activity is locked and can receive replies
      */
    def isLocked: SelectionBuilder[ListActivity, Option[Boolean]] =
      Field("isLocked", OptionOf(Scalar()))

    /**
      * If the currently authenticated user is subscribed to the activity
      */
    def isSubscribed: SelectionBuilder[ListActivity, Option[Boolean]] =
      Field("isSubscribed", OptionOf(Scalar()))

    /**
      * The amount of likes the activity has
      */
    def likeCount: SelectionBuilder[ListActivity, Int] =
      Field("likeCount", Scalar())

    /**
      * The users who liked the activity
      */
    def likes[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ListActivity, Option[List[Option[A]]]] =
      Field("likes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The associated media to the activity update
      */
    def media[A](
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[ListActivity, Option[A]] =
      Field("media", OptionOf(Obj(innerSelection)))

    /**
      * The list progress made
      */
    def progress: SelectionBuilder[ListActivity, Option[String]] =
      Field("progress", OptionOf(Scalar()))

    /**
      * The written replies to the activity
      */
    def replies[A](
        innerSelection: SelectionBuilder[ActivityReply, A]
    ): SelectionBuilder[ListActivity, Option[List[Option[A]]]] =
      Field("replies", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The number of activity replies
      */
    def replyCount: SelectionBuilder[ListActivity, Int] =
      Field("replyCount", Scalar())

    /**
      * The url for the activity page on the AniList website
      */
    def siteUrl: SelectionBuilder[ListActivity, Option[String]] =
      Field("siteUrl", OptionOf(Scalar()))

    /**
      * The list item's textual status
      */
    def status: SelectionBuilder[ListActivity, Option[String]] =
      Field("status", OptionOf(Scalar()))

    /**
      * The type of activity
      */
    def `type`: SelectionBuilder[ListActivity, Option[ActivityType]] =
      Field("type", OptionOf(Scalar()))

    /**
      * The owner of the activity
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ListActivity, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))

    /**
      * The user id of the activity's creator
      */
    def userId: SelectionBuilder[ListActivity, Option[Int]] =
      Field("userId", OptionOf(Scalar()))
  }

  type ListScoreStats
  object ListScoreStats {
    def meanScore: SelectionBuilder[ListScoreStats, Option[Int]] =
      Field("meanScore", OptionOf(Scalar()))
    def standardDeviation: SelectionBuilder[ListScoreStats, Option[Int]] =
      Field("standardDeviation", OptionOf(Scalar()))
  }

  type Media
  object Media {

    /**
      * The media's entire airing schedule
      */
    def airingSchedule[A](
        notYetAired: Option[Boolean] = None,
        page: Option[Int] = None,
        perPage: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[AiringScheduleConnection, A]
    ): SelectionBuilder[Media, Option[A]] =
      Field(
        "airingSchedule",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("notYetAired", notYetAired),
          Argument("page", page),
          Argument("perPage", perPage)
        )
      )

    /**
      * If the media should have forum thread automatically created for it on airing episode release
      */
    def autoCreateForumThread: SelectionBuilder[Media, Option[Boolean]] =
      Field("autoCreateForumThread", OptionOf(Scalar()))

    /**
      * A weighted average score of all the user's scores of the media
      */
    def averageScore: SelectionBuilder[Media, Option[Int]] =
      Field("averageScore", OptionOf(Scalar()))

    /**
      * The banner image of the media
      */
    def bannerImage: SelectionBuilder[Media, Option[String]] =
      Field("bannerImage", OptionOf(Scalar()))

    /**
      * The amount of chapters the manga has when complete
      */
    def chapters: SelectionBuilder[Media, Option[Int]] =
      Field("chapters", OptionOf(Scalar()))

    /**
      * The characters in the media
      */
    def characters[A](
        page: Option[Int] = None,
        perPage: Option[Int] = None,
        role: Option[CharacterRole] = None,
        sort: Option[List[Option[CharacterSort]]] = None
    )(
        innerSelection: SelectionBuilder[CharacterConnection, A]
    ): SelectionBuilder[Media, Option[A]] =
      Field(
        "characters",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("page", page),
          Argument("perPage", perPage),
          Argument("role", role),
          Argument("sort", sort)
        )
      )

    /**
      * Where the media was created. (ISO 3166-1 alpha-2)
      */
    def countryOfOrigin: SelectionBuilder[Media, Option[CountryCode]] =
      Field("countryOfOrigin", OptionOf(Scalar()))

    /**
      * The cover images of the media
      */
    def coverImage[A](
        innerSelection: SelectionBuilder[MediaCoverImage, A]
    ): SelectionBuilder[Media, Option[A]] =
      Field("coverImage", OptionOf(Obj(innerSelection)))

    /**
      * Short description of the media's story and characters
      */
    def description(
        asHtml: Option[Boolean] = None
    ): SelectionBuilder[Media, Option[String]] =
      Field(
        "description",
        OptionOf(Scalar()),
        arguments = List(Argument("asHtml", asHtml))
      )

    /**
      * The general length of each anime episode in minutes
      */
    def duration: SelectionBuilder[Media, Option[Int]] =
      Field("duration", OptionOf(Scalar()))

    /**
      * The last official release date of the media
      */
    def endDate[A](
        innerSelection: SelectionBuilder[FuzzyDate, A]
    ): SelectionBuilder[Media, Option[A]] =
      Field("endDate", OptionOf(Obj(innerSelection)))

    /**
      * The amount of episodes the anime has when complete
      */
    def episodes: SelectionBuilder[Media, Option[Int]] =
      Field("episodes", OptionOf(Scalar()))

    /**
      * External links to another site related to the media
      */
    def externalLinks[A](
        innerSelection: SelectionBuilder[MediaExternalLink, A]
    ): SelectionBuilder[Media, Option[List[Option[A]]]] =
      Field("externalLinks", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The amount of user's who have favourited the media
      */
    def favourites: SelectionBuilder[Media, Option[Int]] =
      Field("favourites", OptionOf(Scalar()))

    /**
      * The format the media was released in
      */
    def format: SelectionBuilder[Media, Option[MediaFormat]] =
      Field("format", OptionOf(Scalar()))

    /**
      * The genres of the media
      */
    def genres: SelectionBuilder[Media, Option[List[Option[String]]]] =
      Field("genres", OptionOf(ListOf(OptionOf(Scalar()))))

    /**
      * Official Twitter hashtags for the media
      */
    def hashtag: SelectionBuilder[Media, Option[String]] =
      Field("hashtag", OptionOf(Scalar()))

    /**
      * The id of the media
      */
    def id: SelectionBuilder[Media, Int] = Field("id", Scalar())

    /**
      * The mal id of the media
      */
    def idMal: SelectionBuilder[Media, Option[Int]] =
      Field("idMal", OptionOf(Scalar()))

    /**
      * If the media is intended only for 18+ adult audiences
      */
    def isAdult: SelectionBuilder[Media, Option[Boolean]] =
      Field("isAdult", OptionOf(Scalar()))

    /**
      * If the media is marked as favourite by the current authenticated user
      */
    def isFavourite: SelectionBuilder[Media, Boolean] =
      Field("isFavourite", Scalar())

    /**
      * If the media is officially licensed or a self-published doujin release
      */
    def isLicensed: SelectionBuilder[Media, Option[Boolean]] =
      Field("isLicensed", OptionOf(Scalar()))

    /**
      * Locked media may not be added to lists our favorited. This may be due to the entry pending for deletion or other reasons.
      */
    def isLocked: SelectionBuilder[Media, Option[Boolean]] =
      Field("isLocked", OptionOf(Scalar()))

    /**
      * If the media is blocked from being recommended to/from
      */
    def isRecommendationBlocked: SelectionBuilder[Media, Option[Boolean]] =
      Field("isRecommendationBlocked", OptionOf(Scalar()))

    /**
      * Mean score of all the user's scores of the media
      */
    def meanScore: SelectionBuilder[Media, Option[Int]] =
      Field("meanScore", OptionOf(Scalar()))

    /**
      * The authenticated user's media list entry for the media
      */
    def mediaListEntry[A](
        innerSelection: SelectionBuilder[MediaList, A]
    ): SelectionBuilder[Media, Option[A]] =
      Field("mediaListEntry", OptionOf(Obj(innerSelection)))

    /**
      * Notes for site moderators
      */
    def modNotes: SelectionBuilder[Media, Option[String]] =
      Field("modNotes", OptionOf(Scalar()))

    /**
      * The media's next episode airing schedule
      */
    def nextAiringEpisode[A](
        innerSelection: SelectionBuilder[AiringSchedule, A]
    ): SelectionBuilder[Media, Option[A]] =
      Field("nextAiringEpisode", OptionOf(Obj(innerSelection)))

    /**
      * The number of users with the media on their list
      */
    def popularity: SelectionBuilder[Media, Option[Int]] =
      Field("popularity", OptionOf(Scalar()))

    /**
      * The ranking of the media in a particular time span and format compared to other media
      */
    def rankings[A](
        innerSelection: SelectionBuilder[MediaRank, A]
    ): SelectionBuilder[Media, Option[List[Option[A]]]] =
      Field("rankings", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * User recommendations for similar media
      */
    def recommendations[A](
        page: Option[Int] = None,
        perPage: Option[Int] = None,
        sort: Option[List[Option[RecommendationSort]]] = None
    )(
        innerSelection: SelectionBuilder[RecommendationConnection, A]
    ): SelectionBuilder[Media, Option[A]] =
      Field(
        "recommendations",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("page", page),
          Argument("perPage", perPage),
          Argument("sort", sort)
        )
      )

    /**
      * Other media in the same or connecting franchise
      */
    def relations[A](
        innerSelection: SelectionBuilder[MediaConnection, A]
    ): SelectionBuilder[Media, Option[A]] =
      Field("relations", OptionOf(Obj(innerSelection)))

    /**
      * User reviews of the media
      */
    def reviews[A](
        limit: Option[Int] = None,
        page: Option[Int] = None,
        perPage: Option[Int] = None,
        sort: Option[List[Option[ReviewSort]]] = None
    )(
        innerSelection: SelectionBuilder[ReviewConnection, A]
    ): SelectionBuilder[Media, Option[A]] =
      Field(
        "reviews",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("limit", limit),
          Argument("page", page),
          Argument("perPage", perPage),
          Argument("sort", sort)
        )
      )

    /**
      * The season the media was initially released in
      */
    def season: SelectionBuilder[Media, Option[MediaSeason]] =
      Field("season", OptionOf(Scalar()))

    /**
      * The year & season the media was initially released in
      */
    def seasonInt: SelectionBuilder[Media, Option[Int]] =
      Field("seasonInt", OptionOf(Scalar()))

    /**
      * The season year the media was initially released in
      */
    def seasonYear: SelectionBuilder[Media, Option[Int]] =
      Field("seasonYear", OptionOf(Scalar()))

    /**
      * The url for the media page on the AniList website
      */
    def siteUrl: SelectionBuilder[Media, Option[String]] =
      Field("siteUrl", OptionOf(Scalar()))

    /**
      * Source type the media was adapted from.
      */
    def source(
        version: Option[Int] = None
    ): SelectionBuilder[Media, Option[MediaSource]] =
      Field(
        "source",
        OptionOf(Scalar()),
        arguments = List(Argument("version", version))
      )

    /**
      * The staff who produced the media
      */
    def staff[A](
        page: Option[Int] = None,
        perPage: Option[Int] = None,
        sort: Option[List[Option[StaffSort]]] = None
    )(
        innerSelection: SelectionBuilder[StaffConnection, A]
    ): SelectionBuilder[Media, Option[A]] =
      Field(
        "staff",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("page", page),
          Argument("perPage", perPage),
          Argument("sort", sort)
        )
      )

    /**
      * The first official release date of the media
      */
    def startDate[A](
        innerSelection: SelectionBuilder[FuzzyDate, A]
    ): SelectionBuilder[Media, Option[A]] =
      Field("startDate", OptionOf(Obj(innerSelection)))
    def stats[A](
        innerSelection: SelectionBuilder[MediaStats, A]
    ): SelectionBuilder[Media, Option[A]] =
      Field("stats", OptionOf(Obj(innerSelection)))

    /**
      * The current releasing status of the media
      */
    def status: SelectionBuilder[Media, Option[MediaStatus]] =
      Field("status", OptionOf(Scalar()))

    /**
      * Data and links to legal streaming episodes on external sites
      */
    def streamingEpisodes[A](
        innerSelection: SelectionBuilder[MediaStreamingEpisode, A]
    ): SelectionBuilder[Media, Option[List[Option[A]]]] =
      Field(
        "streamingEpisodes",
        OptionOf(ListOf(OptionOf(Obj(innerSelection))))
      )

    /**
      * The companies who produced the media
      */
    def studios[A](
        isMain: Option[Boolean] = None,
        sort: Option[List[Option[StudioSort]]] = None
    )(
        innerSelection: SelectionBuilder[StudioConnection, A]
    ): SelectionBuilder[Media, Option[A]] =
      Field(
        "studios",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("isMain", isMain), Argument("sort", sort))
      )

    /**
      * Alternative titles of the media
      */
    def synonyms: SelectionBuilder[Media, Option[List[Option[String]]]] =
      Field("synonyms", OptionOf(ListOf(OptionOf(Scalar()))))

    /**
      * List of tags that describes elements and themes of the media
      */
    def tags[A](
        innerSelection: SelectionBuilder[MediaTag, A]
    ): SelectionBuilder[Media, Option[List[Option[A]]]] =
      Field("tags", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The official titles of the media in various languages
      */
    def title[A](
        innerSelection: SelectionBuilder[MediaTitle, A]
    ): SelectionBuilder[Media, Option[A]] =
      Field("title", OptionOf(Obj(innerSelection)))

    /**
      * Media trailer or advertisement
      */
    def trailer[A](
        innerSelection: SelectionBuilder[MediaTrailer, A]
    ): SelectionBuilder[Media, Option[A]] =
      Field("trailer", OptionOf(Obj(innerSelection)))

    /**
      * The amount of related activity in the past hour
      */
    def trending: SelectionBuilder[Media, Option[Int]] =
      Field("trending", OptionOf(Scalar()))

    /**
      * The media's daily trend stats
      */
    def trends[A](
        page: Option[Int] = None,
        perPage: Option[Int] = None,
        releasing: Option[Boolean] = None,
        sort: Option[List[Option[MediaTrendSort]]] = None
    )(
        innerSelection: SelectionBuilder[MediaTrendConnection, A]
    ): SelectionBuilder[Media, Option[A]] =
      Field(
        "trends",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("page", page),
          Argument("perPage", perPage),
          Argument("releasing", releasing),
          Argument("sort", sort)
        )
      )

    /**
      * The type of the media; anime or manga
      */
    def `type`: SelectionBuilder[Media, Option[MediaType]] =
      Field("type", OptionOf(Scalar()))

    /**
      * When the media's data was last updated
      */
    def updatedAt: SelectionBuilder[Media, Option[Int]] =
      Field("updatedAt", OptionOf(Scalar()))

    /**
      * The amount of volumes the manga has when complete
      */
    def volumes: SelectionBuilder[Media, Option[Int]] =
      Field("volumes", OptionOf(Scalar()))
  }

  type MediaCharacter
  object MediaCharacter {

    /**
      * The characters in the media voiced by the parent actor
      */
    def character[A](
        innerSelection: SelectionBuilder[Character, A]
    ): SelectionBuilder[MediaCharacter, Option[A]] =
      Field("character", OptionOf(Obj(innerSelection)))

    /**
      * The id of the connection
      */
    def id: SelectionBuilder[MediaCharacter, Option[Int]] =
      Field("id", OptionOf(Scalar()))

    /**
      * The characters role in the media
      */
    def role: SelectionBuilder[MediaCharacter, Option[CharacterRole]] =
      Field("role", OptionOf(Scalar()))

    /**
      * The voice actor of the character
      */
    def voiceActor[A](
        innerSelection: SelectionBuilder[Staff, A]
    ): SelectionBuilder[MediaCharacter, Option[A]] =
      Field("voiceActor", OptionOf(Obj(innerSelection)))
  }

  type MediaConnection
  object MediaConnection {
    def edges[A](
        innerSelection: SelectionBuilder[MediaEdge, A]
    ): SelectionBuilder[MediaConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def nodes[A](
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[MediaConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The pagination information
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[MediaConnection, Option[A]] =
      Field("pageInfo", OptionOf(Obj(innerSelection)))
  }

  type MediaCoverImage
  object MediaCoverImage {

    /**
      * Average #hex color of cover image
      */
    def color: SelectionBuilder[MediaCoverImage, Option[String]] =
      Field("color", OptionOf(Scalar()))

    /**
      * The cover image url of the media at its largest size. If this size isn't available, large will be provided instead.
      */
    def extraLarge: SelectionBuilder[MediaCoverImage, Option[String]] =
      Field("extraLarge", OptionOf(Scalar()))

    /**
      * The cover image url of the media at a large size
      */
    def large: SelectionBuilder[MediaCoverImage, Option[String]] =
      Field("large", OptionOf(Scalar()))

    /**
      * The cover image url of the media at medium size
      */
    def medium: SelectionBuilder[MediaCoverImage, Option[String]] =
      Field("medium", OptionOf(Scalar()))
  }

  type MediaEdge
  object MediaEdge {

    /**
      * The characters role in the media
      */
    def characterRole: SelectionBuilder[MediaEdge, Option[CharacterRole]] =
      Field("characterRole", OptionOf(Scalar()))

    /**
      * The characters in the media voiced by the parent actor
      */
    def characters[A](
        innerSelection: SelectionBuilder[Character, A]
    ): SelectionBuilder[MediaEdge, Option[List[Option[A]]]] =
      Field("characters", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The order the media should be displayed from the users favourites
      */
    def favouriteOrder: SelectionBuilder[MediaEdge, Option[Int]] =
      Field("favouriteOrder", OptionOf(Scalar()))

    /**
      * The id of the connection
      */
    def id: SelectionBuilder[MediaEdge, Option[Int]] =
      Field("id", OptionOf(Scalar()))

    /**
      * If the studio is the main animation studio of the media (For Studio->MediaConnection field only)
      */
    def isMainStudio: SelectionBuilder[MediaEdge, Boolean] =
      Field("isMainStudio", Scalar())
    def node[A](
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[MediaEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))

    /**
      * The type of relation to the parent model
      */
    def relationType(
        version: Option[Int] = None
    ): SelectionBuilder[MediaEdge, Option[MediaRelation]] =
      Field(
        "relationType",
        OptionOf(Scalar()),
        arguments = List(Argument("version", version))
      )

    /**
      * The role of the staff member in the production of the media
      */
    def staffRole: SelectionBuilder[MediaEdge, Option[String]] =
      Field("staffRole", OptionOf(Scalar()))

    /**
      * The voice actors of the character
      */
    def voiceActors[A](
        language: Option[StaffLanguage] = None,
        sort: Option[List[Option[StaffSort]]] = None
    )(
        innerSelection: SelectionBuilder[Staff, A]
    ): SelectionBuilder[MediaEdge, Option[List[Option[A]]]] =
      Field(
        "voiceActors",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("language", language), Argument("sort", sort))
      )
  }

  type MediaExternalLink
  object MediaExternalLink {

    /**
      * The id of the external link
      */
    def id: SelectionBuilder[MediaExternalLink, Int] = Field("id", Scalar())

    /**
      * The site location of the external link
      */
    def site: SelectionBuilder[MediaExternalLink, String] =
      Field("site", Scalar())

    /**
      * The url of the external link
      */
    def url: SelectionBuilder[MediaExternalLink, String] =
      Field("url", Scalar())
  }

  type MediaList
  object MediaList {

    /**
      * Map of advanced scores with name keys
      */
    def advancedScores: SelectionBuilder[MediaList, Option[Json]] =
      Field("advancedScores", OptionOf(Scalar()))

    /**
      * When the entry was completed by the user
      */
    def completedAt[A](
        innerSelection: SelectionBuilder[FuzzyDate, A]
    ): SelectionBuilder[MediaList, Option[A]] =
      Field("completedAt", OptionOf(Obj(innerSelection)))

    /**
      * When the entry data was created
      */
    def createdAt: SelectionBuilder[MediaList, Option[Int]] =
      Field("createdAt", OptionOf(Scalar()))

    /**
      * Map of booleans for which custom lists the entry are in
      */
    def customLists(
        asArray: Option[Boolean] = None
    ): SelectionBuilder[MediaList, Option[Json]] =
      Field(
        "customLists",
        OptionOf(Scalar()),
        arguments = List(Argument("asArray", asArray))
      )

    /**
      * If the entry shown be hidden from non-custom lists
      */
    def hiddenFromStatusLists: SelectionBuilder[MediaList, Option[Boolean]] =
      Field("hiddenFromStatusLists", OptionOf(Scalar()))

    /**
      * The id of the list entry
      */
    def id: SelectionBuilder[MediaList, Int] = Field("id", Scalar())
    def media[A](
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[MediaList, Option[A]] =
      Field("media", OptionOf(Obj(innerSelection)))

    /**
      * The id of the media
      */
    def mediaId: SelectionBuilder[MediaList, Int] = Field("mediaId", Scalar())

    /**
      * Text notes
      */
    def notes: SelectionBuilder[MediaList, Option[String]] =
      Field("notes", OptionOf(Scalar()))

    /**
      * Priority of planning
      */
    def priority: SelectionBuilder[MediaList, Option[Int]] =
      Field("priority", OptionOf(Scalar()))

    /**
      * If the entry should only be visible to authenticated user
      */
    def `private`: SelectionBuilder[MediaList, Option[Boolean]] =
      Field("private", OptionOf(Scalar()))

    /**
      * The amount of episodes/chapters consumed by the user
      */
    def progress: SelectionBuilder[MediaList, Option[Int]] =
      Field("progress", OptionOf(Scalar()))

    /**
      * The amount of volumes read by the user
      */
    def progressVolumes: SelectionBuilder[MediaList, Option[Int]] =
      Field("progressVolumes", OptionOf(Scalar()))

    /**
      * The amount of times the user has rewatched/read the media
      */
    def repeat: SelectionBuilder[MediaList, Option[Int]] =
      Field("repeat", OptionOf(Scalar()))

    /**
      * The score of the entry
      */
    def score(
        format: Option[ScoreFormat] = None
    ): SelectionBuilder[MediaList, Option[Double]] =
      Field(
        "score",
        OptionOf(Scalar()),
        arguments = List(Argument("format", format))
      )

    /**
      * When the entry was started by the user
      */
    def startedAt[A](
        innerSelection: SelectionBuilder[FuzzyDate, A]
    ): SelectionBuilder[MediaList, Option[A]] =
      Field("startedAt", OptionOf(Obj(innerSelection)))

    /**
      * The watching/reading status
      */
    def status: SelectionBuilder[MediaList, Option[MediaListStatus]] =
      Field("status", OptionOf(Scalar()))

    /**
      * When the entry data was last updated
      */
    def updatedAt: SelectionBuilder[MediaList, Option[Int]] =
      Field("updatedAt", OptionOf(Scalar()))
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[MediaList, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))

    /**
      * The id of the user owner of the list entry
      */
    def userId: SelectionBuilder[MediaList, Int] = Field("userId", Scalar())
  }

  type MediaListCollection
  object MediaListCollection {

    /**
      * A map of media list entry arrays grouped by custom lists
      */
    @deprecated("Not GraphQL spec compliant, use lists field instead.", "")
    def customLists[A](asArray: Option[Boolean] = None)(
        innerSelection: SelectionBuilder[MediaList, A]
    ): SelectionBuilder[MediaListCollection, Option[
      List[Option[List[Option[A]]]]
    ]] =
      Field(
        "customLists",
        OptionOf(ListOf(OptionOf(ListOf(OptionOf(Obj(innerSelection)))))),
        arguments = List(Argument("asArray", asArray))
      )

    /**
      * If there is another chunk
      */
    def hasNextChunk: SelectionBuilder[MediaListCollection, Option[Boolean]] =
      Field("hasNextChunk", OptionOf(Scalar()))

    /**
      * Grouped media list entries
      */
    def lists[A](
        innerSelection: SelectionBuilder[MediaListGroup, A]
    ): SelectionBuilder[MediaListCollection, Option[List[Option[A]]]] =
      Field("lists", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A map of media list entry arrays grouped by status
      */
    @deprecated("Not GraphQL spec compliant, use lists field instead.", "")
    def statusLists[A](asArray: Option[Boolean] = None)(
        innerSelection: SelectionBuilder[MediaList, A]
    ): SelectionBuilder[MediaListCollection, Option[
      List[Option[List[Option[A]]]]
    ]] =
      Field(
        "statusLists",
        OptionOf(ListOf(OptionOf(ListOf(OptionOf(Obj(innerSelection)))))),
        arguments = List(Argument("asArray", asArray))
      )

    /**
      * The owner of the list
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[MediaListCollection, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))
  }

  type MediaListGroup
  object MediaListGroup {

    /**
      * Media list entries
      */
    def entries[A](
        innerSelection: SelectionBuilder[MediaList, A]
    ): SelectionBuilder[MediaListGroup, Option[List[Option[A]]]] =
      Field("entries", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def isCustomList: SelectionBuilder[MediaListGroup, Option[Boolean]] =
      Field("isCustomList", OptionOf(Scalar()))
    def isSplitCompletedList
        : SelectionBuilder[MediaListGroup, Option[Boolean]] =
      Field("isSplitCompletedList", OptionOf(Scalar()))
    def name: SelectionBuilder[MediaListGroup, Option[String]] =
      Field("name", OptionOf(Scalar()))
    def status: SelectionBuilder[MediaListGroup, Option[MediaListStatus]] =
      Field("status", OptionOf(Scalar()))
  }

  type MediaListOptions
  object MediaListOptions {

    /**
      * The user's anime list options
      */
    def animeList[A](
        innerSelection: SelectionBuilder[MediaListTypeOptions, A]
    ): SelectionBuilder[MediaListOptions, Option[A]] =
      Field("animeList", OptionOf(Obj(innerSelection)))

    /**
      * The user's manga list options
      */
    def mangaList[A](
        innerSelection: SelectionBuilder[MediaListTypeOptions, A]
    ): SelectionBuilder[MediaListOptions, Option[A]] =
      Field("mangaList", OptionOf(Obj(innerSelection)))

    /**
      * The default order list rows should be displayed in
      */
    def rowOrder: SelectionBuilder[MediaListOptions, Option[String]] =
      Field("rowOrder", OptionOf(Scalar()))

    /**
      * The score format the user is using for media lists
      */
    def scoreFormat: SelectionBuilder[MediaListOptions, Option[ScoreFormat]] =
      Field("scoreFormat", OptionOf(Scalar()))

    /**
      * The list theme options for both lists
      */
    @deprecated("No longer used", "")
    def sharedTheme: SelectionBuilder[MediaListOptions, Option[Json]] =
      Field("sharedTheme", OptionOf(Scalar()))

    /**
      * If the shared theme should be used instead of the individual list themes
      */
    @deprecated("No longer used", "")
    def sharedThemeEnabled
        : SelectionBuilder[MediaListOptions, Option[Boolean]] =
      Field("sharedThemeEnabled", OptionOf(Scalar()))

    /**
      * (Site only) If the user should be using legacy css-supporting list versions
      */
    def useLegacyLists: SelectionBuilder[MediaListOptions, Option[Boolean]] =
      Field("useLegacyLists", OptionOf(Scalar()))
  }

  type MediaListTypeOptions
  object MediaListTypeOptions {

    /**
      * The names of the user's advanced scoring sections
      */
    def advancedScoring
        : SelectionBuilder[MediaListTypeOptions, Option[List[Option[String]]]] =
      Field("advancedScoring", OptionOf(ListOf(OptionOf(Scalar()))))

    /**
      * If advanced scoring is enabled
      */
    def advancedScoringEnabled
        : SelectionBuilder[MediaListTypeOptions, Option[Boolean]] =
      Field("advancedScoringEnabled", OptionOf(Scalar()))

    /**
      * The names of the user's custom lists
      */
    def customLists
        : SelectionBuilder[MediaListTypeOptions, Option[List[Option[String]]]] =
      Field("customLists", OptionOf(ListOf(OptionOf(Scalar()))))

    /**
      * The order each list should be displayed in
      */
    def sectionOrder
        : SelectionBuilder[MediaListTypeOptions, Option[List[Option[String]]]] =
      Field("sectionOrder", OptionOf(ListOf(OptionOf(Scalar()))))

    /**
      * If the completed sections of the list should be separated by format
      */
    def splitCompletedSectionByFormat
        : SelectionBuilder[MediaListTypeOptions, Option[Boolean]] =
      Field("splitCompletedSectionByFormat", OptionOf(Scalar()))

    /**
      * The list theme options
      */
    @deprecated(
      "This field has not yet been fully implemented and may change without warning",
      ""
    )
    def theme: SelectionBuilder[MediaListTypeOptions, Option[Json]] =
      Field("theme", OptionOf(Scalar()))
  }

  type MediaRank
  object MediaRank {

    /**
      * If the ranking is based on all time instead of a season/year
      */
    def allTime: SelectionBuilder[MediaRank, Option[Boolean]] =
      Field("allTime", OptionOf(Scalar()))

    /**
      * String that gives context to the ranking type and time span
      */
    def context: SelectionBuilder[MediaRank, String] =
      Field("context", Scalar())

    /**
      * The format the media is ranked within
      */
    def format: SelectionBuilder[MediaRank, MediaFormat] =
      Field("format", Scalar())

    /**
      * The id of the rank
      */
    def id: SelectionBuilder[MediaRank, Int] = Field("id", Scalar())

    /**
      * The numerical rank of the media
      */
    def rank: SelectionBuilder[MediaRank, Int] = Field("rank", Scalar())

    /**
      * The season the media is ranked within
      */
    def season: SelectionBuilder[MediaRank, Option[MediaSeason]] =
      Field("season", OptionOf(Scalar()))

    /**
      * The type of ranking
      */
    def `type`: SelectionBuilder[MediaRank, MediaRankType] =
      Field("type", Scalar())

    /**
      * The year the media is ranked within
      */
    def year: SelectionBuilder[MediaRank, Option[Int]] =
      Field("year", OptionOf(Scalar()))
  }

  type MediaStats
  object MediaStats {
    @deprecated("Replaced by MediaTrends", "")
    def airingProgression[A](
        innerSelection: SelectionBuilder[AiringProgression, A]
    ): SelectionBuilder[MediaStats, Option[List[Option[A]]]] =
      Field(
        "airingProgression",
        OptionOf(ListOf(OptionOf(Obj(innerSelection))))
      )
    def scoreDistribution[A](
        innerSelection: SelectionBuilder[ScoreDistribution, A]
    ): SelectionBuilder[MediaStats, Option[List[Option[A]]]] =
      Field(
        "scoreDistribution",
        OptionOf(ListOf(OptionOf(Obj(innerSelection))))
      )
    def statusDistribution[A](
        innerSelection: SelectionBuilder[StatusDistribution, A]
    ): SelectionBuilder[MediaStats, Option[List[Option[A]]]] =
      Field(
        "statusDistribution",
        OptionOf(ListOf(OptionOf(Obj(innerSelection))))
      )
  }

  type MediaStreamingEpisode
  object MediaStreamingEpisode {

    /**
      * The site location of the streaming episodes
      */
    def site: SelectionBuilder[MediaStreamingEpisode, Option[String]] =
      Field("site", OptionOf(Scalar()))

    /**
      * Url of episode image thumbnail
      */
    def thumbnail: SelectionBuilder[MediaStreamingEpisode, Option[String]] =
      Field("thumbnail", OptionOf(Scalar()))

    /**
      * Title of the episode
      */
    def title: SelectionBuilder[MediaStreamingEpisode, Option[String]] =
      Field("title", OptionOf(Scalar()))

    /**
      * The url of the episode
      */
    def url: SelectionBuilder[MediaStreamingEpisode, Option[String]] =
      Field("url", OptionOf(Scalar()))
  }

  type MediaSubmission
  object MediaSubmission {
    def changes
        : SelectionBuilder[MediaSubmission, Option[List[Option[String]]]] =
      Field("changes", OptionOf(ListOf(OptionOf(Scalar()))))
    def characters[A](
        innerSelection: SelectionBuilder[MediaSubmissionComparison, A]
    ): SelectionBuilder[MediaSubmission, Option[List[Option[A]]]] =
      Field("characters", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def createdAt: SelectionBuilder[MediaSubmission, Option[Int]] =
      Field("createdAt", OptionOf(Scalar()))
    def externalLinks[A](
        innerSelection: SelectionBuilder[MediaExternalLink, A]
    ): SelectionBuilder[MediaSubmission, Option[List[Option[A]]]] =
      Field("externalLinks", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The id of the submission
      */
    def id: SelectionBuilder[MediaSubmission, Int] = Field("id", Scalar())
    def media[A](
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[MediaSubmission, Option[A]] =
      Field("media", OptionOf(Obj(innerSelection)))
    def notes: SelectionBuilder[MediaSubmission, Option[String]] =
      Field("notes", OptionOf(Scalar()))
    def relations[A](
        innerSelection: SelectionBuilder[MediaEdge, A]
    ): SelectionBuilder[MediaSubmission, Option[List[Option[A]]]] =
      Field("relations", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def source: SelectionBuilder[MediaSubmission, Option[String]] =
      Field("source", OptionOf(Scalar()))
    def staff[A](
        innerSelection: SelectionBuilder[MediaSubmissionComparison, A]
    ): SelectionBuilder[MediaSubmission, Option[List[Option[A]]]] =
      Field("staff", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Status of the submission
      */
    def status: SelectionBuilder[MediaSubmission, Option[SubmissionStatus]] =
      Field("status", OptionOf(Scalar()))
    def studios[A](
        innerSelection: SelectionBuilder[MediaSubmissionComparison, A]
    ): SelectionBuilder[MediaSubmission, Option[List[Option[A]]]] =
      Field("studios", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def submission[A](
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[MediaSubmission, Option[A]] =
      Field("submission", OptionOf(Obj(innerSelection)))

    /**
      * User submitter of the submission
      */
    def submitter[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[MediaSubmission, Option[A]] =
      Field("submitter", OptionOf(Obj(innerSelection)))
    def submitterStats: SelectionBuilder[MediaSubmission, Option[Json]] =
      Field("submitterStats", OptionOf(Scalar()))
  }

  type MediaSubmissionComparison
  object MediaSubmissionComparison {
    def character[A](
        innerSelection: SelectionBuilder[MediaCharacter, A]
    ): SelectionBuilder[MediaSubmissionComparison, Option[A]] =
      Field("character", OptionOf(Obj(innerSelection)))
    def staff[A](
        innerSelection: SelectionBuilder[StaffEdge, A]
    ): SelectionBuilder[MediaSubmissionComparison, Option[A]] =
      Field("staff", OptionOf(Obj(innerSelection)))
    def studio[A](
        innerSelection: SelectionBuilder[StudioEdge, A]
    ): SelectionBuilder[MediaSubmissionComparison, Option[A]] =
      Field("studio", OptionOf(Obj(innerSelection)))
    def submission[A](
        innerSelection: SelectionBuilder[MediaSubmissionEdge, A]
    ): SelectionBuilder[MediaSubmissionComparison, Option[A]] =
      Field("submission", OptionOf(Obj(innerSelection)))
  }

  type MediaSubmissionEdge
  object MediaSubmissionEdge {
    def character[A](
        innerSelection: SelectionBuilder[Character, A]
    ): SelectionBuilder[MediaSubmissionEdge, Option[A]] =
      Field("character", OptionOf(Obj(innerSelection)))
    def characterRole
        : SelectionBuilder[MediaSubmissionEdge, Option[CharacterRole]] =
      Field("characterRole", OptionOf(Scalar()))
    def characterSubmission[A](
        innerSelection: SelectionBuilder[Character, A]
    ): SelectionBuilder[MediaSubmissionEdge, Option[A]] =
      Field("characterSubmission", OptionOf(Obj(innerSelection)))

    /**
      * The id of the direct submission
      */
    def id: SelectionBuilder[MediaSubmissionEdge, Option[Int]] =
      Field("id", OptionOf(Scalar()))
    def isMain: SelectionBuilder[MediaSubmissionEdge, Option[Boolean]] =
      Field("isMain", OptionOf(Scalar()))
    def media[A](
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[MediaSubmissionEdge, Option[A]] =
      Field("media", OptionOf(Obj(innerSelection)))
    def staff[A](
        innerSelection: SelectionBuilder[Staff, A]
    ): SelectionBuilder[MediaSubmissionEdge, Option[A]] =
      Field("staff", OptionOf(Obj(innerSelection)))
    def staffRole: SelectionBuilder[MediaSubmissionEdge, Option[String]] =
      Field("staffRole", OptionOf(Scalar()))
    def staffSubmission[A](
        innerSelection: SelectionBuilder[Staff, A]
    ): SelectionBuilder[MediaSubmissionEdge, Option[A]] =
      Field("staffSubmission", OptionOf(Obj(innerSelection)))
    def studio[A](
        innerSelection: SelectionBuilder[Studio, A]
    ): SelectionBuilder[MediaSubmissionEdge, Option[A]] =
      Field("studio", OptionOf(Obj(innerSelection)))
    def voiceActor[A](
        innerSelection: SelectionBuilder[Staff, A]
    ): SelectionBuilder[MediaSubmissionEdge, Option[A]] =
      Field("voiceActor", OptionOf(Obj(innerSelection)))
    def voiceActorSubmission[A](
        innerSelection: SelectionBuilder[Staff, A]
    ): SelectionBuilder[MediaSubmissionEdge, Option[A]] =
      Field("voiceActorSubmission", OptionOf(Obj(innerSelection)))
  }

  type MediaTag
  object MediaTag {

    /**
      * The categories of tags this tag belongs to
      */
    def category: SelectionBuilder[MediaTag, Option[String]] =
      Field("category", OptionOf(Scalar()))

    /**
      * A general description of the tag
      */
    def description: SelectionBuilder[MediaTag, Option[String]] =
      Field("description", OptionOf(Scalar()))

    /**
      * The id of the tag
      */
    def id: SelectionBuilder[MediaTag, Int] = Field("id", Scalar())

    /**
      * If the tag is only for adult 18+ media
      */
    def isAdult: SelectionBuilder[MediaTag, Option[Boolean]] =
      Field("isAdult", OptionOf(Scalar()))

    /**
      * If the tag could be a spoiler for any media
      */
    def isGeneralSpoiler: SelectionBuilder[MediaTag, Option[Boolean]] =
      Field("isGeneralSpoiler", OptionOf(Scalar()))

    /**
      * If the tag is a spoiler for this media
      */
    def isMediaSpoiler: SelectionBuilder[MediaTag, Option[Boolean]] =
      Field("isMediaSpoiler", OptionOf(Scalar()))

    /**
      * The name of the tag
      */
    def name: SelectionBuilder[MediaTag, String] = Field("name", Scalar())

    /**
      * The relevance ranking of the tag out of the 100 for this media
      */
    def rank: SelectionBuilder[MediaTag, Option[Int]] =
      Field("rank", OptionOf(Scalar()))
  }

  type MediaTitle
  object MediaTitle {

    /**
      * The official english title
      */
    def english(
        stylised: Option[Boolean] = None
    ): SelectionBuilder[MediaTitle, Option[String]] =
      Field(
        "english",
        OptionOf(Scalar()),
        arguments = List(Argument("stylised", stylised))
      )

    /**
      * Official title in it's native language
      */
    def native(
        stylised: Option[Boolean] = None
    ): SelectionBuilder[MediaTitle, Option[String]] =
      Field(
        "native",
        OptionOf(Scalar()),
        arguments = List(Argument("stylised", stylised))
      )

    /**
      * The romanization of the native language title
      */
    def romaji(
        stylised: Option[Boolean] = None
    ): SelectionBuilder[MediaTitle, Option[String]] =
      Field(
        "romaji",
        OptionOf(Scalar()),
        arguments = List(Argument("stylised", stylised))
      )

    /**
      * The currently authenticated users preferred title language. Default romaji for non-authenticated
      */
    def userPreferred: SelectionBuilder[MediaTitle, Option[String]] =
      Field("userPreferred", OptionOf(Scalar()))
  }

  type MediaTrailer
  object MediaTrailer {

    /**
      * The trailer video id
      */
    def id: SelectionBuilder[MediaTrailer, Option[String]] =
      Field("id", OptionOf(Scalar()))

    /**
      * The site the video is hosted by (Currently either youtube or dailymotion)
      */
    def site: SelectionBuilder[MediaTrailer, Option[String]] =
      Field("site", OptionOf(Scalar()))

    /**
      * The url for the thumbnail image of the video
      */
    def thumbnail: SelectionBuilder[MediaTrailer, Option[String]] =
      Field("thumbnail", OptionOf(Scalar()))
  }

  type MediaTrend
  object MediaTrend {

    /**
      * A weighted average score of all the user's scores of the media
      */
    def averageScore: SelectionBuilder[MediaTrend, Option[Int]] =
      Field("averageScore", OptionOf(Scalar()))

    /**
      * The day the data was recorded (timestamp)
      */
    def date: SelectionBuilder[MediaTrend, Int] = Field("date", Scalar())

    /**
      * The episode number of the anime released on this day
      */
    def episode: SelectionBuilder[MediaTrend, Option[Int]] =
      Field("episode", OptionOf(Scalar()))

    /**
      * The number of users with watching/reading the media
      */
    def inProgress: SelectionBuilder[MediaTrend, Option[Int]] =
      Field("inProgress", OptionOf(Scalar()))

    /**
      * The related media
      */
    def media[A](
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[MediaTrend, Option[A]] =
      Field("media", OptionOf(Obj(innerSelection)))

    /**
      * The id of the tag
      */
    def mediaId: SelectionBuilder[MediaTrend, Int] = Field("mediaId", Scalar())

    /**
      * The number of users with the media on their list
      */
    def popularity: SelectionBuilder[MediaTrend, Option[Int]] =
      Field("popularity", OptionOf(Scalar()))

    /**
      * If the media was being released at this time
      */
    def releasing: SelectionBuilder[MediaTrend, Boolean] =
      Field("releasing", Scalar())

    /**
      * The amount of media activity on the day
      */
    def trending: SelectionBuilder[MediaTrend, Int] =
      Field("trending", Scalar())
  }

  type MediaTrendConnection
  object MediaTrendConnection {
    def edges[A](
        innerSelection: SelectionBuilder[MediaTrendEdge, A]
    ): SelectionBuilder[MediaTrendConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def nodes[A](
        innerSelection: SelectionBuilder[MediaTrend, A]
    ): SelectionBuilder[MediaTrendConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The pagination information
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[MediaTrendConnection, Option[A]] =
      Field("pageInfo", OptionOf(Obj(innerSelection)))
  }

  type MediaTrendEdge
  object MediaTrendEdge {
    def node[A](
        innerSelection: SelectionBuilder[MediaTrend, A]
    ): SelectionBuilder[MediaTrendEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type MessageActivity
  object MessageActivity {

    /**
      * The time the activity was created at
      */
    def createdAt: SelectionBuilder[MessageActivity, Int] =
      Field("createdAt", Scalar())

    /**
      * The id of the activity
      */
    def id: SelectionBuilder[MessageActivity, Int] = Field("id", Scalar())

    /**
      * If the currently authenticated user liked the activity
      */
    def isLiked: SelectionBuilder[MessageActivity, Option[Boolean]] =
      Field("isLiked", OptionOf(Scalar()))

    /**
      * If the activity is locked and can receive replies
      */
    def isLocked: SelectionBuilder[MessageActivity, Option[Boolean]] =
      Field("isLocked", OptionOf(Scalar()))

    /**
      * If the message is private and only viewable to the sender and recipients
      */
    def isPrivate: SelectionBuilder[MessageActivity, Option[Boolean]] =
      Field("isPrivate", OptionOf(Scalar()))

    /**
      * If the currently authenticated user is subscribed to the activity
      */
    def isSubscribed: SelectionBuilder[MessageActivity, Option[Boolean]] =
      Field("isSubscribed", OptionOf(Scalar()))

    /**
      * The amount of likes the activity has
      */
    def likeCount: SelectionBuilder[MessageActivity, Int] =
      Field("likeCount", Scalar())

    /**
      * The users who liked the activity
      */
    def likes[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[MessageActivity, Option[List[Option[A]]]] =
      Field("likes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The message text (Markdown)
      */
    def message(
        asHtml: Option[Boolean] = None
    ): SelectionBuilder[MessageActivity, Option[String]] =
      Field(
        "message",
        OptionOf(Scalar()),
        arguments = List(Argument("asHtml", asHtml))
      )

    /**
      * The user who sent the activity message
      */
    def messenger[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[MessageActivity, Option[A]] =
      Field("messenger", OptionOf(Obj(innerSelection)))

    /**
      * The user id of the activity's sender
      */
    def messengerId: SelectionBuilder[MessageActivity, Option[Int]] =
      Field("messengerId", OptionOf(Scalar()))

    /**
      * The user who the activity message was sent to
      */
    def recipient[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[MessageActivity, Option[A]] =
      Field("recipient", OptionOf(Obj(innerSelection)))

    /**
      * The user id of the activity's recipient
      */
    def recipientId: SelectionBuilder[MessageActivity, Option[Int]] =
      Field("recipientId", OptionOf(Scalar()))

    /**
      * The written replies to the activity
      */
    def replies[A](
        innerSelection: SelectionBuilder[ActivityReply, A]
    ): SelectionBuilder[MessageActivity, Option[List[Option[A]]]] =
      Field("replies", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The number of activity replies
      */
    def replyCount: SelectionBuilder[MessageActivity, Int] =
      Field("replyCount", Scalar())

    /**
      * The url for the activity page on the AniList website
      */
    def siteUrl: SelectionBuilder[MessageActivity, Option[String]] =
      Field("siteUrl", OptionOf(Scalar()))

    /**
      * The type of the activity
      */
    def `type`: SelectionBuilder[MessageActivity, Option[ActivityType]] =
      Field("type", OptionOf(Scalar()))
  }

  type ModAction
  object ModAction {
    def createdAt: SelectionBuilder[ModAction, Int] =
      Field("createdAt", Scalar())
    def data: SelectionBuilder[ModAction, Option[String]] =
      Field("data", OptionOf(Scalar()))

    /**
      * The id of the action
      */
    def id: SelectionBuilder[ModAction, Int] = Field("id", Scalar())
    def mod[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ModAction, Option[A]] =
      Field("mod", OptionOf(Obj(innerSelection)))
    def objectId: SelectionBuilder[ModAction, Option[Int]] =
      Field("objectId", OptionOf(Scalar()))
    def objectType: SelectionBuilder[ModAction, Option[String]] =
      Field("objectType", OptionOf(Scalar()))
    def `type`: SelectionBuilder[ModAction, Option[ModActionType]] =
      Field("type", OptionOf(Scalar()))
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ModAction, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))
  }

  type NotificationOption
  object NotificationOption {

    /**
      * Whether this type of notification is enabled
      */
    def enabled: SelectionBuilder[NotificationOption, Option[Boolean]] =
      Field("enabled", OptionOf(Scalar()))

    /**
      * The type of notification
      */
    def `type`: SelectionBuilder[NotificationOption, Option[NotificationType]] =
      Field("type", OptionOf(Scalar()))
  }

  type Page
  object Page {
    def activities[A](
        createdAt: Option[Int] = None,
        createdAt_greater: Option[Int] = None,
        createdAt_lesser: Option[Int] = None,
        hasReplies: Option[Boolean] = None,
        hasRepliesOrTypeText: Option[Boolean] = None,
        id: Option[Int] = None,
        id_in: Option[List[Option[Int]]] = None,
        id_not: Option[Int] = None,
        id_not_in: Option[List[Option[Int]]] = None,
        isFollowing: Option[Boolean] = None,
        mediaId: Option[Int] = None,
        mediaId_in: Option[List[Option[Int]]] = None,
        mediaId_not: Option[Int] = None,
        mediaId_not_in: Option[List[Option[Int]]] = None,
        messengerId: Option[Int] = None,
        messengerId_in: Option[List[Option[Int]]] = None,
        messengerId_not: Option[Int] = None,
        messengerId_not_in: Option[List[Option[Int]]] = None,
        sort: Option[List[Option[ActivitySort]]] = None,
        `type`: Option[ActivityType] = None,
        type_in: Option[List[Option[ActivityType]]] = None,
        type_not: Option[ActivityType] = None,
        type_not_in: Option[List[Option[ActivityType]]] = None,
        userId: Option[Int] = None,
        userId_in: Option[List[Option[Int]]] = None,
        userId_not: Option[Int] = None,
        userId_not_in: Option[List[Option[Int]]] = None
    )(
        onListActivity: SelectionBuilder[ListActivity, A],
        onMessageActivity: SelectionBuilder[MessageActivity, A],
        onTextActivity: SelectionBuilder[TextActivity, A]
    ): SelectionBuilder[Page, Option[List[Option[A]]]] =
      Field(
        "activities",
        OptionOf(
          ListOf(
            OptionOf(
              ChoiceOf(
                Map(
                  "ListActivity" -> Obj(onListActivity),
                  "MessageActivity" -> Obj(onMessageActivity),
                  "TextActivity" -> Obj(onTextActivity)
                )
              )
            )
          )
        ),
        arguments = List(
          Argument("createdAt", createdAt),
          Argument("createdAt_greater", createdAt_greater),
          Argument("createdAt_lesser", createdAt_lesser),
          Argument("hasReplies", hasReplies),
          Argument("hasRepliesOrTypeText", hasRepliesOrTypeText),
          Argument("id", id),
          Argument("id_in", id_in),
          Argument("id_not", id_not),
          Argument("id_not_in", id_not_in),
          Argument("isFollowing", isFollowing),
          Argument("mediaId", mediaId),
          Argument("mediaId_in", mediaId_in),
          Argument("mediaId_not", mediaId_not),
          Argument("mediaId_not_in", mediaId_not_in),
          Argument("messengerId", messengerId),
          Argument("messengerId_in", messengerId_in),
          Argument("messengerId_not", messengerId_not),
          Argument("messengerId_not_in", messengerId_not_in),
          Argument("sort", sort),
          Argument("type", `type`),
          Argument("type_in", type_in),
          Argument("type_not", type_not),
          Argument("type_not_in", type_not_in),
          Argument("userId", userId),
          Argument("userId_in", userId_in),
          Argument("userId_not", userId_not),
          Argument("userId_not_in", userId_not_in)
        )
      )
    def activityReplies[A](
        activityId: Option[Int] = None,
        id: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[ActivityReply, A]
    ): SelectionBuilder[Page, Option[List[Option[A]]]] =
      Field(
        "activityReplies",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("activityId", activityId), Argument("id", id))
      )
    def airingSchedules[A](
        airingAt: Option[Int] = None,
        airingAt_greater: Option[Int] = None,
        airingAt_lesser: Option[Int] = None,
        episode: Option[Int] = None,
        episode_greater: Option[Int] = None,
        episode_in: Option[List[Option[Int]]] = None,
        episode_lesser: Option[Int] = None,
        episode_not: Option[Int] = None,
        episode_not_in: Option[List[Option[Int]]] = None,
        id: Option[Int] = None,
        id_in: Option[List[Option[Int]]] = None,
        id_not: Option[Int] = None,
        id_not_in: Option[List[Option[Int]]] = None,
        mediaId: Option[Int] = None,
        mediaId_in: Option[List[Option[Int]]] = None,
        mediaId_not: Option[Int] = None,
        mediaId_not_in: Option[List[Option[Int]]] = None,
        notYetAired: Option[Boolean] = None,
        sort: Option[List[Option[AiringSort]]] = None
    )(
        innerSelection: SelectionBuilder[AiringSchedule, A]
    ): SelectionBuilder[Page, Option[List[Option[A]]]] =
      Field(
        "airingSchedules",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("airingAt", airingAt),
          Argument("airingAt_greater", airingAt_greater),
          Argument("airingAt_lesser", airingAt_lesser),
          Argument("episode", episode),
          Argument("episode_greater", episode_greater),
          Argument("episode_in", episode_in),
          Argument("episode_lesser", episode_lesser),
          Argument("episode_not", episode_not),
          Argument("episode_not_in", episode_not_in),
          Argument("id", id),
          Argument("id_in", id_in),
          Argument("id_not", id_not),
          Argument("id_not_in", id_not_in),
          Argument("mediaId", mediaId),
          Argument("mediaId_in", mediaId_in),
          Argument("mediaId_not", mediaId_not),
          Argument("mediaId_not_in", mediaId_not_in),
          Argument("notYetAired", notYetAired),
          Argument("sort", sort)
        )
      )
    def characters[A](
        id: Option[Int] = None,
        id_in: Option[List[Option[Int]]] = None,
        id_not: Option[Int] = None,
        id_not_in: Option[List[Option[Int]]] = None,
        search: Option[String] = None,
        sort: Option[List[Option[CharacterSort]]] = None
    )(
        innerSelection: SelectionBuilder[Character, A]
    ): SelectionBuilder[Page, Option[List[Option[A]]]] =
      Field(
        "characters",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("id", id),
          Argument("id_in", id_in),
          Argument("id_not", id_not),
          Argument("id_not_in", id_not_in),
          Argument("search", search),
          Argument("sort", sort)
        )
      )
    def followers[A](sort: Option[List[Option[UserSort]]] = None, userId: Int)(
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Page, Option[List[Option[A]]]] =
      Field(
        "followers",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("sort", sort), Argument("userId", userId))
      )
    def following[A](sort: Option[List[Option[UserSort]]] = None, userId: Int)(
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Page, Option[List[Option[A]]]] =
      Field(
        "following",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("sort", sort), Argument("userId", userId))
      )
    def likes[A](
        likeableId: Option[Int] = None,
        `type`: Option[LikeableType] = None
    )(
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Page, Option[List[Option[A]]]] =
      Field(
        "likes",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments =
          List(Argument("likeableId", likeableId), Argument("type", `type`))
      )
    def media[A](
        averageScore: Option[Int] = None,
        averageScore_greater: Option[Int] = None,
        averageScore_lesser: Option[Int] = None,
        averageScore_not: Option[Int] = None,
        chapters: Option[Int] = None,
        chapters_greater: Option[Int] = None,
        chapters_lesser: Option[Int] = None,
        countryOfOrigin: Option[CountryCode] = None,
        duration: Option[Int] = None,
        duration_greater: Option[Int] = None,
        duration_lesser: Option[Int] = None,
        endDate: Option[FuzzyDateInt] = None,
        endDate_greater: Option[FuzzyDateInt] = None,
        endDate_lesser: Option[FuzzyDateInt] = None,
        endDate_like: Option[String] = None,
        episodes: Option[Int] = None,
        episodes_greater: Option[Int] = None,
        episodes_lesser: Option[Int] = None,
        format: Option[MediaFormat] = None,
        format_in: Option[List[Option[MediaFormat]]] = None,
        format_not: Option[MediaFormat] = None,
        format_not_in: Option[List[Option[MediaFormat]]] = None,
        genre: Option[String] = None,
        genre_in: Option[List[Option[String]]] = None,
        genre_not_in: Option[List[Option[String]]] = None,
        id: Option[Int] = None,
        idMal: Option[Int] = None,
        idMal_in: Option[List[Option[Int]]] = None,
        idMal_not: Option[Int] = None,
        idMal_not_in: Option[List[Option[Int]]] = None,
        id_in: Option[List[Option[Int]]] = None,
        id_not: Option[Int] = None,
        id_not_in: Option[List[Option[Int]]] = None,
        isAdult: Option[Boolean] = None,
        licensedBy: Option[String] = None,
        licensedBy_in: Option[List[Option[String]]] = None,
        minimumTagRank: Option[Int] = None,
        onList: Option[Boolean] = None,
        popularity: Option[Int] = None,
        popularity_greater: Option[Int] = None,
        popularity_lesser: Option[Int] = None,
        popularity_not: Option[Int] = None,
        search: Option[String] = None,
        season: Option[MediaSeason] = None,
        seasonYear: Option[Int] = None,
        sort: Option[List[Option[MediaSort]]] = None,
        source: Option[MediaSource] = None,
        source_in: Option[List[Option[MediaSource]]] = None,
        startDate: Option[FuzzyDateInt] = None,
        startDate_greater: Option[FuzzyDateInt] = None,
        startDate_lesser: Option[FuzzyDateInt] = None,
        startDate_like: Option[String] = None,
        status: Option[MediaStatus] = None,
        status_in: Option[List[Option[MediaStatus]]] = None,
        status_not: Option[MediaStatus] = None,
        status_not_in: Option[List[Option[MediaStatus]]] = None,
        tag: Option[String] = None,
        tagCategory: Option[String] = None,
        tagCategory_in: Option[List[Option[String]]] = None,
        tagCategory_not_in: Option[List[Option[String]]] = None,
        tag_in: Option[List[Option[String]]] = None,
        tag_not_in: Option[List[Option[String]]] = None,
        `type`: Option[MediaType] = None,
        volumes: Option[Int] = None,
        volumes_greater: Option[Int] = None,
        volumes_lesser: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[Page, Option[List[Option[A]]]] =
      Field(
        "media",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("averageScore", averageScore),
          Argument("averageScore_greater", averageScore_greater),
          Argument("averageScore_lesser", averageScore_lesser),
          Argument("averageScore_not", averageScore_not),
          Argument("chapters", chapters),
          Argument("chapters_greater", chapters_greater),
          Argument("chapters_lesser", chapters_lesser),
          Argument("countryOfOrigin", countryOfOrigin),
          Argument("duration", duration),
          Argument("duration_greater", duration_greater),
          Argument("duration_lesser", duration_lesser),
          Argument("endDate", endDate),
          Argument("endDate_greater", endDate_greater),
          Argument("endDate_lesser", endDate_lesser),
          Argument("endDate_like", endDate_like),
          Argument("episodes", episodes),
          Argument("episodes_greater", episodes_greater),
          Argument("episodes_lesser", episodes_lesser),
          Argument("format", format),
          Argument("format_in", format_in),
          Argument("format_not", format_not),
          Argument("format_not_in", format_not_in),
          Argument("genre", genre),
          Argument("genre_in", genre_in),
          Argument("genre_not_in", genre_not_in),
          Argument("id", id),
          Argument("idMal", idMal),
          Argument("idMal_in", idMal_in),
          Argument("idMal_not", idMal_not),
          Argument("idMal_not_in", idMal_not_in),
          Argument("id_in", id_in),
          Argument("id_not", id_not),
          Argument("id_not_in", id_not_in),
          Argument("isAdult", isAdult),
          Argument("licensedBy", licensedBy),
          Argument("licensedBy_in", licensedBy_in),
          Argument("minimumTagRank", minimumTagRank),
          Argument("onList", onList),
          Argument("popularity", popularity),
          Argument("popularity_greater", popularity_greater),
          Argument("popularity_lesser", popularity_lesser),
          Argument("popularity_not", popularity_not),
          Argument("search", search),
          Argument("season", season),
          Argument("seasonYear", seasonYear),
          Argument("sort", sort),
          Argument("source", source),
          Argument("source_in", source_in),
          Argument("startDate", startDate),
          Argument("startDate_greater", startDate_greater),
          Argument("startDate_lesser", startDate_lesser),
          Argument("startDate_like", startDate_like),
          Argument("status", status),
          Argument("status_in", status_in),
          Argument("status_not", status_not),
          Argument("status_not_in", status_not_in),
          Argument("tag", tag),
          Argument("tagCategory", tagCategory),
          Argument("tagCategory_in", tagCategory_in),
          Argument("tagCategory_not_in", tagCategory_not_in),
          Argument("tag_in", tag_in),
          Argument("tag_not_in", tag_not_in),
          Argument("type", `type`),
          Argument("volumes", volumes),
          Argument("volumes_greater", volumes_greater),
          Argument("volumes_lesser", volumes_lesser)
        )
      )
    def mediaList[A](
        compareWithAuthList: Option[Boolean] = None,
        completedAt: Option[FuzzyDateInt] = None,
        completedAt_greater: Option[FuzzyDateInt] = None,
        completedAt_lesser: Option[FuzzyDateInt] = None,
        completedAt_like: Option[String] = None,
        id: Option[Int] = None,
        isFollowing: Option[Boolean] = None,
        mediaId: Option[Int] = None,
        mediaId_in: Option[List[Option[Int]]] = None,
        mediaId_not_in: Option[List[Option[Int]]] = None,
        notes: Option[String] = None,
        notes_like: Option[String] = None,
        sort: Option[List[Option[MediaListSort]]] = None,
        startedAt: Option[FuzzyDateInt] = None,
        startedAt_greater: Option[FuzzyDateInt] = None,
        startedAt_lesser: Option[FuzzyDateInt] = None,
        startedAt_like: Option[String] = None,
        status: Option[MediaListStatus] = None,
        status_in: Option[List[Option[MediaListStatus]]] = None,
        status_not: Option[MediaListStatus] = None,
        status_not_in: Option[List[Option[MediaListStatus]]] = None,
        `type`: Option[MediaType] = None,
        userId: Option[Int] = None,
        userId_in: Option[List[Option[Int]]] = None,
        userName: Option[String] = None
    )(
        innerSelection: SelectionBuilder[MediaList, A]
    ): SelectionBuilder[Page, Option[List[Option[A]]]] =
      Field(
        "mediaList",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("compareWithAuthList", compareWithAuthList),
          Argument("completedAt", completedAt),
          Argument("completedAt_greater", completedAt_greater),
          Argument("completedAt_lesser", completedAt_lesser),
          Argument("completedAt_like", completedAt_like),
          Argument("id", id),
          Argument("isFollowing", isFollowing),
          Argument("mediaId", mediaId),
          Argument("mediaId_in", mediaId_in),
          Argument("mediaId_not_in", mediaId_not_in),
          Argument("notes", notes),
          Argument("notes_like", notes_like),
          Argument("sort", sort),
          Argument("startedAt", startedAt),
          Argument("startedAt_greater", startedAt_greater),
          Argument("startedAt_lesser", startedAt_lesser),
          Argument("startedAt_like", startedAt_like),
          Argument("status", status),
          Argument("status_in", status_in),
          Argument("status_not", status_not),
          Argument("status_not_in", status_not_in),
          Argument("type", `type`),
          Argument("userId", userId),
          Argument("userId_in", userId_in),
          Argument("userName", userName)
        )
      )
    def mediaTrends[A](
        averageScore: Option[Int] = None,
        averageScore_greater: Option[Int] = None,
        averageScore_lesser: Option[Int] = None,
        averageScore_not: Option[Int] = None,
        date: Option[Int] = None,
        date_greater: Option[Int] = None,
        date_lesser: Option[Int] = None,
        episode: Option[Int] = None,
        episode_greater: Option[Int] = None,
        episode_lesser: Option[Int] = None,
        episode_not: Option[Int] = None,
        mediaId: Option[Int] = None,
        mediaId_in: Option[List[Option[Int]]] = None,
        mediaId_not: Option[Int] = None,
        mediaId_not_in: Option[List[Option[Int]]] = None,
        popularity: Option[Int] = None,
        popularity_greater: Option[Int] = None,
        popularity_lesser: Option[Int] = None,
        popularity_not: Option[Int] = None,
        releasing: Option[Boolean] = None,
        sort: Option[List[Option[MediaTrendSort]]] = None,
        trending: Option[Int] = None,
        trending_greater: Option[Int] = None,
        trending_lesser: Option[Int] = None,
        trending_not: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[MediaTrend, A]
    ): SelectionBuilder[Page, Option[List[Option[A]]]] =
      Field(
        "mediaTrends",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("averageScore", averageScore),
          Argument("averageScore_greater", averageScore_greater),
          Argument("averageScore_lesser", averageScore_lesser),
          Argument("averageScore_not", averageScore_not),
          Argument("date", date),
          Argument("date_greater", date_greater),
          Argument("date_lesser", date_lesser),
          Argument("episode", episode),
          Argument("episode_greater", episode_greater),
          Argument("episode_lesser", episode_lesser),
          Argument("episode_not", episode_not),
          Argument("mediaId", mediaId),
          Argument("mediaId_in", mediaId_in),
          Argument("mediaId_not", mediaId_not),
          Argument("mediaId_not_in", mediaId_not_in),
          Argument("popularity", popularity),
          Argument("popularity_greater", popularity_greater),
          Argument("popularity_lesser", popularity_lesser),
          Argument("popularity_not", popularity_not),
          Argument("releasing", releasing),
          Argument("sort", sort),
          Argument("trending", trending),
          Argument("trending_greater", trending_greater),
          Argument("trending_lesser", trending_lesser),
          Argument("trending_not", trending_not)
        )
      )
    def notifications[A](
        resetNotificationCount: Option[Boolean] = None,
        `type`: Option[NotificationType] = None,
        type_in: Option[List[Option[NotificationType]]] = None
    )(
        onActivityLikeNotification: SelectionBuilder[
          ActivityLikeNotification,
          A
        ],
        onActivityMentionNotification: SelectionBuilder[
          ActivityMentionNotification,
          A
        ],
        onActivityMessageNotification: SelectionBuilder[
          ActivityMessageNotification,
          A
        ],
        onActivityReplyLikeNotification: SelectionBuilder[
          ActivityReplyLikeNotification,
          A
        ],
        onActivityReplyNotification: SelectionBuilder[
          ActivityReplyNotification,
          A
        ],
        onActivityReplySubscribedNotification: SelectionBuilder[
          ActivityReplySubscribedNotification,
          A
        ],
        onAiringNotification: SelectionBuilder[AiringNotification, A],
        onFollowingNotification: SelectionBuilder[FollowingNotification, A],
        onRelatedMediaAdditionNotification: SelectionBuilder[
          RelatedMediaAdditionNotification,
          A
        ],
        onThreadCommentLikeNotification: SelectionBuilder[
          ThreadCommentLikeNotification,
          A
        ],
        onThreadCommentMentionNotification: SelectionBuilder[
          ThreadCommentMentionNotification,
          A
        ],
        onThreadCommentReplyNotification: SelectionBuilder[
          ThreadCommentReplyNotification,
          A
        ],
        onThreadCommentSubscribedNotification: SelectionBuilder[
          ThreadCommentSubscribedNotification,
          A
        ],
        onThreadLikeNotification: SelectionBuilder[ThreadLikeNotification, A]
    ): SelectionBuilder[Page, Option[List[Option[A]]]] =
      Field(
        "notifications",
        OptionOf(
          ListOf(
            OptionOf(
              ChoiceOf(
                Map(
                  "ActivityLikeNotification" -> Obj(onActivityLikeNotification),
                  "ActivityMentionNotification" -> Obj(
                    onActivityMentionNotification
                  ),
                  "ActivityMessageNotification" -> Obj(
                    onActivityMessageNotification
                  ),
                  "ActivityReplyLikeNotification" -> Obj(
                    onActivityReplyLikeNotification
                  ),
                  "ActivityReplyNotification" -> Obj(
                    onActivityReplyNotification
                  ),
                  "ActivityReplySubscribedNotification" -> Obj(
                    onActivityReplySubscribedNotification
                  ),
                  "AiringNotification" -> Obj(onAiringNotification),
                  "FollowingNotification" -> Obj(onFollowingNotification),
                  "RelatedMediaAdditionNotification" -> Obj(
                    onRelatedMediaAdditionNotification
                  ),
                  "ThreadCommentLikeNotification" -> Obj(
                    onThreadCommentLikeNotification
                  ),
                  "ThreadCommentMentionNotification" -> Obj(
                    onThreadCommentMentionNotification
                  ),
                  "ThreadCommentReplyNotification" -> Obj(
                    onThreadCommentReplyNotification
                  ),
                  "ThreadCommentSubscribedNotification" -> Obj(
                    onThreadCommentSubscribedNotification
                  ),
                  "ThreadLikeNotification" -> Obj(onThreadLikeNotification)
                )
              )
            )
          )
        ),
        arguments = List(
          Argument("resetNotificationCount", resetNotificationCount),
          Argument("type", `type`),
          Argument("type_in", type_in)
        )
      )

    /**
      * The pagination information
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[Page, Option[A]] =
      Field("pageInfo", OptionOf(Obj(innerSelection)))
    def recommendations[A](
        id: Option[Int] = None,
        mediaId: Option[Int] = None,
        mediaRecommendationId: Option[Int] = None,
        onList: Option[Boolean] = None,
        rating: Option[Int] = None,
        rating_greater: Option[Int] = None,
        rating_lesser: Option[Int] = None,
        sort: Option[List[Option[RecommendationSort]]] = None,
        userId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[Recommendation, A]
    ): SelectionBuilder[Page, Option[List[Option[A]]]] =
      Field(
        "recommendations",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("id", id),
          Argument("mediaId", mediaId),
          Argument("mediaRecommendationId", mediaRecommendationId),
          Argument("onList", onList),
          Argument("rating", rating),
          Argument("rating_greater", rating_greater),
          Argument("rating_lesser", rating_lesser),
          Argument("sort", sort),
          Argument("userId", userId)
        )
      )
    def reviews[A](
        id: Option[Int] = None,
        mediaId: Option[Int] = None,
        mediaType: Option[MediaType] = None,
        sort: Option[List[Option[ReviewSort]]] = None,
        userId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[Review, A]
    ): SelectionBuilder[Page, Option[List[Option[A]]]] =
      Field(
        "reviews",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("id", id),
          Argument("mediaId", mediaId),
          Argument("mediaType", mediaType),
          Argument("sort", sort),
          Argument("userId", userId)
        )
      )
    def staff[A](
        id: Option[Int] = None,
        id_in: Option[List[Option[Int]]] = None,
        id_not: Option[Int] = None,
        id_not_in: Option[List[Option[Int]]] = None,
        search: Option[String] = None,
        sort: Option[List[Option[StaffSort]]] = None
    )(
        innerSelection: SelectionBuilder[Staff, A]
    ): SelectionBuilder[Page, Option[List[Option[A]]]] =
      Field(
        "staff",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("id", id),
          Argument("id_in", id_in),
          Argument("id_not", id_not),
          Argument("id_not_in", id_not_in),
          Argument("search", search),
          Argument("sort", sort)
        )
      )
    def studios[A](
        id: Option[Int] = None,
        id_in: Option[List[Option[Int]]] = None,
        id_not: Option[Int] = None,
        id_not_in: Option[List[Option[Int]]] = None,
        search: Option[String] = None,
        sort: Option[List[Option[StudioSort]]] = None
    )(
        innerSelection: SelectionBuilder[Studio, A]
    ): SelectionBuilder[Page, Option[List[Option[A]]]] =
      Field(
        "studios",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("id", id),
          Argument("id_in", id_in),
          Argument("id_not", id_not),
          Argument("id_not_in", id_not_in),
          Argument("search", search),
          Argument("sort", sort)
        )
      )
    def threadComments[A](
        id: Option[Int] = None,
        sort: Option[List[Option[ThreadCommentSort]]] = None,
        threadId: Option[Int] = None,
        userId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[ThreadComment, A]
    ): SelectionBuilder[Page, Option[List[Option[A]]]] =
      Field(
        "threadComments",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("id", id),
          Argument("sort", sort),
          Argument("threadId", threadId),
          Argument("userId", userId)
        )
      )
    def threads[A](
        categoryId: Option[Int] = None,
        id: Option[Int] = None,
        id_in: Option[List[Option[Int]]] = None,
        mediaCategoryId: Option[Int] = None,
        replyUserId: Option[Int] = None,
        search: Option[String] = None,
        sort: Option[List[Option[ThreadSort]]] = None,
        subscribed: Option[Boolean] = None,
        userId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[Thread, A]
    ): SelectionBuilder[Page, Option[List[Option[A]]]] =
      Field(
        "threads",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("categoryId", categoryId),
          Argument("id", id),
          Argument("id_in", id_in),
          Argument("mediaCategoryId", mediaCategoryId),
          Argument("replyUserId", replyUserId),
          Argument("search", search),
          Argument("sort", sort),
          Argument("subscribed", subscribed),
          Argument("userId", userId)
        )
      )
    def users[A](
        id: Option[Int] = None,
        name: Option[String] = None,
        search: Option[String] = None,
        sort: Option[List[Option[UserSort]]] = None
    )(
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Page, Option[List[Option[A]]]] =
      Field(
        "users",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("id", id),
          Argument("name", name),
          Argument("search", search),
          Argument("sort", sort)
        )
      )
  }

  type PageInfo
  object PageInfo {

    /**
      * The current page
      */
    def currentPage: SelectionBuilder[PageInfo, Option[Int]] =
      Field("currentPage", OptionOf(Scalar()))

    /**
      * If there is another page
      */
    def hasNextPage: SelectionBuilder[PageInfo, Option[Boolean]] =
      Field("hasNextPage", OptionOf(Scalar()))

    /**
      * The last page
      */
    def lastPage: SelectionBuilder[PageInfo, Option[Int]] =
      Field("lastPage", OptionOf(Scalar()))

    /**
      * The count on a page
      */
    def perPage: SelectionBuilder[PageInfo, Option[Int]] =
      Field("perPage", OptionOf(Scalar()))

    /**
      * The total number of items
      */
    def total: SelectionBuilder[PageInfo, Option[Int]] =
      Field("total", OptionOf(Scalar()))
  }

  type ParsedMarkdown
  object ParsedMarkdown {

    /**
      * The parsed markdown as html
      */
    def html: SelectionBuilder[ParsedMarkdown, Option[String]] =
      Field("html", OptionOf(Scalar()))
  }

  type Recommendation
  object Recommendation {

    /**
      * The id of the recommendation
      */
    def id: SelectionBuilder[Recommendation, Int] = Field("id", Scalar())

    /**
      * The media the recommendation is from
      */
    def media[A](
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[Recommendation, Option[A]] =
      Field("media", OptionOf(Obj(innerSelection)))

    /**
      * The recommended media
      */
    def mediaRecommendation[A](
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[Recommendation, Option[A]] =
      Field("mediaRecommendation", OptionOf(Obj(innerSelection)))

    /**
      * Users rating of the recommendation
      */
    def rating: SelectionBuilder[Recommendation, Option[Int]] =
      Field("rating", OptionOf(Scalar()))

    /**
      * The user that first created the recommendation
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Recommendation, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))

    /**
      * The rating of the recommendation by currently authenticated user
      */
    def userRating
        : SelectionBuilder[Recommendation, Option[RecommendationRating]] =
      Field("userRating", OptionOf(Scalar()))
  }

  type RecommendationConnection
  object RecommendationConnection {
    def edges[A](
        innerSelection: SelectionBuilder[RecommendationEdge, A]
    ): SelectionBuilder[RecommendationConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def nodes[A](
        innerSelection: SelectionBuilder[Recommendation, A]
    ): SelectionBuilder[RecommendationConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The pagination information
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[RecommendationConnection, Option[A]] =
      Field("pageInfo", OptionOf(Obj(innerSelection)))
  }

  type RecommendationEdge
  object RecommendationEdge {
    def node[A](
        innerSelection: SelectionBuilder[Recommendation, A]
    ): SelectionBuilder[RecommendationEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type RelatedMediaAdditionNotification
  object RelatedMediaAdditionNotification {

    /**
      * The notification context text
      */
    def context
        : SelectionBuilder[RelatedMediaAdditionNotification, Option[String]] =
      Field("context", OptionOf(Scalar()))

    /**
      * The time the notification was created at
      */
    def createdAt
        : SelectionBuilder[RelatedMediaAdditionNotification, Option[Int]] =
      Field("createdAt", OptionOf(Scalar()))

    /**
      * The id of the Notification
      */
    def id: SelectionBuilder[RelatedMediaAdditionNotification, Int] =
      Field("id", Scalar())

    /**
      * The associated media of the airing schedule
      */
    def media[A](
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[RelatedMediaAdditionNotification, Option[A]] =
      Field("media", OptionOf(Obj(innerSelection)))

    /**
      * The id of the new media
      */
    def mediaId: SelectionBuilder[RelatedMediaAdditionNotification, Int] =
      Field("mediaId", Scalar())

    /**
      * The type of notification
      */
    def `type`: SelectionBuilder[RelatedMediaAdditionNotification, Option[
      NotificationType
    ]] = Field("type", OptionOf(Scalar()))
  }

  type Report
  object Report {

    /**
      * When the entry data was created
      */
    def createdAt: SelectionBuilder[Report, Option[Int]] =
      Field("createdAt", OptionOf(Scalar()))
    def id: SelectionBuilder[Report, Int] = Field("id", Scalar())
    def reason: SelectionBuilder[Report, Option[String]] =
      Field("reason", OptionOf(Scalar()))
    def reported[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Report, Option[A]] =
      Field("reported", OptionOf(Obj(innerSelection)))
    def reporter[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Report, Option[A]] =
      Field("reporter", OptionOf(Obj(innerSelection)))
  }

  type Review
  object Review {

    /**
      * The main review body text
      */
    def body(
        asHtml: Option[Boolean] = None
    ): SelectionBuilder[Review, Option[String]] =
      Field(
        "body",
        OptionOf(Scalar()),
        arguments = List(Argument("asHtml", asHtml))
      )

    /**
      * The time of the thread creation
      */
    def createdAt: SelectionBuilder[Review, Int] = Field("createdAt", Scalar())

    /**
      * The id of the review
      */
    def id: SelectionBuilder[Review, Int] = Field("id", Scalar())

    /**
      * The media the review is of
      */
    def media[A](
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[Review, Option[A]] =
      Field("media", OptionOf(Obj(innerSelection)))

    /**
      * The id of the review's media
      */
    def mediaId: SelectionBuilder[Review, Int] = Field("mediaId", Scalar())

    /**
      * For which type of media the review is for
      */
    def mediaType: SelectionBuilder[Review, Option[MediaType]] =
      Field("mediaType", OptionOf(Scalar()))

    /**
      * If the review is not yet publicly published and is only viewable by creator
      */
    def `private`: SelectionBuilder[Review, Option[Boolean]] =
      Field("private", OptionOf(Scalar()))

    /**
      * The total user rating of the review
      */
    def rating: SelectionBuilder[Review, Option[Int]] =
      Field("rating", OptionOf(Scalar()))

    /**
      * The amount of user ratings of the review
      */
    def ratingAmount: SelectionBuilder[Review, Option[Int]] =
      Field("ratingAmount", OptionOf(Scalar()))

    /**
      * The review score of the media
      */
    def score: SelectionBuilder[Review, Option[Int]] =
      Field("score", OptionOf(Scalar()))

    /**
      * The url for the review page on the AniList website
      */
    def siteUrl: SelectionBuilder[Review, Option[String]] =
      Field("siteUrl", OptionOf(Scalar()))

    /**
      * A short summary of the review
      */
    def summary: SelectionBuilder[Review, Option[String]] =
      Field("summary", OptionOf(Scalar()))

    /**
      * The time of the thread last update
      */
    def updatedAt: SelectionBuilder[Review, Int] = Field("updatedAt", Scalar())

    /**
      * The creator of the review
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Review, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))

    /**
      * The id of the review's creator
      */
    def userId: SelectionBuilder[Review, Int] = Field("userId", Scalar())

    /**
      * The rating of the review by currently authenticated user
      */
    def userRating: SelectionBuilder[Review, Option[ReviewRating]] =
      Field("userRating", OptionOf(Scalar()))
  }

  type ReviewConnection
  object ReviewConnection {
    def edges[A](
        innerSelection: SelectionBuilder[ReviewEdge, A]
    ): SelectionBuilder[ReviewConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def nodes[A](
        innerSelection: SelectionBuilder[Review, A]
    ): SelectionBuilder[ReviewConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The pagination information
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[ReviewConnection, Option[A]] =
      Field("pageInfo", OptionOf(Obj(innerSelection)))
  }

  type ReviewEdge
  object ReviewEdge {
    def node[A](
        innerSelection: SelectionBuilder[Review, A]
    ): SelectionBuilder[ReviewEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type RevisionHistory
  object RevisionHistory {

    /**
      * The action taken on the objects
      */
    def action
        : SelectionBuilder[RevisionHistory, Option[RevisionHistoryAction]] =
      Field("action", OptionOf(Scalar()))

    /**
      * A JSON object of the fields that changed
      */
    def changes: SelectionBuilder[RevisionHistory, Option[Json]] =
      Field("changes", OptionOf(Scalar()))

    /**
      * The character the mod feed entry references
      */
    def character[A](
        innerSelection: SelectionBuilder[Character, A]
    ): SelectionBuilder[RevisionHistory, Option[A]] =
      Field("character", OptionOf(Obj(innerSelection)))

    /**
      * When the mod feed entry was created
      */
    def createdAt: SelectionBuilder[RevisionHistory, Option[Int]] =
      Field("createdAt", OptionOf(Scalar()))

    /**
      * The id of the media
      */
    def id: SelectionBuilder[RevisionHistory, Int] = Field("id", Scalar())

    /**
      * The media the mod feed entry references
      */
    def media[A](
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[RevisionHistory, Option[A]] =
      Field("media", OptionOf(Obj(innerSelection)))

    /**
      * The staff member the mod feed entry references
      */
    def staff[A](
        innerSelection: SelectionBuilder[Staff, A]
    ): SelectionBuilder[RevisionHistory, Option[A]] =
      Field("staff", OptionOf(Obj(innerSelection)))

    /**
      * The studio the mod feed entry references
      */
    def studio[A](
        innerSelection: SelectionBuilder[Studio, A]
    ): SelectionBuilder[RevisionHistory, Option[A]] =
      Field("studio", OptionOf(Obj(innerSelection)))

    /**
      * The user who made the edit to the object
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[RevisionHistory, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))
  }

  type ScoreDistribution
  object ScoreDistribution {

    /**
      * The amount of list entries with this score
      */
    def amount: SelectionBuilder[ScoreDistribution, Option[Int]] =
      Field("amount", OptionOf(Scalar()))
    def score: SelectionBuilder[ScoreDistribution, Option[Int]] =
      Field("score", OptionOf(Scalar()))
  }

  type SiteStatistics
  object SiteStatistics {
    def anime[A](
        page: Option[Int] = None,
        perPage: Option[Int] = None,
        sort: Option[List[Option[SiteTrendSort]]] = None
    )(
        innerSelection: SelectionBuilder[SiteTrendConnection, A]
    ): SelectionBuilder[SiteStatistics, Option[A]] =
      Field(
        "anime",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("page", page),
          Argument("perPage", perPage),
          Argument("sort", sort)
        )
      )
    def characters[A](
        page: Option[Int] = None,
        perPage: Option[Int] = None,
        sort: Option[List[Option[SiteTrendSort]]] = None
    )(
        innerSelection: SelectionBuilder[SiteTrendConnection, A]
    ): SelectionBuilder[SiteStatistics, Option[A]] =
      Field(
        "characters",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("page", page),
          Argument("perPage", perPage),
          Argument("sort", sort)
        )
      )
    def manga[A](
        page: Option[Int] = None,
        perPage: Option[Int] = None,
        sort: Option[List[Option[SiteTrendSort]]] = None
    )(
        innerSelection: SelectionBuilder[SiteTrendConnection, A]
    ): SelectionBuilder[SiteStatistics, Option[A]] =
      Field(
        "manga",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("page", page),
          Argument("perPage", perPage),
          Argument("sort", sort)
        )
      )
    def reviews[A](
        page: Option[Int] = None,
        perPage: Option[Int] = None,
        sort: Option[List[Option[SiteTrendSort]]] = None
    )(
        innerSelection: SelectionBuilder[SiteTrendConnection, A]
    ): SelectionBuilder[SiteStatistics, Option[A]] =
      Field(
        "reviews",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("page", page),
          Argument("perPage", perPage),
          Argument("sort", sort)
        )
      )
    def staff[A](
        page: Option[Int] = None,
        perPage: Option[Int] = None,
        sort: Option[List[Option[SiteTrendSort]]] = None
    )(
        innerSelection: SelectionBuilder[SiteTrendConnection, A]
    ): SelectionBuilder[SiteStatistics, Option[A]] =
      Field(
        "staff",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("page", page),
          Argument("perPage", perPage),
          Argument("sort", sort)
        )
      )
    def studios[A](
        page: Option[Int] = None,
        perPage: Option[Int] = None,
        sort: Option[List[Option[SiteTrendSort]]] = None
    )(
        innerSelection: SelectionBuilder[SiteTrendConnection, A]
    ): SelectionBuilder[SiteStatistics, Option[A]] =
      Field(
        "studios",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("page", page),
          Argument("perPage", perPage),
          Argument("sort", sort)
        )
      )
    def users[A](
        page: Option[Int] = None,
        perPage: Option[Int] = None,
        sort: Option[List[Option[SiteTrendSort]]] = None
    )(
        innerSelection: SelectionBuilder[SiteTrendConnection, A]
    ): SelectionBuilder[SiteStatistics, Option[A]] =
      Field(
        "users",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("page", page),
          Argument("perPage", perPage),
          Argument("sort", sort)
        )
      )
  }

  type SiteTrend
  object SiteTrend {

    /**
      * The change from yesterday
      */
    def change: SelectionBuilder[SiteTrend, Int] = Field("change", Scalar())
    def count: SelectionBuilder[SiteTrend, Int] = Field("count", Scalar())

    /**
      * The day the data was recorded (timestamp)
      */
    def date: SelectionBuilder[SiteTrend, Int] = Field("date", Scalar())
  }

  type SiteTrendConnection
  object SiteTrendConnection {
    def edges[A](
        innerSelection: SelectionBuilder[SiteTrendEdge, A]
    ): SelectionBuilder[SiteTrendConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def nodes[A](
        innerSelection: SelectionBuilder[SiteTrend, A]
    ): SelectionBuilder[SiteTrendConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The pagination information
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[SiteTrendConnection, Option[A]] =
      Field("pageInfo", OptionOf(Obj(innerSelection)))
  }

  type SiteTrendEdge
  object SiteTrendEdge {
    def node[A](
        innerSelection: SelectionBuilder[SiteTrend, A]
    ): SelectionBuilder[SiteTrendEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type Staff
  object Staff {

    /**
      * Characters voiced by the actor
      */
    def characters[A](
        page: Option[Int] = None,
        perPage: Option[Int] = None,
        sort: Option[List[Option[CharacterSort]]] = None
    )(
        innerSelection: SelectionBuilder[CharacterConnection, A]
    ): SelectionBuilder[Staff, Option[A]] =
      Field(
        "characters",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("page", page),
          Argument("perPage", perPage),
          Argument("sort", sort)
        )
      )

    /**
      * A general description of the staff member
      */
    def description(
        asHtml: Option[Boolean] = None
    ): SelectionBuilder[Staff, Option[String]] =
      Field(
        "description",
        OptionOf(Scalar()),
        arguments = List(Argument("asHtml", asHtml))
      )

    /**
      * The amount of user's who have favourited the staff member
      */
    def favourites: SelectionBuilder[Staff, Option[Int]] =
      Field("favourites", OptionOf(Scalar()))

    /**
      * The id of the staff member
      */
    def id: SelectionBuilder[Staff, Int] = Field("id", Scalar())

    /**
      * The staff images
      */
    def image[A](
        innerSelection: SelectionBuilder[StaffImage, A]
    ): SelectionBuilder[Staff, Option[A]] =
      Field("image", OptionOf(Obj(innerSelection)))

    /**
      * If the staff member is marked as favourite by the currently authenticated user
      */
    def isFavourite: SelectionBuilder[Staff, Boolean] =
      Field("isFavourite", Scalar())

    /**
      * The primary language of the staff member
      */
    def language: SelectionBuilder[Staff, Option[StaffLanguage]] =
      Field("language", OptionOf(Scalar()))

    /**
      * Notes for site moderators
      */
    def modNotes: SelectionBuilder[Staff, Option[String]] =
      Field("modNotes", OptionOf(Scalar()))

    /**
      * The names of the staff member
      */
    def name[A](
        innerSelection: SelectionBuilder[StaffName, A]
    ): SelectionBuilder[Staff, Option[A]] =
      Field("name", OptionOf(Obj(innerSelection)))

    /**
      * The url for the staff page on the AniList website
      */
    def siteUrl: SelectionBuilder[Staff, Option[String]] =
      Field("siteUrl", OptionOf(Scalar()))

    /**
      * Staff member that the submission is referencing
      */
    def staff[A](
        innerSelection: SelectionBuilder[Staff, A]
    ): SelectionBuilder[Staff, Option[A]] =
      Field("staff", OptionOf(Obj(innerSelection)))

    /**
      * Media where the staff member has a production role
      */
    def staffMedia[A](
        page: Option[Int] = None,
        perPage: Option[Int] = None,
        sort: Option[List[Option[MediaSort]]] = None,
        `type`: Option[MediaType] = None
    )(
        innerSelection: SelectionBuilder[MediaConnection, A]
    ): SelectionBuilder[Staff, Option[A]] =
      Field(
        "staffMedia",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("page", page),
          Argument("perPage", perPage),
          Argument("sort", sort),
          Argument("type", `type`)
        )
      )

    /**
      * Inner details of submission status
      */
    def submissionNotes: SelectionBuilder[Staff, Option[String]] =
      Field("submissionNotes", OptionOf(Scalar()))

    /**
      * Status of the submission
      */
    def submissionStatus: SelectionBuilder[Staff, Option[Int]] =
      Field("submissionStatus", OptionOf(Scalar()))

    /**
      * Submitter for the submission
      */
    def submitter[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Staff, Option[A]] =
      Field("submitter", OptionOf(Obj(innerSelection)))
    @deprecated("No data available", "")
    def updatedAt: SelectionBuilder[Staff, Option[Int]] =
      Field("updatedAt", OptionOf(Scalar()))
  }

  type StaffConnection
  object StaffConnection {
    def edges[A](
        innerSelection: SelectionBuilder[StaffEdge, A]
    ): SelectionBuilder[StaffConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def nodes[A](
        innerSelection: SelectionBuilder[Staff, A]
    ): SelectionBuilder[StaffConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The pagination information
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[StaffConnection, Option[A]] =
      Field("pageInfo", OptionOf(Obj(innerSelection)))
  }

  type StaffEdge
  object StaffEdge {

    /**
      * The order the staff should be displayed from the users favourites
      */
    def favouriteOrder: SelectionBuilder[StaffEdge, Option[Int]] =
      Field("favouriteOrder", OptionOf(Scalar()))

    /**
      * The id of the connection
      */
    def id: SelectionBuilder[StaffEdge, Option[Int]] =
      Field("id", OptionOf(Scalar()))
    def node[A](
        innerSelection: SelectionBuilder[Staff, A]
    ): SelectionBuilder[StaffEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))

    /**
      * The role of the staff member in the production of the media
      */
    def role: SelectionBuilder[StaffEdge, Option[String]] =
      Field("role", OptionOf(Scalar()))
  }

  type StaffImage
  object StaffImage {

    /**
      * The person's image of media at its largest size
      */
    def large: SelectionBuilder[StaffImage, Option[String]] =
      Field("large", OptionOf(Scalar()))

    /**
      * The person's image of media at medium size
      */
    def medium: SelectionBuilder[StaffImage, Option[String]] =
      Field("medium", OptionOf(Scalar()))
  }

  type StaffName
  object StaffName {

    /**
      * Other names the staff member might be referred to as (pen names)
      */
    def alternative: SelectionBuilder[StaffName, Option[List[Option[String]]]] =
      Field("alternative", OptionOf(ListOf(OptionOf(Scalar()))))

    /**
      * The person's given name
      */
    def first: SelectionBuilder[StaffName, Option[String]] =
      Field("first", OptionOf(Scalar()))

    /**
      * The person's full name
      */
    def full: SelectionBuilder[StaffName, Option[String]] =
      Field("full", OptionOf(Scalar()))

    /**
      * The person's surname
      */
    def last: SelectionBuilder[StaffName, Option[String]] =
      Field("last", OptionOf(Scalar()))

    /**
      * The person's full name in their native language
      */
    def native: SelectionBuilder[StaffName, Option[String]] =
      Field("native", OptionOf(Scalar()))
  }

  type StaffStats
  object StaffStats {
    def amount: SelectionBuilder[StaffStats, Option[Int]] =
      Field("amount", OptionOf(Scalar()))
    def meanScore: SelectionBuilder[StaffStats, Option[Int]] =
      Field("meanScore", OptionOf(Scalar()))
    def staff[A](
        innerSelection: SelectionBuilder[Staff, A]
    ): SelectionBuilder[StaffStats, Option[A]] =
      Field("staff", OptionOf(Obj(innerSelection)))

    /**
      * The amount of time in minutes the staff member has been watched by the user
      */
    def timeWatched: SelectionBuilder[StaffStats, Option[Int]] =
      Field("timeWatched", OptionOf(Scalar()))
  }

  type StaffSubmission
  object StaffSubmission {
    def createdAt: SelectionBuilder[StaffSubmission, Option[Int]] =
      Field("createdAt", OptionOf(Scalar()))

    /**
      * The id of the submission
      */
    def id: SelectionBuilder[StaffSubmission, Int] = Field("id", Scalar())

    /**
      * Inner details of submission status
      */
    def notes: SelectionBuilder[StaffSubmission, Option[String]] =
      Field("notes", OptionOf(Scalar()))
    def source: SelectionBuilder[StaffSubmission, Option[String]] =
      Field("source", OptionOf(Scalar()))

    /**
      * Staff that the submission is referencing
      */
    def staff[A](
        innerSelection: SelectionBuilder[Staff, A]
    ): SelectionBuilder[StaffSubmission, Option[A]] =
      Field("staff", OptionOf(Obj(innerSelection)))

    /**
      * Status of the submission
      */
    def status: SelectionBuilder[StaffSubmission, Option[SubmissionStatus]] =
      Field("status", OptionOf(Scalar()))

    /**
      * The staff submission changes
      */
    def submission[A](
        innerSelection: SelectionBuilder[Staff, A]
    ): SelectionBuilder[StaffSubmission, Option[A]] =
      Field("submission", OptionOf(Obj(innerSelection)))

    /**
      * Submitter for the submission
      */
    def submitter[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[StaffSubmission, Option[A]] =
      Field("submitter", OptionOf(Obj(innerSelection)))
  }

  type StatusDistribution
  object StatusDistribution {

    /**
      * The amount of entries with this status
      */
    def amount: SelectionBuilder[StatusDistribution, Option[Int]] =
      Field("amount", OptionOf(Scalar()))

    /**
      * The day the activity took place (Unix timestamp)
      */
    def status: SelectionBuilder[StatusDistribution, Option[MediaListStatus]] =
      Field("status", OptionOf(Scalar()))
  }

  type Studio
  object Studio {

    /**
      * The amount of user's who have favourited the studio
      */
    def favourites: SelectionBuilder[Studio, Option[Int]] =
      Field("favourites", OptionOf(Scalar()))

    /**
      * The id of the studio
      */
    def id: SelectionBuilder[Studio, Int] = Field("id", Scalar())

    /**
      * If the studio is an animation studio or a different kind of company
      */
    def isAnimationStudio: SelectionBuilder[Studio, Boolean] =
      Field("isAnimationStudio", Scalar())

    /**
      * If the studio is marked as favourite by the currently authenticated user
      */
    def isFavourite: SelectionBuilder[Studio, Boolean] =
      Field("isFavourite", Scalar())

    /**
      * The media the studio has worked on
      */
    def media[A](
        isMain: Option[Boolean] = None,
        page: Option[Int] = None,
        perPage: Option[Int] = None,
        sort: Option[List[Option[MediaSort]]] = None
    )(
        innerSelection: SelectionBuilder[MediaConnection, A]
    ): SelectionBuilder[Studio, Option[A]] =
      Field(
        "media",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("isMain", isMain),
          Argument("page", page),
          Argument("perPage", perPage),
          Argument("sort", sort)
        )
      )

    /**
      * The name of the studio
      */
    def name: SelectionBuilder[Studio, String] = Field("name", Scalar())

    /**
      * The url for the studio page on the AniList website
      */
    def siteUrl: SelectionBuilder[Studio, Option[String]] =
      Field("siteUrl", OptionOf(Scalar()))
  }

  type StudioConnection
  object StudioConnection {
    def edges[A](
        innerSelection: SelectionBuilder[StudioEdge, A]
    ): SelectionBuilder[StudioConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def nodes[A](
        innerSelection: SelectionBuilder[Studio, A]
    ): SelectionBuilder[StudioConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The pagination information
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[StudioConnection, Option[A]] =
      Field("pageInfo", OptionOf(Obj(innerSelection)))
  }

  type StudioEdge
  object StudioEdge {

    /**
      * The order the character should be displayed from the users favourites
      */
    def favouriteOrder: SelectionBuilder[StudioEdge, Option[Int]] =
      Field("favouriteOrder", OptionOf(Scalar()))

    /**
      * The id of the connection
      */
    def id: SelectionBuilder[StudioEdge, Option[Int]] =
      Field("id", OptionOf(Scalar()))

    /**
      * If the studio is the main animation studio of the anime
      */
    def isMain: SelectionBuilder[StudioEdge, Boolean] =
      Field("isMain", Scalar())
    def node[A](
        innerSelection: SelectionBuilder[Studio, A]
    ): SelectionBuilder[StudioEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type StudioStats
  object StudioStats {
    def amount: SelectionBuilder[StudioStats, Option[Int]] =
      Field("amount", OptionOf(Scalar()))
    def meanScore: SelectionBuilder[StudioStats, Option[Int]] =
      Field("meanScore", OptionOf(Scalar()))
    def studio[A](
        innerSelection: SelectionBuilder[Studio, A]
    ): SelectionBuilder[StudioStats, Option[A]] =
      Field("studio", OptionOf(Obj(innerSelection)))

    /**
      * The amount of time in minutes the studio's works have been watched by the user
      */
    def timeWatched: SelectionBuilder[StudioStats, Option[Int]] =
      Field("timeWatched", OptionOf(Scalar()))
  }

  type TagStats
  object TagStats {
    def amount: SelectionBuilder[TagStats, Option[Int]] =
      Field("amount", OptionOf(Scalar()))
    def meanScore: SelectionBuilder[TagStats, Option[Int]] =
      Field("meanScore", OptionOf(Scalar()))
    def tag[A](
        innerSelection: SelectionBuilder[MediaTag, A]
    ): SelectionBuilder[TagStats, Option[A]] =
      Field("tag", OptionOf(Obj(innerSelection)))

    /**
      * The amount of time in minutes the tag has been watched by the user
      */
    def timeWatched: SelectionBuilder[TagStats, Option[Int]] =
      Field("timeWatched", OptionOf(Scalar()))
  }

  type TextActivity
  object TextActivity {

    /**
      * The time the activity was created at
      */
    def createdAt: SelectionBuilder[TextActivity, Int] =
      Field("createdAt", Scalar())

    /**
      * The id of the activity
      */
    def id: SelectionBuilder[TextActivity, Int] = Field("id", Scalar())

    /**
      * If the currently authenticated user liked the activity
      */
    def isLiked: SelectionBuilder[TextActivity, Option[Boolean]] =
      Field("isLiked", OptionOf(Scalar()))

    /**
      * If the activity is locked and can receive replies
      */
    def isLocked: SelectionBuilder[TextActivity, Option[Boolean]] =
      Field("isLocked", OptionOf(Scalar()))

    /**
      * If the currently authenticated user is subscribed to the activity
      */
    def isSubscribed: SelectionBuilder[TextActivity, Option[Boolean]] =
      Field("isSubscribed", OptionOf(Scalar()))

    /**
      * The amount of likes the activity has
      */
    def likeCount: SelectionBuilder[TextActivity, Int] =
      Field("likeCount", Scalar())

    /**
      * The users who liked the activity
      */
    def likes[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[TextActivity, Option[List[Option[A]]]] =
      Field("likes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The written replies to the activity
      */
    def replies[A](
        innerSelection: SelectionBuilder[ActivityReply, A]
    ): SelectionBuilder[TextActivity, Option[List[Option[A]]]] =
      Field("replies", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The number of activity replies
      */
    def replyCount: SelectionBuilder[TextActivity, Int] =
      Field("replyCount", Scalar())

    /**
      * The url for the activity page on the AniList website
      */
    def siteUrl: SelectionBuilder[TextActivity, Option[String]] =
      Field("siteUrl", OptionOf(Scalar()))

    /**
      * The status text (Markdown)
      */
    def text(
        asHtml: Option[Boolean] = None
    ): SelectionBuilder[TextActivity, Option[String]] =
      Field(
        "text",
        OptionOf(Scalar()),
        arguments = List(Argument("asHtml", asHtml))
      )

    /**
      * The type of activity
      */
    def `type`: SelectionBuilder[TextActivity, Option[ActivityType]] =
      Field("type", OptionOf(Scalar()))

    /**
      * The user who created the activity
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[TextActivity, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))

    /**
      * The user id of the activity's creator
      */
    def userId: SelectionBuilder[TextActivity, Option[Int]] =
      Field("userId", OptionOf(Scalar()))
  }

  type Thread
  object Thread {

    /**
      * The text body of the thread (Markdown)
      */
    def body(
        asHtml: Option[Boolean] = None
    ): SelectionBuilder[Thread, Option[String]] =
      Field(
        "body",
        OptionOf(Scalar()),
        arguments = List(Argument("asHtml", asHtml))
      )

    /**
      * The categories of the thread
      */
    def categories[A](
        innerSelection: SelectionBuilder[ThreadCategory, A]
    ): SelectionBuilder[Thread, Option[List[Option[A]]]] =
      Field("categories", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The time of the thread creation
      */
    def createdAt: SelectionBuilder[Thread, Int] = Field("createdAt", Scalar())

    /**
      * The id of the thread
      */
    def id: SelectionBuilder[Thread, Int] = Field("id", Scalar())

    /**
      * If the currently authenticated user liked the thread
      */
    def isLiked: SelectionBuilder[Thread, Option[Boolean]] =
      Field("isLiked", OptionOf(Scalar()))

    /**
      * If the thread is locked and can receive comments
      */
    def isLocked: SelectionBuilder[Thread, Option[Boolean]] =
      Field("isLocked", OptionOf(Scalar()))

    /**
      * If the thread is stickied and should be displayed at the top of the page
      */
    def isSticky: SelectionBuilder[Thread, Option[Boolean]] =
      Field("isSticky", OptionOf(Scalar()))

    /**
      * If the currently authenticated user is subscribed to the thread
      */
    def isSubscribed: SelectionBuilder[Thread, Option[Boolean]] =
      Field("isSubscribed", OptionOf(Scalar()))

    /**
      * The amount of likes the thread has
      */
    def likeCount: SelectionBuilder[Thread, Int] = Field("likeCount", Scalar())

    /**
      * The users who liked the thread
      */
    def likes[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Thread, Option[List[Option[A]]]] =
      Field("likes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The media categories of the thread
      */
    def mediaCategories[A](
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[Thread, Option[List[Option[A]]]] =
      Field("mediaCategories", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The time of the last reply
      */
    def repliedAt: SelectionBuilder[Thread, Option[Int]] =
      Field("repliedAt", OptionOf(Scalar()))

    /**
      * The id of the most recent comment on the thread
      */
    def replyCommentId: SelectionBuilder[Thread, Option[Int]] =
      Field("replyCommentId", OptionOf(Scalar()))

    /**
      * The number of comments on the thread
      */
    def replyCount: SelectionBuilder[Thread, Option[Int]] =
      Field("replyCount", OptionOf(Scalar()))

    /**
      * The user to last reply to the thread
      */
    def replyUser[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Thread, Option[A]] =
      Field("replyUser", OptionOf(Obj(innerSelection)))

    /**
      * The id of the user who most recently commented on the thread
      */
    def replyUserId: SelectionBuilder[Thread, Option[Int]] =
      Field("replyUserId", OptionOf(Scalar()))

    /**
      * The url for the thread page on the AniList website
      */
    def siteUrl: SelectionBuilder[Thread, Option[String]] =
      Field("siteUrl", OptionOf(Scalar()))

    /**
      * The title of the thread
      */
    def title: SelectionBuilder[Thread, Option[String]] =
      Field("title", OptionOf(Scalar()))

    /**
      * The time of the thread last update
      */
    def updatedAt: SelectionBuilder[Thread, Int] = Field("updatedAt", Scalar())

    /**
      * The owner of the thread
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Thread, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))

    /**
      * The id of the thread owner user
      */
    def userId: SelectionBuilder[Thread, Int] = Field("userId", Scalar())

    /**
      * The number of times users have viewed the thread
      */
    def viewCount: SelectionBuilder[Thread, Option[Int]] =
      Field("viewCount", OptionOf(Scalar()))
  }

  type ThreadCategory
  object ThreadCategory {

    /**
      * The id of the category
      */
    def id: SelectionBuilder[ThreadCategory, Int] = Field("id", Scalar())

    /**
      * The name of the category
      */
    def name: SelectionBuilder[ThreadCategory, String] = Field("name", Scalar())
  }

  type ThreadComment
  object ThreadComment {

    /**
      * The comment's child reply comments
      */
    def childComments: SelectionBuilder[ThreadComment, Option[Json]] =
      Field("childComments", OptionOf(Scalar()))

    /**
      * The text content of the comment (Markdown)
      */
    def comment(
        asHtml: Option[Boolean] = None
    ): SelectionBuilder[ThreadComment, Option[String]] =
      Field(
        "comment",
        OptionOf(Scalar()),
        arguments = List(Argument("asHtml", asHtml))
      )

    /**
      * The time of the comments creation
      */
    def createdAt: SelectionBuilder[ThreadComment, Int] =
      Field("createdAt", Scalar())

    /**
      * The id of the comment
      */
    def id: SelectionBuilder[ThreadComment, Int] = Field("id", Scalar())

    /**
      * If the currently authenticated user liked the comment
      */
    def isLiked: SelectionBuilder[ThreadComment, Option[Boolean]] =
      Field("isLiked", OptionOf(Scalar()))

    /**
      * The amount of likes the comment has
      */
    def likeCount: SelectionBuilder[ThreadComment, Int] =
      Field("likeCount", Scalar())

    /**
      * The users who liked the comment
      */
    def likes[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ThreadComment, Option[List[Option[A]]]] =
      Field("likes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * The url for the comment page on the AniList website
      */
    def siteUrl: SelectionBuilder[ThreadComment, Option[String]] =
      Field("siteUrl", OptionOf(Scalar()))

    /**
      * The thread the comment belongs to
      */
    def thread[A](
        innerSelection: SelectionBuilder[Thread, A]
    ): SelectionBuilder[ThreadComment, Option[A]] =
      Field("thread", OptionOf(Obj(innerSelection)))

    /**
      * The id of thread the comment belongs to
      */
    def threadId: SelectionBuilder[ThreadComment, Option[Int]] =
      Field("threadId", OptionOf(Scalar()))

    /**
      * The time of the comments last update
      */
    def updatedAt: SelectionBuilder[ThreadComment, Int] =
      Field("updatedAt", Scalar())

    /**
      * The user who created the comment
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ThreadComment, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))

    /**
      * The user id of the comment's owner
      */
    def userId: SelectionBuilder[ThreadComment, Option[Int]] =
      Field("userId", OptionOf(Scalar()))
  }

  type ThreadCommentLikeNotification
  object ThreadCommentLikeNotification {

    /**
      * The thread comment that was liked
      */
    def comment[A](
        innerSelection: SelectionBuilder[ThreadComment, A]
    ): SelectionBuilder[ThreadCommentLikeNotification, Option[A]] =
      Field("comment", OptionOf(Obj(innerSelection)))

    /**
      * The id of the activity which was liked
      */
    def commentId: SelectionBuilder[ThreadCommentLikeNotification, Int] =
      Field("commentId", Scalar())

    /**
      * The notification context text
      */
    def context
        : SelectionBuilder[ThreadCommentLikeNotification, Option[String]] =
      Field("context", OptionOf(Scalar()))

    /**
      * The time the notification was created at
      */
    def createdAt
        : SelectionBuilder[ThreadCommentLikeNotification, Option[Int]] =
      Field("createdAt", OptionOf(Scalar()))

    /**
      * The id of the Notification
      */
    def id: SelectionBuilder[ThreadCommentLikeNotification, Int] =
      Field("id", Scalar())

    /**
      * The thread that the relevant comment belongs to
      */
    def thread[A](
        innerSelection: SelectionBuilder[Thread, A]
    ): SelectionBuilder[ThreadCommentLikeNotification, Option[A]] =
      Field("thread", OptionOf(Obj(innerSelection)))

    /**
      * The type of notification
      */
    def `type`: SelectionBuilder[ThreadCommentLikeNotification, Option[
      NotificationType
    ]] = Field("type", OptionOf(Scalar()))

    /**
      * The user who liked the activity
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ThreadCommentLikeNotification, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))

    /**
      * The id of the user who liked to the activity
      */
    def userId: SelectionBuilder[ThreadCommentLikeNotification, Int] =
      Field("userId", Scalar())
  }

  type ThreadCommentMentionNotification
  object ThreadCommentMentionNotification {

    /**
      * The thread comment that included the @ mention
      */
    def comment[A](
        innerSelection: SelectionBuilder[ThreadComment, A]
    ): SelectionBuilder[ThreadCommentMentionNotification, Option[A]] =
      Field("comment", OptionOf(Obj(innerSelection)))

    /**
      * The id of the comment where mentioned
      */
    def commentId: SelectionBuilder[ThreadCommentMentionNotification, Int] =
      Field("commentId", Scalar())

    /**
      * The notification context text
      */
    def context
        : SelectionBuilder[ThreadCommentMentionNotification, Option[String]] =
      Field("context", OptionOf(Scalar()))

    /**
      * The time the notification was created at
      */
    def createdAt
        : SelectionBuilder[ThreadCommentMentionNotification, Option[Int]] =
      Field("createdAt", OptionOf(Scalar()))

    /**
      * The id of the Notification
      */
    def id: SelectionBuilder[ThreadCommentMentionNotification, Int] =
      Field("id", Scalar())

    /**
      * The thread that the relevant comment belongs to
      */
    def thread[A](
        innerSelection: SelectionBuilder[Thread, A]
    ): SelectionBuilder[ThreadCommentMentionNotification, Option[A]] =
      Field("thread", OptionOf(Obj(innerSelection)))

    /**
      * The type of notification
      */
    def `type`: SelectionBuilder[ThreadCommentMentionNotification, Option[
      NotificationType
    ]] = Field("type", OptionOf(Scalar()))

    /**
      * The user who mentioned the authenticated user
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ThreadCommentMentionNotification, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))

    /**
      * The id of the user who mentioned the authenticated user
      */
    def userId: SelectionBuilder[ThreadCommentMentionNotification, Int] =
      Field("userId", Scalar())
  }

  type ThreadCommentReplyNotification
  object ThreadCommentReplyNotification {

    /**
      * The reply thread comment
      */
    def comment[A](
        innerSelection: SelectionBuilder[ThreadComment, A]
    ): SelectionBuilder[ThreadCommentReplyNotification, Option[A]] =
      Field("comment", OptionOf(Obj(innerSelection)))

    /**
      * The id of the reply comment
      */
    def commentId: SelectionBuilder[ThreadCommentReplyNotification, Int] =
      Field("commentId", Scalar())

    /**
      * The notification context text
      */
    def context
        : SelectionBuilder[ThreadCommentReplyNotification, Option[String]] =
      Field("context", OptionOf(Scalar()))

    /**
      * The time the notification was created at
      */
    def createdAt
        : SelectionBuilder[ThreadCommentReplyNotification, Option[Int]] =
      Field("createdAt", OptionOf(Scalar()))

    /**
      * The id of the Notification
      */
    def id: SelectionBuilder[ThreadCommentReplyNotification, Int] =
      Field("id", Scalar())

    /**
      * The thread that the relevant comment belongs to
      */
    def thread[A](
        innerSelection: SelectionBuilder[Thread, A]
    ): SelectionBuilder[ThreadCommentReplyNotification, Option[A]] =
      Field("thread", OptionOf(Obj(innerSelection)))

    /**
      * The type of notification
      */
    def `type`: SelectionBuilder[ThreadCommentReplyNotification, Option[
      NotificationType
    ]] = Field("type", OptionOf(Scalar()))

    /**
      * The user who replied to the activity
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ThreadCommentReplyNotification, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))

    /**
      * The id of the user who create the comment reply
      */
    def userId: SelectionBuilder[ThreadCommentReplyNotification, Int] =
      Field("userId", Scalar())
  }

  type ThreadCommentSubscribedNotification
  object ThreadCommentSubscribedNotification {

    /**
      * The reply thread comment
      */
    def comment[A](
        innerSelection: SelectionBuilder[ThreadComment, A]
    ): SelectionBuilder[ThreadCommentSubscribedNotification, Option[A]] =
      Field("comment", OptionOf(Obj(innerSelection)))

    /**
      * The id of the new comment in the subscribed thread
      */
    def commentId: SelectionBuilder[ThreadCommentSubscribedNotification, Int] =
      Field("commentId", Scalar())

    /**
      * The notification context text
      */
    def context: SelectionBuilder[ThreadCommentSubscribedNotification, Option[
      String
    ]] = Field("context", OptionOf(Scalar()))

    /**
      * The time the notification was created at
      */
    def createdAt
        : SelectionBuilder[ThreadCommentSubscribedNotification, Option[Int]] =
      Field("createdAt", OptionOf(Scalar()))

    /**
      * The id of the Notification
      */
    def id: SelectionBuilder[ThreadCommentSubscribedNotification, Int] =
      Field("id", Scalar())

    /**
      * The thread that the relevant comment belongs to
      */
    def thread[A](
        innerSelection: SelectionBuilder[Thread, A]
    ): SelectionBuilder[ThreadCommentSubscribedNotification, Option[A]] =
      Field("thread", OptionOf(Obj(innerSelection)))

    /**
      * The type of notification
      */
    def `type`: SelectionBuilder[ThreadCommentSubscribedNotification, Option[
      NotificationType
    ]] = Field("type", OptionOf(Scalar()))

    /**
      * The user who replied to the subscribed thread
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ThreadCommentSubscribedNotification, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))

    /**
      * The id of the user who commented on the thread
      */
    def userId: SelectionBuilder[ThreadCommentSubscribedNotification, Int] =
      Field("userId", Scalar())
  }

  type ThreadLikeNotification
  object ThreadLikeNotification {

    /**
      * The liked thread comment
      */
    def comment[A](
        innerSelection: SelectionBuilder[ThreadComment, A]
    ): SelectionBuilder[ThreadLikeNotification, Option[A]] =
      Field("comment", OptionOf(Obj(innerSelection)))

    /**
      * The notification context text
      */
    def context: SelectionBuilder[ThreadLikeNotification, Option[String]] =
      Field("context", OptionOf(Scalar()))

    /**
      * The time the notification was created at
      */
    def createdAt: SelectionBuilder[ThreadLikeNotification, Option[Int]] =
      Field("createdAt", OptionOf(Scalar()))

    /**
      * The id of the Notification
      */
    def id: SelectionBuilder[ThreadLikeNotification, Int] =
      Field("id", Scalar())

    /**
      * The thread that the relevant comment belongs to
      */
    def thread[A](
        innerSelection: SelectionBuilder[Thread, A]
    ): SelectionBuilder[ThreadLikeNotification, Option[A]] =
      Field("thread", OptionOf(Obj(innerSelection)))

    /**
      * The id of the thread which was liked
      */
    def threadId: SelectionBuilder[ThreadLikeNotification, Int] =
      Field("threadId", Scalar())

    /**
      * The type of notification
      */
    def `type`
        : SelectionBuilder[ThreadLikeNotification, Option[NotificationType]] =
      Field("type", OptionOf(Scalar()))

    /**
      * The user who liked the activity
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[ThreadLikeNotification, Option[A]] =
      Field("user", OptionOf(Obj(innerSelection)))

    /**
      * The id of the user who liked to the activity
      */
    def userId: SelectionBuilder[ThreadLikeNotification, Int] =
      Field("userId", Scalar())
  }

  type User
  object User {

    /**
      * The bio written by user (Markdown)
      */
    def about(
        asHtml: Option[Boolean] = None
    ): SelectionBuilder[User, Option[String]] =
      Field(
        "about",
        OptionOf(Scalar()),
        arguments = List(Argument("asHtml", asHtml))
      )

    /**
      * The user's avatar images
      */
    def avatar[A](
        innerSelection: SelectionBuilder[UserAvatar, A]
    ): SelectionBuilder[User, Option[A]] =
      Field("avatar", OptionOf(Obj(innerSelection)))

    /**
      * The user's banner images
      */
    def bannerImage: SelectionBuilder[User, Option[String]] =
      Field("bannerImage", OptionOf(Scalar()))
    def bans: SelectionBuilder[User, Option[Json]] =
      Field("bans", OptionOf(Scalar()))

    /**
      * Custom donation badge text
      */
    def donatorBadge: SelectionBuilder[User, Option[String]] =
      Field("donatorBadge", OptionOf(Scalar()))

    /**
      * The donation tier of the user
      */
    def donatorTier: SelectionBuilder[User, Option[Int]] =
      Field("donatorTier", OptionOf(Scalar()))

    /**
      * The users favourites
      */
    def favourites[A](page: Option[Int] = None)(
        innerSelection: SelectionBuilder[Favourites, A]
    ): SelectionBuilder[User, Option[A]] =
      Field(
        "favourites",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("page", page))
      )

    /**
      * The id of the user
      */
    def id: SelectionBuilder[User, Int] = Field("id", Scalar())

    /**
      * If the user is blocked by the authenticated user
      */
    def isBlocked: SelectionBuilder[User, Option[Boolean]] =
      Field("isBlocked", OptionOf(Scalar()))

    /**
      * If this user if following the authenticated user
      */
    def isFollower: SelectionBuilder[User, Option[Boolean]] =
      Field("isFollower", OptionOf(Scalar()))

    /**
      * If the authenticated user if following this user
      */
    def isFollowing: SelectionBuilder[User, Option[Boolean]] =
      Field("isFollowing", OptionOf(Scalar()))

    /**
      * The user's media list options
      */
    def mediaListOptions[A](
        innerSelection: SelectionBuilder[MediaListOptions, A]
    ): SelectionBuilder[User, Option[A]] =
      Field("mediaListOptions", OptionOf(Obj(innerSelection)))

    /**
      * If the user is a moderator or data moderator
      */
    def moderatorStatus: SelectionBuilder[User, Option[String]] =
      Field("moderatorStatus", OptionOf(Scalar()))

    /**
      * The name of the user
      */
    def name: SelectionBuilder[User, String] = Field("name", Scalar())

    /**
      * The user's general options
      */
    def options[A](
        innerSelection: SelectionBuilder[UserOptions, A]
    ): SelectionBuilder[User, Option[A]] =
      Field("options", OptionOf(Obj(innerSelection)))

    /**
      * The url for the user page on the AniList website
      */
    def siteUrl: SelectionBuilder[User, Option[String]] =
      Field("siteUrl", OptionOf(Scalar()))

    /**
      * The users anime & manga list statistics
      */
    def statistics[A](
        innerSelection: SelectionBuilder[UserStatisticTypes, A]
    ): SelectionBuilder[User, Option[A]] =
      Field("statistics", OptionOf(Obj(innerSelection)))

    /**
      * The user's statistics
      */
    @deprecated("Deprecated. Replaced with statistics field.", "")
    def stats[A](
        innerSelection: SelectionBuilder[UserStats, A]
    ): SelectionBuilder[User, Option[A]] =
      Field("stats", OptionOf(Obj(innerSelection)))

    /**
      * The number of unread notifications the user has
      */
    def unreadNotificationCount: SelectionBuilder[User, Option[Int]] =
      Field("unreadNotificationCount", OptionOf(Scalar()))

    /**
      * When the user's data was last updated
      */
    def updatedAt: SelectionBuilder[User, Option[Int]] =
      Field("updatedAt", OptionOf(Scalar()))
  }

  type UserActivityHistory
  object UserActivityHistory {

    /**
      * The amount of activity on the day
      */
    def amount: SelectionBuilder[UserActivityHistory, Option[Int]] =
      Field("amount", OptionOf(Scalar()))

    /**
      * The day the activity took place (Unix timestamp)
      */
    def date: SelectionBuilder[UserActivityHistory, Option[Int]] =
      Field("date", OptionOf(Scalar()))

    /**
      * The level of activity represented on a 1-10 scale
      */
    def level: SelectionBuilder[UserActivityHistory, Option[Int]] =
      Field("level", OptionOf(Scalar()))
  }

  type UserAvatar
  object UserAvatar {

    /**
      * The avatar of user at its largest size
      */
    def large: SelectionBuilder[UserAvatar, Option[String]] =
      Field("large", OptionOf(Scalar()))

    /**
      * The avatar of user at medium size
      */
    def medium: SelectionBuilder[UserAvatar, Option[String]] =
      Field("medium", OptionOf(Scalar()))
  }

  type UserCountryStatistic
  object UserCountryStatistic {
    def chaptersRead: SelectionBuilder[UserCountryStatistic, Int] =
      Field("chaptersRead", Scalar())
    def count: SelectionBuilder[UserCountryStatistic, Int] =
      Field("count", Scalar())
    def country: SelectionBuilder[UserCountryStatistic, Option[CountryCode]] =
      Field("country", OptionOf(Scalar()))
    def meanScore: SelectionBuilder[UserCountryStatistic, Double] =
      Field("meanScore", Scalar())
    def mediaIds: SelectionBuilder[UserCountryStatistic, List[Option[Int]]] =
      Field("mediaIds", ListOf(OptionOf(Scalar())))
    def minutesWatched: SelectionBuilder[UserCountryStatistic, Int] =
      Field("minutesWatched", Scalar())
  }

  type UserFormatStatistic
  object UserFormatStatistic {
    def chaptersRead: SelectionBuilder[UserFormatStatistic, Int] =
      Field("chaptersRead", Scalar())
    def count: SelectionBuilder[UserFormatStatistic, Int] =
      Field("count", Scalar())
    def format: SelectionBuilder[UserFormatStatistic, Option[MediaFormat]] =
      Field("format", OptionOf(Scalar()))
    def meanScore: SelectionBuilder[UserFormatStatistic, Double] =
      Field("meanScore", Scalar())
    def mediaIds: SelectionBuilder[UserFormatStatistic, List[Option[Int]]] =
      Field("mediaIds", ListOf(OptionOf(Scalar())))
    def minutesWatched: SelectionBuilder[UserFormatStatistic, Int] =
      Field("minutesWatched", Scalar())
  }

  type UserGenreStatistic
  object UserGenreStatistic {
    def chaptersRead: SelectionBuilder[UserGenreStatistic, Int] =
      Field("chaptersRead", Scalar())
    def count: SelectionBuilder[UserGenreStatistic, Int] =
      Field("count", Scalar())
    def genre: SelectionBuilder[UserGenreStatistic, Option[String]] =
      Field("genre", OptionOf(Scalar()))
    def meanScore: SelectionBuilder[UserGenreStatistic, Double] =
      Field("meanScore", Scalar())
    def mediaIds: SelectionBuilder[UserGenreStatistic, List[Option[Int]]] =
      Field("mediaIds", ListOf(OptionOf(Scalar())))
    def minutesWatched: SelectionBuilder[UserGenreStatistic, Int] =
      Field("minutesWatched", Scalar())
  }

  type UserLengthStatistic
  object UserLengthStatistic {
    def chaptersRead: SelectionBuilder[UserLengthStatistic, Int] =
      Field("chaptersRead", Scalar())
    def count: SelectionBuilder[UserLengthStatistic, Int] =
      Field("count", Scalar())
    def length: SelectionBuilder[UserLengthStatistic, Option[String]] =
      Field("length", OptionOf(Scalar()))
    def meanScore: SelectionBuilder[UserLengthStatistic, Double] =
      Field("meanScore", Scalar())
    def mediaIds: SelectionBuilder[UserLengthStatistic, List[Option[Int]]] =
      Field("mediaIds", ListOf(OptionOf(Scalar())))
    def minutesWatched: SelectionBuilder[UserLengthStatistic, Int] =
      Field("minutesWatched", Scalar())
  }

  type UserModData
  object UserModData {
    def alts[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[UserModData, Option[List[Option[A]]]] =
      Field("alts", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def bans: SelectionBuilder[UserModData, Option[Json]] =
      Field("bans", OptionOf(Scalar()))
    def counts: SelectionBuilder[UserModData, Option[Json]] =
      Field("counts", OptionOf(Scalar()))
    def ip: SelectionBuilder[UserModData, Option[Json]] =
      Field("ip", OptionOf(Scalar()))
  }

  type UserOptions
  object UserOptions {

    /**
      * Whether the user receives notifications when a show they are watching aires
      */
    def airingNotifications: SelectionBuilder[UserOptions, Option[Boolean]] =
      Field("airingNotifications", OptionOf(Scalar()))

    /**
      * Whether the user has enabled viewing of 18+ content
      */
    def displayAdultContent: SelectionBuilder[UserOptions, Option[Boolean]] =
      Field("displayAdultContent", OptionOf(Scalar()))

    /**
      * Notification options
      */
    def notificationOptions[A](
        innerSelection: SelectionBuilder[NotificationOption, A]
    ): SelectionBuilder[UserOptions, Option[List[Option[A]]]] =
      Field(
        "notificationOptions",
        OptionOf(ListOf(OptionOf(Obj(innerSelection))))
      )

    /**
      * Profile highlight color (blue, purple, pink, orange, red, green, gray)
      */
    def profileColor: SelectionBuilder[UserOptions, Option[String]] =
      Field("profileColor", OptionOf(Scalar()))

    /**
      * The language the user wants to see media titles in
      */
    def titleLanguage
        : SelectionBuilder[UserOptions, Option[UserTitleLanguage]] =
      Field("titleLanguage", OptionOf(Scalar()))
  }

  type UserReleaseYearStatistic
  object UserReleaseYearStatistic {
    def chaptersRead: SelectionBuilder[UserReleaseYearStatistic, Int] =
      Field("chaptersRead", Scalar())
    def count: SelectionBuilder[UserReleaseYearStatistic, Int] =
      Field("count", Scalar())
    def meanScore: SelectionBuilder[UserReleaseYearStatistic, Double] =
      Field("meanScore", Scalar())
    def mediaIds
        : SelectionBuilder[UserReleaseYearStatistic, List[Option[Int]]] =
      Field("mediaIds", ListOf(OptionOf(Scalar())))
    def minutesWatched: SelectionBuilder[UserReleaseYearStatistic, Int] =
      Field("minutesWatched", Scalar())
    def releaseYear: SelectionBuilder[UserReleaseYearStatistic, Option[Int]] =
      Field("releaseYear", OptionOf(Scalar()))
  }

  type UserScoreStatistic
  object UserScoreStatistic {
    def chaptersRead: SelectionBuilder[UserScoreStatistic, Int] =
      Field("chaptersRead", Scalar())
    def count: SelectionBuilder[UserScoreStatistic, Int] =
      Field("count", Scalar())
    def meanScore: SelectionBuilder[UserScoreStatistic, Double] =
      Field("meanScore", Scalar())
    def mediaIds: SelectionBuilder[UserScoreStatistic, List[Option[Int]]] =
      Field("mediaIds", ListOf(OptionOf(Scalar())))
    def minutesWatched: SelectionBuilder[UserScoreStatistic, Int] =
      Field("minutesWatched", Scalar())
    def score: SelectionBuilder[UserScoreStatistic, Option[Int]] =
      Field("score", OptionOf(Scalar()))
  }

  type UserStaffStatistic
  object UserStaffStatistic {
    def chaptersRead: SelectionBuilder[UserStaffStatistic, Int] =
      Field("chaptersRead", Scalar())
    def count: SelectionBuilder[UserStaffStatistic, Int] =
      Field("count", Scalar())
    def meanScore: SelectionBuilder[UserStaffStatistic, Double] =
      Field("meanScore", Scalar())
    def mediaIds: SelectionBuilder[UserStaffStatistic, List[Option[Int]]] =
      Field("mediaIds", ListOf(OptionOf(Scalar())))
    def minutesWatched: SelectionBuilder[UserStaffStatistic, Int] =
      Field("minutesWatched", Scalar())
    def staff[A](
        innerSelection: SelectionBuilder[Staff, A]
    ): SelectionBuilder[UserStaffStatistic, Option[A]] =
      Field("staff", OptionOf(Obj(innerSelection)))
  }

  type UserStartYearStatistic
  object UserStartYearStatistic {
    def chaptersRead: SelectionBuilder[UserStartYearStatistic, Int] =
      Field("chaptersRead", Scalar())
    def count: SelectionBuilder[UserStartYearStatistic, Int] =
      Field("count", Scalar())
    def meanScore: SelectionBuilder[UserStartYearStatistic, Double] =
      Field("meanScore", Scalar())
    def mediaIds: SelectionBuilder[UserStartYearStatistic, List[Option[Int]]] =
      Field("mediaIds", ListOf(OptionOf(Scalar())))
    def minutesWatched: SelectionBuilder[UserStartYearStatistic, Int] =
      Field("minutesWatched", Scalar())
    def startYear: SelectionBuilder[UserStartYearStatistic, Option[Int]] =
      Field("startYear", OptionOf(Scalar()))
  }

  type UserStatisticTypes
  object UserStatisticTypes {
    def anime[A](
        innerSelection: SelectionBuilder[UserStatistics, A]
    ): SelectionBuilder[UserStatisticTypes, Option[A]] =
      Field("anime", OptionOf(Obj(innerSelection)))
    def manga[A](
        innerSelection: SelectionBuilder[UserStatistics, A]
    ): SelectionBuilder[UserStatisticTypes, Option[A]] =
      Field("manga", OptionOf(Obj(innerSelection)))
  }

  type UserStatistics
  object UserStatistics {
    def chaptersRead: SelectionBuilder[UserStatistics, Int] =
      Field("chaptersRead", Scalar())
    def count: SelectionBuilder[UserStatistics, Int] = Field("count", Scalar())
    def countries[A](
        limit: Option[Int] = None,
        sort: Option[List[Option[UserStatisticsSort]]] = None
    )(
        innerSelection: SelectionBuilder[UserCountryStatistic, A]
    ): SelectionBuilder[UserStatistics, Option[List[Option[A]]]] =
      Field(
        "countries",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("limit", limit), Argument("sort", sort))
      )
    def episodesWatched: SelectionBuilder[UserStatistics, Int] =
      Field("episodesWatched", Scalar())
    def formats[A](
        limit: Option[Int] = None,
        sort: Option[List[Option[UserStatisticsSort]]] = None
    )(
        innerSelection: SelectionBuilder[UserFormatStatistic, A]
    ): SelectionBuilder[UserStatistics, Option[List[Option[A]]]] =
      Field(
        "formats",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("limit", limit), Argument("sort", sort))
      )
    def genres[A](
        limit: Option[Int] = None,
        sort: Option[List[Option[UserStatisticsSort]]] = None
    )(
        innerSelection: SelectionBuilder[UserGenreStatistic, A]
    ): SelectionBuilder[UserStatistics, Option[List[Option[A]]]] =
      Field(
        "genres",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("limit", limit), Argument("sort", sort))
      )
    def lengths[A](
        limit: Option[Int] = None,
        sort: Option[List[Option[UserStatisticsSort]]] = None
    )(
        innerSelection: SelectionBuilder[UserLengthStatistic, A]
    ): SelectionBuilder[UserStatistics, Option[List[Option[A]]]] =
      Field(
        "lengths",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("limit", limit), Argument("sort", sort))
      )
    def meanScore: SelectionBuilder[UserStatistics, Double] =
      Field("meanScore", Scalar())
    def minutesWatched: SelectionBuilder[UserStatistics, Int] =
      Field("minutesWatched", Scalar())
    def releaseYears[A](
        limit: Option[Int] = None,
        sort: Option[List[Option[UserStatisticsSort]]] = None
    )(
        innerSelection: SelectionBuilder[UserReleaseYearStatistic, A]
    ): SelectionBuilder[UserStatistics, Option[List[Option[A]]]] =
      Field(
        "releaseYears",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("limit", limit), Argument("sort", sort))
      )
    def scores[A](
        limit: Option[Int] = None,
        sort: Option[List[Option[UserStatisticsSort]]] = None
    )(
        innerSelection: SelectionBuilder[UserScoreStatistic, A]
    ): SelectionBuilder[UserStatistics, Option[List[Option[A]]]] =
      Field(
        "scores",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("limit", limit), Argument("sort", sort))
      )
    def staff[A](
        limit: Option[Int] = None,
        sort: Option[List[Option[UserStatisticsSort]]] = None
    )(
        innerSelection: SelectionBuilder[UserStaffStatistic, A]
    ): SelectionBuilder[UserStatistics, Option[List[Option[A]]]] =
      Field(
        "staff",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("limit", limit), Argument("sort", sort))
      )
    def standardDeviation: SelectionBuilder[UserStatistics, Double] =
      Field("standardDeviation", Scalar())
    def startYears[A](
        limit: Option[Int] = None,
        sort: Option[List[Option[UserStatisticsSort]]] = None
    )(
        innerSelection: SelectionBuilder[UserStartYearStatistic, A]
    ): SelectionBuilder[UserStatistics, Option[List[Option[A]]]] =
      Field(
        "startYears",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("limit", limit), Argument("sort", sort))
      )
    def statuses[A](
        limit: Option[Int] = None,
        sort: Option[List[Option[UserStatisticsSort]]] = None
    )(
        innerSelection: SelectionBuilder[UserStatusStatistic, A]
    ): SelectionBuilder[UserStatistics, Option[List[Option[A]]]] =
      Field(
        "statuses",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("limit", limit), Argument("sort", sort))
      )
    def studios[A](
        limit: Option[Int] = None,
        sort: Option[List[Option[UserStatisticsSort]]] = None
    )(
        innerSelection: SelectionBuilder[UserStudioStatistic, A]
    ): SelectionBuilder[UserStatistics, Option[List[Option[A]]]] =
      Field(
        "studios",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("limit", limit), Argument("sort", sort))
      )
    def tags[A](
        limit: Option[Int] = None,
        sort: Option[List[Option[UserStatisticsSort]]] = None
    )(
        innerSelection: SelectionBuilder[UserTagStatistic, A]
    ): SelectionBuilder[UserStatistics, Option[List[Option[A]]]] =
      Field(
        "tags",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("limit", limit), Argument("sort", sort))
      )
    def voiceActors[A](
        limit: Option[Int] = None,
        sort: Option[List[Option[UserStatisticsSort]]] = None
    )(
        innerSelection: SelectionBuilder[UserVoiceActorStatistic, A]
    ): SelectionBuilder[UserStatistics, Option[List[Option[A]]]] =
      Field(
        "voiceActors",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("limit", limit), Argument("sort", sort))
      )
    def volumesRead: SelectionBuilder[UserStatistics, Int] =
      Field("volumesRead", Scalar())
  }

  type UserStats
  object UserStats {
    def activityHistory[A](
        innerSelection: SelectionBuilder[UserActivityHistory, A]
    ): SelectionBuilder[UserStats, Option[List[Option[A]]]] =
      Field("activityHistory", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def animeListScores[A](
        innerSelection: SelectionBuilder[ListScoreStats, A]
    ): SelectionBuilder[UserStats, Option[A]] =
      Field("animeListScores", OptionOf(Obj(innerSelection)))
    def animeScoreDistribution[A](
        innerSelection: SelectionBuilder[ScoreDistribution, A]
    ): SelectionBuilder[UserStats, Option[List[Option[A]]]] =
      Field(
        "animeScoreDistribution",
        OptionOf(ListOf(OptionOf(Obj(innerSelection))))
      )
    def animeStatusDistribution[A](
        innerSelection: SelectionBuilder[StatusDistribution, A]
    ): SelectionBuilder[UserStats, Option[List[Option[A]]]] =
      Field(
        "animeStatusDistribution",
        OptionOf(ListOf(OptionOf(Obj(innerSelection))))
      )

    /**
      * The amount of manga chapters the user has read
      */
    def chaptersRead: SelectionBuilder[UserStats, Option[Int]] =
      Field("chaptersRead", OptionOf(Scalar()))
    def favouredActors[A](
        innerSelection: SelectionBuilder[StaffStats, A]
    ): SelectionBuilder[UserStats, Option[List[Option[A]]]] =
      Field("favouredActors", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def favouredFormats[A](
        innerSelection: SelectionBuilder[FormatStats, A]
    ): SelectionBuilder[UserStats, Option[List[Option[A]]]] =
      Field("favouredFormats", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def favouredGenres[A](
        innerSelection: SelectionBuilder[GenreStats, A]
    ): SelectionBuilder[UserStats, Option[List[Option[A]]]] =
      Field("favouredGenres", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def favouredGenresOverview[A](
        innerSelection: SelectionBuilder[GenreStats, A]
    ): SelectionBuilder[UserStats, Option[List[Option[A]]]] =
      Field(
        "favouredGenresOverview",
        OptionOf(ListOf(OptionOf(Obj(innerSelection))))
      )
    def favouredStaff[A](
        innerSelection: SelectionBuilder[StaffStats, A]
    ): SelectionBuilder[UserStats, Option[List[Option[A]]]] =
      Field("favouredStaff", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def favouredStudios[A](
        innerSelection: SelectionBuilder[StudioStats, A]
    ): SelectionBuilder[UserStats, Option[List[Option[A]]]] =
      Field("favouredStudios", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def favouredTags[A](
        innerSelection: SelectionBuilder[TagStats, A]
    ): SelectionBuilder[UserStats, Option[List[Option[A]]]] =
      Field("favouredTags", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def favouredYears[A](
        innerSelection: SelectionBuilder[YearStats, A]
    ): SelectionBuilder[UserStats, Option[List[Option[A]]]] =
      Field("favouredYears", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def mangaListScores[A](
        innerSelection: SelectionBuilder[ListScoreStats, A]
    ): SelectionBuilder[UserStats, Option[A]] =
      Field("mangaListScores", OptionOf(Obj(innerSelection)))
    def mangaScoreDistribution[A](
        innerSelection: SelectionBuilder[ScoreDistribution, A]
    ): SelectionBuilder[UserStats, Option[List[Option[A]]]] =
      Field(
        "mangaScoreDistribution",
        OptionOf(ListOf(OptionOf(Obj(innerSelection))))
      )
    def mangaStatusDistribution[A](
        innerSelection: SelectionBuilder[StatusDistribution, A]
    ): SelectionBuilder[UserStats, Option[List[Option[A]]]] =
      Field(
        "mangaStatusDistribution",
        OptionOf(ListOf(OptionOf(Obj(innerSelection))))
      )

    /**
      * The amount of anime the user has watched in minutes
      */
    def watchedTime: SelectionBuilder[UserStats, Option[Int]] =
      Field("watchedTime", OptionOf(Scalar()))
  }

  type UserStatusStatistic
  object UserStatusStatistic {
    def chaptersRead: SelectionBuilder[UserStatusStatistic, Int] =
      Field("chaptersRead", Scalar())
    def count: SelectionBuilder[UserStatusStatistic, Int] =
      Field("count", Scalar())
    def meanScore: SelectionBuilder[UserStatusStatistic, Double] =
      Field("meanScore", Scalar())
    def mediaIds: SelectionBuilder[UserStatusStatistic, List[Option[Int]]] =
      Field("mediaIds", ListOf(OptionOf(Scalar())))
    def minutesWatched: SelectionBuilder[UserStatusStatistic, Int] =
      Field("minutesWatched", Scalar())
    def status: SelectionBuilder[UserStatusStatistic, Option[MediaListStatus]] =
      Field("status", OptionOf(Scalar()))
  }

  type UserStudioStatistic
  object UserStudioStatistic {
    def chaptersRead: SelectionBuilder[UserStudioStatistic, Int] =
      Field("chaptersRead", Scalar())
    def count: SelectionBuilder[UserStudioStatistic, Int] =
      Field("count", Scalar())
    def meanScore: SelectionBuilder[UserStudioStatistic, Double] =
      Field("meanScore", Scalar())
    def mediaIds: SelectionBuilder[UserStudioStatistic, List[Option[Int]]] =
      Field("mediaIds", ListOf(OptionOf(Scalar())))
    def minutesWatched: SelectionBuilder[UserStudioStatistic, Int] =
      Field("minutesWatched", Scalar())
    def studio[A](
        innerSelection: SelectionBuilder[Studio, A]
    ): SelectionBuilder[UserStudioStatistic, Option[A]] =
      Field("studio", OptionOf(Obj(innerSelection)))
  }

  type UserTagStatistic
  object UserTagStatistic {
    def chaptersRead: SelectionBuilder[UserTagStatistic, Int] =
      Field("chaptersRead", Scalar())
    def count: SelectionBuilder[UserTagStatistic, Int] =
      Field("count", Scalar())
    def meanScore: SelectionBuilder[UserTagStatistic, Double] =
      Field("meanScore", Scalar())
    def mediaIds: SelectionBuilder[UserTagStatistic, List[Option[Int]]] =
      Field("mediaIds", ListOf(OptionOf(Scalar())))
    def minutesWatched: SelectionBuilder[UserTagStatistic, Int] =
      Field("minutesWatched", Scalar())
    def tag[A](
        innerSelection: SelectionBuilder[MediaTag, A]
    ): SelectionBuilder[UserTagStatistic, Option[A]] =
      Field("tag", OptionOf(Obj(innerSelection)))
  }

  type UserVoiceActorStatistic
  object UserVoiceActorStatistic {
    def chaptersRead: SelectionBuilder[UserVoiceActorStatistic, Int] =
      Field("chaptersRead", Scalar())
    def characterIds
        : SelectionBuilder[UserVoiceActorStatistic, List[Option[Int]]] =
      Field("characterIds", ListOf(OptionOf(Scalar())))
    def count: SelectionBuilder[UserVoiceActorStatistic, Int] =
      Field("count", Scalar())
    def meanScore: SelectionBuilder[UserVoiceActorStatistic, Double] =
      Field("meanScore", Scalar())
    def mediaIds: SelectionBuilder[UserVoiceActorStatistic, List[Option[Int]]] =
      Field("mediaIds", ListOf(OptionOf(Scalar())))
    def minutesWatched: SelectionBuilder[UserVoiceActorStatistic, Int] =
      Field("minutesWatched", Scalar())
    def voiceActor[A](
        innerSelection: SelectionBuilder[Staff, A]
    ): SelectionBuilder[UserVoiceActorStatistic, Option[A]] =
      Field("voiceActor", OptionOf(Obj(innerSelection)))
  }

  type YearStats
  object YearStats {
    def amount: SelectionBuilder[YearStats, Option[Int]] =
      Field("amount", OptionOf(Scalar()))
    def meanScore: SelectionBuilder[YearStats, Option[Int]] =
      Field("meanScore", OptionOf(Scalar()))
    def year: SelectionBuilder[YearStats, Option[Int]] =
      Field("year", OptionOf(Scalar()))
  }

  case class AiringScheduleInput(
      airingAt: Option[Int] = None,
      episode: Option[Int] = None,
      timeUntilAiring: Option[Int] = None
  )
  object AiringScheduleInput {
    implicit val encoder: ArgEncoder[AiringScheduleInput] =
      new ArgEncoder[AiringScheduleInput] {
        override def encode(value: AiringScheduleInput): Value =
          ObjectValue(
            List(
              "airingAt" -> value.airingAt.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[Int]].encode(value)
              ),
              "episode" -> value.episode.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[Int]].encode(value)
              ),
              "timeUntilAiring" -> value.timeUntilAiring.fold(NullValue: Value)(
                value => implicitly[ArgEncoder[Int]].encode(value)
              )
            )
          )
        override def typeName: String = "AiringScheduleInput"
      }
  }
  case class AniChartHighlightInput(
      highlight: Option[String] = None,
      mediaId: Option[Int] = None
  )
  object AniChartHighlightInput {
    implicit val encoder: ArgEncoder[AniChartHighlightInput] =
      new ArgEncoder[AniChartHighlightInput] {
        override def encode(value: AniChartHighlightInput): Value =
          ObjectValue(
            List(
              "highlight" -> value.highlight.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "mediaId" -> value.mediaId.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[Int]].encode(value)
              )
            )
          )
        override def typeName: String = "AniChartHighlightInput"
      }
  }
  case class CharacterNameInput(
      alternative: Option[List[Option[String]]] = None,
      first: Option[String] = None,
      last: Option[String] = None,
      native: Option[String] = None
  )
  object CharacterNameInput {
    implicit val encoder: ArgEncoder[CharacterNameInput] =
      new ArgEncoder[CharacterNameInput] {
        override def encode(value: CharacterNameInput): Value =
          ObjectValue(
            List(
              "alternative" -> value.alternative.fold(NullValue: Value)(value =>
                ListValue(
                  value.map(value =>
                    value.fold(NullValue: Value)(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
                )
              ),
              "first" -> value.first.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "last" -> value.last.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "native" -> value.native.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
        override def typeName: String = "CharacterNameInput"
      }
  }
  case class FuzzyDateInput(
      day: Option[Int] = None,
      month: Option[Int] = None,
      year: Option[Int] = None
  )
  object FuzzyDateInput {
    implicit val encoder: ArgEncoder[FuzzyDateInput] =
      new ArgEncoder[FuzzyDateInput] {
        override def encode(value: FuzzyDateInput): Value =
          ObjectValue(
            List(
              "day" -> value.day.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[Int]].encode(value)
              ),
              "month" -> value.month.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[Int]].encode(value)
              ),
              "year" -> value.year.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[Int]].encode(value)
              )
            )
          )
        override def typeName: String = "FuzzyDateInput"
      }
  }
  case class MediaExternalLinkInput(id: Int, site: String, url: String)
  object MediaExternalLinkInput {
    implicit val encoder: ArgEncoder[MediaExternalLinkInput] =
      new ArgEncoder[MediaExternalLinkInput] {
        override def encode(value: MediaExternalLinkInput): Value =
          ObjectValue(
            List(
              "id" -> implicitly[ArgEncoder[Int]].encode(value.id),
              "site" -> implicitly[ArgEncoder[String]].encode(value.site),
              "url" -> implicitly[ArgEncoder[String]].encode(value.url)
            )
          )
        override def typeName: String = "MediaExternalLinkInput"
      }
  }
  case class MediaListOptionsInput(
      advancedScoring: Option[List[Option[String]]] = None,
      advancedScoringEnabled: Option[Boolean] = None,
      customLists: Option[List[Option[String]]] = None,
      sectionOrder: Option[List[Option[String]]] = None,
      splitCompletedSectionByFormat: Option[Boolean] = None,
      theme: Option[String] = None
  )
  object MediaListOptionsInput {
    implicit val encoder: ArgEncoder[MediaListOptionsInput] =
      new ArgEncoder[MediaListOptionsInput] {
        override def encode(value: MediaListOptionsInput): Value =
          ObjectValue(
            List(
              "advancedScoring" -> value.advancedScoring.fold(NullValue: Value)(
                value =>
                  ListValue(
                    value.map(value =>
                      value.fold(NullValue: Value)(value =>
                        implicitly[ArgEncoder[String]].encode(value)
                      )
                    )
                  )
              ),
              "advancedScoringEnabled" -> value.advancedScoringEnabled.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
              "customLists" -> value.customLists.fold(NullValue: Value)(value =>
                ListValue(
                  value.map(value =>
                    value.fold(NullValue: Value)(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
                )
              ),
              "sectionOrder" -> value.sectionOrder.fold(NullValue: Value)(
                value =>
                  ListValue(
                    value.map(value =>
                      value.fold(NullValue: Value)(value =>
                        implicitly[ArgEncoder[String]].encode(value)
                      )
                    )
                  )
              ),
              "splitCompletedSectionByFormat" -> value.splitCompletedSectionByFormat
                .fold(NullValue: Value)(value =>
                  implicitly[ArgEncoder[Boolean]].encode(value)
                ),
              "theme" -> value.theme.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
        override def typeName: String = "MediaListOptionsInput"
      }
  }
  case class MediaTitleInput(
      english: Option[String] = None,
      native: Option[String] = None,
      romaji: Option[String] = None
  )
  object MediaTitleInput {
    implicit val encoder: ArgEncoder[MediaTitleInput] =
      new ArgEncoder[MediaTitleInput] {
        override def encode(value: MediaTitleInput): Value =
          ObjectValue(
            List(
              "english" -> value.english.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "native" -> value.native.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "romaji" -> value.romaji.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
        override def typeName: String = "MediaTitleInput"
      }
  }
  case class NotificationOptionInput(
      enabled: Option[Boolean] = None,
      `type`: Option[NotificationType] = None
  )
  object NotificationOptionInput {
    implicit val encoder: ArgEncoder[NotificationOptionInput] =
      new ArgEncoder[NotificationOptionInput] {
        override def encode(value: NotificationOptionInput): Value =
          ObjectValue(
            List(
              "enabled" -> value.enabled.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "type" -> value.`type`.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[NotificationType]].encode(value)
              )
            )
          )
        override def typeName: String = "NotificationOptionInput"
      }
  }
  case class StaffNameInput(
      alternative: Option[List[Option[String]]] = None,
      first: Option[String] = None,
      last: Option[String] = None,
      native: Option[String] = None
  )
  object StaffNameInput {
    implicit val encoder: ArgEncoder[StaffNameInput] =
      new ArgEncoder[StaffNameInput] {
        override def encode(value: StaffNameInput): Value =
          ObjectValue(
            List(
              "alternative" -> value.alternative.fold(NullValue: Value)(value =>
                ListValue(
                  value.map(value =>
                    value.fold(NullValue: Value)(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
                )
              ),
              "first" -> value.first.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "last" -> value.last.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "native" -> value.native.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
        override def typeName: String = "StaffNameInput"
      }
  }
  type Query = RootQuery
  object Query {

    /**
      * Activity query
      */
    def Activity[A](
        createdAt: Option[Int] = None,
        createdAt_greater: Option[Int] = None,
        createdAt_lesser: Option[Int] = None,
        hasReplies: Option[Boolean] = None,
        hasRepliesOrTypeText: Option[Boolean] = None,
        id: Option[Int] = None,
        id_in: Option[List[Option[Int]]] = None,
        id_not: Option[Int] = None,
        id_not_in: Option[List[Option[Int]]] = None,
        isFollowing: Option[Boolean] = None,
        mediaId: Option[Int] = None,
        mediaId_in: Option[List[Option[Int]]] = None,
        mediaId_not: Option[Int] = None,
        mediaId_not_in: Option[List[Option[Int]]] = None,
        messengerId: Option[Int] = None,
        messengerId_in: Option[List[Option[Int]]] = None,
        messengerId_not: Option[Int] = None,
        messengerId_not_in: Option[List[Option[Int]]] = None,
        sort: Option[List[Option[ActivitySort]]] = None,
        `type`: Option[ActivityType] = None,
        type_in: Option[List[Option[ActivityType]]] = None,
        type_not: Option[ActivityType] = None,
        type_not_in: Option[List[Option[ActivityType]]] = None,
        userId: Option[Int] = None,
        userId_in: Option[List[Option[Int]]] = None,
        userId_not: Option[Int] = None,
        userId_not_in: Option[List[Option[Int]]] = None
    )(
        onListActivity: SelectionBuilder[ListActivity, A],
        onMessageActivity: SelectionBuilder[MessageActivity, A],
        onTextActivity: SelectionBuilder[TextActivity, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "Activity",
        OptionOf(
          ChoiceOf(
            Map(
              "ListActivity" -> Obj(onListActivity),
              "MessageActivity" -> Obj(onMessageActivity),
              "TextActivity" -> Obj(onTextActivity)
            )
          )
        ),
        arguments = List(
          Argument("createdAt", createdAt),
          Argument("createdAt_greater", createdAt_greater),
          Argument("createdAt_lesser", createdAt_lesser),
          Argument("hasReplies", hasReplies),
          Argument("hasRepliesOrTypeText", hasRepliesOrTypeText),
          Argument("id", id),
          Argument("id_in", id_in),
          Argument("id_not", id_not),
          Argument("id_not_in", id_not_in),
          Argument("isFollowing", isFollowing),
          Argument("mediaId", mediaId),
          Argument("mediaId_in", mediaId_in),
          Argument("mediaId_not", mediaId_not),
          Argument("mediaId_not_in", mediaId_not_in),
          Argument("messengerId", messengerId),
          Argument("messengerId_in", messengerId_in),
          Argument("messengerId_not", messengerId_not),
          Argument("messengerId_not_in", messengerId_not_in),
          Argument("sort", sort),
          Argument("type", `type`),
          Argument("type_in", type_in),
          Argument("type_not", type_not),
          Argument("type_not_in", type_not_in),
          Argument("userId", userId),
          Argument("userId_in", userId_in),
          Argument("userId_not", userId_not),
          Argument("userId_not_in", userId_not_in)
        )
      )

    /**
      * Activity reply query
      */
    def ActivityReply[A](
        activityId: Option[Int] = None,
        id: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[ActivityReply, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "ActivityReply",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("activityId", activityId), Argument("id", id))
      )

    /**
      * Airing schedule query
      */
    def AiringSchedule[A](
        airingAt: Option[Int] = None,
        airingAt_greater: Option[Int] = None,
        airingAt_lesser: Option[Int] = None,
        episode: Option[Int] = None,
        episode_greater: Option[Int] = None,
        episode_in: Option[List[Option[Int]]] = None,
        episode_lesser: Option[Int] = None,
        episode_not: Option[Int] = None,
        episode_not_in: Option[List[Option[Int]]] = None,
        id: Option[Int] = None,
        id_in: Option[List[Option[Int]]] = None,
        id_not: Option[Int] = None,
        id_not_in: Option[List[Option[Int]]] = None,
        mediaId: Option[Int] = None,
        mediaId_in: Option[List[Option[Int]]] = None,
        mediaId_not: Option[Int] = None,
        mediaId_not_in: Option[List[Option[Int]]] = None,
        notYetAired: Option[Boolean] = None,
        sort: Option[List[Option[AiringSort]]] = None
    )(
        innerSelection: SelectionBuilder[AiringSchedule, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "AiringSchedule",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("airingAt", airingAt),
          Argument("airingAt_greater", airingAt_greater),
          Argument("airingAt_lesser", airingAt_lesser),
          Argument("episode", episode),
          Argument("episode_greater", episode_greater),
          Argument("episode_in", episode_in),
          Argument("episode_lesser", episode_lesser),
          Argument("episode_not", episode_not),
          Argument("episode_not_in", episode_not_in),
          Argument("id", id),
          Argument("id_in", id_in),
          Argument("id_not", id_not),
          Argument("id_not_in", id_not_in),
          Argument("mediaId", mediaId),
          Argument("mediaId_in", mediaId_in),
          Argument("mediaId_not", mediaId_not),
          Argument("mediaId_not_in", mediaId_not_in),
          Argument("notYetAired", notYetAired),
          Argument("sort", sort)
        )
      )
    def AniChartUser[A](
        innerSelection: SelectionBuilder[AniChartUser, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field("AniChartUser", OptionOf(Obj(innerSelection)))

    /**
      * Character query
      */
    def Character[A](
        id: Option[Int] = None,
        id_in: Option[List[Option[Int]]] = None,
        id_not: Option[Int] = None,
        id_not_in: Option[List[Option[Int]]] = None,
        search: Option[String] = None,
        sort: Option[List[Option[CharacterSort]]] = None
    )(
        innerSelection: SelectionBuilder[Character, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "Character",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("id", id),
          Argument("id_in", id_in),
          Argument("id_not", id_not),
          Argument("id_not_in", id_not_in),
          Argument("search", search),
          Argument("sort", sort)
        )
      )

    /**
      * Follow query
      */
    def Follower[A](sort: Option[List[Option[UserSort]]] = None, userId: Int)(
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "Follower",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("sort", sort), Argument("userId", userId))
      )

    /**
      * Follow query
      */
    def Following[A](sort: Option[List[Option[UserSort]]] = None, userId: Int)(
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "Following",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("sort", sort), Argument("userId", userId))
      )

    /**
      * Collection of all the possible media genres
      */
    def GenreCollection
        : SelectionBuilder[RootQuery, Option[List[Option[String]]]] =
      Field("GenreCollection", OptionOf(ListOf(OptionOf(Scalar()))))

    /**
      * Like query
      */
    def Like[A](
        likeableId: Option[Int] = None,
        `type`: Option[LikeableType] = None
    )(
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "Like",
        OptionOf(Obj(innerSelection)),
        arguments =
          List(Argument("likeableId", likeableId), Argument("type", `type`))
      )

    /**
      * Provide AniList markdown to be converted to html (Requires auth)
      */
    def Markdown[A](markdown: String)(
        innerSelection: SelectionBuilder[ParsedMarkdown, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "Markdown",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("markdown", markdown))
      )

    /**
      * Media query
      */
    def Media[A](
        averageScore: Option[Int] = None,
        averageScore_greater: Option[Int] = None,
        averageScore_lesser: Option[Int] = None,
        averageScore_not: Option[Int] = None,
        chapters: Option[Int] = None,
        chapters_greater: Option[Int] = None,
        chapters_lesser: Option[Int] = None,
        countryOfOrigin: Option[CountryCode] = None,
        duration: Option[Int] = None,
        duration_greater: Option[Int] = None,
        duration_lesser: Option[Int] = None,
        endDate: Option[FuzzyDateInt] = None,
        endDate_greater: Option[FuzzyDateInt] = None,
        endDate_lesser: Option[FuzzyDateInt] = None,
        endDate_like: Option[String] = None,
        episodes: Option[Int] = None,
        episodes_greater: Option[Int] = None,
        episodes_lesser: Option[Int] = None,
        format: Option[MediaFormat] = None,
        format_in: Option[List[Option[MediaFormat]]] = None,
        format_not: Option[MediaFormat] = None,
        format_not_in: Option[List[Option[MediaFormat]]] = None,
        genre: Option[String] = None,
        genre_in: Option[List[Option[String]]] = None,
        genre_not_in: Option[List[Option[String]]] = None,
        id: Option[Int] = None,
        idMal: Option[Int] = None,
        idMal_in: Option[List[Option[Int]]] = None,
        idMal_not: Option[Int] = None,
        idMal_not_in: Option[List[Option[Int]]] = None,
        id_in: Option[List[Option[Int]]] = None,
        id_not: Option[Int] = None,
        id_not_in: Option[List[Option[Int]]] = None,
        isAdult: Option[Boolean] = None,
        licensedBy: Option[String] = None,
        licensedBy_in: Option[List[Option[String]]] = None,
        minimumTagRank: Option[Int] = None,
        onList: Option[Boolean] = None,
        popularity: Option[Int] = None,
        popularity_greater: Option[Int] = None,
        popularity_lesser: Option[Int] = None,
        popularity_not: Option[Int] = None,
        search: Option[String] = None,
        season: Option[MediaSeason] = None,
        seasonYear: Option[Int] = None,
        sort: Option[List[Option[MediaSort]]] = None,
        source: Option[MediaSource] = None,
        source_in: Option[List[Option[MediaSource]]] = None,
        startDate: Option[FuzzyDateInt] = None,
        startDate_greater: Option[FuzzyDateInt] = None,
        startDate_lesser: Option[FuzzyDateInt] = None,
        startDate_like: Option[String] = None,
        status: Option[MediaStatus] = None,
        status_in: Option[List[Option[MediaStatus]]] = None,
        status_not: Option[MediaStatus] = None,
        status_not_in: Option[List[Option[MediaStatus]]] = None,
        tag: Option[String] = None,
        tagCategory: Option[String] = None,
        tagCategory_in: Option[List[Option[String]]] = None,
        tagCategory_not_in: Option[List[Option[String]]] = None,
        tag_in: Option[List[Option[String]]] = None,
        tag_not_in: Option[List[Option[String]]] = None,
        `type`: Option[MediaType] = None,
        volumes: Option[Int] = None,
        volumes_greater: Option[Int] = None,
        volumes_lesser: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "Media",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("averageScore", averageScore),
          Argument("averageScore_greater", averageScore_greater),
          Argument("averageScore_lesser", averageScore_lesser),
          Argument("averageScore_not", averageScore_not),
          Argument("chapters", chapters),
          Argument("chapters_greater", chapters_greater),
          Argument("chapters_lesser", chapters_lesser),
          Argument("countryOfOrigin", countryOfOrigin),
          Argument("duration", duration),
          Argument("duration_greater", duration_greater),
          Argument("duration_lesser", duration_lesser),
          Argument("endDate", endDate),
          Argument("endDate_greater", endDate_greater),
          Argument("endDate_lesser", endDate_lesser),
          Argument("endDate_like", endDate_like),
          Argument("episodes", episodes),
          Argument("episodes_greater", episodes_greater),
          Argument("episodes_lesser", episodes_lesser),
          Argument("format", format),
          Argument("format_in", format_in),
          Argument("format_not", format_not),
          Argument("format_not_in", format_not_in),
          Argument("genre", genre),
          Argument("genre_in", genre_in),
          Argument("genre_not_in", genre_not_in),
          Argument("id", id),
          Argument("idMal", idMal),
          Argument("idMal_in", idMal_in),
          Argument("idMal_not", idMal_not),
          Argument("idMal_not_in", idMal_not_in),
          Argument("id_in", id_in),
          Argument("id_not", id_not),
          Argument("id_not_in", id_not_in),
          Argument("isAdult", isAdult),
          Argument("licensedBy", licensedBy),
          Argument("licensedBy_in", licensedBy_in),
          Argument("minimumTagRank", minimumTagRank),
          Argument("onList", onList),
          Argument("popularity", popularity),
          Argument("popularity_greater", popularity_greater),
          Argument("popularity_lesser", popularity_lesser),
          Argument("popularity_not", popularity_not),
          Argument("search", search),
          Argument("season", season),
          Argument("seasonYear", seasonYear),
          Argument("sort", sort),
          Argument("source", source),
          Argument("source_in", source_in),
          Argument("startDate", startDate),
          Argument("startDate_greater", startDate_greater),
          Argument("startDate_lesser", startDate_lesser),
          Argument("startDate_like", startDate_like),
          Argument("status", status),
          Argument("status_in", status_in),
          Argument("status_not", status_not),
          Argument("status_not_in", status_not_in),
          Argument("tag", tag),
          Argument("tagCategory", tagCategory),
          Argument("tagCategory_in", tagCategory_in),
          Argument("tagCategory_not_in", tagCategory_not_in),
          Argument("tag_in", tag_in),
          Argument("tag_not_in", tag_not_in),
          Argument("type", `type`),
          Argument("volumes", volumes),
          Argument("volumes_greater", volumes_greater),
          Argument("volumes_lesser", volumes_lesser)
        )
      )

    /**
      * Media list query
      */
    def MediaList[A](
        compareWithAuthList: Option[Boolean] = None,
        completedAt: Option[FuzzyDateInt] = None,
        completedAt_greater: Option[FuzzyDateInt] = None,
        completedAt_lesser: Option[FuzzyDateInt] = None,
        completedAt_like: Option[String] = None,
        id: Option[Int] = None,
        isFollowing: Option[Boolean] = None,
        mediaId: Option[Int] = None,
        mediaId_in: Option[List[Option[Int]]] = None,
        mediaId_not_in: Option[List[Option[Int]]] = None,
        notes: Option[String] = None,
        notes_like: Option[String] = None,
        sort: Option[List[Option[MediaListSort]]] = None,
        startedAt: Option[FuzzyDateInt] = None,
        startedAt_greater: Option[FuzzyDateInt] = None,
        startedAt_lesser: Option[FuzzyDateInt] = None,
        startedAt_like: Option[String] = None,
        status: Option[MediaListStatus] = None,
        status_in: Option[List[Option[MediaListStatus]]] = None,
        status_not: Option[MediaListStatus] = None,
        status_not_in: Option[List[Option[MediaListStatus]]] = None,
        `type`: Option[MediaType] = None,
        userId: Option[Int] = None,
        userId_in: Option[List[Option[Int]]] = None,
        userName: Option[String] = None
    )(
        innerSelection: SelectionBuilder[MediaList, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "MediaList",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("compareWithAuthList", compareWithAuthList),
          Argument("completedAt", completedAt),
          Argument("completedAt_greater", completedAt_greater),
          Argument("completedAt_lesser", completedAt_lesser),
          Argument("completedAt_like", completedAt_like),
          Argument("id", id),
          Argument("isFollowing", isFollowing),
          Argument("mediaId", mediaId),
          Argument("mediaId_in", mediaId_in),
          Argument("mediaId_not_in", mediaId_not_in),
          Argument("notes", notes),
          Argument("notes_like", notes_like),
          Argument("sort", sort),
          Argument("startedAt", startedAt),
          Argument("startedAt_greater", startedAt_greater),
          Argument("startedAt_lesser", startedAt_lesser),
          Argument("startedAt_like", startedAt_like),
          Argument("status", status),
          Argument("status_in", status_in),
          Argument("status_not", status_not),
          Argument("status_not_in", status_not_in),
          Argument("type", `type`),
          Argument("userId", userId),
          Argument("userId_in", userId_in),
          Argument("userName", userName)
        )
      )

    /**
      * Media list collection query, provides list pre-grouped by status & custom lists. User ID and Media Type arguments required.
      */
    def MediaListCollection[A](
        chunk: Option[Int] = None,
        completedAt: Option[FuzzyDateInt] = None,
        completedAt_greater: Option[FuzzyDateInt] = None,
        completedAt_lesser: Option[FuzzyDateInt] = None,
        completedAt_like: Option[String] = None,
        forceSingleCompletedList: Option[Boolean] = None,
        notes: Option[String] = None,
        notes_like: Option[String] = None,
        perChunk: Option[Int] = None,
        sort: Option[List[Option[MediaListSort]]] = None,
        startedAt: Option[FuzzyDateInt] = None,
        startedAt_greater: Option[FuzzyDateInt] = None,
        startedAt_lesser: Option[FuzzyDateInt] = None,
        startedAt_like: Option[String] = None,
        status: Option[MediaListStatus] = None,
        status_in: Option[List[Option[MediaListStatus]]] = None,
        status_not: Option[MediaListStatus] = None,
        status_not_in: Option[List[Option[MediaListStatus]]] = None,
        `type`: Option[MediaType] = None,
        userId: Option[Int] = None,
        userName: Option[String] = None
    )(
        innerSelection: SelectionBuilder[MediaListCollection, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "MediaListCollection",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("chunk", chunk),
          Argument("completedAt", completedAt),
          Argument("completedAt_greater", completedAt_greater),
          Argument("completedAt_lesser", completedAt_lesser),
          Argument("completedAt_like", completedAt_like),
          Argument("forceSingleCompletedList", forceSingleCompletedList),
          Argument("notes", notes),
          Argument("notes_like", notes_like),
          Argument("perChunk", perChunk),
          Argument("sort", sort),
          Argument("startedAt", startedAt),
          Argument("startedAt_greater", startedAt_greater),
          Argument("startedAt_lesser", startedAt_lesser),
          Argument("startedAt_like", startedAt_like),
          Argument("status", status),
          Argument("status_in", status_in),
          Argument("status_not", status_not),
          Argument("status_not_in", status_not_in),
          Argument("type", `type`),
          Argument("userId", userId),
          Argument("userName", userName)
        )
      )

    /**
      * Collection of all the possible media tags
      */
    def MediaTagCollection[A](status: Option[Int] = None)(
        innerSelection: SelectionBuilder[MediaTag, A]
    ): SelectionBuilder[RootQuery, Option[List[Option[A]]]] =
      Field(
        "MediaTagCollection",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("status", status))
      )

    /**
      * Media Trend query
      */
    def MediaTrend[A](
        averageScore: Option[Int] = None,
        averageScore_greater: Option[Int] = None,
        averageScore_lesser: Option[Int] = None,
        averageScore_not: Option[Int] = None,
        date: Option[Int] = None,
        date_greater: Option[Int] = None,
        date_lesser: Option[Int] = None,
        episode: Option[Int] = None,
        episode_greater: Option[Int] = None,
        episode_lesser: Option[Int] = None,
        episode_not: Option[Int] = None,
        mediaId: Option[Int] = None,
        mediaId_in: Option[List[Option[Int]]] = None,
        mediaId_not: Option[Int] = None,
        mediaId_not_in: Option[List[Option[Int]]] = None,
        popularity: Option[Int] = None,
        popularity_greater: Option[Int] = None,
        popularity_lesser: Option[Int] = None,
        popularity_not: Option[Int] = None,
        releasing: Option[Boolean] = None,
        sort: Option[List[Option[MediaTrendSort]]] = None,
        trending: Option[Int] = None,
        trending_greater: Option[Int] = None,
        trending_lesser: Option[Int] = None,
        trending_not: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[MediaTrend, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "MediaTrend",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("averageScore", averageScore),
          Argument("averageScore_greater", averageScore_greater),
          Argument("averageScore_lesser", averageScore_lesser),
          Argument("averageScore_not", averageScore_not),
          Argument("date", date),
          Argument("date_greater", date_greater),
          Argument("date_lesser", date_lesser),
          Argument("episode", episode),
          Argument("episode_greater", episode_greater),
          Argument("episode_lesser", episode_lesser),
          Argument("episode_not", episode_not),
          Argument("mediaId", mediaId),
          Argument("mediaId_in", mediaId_in),
          Argument("mediaId_not", mediaId_not),
          Argument("mediaId_not_in", mediaId_not_in),
          Argument("popularity", popularity),
          Argument("popularity_greater", popularity_greater),
          Argument("popularity_lesser", popularity_lesser),
          Argument("popularity_not", popularity_not),
          Argument("releasing", releasing),
          Argument("sort", sort),
          Argument("trending", trending),
          Argument("trending_greater", trending_greater),
          Argument("trending_lesser", trending_lesser),
          Argument("trending_not", trending_not)
        )
      )

    /**
      * Notification query
      */
    def Notification[A](
        resetNotificationCount: Option[Boolean] = None,
        `type`: Option[NotificationType] = None,
        type_in: Option[List[Option[NotificationType]]] = None
    )(
        onActivityLikeNotification: SelectionBuilder[
          ActivityLikeNotification,
          A
        ],
        onActivityMentionNotification: SelectionBuilder[
          ActivityMentionNotification,
          A
        ],
        onActivityMessageNotification: SelectionBuilder[
          ActivityMessageNotification,
          A
        ],
        onActivityReplyLikeNotification: SelectionBuilder[
          ActivityReplyLikeNotification,
          A
        ],
        onActivityReplyNotification: SelectionBuilder[
          ActivityReplyNotification,
          A
        ],
        onActivityReplySubscribedNotification: SelectionBuilder[
          ActivityReplySubscribedNotification,
          A
        ],
        onAiringNotification: SelectionBuilder[AiringNotification, A],
        onFollowingNotification: SelectionBuilder[FollowingNotification, A],
        onRelatedMediaAdditionNotification: SelectionBuilder[
          RelatedMediaAdditionNotification,
          A
        ],
        onThreadCommentLikeNotification: SelectionBuilder[
          ThreadCommentLikeNotification,
          A
        ],
        onThreadCommentMentionNotification: SelectionBuilder[
          ThreadCommentMentionNotification,
          A
        ],
        onThreadCommentReplyNotification: SelectionBuilder[
          ThreadCommentReplyNotification,
          A
        ],
        onThreadCommentSubscribedNotification: SelectionBuilder[
          ThreadCommentSubscribedNotification,
          A
        ],
        onThreadLikeNotification: SelectionBuilder[ThreadLikeNotification, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "Notification",
        OptionOf(
          ChoiceOf(
            Map(
              "ActivityLikeNotification" -> Obj(onActivityLikeNotification),
              "ActivityMentionNotification" -> Obj(
                onActivityMentionNotification
              ),
              "ActivityMessageNotification" -> Obj(
                onActivityMessageNotification
              ),
              "ActivityReplyLikeNotification" -> Obj(
                onActivityReplyLikeNotification
              ),
              "ActivityReplyNotification" -> Obj(onActivityReplyNotification),
              "ActivityReplySubscribedNotification" -> Obj(
                onActivityReplySubscribedNotification
              ),
              "AiringNotification" -> Obj(onAiringNotification),
              "FollowingNotification" -> Obj(onFollowingNotification),
              "RelatedMediaAdditionNotification" -> Obj(
                onRelatedMediaAdditionNotification
              ),
              "ThreadCommentLikeNotification" -> Obj(
                onThreadCommentLikeNotification
              ),
              "ThreadCommentMentionNotification" -> Obj(
                onThreadCommentMentionNotification
              ),
              "ThreadCommentReplyNotification" -> Obj(
                onThreadCommentReplyNotification
              ),
              "ThreadCommentSubscribedNotification" -> Obj(
                onThreadCommentSubscribedNotification
              ),
              "ThreadLikeNotification" -> Obj(onThreadLikeNotification)
            )
          )
        ),
        arguments = List(
          Argument("resetNotificationCount", resetNotificationCount),
          Argument("type", `type`),
          Argument("type_in", type_in)
        )
      )
    def Page[A](page: Option[Int] = None, perPage: Option[Int] = None)(
        innerSelection: SelectionBuilder[Page, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "Page",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("page", page), Argument("perPage", perPage))
      )

    /**
      * Recommendation query
      */
    def Recommendation[A](
        id: Option[Int] = None,
        mediaId: Option[Int] = None,
        mediaRecommendationId: Option[Int] = None,
        onList: Option[Boolean] = None,
        rating: Option[Int] = None,
        rating_greater: Option[Int] = None,
        rating_lesser: Option[Int] = None,
        sort: Option[List[Option[RecommendationSort]]] = None,
        userId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[Recommendation, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "Recommendation",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("id", id),
          Argument("mediaId", mediaId),
          Argument("mediaRecommendationId", mediaRecommendationId),
          Argument("onList", onList),
          Argument("rating", rating),
          Argument("rating_greater", rating_greater),
          Argument("rating_lesser", rating_lesser),
          Argument("sort", sort),
          Argument("userId", userId)
        )
      )

    /**
      * Review query
      */
    def Review[A](
        id: Option[Int] = None,
        mediaId: Option[Int] = None,
        mediaType: Option[MediaType] = None,
        sort: Option[List[Option[ReviewSort]]] = None,
        userId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[Review, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "Review",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("id", id),
          Argument("mediaId", mediaId),
          Argument("mediaType", mediaType),
          Argument("sort", sort),
          Argument("userId", userId)
        )
      )

    /**
      * Site statistics query
      */
    def SiteStatistics[A](
        innerSelection: SelectionBuilder[SiteStatistics, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field("SiteStatistics", OptionOf(Obj(innerSelection)))

    /**
      * Staff query
      */
    def Staff[A](
        id: Option[Int] = None,
        id_in: Option[List[Option[Int]]] = None,
        id_not: Option[Int] = None,
        id_not_in: Option[List[Option[Int]]] = None,
        search: Option[String] = None,
        sort: Option[List[Option[StaffSort]]] = None
    )(
        innerSelection: SelectionBuilder[Staff, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "Staff",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("id", id),
          Argument("id_in", id_in),
          Argument("id_not", id_not),
          Argument("id_not_in", id_not_in),
          Argument("search", search),
          Argument("sort", sort)
        )
      )

    /**
      * Studio query
      */
    def Studio[A](
        id: Option[Int] = None,
        id_in: Option[List[Option[Int]]] = None,
        id_not: Option[Int] = None,
        id_not_in: Option[List[Option[Int]]] = None,
        search: Option[String] = None,
        sort: Option[List[Option[StudioSort]]] = None
    )(
        innerSelection: SelectionBuilder[Studio, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "Studio",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("id", id),
          Argument("id_in", id_in),
          Argument("id_not", id_not),
          Argument("id_not_in", id_not_in),
          Argument("search", search),
          Argument("sort", sort)
        )
      )

    /**
      * Thread query
      */
    def Thread[A](
        categoryId: Option[Int] = None,
        id: Option[Int] = None,
        id_in: Option[List[Option[Int]]] = None,
        mediaCategoryId: Option[Int] = None,
        replyUserId: Option[Int] = None,
        search: Option[String] = None,
        sort: Option[List[Option[ThreadSort]]] = None,
        subscribed: Option[Boolean] = None,
        userId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[Thread, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "Thread",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("categoryId", categoryId),
          Argument("id", id),
          Argument("id_in", id_in),
          Argument("mediaCategoryId", mediaCategoryId),
          Argument("replyUserId", replyUserId),
          Argument("search", search),
          Argument("sort", sort),
          Argument("subscribed", subscribed),
          Argument("userId", userId)
        )
      )

    /**
      * Comment query
      */
    def ThreadComment[A](
        id: Option[Int] = None,
        sort: Option[List[Option[ThreadCommentSort]]] = None,
        threadId: Option[Int] = None,
        userId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[ThreadComment, A]
    ): SelectionBuilder[RootQuery, Option[List[Option[A]]]] =
      Field(
        "ThreadComment",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("id", id),
          Argument("sort", sort),
          Argument("threadId", threadId),
          Argument("userId", userId)
        )
      )

    /**
      * User query
      */
    def User[A](
        id: Option[Int] = None,
        name: Option[String] = None,
        search: Option[String] = None,
        sort: Option[List[Option[UserSort]]] = None
    )(
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "User",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("id", id),
          Argument("name", name),
          Argument("search", search),
          Argument("sort", sort)
        )
      )

    /**
      * Get the currently authenticated user
      */
    def Viewer[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field("Viewer", OptionOf(Obj(innerSelection)))
  }

  type Mutation = RootMutation
  object Mutation {

    /**
      * Delete an activity item of the authenticated users
      */
    def DeleteActivity[A](id: Option[Int] = None)(
        innerSelection: SelectionBuilder[Deleted, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "DeleteActivity",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id))
      )

    /**
      * Delete an activity reply of the authenticated users
      */
    def DeleteActivityReply[A](id: Option[Int] = None)(
        innerSelection: SelectionBuilder[Deleted, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "DeleteActivityReply",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id))
      )

    /**
      * Delete a custom list and remove the list entries from it
      */
    def DeleteCustomList[A](
        customList: Option[String] = None,
        `type`: Option[MediaType] = None
    )(
        innerSelection: SelectionBuilder[Deleted, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "DeleteCustomList",
        OptionOf(Obj(innerSelection)),
        arguments =
          List(Argument("customList", customList), Argument("type", `type`))
      )

    /**
      * Delete a media list entry
      */
    def DeleteMediaListEntry[A](id: Option[Int] = None)(
        innerSelection: SelectionBuilder[Deleted, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "DeleteMediaListEntry",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id))
      )

    /**
      * Delete a review
      */
    def DeleteReview[A](id: Option[Int] = None)(
        innerSelection: SelectionBuilder[Deleted, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "DeleteReview",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id))
      )

    /**
      * Delete a thread
      */
    def DeleteThread[A](id: Option[Int] = None)(
        innerSelection: SelectionBuilder[Deleted, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "DeleteThread",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id))
      )

    /**
      * Delete a thread comment
      */
    def DeleteThreadComment[A](id: Option[Int] = None)(
        innerSelection: SelectionBuilder[Deleted, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "DeleteThreadComment",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id))
      )

    /**
      * Rate a review
      */
    def RateReview[A](
        rating: Option[ReviewRating] = None,
        reviewId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[Review, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "RateReview",
        OptionOf(Obj(innerSelection)),
        arguments =
          List(Argument("rating", rating), Argument("reviewId", reviewId))
      )

    /**
      * Create or update an activity reply
      */
    def SaveActivityReply[A](
        activityId: Option[Int] = None,
        asMod: Option[Boolean] = None,
        id: Option[Int] = None,
        text: Option[String] = None
    )(
        innerSelection: SelectionBuilder[ActivityReply, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "SaveActivityReply",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("activityId", activityId),
          Argument("asMod", asMod),
          Argument("id", id),
          Argument("text", text)
        )
      )

    /**
      * Update list activity (Mod Only)
      */
    def SaveListActivity[A](
        id: Option[Int] = None,
        locked: Option[Boolean] = None
    )(
        innerSelection: SelectionBuilder[ListActivity, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "SaveListActivity",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id), Argument("locked", locked))
      )

    /**
      * Create or update a media list entry
      */
    def SaveMediaListEntry[A](
        advancedScores: Option[List[Option[Double]]] = None,
        completedAt: Option[FuzzyDateInput] = None,
        customLists: Option[List[Option[String]]] = None,
        hiddenFromStatusLists: Option[Boolean] = None,
        id: Option[Int] = None,
        mediaId: Option[Int] = None,
        notes: Option[String] = None,
        priority: Option[Int] = None,
        `private`: Option[Boolean] = None,
        progress: Option[Int] = None,
        progressVolumes: Option[Int] = None,
        repeat: Option[Int] = None,
        score: Option[Double] = None,
        scoreRaw: Option[Int] = None,
        startedAt: Option[FuzzyDateInput] = None,
        status: Option[MediaListStatus] = None
    )(
        innerSelection: SelectionBuilder[MediaList, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "SaveMediaListEntry",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("advancedScores", advancedScores),
          Argument("completedAt", completedAt),
          Argument("customLists", customLists),
          Argument("hiddenFromStatusLists", hiddenFromStatusLists),
          Argument("id", id),
          Argument("mediaId", mediaId),
          Argument("notes", notes),
          Argument("priority", priority),
          Argument("private", `private`),
          Argument("progress", progress),
          Argument("progressVolumes", progressVolumes),
          Argument("repeat", repeat),
          Argument("score", score),
          Argument("scoreRaw", scoreRaw),
          Argument("startedAt", startedAt),
          Argument("status", status)
        )
      )

    /**
      * Create or update message activity for the currently authenticated user
      */
    def SaveMessageActivity[A](
        asMod: Option[Boolean] = None,
        id: Option[Int] = None,
        locked: Option[Boolean] = None,
        message: Option[String] = None,
        `private`: Option[Boolean] = None,
        recipientId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[MessageActivity, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "SaveMessageActivity",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("asMod", asMod),
          Argument("id", id),
          Argument("locked", locked),
          Argument("message", message),
          Argument("private", `private`),
          Argument("recipientId", recipientId)
        )
      )

    /**
      * Recommendation a media
      */
    def SaveRecommendation[A](
        mediaId: Option[Int] = None,
        mediaRecommendationId: Option[Int] = None,
        rating: Option[RecommendationRating] = None
    )(
        innerSelection: SelectionBuilder[Recommendation, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "SaveRecommendation",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("mediaId", mediaId),
          Argument("mediaRecommendationId", mediaRecommendationId),
          Argument("rating", rating)
        )
      )

    /**
      * Create or update a review
      */
    def SaveReview[A](
        body: Option[String] = None,
        id: Option[Int] = None,
        mediaId: Option[Int] = None,
        `private`: Option[Boolean] = None,
        score: Option[Int] = None,
        summary: Option[String] = None
    )(
        innerSelection: SelectionBuilder[Review, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "SaveReview",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("body", body),
          Argument("id", id),
          Argument("mediaId", mediaId),
          Argument("private", `private`),
          Argument("score", score),
          Argument("summary", summary)
        )
      )

    /**
      * Create or update text activity for the currently authenticated user
      */
    def SaveTextActivity[A](
        id: Option[Int] = None,
        locked: Option[Boolean] = None,
        text: Option[String] = None
    )(
        innerSelection: SelectionBuilder[TextActivity, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "SaveTextActivity",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("id", id),
          Argument("locked", locked),
          Argument("text", text)
        )
      )

    /**
      * Create or update a forum thread
      */
    def SaveThread[A](
        body: Option[String] = None,
        categories: Option[List[Option[Int]]] = None,
        id: Option[Int] = None,
        locked: Option[Boolean] = None,
        mediaCategories: Option[List[Option[Int]]] = None,
        sticky: Option[Boolean] = None,
        title: Option[String] = None
    )(
        innerSelection: SelectionBuilder[Thread, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "SaveThread",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("body", body),
          Argument("categories", categories),
          Argument("id", id),
          Argument("locked", locked),
          Argument("mediaCategories", mediaCategories),
          Argument("sticky", sticky),
          Argument("title", title)
        )
      )

    /**
      * Create or update a thread comment
      */
    def SaveThreadComment[A](
        comment: Option[String] = None,
        id: Option[Int] = None,
        parentCommentId: Option[Int] = None,
        threadId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[ThreadComment, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "SaveThreadComment",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("comment", comment),
          Argument("id", id),
          Argument("parentCommentId", parentCommentId),
          Argument("threadId", threadId)
        )
      )

    /**
      * Toggle the subscription of an activity item
      */
    def ToggleActivitySubscription[A](
        activityId: Option[Int] = None,
        subscribe: Option[Boolean] = None
    )(
        onListActivity: SelectionBuilder[ListActivity, A],
        onMessageActivity: SelectionBuilder[MessageActivity, A],
        onTextActivity: SelectionBuilder[TextActivity, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "ToggleActivitySubscription",
        OptionOf(
          ChoiceOf(
            Map(
              "ListActivity" -> Obj(onListActivity),
              "MessageActivity" -> Obj(onMessageActivity),
              "TextActivity" -> Obj(onTextActivity)
            )
          )
        ),
        arguments = List(
          Argument("activityId", activityId),
          Argument("subscribe", subscribe)
        )
      )

    /**
      * Favourite or unfavourite an anime, manga, character, staff member, or studio
      */
    def ToggleFavourite[A](
        animeId: Option[Int] = None,
        characterId: Option[Int] = None,
        mangaId: Option[Int] = None,
        staffId: Option[Int] = None,
        studioId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[Favourites, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "ToggleFavourite",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("animeId", animeId),
          Argument("characterId", characterId),
          Argument("mangaId", mangaId),
          Argument("staffId", staffId),
          Argument("studioId", studioId)
        )
      )

    /**
      * Toggle the un/following of a user
      */
    def ToggleFollow[A](userId: Option[Int] = None)(
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "ToggleFollow",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("userId", userId))
      )

    /**
      * Add or remove a like from a likeable type.
Returns all the users who liked the same model
      */
    def ToggleLike[A](
        id: Option[Int] = None,
        `type`: Option[LikeableType] = None
    )(
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[RootMutation, Option[List[Option[A]]]] =
      Field(
        "ToggleLike",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(Argument("id", id), Argument("type", `type`))
      )

    /**
      * Add or remove a like from a likeable type.
      */
    def ToggleLikeV2[A](
        id: Option[Int] = None,
        `type`: Option[LikeableType] = None
    )(
        onActivityReply: SelectionBuilder[ActivityReply, A],
        onListActivity: SelectionBuilder[ListActivity, A],
        onMessageActivity: SelectionBuilder[MessageActivity, A],
        onTextActivity: SelectionBuilder[TextActivity, A],
        onThread: SelectionBuilder[Thread, A],
        onThreadComment: SelectionBuilder[ThreadComment, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "ToggleLikeV2",
        OptionOf(
          ChoiceOf(
            Map(
              "ActivityReply" -> Obj(onActivityReply),
              "ListActivity" -> Obj(onListActivity),
              "MessageActivity" -> Obj(onMessageActivity),
              "TextActivity" -> Obj(onTextActivity),
              "Thread" -> Obj(onThread),
              "ThreadComment" -> Obj(onThreadComment)
            )
          )
        ),
        arguments = List(Argument("id", id), Argument("type", `type`))
      )

    /**
      * Toggle the subscription of a forum thread
      */
    def ToggleThreadSubscription[A](
        subscribe: Option[Boolean] = None,
        threadId: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[Thread, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "ToggleThreadSubscription",
        OptionOf(Obj(innerSelection)),
        arguments =
          List(Argument("subscribe", subscribe), Argument("threadId", threadId))
      )
    def UpdateAniChartHighlights(
        highlights: Option[List[Option[AniChartHighlightInput]]] = None
    ): SelectionBuilder[RootMutation, Option[Json]] =
      Field(
        "UpdateAniChartHighlights",
        OptionOf(Scalar()),
        arguments = List(Argument("highlights", highlights))
      )
    def UpdateAniChartSettings(
        outgoingLinkProvider: Option[String] = None,
        sort: Option[String] = None,
        theme: Option[String] = None,
        titleLanguage: Option[String] = None
    ): SelectionBuilder[RootMutation, Option[Json]] =
      Field(
        "UpdateAniChartSettings",
        OptionOf(Scalar()),
        arguments = List(
          Argument("outgoingLinkProvider", outgoingLinkProvider),
          Argument("sort", sort),
          Argument("theme", theme),
          Argument("titleLanguage", titleLanguage)
        )
      )

    /**
      * Update the order favourites are displayed in
      */
    def UpdateFavouriteOrder[A](
        animeIds: Option[List[Option[Int]]] = None,
        animeOrder: Option[List[Option[Int]]] = None,
        characterIds: Option[List[Option[Int]]] = None,
        characterOrder: Option[List[Option[Int]]] = None,
        mangaIds: Option[List[Option[Int]]] = None,
        mangaOrder: Option[List[Option[Int]]] = None,
        staffIds: Option[List[Option[Int]]] = None,
        staffOrder: Option[List[Option[Int]]] = None,
        studioIds: Option[List[Option[Int]]] = None,
        studioOrder: Option[List[Option[Int]]] = None
    )(
        innerSelection: SelectionBuilder[Favourites, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "UpdateFavouriteOrder",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("animeIds", animeIds),
          Argument("animeOrder", animeOrder),
          Argument("characterIds", characterIds),
          Argument("characterOrder", characterOrder),
          Argument("mangaIds", mangaIds),
          Argument("mangaOrder", mangaOrder),
          Argument("staffIds", staffIds),
          Argument("staffOrder", staffOrder),
          Argument("studioIds", studioIds),
          Argument("studioOrder", studioOrder)
        )
      )

    /**
      * Update multiple media list entries to the same values
      */
    def UpdateMediaListEntries[A](
        advancedScores: Option[List[Option[Double]]] = None,
        completedAt: Option[FuzzyDateInput] = None,
        hiddenFromStatusLists: Option[Boolean] = None,
        ids: Option[List[Option[Int]]] = None,
        notes: Option[String] = None,
        priority: Option[Int] = None,
        `private`: Option[Boolean] = None,
        progress: Option[Int] = None,
        progressVolumes: Option[Int] = None,
        repeat: Option[Int] = None,
        score: Option[Double] = None,
        scoreRaw: Option[Int] = None,
        startedAt: Option[FuzzyDateInput] = None,
        status: Option[MediaListStatus] = None
    )(
        innerSelection: SelectionBuilder[MediaList, A]
    ): SelectionBuilder[RootMutation, Option[List[Option[A]]]] =
      Field(
        "UpdateMediaListEntries",
        OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
        arguments = List(
          Argument("advancedScores", advancedScores),
          Argument("completedAt", completedAt),
          Argument("hiddenFromStatusLists", hiddenFromStatusLists),
          Argument("ids", ids),
          Argument("notes", notes),
          Argument("priority", priority),
          Argument("private", `private`),
          Argument("progress", progress),
          Argument("progressVolumes", progressVolumes),
          Argument("repeat", repeat),
          Argument("score", score),
          Argument("scoreRaw", scoreRaw),
          Argument("startedAt", startedAt),
          Argument("status", status)
        )
      )
    def UpdateUser[A](
        about: Option[String] = None,
        airingNotifications: Option[Boolean] = None,
        animeListOptions: Option[MediaListOptionsInput] = None,
        displayAdultContent: Option[Boolean] = None,
        donatorBadge: Option[String] = None,
        mangaListOptions: Option[MediaListOptionsInput] = None,
        notificationOptions: Option[List[Option[NotificationOptionInput]]] =
          None,
        profileColor: Option[String] = None,
        rowOrder: Option[String] = None,
        scoreFormat: Option[ScoreFormat] = None,
        titleLanguage: Option[UserTitleLanguage] = None
    )(
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "UpdateUser",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("about", about),
          Argument("airingNotifications", airingNotifications),
          Argument("animeListOptions", animeListOptions),
          Argument("displayAdultContent", displayAdultContent),
          Argument("donatorBadge", donatorBadge),
          Argument("mangaListOptions", mangaListOptions),
          Argument("notificationOptions", notificationOptions),
          Argument("profileColor", profileColor),
          Argument("rowOrder", rowOrder),
          Argument("scoreFormat", scoreFormat),
          Argument("titleLanguage", titleLanguage)
        )
      )
  }

}

