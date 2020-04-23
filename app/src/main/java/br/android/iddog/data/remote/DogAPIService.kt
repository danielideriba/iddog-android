package br.android.iddog.data.remote

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DogAPIService {
    @GET("/breeds/list/all")
    fun getAllBreeds(): Call<Breeds>

    @GET("/breed/{dogBreed}]/images/random")
    fun getBreed(@Path("dogBreed") dogBreed: String): Call<Breed>

    @GET("/breed/hound/list")
    fun getSubBreed(): Call<SubBreed>

    @GET("/api/breed/{dogBreed}/images/random")
    fun getDogBreedImage(@Path("dogBreed") dogBreed: String): Call<BreedImage>
}