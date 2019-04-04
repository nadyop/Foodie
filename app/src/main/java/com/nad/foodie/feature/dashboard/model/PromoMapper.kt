package com.nad.foodie.feature.dashboard.model

import com.nad.foodie.api.response.PromoResponse

interface PromoMapper {
    companion object {
        fun mapToPromoUiModel(item: PromoResponse): PromoUiModel {
            return PromoUiModel(
                item.image_promo.orEmpty()
            )
        }
    }
}