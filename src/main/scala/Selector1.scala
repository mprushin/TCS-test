import java.util.Date

object Selector1 {

  /**
    * Function isBackDated checks wheter date is backdated for data sequence with Id less than i
    * @param i - border identifier to check
    * @param date - date to check
    * @param data - input list of pairs (Int, Date)
    * @return - if date is before than at least one of the date from input list with identifier less than id then true, otherwise - false
    */
  def isBackDated(i: Int, date: Date, data: List[(Int, Date)]): Boolean = {
    val list = data.filter(pair => pair._1 < i).map(_._2)
    if (list.isEmpty) {
      false
    }
    else {
      date.before(list.max)
    }
  }

  /**
    * Function selects all ids with backdates from the input list
    * @param data - input list of pairs (Int, Date)
    * @return - list of ids
    */
  def selectBackDated(data: List[(Int, Date)]): List[Int] = {
    data.filter(pair => isBackDated(pair._1, pair._2, data)).map(pair => pair._1)
  }
}
