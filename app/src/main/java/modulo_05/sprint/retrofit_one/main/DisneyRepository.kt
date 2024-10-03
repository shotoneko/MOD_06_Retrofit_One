package modulo_05.sprint.retrofit_one.main

import android.util.Log

class DisneyRepository ( private val api: DisneyApi) {

    suspend fun getCharacters() :Result<List<DisneyCharacter>> {
        return  try {
            val response = api.getCharacters().data
            Result.success(
                response.map {
                    Log.d("rRRRRRRdd", it.name)
                    DisneyCharacter(
                        name = it.name,
                        imageUrl = it.imageUrl
                    )
                }
            )

        } catch (e: Exception){
            println("Error: ${e.message}")
            Result.failure(e)
        }
    }
    private fun convert(data: Data): DisneyCharacter{
        return DisneyCharacter(
            name = data.name,
            imageUrl = data.imageUrl
        )
    }
}



