import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EstimacionPerdida {

    public static List<Integer> maximoNumeroHoras(List<List<Integer>> equipo){

        List<Integer> maximoHoras = new ArrayList<>();
        int minimoHoras, promedio,tareas, maxhoras;
        int tiempoOtrasTareas;

        for(List<Integer> list: equipo ) {
            tareas = list.get(0);
            promedio = list.get(1);
            minimoHoras = list.get(2);
            maxhoras = 0;
            int n = 0;

            n = tareas - 2;
            tiempoOtrasTareas =  n * minimoHoras;

            maxhoras = promedio * tareas - (minimoHoras + tiempoOtrasTareas);

            maximoHoras.add(maxhoras);
        }




        return maximoHoras;
    }



    public static void main(String[] args) {
        // Cantidad de tareas que tenía el equipo
        // Promedio de estimación de tareas (Horas)
        // Duración de tareas con menor valor estimado

        // Necesita saber cual es la duración maxima que puede tener una de las tareas.

        //Recibe lista de 3 valores
        //Devuelve una lista que respresenta el número de días necesarios para pagar cada deuda

        // N número de tareas asignadas en el equipo.
        // T número de horas promedio de las tareas en el equipo
        // R Duración en horas de la tarea más pequeña en el equipo

        // 2 <= N <= 1000
        // R <= T <= 2000
        // 1 <= R <= 2000

        Scanner s = new Scanner(System.in);
        List<List<Integer>> equipos = new ArrayList<>();
        int N, T, R;
        int numeroEuipo;

        System.out.println("Ingrese el número de equipos");
        numeroEuipo = s.nextInt();
        s.nextLine();

        for(int i = 0; i < numeroEuipo; i++){
            List<Integer> tareasEquipos = new ArrayList<>();
            System.out.println("Ingrese el número de tareas asignadas");
            N = s.nextInt();
            s.nextLine();
            tareasEquipos.add(N);
            System.out.println("Ingrese el número de horas promedio");
            T = s.nextInt();
            s.nextLine();
            tareasEquipos.add(T);
            System.out.println("Ingrese la duración de la tarea más pequeña");
            R = s.nextInt();
            s.nextLine();
            tareasEquipos.add(R);

            equipos.add(tareasEquipos);
        }

        maximoNumeroHoras(equipos).forEach(System.out::println);


    }
}
