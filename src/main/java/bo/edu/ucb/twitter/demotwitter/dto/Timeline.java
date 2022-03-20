package bo.edu.ucb.twitter.demotwitter.dto;


import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Configuration
@EnableCaching
@ControllerAdvice
public class Timeline {

    @Id
    @GeneratedValue

    //twetts
    private Integer idTwett;
    private String texto;
    private Integer idTweet_idUser;

    //usuarios
    private Integer idUser;

    //Seguidores
    private Integer usuarioS;
    private Integer userFollow;

    public Timeline(){

    }

    public Integer getIdTwett() {
        return idTwett;
    }

    public void setIdTwett(Integer idTwett) {
        this.idTwett = idTwett;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getIdTweet_idUser() {
        return idTweet_idUser;
    }

    public void setIdTweet_idUser(Integer idTweet_idUser) {
        this.idTweet_idUser = idTweet_idUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
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
