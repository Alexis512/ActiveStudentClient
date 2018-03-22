package activestudent.com.client.alex.presentation.views.employee

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_account_employee.*
import kotlinx.android.synthetic.main.my_toolbar.*
import org.jetbrains.anko.startActivity

class AccountEmployeeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_employee)
        setSupportActionBar(my_toolbar)
        App.component.inject(this)
        setOnClickListeners()
    }

    fun setOnClickListeners() {
        btnUntreatedMsg.setOnClickListener({ })
        btnAllMsg.setOnClickListener({ startActivity<AllMsgEmployeeActivity>() })
    }


}
