package activestudent.com.client.alex.presentation.views.recyclerView.adapters

import activestudent.com.client.alex.R
import activestudent.com.client.alex.model.Messages
import activestudent.com.client.alex.presentation.views.recyclerView.holders.MyMessagesHolder
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by alex on 12.03.2018.
 */
class MyMessagesAdapter(val messages: ArrayList<Messages>, val listener: (Messages) -> Unit) : RecyclerView.Adapter<MyMessagesHolder>() {

    override fun onBindViewHolder(holder: MyMessagesHolder, position: Int) = holder.bind(messages[position], listener)

    override fun getItemCount() = messages.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyMessagesHolder = MyMessagesHolder(LayoutInflater
            .from(parent?.context)
            .inflate(R.layout.items_messages, parent, false))
}