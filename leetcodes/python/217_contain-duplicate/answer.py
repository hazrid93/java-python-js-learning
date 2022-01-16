
from typing import List

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        itemDict = dict()
        boolExist = False
        
        for count,value in enumerate(nums):
            if(itemDict.get(value) is None):
                itemDict[value] = "exist"
            elif(itemDict.get(value) is not None):
                boolExist = True
                return boolExist
        
        return boolExist

sol = Solution()
val = sol.containsDuplicate([1,2,3,1])
print(val)