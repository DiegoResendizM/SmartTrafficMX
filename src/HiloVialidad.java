import java.io.*;
import java.io.*;
import java.util.Random;
import javax.swing.*;


public class HiloVialidad extends Thread {
    private String nombreVialidad;
    private int traficoActual;
    private final JTextArea areaResultados;
    private final String nombreCiudad;
    private final Random rand;

    public HiloVialidad(String nombreVialidad, int traficoInicial, JTextArea area, String ciudad) {
        this.nombreVialidad = nombreVialidad;
        this.traficoActual = traficoInicial;
        this.areaResultados = area;
        this.nombreCiudad = ciudad;
        this.rand = new Random();
    }

    private String clasificarTrafico(int trafico) {
        if (trafico <= 20) {
            return "Fluido";
        } else if (trafico <= 40) {
            return "Moderado";
        } else if (trafico <= 60) {
            return "Congestionado";
        } else {
            return "Colapsado";
        }
    }

    @Override
    public void run() {
        String nombreArchivo = "SmartTrafficMX_" + nombreCiudad + ".txt";
        
        try (FileWriter escritor = new FileWriter(nombreArchivo, true)) {
            // Escribir encabezado para esta vialidad
            String encabezado = "\n========== " + nombreVialidad + " ==========\n";
            escritor.write(encabezado);
            escritor.flush();
            
            SwingUtilities.invokeLater(() -> {
                areaResultados.append(encabezado);
            });

            // Simulación de 360 minutos (6 horas)
            for (int minuto = 1; minuto <= 360; minuto++) {
                // Generar variación aleatoria más balanceada: -8 a +8
                int variacion = rand.nextInt(17) - 8;
                traficoActual += variacion;
                
                // Asegurar que el tráfico no sea negativo
                if (traficoActual < 0) {
                    traficoActual = 0;
                }
                
                // Limitar tráfico máximo
                if (traficoActual > 100) {
                    traficoActual = 100;
                }

                // Clasificar el tráfico
                String clasificacion = clasificarTrafico(traficoActual);

                // Crear registro
                String registro = String.format("Minuto %3d | %s | Tráfico: %3d veh/min | Variación: %+3d | Estado: %s",
                        minuto, nombreVialidad, traficoActual, variacion, clasificacion);

                // Escribir en archivo
                escritor.write(registro + System.lineSeparator());
                escritor.flush();

                // Actualizar interfaz gráfica
                final String registroFinal = registro;
                SwingUtilities.invokeLater(() -> {
                    areaResultados.append(registroFinal + "\n");
                    // Auto-scroll hacia abajo
                    areaResultados.setCaretPosition(areaResultados.getDocument().getLength());
                });

                // Pausa de 100ms para simular el paso del tiempo
                Thread.sleep(100);
            }

            // Escribir resumen final
            String resumen = String.format("\n--- Resumen %s ---\nTráfico final: %d veh/min | Estado final: %s\n",
                    nombreVialidad, traficoActual, clasificarTrafico(traficoActual));
            escritor.write(resumen);
            escritor.flush();

            SwingUtilities.invokeLater(() -> {
                areaResultados.append(resumen);
            });

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
            SwingUtilities.invokeLater(() -> {
                areaResultados.append("ERROR: No se pudo escribir en el archivo para " + nombreVialidad + "\n");
            });
        } catch (InterruptedException e) {
            System.err.println("Hilo interrumpido: " + e.getMessage());
        }
    }
}