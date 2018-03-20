package activestudent.com.client.alex.model

import android.os.Parcel
import android.os.Parcelable
import java.sql.Date

/**
 * Created by alex on 18.02.2018.
 */

data class Messages(var _id: String?,
                    var numMessage: String?,
                    var id_stud: String?,
                    var photo: String?,
                    var categoryWork: String?,
                    var location: String?,
                    var time_state: String?,
                    var time_impl: String?,
                    var type_work: String?,
                    var executor: String?,
                    var status: String?,
                    var description: String?) : Parcelable {

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

    companion object CREATOR : Parcelable.Creator<Messages> {
        override fun createFromParcel(parcel: Parcel): Messages {
            return Messages(parcel)
        }

        override fun newArray(size: Int): Array<Messages?> {
            return arrayOfNulls(size)
        }
    }
}
