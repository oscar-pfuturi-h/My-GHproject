from time import time
from io import open

def heapify(arr, n, i):
    largest = i
    l = 2 * i + 1
    r = 2 * i + 2

    if l < n and arr[i] < arr[l]:
        largest = l

    if r < n and arr[largest] < arr[r]:
        largest = r

    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)

def heapSort(arr):
    n = len(arr)

    for i in range(n//2, -1, -1):
        heapify(arr, n, i)

    for i in range(n-1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]
        heapify(arr, i, 0)


if __name__ == '__main__': 
    #n=int(input())
    tams = [100000,200000,500000,700000,800000,1000000]
    times = [0,0,0,0,0,0]
    f=open("heappy.txt","w")
    
    for j in range(6):
        archivo=open("entrada.txt","r")
        lista=archivo.readlines()
        archivo.close()
        n=tams[j]
        A = [0 for k in range(n)]
        for i in range(n):
            A[i]=int(lista[i])
        t0=time()
        heapSort(A)
        tiempo =time()-t0
        tiempo=round(tiempo,3)
        lista.clear()
        #printList(A)
        f.write(str(tams[j])+" , "+str(tiempo)+"\n")