package bo.edu.ucb.twitter.demotwitter.dto;


import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Date;

@ControllerAdvice
public class Twetts {
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
