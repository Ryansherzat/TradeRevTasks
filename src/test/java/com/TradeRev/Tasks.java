package com.TradeRev;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class Tasks {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    /*
    Scenario 1: check whether Canada TradeRev career page is displayed properly
1.     Visit https://www.traderev.com/en-ca/
2.     Navigate to “Careers” page
3.     The Careers page should be displayed properly
4.     Click on “Canadian Opportunities”
5.     Validate whether Canadian job site is displayed properly
     */
    @Test
    public  void scenario1() {

        driver.get("https://www.traderev.com/en-ca/");

        driver.findElement(By.xpath("//a[.=' Careers ']")).click();

        Set<String> allWindows = driver.getWindowHandles();
        for (String curWindow : allWindows) {
            driver.switchTo().window(curWindow);
        }

        driver.findElement(By.xpath("//a[@title='Canadian Jobs']")).click();
        Set handles = driver.getWindowHandles();
        String[] individualHandle = new String[handles.size()];
        Iterator it = handles.iterator();
        int i = 0;
        while (it.hasNext()) {
            individualHandle[i] = (String) it.next();
            i++;
        }
        driver.switchTo().window(individualHandle[2]);

       List<WebElement> locations = driver.findElements(By.xpath("//span[@class='sort-by-location posting-category small-category-label']"));

        for (WebElement item : locations) {
            boolean match = false;
            if (item.getText().contains("CANADA")){
                match = true;
            }
            Assert.assertTrue(match);
        }
    }
    ////////////////////////////////
    /*    Scenario 2: check whether job filter (city) is working properly
    1.      Visit https://jobs.lever.co/traderev
    2.      Filter the Search results by City “Toronto, Ontario, Canada”
    3.      All the job results displayed should belong to “Toronto, Ontario, Canada” validate this.
     */
        @Test
        public  void scenario2() {
            driver.get("https://jobs.lever.co/traderev");
            driver.findElement(By.xpath("//div[.='Location']")).click();
            driver.findElement(By.xpath("//a[.='Toronto, Ontario, Canada']")).click();
            List<WebElement> location = driver.findElements(By.xpath("//span[.='Toronto, Ontario, Canada']"));
            String expectResult="TORONTO, ONTARIO, CANADA";
            for (WebElement item : location) {
               boolean match = false;
                   if (item.getText().equalsIgnoreCase(expectResult)){
                       match = true;
                    }

                Assert.assertTrue(match);

        }
        }
  ////////////////////////////////////////
/*
Scenario 3: check whether job filter (city) and (team) is working properly
1.      Visit https://jobs.lever.co/traderev
2.      Filter the Search results by City “Toronto, Ontario, Canada” and Team “Engineering”
3.      All the job results displayed should belong to region “Toronto, Ontario, Canada” and “Engineering” team, prove this.
4.     Finally log the total available positions listed
 */

    @Test
    public  void scenario3() {
        driver.get("https://jobs.lever.co/traderev");
        driver.findElement(By.xpath("//div[.='Location']")).click();
        driver.findElement(By.xpath("//a[.='Toronto, Ontario, Canada']")).click();
        driver.findElement(By.xpath("//div[.='Team']")).click();
        driver.findElement(By.xpath("//a[.='Engineering']")).click();

        List<WebElement> location = driver.findElements(By.xpath("//span[.='Toronto, Ontario, Canada']"));
        String expectResult = "TORONTO, ONTARIO, CANADA";
        for (WebElement item : location) {
            boolean match = false;
            if (item.getText().equalsIgnoreCase(expectResult)) {
                match = true;
            }

            Assert.assertTrue(match);

        }

        List<WebElement> teamType = driver.findElements(By.xpath("//span[starts-with(., 'Engineering')]"));
        for (WebElement item : teamType) {
            boolean match = false;
            if (item.getText().contains("ENGINEERING")) {
                match = true;

            }
            Assert.assertTrue(match);
        }

    }
        // 4.     Finally log the total available positions listed
        @Test
    public  void scenario4() {

            driver.get("https://jobs.lever.co/traderev");
            driver.findElement(By.xpath("//div[.='Location']")).click();
            driver.findElement(By.xpath("(//a[.='All'])[1]")).click();
            driver.findElement(By.xpath("//div[.='Team']")).click();
            driver.findElement(By.xpath("(//a[.='All'])[2]")).click();
            driver.findElement(By.xpath("//div[.='Work type']")).click();
            driver.findElement(By.xpath("(//a[.='All'])[3]")).click();

            List<WebElement> positions = driver.findElements(By.xpath("//h5[@data-qa]"));

            for (WebElement item : positions) {
                System.out.println("Position Name " + item.getText());
            }
           // Assert.assertEquals(positions.size(),34);

        }



    @AfterMethod
        public void tearDown(){
        driver.quit();
        }


}
