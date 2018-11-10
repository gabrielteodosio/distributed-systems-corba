# CORBA  [It's terrible, don't use it]

## SimpleCalculator

Here follows the step-by-step of what you need to do to get this working.

1. start **orbd** on port **1050**:

```
orbd -ORBInitialPort 1050
```

2. then start the server side:

```
java SimpleCalculatorServer -ORBInitialPort 1050 -ORBInitialHost localhost
```

3. and then start the client side:

```
java SimpleCalculatorClient 1 2 -ORBInitialPort 1050 -ORBInitialHost localhost
```

That is it. Thanks.