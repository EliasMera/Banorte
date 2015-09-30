/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banorte;

import static banorte.Banorte.modProyecto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MostrarProyectos extends javax.swing.JFrame {

    /**
     * Creates new form MostrarInfoGer
     */
    public MostrarProyectos() {
        this.setTitle("Proyectos del Gerente");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        textArea1 = new java.awt.TextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Introduzca su ID (8 dígitos)");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ok");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(20, 20, 20)
                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        textArea1.setText("");
        try {
            RandomAccessFile miArchivito=new RandomAccessFile("Proyectos.dat","rw");
            int contador=0, pruebaId;
            int IDproyecto, horasHombre,numIniciativa, tamRegistro=3217, idGer=0, opcion, identificador=0;
            String nombreP="",direcGral="",liderpro="", objetivo="", indicadores="", pruebaid="";
            String fecha="", status="", consultor="", cualitativas="", cuantitativas="";
            String kpiSeg="", linea="";
            boolean terminado=false;
            int numRegistros=(int)(miArchivito.length()/tamRegistro);
            boolean encontrado=false;
            pruebaid="1"+jTextField1.getText();
            pruebaId=Integer.parseInt(pruebaid);
            while((contador<numRegistros)){
                miArchivito.seek(contador*tamRegistro);
                identificador=miArchivito.readInt();
                if(pruebaId==identificador){
                    miArchivito.seek(contador*tamRegistro+4);
                    terminado=miArchivito.readBoolean();
                    IDproyecto=miArchivito.readInt();
                    for(int i=0; i<100; i++)
                        nombreP+=miArchivito.readChar();
                    for(int i=0; i<100; i++)
                        direcGral+=miArchivito.readChar();
                    for(int i=0; i<50; i++)
                        liderpro+=miArchivito.readChar();
                    for(int i=0; i<200; i++)
                        objetivo+=miArchivito.readChar();
                    numIniciativa=miArchivito.readInt();
                    for(int i=0; i<30; i++)
                        indicadores+=miArchivito.readChar();
                    for(int i=0; i<10; i++)
                        fecha+=miArchivito.readChar();
                    for(int i=0; i<30; i++)
                        status+=miArchivito.readChar();
                    for(int i=0; i<50; i++)
                        consultor+=miArchivito.readChar();
                    horasHombre=miArchivito.readInt();
                    for(int i=0; i<500; i++)
                        cualitativas+=miArchivito.readChar();
                    for(int i=0; i<500; i++)
                        cuantitativas+=miArchivito.readChar();
                    for(int i=0; i<30; i++)
                        kpiSeg+=miArchivito.readChar();
                    if(terminado){
                        linea = "Proyecto del usuario: " + Integer.toString(identificador).substring(1,9) + "\nID proyecto: " + IDproyecto + "\nNombre proyecto: " + nombreP + "\nProyecto terminado" + "\nDirección general: " + direcGral
                                + "\nLíder Proyecto: " + liderpro + "\nObjetivo del proyecto: " + objetivo + "\nNo. de iniciativa: " + numIniciativa + "\nIndicadores KPI: " + indicadores
                                + "\nFecha proyecto " + fecha + "\nEstatus del proyecto: " + status + "\nConsultor: " + consultor + "\nNúmero de horas: "
                                + horasHombre + "\nVentajas cualitativas: " + cualitativas + "\nVentajas cuantitativas: " + cuantitativas + "\nIndicadores KPI: " + kpiSeg + "\n\n";
                        textArea1.append(linea);
                    }
                    else{
                        linea = "Proyecto del usuario: " + Integer.toString(identificador).substring(1,9) + "\nID proyecto: " + IDproyecto + "\nNombre proyecto: " + nombreP + "\nProyecto no terminado" + "\nDirección general: " + direcGral
                                + "\nLíder Proyecto: " + liderpro + "\nObjetivo del proyecto: " + objetivo + "\nNo. de iniciativa: " + numIniciativa + "\nIndicadores KPI: " + indicadores
                                + "\nFecha proyecto " + fecha + "\nEstatus del proyecto: " + status + "\nConsultor: " + consultor + "\nNúmero de horas: "
                                + horasHombre + "\nVentajas cualitativas: " + cualitativas + "\nVentajas cuantitativas: " + cuantitativas + "\nIndicadores KPI: " + kpiSeg + "\n\n";
                        textArea1.append(linea);
                    }

                    nombreP=direcGral=liderpro=objetivo=indicadores=pruebaid="";
                    fecha=status=consultor=cualitativas=cuantitativas="";
                    kpiSeg="";
                    encontrado=true;
                }
                contador++;
        }
            if(!encontrado)
                textArea1.setText("ID sin proyectos o mal introducido. \nIntente de nuevo.");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MostrarProyectos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MostrarProyectos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MostrarProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarProyectos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}