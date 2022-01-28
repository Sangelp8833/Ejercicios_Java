import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElProgramadorPerfeccionista {

    public static List<Boolean> CumpleoNocumple(List<List<Integer>> caso){
        List<Boolean> cumpleoNocumple = new ArrayList<>();
        int funcionesTotalesAlDía;
        int funcionesSemana = 0;

        for(List<Integer> list: caso){
            for(int i = 0; i < list.get(0); i++){
                if (i != list.get(0)-1){
                    funcionesTotalesAlDía = list.get(2) - list.get(3);
                }else {
                    funcionesTotalesAlDía = list.get(2);
                }
                funcionesSemana += funcionesTotalesAlDía;

            }
            if(funcionesSemana >= list.get(1)){
                cumpleoNocumple.add(true);
            }else{
                cumpleoNocumple.add(false);
            }
        }

        return cumpleoNocumple;
    }



    public static void main(String[] args) {
        // F cantidad de funciones nuevas
        // R cantidad de funciones que elimina
        // Programa que determine si Ricardo podrá cumplir con su asignación.

        // Datos de entrada.
        // D número de días del deadline
        // T cantidad de funciones totales que espera el cliente.
        // F cantidad de funciones nuevas que escribirá ricardo por día.
        // R cantidad de funciones que borrará ricardo cad día al finalizar.
        // True Logra; Flase No logra
        // True = 1; False = 0;

        // 0 < D < = 10000
        // 1 <=  T > = 5000
        // 1 <=  F <= 5000
        // F <= R < = 5000

        // N numero de posibilidades a evaluar
        // 4 representa las cuatro variables a leer
        // N líneas cada una con 4 variables (D T F R)

        // SOLUCIÓN DEL PROBLEMA ///


        int numeroCasos;
        int numeroVariables = 4;
        int D, T, F, R;
        Scanner s = new Scanner(System.in);
        List<List<Integer>> casos = new ArrayList<>();

        System.out.println("Número de casos a evaluar: ");
        numeroCasos = s.nextInt();
        s.nextLine();

        for(int i = 0; i < numeroCasos; i++){
            List<Integer> casos2 = new ArrayList<>();
            System.out.println("número de días");
            D = s.nextInt();
            s.nextLine();
            System.out.println("Cantidad de funciones");
            T = s.nextInt();
            s.nextLine();
            System.out.println("Funciones nuevas");
            F = s.nextInt();
            s.nextLine();
            System.out.println("Funciones borradas");
            R = s.nextInt();
            s.nextLine();
            casos2.add(D);
            casos2.add(T);
            casos2.add(F);
            casos2.add(R);

            casos.add(casos2);
        }


        System.out.println("\n**** RESULTADO *****");
        CumpleoNocumple(casos).stream().map(e -> e.equals(true) ? 1 : 0).forEach(System.out::println);

    }
}
