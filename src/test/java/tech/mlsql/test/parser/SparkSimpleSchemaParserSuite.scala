package tech.mlsql.test.parser

import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.scalatest.{BeforeAndAfterAll, FunSuite}
import tech.mlsql.schema.parser.SparkSimpleSchemaParser

/**
  * 2019-06-25 WilliamZhu(allwefantasy@gmail.com)
  */
class SparkSimpleSchemaParserSuite extends FunSuite
  with BeforeAndAfterAll {
  test("parse sting schema to StructType") {
    val s = SparkSimpleSchemaParser.parse("st(field(column1,string),field(column2,string),field(column3,string))")
    assert(s == StructType(Seq(StructField("column1", StringType), StructField("column2", StringType), StructField("column3", StringType))))
  }
}
