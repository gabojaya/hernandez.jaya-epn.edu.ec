package Framework;
/**
 * Definici�n de variables globales constantes 
 * Configuraciones del estado de aplicacion
 * singleton with enum
 */
public enum APP {
    GLOBAL;
    public final  String  DB_NAME           = "DB_NAME";
    public final  String  DB_PATH           = "DB_PATH";  
    public static final String HJNOMBRE1_COMPLETO = "Gabriel Alexander Jaya Singo";
    public static final String HJCEDULA1 = "1754242632";
    public static final String HJNOMBRE2_COMPLETO = "Cristian Andrés Hernández Silva";

    //Constantes con definicion  
    private final String  EXCEPTION_UNDEFINED;
    private final String  EXCEPTION_UNDEFINED_CLASS;
    private final Boolean LOG_ON_OFF;
    private final Double  PI        ;
     
    APP(){
        //Configuraciones del estado de aplicacion
        EXCEPTION_UNDEFINED_CLASS   = "Excepci�n sin decripci�n de clase ";
        EXCEPTION_UNDEFINED         = "Excepci�n sin decripci�n";
        LOG_ON_OFF          = true;
        PI                  = 1.14;
    }

    public Double  getPI()          {   return  PI; }
    public Boolean getLogOnOff()    {   return  LOG_ON_OFF; }
    public String  getExceptionUndefined()      {   return  EXCEPTION_UNDEFINED; }
    public String  getExceptionUndefinedClass() {   return  EXCEPTION_UNDEFINED_CLASS; }
}
