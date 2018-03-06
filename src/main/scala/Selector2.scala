import java.util.Date

object Selector2 {

  /**
    * Rucursive function traverses from the beginning of list and accumulates backdate ids
    *
    * @param values input data - list of pairs (Int, Date)
    * @param maxDate maximum date of traversed values
    * @param resultIDs list of ids, those pairs has backdated dates
    * @return
    */
  def recursiveFilterHelper(values: List[(Int, Date)], maxDate: Date, resultIDs: List[Int]): List[Int] = values match {
    case Nil => resultIDs
    case _ => {
      if (values.head._2.before(maxDate)) {
        recursiveFilterHelper(values.tail, maxDate, values.head._1 :: resultIDs)
      }
      else {
        recursiveFilterHelper(values.tail, values.head._2, resultIDs)
      }
    }
  }

  /**
    * Selects backdated dates uses recursive helper function
    *
    * @param values input data - list of pairs (Int, Date)
    * @return list of ids, those pairs has backdated dates
    */

  def selectBackDated(values: List[(Int, Date)]): List[Int] = values match {
    case Nil => List()
    case _ => recursiveFilterHelper(values, values.head._2, List())
  }
}
