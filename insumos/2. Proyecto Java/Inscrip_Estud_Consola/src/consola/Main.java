
package consola;

import Logica_Operaciones_BD.OperacionesCRUD;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {

    
    
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        //completar   
        Scanner sc = new Scanner (System.in);
        while(true) {
        int opcionM = menuOpciones(sc);
        
        switch (opcionM){
            case 1:
               EstudiantesInscritos();
                break;
                
            case 2:
               Paralelo_Jornada();
                break;
            
            case 3:
                System.out.println("Saliendo...");
                sc.close();
                System.exit(0);
            default:
                System.out.println("Opción no válida.");
        }
        }
        
       
    }
    
    public static int menuOpciones(Scanner sc) {
        System.out.println("\n");
        System.out.println("-------------MENU--------------");
        System.out.println("1. Mostra lista de los estudiantes inscritos en carreras.");
        System.out.println("2. Mostra paralelo y su Jornada.");
        System.out.println("3. Salir.");
        System.out.print("opcion:");
        
        
        int opcionM = 0;
        //completar la lógica de pasos del menú de opciones
        try {
            opcionM = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e){
            System.out.println("Error.");
            sc.nextLine();
        }
            
        return opcionM;
    }
    
    
     public static void EstudiantesInscritos() throws SQLException{
         // Obtener el listado de los estudiantes inscritos en carreras con los datos de cedula, 
        //nombres y apellidos por cada estudiante
        OperacionesCRUD objOpeBD= OperacionesCRUD.getInstance();
        List<String>ListadoEstudiantesInscritos = objOpeBD.obtenerListadoEstudiantesInscritos();
        System.out.println("\n");
        System.out.println(" Estudiantes inscritos en carreras : ");
        for(int i =0;i<ListadoEstudiantesInscritos.size();i++){
            System.out.println(ListadoEstudiantesInscritos.get(i));
        }
       
    }
     
     
      public static void Paralelo_Jornada() throws SQLException{
        //Obtener el listado de paralelos, tienen estudiantes inscritos en carreras, con los datos 
        //de nombre y jornada por cada paralelo
        OperacionesCRUD objOpeBD= OperacionesCRUD.getInstance();
        List<String>ListadoCarrerasConEstudiantesInscritos = objOpeBD.obtenerListadoCarrerasConEstudiantesInscritos();
        System.out.println("\n");
        System.out.println("Paralelo y su Jornada : ");
        for(int i =0;i<ListadoCarrerasConEstudiantesInscritos.size();i++){
            System.out.println(ListadoCarrerasConEstudiantesInscritos.get(i));
        }
       
    }
    
}
