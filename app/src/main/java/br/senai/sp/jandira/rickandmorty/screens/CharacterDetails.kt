package br.senai.sp.jandira.rickandmorty.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.rickandmorty.model.Character
import br.senai.sp.jandira.rickandmorty.model.Episode
import br.senai.sp.jandira.rickandmorty.service.RetrofitFactory
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun CharacterDetails(controleDeNavegacao: NavHostController){

    var id by remember{
        mutableStateOf("")
    }
    var character by remember{
        mutableStateOf(Character())
    }

    //var episodeList by remember {
        //mutableStateOf(listOf<Episode>())
    //}

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(modifier = Modifier.padding(16.dp)
        ) {

            val callCharacter = RetrofitFactory()
                .getCharacterService()
                .getCharacterById(id.toInt())

            callCharacter.enqueue(object : Callback<Character> {
                override fun onResponse(p0: Call<Character>, response: Response<Character>) {
                    character = response.body()!!
                }

                override fun onFailure(p0: Call<Character>, p1: Throwable) {
                }
            })

            Spacer(modifier = Modifier.height(32.dp))
            Card(
                modifier = Modifier
                    .size(100.dp)
            ) {
                AsyncImage(model = character.image,
                    contentDescription = ""
                )
            }
            Text(text = "Name: ${character.name}")
            Text(text = "Specie: ${character.species}")
            Text(text = "Origin: ${character.origin.name}")
            Text(text = "Location: ${character.location.name}")
            Text(text = "Stats: ${character.status}")
            Text(text = "Genre: ${character.gender}")
            Text(text = "Type: ${character.type}")
            Text(text = "Episodes: ${character.episode.size}")

            //LazyColumn {
                //items(episodeList){ episode ->
                //episodeList(episode)

            //}
        }
    }
}

@Preview
@Composable
private fun CharacterDetailsPreview(){
    //CharacterDetails()
}