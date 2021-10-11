package com.android.oda.data.shopping

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Keep
data class ProductsListDto(
    val items: List<ProductItem>,
    @SerializedName("extra_lines")
    val extraLines: List<ExtraLine>
) : Parcelable

@Parcelize
@Keep
data class ProductItem(
    val product: ProductInfo,
    var quantity: Int,
    @SerializedName("display_price_total")
    val displayPriceTotal: String,
    @SerializedName("discounted_display_price_total")
    val discountedDisplayPriceTotal: String
): Parcelable

@Parcelize
@Keep
data class ProductInfo(
    val id: Long,
    @SerializedName("full_name")
    val fullName: String,
    val brand: String?,
    @SerializedName("brand_id")
    val brandId: Long?,
    val name: String,
    @SerializedName("name_extra")
    val nameExtra: String?,
    @SerializedName("front_url")
    val frontUrl: String,
    val images: List<Image>,
    @SerializedName("gross_price")
    val grossPrice: String,
    @SerializedName("gross_unit_price")
    val grossUnitPrice: String,
    @SerializedName("unit_price_quantity_abbreviation")
    val unitPriceQuantityAbbreviation: String,
    @SerializedName("unit_price_quantity_name")
    val unitPriceQuantityName: String,
    val discount: Discount?,
    val promotion: Promotion?,
    val availability: Availability,
    @SerializedName("client_classifiers")
    val clientClassifiers: List<ClientClassifiers> = listOf()
): Parcelable

@Parcelize
@Keep
data class Image(
    val thumbnail: URL,
    val large: URL,
): Parcelable

@Parcelize
@Keep
data class URL(
    val url: String
): Parcelable

@Parcelize
@Keep
data class Availability(
    @SerializedName("is_available")
    val isAvailable: Boolean,
    val code: String?,
    val description: String,
    @SerializedName("description_short")
    val descriptionShort: String
): Parcelable

@Parcelize
@Keep
data class Discount(
    @SerializedName("is_discounted")
    val isDiscounted: Boolean,
    @SerializedName("undiscounted_gross_price")
    val unDiscountedGrossPrice: String,
    @SerializedName("undiscounted_gross_unit_price")
    val unDiscountedGrossUnitPrice: String,
    @SerializedName("description_short")
    val descriptionShort: String
): Parcelable

@Parcelize
@Keep
data class Promotion(
    val title: String,
    @SerializedName("title_color")
    val titleColor: String,
    @SerializedName("background_color")
    val backgroundColor: String,
    @SerializedName("text_color")
    val textColor: String,
    @SerializedName("description_short")
    val descriptionShort: String,
    @SerializedName("accessibility_text")
    val accessibilityText: String
): Parcelable

@Parcelize
@Keep
data class ClientClassifiers(
    val name: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("is_important")
    val isImportant: Boolean
): Parcelable

@Parcelize
@Keep
data class ExtraLine(
    val description: String,
    @SerializedName("long_description")
    val longDescription: String,
    @SerializedName("gross_amount")
    val grossAmount: Boolean
): Parcelable