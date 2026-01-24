/**
 * Demo de integración entre Monitoreo y TrafficDataProcessor
 * Este programa demuestra cómo funciona la integración
 */
public class DemoIntegracion {
    public static void main(String[] args) {
        System.out.println("=== DEMO DE INTEGRACIÓN SMARTTRAFFICMX ===\n");
        
        // Crear instancia del procesador
        TrafficDataProcessor processor = new TrafficDataProcessor();
        
        // Simular datos de diferentes ciudades
        System.out.println("1. Agregando datos de tráfico...");
        processor.addTrafficData("CDMX - Avenida Central", 150);
        processor.addTrafficData("CDMX - Periférico", 200);
        processor.addTrafficData("CDMX - Carretera Nacional", 180);
        
        processor.addTrafficData("GDL - Avenida Central", 120);
        processor.addTrafficData("GDL - Periférico", 140);
        processor.addTrafficData("GDL - Carretera Nacional", 110);
        
        processor.addTrafficData("MTY - Avenida Central", 180);
        processor.addTrafficData("MTY - Periférico", 220);
        processor.addTrafficData("MTY - Carretera Nacional", 190);
        
        // Reportar algunos incidentes
        System.out.println("\n2. Reportando incidentes...");
        processor.reportIncident("CDMX - Avenida Central", "Congestión severa por manifestación");
        processor.reportIncident("GDL - Periférico", "Accidente vehicular - carril cerrado");
        processor.reportIncident("MTY - Carretera Nacional", "Obras en progreso - velocidad reducida");
        
        // Mostrar análisis
        System.out.println("\n3. Análisis de tráfico:");
        System.out.println("- Promedio de vehículos: " + processor.calculateAverageTraffic());
        System.out.println("- Ubicación con mayor tráfico: " + processor.findHighestTrafficLocation());
        
        // Generar reporte completo
        System.out.println("\n4. Generando reporte completo:");
        System.out.println(processor.generateTrafficReport());
        
        System.out.println("\n=== DEMO COMPLETADA ===");
        System.out.println("Ahora puedes ejecutar la interfaz gráfica con: java -cp . inicio");
    }
}