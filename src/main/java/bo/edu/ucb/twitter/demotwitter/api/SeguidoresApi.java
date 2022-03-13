package bo.edu.ucb.twitter.demotwitter.api;


import bo.edu.ucb.twitter.demotwitter.bl.SeguidoresBl;
import bo.edu.ucb.twitter.demotwitter.dto.Seguidores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seguidores")
public class SeguidoresApi {

    SeguidoresBl seguidoresBl;

    @Autowired
    public SeguidoresApi(SeguidoresBl seguidoresBl){this.seguidoresBl=seguidoresBl;}

    @RequestMapping(path = "/post",method = RequestMethod.POST)
    public Seguidores postSeguir(@RequestBody Seguidores seguidores){
        Seguidores seguirInf=seguidoresBl.postSeguir(seguidores);
        return seguirInf;
    }


}
