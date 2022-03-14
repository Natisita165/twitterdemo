package bo.edu.ucb.twitter.demotwitter.api;


import bo.edu.ucb.twitter.demotwitter.bl.TimelineBl;
import bo.edu.ucb.twitter.demotwitter.dto.Timeline;
import bo.edu.ucb.twitter.demotwitter.dto.Twetts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timeline")
public class TimelineApi {
    TimelineBl timelineBl;

    @Autowired
    public TimelineApi(TimelineBl timelineBl){this.timelineBl=timelineBl;}

    @RequestMapping(path = "/get",method = RequestMethod.GET)
    public List<Timeline> getTweetsLine(@RequestParam(value = "usuarioline",required = false) Integer usuarioline){
        List<Timeline> obtenerLinea = timelineBl.getTweetsLine(usuarioline);
        return obtenerLinea;
    }
}
