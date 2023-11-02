package controlador;

import java.sql.*;
import java.util.ArrayList;
import modelos.Alumno;
import modelos.Curso;
import modelos.Examen;
import modelos.Matricula;
/**
 *
 * @author Wence
 */
public class ControlConexion {
    public static Connection conexion = null;
    private String cadenaConexion, ins;
    private ArrayList<Alumno> listaAlumnos = new ArrayList<>();
    private ArrayList<Curso> listaCursos = new ArrayList<>();
    private ArrayList<Matricula> listaMatriculas = new ArrayList<>();
    private ArrayList<Examen> listaExamenes = new ArrayList<>();
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    int nfa;
    
    public Connection conectar(String servidor, String puerto, String sid, String usuario, String pass){
        cadenaConexion = "jdbc:oracle:thin:@" + servidor.trim() + ":" + puerto.trim() + ":" + sid.trim();
        
        try{
            conexion = DriverManager.getConnection(cadenaConexion, usuario, pass);
        }catch(SQLException ex){
        }finally{
            return conexion;
        }
    }
    
    public ArrayList<Alumno> readTablaAlumnos(){
        listaAlumnos.removeAll(listaAlumnos);
        ins = "SELECT * FROM ALUMNOS ORDER BY cCodAlu ASC";
        try{
            if (conexion != null && !conexion.isClosed()) {
                st = conexion.createStatement();
                rs = st.executeQuery(ins);
                Alumno alumno;
                while (rs.next()) {
                    alumno = new Alumno(
                            rs.getString("cCodAlu"), 
                            rs.getString("cNomAlu"));
                    listaAlumnos.add(alumno);
                }
            }
        }catch(SQLException ex){
        }finally{
            try{
                rs.close();
                st.close();
            }catch(SQLException ex){
            }            
            return listaAlumnos;
        }
    }
    
    public ArrayList<Curso> readTablaCursos(){
        listaCursos.removeAll(listaCursos);
        ins = "SELECT * FROM CURSOS";
        try{
            if (conexion != null && !conexion.isClosed()) {
                st = conexion.createStatement();
                rs = st.executeQuery(ins);
                Curso curso;
                while (rs.next()) {
                    curso = new Curso(
                            rs.getString("cCodCurso"), 
                            rs.getString("cNomCurso"), 
                            rs.getInt("nNumExa"));
                    listaCursos.add(curso);
                }
            }
        }catch(SQLException ex){
        }finally{
            try{
                rs.close();
                st.close();
            }catch(SQLException ex){
            }
            return listaCursos;
        }
    }
    
    public int callProcedure(String codAlu, String codCurso){
        int aux = 0;
        ins = "{call sp_AltaMatricula(?, ?, ?)}";
        try{
            CallableStatement sentencia = conexion.prepareCall(ins);
            sentencia.setString(1, codAlu);
            sentencia.setString(2, codCurso);
            sentencia.registerOutParameter(3, java.sql.Types.NUMERIC);
            sentencia.executeUpdate();
        }catch(SQLException ex){
            aux = -1;
        }finally{
            return aux;
        }    
    }
    
    public ArrayList<Matricula> readVista(String where){
        listaMatriculas.removeAll(listaMatriculas);
        ins = "SELECT * FROM vista_tabla_matriculas WHERE cCodAlu = " + where;
        try{
            if (conexion != null && !conexion.isClosed()) {
                st = conexion.createStatement();
                rs = st.executeQuery(ins);
                Matricula matricula;
                while (rs.next()) {
                    matricula = new Matricula(
                            rs.getString("cCodAlu"), 
                            rs.getString("cNomAlu"), 
                            rs.getString("cCodCurso"),
                            rs.getString("cNomCurso"),
                            rs.getInt("nNotaMedia"));
                    listaMatriculas.add(matricula);
                }
            }
        }catch(SQLException ex){
        }finally{
            try{
                rs.close();
                st.close();
            }catch(SQLException ex){
            }
            return listaMatriculas;
        }
    }
    
    public ArrayList<Examen> readTablaExamenes(String codAlu, String where){
        listaExamenes.removeAll(listaExamenes);
        ins = "SELECT nNumExam, dFecExam, nNotaExam FROM EXAMENES WHERE cCodAlu = " + codAlu + " AND cCodCurso = '" + where + "'";
        try{
            if (conexion != null && !conexion.isClosed()) {
                st = conexion.createStatement();
                rs = st.executeQuery(ins);
                Examen examen;
                while(rs.next()){
                    examen = new Examen(
                            rs.getInt("nNumExam"), 
                            rs.getDate("dFecExam"),
                            rs.getDouble("nNotaExam"));
                    listaExamenes.add(examen);
                }
            }
        }catch(SQLException ex){
        }finally{
            try{
                rs.close();
                st.close();
            }catch(SQLException ex){
            }
            return listaExamenes;
        }
    }
    
    public void actualizarExamen(Date fecha, Double notaExamen, String codAlu, String codCurso , int numExam){
        ins = "UPDATE EXAMENES SET dFecExam = ?, nNotaExam = ? WHERE cCodAlu = ? AND cCodCurso = ? AND nNumExam = ?";
        try{
            if (conexion!= null && !conexion.isClosed()) {
                ps = conexion.prepareStatement(ins);
                ps.setDate(1, fecha);
                ps.setDouble(2, notaExamen);
                ps.setString(3, codAlu);
                ps.setString(4, codCurso);
                ps.setInt(5, numExam);
                //Ejecutar PrepareStatement
                nfa = ps.executeUpdate();
                System.out.println("Filas afectadas " + nfa);
            }
        }catch(SQLException ex){
        }finally{
            try{
                ps.close();
            }catch(SQLException ex){
            }
        }
    }
}