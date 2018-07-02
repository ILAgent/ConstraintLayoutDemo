package ru.yandex.ilavrov.constraintlayoutdemo

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.constraint.ConstraintSet.PARENT_ID
import android.support.v4.app.Fragment
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ImageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
                .also { view ->
                    val description = view.findViewById<TextView>(R.id.description)
                    //view.findViewById<TextView>(R.id.expand).setOnClickListener {
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
                    // }
                }
    }
}

fun ConstraintLayout.modify(
        change: ConstraintSet.() -> Unit
) {
    val constraintSet = ConstraintSet()
    constraintSet.clone(this)
    change(constraintSet)
    constraintSet.applyTo(this)
}

fun demo() {
    val constraintLayout: ConstraintLayout = ConstraintLayout(null)


    TransitionManager.beginDelayedTransition(constraintLayout)
    constraintLayout.modify {
        connect(
                R.id.image_view,
                ConstraintSet.TOP,
                PARENT_ID,
                ConstraintSet.TOP)
    }

    val constraintSet = ConstraintSet()
    constraintSet.clone(constraintLayout)
    change(constraintSet)
    constraintSet.applyTo(constraintLayout)
}

fun change(constraintSet: ConstraintSet) {




    constraintSet.clear(
            R.id.image_view,   //id
            ConstraintSet.TOP) //side

    constraintSet.connect(
            R.id.image_view,    // startId
            ConstraintSet.TOP,  // startSide
            PARENT_ID,          // endId
            ConstraintSet.TOP,  // endSide
            16)          // margin
    //........


}