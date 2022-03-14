package bo.edu.ucb.twitter.demotwitter.api;


import bo.edu.ucb.twitter.demotwitter.bl.TwettsBl;
import bo.edu.ucb.twitter.demotwitter.dto.Seguidores;
import bo.edu.ucb.twitter.demotwitter.dto.Twetts;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/twetts")
public class TwettsApi {
    TwettsBl twettsBl;

    public TwettsApi(TwettsBl twettsBl){this.twettsBl=twettsBl;}

    @RequestMapping(path = "/post",method = RequestMethod.POST)
    public Twetts postTwetear(@RequestBody Twetts twetts){
        Twetts sendTweet=twettsBl.postTwetear(twetts);
        return sendTweet;
    }
}
