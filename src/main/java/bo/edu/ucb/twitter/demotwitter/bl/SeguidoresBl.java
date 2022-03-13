package bo.edu.ucb.twitter.demotwitter.bl;


import bo.edu.ucb.twitter.demotwitter.dao.SeguidoresDao;
import bo.edu.ucb.twitter.demotwitter.dto.Seguidores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeguidoresBl {

    private SeguidoresDao seguidoresDao;


    public SeguidoresBl(SeguidoresDao seguidoresDao){
        this.seguidoresDao=seguidoresDao;
    }

    public Seguidores postSeguir(Seguidores seguidores){
        return seguidoresDao.postSeguir(seguidores);
    }

}
