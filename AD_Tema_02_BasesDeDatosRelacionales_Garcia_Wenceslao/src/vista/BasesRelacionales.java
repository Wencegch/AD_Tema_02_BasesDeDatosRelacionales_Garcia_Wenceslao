package vista;

import com.google.gson.Gson;
import controlador.ControlConexion;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Alumno;
import modelos.Curso;
import modelos.Examen;
import modelos.Matricula;
import modelos.XmlManager;

/**
 *
 * @author Wence
 */
public class BasesRelacionales extends javax.swing.JFrame {

    private ControlConexion controlConexion = null;
    private DefaultTableModel dtm;
    private ArrayList<Alumno> listaAlumnos = new ArrayList<>();
    private ArrayList<Curso> listaCursos = new ArrayList<>();
    private ArrayList<Matricula> listaMatriculas = new ArrayList<>();
    private ArrayList<Examen> listaExamenes = new ArrayList<>();
    private String codAlu, nomAlu, codCurso, nomCurso, fechaTexto, notaMediaTexto;
    private int filaSeleccionada, filaSeleccionada2, numExa, notaMedia;
    private Double notaExamen;
    private Date fecha;
    private SimpleDateFormat formaFecha = new SimpleDateFormat("dd/MM/yyyy");
    private File f = new File("Examenes.json");
    
    public BasesRelacionales() {
        controlConexion = new ControlConexion();
        
        if (controlConexion.conectar("localhost", "1521", "xe", "AD_TEMA02", "AD_TEMA02") == null) {
            JOptionPane.showMessageDialog(null, "Error, no se pudo conectar a la base de datos");
            System.exit(0);
        }
        
        initComponents();
        setTitle("Practica_02_AD_BasesDeDatosRelacionales");
        setLocationRelativeTo(null);
        rellenarTablaAlumnos();
        rellenarTablaCursos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlumnos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCursos = new javax.swing.JTable();
        btnMatricular = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableMatriculas = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableExamenes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNota = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnJson = new javax.swing.JButton();
        btnListadoMatriculaXml = new javax.swing.JButton();
        jDateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Alumno", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAlumnos);
        if (jTableAlumnos.getColumnModel().getColumnCount() > 0) {
            jTableAlumnos.getColumnModel().getColumn(0).setResizable(false);
        }

        jTableCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Curso", "Nombre Curso", "Nº Examenes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableCursos);
        if (jTableCursos.getColumnModel().getColumnCount() > 0) {
            jTableCursos.getColumnModel().getColumn(0).setResizable(false);
            jTableCursos.getColumnModel().getColumn(2).setResizable(false);
        }

        btnMatricular.setText("Matricular Alumno en Curso");
        btnMatricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatricularActionPerformed(evt);
            }
        });

        jTableMatriculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Alumno", "Nombre Alumno", "Codigo Curso", "Nombre Curso", "Nota Media"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMatriculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMatriculasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableMatriculas);
        if (jTableMatriculas.getColumnModel().getColumnCount() > 0) {
            jTableMatriculas.getColumnModel().getColumn(0).setResizable(false);
            jTableMatriculas.getColumnModel().getColumn(2).setResizable(false);
        }

        jTableExamenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero examen", "Fecha Examen", "Nota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableExamenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableExamenesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableExamenes);
        if (jTableExamenes.getColumnModel().getColumnCount() > 0) {
            jTableExamenes.getColumnModel().getColumn(0).setResizable(false);
            jTableExamenes.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setText("Fecha Examen");

        jLabel2.setText("Nota");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnJson.setText("Boletin JSON");
        btnJson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJsonActionPerformed(evt);
            }
        });

        btnListadoMatriculaXml.setText("Listado Matricula XML");
        btnListadoMatriculaXml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListadoMatriculaXmlActionPerformed(evt);
            }
        });

        jDateChooser.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(btnMatricular)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnJson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(txtNota)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnListadoMatriculaXml, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnMatricular)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar)
                        .addGap(69, 69, 69)
                        .addComponent(btnJson)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListadoMatriculaXml)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAlumnosMouseClicked
        dtm = (DefaultTableModel) jTableMatriculas.getModel();
        dtm.setRowCount(0);
        filaSeleccionada = jTableAlumnos.getSelectedRow();
        codAlu = String.valueOf(jTableAlumnos.getValueAt(filaSeleccionada, 0));
        rellenarTablaMatriculas(codAlu);
    }//GEN-LAST:event_jTableAlumnosMouseClicked

    private void btnMatricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatricularActionPerformed
        try{
            filaSeleccionada = jTableAlumnos.getSelectedRow();
            filaSeleccionada2 = jTableCursos.getSelectedRow();
            codAlu = String.valueOf(jTableAlumnos.getValueAt(filaSeleccionada, 0));
            codCurso = String.valueOf(jTableCursos.getValueAt(filaSeleccionada2, 0));

            if(controlConexion.callProcedure(codAlu, codCurso) == -1){
                JOptionPane.showMessageDialog(null, "Error en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null, "No hay campos seleccionados", "Campos no seleccionados", JOptionPane.ERROR_MESSAGE);
        }
        rellenarTablaMatriculas(codAlu);
    }//GEN-LAST:event_btnMatricularActionPerformed

    private void jTableMatriculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMatriculasMouseClicked
        dtm = (DefaultTableModel)jTableExamenes.getModel();
        filaSeleccionada = jTableMatriculas.getSelectedRow();
        codAlu = String.valueOf(jTableMatriculas.getValueAt(filaSeleccionada, 0));
        codCurso = String.valueOf(jTableMatriculas.getValueAt(filaSeleccionada, 2));
        
        try{
            rellenarTablaExamenes(codAlu, codCurso);
        }catch(NullPointerException ex){}
    }//GEN-LAST:event_jTableMatriculasMouseClicked

    private void jTableExamenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableExamenesMouseClicked
        filaSeleccionada = jTableExamenes.getSelectedRow();
        fechaTexto = String.valueOf(jTableExamenes.getValueAt(filaSeleccionada, 1));
        txtNota.setText(String.valueOf(jTableExamenes.getValueAt(filaSeleccionada, 2)));
        try{
            if (!fechaTexto.isEmpty()) {
                fecha = formaFecha.parse(fechaTexto);
                jDateChooser.setDate(fecha);
            }else{
                jDateChooser.setDate(null);
            }
        }catch(ParseException | NullPointerException ex){
        }
    }//GEN-LAST:event_jTableExamenesMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int res = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres modificar la nota y fecha?", "Actualizar", JOptionPane.WARNING_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
           try{
                filaSeleccionada = jTableMatriculas.getSelectedRow();
                filaSeleccionada2 = jTableExamenes.getSelectedRow();

                codAlu = String.valueOf(jTableMatriculas.getValueAt(filaSeleccionada, 0));
                codCurso = String.valueOf(jTableMatriculas.getValueAt(filaSeleccionada, 2));
                numExa = (int) jTableExamenes.getValueAt(filaSeleccionada2, 0);
                notaExamen = Double.valueOf(txtNota.getText().trim());
                
                fecha = jDateChooser.getDate();
                long d = fecha.getTime();
                java.sql.Date fecha1 = new java.sql.Date(d);
        
                controlConexion.actualizarExamen(fecha1, notaExamen, codAlu, codCurso, numExa);
                rellenarTablaMatriculas(codAlu);
                rellenarTablaExamenes(codAlu, codCurso);
            }catch(ArrayIndexOutOfBoundsException ex){
                JOptionPane.showMessageDialog(null, "Faltan campos por seleccionar");
            }catch(NullPointerException ex){
                JOptionPane.showMessageDialog(null, "Fecha incorrecta");
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Error: Campos erroneos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnJsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJsonActionPerformed
        try{
            if (!f.exists()) {
                int res = JOptionPane.showConfirmDialog(null, "¿Crear JSON?", "Crear JSON",JOptionPane.WARNING_MESSAGE);
                if (res == JOptionPane.YES_OPTION) {
                    crearJSON();
                }
            }else{
                int res = JOptionPane.showConfirmDialog(null, "Ya existe un archivo JSON, la información que esté almacenada en él se perderá, ¿estás seguro?","Guardar jSON",JOptionPane.WARNING_MESSAGE);
                if (res == JOptionPane.YES_OPTION) {
                    crearJSON();
                }
            }
        }catch(NullPointerException ex){}
    }//GEN-LAST:event_btnJsonActionPerformed

    private void btnListadoMatriculaXmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListadoMatriculaXmlActionPerformed
        int res = JOptionPane.showConfirmDialog(null, "¿Crear XML con las matrículas del alumno?", "Crear XML", JOptionPane.INFORMATION_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
            filaSeleccionada = jTableMatriculas.getSelectedRow();
            try{
                codAlu = String.valueOf(jTableMatriculas.getValueAt(filaSeleccionada, 0));
            }catch(ArrayIndexOutOfBoundsException ex){}

            XmlManager xml = new XmlManager();
            listaMatriculas = controlConexion.readVista(codAlu);
            xml.CrearXML(codAlu, listaMatriculas);
        }
    }//GEN-LAST:event_btnListadoMatriculaXmlActionPerformed
    
    public void rellenarTablaAlumnos(){
        dtm = (DefaultTableModel) jTableAlumnos.getModel();
        dtm.setRowCount(0);
        //Recogemos los datos de la tabla
        listaAlumnos = controlConexion.readTablaAlumnos();
        for (Alumno al : listaAlumnos) {
            codAlu = al.getcCodAlu();
            nomAlu = al.getcNomAlu();
            Object [] alumno = {codAlu, nomAlu};
            dtm.addRow(alumno);
        }
    }
    
    public void rellenarTablaCursos(){
        dtm = (DefaultTableModel)jTableCursos.getModel();
        dtm.setRowCount(0);
        //Recogemos los datos de la tabla
        listaCursos = controlConexion.readTablaCursos();
        for (Curso c : listaCursos) {
            codAlu = c.getCodCurso();
            nomAlu = c.getNomCurso();
            numExa = c.getNumExam();
            Object [] curso = {codAlu, nomAlu, numExa};
            dtm.addRow(curso);
        }
    }
    
    public void rellenarTablaMatriculas(String where){
        dtm = (DefaultTableModel)jTableMatriculas.getModel();
        dtm.setRowCount(0);
        //Recogemos los datos de la tabla
        listaMatriculas = controlConexion.readVista(where);
        for (Matricula mt : listaMatriculas) {
            codAlu = mt.getCodAlu();
            nomAlu = mt.getNomAlu();
            codCurso = mt.getCodCurso();
            nomCurso = mt.getNomCurso();
            notaMedia = mt.getNotaMedia();
            Object [] matricula = {codAlu, nomAlu, codCurso, nomCurso, notaMedia};
            dtm.addRow(matricula);
        }
    }
    
    public void rellenarTablaExamenes(String codAlu, String where){
        dtm = (DefaultTableModel)jTableExamenes.getModel();
        dtm.setRowCount(0);
        //Recogemos los datos de la tabla
        listaExamenes = controlConexion.readTablaExamenes(codAlu, where);
        for (Examen listExames : listaExamenes) {
            numExa = listExames.getNumExam();
            fecha = listExames.getFechaExam();
            if (fecha != null) {
                fechaTexto = formaFecha.format(fecha);
            }else{
                if (fecha == null) {
                    fechaTexto = "";
                }
            }
            notaExamen = listExames.getNotaExam();
            Object [] examen = {numExa, fechaTexto, notaExamen};
            dtm.addRow(examen);
        }
    }
    
    public void crearJSON(){
        f = new File("Examenes.json");
        FileWriter fw = null;
        Gson gson = new Gson();
        try{
            fw = new FileWriter(f);
            for (Examen listaExam : listaExamenes) {
                fw.write(gson.toJson(listaExam));
            }
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "No se ha podido guardar los exámenes");
        }finally{
            try{
                fw.close();
            }catch(IOException ex){
            }
        }   
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BasesRelacionales().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnJson;
    private javax.swing.JButton btnListadoMatriculaXml;
    private javax.swing.JButton btnMatricular;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableAlumnos;
    private javax.swing.JTable jTableCursos;
    private javax.swing.JTable jTableExamenes;
    private javax.swing.JTable jTableMatriculas;
    private javax.swing.JTextField txtNota;
    // End of variables declaration//GEN-END:variables
}