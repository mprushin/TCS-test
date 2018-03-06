import java.util.{Calendar, Date}

import org.scalatest.FunSuite

trait SelectorTest extends FunSuite {

  val data1 = List((1, new Date(2016, 9, 11)),
    (2, new Date(2016, 9, 12)),
    (3, new Date(2016, 9, 13)),
    (4, new Date(2016, 9, 14)),
    (5, new Date(2016, 9, 9)),
    (6, new Date(2016, 9, 8)),
    (7, new Date(2016, 9, 15))
  )

  val dateSeq = for (
  year <- (1900 to 2020);
  month <- (1 to 12);
  day <- (1 to 28)
  )
  yield (new Date(year, month, day))


  val data2 = ((1 to 43020) zip dateSeq).toList

  test("test Selector1 selection on data1") {
    assert(Selector1.selectBackDated(data1).sortBy[Int](i => i) == List(5, 6))
  }

  test("test Selector2 selection on data1") {
    assert(Selector2.selectBackDated(data1).sortBy[Int](i => i) == List(5, 6))
  }

  test("test Selector1 selection on data2") {
    assert(Selector1.selectBackDated(data2).sortBy[Int](i => i) == List())
  }

  test("test Selector2 selection on data2") {
    assert(Selector2.selectBackDated(data2).sortBy[Int](i => i) == List())
  }
}
