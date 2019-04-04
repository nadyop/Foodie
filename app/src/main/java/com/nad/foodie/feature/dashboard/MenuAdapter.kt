package com.nad.foodie.feature.dashboard

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.nad.foodie.R
import com.nad.foodie.databinding.ItemMenuBinding
import com.nad.foodie.feature.base.BaseRecyclerViewListAdapter
import com.nad.foodie.feature.dashboard.model.MenuUiModel

class MenuAdapter(
    menuUiModels: MutableList<MenuUiModel>
) : BaseRecyclerViewListAdapter<MenuUiModel, MenuAdapter.ViewHolder>(menuUiModels) {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemGridBinding = DataBindingUtil.bind<ItemMenuBinding>(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_menu, parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.itemGridBinding?.apply {
            with(item) {
                Glide.with(ivPhoto.context).load(this.image_menu).placeholder(
                    R.drawable.no_image_available
                ).into(ivPhoto)
                Glide.with(ivIcon.context).load(this.store_menu).placeholder(
                    R.drawable.no_image_available
                ).into(ivIcon)
                tvName.text = name_menu.capitalize()
                tvPrice.text = price_menu
            }
        }
    }
}