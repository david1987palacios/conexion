/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author DAVID>>>>@author DIGERATI
 */
        public class Conexion {
            
                    Connection com;   // llamamos el objeto  Connection =com "ya esta instamciado"
                    private Connection con;


                    public Conexion(){ // en java metodo con el mismo nombbre de la clase es un constructor(no requiere inst)
                        
                    try {//hagalo/intenta
                    Class.forName("com.mysql.cj.jdbc.Driver"); // trae controladores de la base de datos MYsql con JDBC conexion a la BD
            
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infofamilia","root","");// se importa galeria la "import java.sql.DriverManager;"
                                                                                                    //localhost:3306/dbsiac"  (donde esta es mysql)
                                                                                                    // nombre de la BD _______
                                                                                                    //usuario root (para acceder a la BD
                                                                                                    //contraseña""
                                                                                                    //>>>>con esto se ingresa a la BD
              
                       
                               //con el anterior metodo apenas abra la aplicacion automaticamente se conecta a la BD
                    } catch (Exception e){// si no encuentra la conexion ejecuta lo >>
                     System.err.println("Error:" +e);
        }
    
}
     
    public static void main(String[] args) {//metodo principal se centran todas las ejecuciones
        
   
        
       Conexion cn=new Conexion();// la clase principal se debe instamciar al menos una vez  par aque se ejute el metodo constructor
        //objetos
        Statement st;  //"estado-accion" se importa la galeria Statement
        ResultSet rs;// "resultado" se importa la galeria ResultSet
        
       try {
            st=cn.con.createStatement();// se conecta a la BD
          
           rs=st.executeQuery("select * from integrantes");//Query =lenguaje de consulta sql
                                                           // selecciona>>todos los campos>> de la tabla "BD"
                                                          
            while (rs.next()) {      //  buscara resultados repetidamente   

            
               System.out.println(rs.getString("nombre")+" " +rs.getString("Primerapellido")+" "+rs.getString("Segundoapellido")+">> "+rs.getString("documento"));
               
              }
            cn.com.close();// dar orden de terminar la ejecucion
            
         } catch (Exception e) {
            }
         }
    
          
       }  
        
    
       
