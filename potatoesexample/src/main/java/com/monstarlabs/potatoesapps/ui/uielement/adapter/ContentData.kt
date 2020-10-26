package com.monstarlabs.potatoesapps.ui.uielement.adapter

import android.os.Parcel
import android.os.Parcelable

 class ContentData(
     private var projectName:String,
     private var projectID: Int
 )  {
    fun getProjectName():String{
        return projectName
    }
     fun getProjectID():Int{
         return projectID
     }
}