package com.example.feature_news.initialscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.core.di.StringResource
import com.example.core.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InitialViewModel @Inject constructor(
   val stringResource: StringResource
) : ViewModel() {
   fun getImageUrl(): String { return stringResource.get(R.string.image_url)
   }
}