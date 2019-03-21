package com.example.mayoufcv.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

/**
 * An extension function to retrieve an instance of LayoutInflater
 *
 */
fun ViewGroup.getLayoutInflater() = LayoutInflater.from(context)