package com.selenium.SeleniumWithSpring.Controllers;

import com.selenium.SeleniumWithSpring.SeleniumWithSpringApplication;
import com.selenium.SeleniumWithSpring.domain.Product;
import com.selenium.SeleniumWithSpring.domain.Site;
import com.selenium.SeleniumWithSpring.domain.repository.ProductRepository;
import com.selenium.SeleniumWithSpring.domain.repository.SiteRepository;
import com.selenium.SeleniumWithSpring.services.SiteServices;
import org.junit.runner.RunWith;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

//@SpringApplicationConfiguration(classes = Application.class)
@Controller
public class HomeControllerClassicTest {

    @Autowired
    SeleniumWithSpringApplication seleniumWithSpringApplication;
    @Autowired
    SiteServices siteServices;
    @Autowired
    SiteRepository siteRepository;
    @Autowired
    ProductRepository productRepository;

    String productWithootSendingToPolandTest = "https://www.amazon.de/Samsung-S24D330H-Monitor-Reaktionszeit-schwarz/dp/B01HRYELC4/ref=pd_pgd_B014RKZ81O_B01HRYELC4/260-1556928-2729048?pf_rd_m=A3JWKAKR8XB7XF&pf_rd_s=lpo-top-stripe&pf_rd_r=BD67MPBZZ17QNAJC6N55&pf_rd_r=BD67MPBZZ17QNAJC6N55&pf_rd_t=201&pf_rd_p=29354430-6579-4ff3-aa4e-37a83f02706e&pf_rd_p=29354430-6579-4ff3-aa4e-37a83f02706e&pf_rd_i=B014RKZ81O";
    String DellOptiPlex3050Test = "https://www.amazon.de/gp/product/B06X92JDQS/ref=s9u_psimh_gw_i4?ie=UTF8&pd_rd_i=B06X92JDQS&pd_rd_r=63ae6613-5794-11e8-befb-bde8ffa61ecb&pd_rd_w=NXm6e&pd_rd_wg=HtVXd&pf_rd_m=A3JWKAKR8XB7XF&pf_rd_s=&pf_rd_r=G5T38R6DZFGGPHV4X1Q1&pf_rd_t=36701&pf_rd_p=1c175abe-9bc7-490b-bbe1-2caf7e752c98&pf_rd_i=desktop";
    String productToTestSendingToPoland = "https://www.amazon.de/dp/B00H3JIGHA/ref=dp_cerb_1";


    @RequestMapping("mainPage")
    public String mainPage(Model model) {
        System.out.println("with main");
        productRepository.getAllProducts();
        List<Product> products = productRepository.getAllProducts() ;
        List<Site> sites = siteRepository.getAllSites() ;
        model.addAttribute("products" , products);
        model.addAttribute("sites" , sites);
        return "mainPage";
    }
    @RequestMapping("addNewSite")
    public String addNewSite(Model model) {
        System.out.println("with main");
        Site site = new Site();
        model.addAttribute("site", site);
        return "addNewSite";
    }

@RequestMapping(value = "runTest" ,  method = RequestMethod.POST)
    public String runTest(Site site) {
        String url = site.getUrl();
        siteRepository.createSite(url);
        siteServices.setUpPL();
        siteServices.loadCookie();
        List<String>product = siteServices.testConditionProduct(url);
        if (product != null)
        {
            String condition   = product.get(0);
            System.out.println(condition);
            String price       = product.get(1);
            String nameProduct = product.get(2);
            productRepository.createProduct(nameProduct, price, condition);

        }
        siteServices.quit();
        return "redirect:/mainPage";
    }

}
