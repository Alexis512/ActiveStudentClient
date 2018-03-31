package activestudent.com.client.alex.presentation.views.recyclerView.holders

import activestudent.com.client.alex.model.Message
import activestudent.com.client.alex.utils.TimeUtils
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.items_messages.view.*
import org.jetbrains.anko.textColor

/**
 * Created by alex on 12.03.2018.
 */
class LoadMessagesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun bind(items: Message, listener: (Message) -> Unit) {
        val time = TimeUtils()
        itemView.tvTime.text = time.formatData(items.time_state)
        when (items.status) {
            "proc" -> {
                itemView.tvStatus.text = "Модерация"
                itemView.tvStatus.textColor = Color.parseColor("#D95E5E")
            }
            "exec" -> {
                itemView.tvStatus.text = "В исполнении"
                itemView.tvStatus.textColor = Color.parseColor("#F57924")
            }
            "done" -> {
                itemView.tvStatus.text = "Выполнена"
                itemView.tvStatus.textColor = Color.parseColor("#0EB442")
            }
            else -> Log.d("Error", "Ошибка в преобразовании статуса")
        }
        itemView.tvCategoryWork.text = items.categoryWork
        itemView.setOnClickListener({ listener(items) })
    }

}