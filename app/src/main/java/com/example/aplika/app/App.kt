package com.example.aplika.app

import android.app.Application
import com.example.aplika.Data.Datasource.BannerRemoteDataSource
import com.example.aplika.Data.Datasource.ProductRemoteDataSource
import com.example.aplika.Data.Repository.BannerRepository
import com.example.aplika.Data.Repository.BannerRepositoryImpl
import com.example.aplika.Data.Repository.ProductRepository
import com.example.aplika.Data.Repository.ProductRepositryImp
import com.example.aplika.Feature.Home.HomeViewModel
import com.example.aplika.Feature.Home.ProductAdapter
import com.example.aplika.Servicee.ApiService.ApiService
import com.example.aplika.Servicee.ApiService.createApiServiceInstance
import com.example.aplika.Servicee.ImageLoadinServices.ImageLoadingImpl
import com.example.aplika.Servicee.ImageLoadinServices.ImageLoadingService
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber

class app :Application() {


    override fun onCreate() {
        super.onCreate()
        //init library timber for log
        Timber.plant(Timber.DebugTree())
        //init library fresco for load image
        Fresco.initialize(this)


        // make module dor dependency  injection with library koin
        val mymodul= module {

            single <ApiService>{ createApiServiceInstance()  }
            single<ImageLoadingService> { ImageLoadingImpl() }
            factory <ProductRepository>{ ProductRepositryImp(ProductRemoteDataSource(get()))  }
            factory <BannerRepository>{ BannerRepositoryImpl(  BannerRemoteDataSource(get()))  }
            factory <ProductAdapter>{  ProductAdapter(get())  }

            viewModel { HomeViewModel(get(),get()) }
        }


        startKoin {

            modules(mymodul)
        }




    }
}