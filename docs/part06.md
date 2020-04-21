# Pattern matching

This is one of the most common tools in functional programming:

```scala
def eval(e: Expr): Int = e match {
    case Number(n) => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
}
```
and throws `MatchError` if no pattern matches.

A `match` instruction is followed by a sequence of cases `pattern => expression`.

Patternts are composed of:

 * constructors
 * variables
 * wildcard patterns (like `_`)
 * constants

The same values can't appear more than once:

```scala
sum(x,x) // error
sum(x,y) // ok
```

Names of constants starts with a capital letter

A constructor pattern `C(x1, ..., xn)` matches al the values of type `C` or a subtype that have been constructed with arguments matching `x1, ..., xn`.

A variable pattern `x` matches any value.

A constant pattern `c` matches values that are equal to c (`==`)
