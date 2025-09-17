package helper;

import mx.desarollo.entity.Usuario;

public class LoginHelper {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";

    public Usuario login(String usuario, String password) {
        if (USERNAME.equals(usuario) && PASSWORD.equals(password)) {
            return new Usuario(usuario, password);
        } else {
            return null;
        }
    }
}
