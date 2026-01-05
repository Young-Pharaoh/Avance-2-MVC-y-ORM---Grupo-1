package orm;

/**
 * Configuración del ORM (Object-Relational Mapping)
 * 
 * Gestiona la configuración de conexión a la base de datos
 * y proporciona constantes para el mapeo de objetos.
 */
public class ORMConfig {
    
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/catalogo_productos";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    
    /**
     * Inicializa la configuración del ORM cargando el driver JDBC
     */
    public static void inicializar() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se pudo cargar el driver JDBC");
            e.printStackTrace();
        }
    }
    
    /**
     * @return URL de conexión a la base de datos
     */
    public static String getDBUrl() {
        return DB_URL;
    }
    
    /**
     * @return Usuario para la conexión
     */
    public static String getDBUser() {
        return DB_USER;
    }
    
    /**
     * @return Contraseña para la conexión
     */
    public static String getDBPassword() {
        return DB_PASSWORD;
    }
    
    /**
     * @return Driver JDBC a utilizar
     */
    public static String getDBDriver() {
        return DB_DRIVER;
    }
}
