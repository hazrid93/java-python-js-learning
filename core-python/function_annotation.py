# use is to add static type checking by metadata for python, pyhthon itself will ignore but third party library
# can use this to check, ourselves via __annotations__ values, official note at : https://www.python.org/dev/peps/pep-3107/

# example, this will create...
def foo(a: 'x', b: 5 + 6, c: list) -> max(2, 9):
    pass

# for special type like 'List[]', refer https://docs.python.org/3/library/typing.html (need to write 'from typing import List')
def containsDuplicate(self, nums: List[int]) -> bool:
    pass

defaultFoo = foo('a', 12, [1,2])
''' //would result in an __annotations__ mapping of//
{'a': 'x',
 'b': 11,
 'c': list,
 'return': 9}
'''