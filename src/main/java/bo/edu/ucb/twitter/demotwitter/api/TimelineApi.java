package bo.edu.ucb.twitter.demotwitter.api;


import bo.edu.ucb.twitter.demotwitter.bl.TimelineBl;
import bo.edu.ucb.twitter.demotwitter.customKey.CustomKeyGenerator;
import bo.edu.ucb.twitter.demotwitter.dto.Timeline;
import bo.edu.ucb.twitter.demotwitter.dto.Twetts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timeline")
@CacheConfig(cacheNames = {"timelines"})
public class TimelineApi {
    TimelineBl timelineBl;

    @Autowired
    public TimelineApi(TimelineBl timelineBl){this.timelineBl=timelineBl;}

    @Autowired
    private CustomKeyGenerator customKeyGenerator;

    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    @Cacheable(key = "#id")
    public List<Timeline> getTweetsLine(@PathVariable(value = "id",required = false) Integer id){
        List<Timeline> obtenerLinea = timelineBl.getTweetsLine(id);
        return obtenerLinea;
    }
}
