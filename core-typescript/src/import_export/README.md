# Import Export

## import … = require(…) versus const … = require(…)
Using const .. = require(..) will not import the type definition at least in typescript.
Hence autocompletion will not work, its better to use import .. = require(..) to have auto completion (intellisense)

At runtime (or once the code is compiled), there is no difference between the two syntaxes, the first one is converted to the second one.


- With import:
```
import x = require('x')
```
This syntax is specific to TypeScript. The constant x is of type given by some typing defined in the imported package or in a package @types/x.

- With const:
```
const x = require('x')
```
This is a valid syntax in JavaScript and of course in TypeScript. In TypeScript, the constant x is of type any.

## import … from … versus import … = require(…)

The syntax import … from … is from the ES6 standard.
But, in short, the syntax import x from 'x' is equivalent to:
```
import x = require('x').default
```
(Notice the .default member.)

> How to convert import … = require(…) to the ES6 syntax

The ES6 standard states that all exported members can be imported into a single "namespace object module".

Then the closest standard syntax of import x = require('x') is:

```
import * as x from 'x'
```
This syntax currently works well with the TypeScript transpilation because the code is converted to a const … = require(…).

However: This syntax should be used only in the context defined by the standard. Because, when your code will use a native version of ES6 modules, you won't be able to import a function or a class that way.

# Note
- getting autocomplete in typescript > [link](https://stackoverflow.com/questions/40268442/vscode-typescript-intellisense-not-working)
- more about type acquisition (intellisense) > [link](https://code.visualstudio.com/docs/nodejs/working-with-javascript#_typings-and-automatic-type-acquisition)