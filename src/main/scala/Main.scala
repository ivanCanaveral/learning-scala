//import part01.sqroot.squareRoot
import numbers.{NumericFunctions, RangeSum => RS, Rational}
import trees.EmptyBTree
import linked.list.{EmptyLinkedList, NonEmptyLinkedList}
import plist.{EmptyPList, FullPList}

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