import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LaDeuda {

    public static List<Integer> díasDePago(List<List<Integer>> deudas){

        List<Integer> diasDePago = new ArrayList<>();
        Double sum;
        Integer dias;
        Double pagoAnterior;

        for(List<Integer> list: deudas){
            sum = 1d;
            dias = 1;

            Integer deuda = list.get(0);
            while(sum < list.get(0)){
                pagoAnterior = Math.pow(2,dias);
                sum += pagoAnterior;
                dias += 1;
            }
            diasDePago.add(dias);

        }

        return diasDePago;

    }

    public static void main(String[] args) {
        // El primer día la persona deba pagar solo 1 peso
        // cada día que pasa deberá pagar el doble de lo que pagó el día anterior
        // El ultimo día deberá pagar lo que falta

        // N -> devolver un entero indicando la cantidad de días requeridos para resolverlo.

        // Recibe lista de deudas.
        // Retornar un lista que representa la cantidad de días para pagar la deuda.

        Scanner s  = new Scanner(System.in);
        List<List<Integer>> deudas = new ArrayList<>();
        int numeroDeudas, valorPrestado;

        System.out.println("Ingrese el número de deudas");
        numeroDeudas = s.nextInt();
        s.nextLine();


        for (int i = 0; i< numeroDeudas; i++){
            List<Integer> valorDeuda = new ArrayList<>();
            System.out.println("Ingres el valor prestado ");
            valorPrestado = s.nextInt();
            s.nextLine();

            valorDeuda.add(valorPrestado);
            deudas.add(valorDeuda);
        }

        díasDePago(deudas).forEach(System.out::println);

    }
}
