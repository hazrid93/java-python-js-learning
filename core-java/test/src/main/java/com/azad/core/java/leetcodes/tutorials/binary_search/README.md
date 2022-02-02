# Binary search

# Template
more discussion on template at [link](https://leetcode.com/discuss/explore/binary-search/744369/Can't-really-understand-the-difference-between-these-3-templates.)

Template Explanation:

```
- Template 1 :
At the end, you will be left with no elements to do anything. This is used when you want to find the target and the array doesn't contain any duplicates.

- Template 2:
you will be left with one element.

- Template 3:
you will be left with 2 elements at the end.

One use case for T2/ T3 is when the sorted array is rotated and also contains duplicates. now to find the min element, you need to check with one extra element other than mid. the while loop condition makes sure the search space contains that extra neighbours. the 2 templates just helps us in assuring that the search space is with extra elements other than left, mid, right i.e to avoid overflow when accessing mid+1 or anything.
```

![diagram](./Template_Diagram.png)


These 3 templates differ by their:

left, mid, right index assignments
loop or recursive termination condition
necessity of post-processing
Templates 1 and 3 are the most commonly used and almost all binary search problems can be easily implemented in one of them. Template 2 is a bit more advanced and used for certain types of problems.

Each of these 3 provided templates provides a specific use case:

 

## Template #1 (left <= right):

Most basic and elementary form of Binary Search
Search Condition can be determined without comparing to the element's neighbors (or use specific elements around it)
No post-processing required because at each step, you are checking to see if the element has been found. If you reach the end, then you know the element is not found
 

## Template #2 (left < right):

An advanced way to implement Binary Search.
Search Condition needs to access the element's immediate right neighbor
Use the element's right neighbor to determine if the condition is met and decide whether to go left or right
Guarantees Search Space is at least 2 in size at each step
Post-processing required. Loop/Recursion ends when you have 1 element left. Need to assess if the remaining element meets the condition.
 

## Template #3 (left + 1 < right):

An alternative way to implement Binary Search
Search Condition needs to access element's immediate left and right neighbors
Use element's neighbors to determine if the condition is met and decide whether to go left or right
Guarantees Search Space is at least 3 in size at each step
Post-processing required. Loop/Recursion ends when you have 2 elements left. Need to assess if the remaining elements meet the condition.
 

## Time and Space Complexity:

Runtime: O(log n) -- Logarithmic Time

Because Binary Search operates by applying a condition to the value in the middle of our search space and thus cutting the search space in half, in the worse case, we will have to make O(log n) comparisons, where n is the number of elements in our collection.

```
Why log n?

- Binary search is performed by dividing the existing array in half.

- So every time you a call the subroutine ( or complete one iteration ) the size reduced to half of the existing part.

- First N become N/2, then it become N/4 and go on till it find the element or size become 1.

- The maximum no of iterations is log N (base 2).
 ```

Space: O(1) -- Constant Space

Although Binary Search does require keeping track of 3 indices, the iterative solution does not typically require any other additional space and can be applied directly to the collection itself, therefore warrants O(1) or constant space.

 