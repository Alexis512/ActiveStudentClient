package activestudent.com.client.alex.presentation.views.student.activites

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import activestudent.com.client.alex.presentation.mvp.presenterImpls.student.StudentRolePresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.student.StudentRoleView
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_student.*
import javax.inject.Inject

class StudentRoleActivity : AppCompatActivity(), StudentRoleView, ActivityCompat.OnRequestPermissionsResultCallback {

    override fun getContext() = this

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            /*Сделать действия при разрешение*/
    }

    @Inject
    lateinit var sPresenter: StudentRolePresenterImpl


    override fun openCamera() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, sPresenter.pathFile())
            startActivityForResult(intent, 1)
        } else ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.CAMERA), 1)
    }

    override fun loadPhotoPicasso(uri : Uri) {
        Picasso.with(this)
                .load(uri)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(imgPhoto)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        App.component.inject(this)
        setListener()
        sPresenter.attachView(this)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
            sendBroadcast(sPresenter.addPhotoGallery())
            sPresenter.loadPhoto()
    }

    private fun setListener() {
        btnMakePhoto.setOnClickListener({
            sPresenter.openCamera()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        sPresenter.detachView()
    }
}
