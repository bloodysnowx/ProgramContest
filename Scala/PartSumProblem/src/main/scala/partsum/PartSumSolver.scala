import scala.annotation.tailrec

object PartSumSolver {
  def main(args: Array[String]): Unit = {
    println(solve(Array[Int](1, 2, 4, 7), 13, 0))
    println(solve(Array[Int](1, 2, 4, 7), 15, 0))
    println(solve2(Array[Int](1, 2, 4, 7), 13))
    println(solve2(Array[Int](1, 2, 4, 7), 15))
  }
  def solve(a:Array[Int], k:Int, sum:Int): Boolean = {
    if(k == sum) return true
    else if(a.length == 0) return false
    if(solve(a.tail, k, sum + a.head)) return true
    if(solve(a.tail, k, sum)) return true
    false
  }
  def solve2(a:Array[Int], k:Int): Boolean = {
    List.range[Int](0, a.length + 1).exists(i => a.combinations(i).exists(combination => combination.sum == k))
  }
}