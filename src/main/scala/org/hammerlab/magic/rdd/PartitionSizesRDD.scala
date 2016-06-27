package org.hammerlab.magic.rdd

import org.apache.spark.rdd.RDD

import scala.reflect.ClassTag

class PartitionSizesRDD[T: ClassTag](rdd: RDD[T]) {
  lazy val partitionSizes =
    rdd.mapPartitionsWithIndex((idx, it) => {
      Iterator(it.size)
    }).collect()
}

object PartitionSizesRDD {
  implicit def rddToPartitionSizesRDD[T: ClassTag](rdd: RDD[T]): PartitionSizesRDD[T] = new PartitionSizesRDD(rdd)
}
