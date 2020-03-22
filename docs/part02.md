# Part 02: Higher-Order functions

## Function types

Of course, in scala functions are first class citiziens. We can type then as follows:

``` scala
def myFunc(f: Int => Int, a: Int, b: Int): Int = ...
```

## Anonymous functions

When we need an extremely simple function, we can avoid investing time in a formal definition by using anonymous functions. In fact, it is very common not to type this type of function if the typing is obvious.

```scala
(x: Int, y: Int) => x + y
```
or in general terms:

```scala
(x_1:T_1, ..., x_n:T_n) => E
```
This is equivalent to:

```scala
{ def f(x_1:T_1, ..., x_n:T_n) = E; f}
```
 where `E` is a expression.

## Stepwise applications

Let's say we have a function like the following

```scala
def F(f: Int => Int): (Int, Int) => Int = ...
```
since it's a function that takes one function and returns another, we can do this

```scala
F ((x: Int) => x*x) (1, 9)
```

## Curry

Write functions that return other fuctions may require multiline expressions:

```scala
def functionalSumRange(f: Int => Int): (Int, Int, Int) => Int = {
    
  @tailrec
  def sumRange(a: Int, b: Int, acc: Int): Int =
    if (a >= b) acc
    else sumRange(a + 1, b, f(a) + acc)
    
  sumRange
}
```

However, scala supports a compact syntax for this:

```scala
@tailrec
def currySumRange(f: Int => Int)(a:Int, b:Int, acc:Int): Int =
  if (a >= b) acc
  else currySumRange(f)(a + 1, b, f(a) + acc)
```

The type of this function is

```scala
(Int => Int) => (Int, Int, Int) => Int
```

As in other functional languages, this type declaration is associative to the right, so this declaration is equivalent to

```scala
(Int => Int) => ((Int, Int, Int) => Int)
```

#### Currying

In general, the definition of a function

```scala
def f(args_1, ..., args_n) = E
```

is equivalent to

```scala
def f(args_1, ..., args_(n-1)) = {def g(arg_n) = E;g} = (args_n) => E
```

By repeating this process in a inductive way, we have:

```scala
def f = (args_1 => (args_2 => ... (args_n => E)...)))
```