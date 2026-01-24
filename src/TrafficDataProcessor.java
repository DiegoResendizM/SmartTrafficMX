import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase para procesar y analizar datos de tráfico
 * Proporciona funciones para calcular estadísticas y generar reportes
 */
public class TrafficDataProcessor {
    
    private Map<String, Integer> trafficData;
    private List<String> incidentReports;
    
    public TrafficDataProcessor() {
        this.trafficData = new HashMap<>();
        this.incidentReports = new ArrayList<>();
    }
    
    /**
     * Agrega datos de tráfico para una ubicación específica
     * @param location Ubicación del sensor
     * @param vehicleCount Número de vehículos detectados
     */
    public void addTrafficData(String location, int vehicleCount) {
        trafficData.put(location, vehicleCount);
        System.out.println("Datos agregados para " + location + ": " + vehicleCount + " vehículos");
    }
    
    /**
     * Calcula el promedio de vehículos en todas las ubicaciones
     * @return Promedio de vehículos
     */
    public double calculateAverageTraffic() {
        if (trafficData.isEmpty()) {
            return 0.0;
        }
        
        int total = 0;
        for (int count : trafficData.values()) {
            total += count;
        }
        return (double) total / trafficData.size();
    }
    
    /**
     * Encuentra la ubicación con mayor tráfico
     * @return Nombre de la ubicación con mayor tráfico
     */
    public String findHighestTrafficLocation() {
        if (trafficData.isEmpty()) {
            return "No hay datos disponibles";
        }
        
        String maxLocation = "";
        int maxCount = -1;
        
        for (Map.Entry<String, Integer> entry : trafficData.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxLocation = entry.getKey();
            }
        }
        return maxLocation;
    }
    
    /**
     * Reporta un incidente de tráfico
     * @param location Ubicación del incidente
     * @param description Descripción del incidente
     */
    public void reportIncident(String location, String description) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String incident = String.format("[%s] %s: %s", timestamp, location, description);
        incidentReports.add(incident);
        System.out.println("Incidente reportado: " + incident);
    }
    
    /**
     * Genera un reporte completo de tráfico
     * @return String con el reporte formateado
     */
    public String generateTrafficReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== REPORTE DE TRAFICO SMARTTRAFFICMX ===\n");
        report.append("Fecha y hora: ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n\n");
        
        // Estadísticas generales
        report.append("ESTADISTICAS GENERALES:\n");
        report.append("Total de ubicaciones monitoreadas: ").append(trafficData.size()).append("\n");
        report.append("Promedio de vehículos: ").append(String.format("%.2f", calculateAverageTraffic())).append("\n");
        report.append("Ubicación con mayor tráfico: ").append(findHighestTrafficLocation()).append("\n\n");
        
        // Detalles por ubicación
        report.append("DETALLES POR UBICACIÓN:\n");
        for (Map.Entry<String, Integer> entry : trafficData.entrySet()) {
            report.append("- ").append(entry.getKey()).append(": ").append(entry.getValue()).append(" vehículos\n");
        }
        
        // Incidentes reportados
        if (!incidentReports.isEmpty()) {
            report.append("\nINCIDENTES REPORTADOS:\n");
            for (String incident : incidentReports) {
                report.append("- ").append(incident).append("\n");
            }
        } else {
            report.append("\nNo hay incidentes reportados.\n");
        }
        
        return report.toString();
    }
    
    /**
     * Limpia todos los datos almacenados
     */
    public void clearAllData() {
        trafficData.clear();
        incidentReports.clear();
        System.out.println("Todos los datos han sido limpiados.");
    }
    
    /**
     * Método principal para demostrar el funcionamiento
     */
    public static void main(String[] args) {
        TrafficDataProcessor processor = new TrafficDataProcessor();
        
        // Simulación de datos de tráfico
        System.out.println("=== DEMO SMARTTRAFFICMX ===\n");
        
        processor.addTrafficData("CDMX - Centro", 150);
        processor.addTrafficData("CDMX - Norte", 200);
        processor.addTrafficData("GDL - Centro", 120);
        processor.addTrafficData("MTY - Sur", 180);
        processor.addTrafficData("PBL - Centro", 90);
        
        // Reportar incidentes
        processor.reportIncident("CDMX - Centro", "Congestión severa por manifestación");
        processor.reportIncident("GDL - Centro", "Accidente vehicular - carril cerrado");
        
        // Generar reporte
        System.out.println("\n" + processor.generateTrafficReport());
        
        // Mostrar estadísticas adicionales
        System.out.println("Estadísticas adicionales:");
        System.out.println("- Promedio de vehículos: " + processor.calculateAverageTraffic());
        System.out.println("- Ubicación con más tráfico: " + processor.findHighestTrafficLocation());
    }
}