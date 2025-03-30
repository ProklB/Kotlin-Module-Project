import java.util.Scanner

class Menu(private val name: String, private val items: MutableList<out Any>) {
    private val scanner = Scanner(System.`in`)

    fun output(): Int {
        while (true) {
            println(name)
            println("0. Создать")
            println("1. Выход")
            items.forEachIndexed { index, item ->
                //println("${index + 2}. ${item.name}")
                when (item) {
                    is Archive -> println("${index + 2}. ${item.name}")
                    is Note -> println("${index + 2}. ${item.name}")
                    else -> println("${index + 2}. $item")
                }
            }

            print("Выберите пункт меню: ")
            val input = scanner.nextLine()

            try {
                val choice = input.toInt()
                when {
                    choice < 0 -> println("Число должно быть положительным")
                    choice >= (items.size+2) -> println("Пункта с номером $choice не существует")
                    else -> {
                        return choice

                    }
                }
            } catch (e: NumberFormatException) {
                println("Необходимо ввести число")
            }
        }
    }
}