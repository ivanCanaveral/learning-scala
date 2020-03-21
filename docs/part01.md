# Part 01

## call-by-vale vs call-by-name

**call-by-value**: when a function is executed, first the argument expressions are evaluated, and then the function is executed.

For example, given the following function:

```scala
def prod2(x: Int, y: Int): Int = x * y
```

these are the steps followed by the interpreter

```scala
prod2(3+2, 1+2)
prod2(5, 3)
5 * 3
15
```

**call-by-name**: first the expressions given as arguments are substituted in the function, and the function starts to be executed, evaluating the expressions only when necessary.

```scala
prod2(3+2, 1+2)
(3+2) * (1+2)
5 * (1+2)
5 * 3
15
```

* _Call-by-value_ has the advantage that it evaluates every function
argument only once.
* _Call-by-name_ has the advantage that a function argument is not
evaluated if the corresponding parameter is unused in the evaluation
of the function body.
* If _call-by-value_ evaluation of an expression e terminates, then _call-by-name_
evaluation of e terminates.
* The other direction is not true
* When we declare a variable usin `val`, its right-hand-side is evaluated at that step, in a _call-by-value_ style. If we use `def`, the right-hand-side is purely _call-by-value_. The difference between them becomes apparent in the following exaple:

```scala
def loop: Boolean = loop

def x = loop // this is OK

val x = loop // this never ends ...
```