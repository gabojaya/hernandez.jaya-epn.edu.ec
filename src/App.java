import java.util.List;

import Framework.APP;
import utilitario.HandleInOutput;

public class App {
    public static String User;
    public static final String Tema = "\t ------------------------------------------ \n\t\t  NETWORK DE EXAMEN \n\t ------------------------------------------ ";
    public static void main(String[] args) throws Exception {
        System.out.println("Cabezon!");
        System.out.println(APP.HJNOMBRE1_COMPLETO);
        HandleInOutput.clear();
        System.out.println("\n\n\n"+ Tema);
        login();
    }


    public static boolean login()
    {
        int intentos = 2;
        List<String> usuariosClaves = List.of("patmicpatmic","pat_micpat_mic","profesores1234567");
        do
        {
            System.out.println("\n\n \t\t ........................ ");
            String u = HandleInOutput.getCaracteres  ("\t\t +  usuario: ");
            String c = u + HandleInOutput.getCaracteres  ("\t\t +  clave  : ");
            System.out.println("\t\t ........................ ");
            for (String uc : usuariosClaves) 
                if( c.equals(uc))
                {
                    User = u.toUpperCase();
                    System.out.println("\n :: Bienvenido "+ User);
                    return true;
                }
            System.out.println("\t\t * Nro de intentos: "+ --intentos );
        } while (intentos > 0);
        System.out.println("\n\n \t :(  Lo sentimos tu usuario y clave son incorrectos..! " );
        return false;
    }
}
