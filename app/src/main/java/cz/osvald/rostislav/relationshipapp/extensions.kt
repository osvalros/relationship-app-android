package cz.osvald.rostislav.relationshipapp

import androidx.fragment.app.Fragment

val Any.LOG_TAG: String
    get() {
        val tag = javaClass.simpleName
        return if (tag.length <= 23) tag else tag.substring(0, 23)
    }

val Fragment.FRAGMENT_LOG_TAG: String
    get() = LOG_TAG
