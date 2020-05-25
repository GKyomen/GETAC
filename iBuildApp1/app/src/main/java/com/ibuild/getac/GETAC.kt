package com.ibuild.getac

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class GETAC : Application() {
    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}