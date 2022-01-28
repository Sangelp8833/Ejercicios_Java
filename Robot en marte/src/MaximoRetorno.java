import java.util.ArrayList;
import java.util.List;

public class MaximoRetorno {

    // Inicio del ejercicio
    public static List<Integer> calcularMaximoRetorno(List<String> instruccion) {
        // Write your code here
        List<Integer> resultado = new ArrayList<>();
        String[] arr;

        List<Integer> dist = new ArrayList<>();
        for(int i = 0; i < instruccion.size(); i++){
            arr  = instruccion.get(i).split("");
            int[] coordenadaX = new int[arr.length+1];
            int[] coordenadaY = new int[arr.length+1];
            coordenadaX[0] = 0;
            coordenadaY[0] = 0;

            for(int j = 0; j < arr.length; j++) {
                // Iniciando las coordenadas
                if (arr[j].equals("R")) {
                    coordenadaX[j + 1] = coordenadaX[j] + 1;
                    coordenadaY[j + 1] = coordenadaY[j];
                } else if (arr[j].equals("L")) {
                    coordenadaX[j + 1] = coordenadaX[j] - 1;
                    coordenadaY[j + 1] = coordenadaY[j];
                } else if (arr[j].equals("U")) {
                    coordenadaX[j + 1] = coordenadaX[j];
                    coordenadaY[j + 1] = coordenadaY[j] + 1;
                } else if (arr[j].equals("D")) {
                    coordenadaX[j + 1] = coordenadaX[j];
                    coordenadaY[j + 1] = coordenadaY[j] - 1;
                }
                // Distance
                dist.add(Math.abs(coordenadaX[j + 1]) + Math.abs(coordenadaY[j + 1]));
            }

            int max = 0;
            int indice = 0;
            for(int o = 0; o < dist.size();o++){
                if(dist.get(o) >= max ){
                    max = dist.get(o);
                    indice = o;
                }
            }
            dist.clear();
            if(Math.abs(coordenadaX[indice]) == Math.abs(coordenadaY[indice]) ){
                resultado.add(Math.abs(max-2));
            }else {
                resultado.add(Math.abs((max)));
            }

        }


        return resultado;
    }

    public static void main(String[] args) {

        List<String> direcciones = new ArrayList<>();
        direcciones.add("RRRDDD");
        direcciones.add("UUUUUUUU");
        direcciones.add("URUUULDLLLLLUUUUUUUU");

        System.out.println("****** RESULTADO ******");
        calcularMaximoRetorno(direcciones).forEach(System.out::println);

    }

}
