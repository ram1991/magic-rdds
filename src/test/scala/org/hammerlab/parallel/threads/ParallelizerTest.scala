package org.hammerlab.parallel.threads

import org.hammerlab.parallel
import parallel.makeParallelizer

class ParallelizerTest
  extends parallel.ParallelizerTest {

  implicit val config = Config(4)

  override def make(arr: Array[Int]): Array[String] =
    arr.pmap[String](_.toString)
}

class SingleThreadParallelizerTest
  extends ParallelizerTest {
  override implicit val config = Config(1)
}
