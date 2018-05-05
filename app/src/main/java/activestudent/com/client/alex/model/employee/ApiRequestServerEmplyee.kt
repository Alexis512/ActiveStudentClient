package activestudent.com.client.alex.model.employee

import activestudent.com.client.alex.model.Message
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by alex on 21.03.2018.
 */
interface ApiRequestServerEmplyee {

    @GET("/api/v1/getMessage/{type_work}")
    fun getMessagesEmployee(@Path("type_work") typeWork: String): Call<ArrayList<Message>>

    @PUT("/api/v1/updateStatusDone")
    @FormUrlEncoded
    fun updateStatusDone(@Field("id") id: String, @Field("time_impl") timeImpl: String,
                         @Field("executor") executor: String) : Call<Void>
}