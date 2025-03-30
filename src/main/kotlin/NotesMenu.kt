import java.util.Scanner

class NotesMenu(private val archive: Archive) {
    private val scanner = Scanner(System.`in`)

    fun output() {
        var command: Int
        while (true) {
            command = Menu("Список заметок архива ${archive.name}", archive.notes).output()
            when (command) {
                0 -> createNote()
                1 -> return
                else -> {
                    outputNote(archive.notes[command-2])
                }
            }
        }
    }

    private fun createNote() {
        println("Введите название заметки:")
        val name = checkEmpty("Название не может быть пустым:")

        println("Введите текст заметки:")
        val text = checkEmpty("Текст не может быть пустым:")

        archive.addNote(Note(name, text))
        println("Заметка '$name' создана!")
    }

    private fun checkEmpty(errorMessage: String): String {
        while (true) {
            val input = scanner.nextLine().trim()
            if (input.isNotEmpty()) return input
            println(errorMessage)
        }
    }

    private fun outputNote(note: Note) {
        println("\n=== ${note.name} ===")
        println(note.text)
        println("\nНажмите Enter чтобы вернуться...")
        scanner.nextLine()
    }
}