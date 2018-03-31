package activestudent.com.client.alex.model.student

import activestudent.com.client.alex.model.Schendule
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiServerSchendule {

    @GET("schedule/{group_id}/{season}")
    fun getSchendule(@Path("group_id") groupId: String, @Path("season") season: String): Call<Schendule>
}