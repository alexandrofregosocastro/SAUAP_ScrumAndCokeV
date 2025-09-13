package helper;

import mx.desarollo.entity.Usuario;

public class LoginHelper {
    private static final String username = "User";
    private static final String password = "Password";

    public Usuario login(String usuario, String password) {
        if(usuario.equals(username) && password.equals(password)){
            return new Usuario(usuario, password);
        }
        else{
            return null;
        }
    }
}
