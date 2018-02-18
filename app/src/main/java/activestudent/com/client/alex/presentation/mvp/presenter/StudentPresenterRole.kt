package activestudent.com.client.alex.presentation.mvp.presenter

import activestudent.com.client.alex.presentation.mvp.view.StudentRoleView
import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Created by alex on 06.02.2018.
 */
interface StudentPresenterRole : BaseMvpPresenter<StudentRoleView> {
    fun openCamera()
    fun pathFile() : Uri?
    fun addPhotoGallery() : Intent
    fun loadPhoto()
}