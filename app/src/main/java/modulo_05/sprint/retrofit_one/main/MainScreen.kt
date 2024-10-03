package modulo_05.sprint.retrofit_one.main

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(viewModel: DisneyViewModel) {
    val state = viewModel.state
    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
            items(state.characters) { character ->
                Log.d("MainScreen", "character: $character")
                Text(text = character.name)
               // DisneyCharacterCard(character = character)
            }
        }
    }
}
// crea  DisneyCharacterCard(character = character)
@Composable
fun DisneyCharacterCard(character: DisneyCharacter) {
    Text(text = character.imageUrl)
}