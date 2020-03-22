//import part01.sqroot.squareRoot
import numbers.{NumericFunctions, RangeSum => RS}

object Main extends App {
    println()
    println("Hello! I'm learning scala :)")
    println("---- Part 01 ----")
    println("The square root of 2 is: ", NumericFunctions.squareRoot(2))
    println("The factorial of 12 is: ", NumericFunctions.fact(12, 1))
    println("The gcd of 121 and 77 is: ", NumericFunctions.gcd(121, 77))
    println()
    println("---- Part 02 ----")
    println("Numers between 1 and 9 sums ", RS.sumRange(1, 9, 0))
    println("Square of numers between 1 and 9 sums ", RS.highOrderSumRange((x: Int) => x * x, 1, 9, 0))
    println("The same, but in a more functinoal approach ", RS.functionalSumRange((x: Int) => x*x) (1, 9, 0))
    println("And now, like a pro", RS.currySumRange((x: Int) => x*x)(1, 9, 0))
    println()
}