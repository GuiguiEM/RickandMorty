package br.senai.sp.jandira.rickandmorty.service

import br.senai.sp.jandira.rickandmorty.model.Episode
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EpisodeService {

    interface EpisodeService {

        @GET("episode/{id}")
        fun getEpisodeById(@Path("id") id: Int): Call<Episode>

        @GET("episode")
        fun getAllEpisodes(): Call<List<Episode>>
    }
}