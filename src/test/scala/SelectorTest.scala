import java.util.Date

import org.scalatest.FunSuite

trait SelectorTest extends FunSuite {

  val data = List((1, new Date(2016, 9, 11)),
    (2, new Date(2016, 9, 12)),
    (3, new Date(2016, 9, 13)),
    (4, new Date(2016, 9, 14)),
    (5, new Date(2016, 9, 9)),
    (6, new Date(2016, 9, 8)),
    (7, new Date(2016, 9, 15))
  )

  test("test selection on values") {
    assert(Selector.selectBackDated(data).sortBy[Int](i => i) == List(5, 6))
  }
}
