package bo.edu.ucb.twitter.demotwitter.bl;


import bo.edu.ucb.twitter.demotwitter.dao.TimelineDao;
import bo.edu.ucb.twitter.demotwitter.dto.Timeline;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TimelineBl {

   /* @Autowired
    CacheManager cacheManager;*/

    //public static final String MY_KEY = "mykey";

    private TimelineDao timelineDao;

    public TimelineBl(TimelineDao timelineDao){this.timelineDao=timelineDao;}


    //@Cacheable(value = "address_cache", key = "#root.target.MY_KEY")
    //@Cacheable("usuarioline")
    @Cacheable(value = "address_cache", key = "#usuarioline")
    public List<Timeline> getTweetsLine(Integer usuarioline) {

        return timelineDao.getTweetsLine(usuarioline);
    }

    @Bean
    public Caffeine caffeineConfig() {
        return Caffeine.newBuilder().expireAfterWrite(4, TimeUnit.MINUTES);
    }

    @Bean
    public CacheManager cacheManager(Caffeine caffeine) {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(caffeine);
        return caffeineCacheManager;
    }
}
