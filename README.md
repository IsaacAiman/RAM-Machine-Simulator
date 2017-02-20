# RAM Machine Simulator

This program simulates the behaviour of a RAM machine.

## Compile

To compile the code, you only need to execute:

```
javac RamSimulator.java
```

## Execute

In order to execute the program you will need to specify the following in the command line:

```
java RamSimulator ramProgram.ram inputTape.in outputTape.out debug
```

* **ramProgram.ram**: file that contains the RAM machine program.
* **inputTape.in**: file that contains the input tape.
* **outputTape.in**: file in which the output tape will be written. If it doesn't exist it will be created.
* **debug**: if it's a `1` the RAM simulator will execute with the debug mode showing the values of the *IP, data memory, program memory, input tape, output tape, and the number of instructions that have been executed*. If it's a `0` it won't show all these values.

For example:

```
java RamSimulator test1.ram inTape.in outTape.out 0
```

## Documentation

You can find all the code documentation following this link: https://alu0100841565.github.io/RAM-Machine/index.html
