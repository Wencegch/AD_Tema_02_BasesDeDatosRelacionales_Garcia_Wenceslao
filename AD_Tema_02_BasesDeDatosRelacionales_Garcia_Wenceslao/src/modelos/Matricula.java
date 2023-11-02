package modelos;

/**
 *
 * @author Wence
 */
public class Matricula {
    private String codAlu;
    private String nomAlu;
    private String codCurso;
    private String nomCurso;
    private int notaMedia;

    public Matricula() {
    }

    public Matricula(String codAlu, String nomAlu, String codCurso, String nomCurso, int notaMedia) {
        this.codAlu = codAlu;
        this.nomAlu = nomAlu;
        this.codCurso = codCurso;
        this.nomCurso = nomCurso;
        this.notaMedia = notaMedia;
    }

    public String getCodAlu() {
        return codAlu;
    }

    public void setCodAlu(String codAlu) {
        this.codAlu = codAlu;
    }

    public String getNomAlu() {
        return nomAlu;
    }

    public void setNomAlu(String nomAlu) {
        this.nomAlu = nomAlu;
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

    public int getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(int notaMedia) {
        this.notaMedia = notaMedia;
    }

    @Override
    public String toString() {
        return "Matriculas{" + "Codigo alumno = " + codAlu + ", Nombre Alumno = " + nomAlu + ", Coodigo Curso = " + codCurso + 
                ", Nombre Curso = " + nomCurso + ", Nota Media = " + notaMedia + '}';
    }
    
    
}
