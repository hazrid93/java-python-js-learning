import toexport # normal
import toexport as namer # giving alias
from toexport import myAge, myName # specific import without needing filename during reference
from toexport import * # wildcard import , the only one that respect to not import single leading '_' underscore

toexport.myName("Ali");
namer.myAge("Abu");
myName("Abdul")