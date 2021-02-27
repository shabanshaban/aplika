package com.example.aplika.Feature.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import com.example.aplika.Common.BaseViewModel
import com.example.aplika.Common.MySingleObserver
import com.example.aplika.Common.asyncNetworkRequest
import com.example.aplika.Data.Repository.BannerRepository
import com.example.aplika.Data.Repository.ProductRepository
import com.example.aplika.Data.model.Banner
import com.example.aplika.Data.model.Product
import kotlinx.android.synthetic.main.fragment_home.*

class HomeViewModel (productRepository: ProductRepository,bannerRepository: BannerRepository):BaseViewModel() {
  private  val _product=MutableLiveData<List<Product>>()
  private  val _Banner=MutableLiveData<List<Banner>>()

    val product: LiveData<List<Product>>
    get() = _product
    val Banner: LiveData<List<Banner>>
        get() = _Banner

    init {

        progressBar.value=true
        productRepository.getProducts()
            .asyncNetworkRequest()
            .doFinally { progressBar.postValue(false) }
            .subscribe(object :MySingleObserver<List<Product>>(compositeDisposable){
                override fun onSuccess(t: List<Product>) {

                    _product.value=t
                }

            })
        bannerRepository.getBanner()
            .asyncNetworkRequest()
            .subscribe(object :MySingleObserver<List<Banner>>(compositeDisposable){

                override fun onSuccess(t: List<Banner>) {
                    _Banner.value=t
                }
            })
    }


}