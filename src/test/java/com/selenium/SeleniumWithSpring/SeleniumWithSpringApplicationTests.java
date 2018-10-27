package com.selenium.SeleniumWithSpring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeleniumWithSpringApplicationTests {
    WebDriver driver ;
    String nameProduct;

    @Test
   public void test(){
       System.out.println("checkThisShit");
       TestNG testngRunner = new TestNG();
       List<String> suites = new ArrayList();
       suites.add("D:\\xampp\\htdocs\\JAVA\\SeleniumWithSpring\\src\\test\\java\\com\\selenium\\SeleniumWithSpring\\testng.xml");//path to xml..
       testngRunner .setTestSuites(suites);
       testngRunner .run();
   }

}
