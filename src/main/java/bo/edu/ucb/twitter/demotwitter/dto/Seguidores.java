package bo.edu.ucb.twitter.demotwitter.dto;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class Seguidores {
    private Integer usuarioS;
    private Integer userFollow;

    public Seguidores() {

    }

    public Integer getUsuarioS() {
        return usuarioS;
    }

    public void setUsuarioS(Integer usuarioS) {
        this.usuarioS = usuarioS;
    }

    public Integer getUserFollow() {
        return userFollow;
    }

    public void setUserFollow(Integer userFollow) {
        this.userFollow = userFollow;
    }
}