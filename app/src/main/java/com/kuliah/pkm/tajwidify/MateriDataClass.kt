package com.kuliah.pkm.tajwidify

import android.os.Parcel
import android.os.Parcelable
import org.intellij.lang.annotations.Language

data class MateriDataClass(
    val name: String?,
    val photo: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MateriDataClass> {
        override fun createFromParcel(parcel: Parcel): MateriDataClass {
            return MateriDataClass(parcel)
        }

        override fun newArray(size: Int): Array<MateriDataClass?> {
            return arrayOfNulls(size)
        }
    }
}
