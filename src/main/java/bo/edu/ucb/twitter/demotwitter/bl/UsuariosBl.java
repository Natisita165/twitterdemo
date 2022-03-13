package bo.edu.ucb.twitter.demotwitter.bl;

import bo.edu.ucb.twitter.demotwitter.dao.UsuariosDao;
import bo.edu.ucb.twitter.demotwitter.dto.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosBl {
    private UsuariosDao usuariosDao;

    @Autowired
    public UsuariosBl(UsuariosDao usuariosDao){
        this.usuariosDao = usuariosDao;
    }


    public Usuarios postUsuario(Usuarios usuarios) {
        return usuariosDao.postUsuarios(usuarios);
    }
}
