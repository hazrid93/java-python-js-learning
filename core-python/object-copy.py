'''
A copy is sometimes needed so one can change one copy without changing the other. In Python, there are two ways to create copies :

Deep copy : new reference and new object
Shallow copy: new reference but point same object
'''

# //deep copy example
# Python code to demonstrate copy operations
# importing "copy" for copy operations
import copy
  
# initializing list 1
li1 = [1, 2, [3,5], 4]
  
# using deepcopy to deep copy 
li2 = copy.deepcopy(li1)
  
# original elements of list
print ("The original elements before deep copying")
for i in range(0,len(li1)):
    print (li1[i],end=" ")
  
print("\r")
  
# adding and element to new list
li2[2][0] = 7
  
# Change is reflected in l2 
print ("The new list of elements after deep copying ")
for i in range(0,len( li1)):
    print (li2[i],end=" ")
  
print("\r")
  
# Change is NOT reflected in original list
# as it is a deep copy
print ("The original elements after deep copying")
for i in range(0,len( li1)):
    print (li1[i],end=" ")

print("\n")

# //shallow copy
# Python code to demonstrate copy operations
  
# initializing list 1
li1s = [1, 2, [3,5], 4]
  
# using copy to shallow copy 
li2s = copy.copy(li1s)
  
# original elements of list
print ("The original elements before shallow copying")
for i in range(0,len(li1s)):
    print (li1s[i],end=" ")
  
print("\r")
  
# adding and element to new list
li2s[2][0] = 7
  
# checking if change is reflected
print ("The original elements after shallow copying")
for i in range(0,len( li1s)):
    print (li1s[i],end=" ")