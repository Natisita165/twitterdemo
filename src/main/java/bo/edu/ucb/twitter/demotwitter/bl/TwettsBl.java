package bo.edu.ucb.twitter.demotwitter.bl;


import bo.edu.ucb.twitter.demotwitter.dao.TwettsDao;
import bo.edu.ucb.twitter.demotwitter.dto.Twetts;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TwettsBl {
    private TwettsDao twettsDao;
    /*@Autowired
    CacheManager cacheManager;*/

   // public static final String MY_KEY = "mykey";

    public TwettsBl(TwettsDao twettsDao){this.twettsDao=twettsDao;}


    //@Cacheable(value = "address_cache", key = "'#twetts'")
    //@Cacheable(value = "address_cache", key = "#root.target.MY_KEY")
    //@CachePut("twetts")
    public Twetts postTwetear(Twetts twetts){
        return twettsDao.postTwetear(twetts);
    }

    /*@Bean
    public Caffeine caffeineConfig() {
        return Caffeine.newBuilder().expireAfterWrite(4, TimeUnit.MINUTES);
    }

    @Bean
    public CacheManager cacheManager(Caffeine caffeine) {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(caffeine);
        return caffeineCacheManager;
    }*/

}
