# Simple Calculator

### Server and GUI are integrated. GUI hits respective rest micro-service exposed by server.

#### GUI is developed using Angular 6

#### Server is developed using spring-boot 2.5

# GUI

## Details
1. Required operations: + (Addition), - (Subtraction), * (Multiplication), / (Division);
2. Optional options: ^ (Square by N), Square Root
3. Numbers can be any defined by: ^[0-9]+[.]?[0-9]*$; 
4. No thousand separators (,) is required in the output.


Calculator has following form fields
1. First number
2. Operator (dropdown)
3. Second Number (disabled by default, displayed only for valid operator, disabled for sqareroot as second number is not required)

Submit button will hit respective micro-sevice based on operator choosen.

For complete experience of calculator start the calculator server.


# Server

Calculator exposes vairous rest micro-services for each operator supported.

Details
- Required operations: + (Addition), - (Subtraction), * (Multiplication), / (Division);
- Optional options: ^ (Square by N), Square Root;
- Numbers can be any defined by: ^[0-9]+[.]?[0-9]*$;
- No thousand separators (,) is required in the outputs; and
- Print the result to the console.

## Exposed API's
1. Addition
#### @GET
http://localhost:8080/calculator/addition?firstnumber=10&secondnumber=20

2. Subtraction

#### @GET
http://localhost:8080/calculator/subtraction?firstnumber=50&secondnumber=20

3. Multiplication

#### @GET
http://localhost:8080/calculator/multiplication?firstnumber=50&secondnumber=20

4. Division

#### @GET
http://localhost:8080/calculator/division?firstnumber=50&secondnumber=20

5. SquareRoot

#### @GET
http://localhost:8080/calculator/sqrt/10

6. Power of

#### @GET
http://localhost:8080/calculator/pow?base=2&ext=3
