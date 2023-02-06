package com.myapp.compose.model

data class RestaurantDetails(
    val Area: String,
    val CuisineSets: List<CuisineSet>,
    val Dishes: List<Any>,
    val MetaData: MetaData,
    val RestaurantSets: List<RestaurantSet>,
    val Restaurants: List<Restaurant>,
    val ShortResultText: String,
    val Views: List<View>,
    val deliveryFees: DeliveryFees,
    val promotedPlacement: PromotedPlacement
)

data class CuisineSet(
    val Cuisines: List<Cuisine>,
    val Id: String,
    val Name: String,
    val Type: String
)

data class MetaData(
    val Area: String,
    val CanonicalName: String,
    val CollectionExperimentInjectedRestaurantIds: Any,
    val CuisineDetails: List<CuisineDetail>,
    val DeliveryArea: String,
    val District: String,
    val Latitude: Double,
    val Longitude: Double,
    val Postcode: String,
    val ResultCount: Int,
    val SearchedTerms: Any,
    val TagDetails: List<TagDetail>
)

data class RestaurantSet(
    val Id: String,
    val Name: String,
    val Restaurants: List<Restaurant>,
    val Type: String
)

data class Restaurant(
    val Metadata: MetadataX,
    val Address: Address,
    val Badges: List<Any>,
    val BrandName: String,
    val City: String,
    val CollectionMenuId: Any,
    val CuisineTypes: List<CuisineType>,
    val Cuisines: List<Cuisine>,
    val Deals: List<Any>,
    val DefaultDisplayRank: Int,
    val DeliveryChargeBands: List<Any>,
    val DeliveryCost: Double,
    val DeliveryEtaMinutes: DeliveryEtaMinutes,
    val DeliveryMenuId: Any,
    val DeliveryOpeningTime: String,
    val DeliveryOpeningTimeLocal: String,
    val DeliveryOpeningTimeUtc: Any,
    val DeliveryStartTime: String,
    val DeliveryTime: Any,
    val DeliveryTimeMinutes: Any,
    val DeliveryWorkingTimeMinutes: Int,
    val DeliveryZipcode: Any,
    val Description: String,
    val DriveDistance: Double,
    val DriveInfoCalculated: Boolean,
    val HygieneRating: Any,
    val Id: Int,
    val IsBrand: Boolean,
    val IsCloseBy: Boolean,
    val IsCollection: Boolean,
    val IsDelivery: Boolean,
    val IsFreeDelivery: Boolean,
    val IsHalal: Boolean,
    val IsNew: Boolean,
    val IsOpenNow: Boolean,
    val IsOpenNowForCollection: Boolean,
    val IsOpenNowForDelivery: Boolean,
    val IsOpenNowForPreorder: Boolean,
    val IsPremier: Boolean,
    val IsSponsored: Boolean,
    val IsTemporarilyOffline: Boolean,
    val IsTemporaryBoost: Boolean,
    val IsTestRestaurant: Boolean,
    val LastUpdated: String,
    val Latitude: Double,
    val Logo: List<Logo>,
    val LogoUrl: String,
    val Longitude: Double,
    val MinimumDeliveryValue: Double,
    val Name: String,
    val NewnessDate: String,
    val NumberOfRatings: Int,
    val OfferPercent: Double,
    val Offers: List<Any>,
    val OpeningTime: String,
    val OpeningTimeIso: String,
    val OpeningTimeLocal: String,
    val OpeningTimeUtc: Any,
    val OpeningTimes: List<Any>,
    val Postcode: String,
    val Rating: Rating,
    val RatingAverage: Double,
    val RatingStars: Double,
    val ReasonWhyTemporarilyOffline: String,
    val Score: Double,
    val ScoreMetaData: List<ScoreMetaData>,
    val SecondDateRank: Double,
    val SecondDateRanking: Double,
    val SendsOnItsWayNotifications: Boolean,
    val ServiceableAreas: List<Any>,
    val ShowSmiley: Boolean,
    val SmileyDate: Any,
    val SmileyElite: Boolean,
    val SmileyResult: Any,
    val SmileyUrl: Any,
    val SponsoredPosition: Int,
    val Tags: List<String>,
    val UniqueName: String,
    val Url: String
)

data class View(
    val Components: List<Component>,
    val Target: String
)

data class DeliveryFees(
    val restaurants: Restaurants
)

data class PromotedPlacement(
    val filteredSearchPromotedLimit: Int,
    val rankedIds: List<Int>,
    val restaurants: RestaurantsX
)

data class Cuisine(
    val Name: String,
    val SeoName: String
)

data class CuisineDetail(
    val Name: String,
    val SeoName: String,
    val Total: Int
)

data class TagDetail(
    val BackgroundColour: String,
    val Colour: String,
    val DisplayName: String,
    val Key: String,
    val Priority: Int
)

data class MetadataX(
    val Rating: String
)

data class Address(
    val City: String,
    val FirstLine: String,
    val Latitude: Double,
    val Longitude: Double,
    val Postcode: String
)

data class CuisineType(
    val Id: Int,
    val IsTopCuisine: Boolean,
    val Name: String,
    val SeoName: String
)

data class DeliveryEtaMinutes(
    val Approximate: Any,
    val RangeLower: Int,
    val RangeUpper: Int
)

data class Logo(
    val StandardResolutionURL: String
)

data class Rating(
    val Average: Double,
    val Count: Int,
    val StarRating: Double
)

data class ScoreMetaData(
    val Key: String,
    val Value: String
)

data class Component(
    val Id: String,
    val TemplateName: String,
    val TrackingId: String,
    val Type: String,
    val ViewData: ViewData
)

data class ViewData(
    val Dishes: Any,
    val FocusedProperties: List<String>,
    val SeeAllFilterId: String,
    val SeeAllSearchTarget: SeeAllSearchTarget,
    val SubTitle: Any,
    val Title: String
)

data class SeeAllSearchTarget(
    val CuisineFilters: List<Any>,
    val Refinements: List<Any>,
    val SortOrder: String
)

data class Restaurants(
    val bandList: BandList,
)

data class BandList(
    val bands: List<Band>,
    val minimumOrderValue: Int,
    val restaurantId: String
)

data class Band(
    val fee: Int,
    val minimumAmount: Int
)

data class RestaurantsX(
    val common: Common,
)

data class Common(
    val defaultPromoted: Boolean,
    val restaurantId: String
)