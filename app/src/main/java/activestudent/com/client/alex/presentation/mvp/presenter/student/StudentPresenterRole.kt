package activestudent.com.client.alex.presentation.mvp.presenter.student

import activestudent.com.client.alex.presentation.mvp.presenter.BaseMvpPresenter
import activestudent.com.client.alex.presentation.mvp.view.student.StudentRoleView
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