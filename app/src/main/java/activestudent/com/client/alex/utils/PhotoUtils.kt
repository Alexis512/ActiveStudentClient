package activestudent.com.client.alex.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.support.v4.content.FileProvider
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 * Created by alex on 09.02.2018.
 */
class PhotoUtils @Inject constructor(private val context: Context){

    var pathFile: String? = null

    private fun createFile(): File? {
        var fileName: String = "ACTSTD_" + SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(Date()) + "_"
        var fileDir: File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        var file = File.createTempFile(fileName, ".jpg", fileDir)
        pathFile = file.absolutePath
        return file
    }

    fun getUriPath() = FileProvider.getUriForFile(context, "com.client.alex.utils", createFile())

    fun uriPath(): Uri {
        var file = File(pathFile)
        return Uri.fromFile(file)
    }

    fun addPhotoGallery(): Intent {
        var intent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
        intent.setData(uriPath())
        return intent
    }
}