package activestudent.com.client.alex.model

import android.content.Context
import android.content.Context.MODE_PRIVATE
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by alex on 11.02.2018.
 */


class UserData @Inject constructor(private val context: Context) {

    fun saveUserdata(name: String, value: String) {
        val sPref = context.getSharedPreferences("UserData", MODE_PRIVATE)
        val ed = sPref.edit()
        ed.putString(name, value)
        ed.commit()
    }

    fun loadUserData() : String {
        val sPref = context.getSharedPreferences("UserData", MODE_PRIVATE)
        return sPref.getString("id", "")
    }
}