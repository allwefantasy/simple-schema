# Simple Schema

A library provides a more easy way to describe DataFrame schema for Spark and [MLSQL](http://www.mlsql.tech).
  
## Requirements

This library requires Spark 2.3+/2.4+ (tested).

## Liking 

You can link against this library in your program at the following coordinates:

### Scala 2.11

```sql
groupId: tech.mlsql
artifactId: simple-schema_2.11
version: 0.2.0
```

## Usage

```scala
val s = SparkSimpleSchemaParser.parse("st(field(column1,string),field(column2,string),field(column3,string))")
assert(s == StructType(Seq(StructField("column1", StringType), StructField("column2", StringType), StructField("column3", StringType))))
```

Spark DataFrame schema normally is represented by `json`, but json is not easy to write and used as plain-text in quote.
Simple schema create a new format to make this easy.

st means StructType, filed means StructField,the first value in field is columnName,and the second is type.
For now, simple schema supports type like following:

1. st
2. field
3. string
4. float
5. double
6. integer
7. short
8. date
9. binary
10. map
11. array
12. long 
13. boolean
14. byte
15. decimal

Suppose you have a json data:

```json
{"column1":{"key":"value"}}
```

you can describe it like this:

```sql
st(field(column1,map(string,string)))
```

st also supports nesting:

```sql
st(field(column1,map(string,array(st(field(columnx,string))))))
```




