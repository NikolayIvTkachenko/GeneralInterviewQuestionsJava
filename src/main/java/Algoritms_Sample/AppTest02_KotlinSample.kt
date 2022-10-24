package Algoritms_Sample

fun main() {

}


interface figure {
    fun square(): Int
}

data class SampleTest(
    var width: Int,
    var height: Int
) : figure {
    override fun square(): Int {
        return width * height
    }
}