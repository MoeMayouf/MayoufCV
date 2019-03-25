package com.example.mayoufcv.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull

/**
 * An extension function to retrieve an instance of LayoutInflater
 *
 */
@NonNull
fun ViewGroup.getLayoutInflater() = context?.let { LayoutInflater.from(it) }