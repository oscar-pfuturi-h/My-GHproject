import java.io.*;
import java.util.Scanner;

public class mergesort {
    static void print_array(int A[], int size){
        for (int i = 0; i < size; i++)
            System.out.print(A[i] + " ");
        System.out.println();
    }

    public void merge(int arr[], int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int leftArray[] = new int [n1];
        int rightArray[] = new int [n2];

        for (int i=0; i < n1; i++) {
            leftArray[i] = arr[left+i];
        }
        for (int j=0; j < n2; j++) {
            rightArray[j] = arr[mid + j + 1];
        }

        int i = 0, j = 0;

        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void msort(int arr[], int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            msort(arr, left, mid);
            msort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }
    public static void main(String[] args){
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
        /*int arr[] = { 12, 9, 3, 5, 6, 7 };

        mergesort test = new mergesort();
        long t0 = System.currentTimeMillis();
        test.msort(arr, 0, arr.length-1);
        long t1 = System.currentTimeMillis() - t0;
        System.out.println(t1);
        print_array(arr, arr.length);*/
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
                        mergesort ob = new mergesort();
                        TInicio = System.currentTimeMillis();
                        ob.msort(A, 0, n-1);
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
            FileWriter escritura=new FileWriter("mergejava.txt");
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
