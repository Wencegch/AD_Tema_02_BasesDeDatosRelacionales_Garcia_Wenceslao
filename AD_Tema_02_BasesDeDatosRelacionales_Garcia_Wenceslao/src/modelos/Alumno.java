package modelos;

/**
 *
 * @author Wence
 */
public class Alumno {
    private String cCodAlu;
    private String cNomAlu;

    public Alumno() {
    }

    public Alumno(String cCodAlu, String cNomAlu) {
        this.cCodAlu = cCodAlu;
        this.cNomAlu = cNomAlu;
    }

    public String getcCodAlu() {
        return cCodAlu;
    }

    public void setcCodAlu(String cCodAlu) {
        this.cCodAlu = cCodAlu;
    }

    public String getcNomAlu() {
        return cNomAlu;
    }

    public void setcNomAlu(String cNomAlu) {
        this.cNomAlu = cNomAlu;
    }

    @Override
    public String toString() {
        return "Alumno{" + "cCodAlu=" + cCodAlu + ", cNomAlu=" + cNomAlu + '}';
    }
}