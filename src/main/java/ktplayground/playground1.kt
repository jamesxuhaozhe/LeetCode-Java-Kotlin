package ktplayground

//type inference

val authors = listOf("Dmitry", "Svetlana")

val readers: MutableList<String> = mutableListOf()

val readers1 = mutableListOf<String>()



val letters = ('a'..'z').toList()

interface List<T> {
    operator fun get(index: Int): T
}

interface Comparable<T> {
    fun compareTo(other: T): Int
}

class String : Comparable<String> {
    override fun compareTo(other: String): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }
}

