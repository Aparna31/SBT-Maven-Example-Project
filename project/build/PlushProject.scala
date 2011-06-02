import sbt._


class PlushProject(info: ProjectInfo) extends DefaultProject(info) {
  

  // Create a link to use our existing maven repository
  val mavenLocal = "Local Maven Repository" at "file://" + (Path.userHome / ".m2" / "repository").absolutePath;

  // This is one of our projects that will have subprojects nested underneath it
  lazy val insights = project("insights", "Insights Analytics", new InsightsProject(_));

  lazy val beagle = project("beagle", "Beagle Scraper", new BeagleProject(_));

  lazy val plush = project("plush", "Jim Plush Project" )

  lazy val utilities = project("utilities", "utilities", new Utilities(_))
  
  lazy val jimtest = runTask(Some("com.gravity.beagle.scraper.ScrapingRunner"), runClasspath).dependsOn(compile) describedAs "Runs the demo."
    
  // if you want to override the class that runs when you type in "run" from the sbt console
  //override def mainClass = Some("com.gravity.beagle.scraper.ScrapingRunner")

  // if you want to run this guy do: run-scraper   from the sbt command line in the console
  lazy val runScraper = task { args =>
    runTask(Some("com.gravity.beagle.scraper.ScrapingRunner"), runClasspath, args).dependsOn(compile)
  } describedAs "Example of how to run a main method in a subproject"


  class InsightsProject(info: ProjectInfo) extends ParentProject(info)
  {
    
    lazy val crawler = project("crawler", "Web Crawler")
    lazy val processor = project("processor", "Processes Stuff")

  }


  class BeagleProject(info: ProjectInfo) extends ParentProject(info)
  {
    lazy val scraper = project("scraper", "Data Scraper", utilities )


  }

  class Utilities(info: ProjectInfo) extends DefaultProject(info)
  {


  }

}
