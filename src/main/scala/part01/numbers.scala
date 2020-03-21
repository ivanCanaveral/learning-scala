package numbers

import scala.annotation.tailrec

object NumericFunctions{

    def squareRoot(x: Double): Double = {
        // we can access x everywhere inside this function
        def iterate(currentValue: Double, maxIters: Int): Double = 
            if (isGoodEnough(currentValue) || maxIters < 1) currentValue
            else iterate(improve(currentValue), maxIters - 1)
        
        def isGoodEnough(currentValue: Double): Boolean =
            abs(currentValue - x) < 0.01

        def improve(currentValue: Double): Double =
            (currentValue + x / currentValue) / 2

        def abs(value: Double): Double = if (value > 0) value else -value

        def square(value: Double): Double = value * value

        iterate(1, 10)
    }

    @tailrec
    def fact(x: Int, acc: Int): Int =
        if (x == 0) acc
        else fact(x-1, x*acc)

    def gcd(a: Int, b: Int): Int ={
        
        @tailrec
        def euclid(x: Int, y: Int): Int =
            if (y == 0) x
            else euclid(y, x % y)
        
        if (a > b) euclid(a, b) else euclid(b, a)
    }
}