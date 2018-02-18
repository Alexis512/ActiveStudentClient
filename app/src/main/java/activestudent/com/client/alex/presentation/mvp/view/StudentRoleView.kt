package activestudent.com.client.alex.presentation.mvp.view

import android.content.Context
import android.net.Uri

/**
 * Created by alex on 06.02.2018.
 */
interface StudentRoleView : BaseMvpView {

    fun openCamera()
    fun loadPhotoPicasso(uri: Uri)
    fun getContext() : Context
}