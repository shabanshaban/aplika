package com.example.aplika.Feature.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplika.Common.BaseFragment
import com.example.aplika.Data.model.Product
import com.example.aplika.Feature.Home.slider.BannerSliderAdapter
import com.example.aplika.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class HomeFragment :BaseFragment() {

    val homeViewModel: HomeViewModel by viewModel()
    val adapter:    ProductAdapter  by inject()

    lateinit var vieww:View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {






        return inflater.inflate(R.layout.fragment_home,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showProgressBar()
        getProduct()
        getBanner()

    }
    fun getBanner(){
    homeViewModel.Banner.observe(viewLifecycleOwner){

        val adapter=BannerSliderAdapter(this,it)

        bannerViewPagerSlider.adapter=adapter
        dots_indicator.setViewPager2(bannerViewPagerSlider)


        Timber.e(it.toString())
    }
}
    fun getProduct(){
        homeViewModel.product.observe(viewLifecycleOwner){

             adapter.products= it as ArrayList<Product>
            if (RvLatestProduct.layoutManager==null)
                RvLatestProduct.hasFixedSize()
            RvLatestProduct.layoutManager=
                GridLayoutManager( requireActivity(),2)
            RvLatestProduct.adapter=adapter




            Timber.e(it.toString())
        }
    }
    fun showProgressBar(){

        homeViewModel.progressBar.observe(viewLifecycleOwner){
            showProgress(it)

        }
    }


}