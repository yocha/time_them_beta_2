package com.upwiththekite.timethembeta2

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

/**
 * Created by yocha on 9/15/17.
 */

open class Event : RealmObject() {
    @PrimaryKey
    private var id = UUID.randomUUID().toString()
    var name: String = ""

    fun getId() : String {
        return id
    }

    override fun toString(): String {
        return "${name}"
    }
}