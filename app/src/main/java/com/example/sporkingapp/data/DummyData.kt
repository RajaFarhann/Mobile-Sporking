package com.example.sporkingapp.data

import com.example.sporkingapp.R
import com.example.sporkingapp.model.Category
import com.example.sporkingapp.model.Field

object DummyData {
    private val futsalFields = listOf(
        Field(
            id = 1,
            name = "Lapangan Futsal Ikan Daun",
            price = "167.000,00",
            distance = 0.1,
            rating = 5,
            photo = R.drawable.lapangan_futsal_ikan_daun,
        ),
        Field(
            id = 2,
            name = "M-Barca - Futsal Majesty",
            price = "155.000,00",
            distance = 1.5,
            rating = 3,
            photo = R.drawable.lapangan_futsal_m_barca,
        ),
        Field(
            id = 3,
            name = "Futsal Hang Jebat Batam",
            price = "115.000,00",
            distance = 2.2,
            rating = 2,
            photo = R.drawable.lapangan_futsal_hang_jebat_batam,
        ),
        Field(
            id = 4,
            name = "Sport Hill Centre",
            price = "110.000,00",
            distance = 1.2,
            rating = 5,
            photo = R.drawable.lapangan_futsal_sport_hill_centre,
        ),
        Field(
            id = 5,
            name = "GO Futsal",
            price = "100.000,00",
            distance = 3.2,
            rating = 4,
            photo = R.drawable.lapangan_futsal_go_futsal,
        )
    )

    private val badmintonFields = listOf(
        Field(
            id = 1,
            name = "Gor Bulu Tangkis Orchid Park",
            price = "170.000,00",
            distance = 8.0,
            rating = 3,
            photo = R.drawable.lapangan_gor_orchid_park,
        ),
        Field(
            id = 2,
            name = "GOR Badminton Batu Batam",
            price = "120.000,00",
            distance = 7.2,
            rating = 1,
            photo = R.drawable.lapangan_gor_batu_batam,
        ),
        Field(
            id = 3,
            name = "Elite Badminton",
            price = "130.000,00",
            distance = 1.5,
            rating = 4,
            photo = R.drawable.lapangan_gor_elite_badminton,
        ),
        Field(
            id = 4,
            name = "GOR Badminton Temenggung",
            price = "140.000,00",
            distance = 2.5,
            rating = 2,
            photo = R.drawable.lapangan_gor_temenggung,
        ),
        Field(
            id = 5,
            name = "GOR Bulu tangkis Tiban",
            price = "160.000,00",
            distance = 10.0,
            rating = 3,
            photo = R.drawable.lapangan_gor_tiban,
        )
    )
    private val sepakBolaFields = listOf(
        Field(
            id = 1,
            name = "Batam Arena MiniSoccer",
            price = "270.000,00",
            distance = 9.0,
            rating = 4,
            photo = R.drawable.lapangan_sepak_bola_batam_arena,
        ),
        Field(
            id = 2,
            name = "Alpha Mini Soccer",
            price = "220.000,00",
            distance = 2.2,
            rating = 3,
            photo = R.drawable.lapangan_sepak_bola_alpha,
        )
    )

    private val basketFields = listOf(
        Field(
            id = 1,
            name = "Palm Spring Basketball Court",
            price = "150.000,00",
            distance = 2.0,
            rating = 4,
            photo = R.drawable.lapangan_basket_palm_spring,
        ),
        Field(
            id = 2,
            name = "MJ ARENA",
            price = "220.000,00",
            distance = 4.2,
            rating = 5,
            photo = R.drawable.lapangan_basket_mj_arena,
        ),
        Field(
            id = 3,
            name = "Guard Arena",
            price = "210.000,00",
            distance = 1.5,
            rating = 4,
            photo = R.drawable.lapangan_basket_guard_arena,
        ),
        Field(
            id = 4,
            name = "T.M.Arena",
            price = "200.000,00",
            distance = 1.5,
            rating = 4,
            photo = R.drawable.lapangan_basket_tm_arena,
        ),
        Field(
            id = 5,
            name = "Hi-Test Arena",
            price = "260.000,00",
            distance = 10.0,
            rating = 5,
            photo = R.drawable.lapangan_basket_hitest_arena,
        )
    )

    val categories = listOf(
        Category(
            id = 1,
            name = "Futsal",
            photo = R.drawable.category_futsal,
            fields = futsalFields
        ),
        Category(
            id = 2,
            name = "Badminton",
            photo = R.drawable.category_badminton,
            fields = badmintonFields
        ),
        Category(
            id = 3,
            name = "Basket",
            photo = R.drawable.category_basket,
            fields = basketFields
        ),
        Category(
            id = 4,
            name = "Sepak Bola",
            photo = R.drawable.category_sepakbola,
            fields = sepakBolaFields
        ),
    )
}