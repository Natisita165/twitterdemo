package bo.edu.ucb.twitter.demotwitter.dto;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public class Seguidores {
    private Integer idUserFollow;
    private Integer idUserFollow_idUser;

    public Seguidores(){

    }

    public Integer getIdUserFollow() {
        return idUserFollow;
    }

    public void setIdUserFollow(Integer idUserFollow) {
        this.idUserFollow = idUserFollow;
    }

    public Integer getIdUserFollow_idUser() {
        return idUserFollow_idUser;
    }

    public void setIdUserFollow_idUser(Integer idUserFollow_idUser) {
        this.idUserFollow_idUser = idUserFollow_idUser;
    }
}
