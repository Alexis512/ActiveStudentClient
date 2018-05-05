package activestudent.com.client.alex.model

import android.os.Parcel
import android.os.Parcelable


data class Message(var _id: String? = null,
                   var numMessage: String? = null,
                   var id_stud: String? = null,
                   var photo: String? = "",
                   var categoryWork: String? = null,
                   var location: String? = null,
                   var time_state: String? = null,
                   var time_impl: String? = "",
                   var type_work: String? = null,
                   var executor: String? = "",
                   var status: String? = null,
                   var description: String? = null) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(numMessage)
        parcel.writeString(id_stud)
        parcel.writeString(photo)
        parcel.writeString(categoryWork)
        parcel.writeString(location)
        parcel.writeString(time_state)
        parcel.writeString(time_impl)
        parcel.writeString(type_work)
        parcel.writeString(executor)
        parcel.writeString(status)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Message> {
        override fun createFromParcel(parcel: Parcel): Message {
            return Message(parcel)
        }

        override fun newArray(size: Int): Array<Message?> {
            return arrayOfNulls(size)
        }
    }

}
