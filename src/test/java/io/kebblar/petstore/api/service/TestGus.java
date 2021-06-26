package io.kebblar.petstore.api.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;
import com.ibm.icu.util.Calendar;

import io.kebblar.petstore.api.model.domain.GraficaMascota;
import io.kebblar.petstore.api.model.domain.GraficaPaqueteria;

public class TestGus {
    public static void main(String...argv) {
        // Gson convierte objetos en cadenas Json y viciversa
        Gson gson = new Gson();
        TestGus test = new TestGus();
        
        // Crea listas de POJOS para hacer una prueba
        List<GraficaPaqueteria> graficasPaqueteria = getGraficasPaqueteria();
        List<GraficaMascota> graficasMascota = getGraficasMascota();

        // Calcula las cadenas DE TU MANERA
        String a = test.formatearGraficaPaqueteria(graficasPaqueteria);
        String b = test.formatearGraficaMascota(graficasMascota);
        
        // Crea objetos A MI MANERA
        ChartWrapper x = build(graficasPaqueteria);
        ChartWrapper y = build2(graficasMascota);
        
        // Pinta tus cadenas
        System.out.println(a);
        System.out.println(b);
        
        System.out.println("------------------------------------------");
        
        // Pinta las representaciones JSON de mis objetos
        System.out.println(gson.toJson(x));
        System.out.println(gson.toJson(y));
        
        // OBSERVEN QUE DA LO MISMO !!!!!!!!!!!!
        // EXAMINEN LA SIMPLEZA DE LAS CLASES DE PRUEBA: ChartWrapper y ChartData
        // Hasta se podría eliminar la clase ChartWrapper si a los clienes de este pojo se les ajusta su recepción
    }
    
    private static ChartWrapper build(List<GraficaPaqueteria> graficasPaqueteria) {
        List<String> label = new ArrayList<>();
        List<Long> data = new ArrayList<>();
        Set<String> mes = new HashSet<>();
        for(GraficaPaqueteria gp : graficasPaqueteria) {
            label.add(gp.getPaqueteria());
            mes.add(obtenerMes(gp.getFecha()));
            data.add(gp.getCantidad());
        }
        ChartData chartData = new ChartData(label, data, mes);
        return new ChartWrapper(chartData);
    }

    private static ChartWrapper build2(List<GraficaMascota> graficasMascota) {
        List<String> label = new ArrayList<>();
        List<Long> data = new ArrayList<>();
        Set<String> mes = new HashSet<>();
        for(GraficaMascota gp : graficasMascota) {
            label.add(gp.getMascota());
            mes.add(obtenerMes(gp.getFecha()));
            data.add(gp.getCantidad());
        }
        ChartData chartData = new ChartData(label, data, mes);
        return new ChartWrapper(chartData);
    }    
    
    private String formatearGraficaPaqueteria(List<GraficaPaqueteria> graficas) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbData = new StringBuilder();
        String mes = "";
        String cadena;
        String cadenaTmp;
        String cadenaMes;
        sb.append("{\"chart\":{\"label\":[");
        for (int i = 0; i < graficas.size(); i++) {
            sb.append("\"" + graficas.get(i).getPaqueteria() + "\",");
            sbData.append(graficas.get(i).getCantidad() + ",");
            mes = ("\"" + obtenerMes(graficas.get(i).getFecha()) + "\",");
        }
        cadenaTmp = sb.substring(0, sb.toString().length() - 1) + "],\"data\":[" + sbData.toString();
        cadenaMes = cadenaTmp.substring(0, cadenaTmp.toString().length() - 1) + "],\"mes\":[" + mes;
        cadena = cadenaMes.substring(0, cadenaMes.toString().length() - 1);
        //System.out.println(cadena + "]}}");
        return cadena + "]}}";
    }
    
    private String formatearGraficaMascota(List<GraficaMascota> graficas) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbData = new StringBuilder();
        String mes = "";
        String cadena;
        String cadenaTmp;
        String cadenaMes;
        sb.append("{\"chart\":{\"label\":[");
        for (int i = 0; i < graficas.size(); i++) {
            sb.append("\"" + graficas.get(i).getMascota() + "\",");
            sbData.append(graficas.get(i).getCantidad() + ",");
            mes = ("\"" + obtenerMes(graficas.get(i).getFecha()) + "\",");
        }
        cadenaTmp = sb.substring(0, sb.toString().length() - 1) + "],\"data\":[" + sbData.toString();
        cadenaMes = cadenaTmp.substring(0, cadenaTmp.toString().length() - 1) + "],\"mes\":[" + mes;
        cadena = cadenaMes.substring(0, cadenaMes.toString().length() - 1);
        //System.out.println(cadena + "]}}");
        return cadena + "]}}";
    }

    
    
    private static String obtenerMes(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        String mes = new SimpleDateFormat("MMMM").format(cal.getTime());
        return mes;
    }

    private static List<GraficaPaqueteria> getGraficasPaqueteria() {
        List<GraficaPaqueteria> graficasPaqueteria = new ArrayList<>();
        GraficaPaqueteria gp = null;
        for(long i =0; i<10; i++) {
            gp = new GraficaPaqueteria("paq"+i, i, new Date());
            graficasPaqueteria.add(gp);
        }
        return graficasPaqueteria;
    }
    
    private static List<GraficaMascota> getGraficasMascota() {
        List<GraficaMascota> graficasMascota = new ArrayList<>();
        GraficaMascota gp = null;
        for(long i =0; i<10; i++) {
            gp = new GraficaMascota("mascota"+i, i, new Date());
            graficasMascota.add(gp);
        }
        return graficasMascota;
    }
    
}
