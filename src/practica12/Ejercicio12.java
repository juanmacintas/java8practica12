/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica12;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.THURSDAY;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.DECADES;
import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.ChronoUnit.WEEKS;
import static java.time.temporal.ChronoUnit.YEARS;
import java.time.temporal.TemporalAdjusters;


/**
 * Ejercicios con LocalDate y LocalTime
 * @author juanma
 */
public class Ejercicio12 {

    public static void main (String args[]) {
        System.out.println("***** COMIENZO MAIN*****");
        //Se ejecuta la actividad 12.1
        actividad12_1_Fechas();
                
        actividad12_1_Horas();
     
        actividad12_1_Curso();
    }
    
    private static void actividad12_1_Curso () {
        System.out.println("***** COMIENZO EJERCICIO 12 1 Curso *****");
        System.out.println("El curso comienza el segundo jueves de Septiembre");
        LocalDate fechaComienzo = LocalDate.of(2017, Month.SEPTEMBER, 1).with(TemporalAdjusters.firstInMonth(THURSDAY)).with(TemporalAdjusters.next(THURSDAY));
        System.out.println("El curso comienza:" + fechaComienzo);
        //El curso termina el 25 de JUNIO
        LocalDate fechaFin = LocalDate.of(2018, Month.JUNE, 25);
        System.out.println("El curso termina:" + fechaFin);
        
        
        long numeroSemanasExc = 4;
        long numeroDiaUlt = 0;
        int numeroDiasSemana = 5;
        if (fechaFin.getDayOfWeek() != MONDAY) {
            LocalDate ultimaSemanaEmpieza = fechaFin.with(TemporalAdjusters.previous(MONDAY));
            numeroDiaUlt = fechaComienzo.until(ultimaSemanaEmpieza,DAYS) + 1;
            numeroSemanasExc ++;
        }
        /*
          Cuantos días tiene el curso teniendo en cuenta:
          2 semanas de vacaciones en navidad
          2 semanas de vacaciones extra
          Clase de lunes a viernes
         */
        long numeroDias = (fechaComienzo.until(fechaFin, WEEKS) - numeroSemanasExc) * numeroDiasSemana;
        numeroDias += numeroDiaUlt;        
        
        System.out.printf("El curso tiene un total de %d dias %n", numeroDias);
                
                
                
        System.out.println("***** FIN EJERCICIO 12 1 *****");
    }
    private static void actividad12_1_Horas () {
        System.out.println("***** COMIENZO EJERCICIO 12 1 HORAS *****");
        LocalTime salida = LocalTime.of(12, 30);
        LocalTime llegada = LocalTime.of(19,45);
        
        System.out.printf("El tren ha tardado %d minutos en completar el recorrido.%n", salida.until(llegada, MINUTES));
        // Si se retrasa 1 hora y 49 minutos, ¿a que hora llegaría?
        System.out.printf("La nueva hora de llegada tras el retraso es:" +  llegada.plusHours(1).plusMinutes(49) + "%n");
        
        System.out.println("***** FIN EJERCICIO 12 1 *****");
    }
    private static void actividad12_1_Fechas () {
        System.out.println("***** COMIENZO EJERCICIO 12 1 FECHAS *****");
        
        LocalDate miFechaNacimiento = Year.of(1982).atMonth(Month.OCTOBER).atDay(2);
        LocalDate miFechaBoda = Year.of(2017).atMonth(Month.APRIL).atDay(30);
        
        System.out.printf("Me he casado con %d años.%n", miFechaNacimiento.until(miFechaBoda, YEARS));
        System.out.printf("Me he casado con %d dias.%n", miFechaNacimiento.until(miFechaBoda, DAYS));
        
        System.out.printf("¿He nacido en año bisiesto? %b %n", miFechaNacimiento.isLeapYear());
        System.out.printf("El año que nací tiene %d días %n", miFechaNacimiento.lengthOfYear());
        
        System.out.printf("Nací un %s y me caso en %s %n", miFechaNacimiento.getDayOfWeek(), miFechaBoda.getDayOfWeek());
  
        LocalDate now = LocalDate.now();
        System.out.printf("He vivido %d décadas.%n", miFechaNacimiento.until(now, DECADES));
        
        System.out.printf("Este año mi cumpleaños cae en %s .%n", miFechaNacimiento.plusYears(miFechaNacimiento.until(now, YEARS)).getDayOfWeek());
        System.out.printf("El año que viene mi cumpleaños cae en %s .%n", miFechaNacimiento.plusYears(miFechaNacimiento.until(now, YEARS) +1).getDayOfWeek());
        
        System.out.println("***** FIN EJERCICIO 12 1 *****");
    }
}
