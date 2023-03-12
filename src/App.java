import java.util.List;

import Framework.APP;
import UserInterface.Login;
import utilitario.HandleInOutput;

public class App {
    public static String User;
    public static final String Tema = "\t ------------------------------------------ \n\t\t  NETWORK DE EXAMEN \n\t ------------------------------------------ ";
    public static void main(String[] args) throws Exception {
        System.out.println("Cabezon!");
        System.out.println(APP.HJNOMBRE1_COMPLETO);
        HandleInOutput.clear();
        System.out.println("\n\n\n"+ Tema);
        // Crear y hacer visible la pantalla de login
    Login login = new Login();
    login.setVisible(true);
    }
}
