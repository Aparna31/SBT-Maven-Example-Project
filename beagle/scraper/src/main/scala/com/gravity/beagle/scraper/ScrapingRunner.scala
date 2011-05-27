package com.gravity.beagle.scraper

import org.joda.time.DateTime
import java.io.File
import org.apache.commons.io.FileUtils
import com.gravity.insights.crawler.Crawl


object ScrapingRunner {
  
  def main(args: Array[String]) {
    

    println("This is a sample multi module set up using maven and sbt")

    // example of using a dependency on JodaTime and using it
    val dt = new DateTime();
    println("Datetime is: %s".format(dt.toString()));

    // example of using a dependency from our own project structure in insights/crawler
    val crawler = new Crawl()
    crawler.url = "http://techcrunch.com"
    crawler.crawl()


  }

}
