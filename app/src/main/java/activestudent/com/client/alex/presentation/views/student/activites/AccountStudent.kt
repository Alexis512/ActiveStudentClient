package activestudent.com.client.alex.presentation.views.student.activites

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import activestudent.com.client.alex.R.id.callDispatchService
import activestudent.com.client.alex.presentation.mvp.presenter.student.AccountPresenter
import activestudent.com.client.alex.presentation.mvp.presenterImpls.student.AccountPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.student.AccountView
import activestudent.com.client.alex.presentation.views.BaseActivity
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat.checkSelfPermission
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.my_toolbar.*
import org.jetbrains.anko.makeCall
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class AccountStudent : BaseActivity<AccountView, AccountPresenter>(), AccountView {


    override fun onCreate(savedInstanceState: Bundle?) {
        App.component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        setSupportActionBar(my_toolbar)
        setListener()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            callDispatchService -> {
                onCallPermission()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun callDispatch() {
        makeCall("+788332343212")
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    onCallPermission()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun setListener() {
        newMsg.setOnClickListener({ startActivity<ViolationsActivity>() })
        myMsg.setOnClickListener({ startActivity<MessagesActivity>() })
        btnSchendule.setOnClickListener({ startActivity<SchenduleActivity>() })
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun onCallPermission() {
        if (checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_DENIED) {
            mvpPresenter.onCallDispatchService()
        } else requestPermissions(arrayOf(android.Manifest.permission.CALL_PHONE), 1)
    }


}
