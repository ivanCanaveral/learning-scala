//import part01.sqroot.squareRoot
import numbers.{NumericFunctions, RangeSum => RS, Rational}
import trees.EmptyBTree
import linked.list.{EmptyLinkedList, NonEmptyLinkedList}
import plist.{EmptyPList, FullPList}

object Main extends App {
    println()
    println("Hello! I'm learning scala :)")
    println("---- Part 01 ----")

    val sqrt2 = NumericFunctions.squareRoot(2)
    println(s"The square root of 2 is: $sqrt2")

    val fact12 = NumericFunctions.fact(12, 1)
    println(s"The factorial of 12 is: $fact12")

    val gcd12177 = NumericFunctions.gcd(121, 77)
    println(s"The gcd of 121 and 77 is: $gcd12177")
    
    println()
    println("---- Part 02 ----")

    val sr19 = RS.sumRange(1, 9, 0)
    println(s"Numers between 1 and 9 sums $sr19")

    val srSquared = RS.highOrderSumRange((x: Int) => x * x, 1, 9, 0)
    println(s"Square of numers between 1 and 9 sums $srSquared")

    val srSquaredCool = RS.functionalSumRange((x: Int) => x*x) (1, 9, 0)
    println(s"The same, but in a more functinoal approach $srSquaredCool")

    val srSquaredPro = RS.currySumRange((x: Int) => x*x)(1, 9, 0)
    println(s"And now, like a pro $srSquaredPro")

    val p: Rational = new Rational(1,3)
    val q: Rational = new Rational(1,2)
    println("The sum of 1/3 and 1/2 is: ", p.sum(q))

    println()
    println("---- Part 03 ----")

    val t: EmptyBTree = new EmptyBTree
    println("This is a Tree: ", t.add(2))

    val el: EmptyLinkedList = new EmptyLinkedList
    val nel: NonEmptyLinkedList = el.add(1)
    println("We have created a list with", nel.length, "elements.")
    
    val pl: FullPList[Double] = new FullPList(3.0, new EmptyPList[Double])
    println("This is a parametrized list ", pl)
    println()
}