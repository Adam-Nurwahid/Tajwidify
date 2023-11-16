package com.kuliah.pkm.tajwidify

import android.os.Parcel
import android.os.Parcelable

data class DoaDataClass(
    val name: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DoaDataClass> {
        override fun createFromParcel(parcel: Parcel): DoaDataClass {
            return DoaDataClass(parcel)
        }

        override fun newArray(size: Int): Array<DoaDataClass> {
            TODO("Not yet implemented")
        }
    }
}