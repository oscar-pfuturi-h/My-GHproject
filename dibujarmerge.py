import numpy as np

#import cv2
from matplotlib import pyplot as plt

x,y = np.loadtxt('mergecpp.txt' , delimiter=',' , unpack=True)
x1,y1 = np.loadtxt('mergepy.txt' , delimiter=',' , unpack=True)
x2,y2 = np.loadtxt('mergejava.txt' , delimiter=',' , unpack=True)


plt.plot(x,y,color="blue",label="Merge Sort C++")
plt.plot(x1,y1,color="red",label="Merge Sort Python")
plt.plot(x2,y2,color="yellow",label="Merge Sort Java")

plt.legend()
# plt.plot(s,d,color="red")
plt.title('Merge Sort Algorithm')
plt.xlabel('Data')
plt.ylabel('Seconds')
plt.show()
