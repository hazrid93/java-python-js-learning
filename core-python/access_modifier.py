
# in python there are no real traditional access modifier like java refer: https://www.python.org/dev/peps/pep-0008/#designing-for-inheritance,
# the behaviour with underscores on variable are mimicking access modifier in java
# SYNTAX reference like underscore etc. : https://www.python.org/dev/peps/pep-0008/
# extra symbol doc: https://docs.python.org/3/genindex-all.html#_

"""
According to Meaning of Underscores in Python : https://dbader.org/blog/meaning-of-underscores-in-python

-Single Leading Underscore(_var): Naming convention indicating a name is meant for internal use. Generally not enforced by the Python
     interpreter (except in wildcard imports) and meant as a hint to the programmer only. tldr : Variable with this underscore can be accessed/modified
     but not be imported via wildcard, regular import will still import
-Single Trailing Underscore(var_): Used by convention to avoid naming conflicts with Python keywords.
-Double Leading Underscore(__var): Triggers name mangling when used in a class context. Enforced by the Python interpreter.
    this will make the __var only accessible via class name, e.x: '__name' inside 'Foo' will be acessible by instance._Foo__name.
    If Foo is extended by 'Bar' then it will also be referable by child class , e.x: instance._Bar__name
-Double Leading and Trailing Underscore(__var__): Indicates special methods defined by the Python language. Avoid this naming scheme for your own attributes.
-Single Underscore(_) *literally: Sometimes used as a name for temporary or insignificant variables (“don’t care”). Also: The result of the last expression in a Python REPL.

"""

class BankAccount(object):
    def __init__(self, name, money, password):
        self.name = name            # Public
        self._money = money         # Private : Package Level
        self.__password = password  # Super Private

    def earn_money(self, amount):
        self._money += amount
        print("Salary Received: ", amount, " Updated Balance is: ", self._money)

    def withdraw_money(self, amount):
        self._money -= amount
        print("Money Withdraw: ", amount, " Updated Balance is: ", self._money)

    def show_balance(self):
        print(" Current Balance is: ", self._money)


account = BankAccount("Hitesh", 1000, "PWD")  # Object Initalization

# Method Call
account.earn_money(100)

# Show Balance
print(account.show_balance())

print("PUBLIC ACCESS:", account.name)  # Public Access

# account._money is accessible because it is only hidden by 'soft' convention ( by developer agreement )
print("PROTECTED ACCESS:", account._money)  # Protected Access

# account.__password will throw error but account._BankAccount__password will not
# because __password is super private
print("PRIVATE ACCESS:", account._BankAccount__password)

# Method Call
account.withdraw_money(200)

# Show Balance
print(account.show_balance())

# account._money is accessible because it is only hidden by convention
print(account._money)  # Protected Access