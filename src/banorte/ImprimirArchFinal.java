/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banorte;

import static banorte.Banorte.menu1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImprimirArchFinal extends javax.swing.JFrame {

    /**
     * Creates new form ImprimirGerente
     */
    public ImprimirArchFinal() {
        this.setTitle("Proyectos Terminados");
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

        textArea1 = new java.awt.TextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Los proyectos finalizados hasta el día de hoy son:");

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 64, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textArea1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            RandomAccessFile miArchivoFinalizados = new RandomAccessFile("ProyectoFinalizado.dat","rw");
            int contador=0, opcion=0;
            int IDproyecto, horasHombre,numIniciativa, tamRegistro=3217, identificador=0;
            String nombreP="",direcGral="",liderpro="", objetivo="", indicadores="";
            String fecha="", status="", consultor="", cualitativas="", cuantitativas="";
            String kpiSeg="";
            boolean terminado=false;
            int numRegistros=(int)(miArchivoFinalizados.length()/tamRegistro);
            if(numRegistros==0)
                textArea1.setText("No hay proyectos finalizados hasta el momento.");
            while((contador<numRegistros)){
                miArchivoFinalizados.seek(contador*tamRegistro);
                identificador=miArchivoFinalizados.readInt();
                terminado=miArchivoFinalizados.readBoolean();
                miArchivoFinalizados.seek(contador*tamRegistro + 5);
                IDproyecto=miArchivoFinalizados.readInt();
                for(int i=0; i<100; i++)
                    nombreP+=miArchivoFinalizados.readChar();
                for(int i=0; i<100; i++)
                    direcGral+=miArchivoFinalizados.readChar();
                for(int i=0; i<50; i++)
                    liderpro+=miArchivoFinalizados.readChar();
                for(int i=0; i<200; i++)
                    objetivo+=miArchivoFinalizados.readChar();
                numIniciativa=miArchivoFinalizados.readInt();
                for(int i=0; i<30; i++)
                    indicadores+=miArchivoFinalizados.readChar();
                for(int i=0; i<10; i++)
                    fecha+=miArchivoFinalizados.readChar();
                for(int i=0; i<30; i++)
                    status+=miArchivoFinalizados.readChar();
                for(int i=0; i<50; i++)
                    consultor+=miArchivoFinalizados.readChar();
                horasHombre=miArchivoFinalizados.readInt();
                for(int i=0; i<500; i++)
                    cualitativas+=miArchivoFinalizados.readChar();
                for(int i=0; i<500; i++)
                    cuantitativas+=miArchivoFinalizados.readChar();
                for(int i=0; i<30; i++)
                    kpiSeg+=miArchivoFinalizados.readChar();
                String linea="Proyecto del usuario: "+Integer.toString(identificador).substring(1,9)+"\nID proyecto: "+IDproyecto+"\nNombre proyecto: "+nombreP+"\nDirección general: "+direcGral+
    "\nLíder Proyecto: "+liderpro+"\nObjetivo del proyecto: "+objetivo+"\nNo. de iniciativa: "+numIniciativa+"\nIndicadores KPI: "+indicadores+
    "\nFecha proyecto "+fecha+"\nEstatus del proyecto: "+status+"\nConsultor: "+consultor+"\nNúmero de horas: "+
     horasHombre+"\nVentajas cualitativas: "+cualitativas+"\nVentajas cuantitativas: "+cuantitativas+"\nIndicadores KPI: "+kpiSeg+"\n\n";
                textArea1.append(linea);
                nombreP=direcGral=liderpro=objetivo=indicadores="";
                fecha=status=consultor=cualitativas=cuantitativas="";
                kpiSeg="";
                contador++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImprimirArchFinal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImprimirArchFinal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ImprimirArchFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImprimirArchFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImprimirArchFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImprimirArchFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImprimirArchFinal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
