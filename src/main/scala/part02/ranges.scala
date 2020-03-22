package numbers

import scala.annotation.tailrec

object RangeSum {

  /*
  * Sums all numbers between a and b
  */
  @tailrec
  def sumRange(a: Int, b: Int, acc: Int): Int =
    if (a >= b) acc
    else sumRange(a + 1, b, a + acc)

  @tailrec
  def highOrderSumRange(f: Int => Int, a: Int, b: Int, acc: Int): Int =
    if (a >= b) acc
    else highOrderSumRange(f, a + 1, b, f(a) + acc)

  /*
  * A function that returns as function
  */
  def functionalSumRange(f: Int => Int): (Int, Int, Int) => Int = {
    
    @tailrec
    def sumRange(a: Int, b: Int, acc: Int): Int =
      if (a >= b) acc
      else sumRange(a + 1, b, f(a) + acc)
    
    sumRange
  }

  @tailrec
  def currySumRange(f: Int => Int)(a:Int, b:Int, acc:Int): Int =
    if (a >= b) acc
    else currySumRange(f)(a + 1, b, f(a) + acc)
}