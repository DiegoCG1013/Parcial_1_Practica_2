package dominio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Tablero {

    private static int DIMENSION = 30;
    private int[][] estadoActual;
    private int[][] estadoSiguiente = new int[DIMENSION][DIMENSION];

    public void leerEstadoActual() {
        //Lo hago con esto porque no me acuerdo de lo de los ficheros
        String matriz = "";
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("C:\\Users\\Diego\\IdeaProjects\\Informatica\\POO\\Parcial_1_Practica_2\\src\\main\\java\\dominio\\matriz.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while((linea=br.readLine())!=null)
                matriz = linea;
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        int contador = 0;
        for (int i = 0; i < DIMENSION; i++){
            for (int j = 0; j < DIMENSION; j++){
                estadoActual[i][j] = matriz.charAt(contador);
                contador++;
            }
        }
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < DIMENSION; i++){
            for (int j = 0; j < DIMENSION; j++){
                resultado += estadoActual[i][j];
            }
            resultado += "\n";
        }
        return resultado;
    }


    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        tablero.leerEstadoActual();
        System.out.println(tablero);
    }



}

