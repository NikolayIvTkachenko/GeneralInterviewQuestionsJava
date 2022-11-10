package QuestionTasks

import javax.print.attribute.IntegerSyntax

fun main() {
    val dModel01 = DModel(10)
    dModel01.valueInt02 = 100

    val dModel02 = DModel()
    dModel01.valueInt02 = 50

    val dModel03 = DModel(10)
    dModel01.valueInt02 = 200

    val testSet = HashSet<DModel>();
    testSet.add(dModel01)
    testSet.add(dModel02)
    testSet.add(dModel03)

    println(testSet)

}


data class DModel(val valueInt01: Int = 5){
    var valueInt02: Int? = null

    override fun toString(): String {
        return "valueInt01 = $valueInt01, valueInt02 = $valueInt02"
    }
}