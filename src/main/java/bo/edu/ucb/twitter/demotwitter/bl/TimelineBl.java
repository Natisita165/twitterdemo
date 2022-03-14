package bo.edu.ucb.twitter.demotwitter.bl;


import bo.edu.ucb.twitter.demotwitter.dao.TimelineDao;
import bo.edu.ucb.twitter.demotwitter.dto.Timeline;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineBl {

    private TimelineDao timelineDao;

    public TimelineBl(TimelineDao timelineDao){this.timelineDao=timelineDao;}

    public List<Timeline> getTweetsLine(Integer usuarioline) {
        return timelineDao.getTweetsLine(usuarioline);
    }
}
