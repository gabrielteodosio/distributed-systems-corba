# CORBA  [It's terrible, don't use it]

## SimpleCalculator

Here follows the step-by-step of what you need to do to get this working.

1. start **orbd** on port **1050**:

On unix systems use:
```
orbd -ORBInitialPort 1050
```

On windows systems use:
```
start orbd -ORBInitialPort 1050
```

2. then start the server side:

On unix systems use:
```
java SimpleCalculatorServer -ORBInitialPort 1050 -ORBInitialHost localhost
```

On windows systems use:
```
start java SimpleCalculatorServer -ORBInitialPort 1050 -ORBInitialHost localhost
```

3. and then start the client side:

On unix systems use:
```
java SimpleCalculatorClient 1 2 -ORBInitialPort 1050 -ORBInitialHost localhost
```

On windows systems use:
```
start java SimpleCalculatorClient 1 2 -ORBInitialPort 1050 -ORBInitialHost localhost
```

That is it. Thanks.