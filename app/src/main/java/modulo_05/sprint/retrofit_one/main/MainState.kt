package modulo_05.sprint.retrofit_one.main

data class MainState(
    val isLoading: Boolean = false,
    val characters: List<DisneyCharacter> = emptyList(),
) {
}