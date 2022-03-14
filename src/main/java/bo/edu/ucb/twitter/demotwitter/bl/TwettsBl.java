package bo.edu.ucb.twitter.demotwitter.bl;


import bo.edu.ucb.twitter.demotwitter.dao.TwettsDao;
import bo.edu.ucb.twitter.demotwitter.dto.Twetts;
import org.springframework.stereotype.Service;

@Service
public class TwettsBl {
    private TwettsDao twettsDao;

    public TwettsBl(TwettsDao twettsDao){this.twettsDao=twettsDao;}


    public Twetts postTwetear(Twetts twetts){
        return twettsDao.postTwetear(twetts);
    }

}
