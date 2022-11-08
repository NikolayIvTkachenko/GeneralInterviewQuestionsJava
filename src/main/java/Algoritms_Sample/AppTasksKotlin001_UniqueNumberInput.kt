package Algoritms_Sample

/*
На вход приходит List с названием array состоящий из целых чисел
Вернуть true если каждая цифра в нем встречается уникальное кличество раз

array = [1] -> true (1 встречается 1 )
array = [2, 2, 1, 1] -> false (2 встречается 2 , 1 встречается 2 )
array = [4, 5, 5, 4, 4, 10] -> true (4 встречается 3 , 5 встречается 2 , 10 встречается 1 )

 */


//((4, 3), (5,2), (10,1))
fun main() {

    println("Test...")
    val list3 = listOf<Int>(4, 5, 5, 4, 4, 10)
    println(functionUnique(list3))
}


fun functionUnique(array: List<Int>): Boolean {
    val map = hashMapOf<Int, Int>()
    array.forEach { number -> map.put(number, (map.get(number)?: 0)+1)}
    println(map)
    println(array)
    println()
    return map.size == array.toSet().size
}