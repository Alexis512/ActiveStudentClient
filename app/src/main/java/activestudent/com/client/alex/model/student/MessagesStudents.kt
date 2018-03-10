package activestudent.com.client.alex.model.student

import activestudent.com.client.alex.model.Messages
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by alex on 20.02.2018.
 */
interface MessagesStudents {

    @POST("api/v1/regMessage")
    fun addMessage(@Body message: Messages): Call<Void>

    @GET("/api/v1/getMsgUser/{id_stud}")
    fun allMessegesStudent(@Path("id_stud") idStud: String): Call<ArrayList<Messages>>

    @FormUrlEncoded
    @PUT("/api/v1/updateStatusProc")
    fun changeStatusProc(@Field("id") id: String): Call<Void>
}