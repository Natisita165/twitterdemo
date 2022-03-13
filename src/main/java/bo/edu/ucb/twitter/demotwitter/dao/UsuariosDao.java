package bo.edu.ucb.twitter.demotwitter.dao;

import bo.edu.ucb.twitter.demotwitter.dto.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@Component
public class UsuariosDao {

    private DataSource dataSource;

    @Autowired
    public UsuariosDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public Usuarios postUsuarios(Usuarios usuarios) {
        System.out.println("ENTRE GG 1");
        String query = "INSERT INTO usuarios VALUES (null,?);";

        System.out.println("ENTRE GG 2");
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
        ) {
            System.out.println("ENTRE GG"+query);
            pstmt.setInt(1, usuarios.getIdUser());
            pstmt.setString(2,usuarios.getUsername());


            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            // TODO gestionar correctamente la excepción
        }
        return usuarios;
    }
}
