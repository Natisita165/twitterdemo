package bo.edu.ucb.twitter.demotwitter.dao;


import bo.edu.ucb.twitter.demotwitter.dto.Seguidores;
import bo.edu.ucb.twitter.demotwitter.dto.Twetts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
@EnableAutoConfiguration
public class TwettsDao {
    private DataSource dataSource;

    @Autowired
    public TwettsDao(DataSource dataSource){
        this.dataSource=dataSource;
    }

    public Twetts postTwetear(Twetts twetts) {
        System.out.println("ENTRE GG 1");
        String query = "INSERT INTO twetts VALUES (NULL,?,NOW(),?);";

        System.out.println("ENTRE GG 2");
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
        ) {
            System.out.println("ENTRE GG"+query);
            pstmt.setString(1, twetts.getTexto());
            pstmt.setInt(2,twetts.getIdTweet_idUser());


            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            // TODO gestionar correctamente la excepción
        }
        return twetts;
    }
}
