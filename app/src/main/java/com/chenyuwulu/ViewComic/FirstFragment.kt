package com.chenyuwulu.ViewComic

import androidx.fragment.app.Fragment
import android.os.Bundle
import androidx.annotation.Nullable
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View


class FirstFragment : Fragment() {
    @Nullable
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.we_sub_fragment_first, container, false)
    }
}