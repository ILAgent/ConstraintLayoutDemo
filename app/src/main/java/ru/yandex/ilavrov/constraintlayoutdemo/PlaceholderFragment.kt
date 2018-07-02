package ru.yandex.ilavrov.constraintlayoutdemo

import android.os.Bundle
import android.support.constraint.Placeholder
import android.support.v4.app.Fragment
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class PlaceholderFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.placeholder, container, false).apply {

                val image = findViewById<ImageView>(R.id.image_view)
                val placeholder = findViewById<Placeholder>(R.id.place2)

                image.setOnClickListener {

                    TransitionManager.beginDelayedTransition(this as ViewGroup)

                    placeholder.setContentId(R.id.image_view)
                    image.layoutParams.apply {
                        width = placeholder.width
                        height = placeholder.height
                    }
                }
            }


}