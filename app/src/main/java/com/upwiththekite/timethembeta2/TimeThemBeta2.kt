package com.upwiththekite.timethembeta2

import android.app.Application
import io.realm.Realm

/**
 * Created by yocha on 9/15/17.
 */

class TimeThemBeta2 : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}