package activestudent.com.client.alex.model.student

import activestudent.com.client.alex.model.Messages
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by alex on 20.02.2018.
 */
interface MessagesStudents {

    @POST("api/v1/regMessage")
    fun addMessage(@Body message: Messages): Call<Void>

    @GET("/api/v1/getMsgUser/{id_stud}")
    fun allMessegesStudent(@Path("id_stud") idStud: String): Call<ArrayList<Messages>>
}