package activestudent.com.client.alex.model.student

import activestudent.com.client.alex.model.Message
import retrofit2.Call
import retrofit2.http.*

interface ApiRequestServerStudent {

    @POST("api/v1/regMessage")
    fun addMessage(@Body message: Message): Call<Void>

    @GET("/api/v1/getMsgUser/{id_stud}")
    fun allMessegesStudent(@Path("id_stud") idStud: String): Call<ArrayList<Message>>

    @FormUrlEncoded
    @PUT("/api/v1/updateStatusProc")
    fun changeStatusProc(@Field("id") id: String): Call<Void>

    @FormUrlEncoded
    @PUT("/api/v1/editMessage")
    fun editMessage(@Field("id") id: String, @Field("location") location: String, @Field("description") description: String): Call<Void>

    @DELETE("/api/v1/deleteMessage/{id}")
    fun deleteMessage(@Path("id") id: String?): Call<Void>
}