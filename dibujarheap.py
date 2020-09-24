import numpy as np

#import cv2
from matplotlib import pyplot as plt

x,y = np.loadtxt('heapcpp.txt' , delimiter=',' , unpack=True)
x1,y1 = np.loadtxt('heappy.txt' , delimiter=',' , unpack=True)
x2,y2 = np.loadtxt('heapjava.txt' , delimiter=',' , unpack=True)


plt.plot(x,y,color="blue",label="Heap Sort C++")
plt.plot(x1,y1,color="red",label="Heap Sort Python")
plt.plot(x2,y2,color="yellow",label="Heap Sort Java")

plt.legend()
# plt.plot(s,d,color="red")
plt.title('Heap Sort Algorithm')
plt.xlabel('Data')
plt.ylabel('Seconds')
plt.show()
