package bo.edu.ucb.twitter.demotwitter.api;


import bo.edu.ucb.twitter.demotwitter.bl.UsuariosBl;
import bo.edu.ucb.twitter.demotwitter.dto.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuariosApi {

    UsuariosBl usuariosBl;

    @Autowired
    public UsuariosApi(UsuariosBl usuariosBl){this.usuariosBl=usuariosBl;}

    @RequestMapping(path = "/post",method = RequestMethod.POST)
    public Usuarios postUsuario(@RequestBody Usuarios usuarios){
        Usuarios usuarioInf = usuariosBl.postUsuario(usuarios);
        return usuarioInf;
    }
}
