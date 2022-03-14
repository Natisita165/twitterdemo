package bo.edu.ucb.twitter.demotwitter.dto;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class Usuarios {
    private Integer idUser;
    private String username;


    public Usuarios(){

    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
