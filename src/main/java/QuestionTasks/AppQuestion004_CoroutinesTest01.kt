package QuestionTasks

import kotlinx.coroutines.*
import kotlinx.coroutines.NonCancellable.join
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.coroutines.CoroutineContext


val scope = CoroutineScope(Dispatchers.Default + SupervisorJob())
var i = 0

val mutex = Mutex()

//первая версия - нет синхронизации
//fun main() {
//
//    repeat(100000){
//        increase()
//    }
//    println(i)
//
//}


//Вторая версия с синхронизацтей -> выдает 100000 всегда
suspend fun main() {

    val jobs = mutableListOf<Job>()

    repeat(100000){
        jobs.add(increase())
    }
    jobs.joinAll()

    println(i)

}


//Вторая версия с дополнительным мутексом
fun increase() = scope.launch {// -> компилируется, выполняется, не корректне значение => 87549 и другие
    mutex.withLock {
        i++
    }
}

//Исходная версия
//fun increase() = scope.launch { // -> компилируется, выполняется, не корректне значение => 96824 и другие
//    //синхронизации не происходит
//    synchronized(this){
//        i++
//    }
//}
