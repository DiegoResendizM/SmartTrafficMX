import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JFileChooser;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class Monitoreo extends javax.swing.JFrame {
    private TrafficDataProcessor dataProcessor;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.Timer monitorTimer;
    private int progresoMinutos = 0;

    public Monitoreo() {
        initComponents();
        setLocationRelativeTo(null);
        dataProcessor = new TrafficDataProcessor();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtCiudad = new javax.swing.JTextField();
        txtAvenidaCentral = new javax.swing.JTextField();
        txtPeriferico = new javax.swing.JTextField();
        txtCarreteraNacional = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultados = new javax.swing.JTextArea();
        lblTiempo = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Módulo Monitoreo - SmartTrafficMX");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Módulo Monitoreo");

        jLabel2.setText("Nombre de la ciudad:");

        jLabel3.setText("Avenida Central - Tráfico inicial (veh/min):");

        jLabel4.setText("Periférico Metropolitano - Tráfico inicial (veh/min):");

        jLabel5.setText("Carretera Nacional - Tráfico inicial (veh/min):");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Visualización de resultados en tiempo real:");

        jButton1.setText("INICIAR MONITOREO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("ANALIZAR DATOS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("REPORTE COMPLETO");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5 = new javax.swing.JButton();
        jButton5.setText("EXPORTAR CSV");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtAvenidaCentral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAvenidaCentralActionPerformed(evt);
            }
        });

        txtPeriferico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPerifericoActionPerformed(evt);
            }
        });

        txtResultados.setColumns(20);
        txtResultados.setRows(5);
        jScrollPane1.setViewportView(txtResultados);

        lblTiempo.setText("Progreso: 0/360 min");
        progressBar.setMinimum(0);
        progressBar.setMaximum(360);
        progressBar.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(lblTiempo)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCiudad)
                            .addComponent(txtAvenidaCentral)
                            .addComponent(txtPeriferico)
                            .addComponent(txtCarreteraNacional, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAvenidaCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPeriferico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCarreteraNacional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblTiempo)
                .addGap(8, 8, 8)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
               String ciudad = txtCiudad.getText().trim();
        if (ciudad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el nombre de la ciudad.");
            return;
        }

        try {
            int t1 = Integer.parseInt(txtAvenidaCentral.getText().trim());
            int t2 = Integer.parseInt(txtPeriferico.getText().trim());
            int t3 = Integer.parseInt(txtCarreteraNacional.getText().trim());

            if (t1 < 0 || t2 < 0 || t3 < 0) {
                JOptionPane.showMessageDialog(this, "Los valores de tráfico deben ser positivos.");
                return;
            }

            txtResultados.setText("=== Iniciando simulación para: " + ciudad + " ===\n");
            txtResultados.append("Duración: 6 horas (360 minutos)\n");
            txtResultados.append("Actualizaciones cada minuto\n\n");

            jButton1.setEnabled(false);
            progresoMinutos = 0;
            progressBar.setValue(0);
            lblTiempo.setText("Progreso: 0/360 min");

            // Temporizador de progreso estimado (100ms ~= 1 minuto simulado)
            monitorTimer = new javax.swing.Timer(100, new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    progresoMinutos++;
                    if (progresoMinutos > 360) progresoMinutos = 360;
                    progressBar.setValue(progresoMinutos);
                    lblTiempo.setText(String.format("Progreso: %d/360 min", progresoMinutos));
                    if (progresoMinutos >= 360) {
                        ((javax.swing.Timer)e.getSource()).stop();
                    }
                }
            });
            monitorTimer.start();

            HiloVialidad hilo1 = new HiloVialidad("Avenida Central", t1, txtResultados, ciudad);
            HiloVialidad hilo2 = new HiloVialidad("Periférico Metropolitano", t2, txtResultados, ciudad);
            HiloVialidad hilo3 = new HiloVialidad("Carretera Nacional", t3, txtResultados, ciudad);

            hilo1.start();
            hilo2.start();
            hilo3.start();

            new Thread(() -> {
                try {
                    hilo1.join();
                    hilo2.join();
                    hilo3.join();
                    SwingUtilities.invokeLater(() -> {
                        jButton1.setEnabled(true);
                        if (monitorTimer != null) {
                            monitorTimer.stop();
                        }
                        progressBar.setValue(360);
                        lblTiempo.setText("Progreso: 360/360 min (Completado)");
                        JOptionPane.showMessageDialog(this, 
                            "Simulación completada.\nArchivo: SmartTrafficMX_" + ciudad + ".txt");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos.");
        }                          
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtAvenidaCentralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAvenidaCentralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAvenidaCentralActionPerformed

    private void txtPerifericoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPerifericoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPerifericoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, 
            "¿Está seguro que desea salir?", 
            "Confirmar salida", 
            JOptionPane.YES_NO_OPTION);
        
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String ciudad = txtCiudad.getText().trim();
        if (ciudad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el nombre de la ciudad primero.");
            return;
        }

        try {
            int t1 = Integer.parseInt(txtAvenidaCentral.getText().trim());
            int t2 = Integer.parseInt(txtPeriferico.getText().trim());
            int t3 = Integer.parseInt(txtCarreteraNacional.getText().trim());

            // Agregar datos al procesador
            dataProcessor.addTrafficData(ciudad + " - Avenida Central", t1);
            dataProcessor.addTrafficData(ciudad + " - Periférico Metropolitano", t2);
            dataProcessor.addTrafficData(ciudad + " - Carretera Nacional", t3);

            // Mostrar análisis básico
            StringBuilder analysis = new StringBuilder();
            analysis.append("=== ANALISIS DE TRAFICO ===\n");
            analysis.append("Ciudad: ").append(ciudad).append("\n\n");
            analysis.append("Estadísticas:\n");
            analysis.append("- Promedio de vehículos: ").append(String.format("%.2f", dataProcessor.calculateAverageTraffic())).append(" veh/min\n");
            analysis.append("- Ubicación con mayor tráfico: ").append(dataProcessor.findHighestTrafficLocation()).append("\n\n");
            
            // Comparación entre vías
            analysis.append("Comparación de vías:\n");
            if (t1 > t2 && t1 > t3) {
                analysis.append("- Avenida Central tiene el mayor tráfico (").append(t1).append(" veh/min)\n");
            } else if (t2 > t1 && t2 > t3) {
                analysis.append("- Periférico Metropolitano tiene el mayor tráfico (").append(t2).append(" veh/min)\n");
            } else {
                analysis.append("- Carretera Nacional tiene el mayor tráfico (").append(t3).append(" veh/min)\n");
            }
            
            txtResultados.setText(analysis.toString());
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String ciudad = txtCiudad.getText().trim();
        if (ciudad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el nombre de la ciudad primero.");
            return;
        }

        try {
            // Agregar datos actuales si no están agregados
            int t1 = Integer.parseInt(txtAvenidaCentral.getText().trim());
            int t2 = Integer.parseInt(txtPeriferico.getText().trim());
            int t3 = Integer.parseInt(txtCarreteraNacional.getText().trim());

            dataProcessor.addTrafficData(ciudad + " - Avenida Central", t1);
            dataProcessor.addTrafficData(ciudad + " - Periférico Metropolitano", t2);
            dataProcessor.addTrafficData(ciudad + " - Carretera Nacional", t3);

            // Generar reporte completo
            String reporte = dataProcessor.generateTrafficReport();
            txtResultados.setText(reporte);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos.");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String csv = dataProcessor.generateCsvReport();
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(new java.io.File("reporte_trafico.csv"));
            int res = chooser.showSaveDialog(this);
            if (res == JFileChooser.APPROVE_OPTION) {
                java.io.File file = chooser.getSelectedFile();
                Files.write(Paths.get(file.getAbsolutePath()), csv.getBytes(StandardCharsets.UTF_8));
                JOptionPane.showMessageDialog(this, "CSV exportado: " + file.getAbsolutePath());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al exportar CSV: " + ex.getMessage());
        }
    }

     public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Monitoreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Monitoreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Monitoreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Monitoreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Monitoreo().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAvenidaCentral;
    private javax.swing.JTextField txtCarreteraNacional;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtPeriferico;
    private javax.swing.JTextArea txtResultados;
    // End of variables declaration//GEN-END:variables

}