package com.nad.foodie.feature.dashboard.model

import com.nad.foodie.api.response.MenuResponse

interface MenuMapper {
    companion object {
        fun mapToTourDetailUiModel(item: MenuResponse): MenuUiModel {
            return MenuUiModel(
                item.name_menu.orEmpty(),
                item.price_menu.orEmpty(),
                item.image_menu.orEmpty(),
                item.store_menu.orEmpty()
            )
        }
    }
}