package activestudent.com.client.alex.presentation.mvp.presenterImpls.student

import activestudent.com.client.alex.presentation.mvp.presenter.student.StudentPresenterRole
import activestudent.com.client.alex.presentation.mvp.presenterImpls.BaseMvpPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.student.StudentRoleView
import activestudent.com.client.alex.utils.PhotoUtils
import javax.inject.Inject

/**
 * Created by alex on 06.02.2018.
 */
class StudentRolePresenterImpl @Inject constructor(private val fileUtils: PhotoUtils)
    : BaseMvpPresenterImpl<StudentRoleView>(), StudentPresenterRole {

    override fun loadPhoto() {
        mView?.loadPhotoPicasso(fileUtils.uriPath())
    }

    override fun addPhotoGallery() = fileUtils.addPhotoGallery()

    override fun pathFile() = fileUtils.getUriPath()

    override fun openCamera() {
        mView?.openCamera()
    }


}