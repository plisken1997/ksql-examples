package net.plsk.ksqlExamples.data.serDes

import org.scalacheck.Gen
import org.scalatest.prop.PropertyChecks

import scala.annotation.tailrec

object GenShowOpinion extends PropertyChecks {

  sealed trait Category

  case object Drama extends Category
  case object PoliceDrama extends Category
  case object CrimeThriller extends Category
  case object CrimeDrama extends Category
  case object PoliticalThriller extends Category
  case object EspionageThriller extends Category
  case object SoapOpera extends Category
  case object Thriller extends Category
  case object Comedy extends Category
  case object RomanticComedy extends Category
  case object BlackComedy extends Category
  case object Action extends Category
  case object Documentary extends Category
  case object Sport extends Category
  case object History extends Category
  case object Tragedy extends Category
  case object Sitcom extends Category
  case object GameShow extends Category
  case object SciFi extends Category
  case object Dystopian extends Category
  case object Fantasy extends Category
  case object Horror extends Category

  val categories: List[Category] =
    List(
      Drama,
      PoliceDrama,
      CrimeThriller,
      CrimeDrama,
      PoliticalThriller,
      EspionageThriller,
      SoapOpera,
      Thriller,
      Comedy,
      RomanticComedy,
      BlackComedy,
      Action,
      Documentary,
      Sport,
      History,
      Tragedy,
      Sitcom,
      GameShow,
      SciFi,
      Dystopian,
      Fantasy,
      Horror
    )

  sealed trait Network

  case object Showtime extends Network
  case object Canalplus extends Network
  case object AMC extends Network
  case object ABC extends Network
  case object NBC extends Network
  case object CHANNEL4 extends Network
  case object BBCONE extends Network
  case object UNKNOWN extends Network
  case object ZDF extends Network
  case object Das_Erste extends Network
  case object CBS extends Network
  case object FRANCE2 extends Network
  case object FRANCE3 extends Network
  case object ANTENNE2 extends Network
  case object TF1 extends Network
  case object RTVE extends Network
  case object Antena3 extends Network
  case object NETFLIX extends Network
  case object NetworkTen extends Network
  case object BBCTwo extends Network
  case object ITV extends Network
  case object E4 extends Network
  case object FOX extends Network
  case object TheWb extends Network
  case object HBO extends Network
  case object FX extends Network
  case object TheCW extends Network

  val networks: List[Network] =
    List(
      Showtime,
      Canalplus,
      AMC,
      ABC,
      NBC,
      CHANNEL4,
      BBCONE,
      UNKNOWN,
      ZDF,
      Das_Erste,
      CBS,
      FRANCE2,
      FRANCE3,
      ANTENNE2,
      TF1,
      RTVE,
      Antena3,
      NETFLIX,
      NetworkTen,
      BBCTwo,
      ITV,
      E4,
      FOX,
      TheWb,
      HBO,
      FX,
      TheCW
    )

  sealed trait Country
  case object US extends Country
  case object FR extends Country
  case object UK extends Country
  case object DE extends Country
  case object ES extends Country
  case object AU extends Country

  case class Show(name: String,
                  originalNetwork: Network,
                  category: Seq[Category],
                  country: Country,
                  numberOfSeason: Int,
                  year: Int)

  sealed trait Source

  case object Twitter extends Source
  case object Facebook extends Source
  case object `4chan` extends Source
  case object Redit extends Source
  case object Forum extends Source

  case class User(name: String, age: Int, source: Source)

  case class Opinion(ranking: Float, comment: String, likes: Seq[Category])

  case class ShowOpinion(
      show: Show,
      user: User,
      opinion: Opinion
  )

  val shows: List[Show] = List(
    Show("homeland", Showtime, Seq(CrimeThriller, PoliticalThriller, Drama, EspionageThriller), US, 8, 2011),
    Show("Baron noir", Canalplus, Seq(PoliticalThriller), FR, 2, 2016),
    Show("Desperate Housewives", ABC, Seq(SoapOpera), US, 8, 2004),
    Show("Breaking bad", AMC, Seq(CrimeDrama, BlackComedy), US, 5, 2008),
    Show("Better call Saul", AMC, Seq(CrimeDrama, BlackComedy, Tragedy), US, 4, 2015),
    Show("Saved by the Bell", NBC, Seq(Sitcom, Comedy), US, 5, 1989),
    Show("Friends", NBC, Seq(Sitcom, Comedy), US, 10, 1994),
    Show("Luther", BBCONE, Seq(CrimeDrama), UK, 4, 2010),
    Show("Utopia", CHANNEL4, Seq(Thriller, Dystopian), UK, 2, 2013),
    Show("Derrick", ZDF, Seq(Thriller, PoliceDrama), DE, 10, 1974),
    Show("Tatort", Das_Erste, Seq(PoliceDrama), DE, 45, 1970),
    Show("Powder park", UNKNOWN, Seq(Drama), DE, 1, 2001),
    Show("CSI", CBS, Seq(PoliceDrama, CrimeThriller), US, 15, 2000),
    Show("Le groupe", FRANCE2, Seq(Sitcom, Comedy), FR, 1, 2001),
    Show("Seconde B", ANTENNE2, Seq(Sitcom, Drama), FR, 2, 1993),
    Show("Extrême Limite", TF1, Seq(Drama), FR, 2, 1994),
    Show("Plus belle la vie", FRANCE3, Seq(Drama, Comedy), FR, 15, 2004),
    Show("Hélène et les garçons", TF1, Seq(Sitcom, Comedy), FR, 1, 1992),
    Show("Camping paradis", TF1, Seq(Sitcom, Comedy), FR, 9, 2006),
    Show("Un, dos, tres", RTVE, Seq(GameShow), ES, 6, 2002),
    Show("La casa de papel", Antena3, Seq(Drama, CrimeThriller, CrimeDrama), ES, 1, 2017),
    Show("Elite", NETFLIX, Seq(Drama), ES, 2, 2018),
    Show("Velvet", Antena3, Seq(Drama), ES, 4, 2014),
    Show("Heartbreak High", NetworkTen, Seq(Drama), AU, 7, 1994),
    Show("Top of the Lake", BBCTwo, Seq(Drama, CrimeThriller), AU, 3, 2013),
    Show("Borgia", Canalplus, Seq(Drama, History), DE, 3, 2011),
    Show("Le bureau des légendes", Canalplus, Seq(Drama, EspionageThriller), FR, 4, 2015),
    Show("Engrenages", Canalplus, Seq(PoliceDrama), FR, 6, 2005),
    Show("Au service de la France", NETFLIX, Seq(EspionageThriller, Comedy), FR, 2, 2015),
    Show("Platane", Canalplus, Seq(Comedy), FR, 2, 2011),
    Show("Peaky blinders", BBCTwo, Seq(Action, CrimeDrama), UK, 4, 2013),
    Show("Black mirror", CHANNEL4, Seq(Dystopian, SciFi), UK, 4, 2011),
    Show("Doctor Who", NBC, Seq(SciFi, Drama), UK, 37, 1963),
    Show("Sherlock", BBCONE, Seq(CrimeDrama), UK, 4, 2010),
    Show("Downton Abbey", ITV, Seq(History, Drama), UK, 6, 2010),
    Show("The fall", BBCTwo, Seq(CrimeDrama, Thriller), UK, 3, 2013),
    Show("Misfits", E4, Seq(Action, BlackComedy, SciFi, Drama), UK, 5, 2009),
    Show("21 jump street", FOX, Seq(PoliceDrama), US, 5, 1987),
    Show("Buffy the vampire slayer", TheWb, Seq(Action, Comedy, Drama, Horror), US, 7, 1997),
    Show("How I met your mother", CBS, Seq(Sitcom, Comedy, RomanticComedy), US, 10, 2005),
    Show("The wire", HBO, Seq(CrimeDrama), US, 5, 2002),
    Show("Boardwalk Empire", HBO, Seq(CrimeDrama, History), US, 5, 2010),
    Show("The Fresh Prince of Bel-Air", NBC, Seq(Sitcom, Comedy), US, 6, 1990),
    Show("X-Files", FOX, Seq(Drama, SciFi, Thriller), US, 11, 1993),
    Show("Sons of anarchy", FX, Seq(CrimeDrama, Tragedy), US, 7, 2008),
    Show("Fargo", FX, Seq(CrimeDrama, BlackComedy), US, 3, 2014),
    Show("Silicon valley", HBO, Seq(Comedy), US, 5, 2014),
    Show("Gossip girl", TheCW, Seq(Drama), US, 6, 2007),
    Show("Beverly Hills, 90210", FOX, Seq(Drama, SoapOpera), US, 10, 1990),
    Show("Game of thrones", HBO, Seq(Drama, Fantasy), US, 8, 2011),
    Show("OZ", HBO, Seq(CrimeDrama, BlackComedy), US, 6, 1997),
    Show("Melrose place", FOX, Seq(SoapOpera), US, 7, 1992),
    Show("True detective", HBO, Seq(CrimeDrama), US, 2, 2014),
    Show("Twin peaks", ABC, Seq(Drama, Comedy, Horror), US, 3, 1990),
    Show("Pacific blue", UNKNOWN, Seq(PoliceDrama), US, 5, 1996),
    Show("Stranger things", NETFLIX, Seq(SciFi, Horror), US, 2, 2016),
    Show("Mad men", AMC, Seq(Drama, History), US, 7, 2007),
    Show("Charmed", TheWb, Seq(Drama, Comedy, Horror), US, 8, 1998),
    Show("Sex & the city", HBO, Seq(RomanticComedy, Drama), US, 6, 1998),
    Show("The sopranos", HBO, Seq(CrimeDrama), US, 6, 1999),
    Show("Dawson's Creek", TheWb, Seq(Drama), US, 6, 1998),
    Show("Ally McBeal", FOX, Seq(Drama, RomanticComedy), US, 5, 1997),
    Show("Prison break", FOX, Seq(CrimeDrama, Action), US, 5, 2005)
  )

  case class GenerationMaxAttemptReachedException(maxAttempts: Int)
      extends Exception(s"max attempt reached ($maxAttempts) !")

  val generationMaxAttempts = 5

  @tailrec
  final def createFixtures(generationMaxAttempt: Int = generationMaxAttempts): ShowOpinion =
    if (generationMaxAttempt == 0)
      throw GenerationMaxAttemptReachedException(generationMaxAttempts)
    else {
      val gameOpinion: Option[ShowOpinion] = for {
        show <- Gen.oneOf(shows).sample
        userName <- Gen
          .oneOf("Gerard", "laura", "Raf du 69", "lili", "JS", "Joe", "Simone", "zatopek", "Lol", "me", "Kevin")
          .sample
        userAge <- Gen.oneOf(18 to 60).sample
        source <- Gen.oneOf(Twitter, Facebook, Redit, Forum, `4chan`).sample
        ranking <- Gen.oneOf(1 to 5).sample
        comment <- Gen
          .oneOf(
            "Donec non nulla eu nulla porta cursus vel eget leo. Vivamus a nisi enim. Nulla dignissim lacus orci, in convallis.",
            "Nulla ipsum elit, ullamcorper nec rutrum et, bibendum a nisi. Morbi non odio diam. Etiam auctor, eros rhoncus accumsan dictum.",
            "Maecenas elit nunc, blandit quis ultricies ut, dictum at eros. Quisque dui elit, rutrum non sapien at, placerat aliquet odio.",
            "Mauris non vestibulum justo. Praesent gravida orci ut odio accumsan rhoncus. In rutrum nisl eu odio sodales, eu lacinia nibh.",
            "Morbi nec faucibus ante, sed luctus erat. Integer dui metus, venenatis scelerisque tincidunt a, lacinia ac mi. Fusce blandit a.",
            "Quisque varius egestas lectus, non maximus libero rhoncus ut. Sed faucibus tortor ligula. Phasellus scelerisque ligula vel massa tempus varius.",
            "Integer et nunc vestibulum, egestas dui ornare, varius dui. Proin vitae venenatis neque. Vivamus eget hendrerit mi, a posuere diam.",
            "Curabitur dictum nisi consequat eros tincidunt auctor. Duis dictum neque nec laoreet dapibus. Nunc dignissim in neque et ultricies. Morbi aliquet sed.",
            "Praesent vel volutpat ante. Aenean dictum in risus ut tincidunt. Vestibulum venenatis iaculis porta. Nulla tellus diam massa nunc.",
            "Morbi eget augue mauris. Pellentesque tincidunt euismod vulputate. Nullam ac augue ac arcu feugiat scelerisque. Aliquam cras amet.",
            "Mauris egestas nec lectus a iaculis. Pellentesque euismod, mi a finibus commodo, turpis metus porta erat, eu sodales tellus metus."
          )
          .sample
        likes <- Gen.someOf(categories).sample
      } yield
        ShowOpinion(
          show,
          User(userName, userAge, source),
          Opinion(ranking, comment, likes)
        )
      if (gameOpinion.isDefined) gameOpinion.get
      else createFixtures(generationMaxAttempt - 1)
    }

  def generateFakeElements(gen: Int): List[ShowOpinion] = (0 to gen).toList.map(_ => createFixtures())

  def streamGameOpinions(gen: Option[Int] = None): Stream[ShowOpinion] =
    gen.fold(Stream.from(0).map { cpt =>
      createFixtures()
    }) { maxGen =>
      (0 to maxGen).toStream.map(_ => createFixtures())
    }
}
