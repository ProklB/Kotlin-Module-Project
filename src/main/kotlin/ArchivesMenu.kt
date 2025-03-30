import java.util.Scanner

class ArchivesMenu{
    private val archives = mutableListOf<Archive>()
    private val scanner = Scanner(System.`in`)


    fun output() {
        var command: Int
        while (true) {
            command = Menu("Список архивов:", archives).output()
            when (command) {
                0 -> createArchive()
                1 -> {
                    scanner.close()
                    return
                }
                else -> {
                    NotesMenu(archives[command-2]).output()
                }
            }
        }
    }

    private fun createArchive() {
        println("Введите название архива:")

        while (true) {
            val name = scanner.nextLine().trim()
            when {
                name.isEmpty() -> println("Название не может быть пустым. Введите снова:")
                archives.any { it.name == name } -> println("Архив с таким именем уже существует. Введите другое имя:")
                else -> {
                    archives.add(Archive(name))
                    println("Архив '$name' успешно создан!")
                    return
                }
            }
        }
    }
}