package br.android.iddog.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DogAPIService {
    @GET("/breeds/list/all")
    fun getAllBreeds(): Call<Breeds>

    @GET("/breed/hound/images")
    fun getBreed(): Call<Breed>

    @GET("/breed/hound/list")
    fun getSubBreed(): Call<SubBreed>

    @GET("/api/breed/{dogname}/images/random")
    fun getDogImage(@Path("dogname") dogname: String): Call<BreedImage>
}