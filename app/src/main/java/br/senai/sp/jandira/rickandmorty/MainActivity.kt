package br.senai.sp.jandira.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.rickandmorty.screens.CharacterDetails
import br.senai.sp.jandira.rickandmorty.screens.ListAllCharacters
import br.senai.sp.jandira.rickandmorty.ui.theme.RickAndMortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickAndMortyTheme {

                val controleDeNavegacao =  rememberNavController()
                NavHost(navController = controleDeNavegacao,
                    startDestination = "ListAllCharacters"
                ){
                    composable(route = "listAllCharacters"){ ListAllCharacters(controleDeNavegacao)}
                    composable(route = "CharacterDetails"){ CharacterDetails(controleDeNavegacao)}
                }
            }
        }
    }
}

