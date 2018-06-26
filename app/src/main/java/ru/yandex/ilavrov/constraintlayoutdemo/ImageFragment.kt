package ru.yandex.ilavrov.constraintlayoutdemo

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.constraint.ConstraintSet.BOTTOM
import android.support.constraint.ConstraintSet.TOP
import android.support.v4.app.Fragment
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.TextView

class ImageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
                .also { view ->
                    val description = view.findViewById<TextView>(R.id.description)
                    view.findViewById<TextView>(R.id.expand).setOnClickListener {
                        //                        val set = TransitionSet().apply {
//                            addTransition(Fade())
//                            addTransition(ChangeBounds())
//                        }


                        TransitionManager.beginDelayedTransition(view as ViewGroup)
                        description.textSize = 30f
//                        description.visibility = when (description.visibility) {
//                            VISIBLE -> GONE
//                            else -> VISIBLE
//                        }
//                        (view as ConstraintLayout).changeConstraints {
//                            connect(R.id.description,BOTTOM,R.id.image, BOTTOM)
//                            connect(R.id.expand,TOP,R.id.image, BOTTOM)
//                        }
                    }
                }
    }
}

fun ConstraintLayout.changeConstraints(change: ConstraintSet.() -> Unit) {
    val constraintSet = ConstraintSet()
    constraintSet.clone(this)
    change(constraintSet)
    constraintSet.applyTo(this)
}
