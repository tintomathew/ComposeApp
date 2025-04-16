package com.example.core.di

import android.content.Context
import androidx.annotation.StringRes
import javax.inject.Inject

interface StringResource {
    fun get(@StringRes id:Int): String
    fun get(@StringRes id: Int, vararg formatArgs: Any) : String
}

class StringResourceImpl @Inject constructor(private val context: Context): StringResource {
    override fun get(@StringRes id: Int): String = context.getString(id)


    override fun get(@StringRes id: Int, vararg formatArgs: Any): String = context.getString(id, *formatArgs)

}