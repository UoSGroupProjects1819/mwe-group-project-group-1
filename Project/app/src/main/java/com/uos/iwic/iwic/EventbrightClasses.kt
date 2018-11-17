package com.uos.iwic.iwic

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.sql.Time
import java.util.*

@Parcelize
data class Event(

        val event_name_html: String?,
        val event_description_html: String?,
        val event_organizer_id: String?,
        val event_start_utc: Date?,
        val event_start_timezone: String?,
        val event_end_utc: Time?,
        val event_end_timezone: String?,
        val event_hide_start_date: Boolean?,
        val event_hide_end_date: Boolean?,
        val event_currency: String?,
        val event_venue_id:String?,
        val event_online_event:Boolean?,
        val event_listed:Boolean?,
        val event_logo_id_:String?,
        val event_logo_id: String?,
        val event_category_id: String?,
        val event_subcategory_id: String?,
        val event_format_id: String?,
        val event_shareable: Boolean?,
        val event_invite_only: Boolean?,
        val event_password: String?,
        val event_capacity: Int?,
        val event_show_remaining: Boolean?,
        val event_is_reserved_seating: Boolean?,
        val event_is_externally_ticketed:Boolean?,
        val event_show_pick_a_seat:Boolean?,
        val event_show_seatmap_thumbnail:Boolean?,
        val event_show_colors_in_seatmap_thumbnail: Boolean?,
        val event_source: String?
) : Parcelable