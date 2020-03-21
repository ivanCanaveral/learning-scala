package numbers

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

}