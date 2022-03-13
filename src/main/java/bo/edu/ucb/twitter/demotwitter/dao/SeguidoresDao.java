package bo.edu.ucb.twitter.demotwitter.dao;


import bo.edu.ucb.twitter.demotwitter.dto.Seguidores;
import bo.edu.ucb.twitter.demotwitter.dto.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
@EnableAutoConfiguration
public class SeguidoresDao {

    private DataSource dataSource;

    @Autowired
    public SeguidoresDao(DataSource dataSource){
        this.dataSource=dataSource;
    }
    public Seguidores postSeguir(Seguidores seguidores) {
        System.out.println("ENTRE GG 1");
        String query = "INSERT INTO usuarios VALUES (?,?);";

        System.out.println("ENTRE GG 2");
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
        ) {
            System.out.println("ENTRE GG"+query);
            pstmt.setInt(1, seguidores.getIdUserFollow());
            pstmt.setInt(2,seguidores.getIdUserFollow_idUser());


            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            // TODO gestionar correctamente la excepción
        }
        return seguidores;
    }
}
