package com.geektechkb.android7.`interface`

import com.geektechkb.android7.data.TextModel

interface OnItemTextListener {
    fun onClick(model: TextModel)

    fun onLongClick(model: TextModel)
}