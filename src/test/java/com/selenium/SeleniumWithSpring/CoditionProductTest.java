package com.selenium.SeleniumWithSpring;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CoditionProductTest {

    WebDriver driver ;
    String nameProduct;

    @BeforeTest
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        String start = "https://www.amazon.de/ref=nav_logo";
        driver.get(start);
        addCookiePL();

    }
    public void addCookiePL(){
        String name     = "lc-acbde";
        String value    = "pl_PL";
        String domain   = ".amazon.de";
        String path     = "/";
        Date expiry = new Date(2036,01,01,8,00,00);
        Cookie ck =  new Cookie(name,value ,domain, path , expiry);
        driver.manage().addCookie(ck);
    }
    @org.testng.annotations.Test
    public void testProductView(){

        String productWithootSendingToPoland = "https://www.amazon.de/Samsung-S24D330H-Monitor-Reaktionszeit-schwarz/dp/B01HRYELC4/ref=pd_pgd_B014RKZ81O_B01HRYELC4/260-1556928-2729048?pf_rd_m=A3JWKAKR8XB7XF&pf_rd_s=lpo-top-stripe&pf_rd_r=BD67MPBZZ17QNAJC6N55&pf_rd_r=BD67MPBZZ17QNAJC6N55&pf_rd_t=201&pf_rd_p=29354430-6579-4ff3-aa4e-37a83f02706e&pf_rd_p=29354430-6579-4ff3-aa4e-37a83f02706e&pf_rd_i=B014RKZ81O";
        String DellOptiPlex3050 =              "https://www.amazon.de/gp/product/B06X92JDQS/ref=s9u_psimh_gw_i4?ie=UTF8&pd_rd_i=B06X92JDQS&pd_rd_r=63ae6613-5794-11e8-befb-bde8ffa61ecb&pd_rd_w=NXm6e&pd_rd_wg=HtVXd&pf_rd_m=A3JWKAKR8XB7XF&pf_rd_s=&pf_rd_r=G5T38R6DZFGGPHV4X1Q1&pf_rd_t=36701&pf_rd_p=1c175abe-9bc7-490b-bbe1-2caf7e752c98&pf_rd_i=desktop";
        String productToTest    = "https://www.amazon.de/dp/B00H3JIGHA/ref=dp_cerb_1";
        driver.get(productToTest);

        String notSendingToPoland = driver.findElement(By.cssSelector("#ddmDeliveryMessage")).getText();
        if((notSendingToPoland.equals("Ten sprzedawca nie realizuje dostaw na adres: Polska. Więcej informacji"))){
            System.out.println("Produkt nie jest wysyłany do Polski");
        }else {
            String condition = driver.findElement(By.cssSelector("#availability > span")).getText();
            String price = driver.findElement(By.cssSelector("#priceblock_ourprice")).getText();
            nameProduct = driver.findElement(By.cssSelector("#productTitle")).getText();
            System.out.println(nameProduct);
            System.out.println(condition);
            System.out.println(price);
            System.out.println(notSendingToPoland);
        }

    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }

}
