package com.example.aplika.Common

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aplika.R
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.progressbar.view.*
import java.lang.IllegalStateException

abstract class BaseFragment : Fragment(), BaseView {
    // get root All Fragment for add ProgressBar to rootview
    override val rootView: CoordinatorLayout?
        get() = view as CoordinatorLayout

    override val viewContext: Context?
        get() = context
}

abstract class BaseActivity : AppCompatActivity(), BaseView {

    // get root All Activity for add ProgressBar to rootview
    override val rootView: CoordinatorLayout?
        get()  {

            val viewGroup= window.decorView.findViewById(android.R.id.content) as ViewGroup
            if(viewGroup !is CoordinatorLayout){

                viewGroup.children.forEach {

                    if (it is CoordinatorLayout)
                        return it
                }

                throw IllegalStateException("RootView must be instance of CoordinatorLayout")
            }else {

                return viewGroup

            }

        }

    override val viewContext: Context?
        get() = this
}

interface BaseView {

    val rootView: CoordinatorLayout?
    val viewContext:Context?

    // add and show progressBar to all View
    fun showProgress(show:Boolean){

        viewContext?.let {context->
            rootView?.let {

                var loadingView=it.findViewById<View>(R.id.loadingView)

                if(show && loadingView==null){

                    loadingView=LayoutInflater.from(context).inflate(R.layout.progressbar,it,false)
                    it.addView(loadingView)
                }

                loadingView?.visibility=if (show) View.VISIBLE else View.GONE


            }
        }

    }


}

abstract class BaseViewModel : ViewModel() {

    val compositeDisposable = CompositeDisposable()
    val progressBar=MutableLiveData<Boolean>()

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()

    }

}