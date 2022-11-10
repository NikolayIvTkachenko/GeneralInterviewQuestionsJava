package QuestionTasks

fun main() {

    val mapTest = HashMap<String, Int>().withDefault { -1 } //set default value
    println(mapTest["missing key 1"]) //-> null
    println(mapTest.get("missing key 2"))  //-> null
    println(mapTest.getValue("missing key 3")) // -> -1
    println(mapTest.getOrDefault("missing key 4", 0)) // -> 0
    println(mapTest.getOrElse("missing key 5", { 1 })) //-> 1
    println(mapTest.getOrPut("missing key 6", { 2 })) // -> 2 // выводим 2 и помещаем в
    println(mapTest) // -> {missing key 6=2}
}

