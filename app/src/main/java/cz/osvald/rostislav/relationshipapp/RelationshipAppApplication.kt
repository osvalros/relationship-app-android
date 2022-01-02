package cz.osvald.rostislav.relationshipapp

import android.app.Application
import android.content.Context

class RelationshipAppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

    companion object {
        lateinit var appContext: Context
    }
}