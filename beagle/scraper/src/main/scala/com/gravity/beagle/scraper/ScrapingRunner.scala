package com.gravity.beagle.scraper

import org.joda.time.DateTime
import java.io.File
import org.apache.commons.io.FileUtils
import com.gravity.insights.crawler.Crawl


object ScrapingRunner {
  
  def main(args: Array[String]) {
    
    println("starting up Scraping Runner ")
    val crawler = new Crawl()
    crawler.url = "http://sitethathasdata"
    
    println("about to scrape some data")
    crawler.crawl()

  }

}
