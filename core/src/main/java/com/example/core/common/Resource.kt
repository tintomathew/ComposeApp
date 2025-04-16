/*
 * *
 *  * Created by tinto on 16/11/2022, 11:09
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 16/11/2022, 10:39
 *
 */

package com.example.core.di.common

// A generic class that contains data and status about loading this data.
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}