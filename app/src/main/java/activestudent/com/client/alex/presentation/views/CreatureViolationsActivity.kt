package activestudent.com.client.alex.presentation.views

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import activestudent.com.client.alex.model.Messages
import activestudent.com.client.alex.presentation.mvp.presenterImpl.CreatureViolationsPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.CreatureViolationsView
import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ArrayAdapter
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner
import kotlinx.android.synthetic.main.activity_creature_violations.*
import kotlinx.android.synthetic.main.my_toolbar.*
import org.jetbrains.anko.startActivity
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class CreatureViolationsActivity : AppCompatActivity(), CreatureViolationsView {
    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }


    @Inject
    lateinit var messages: Messages
    @Inject
    lateinit var presenter: CreatureViolationsPresenterImpl

    @SuppressLint("ResourceAsColor")
    fun initSpinnerRoom() {
        val adapter = ArrayAdapter.createFromResource(this, R.array.typeRoom,  android.R.layout.simple_dropdown_item_1line)
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spTypeRoom.setAdapter(adapter)
        val numAdapter = ArrayAdapter.createFromResource(this, R.array.numRoom,  android.R.layout.simple_dropdown_item_1line)
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        numHostel.setAdapter(numAdapter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creature_violations)
        initSpinnerRoom()
        App.component.inject(this)
        presenter.attachView(this)
        setSupportActionBar(my_toolbar)
        setListener()
    }

    fun setListener() {
        btnSend.setOnClickListener({ onClickBtnSend() })
    }

    fun onClickBtnSend() {
        var nRoom = numRoom.text
        var nHostel = numHostel.text
        var type = spTypeRoom.text
        var desk = description.text
        Log.d("asd", "sd")
      /*  //  messages.location = "Общежитие №" + edHostel.text + " , комната №" + edRoom.text
        messages.time_state = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(Date())
        messages.id_stud = presenter.getStudId()
        presenter.sendMessage()*/
      /*  startActivity<AccountStudent>()*/
    }
}
