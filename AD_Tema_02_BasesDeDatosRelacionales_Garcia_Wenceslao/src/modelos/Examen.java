package modelos;

import java.util.Date;
/**
 *
 * @author Wence
 */
public class Examen {
    private int numExam;
    private Date fechaExam;
    private Double notaExam;

    public Examen() {
    }

    public Examen(int numExam, Date fechaExam, Double notaExam) {
        this.numExam = numExam;
        this.fechaExam = fechaExam;
        this.notaExam = notaExam;
    }

    public int getNumExam() {
        return numExam;
    }

    public void setNumExam(int numExam) {
        this.numExam = numExam;
    }

    public Date getFechaExam() {
        return fechaExam;
    }

    public void setFechaExam(Date fechaExam) {
        this.fechaExam = fechaExam;
    }

    public Double getNotaExam() {
        return notaExam;
    }

    public void setNotaExam(Double notaExam) {
        this.notaExam = notaExam;
    }
    
    @Override
    public String toString() {
        return "Examen{" + "Numero Examen = " + numExam + ", Fecha Examen = " + fechaExam + ", Nota Examen = " + notaExam + '}';
    }
}