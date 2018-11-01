package net.plsk.ksqlExamples.data.serDes.json

import net.plsk.ksqlExamples.data.serDes.GenShowOpinion._
import play.api.libs.json._
import io.leonard.TraitFormat.{caseObjectFormat, traitFormat}

object JsonShowOpinionSerDes {

  implicit val sourceFormat = traitFormat[Source] << caseObjectFormat(Twitter) << caseObjectFormat(Facebook) << caseObjectFormat(
    `4chan`) << caseObjectFormat(Redit) << caseObjectFormat(Forum)

  implicit val categoryFormat =
    traitFormat[Category] << caseObjectFormat(Drama) << caseObjectFormat(PoliceDrama) << caseObjectFormat(CrimeThriller) << caseObjectFormat(
      CrimeDrama) << caseObjectFormat(PoliticalThriller) << caseObjectFormat(EspionageThriller) << caseObjectFormat(
      SoapOpera) << caseObjectFormat(Thriller) << caseObjectFormat(Comedy) << caseObjectFormat(RomanticComedy) << caseObjectFormat(
      BlackComedy) << caseObjectFormat(Action) << caseObjectFormat(Documentary) << caseObjectFormat(Sport) << caseObjectFormat(
      History) << caseObjectFormat(Tragedy) << caseObjectFormat(Sitcom) << caseObjectFormat(GameShow) << caseObjectFormat(
      SciFi) << caseObjectFormat(Dystopian) << caseObjectFormat(Fantasy) << caseObjectFormat(Horror)

  implicit val countryFormat = traitFormat[Country] << caseObjectFormat(FR) << caseObjectFormat(US) << caseObjectFormat(
    UK) << caseObjectFormat(DE) << caseObjectFormat(ES) << caseObjectFormat(AU)

  implicit val networkFormat =
    traitFormat[Network] << caseObjectFormat(Showtime) << caseObjectFormat(Canalplus) << caseObjectFormat(AMC) << caseObjectFormat(
      ABC) << caseObjectFormat(NBC) << caseObjectFormat(CHANNEL4) << caseObjectFormat(BBCONE) << caseObjectFormat(
      UNKNOWN) << caseObjectFormat(ZDF) << caseObjectFormat(Das_Erste) << caseObjectFormat(CBS) << caseObjectFormat(
      FRANCE2) << caseObjectFormat(FRANCE3) << caseObjectFormat(ANTENNE2) << caseObjectFormat(TF1) << caseObjectFormat(
      RTVE) << caseObjectFormat(Antena3) << caseObjectFormat(NETFLIX) << caseObjectFormat(NetworkTen) << caseObjectFormat(
      BBCTwo) << caseObjectFormat(ITV) << caseObjectFormat(E4) << caseObjectFormat(FOX) << caseObjectFormat(TheWb) << caseObjectFormat(
      HBO) << caseObjectFormat(FX) << caseObjectFormat(TheCW)

  implicit val showFormat = Json.format[Show]

  implicit val userFormat = Json.format[User]

  implicit val opinionFormat = Json.format[Opinion]

  implicit val gameOpinionFormat = Json.format[ShowOpinion]
}
