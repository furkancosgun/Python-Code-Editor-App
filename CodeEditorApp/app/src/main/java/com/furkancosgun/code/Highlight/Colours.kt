package com.furkancosgun.code

import android.graphics.Color
import android.text.style.ForegroundColorSpan

interface Colours {
    /**
     * Get a colour for a given type
     *
     * eg colourMap = ("keyword" to "magenta", "annotation" to "red", "constant" to "#orange", "comment" to "grey", "class" to "green", "import" to "blue")
     *
     * @param type String eg "keyword"
     * @return ForegroundColorSpan ForegroundColorSpan(Color.parseColor(colourMap[type])) -> "magenta" if type="keyword"
     */
    fun getColour(type: String): ForegroundColorSpan
}

class ColoursDark : Colours {
    override fun getColour(type: String): ForegroundColorSpan {
        val colourMap = mapOf(
            "keyword" to "#C077DF",
            "annotation" to "#D66C75",
            "constant" to "#ff8f00",
            "comment" to "#555862",
            "class" to "#9DC376",
            "import" to "#68B6C2"
        )
        return ForegroundColorSpan(Color.parseColor(colourMap[type]))
    }
}

class ColoursLight : Colours {
    override fun getColour(type: String): ForegroundColorSpan {
        val colourMap = mapOf(
            "keyword" to "#9E25A6",
            "annotation" to "#BF1243",
            "constant" to "#ff8f00",
            "comment" to "#383A42",
            "class" to "#5DA14C",
            "import" to "#5077F4"
        )
        return ForegroundColorSpan(Color.parseColor(colourMap[type]))
    }
}