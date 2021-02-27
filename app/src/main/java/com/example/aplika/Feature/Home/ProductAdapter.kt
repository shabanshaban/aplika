package com.example.aplika.Feature.Home

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplika.Common.formatPrice
import com.example.aplika.Common.implementSpringAnimationTrait
import com.example.aplika.Data.model.Product
import com.example.aplika.R
import com.example.aplika.Servicee.ImageLoadinServices.ImageLoadingService
import kotlinx.android.synthetic.main.item_product_small.view.*

class ProductAdapter(val imageLoadingService: ImageLoadingService) :
    RecyclerView.Adapter<ProductAdapter.Vh>() {
    var products = ArrayList<Product>()
    var productOnclickListener: ProductOnclickListener? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    inner class Vh(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // catch view for once
       val tvProductTitle           = itemView.TvProductTitle
       val tvProductPriceCurrent    = itemView.TvProductPriceCurrent
       val tv_productPrevious       = itemView.Tv_productPrevious
        fun bindView(product: Product) {
            imageLoadingService.load(itemView.IvProduct, product.image)
            tvProductTitle         .text = product.title
            tvProductPriceCurrent  .text = formatPrice(product.price)
            tv_productPrevious     .text = formatPrice(product.previous_price)
            tv_productPrevious     .paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            itemView.implementSpringAnimationTrait()
            itemView.setOnClickListener {
                productOnclickListener?.onClickProduct(product)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product_small, parent, false)
        )
    }
    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.bindView(products[position])
    }
    override fun getItemCount(): Int = products.size
    interface ProductOnclickListener {
        fun onClickProduct(product: Product)
    }
}