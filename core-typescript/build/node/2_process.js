/**
 * Process also provides various properties to interact with. Some of them can be used in a Node application to provide a gateway to communicate between the Node application and any command line interface. This is very useful if you are building a command line application or utility using Node.js
 * process.stdin: a readable stream
 * process.stdout: a writable stream
 * process.stderr: a wriatable stream to recognize errors
 * Using argv you can always access arguments that are passed in a command line. argv is an array which has Node itself as the first element and the absolute path of the file as the second element. From the third element onwards it can have as many arguments as you want.
 */
process.stdout.write('Hello World!' + '\n');
// run with : `node 2_process.js hello`
// output:
/**
 * Hello World!
 * 0: C:\Program Files\nodejs\node.exe
 * 1: C:\codes\github\python-js-learning\core-typescript\build\node\2_process.js
 * 2: hello
 */
process.argv.forEach(function (val, index, array) {
    console.log(index + ': ' + val);
});
//# sourceMappingURL=2_process.js.map