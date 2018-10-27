package com.selenium.SeleniumWithSpring.domain.repository;

import com.selenium.SeleniumWithSpring.domain.Product;
import com.selenium.SeleniumWithSpring.domain.Site;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class SiteRepository {

    Site site ;
    @PersistenceContext
    private EntityManager em ;
//    public void getSite(){
//        site.getUrl();
//    }

    @Transactional
    public Site createSite(String url) {

        Site site = new Site( url) ;
        em.persist(site);

        return site;
    }

    public List<Site> getAllSites() {
        Query query = em.createQuery("SELECT e FROM Site e");
        List<Site> sites = query.getResultList();
        return sites;
    }
}
