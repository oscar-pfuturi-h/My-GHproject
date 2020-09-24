#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <ctime>

using namespace std;

void print_array(int A[], int size) 
{ 
    int i; 
    for (i = 0; i < size; i++) 
        printf("%d ", A[i]); 
    printf("\n"); 
} 
  
void merge(int* arr, int l, int m, int r){
    int n1 = m - l + 1;
    int n2 = r - m;
    int* L = new int[n1];
    int* R = new int[n2];
    int i, j, k;

    for (i=0; i<n1; i++){
        *(L+i) = *(arr+l+i);
    }
    for (j=0; j<n2; j++){
        *(R+j) = *(arr+m+j+1);
    }

    i = 0; j = 0; k = l;
    while (i<n1 && j<n2){
        if (*(L+i) <= *(R+j)){
            *(arr+k) = *(L+i);
            i++;
        } else {
            *(arr+k) = *(R+j);
            j++;
        }
        k++;
    }
    while (i < n1){
        *(arr+k) = *(L+i);
        i++; k++;
    }
    while (j < n2){
        *(arr+k) = *(R+j);
        j++; k++;
    }
}

void mergesort(int* arr, int l, int r){
    if (r > l){
        int m = (l+r)/2;
        mergesort(arr, l, m);
        mergesort(arr, m+1, r);
        merge(arr, l, m, r);
    }
}



int main() 
{ 
    //int arr[] = {7,3,1,10,6,5,4,9};
    int *arr;
    int len[] = {100000,200000,500000,700000,800000,1000000};
    FILE *f = fopen("mergecpp.txt", "w");
    clock_t t0,t1;

    for (int i=0; i<6; i++){
        arr = new int[len[i]];
        for(int j=0; j<len[i]; j++){
            scanf("%d", &arr[j]);
        }
        t0 = clock();
        mergesort(arr, 0, len[i]-1);
        t1 = clock();
        //print_array(arr, 100);
        double time = (double)(t1-t0)/CLOCKS_PER_SEC;
        fprintf(f,"%d , %f\n", len[i], time);
    }
} 
