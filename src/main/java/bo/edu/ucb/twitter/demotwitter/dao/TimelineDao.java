package bo.edu.ucb.twitter.demotwitter.dao;


import bo.edu.ucb.twitter.demotwitter.dto.Timeline;
import bo.edu.ucb.twitter.demotwitter.dto.Twetts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Component
@EnableAutoConfiguration
public class TimelineDao {

    private DataSource dataSource;

    @Autowired
    public TimelineDao(DataSource dataSource){
        this.dataSource=dataSource;
    }

    public List<Timeline> getTweetsLine(Integer usuarioline) {
        System.out.println("ENTRE 1");
        List<Timeline> lineadetiempo = new ArrayList<>();
        //Timeline lineadetiempo=null;
        String query = "SELECT s.usuarioS, " +
                "   s.userFollow, " +
                "   t.idTwett, " +
                "   t.texto, " +
                "   t.idTweet_idUser, " +
                "   u.idUser " +
                "   FROM seguidores s, usuarios u, twetts t " +
                "   WHERE "+
                "         s.usuarios=u.idUser AND "+
                "         u.idUser=t.idTweet_idUser AND " +
                "         s.userFollow= ? "+
                "         LIMIT 4 OFFSET 1 ";
        //SELECT s.usuarioS, s.userFollow, t.idTwett, t.texto, t.idTweet_idUser, u.idUser FROM seguidores s, usuarios u, twetts t WHERE s.userFollow=1 AND s.usuarios=u.idUser AND u.idUser=t.idTweet_idUser ORDER BY rand() LIMIT 4;
        System.out.println("ENTRE 2");
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
        ) {
            System.out.println(query);
            //pstmt.setString(0, "%"+nombre[0].toUpperCase()+ "%");
            pstmt.setInt(1, usuarioline);
            ResultSet rs =  pstmt.executeQuery();
            while(rs.next()){
                Timeline timeline = new Timeline();
                timeline.setIdUser(rs.getInt("idUser"));
                timeline.setIdTweet_idUser(rs.getInt("idTweet_idUser"));
                timeline.setIdTwett(rs.getInt("idTwett"));
                timeline.setTexto(rs.getString("texto"));
                timeline.setUsuarioS(rs.getInt("usuarioS"));
                timeline.setUserFollow(rs.getInt("userFollow"));
                lineadetiempo.add(timeline);
                System.out.println("ENTRE 3");
            }

            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // TODO gestionar correctamente la excepción
        }
        return lineadetiempo;
    }

}
