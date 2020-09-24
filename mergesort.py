from time import time
from io import open

def mergeSort(arr): 
    if len(arr) > 1: 
        mid = len(arr)//2
        L = arr[:mid]
        R = arr[mid:]

        mergeSort(L)
        mergeSort(R)
  
        i = j = k = 0

        while i < len(L) and j < len(R): 
            if L[i] < R[j]: 
                arr[k] = L[i] 
                i+= 1
            else: 
                arr[k] = R[j] 
                j+= 1
            k+= 1
          
        while i < len(L): 
            arr[k] = L[i] 
            i+= 1
            k+= 1
          
        while j < len(R): 
            arr[k] = R[j] 
            j+= 1
            k+= 1
  
def printList(arr): 
    for i in range(10):         
        print(arr[i], end =" ") 
    print() 
  
if __name__ == '__main__': 
    #n=int(input())
    tams = [100000,200000,500000,700000,800000,1000000]
    times = [0,0,0,0,0,0]
    f=open("mergepy.txt","w")
    
    for j in range(6):
        archivo=open("entrada.txt","r")
        lista=archivo.readlines()
        archivo.close()
        n=tams[j]
        A = [0 for k in range(n)]
        for i in range(n):
            A[i]=int(lista[i])
        t0=time()
        mergeSort(A)
        tiempo =time()-t0
        tiempo=round(tiempo,3)
        lista.clear()
        #printList(A)
        f.write(str(tams[j])+" , "+str(tiempo)+"\n")
  