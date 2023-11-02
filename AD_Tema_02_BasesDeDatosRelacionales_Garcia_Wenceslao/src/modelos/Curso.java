package modelos;

/**
 *
 * @author Wence
 */
public class Curso {
    private String codCurso;
    private String nomCurso;
    private int numExam;

    public Curso() {
    }

    public Curso(String codCurso, String nomCurso, int numExam) {
        this.codCurso = codCurso;
        this.nomCurso = nomCurso;
        this.numExam = numExam;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public String getNomCurso() {
        return nomCurso;
    }

    public void setNomCurso(String nomCurso) {
        this.nomCurso = nomCurso;
    }

    public int getNumExam() {
        return numExam;
    }

    public void setNumExam(int numExam) {
        this.numExam = numExam;
    }

    @Override
    public String toString() {
        return "Curso{" + "Codigo Curso = " + codCurso + ", Nombre Curso = " + nomCurso + ", Numero de Examenes = " + numExam + '}';
    }
}