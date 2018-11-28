package ConectaBD;
import java.sql.*;
public class Conecta_Prueba {

	public static void main(String[] args) {
	
		try {
		//1 PASO : CREAR CONEXION: necesitamos utilizar un objeto de tipo conexion y también utilizar la clase
		//DriverManager. El método "getConection" nos devuelve un objeto de tipo "connection" el cual es una nterfaz
			
			Connection MiConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_prueba","root","");
		//2 PASO: CREAR OBJETO STATEMENT: 
			Statement miStatement=MiConexion.createStatement();
		//3 PASO: EJECUTAR INSTRUCCION SQL: Para ello vamos a necesitar el objeto de tipo statement (es una interfaz)
			//esta interfaz tiene un método llamado "ExecuteQuery" este método devuelve un objeto de tipo "Resulset"
			//tendremos que crearnos un objeto de tipo "Resulset". En el String que le pasamos tenemos que darle la
			//instruccion que nos devuelva los usuarios en lenguaje de acceso a datos SQL.
			
			ResultSet MiResulset=miStatement.executeQuery("SELECT * FROM USUARIOS");//con esta línea hemos obtenido todos los campos
			
		//4 PASO: RECORRER LA TABLA VIRTUAL (EL RESULSET). Para ello utitlizamos los metodos de la interfaz ResultSet
			
			while(MiResulset.next()){//MiResulset.next quiere decir mientras haya un siguiente
				
				System.out.println(MiResulset.getString("Nombre") + " " + MiResulset.getString("Correo") + " " + MiResulset.getString("Telefono"));
				//escribir las columnas tal cual estan escritas
			}
			

	}catch(Exception e) {
		System.out.println("No conecta");
		//también imprimimos la pila, lo que nos da una pista de donde ha ocurrido el error
		
		e.printStackTrace();
	}
	}
}
