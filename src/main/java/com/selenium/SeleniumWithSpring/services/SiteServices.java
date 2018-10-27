package com.selenium.SeleniumWithSpring.services;

import com.selenium.SeleniumWithSpring.domain.repository.SiteRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Transactional
@Service
public class SiteServices {

    SiteRepository siteRepository;
    WebDriver driver;

    public SiteServices() {

    }

    public void setUpPL() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        String start = "https://www.amazon.de/ref=nav_logo";
        driver.get(start);
    }

    public void loadCookie() {

        String name = "lc-acbde";
        String value = "pl_PL";
        String domain = ".amazon.de";
        String path = "/";
        Date expiry = new Date(2036, 01, 01, 8, 00, 00);
        Cookie ck = new Cookie(name, value, domain, path, expiry);
        driver.manage().addCookie(ck);
    }

    public List<String> testConditionProduct(String url) {

        List<String> productDescriptionList = new ArrayList<String>();
        ;
        String condition;
        String price;
        String nameProduct;
        driver.get(url);

        String notSendingToPoland = driver.findElement(By.cssSelector("#ddmDeliveryMessage")).getText();
        if ((notSendingToPoland.equals("Ten sprzedawca nie realizuje dostaw na adres: Polska. Więcej informacji"))) {
            System.out.println("Produkt nie jest wysyłany do Polski");
            return null;
        } else {
            productDescriptionList.add(0, condition = driver.findElement(By.cssSelector("#availability > span")).getText());
            try {
                price = driver.findElement(By.cssSelector("#priceblock_ourprice")).getText();
                productDescriptionList.add(1, price);
            } catch (Exception e) {
                price = driver.findElement(By.cssSelector("#priceblock_dealprice")).getText();
                productDescriptionList.add(1, price);
            }
            productDescriptionList.add(2, nameProduct = driver.findElement(By.cssSelector("#productTitle")).getText());
            return productDescriptionList;
        }
    }

    public void quit() {
        driver.quit();
    }
}
