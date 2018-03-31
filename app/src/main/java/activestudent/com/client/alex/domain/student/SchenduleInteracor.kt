package activestudent.com.client.alex.domain.student

import activestudent.com.client.alex.domain.SchenduleLisctenerInteractor
import activestudent.com.client.alex.model.Schendule
import activestudent.com.client.alex.model.student.ApiServerSchendule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by alex on 28.03.2018.
 */
class SchenduleInteracor @Inject constructor(@Named("RetrofitForSchendule") private var retrofitSchendule: Retrofit) {

    private var presenterListener: SchenduleLisctenerInteractor? = null

    fun setPresenterListener(pres: SchenduleLisctenerInteractor) {
        presenterListener = pres
    }

    fun getSchendule(groupId: String, season: String) {
        var lessons = retrofitSchendule.create(ApiServerSchendule::class.java)
        lessons.getSchendule(groupId, season)
                .enqueue(object : Callback<Schendule> {
                    override fun onFailure(call: Call<Schendule>?, t: Throwable?) {
                        presenterListener?.onFailureLoadSchendule()
                    }

                    override fun onResponse(call: Call<Schendule>?, response: Response<Schendule>?) {
                        presenterListener?.onSuccessLoadSchendule(response?.body()!!)
                    }
                })
    }
}