package QuestionTasks


fun main() {

    val class01 = TestClass()
    class01.test()

    //Result output -> call method test() -> testInternal() call property testInternal -> :
    //function test
    //property test internal

}


class TestClass {

    val testInternal = {
        println("property test internal")
    }

    val test = {
        println("property test")
        test()
    }

    fun test(){
        println("function test")
        testInternal()
        fun testInternal(){
            println("Internal function test")
        }
    }

    companion object {
        fun test() {
            println("Companion test")
        }

        fun testInternal(){
            println("Companion test internal")
        }

    }
}