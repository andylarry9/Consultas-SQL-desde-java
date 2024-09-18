
package Logica_Operaciones_BD;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;


public final class OperacionesCRUD 
{
    //patron de diseño Singleton
    private static OperacionesCRUD lainstance = new OperacionesCRUD();
    private Connection conexion;

    private OperacionesCRUD() 
    {         
    }
    
    public static OperacionesCRUD getInstance()
    {
        return lainstance;
    }
    
    private void iniciarConexionBD()//INICIAR LA CONEXIONA LA BD
    {
        this.conexion = ConexionBD.iniciarConexion();
    }
    
    private void cerrarConexionBD() throws SQLException  //CERRAR LA CONEXION A LA BD
    {
        if (this.conexion != null && this.conexion.isClosed() == false) //valida si aun está habierta la conexion BD
        {
            this.conexion.close();
        }
    }    
    //inciso 1.
    public List<String> obtenerListadoEstudiantesInscritos() throws SQLException 
    {
        //1. Conectar a la base de datos
        this.iniciarConexionBD();
        //2. Definir la variable para almacenar el listado de estudiantes con sus respectivos datos.
        List<String> ListadoEstudiantesInscritos = new ArrayList<>();
        //3. Definir espacio de trabajo para la declaración y ejecución de la consulta sql.
        Statement stm = this.conexion.createStatement();
        //4. Definir el texto String de la consulta SQL.
        String sql = "select \n" +
            "i.cedula as cedula,\n" +
            "e.nombres as nombre,\n" +
            "e.apellidos as apellido \n" +
            "from\n" +
            "inscripciones_estudiantes i\n" +
            "join estudiantes e on i.cedula = e.cedula"; 
        //5. Ejecutar la consulta y amacenar en el objeto ResultSet.
        ResultSet tabla = stm.executeQuery(sql); 
        //6. Recorrer el objeto ResultSet mediante un ciclo while para adicionar a la lista el registro de datos de cada estudiante.
        while(tabla.next())
        {                    
            //6.1. Obtener el valor de columna de la fila actual del objeto ResultSet
            String ColumCedula = tabla.getString("CEDULA"); 
            String ColumNombre = tabla.getString("NOMBRE"); 
            String ColumApellido = tabla.getString("APELLIDO"); 
              
            //6.2. Almacenar en el vector creado en el paso 2. el valor de columna de la fila actual del objeto ResultSet
            ListadoEstudiantesInscritos.add(ColumCedula +"  "+ ColumNombre +"     "+ ColumApellido);
            
        }  
        //7. Cerrar la conexion a la base de datos.
         this.cerrarConexionBD(); 
        //8. Retornar el listado de estudiantes con sus respectivos datos obtenidos de la consulta SQL.
          return ListadoEstudiantesInscritos;    
    }
    //inciso 2.
    public List<String> obtenerListadoCarrerasConEstudiantesInscritos() throws SQLException 
    {
        //1. Conectar a la base de datos
        this.iniciarConexionBD();
        //2. Definir la variable para almacenar el listado de estudiantes con sus respectivos datos.
        List<String> ListadoCarrerasConEstudiantesInscritos = new ArrayList<>();
        //3. Definir espacio de trabajo para la declaración y ejecución de la consulta sql.
        Statement stm = this.conexion.createStatement();
        //4. Definir el texto String de la consulta SQL.
        String sql = "select \n" +
                    "p.nombre as paralelo,\n" +
                    "p.jornada as jornada \n" +
                    "from\n" +
                    "inscripciones_estudiantes i \n" +
                    "join paralelos p on p.cod_paralelo = i.cod_paralelo"; 
        //5. Ejecutar la consulta y amacenar en el objeto ResultSet.
        ResultSet tabla = stm.executeQuery(sql); 
        //6. Recorrer el objeto ResultSet mediante un ciclo while para adicionar a la lista el registro de datos de cada estudiante.
        while(tabla.next())
        {                    
            //6.1. Obtener el valor de columna de la fila actual del objeto ResultSet
            String ColumParalelo = tabla.getString("PARALELO"); 
            String ColumJornada = tabla.getString("JORNADA"); 
         
              
            //6.2. Almacenar en el vector creado en el paso 2. el valor de columna de la fila actual del objeto ResultSet
            ListadoCarrerasConEstudiantesInscritos.add(ColumParalelo +"  "+ ColumJornada);
            
        }  
        //7. Cerrar la conexion a la base de datos.
         this.cerrarConexionBD(); 
        //8. Retornar el listado de estudiantes con sus respectivos datos obtenidos de la consulta SQL.
          return ListadoCarrerasConEstudiantesInscritos;  
    }
}
