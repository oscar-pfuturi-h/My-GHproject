import java.io.*;
import java.util.Scanner;

public class HeapSort {

    public void hsort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {

        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Leer_fichero acc = new Leer_fichero();
        Escribir out= new Escribir();
        double a;
        int tams[];
        tams = new int[6];
        tams[0] =100000;
        tams[1] =200000;
        tams[2] =500000;
        tams[3] =700000;
        tams[4] =800000;
        tams[5] =1000000;

        double times[];
        times = new double[6];

        for(int i=0;i<6;i++){
            a=acc.lee(tams[i]);
            times[i]=a;
        }
        out.escr(tams,times);
    }
}

class Leer_fichero{
    public double lee(int n){
        double t_1=1.1;
        try{
            ento = new FileReader("entrada.txt");
            BufferedReader mibuffer = new BufferedReader(ento);

            String linea="";
            double TInicio, TFin;//, t_1;

            int A[];
            A=new int[n];

            int entero,i;
            i=0;
            while(linea!=null){
                linea=mibuffer.readLine();

                if(linea!=null){
                    linea=linea.substring(0,linea.length()-1);
                    entero = Integer.parseInt(linea);

                    A[i]=entero;
                    i=i+1;
                    if(i==n){
                        HeapSort ob = new HeapSort();
                        TInicio = System.currentTimeMillis();
                        ob.hsort(A);
                        TFin = System.currentTimeMillis();
                        t_1 = (TFin - TInicio)/1000;
                        break;
                    }
                }
            }
        }catch (IOException e){
            System.out.println("Archivo no encontrado");
        }finally{
            try{
                ento.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return t_1;
    }
    FileReader ento;
}

class Escribir{
    public void escr(int tams [], double times[]){
        try {
            FileWriter escritura=new FileWriter("heapjava.txt");
            String tipeo;
            String tam_1;
            for(int i=0;i<6;i++){
                tipeo=times[i]+"";
                tam_1=tams[i]+"";
                escritura.write(tams[i]+" , "+tipeo+"\n");
            }
            escritura.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
