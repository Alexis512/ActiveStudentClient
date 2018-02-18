package activestudent.com.client.alex.presentation.views.recyclerView.holders

import activestudent.com.client.alex.model.ViolationsItems
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.items_layout.view.*


/**
 * Created by alex on 14.02.2018.
 */
class ViolationsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun bind(item: ViolationsItems, listener: (ViolationsItems) -> Unit) {
        itemView.btn.text = item.violation
        itemView.btn.setOnClickListener({ listener(item) })
    }

}
