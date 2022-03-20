package bo.edu.ucb.twitter.demotwitter.dto;


import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Configuration
@EnableCaching
@ControllerAdvice
public class Twetts {

    @Id
    @GeneratedValue

    private Integer idTwett;
    private String texto;
    private Date timestamp;
    private Integer idTweet_idUser;

    public Twetts(){

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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getIdTweet_idUser() {
        return idTweet_idUser;
    }

    public void setIdTweet_idUser(Integer idTweet_idUser) {
        this.idTweet_idUser = idTweet_idUser;
    }
}
