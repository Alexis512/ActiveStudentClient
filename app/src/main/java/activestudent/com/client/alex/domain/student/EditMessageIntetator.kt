package activestudent.com.client.alex.domain.student

import activestudent.com.client.alex.model.student.ApiRequestServerStudent
import activestudent.com.client.alex.presentation.mvp.presenterImpls.student.EditMessagePresenterImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by alex on 19.03.2018.
 */
class EditMessageIntetator @Inject constructor(val retrofit: Retrofit) {

    private var editPresenter: EditMessagePresenterImpl? = null
    fun setPresenterListener(ePres: EditMessagePresenterImpl) {
        editPresenter = ePres
    }

    fun updateMessage(id: String, location: String?, description: String?) {
        val editMessage = retrofit.create(ApiRequestServerStudent::class.java)
        editMessage.editMessage(id, location!!, description!!)
                .enqueue(object : Callback<Void> {
                    override fun onFailure(call: Call<Void>?, t: Throwable?) {
                        editPresenter?.onFailure()
                    }

                    override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                        editPresenter?.onSuccess()
                    }

                })
    }
}