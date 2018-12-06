package com.uos.iwic.iwic

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.sql.Time
import java.util.*

@Parcelize
data class EventData(
        val events: List<Event>,
        val pagination: Pagination
) : Parcelable

@Parcelize
data class Pagination(
        val has_more_items: Boolean,
        val object_count: Int,
        val page_count: Int,
        val page_number: Int,
        val page_size: Int
) : Parcelable

@Parcelize
data class Event(
        val description: Description,
        val end: End,
        val logo: Logo,
        val name: Name,
        val start: Start,
        val url: String
) : Parcelable

@Parcelize
data class Name(
        val html: String,
        val text: String
) : Parcelable

@Parcelize
data class Description(
        val html: String,
        val text: String
) : Parcelable

@Parcelize
data class End(
        val local: String,
        val timezone: String,
        val utc: String
) : Parcelable

@Parcelize
data class Start(
        val local: String,
        val timezone: String,
        val utc: String
) : Parcelable

@Parcelize
data class Logo(
        val original: Original,
        val url: String
) : Parcelable

@Parcelize
data class Original(
        val height: Int,
        val url: String,
        val width: Int
) : Parcelable


