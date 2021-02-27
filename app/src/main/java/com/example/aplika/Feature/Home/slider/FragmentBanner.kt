package com.example.aplika.Feature.Home.slider

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aplika.Common.BaseFragment
import com.example.aplika.Common.EXTRA_KEY_DATA
import com.example.aplika.CoustomeView.NikeImageView
import com.example.aplika.Data.model.Banner
import com.example.aplika.R
import com.example.aplika.Servicee.ImageLoadinServices.ImageLoadingService
import kotlinx.android.synthetic.main.fragment_banner.*
import org.koin.android.ext.android.inject
import java.lang.IllegalStateException

class FragmentBanner :Fragment() {


    val imageloding:ImageLoadingService by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_banner,container,false) as NikeImageView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val banner=requireArguments().getParcelable<Banner>(EXTRA_KEY_DATA)

            ?:throw IllegalStateException("banner can not be null")

        imageloding.load(NikeImageView    ,banner.image )
    }

    companion object{
        fun newInstance(banner: Banner):FragmentBanner{
            return  FragmentBanner().apply {
                arguments=Bundle().apply {
                    putParcelable(EXTRA_KEY_DATA,banner)
                }
            }
        }
    }

}