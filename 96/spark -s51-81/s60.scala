Problem Scenario 60 : You have been given below code snippet. 
val a = sc.parallelize(List("dog", "salmon", "salmon", "rat", "elephant"), 3) 
val b = a.keyBy(_.length) 
b.collect
res9: Array[(Int, String)] = Array((3,dog), (6,salmon), (6,salmon), (3,rat), (8,elephant))

val c =sc.parallelize(List("dog", "cat", "gnu", "salmon", "rabbit", "turkey", "wolf", "bear", "bee"),3)
val d = c.keyBy(_.length)

d.collect
res8: Array[(Int, String)] = Array((3,dog), (3,cat), (3,gnu), (6,salmon), (6,rabbit), (6,turkey), (4,wolf), (4,bear), (3,bee))


operation1

Write a correct code snippet tor operation1 which will produce desired output, shown below.

Array[(Int,(String, String))] = Array((6,(salmon,salmon)), (6,(salmon,rabbit)), (6,(salmon,turkey)), (6,(salmon,salmon)), (6,(salmon,rabbit)), (6,(salmon,turkey)), (3,(dog,dog)), (3,(dog,cat)), (3,(dog,gnu)), (3,(dog,bee)), (3,(rat,dog)), (3,(rat,cat)), (3,(rat,gnu)), (3,(rat,bee)))

Solution : 

scala> b.join(d).collect
res10: Array[(Int, (String, String))] = Array((6,(salmon,salmon)), (6,(salmon,rabbit)), (6,(salmon,turkey)), (6,(salmon,salmon)), (6,(salmon,rabbit)), (6,(salmon,turkey)), (3,(dog,dog)), (3,(dog,cat)), (3,(dog,gnu)), (3,(dog,bee)), (3,(rat,dog)), (3,(rat,cat)), (3,(rat,gnu)), (3,(rat,bee)))




join [Pair] : Performs an inner join using two key-value RDDS. Please note that the keys must be generally comparable to make this work.
keyBy : Constructs two-component tuples (key-value pairs) by applying a function on each data item. The result of the function becomes the key and the original
data item becomes the value of the newly created tuples.


