package com.example.sporkingapp.data.local.dummy

import com.example.sporkingapp.R
import com.example.sporkingapp.model.Category
import com.example.sporkingapp.model.Field
import com.example.sporkingapp.model.News

object DummyData {
    val futsalFields = listOf(
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

    val badmintonFields = listOf(
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
    val sepakBolaFields = listOf(
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

    val basketFields = listOf(
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
    val newsList = listOf(
        News(
            id = 1,
            title = "Manchester United Shocks Manchester City in English FA Cup Final",
            date = "20/8/2023",
            newsItemText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Massa massa ultricies mi quis hendrerit dolor magna. Lorem sed risus ultricies tristique nulla aliquet enim tortor. Quis auctor elit sed vulputate mi sit amet mauris.",
            newsImageID = R.drawable.p1
        ),
        News(
            id = 2,
            title = "Barcelona Retains Women’s Champions League Title, Completing Historic Quadruple",
            date = "1/2/2023",
            newsItemText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Massa massa ultricies mi quis hendrerit dolor magna. Lorem sed risus ultricies tristique nulla aliquet enim tortor. Quis auctor elit sed vulputate mi sit amet mauris.",
            newsImageID = R.drawable.p2
        ),
        News(
            id = 3,
            title = "Novak Djokovic’s Wait for First Title of 2024 Continues as He Struggles with Illness at Geneva Open",
            date = "4/10/2023",
            newsItemText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Massa massa ultricies mi quis hendrerit dolor magna. Lorem sed risus ultricies tristique nulla aliquet enim tortor. Quis auctor elit sed vulputate mi sit amet mauris.",
            newsImageID = R.drawable.p3
        ),
        News(
            id = 4,
            title = "Southampton Back in the Premier League After Winning Playoff Final, the Richest Game in World Soccer",
            date = "12/7/2023",
            newsItemText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Massa massa ultricies mi quis hendrerit dolor magna. Lorem sed risus ultricies tristique nulla aliquet enim tortor. Quis auctor elit sed vulputate mi sit amet mauris.",
            newsImageID = R.drawable.p4
        ),
        News(
            id = 5,
            title = "FC Midtjylland Wins Danish League After Final-Day Slip-Up by Brondby",
            date = "23/5/2023",
            newsItemText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Massa massa ultricies mi quis hendrerit dolor magna. Lorem sed risus ultricies tristique nulla aliquet enim tortor. Quis auctor elit sed vulputate mi sit amet mauris.",
            newsImageID = R.drawable.p5
        ),
        News(
            id = 6,
            title = "Manchester United Shocks Manchester City in English FA Cup Final",
            date = "20/8/2023",
            newsItemText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Massa massa ultricies mi quis hendrerit dolor magna. Lorem sed risus ultricies tristique nulla aliquet enim tortor. Quis auctor elit sed vulputate mi sit amet mauris.",
            newsImageID = R.drawable.p1
        ),
        News(
            id = 7,
            title = "Barcelona Retains Women’s Champions League Title, Completing Historic Quadruple",
            date = "1/2/2023",
            newsItemText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Massa massa ultricies mi quis hendrerit dolor magna. Lorem sed risus ultricies tristique nulla aliquet enim tortor. Quis auctor elit sed vulputate mi sit amet mauris.",
            newsImageID = R.drawable.p2
        ),
        News(
            id = 8,
            title = "Novak Djokovic’s Wait for First Title of 2024 Continues as He Struggles with Illness at Geneva Open",
            date = "4/10/2023",
            newsItemText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Massa massa ultricies mi quis hendrerit dolor magna. Lorem sed risus ultricies tristique nulla aliquet enim tortor. Quis auctor elit sed vulputate mi sit amet mauris.",
            newsImageID = R.drawable.p3
        ),
        News(
            id = 9,
            title = "Southampton Back in the Premier League After Winning Playoff Final, the Richest Game in World Soccer",
            date = "12/7/2023",
            newsItemText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Massa massa ultricies mi quis hendrerit dolor magna. Lorem sed risus ultricies tristique nulla aliquet enim tortor. Quis auctor elit sed vulputate mi sit amet mauris.",
            newsImageID = R.drawable.p4
        ),
        News(
            id = 10,
            title = "FC Midtjylland Wins Danish League After Final-Day Slip-Up by Brondby",
            date = "23/5/2023",
            newsItemText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Massa massa ultricies mi quis hendrerit dolor magna. Lorem sed risus ultricies tristique nulla aliquet enim tortor. Quis auctor elit sed vulputate mi sit amet mauris.",
            newsImageID = R.drawable.p5
        ),
        News(
            id = 11,
            title = "Chalsea wins against Manchaster United in Premier League at summer 2024",
            date = "23/5/2023",
            newsItemText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Massa massa ultricies mi quis hendrerit dolor magna. Lorem sed risus ultricies tristique nulla aliquet enim tortor. Quis auctor elit sed vulputate mi sit amet mauris.",
            newsImageID = R.drawable.p6
        ),
        News(
            id = 12,
            title = "Soccer is the real language in term of sport not Football",
            date = "12/8/2024",
            newsItemText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Tellus molestie nunc non blandit massa enim nec. Placerat in egestas erat imperdiet. Lectus vestibulum mattis ullamcorper velit sed. Parturient montes nascetur ridiculus mus mauris vitae ultricies leo integer. Eu scelerisque felis imperdiet proin fermentum leo vel orci. Nibh nisl condimentum id venenatis a condimentum vitae. Non tellus orci ac auctor augue mauris augue neque. Vitae proin sagittis nisl rhoncus mattis rhoncus urna. Pharetra magna ac placerat vestibulum lectus mauris ultrices eros. Ultrices eros in cursus turpis massa tincidunt dui ut. Arcu dictum varius duis at consectetur lorem donec. Ornare lectus sit amet est placerat. Fermentum et sollicitudin ac orci phasellus egestas tellus rutrum tellus.\n" +
                    "\n" +
                    "Sit amet purus gravida quis. Sed risus pretium quam vulputate dignissim suspendisse in est ante. Nisl nisi scelerisque eu ultrices. Fermentum odio eu feugiat pretium nibh ipsum. Nisl nisi scelerisque eu ultrices vitae auctor eu augue ut. Enim ut tellus elementum sagittis vitae et leo duis. Ullamcorper eget nulla facilisi etiam dignissim diam. Nisl nunc mi ipsum faucibus vitae. In nibh mauris cursus mattis molestie a iaculis at. Ut enim blandit volutpat maecenas. Enim blandit volutpat maecenas volutpat. Posuere urna nec tincidunt praesent. Mattis aliquam faucibus purus in. Elit pellentesque habitant morbi tristique senectus et. Purus sit amet luctus venenatis lectus. Neque sodales ut etiam sit amet nisl purus. Diam maecenas sed enim ut sem viverra aliquet eget sit.\n" +
                    "\n" +
                    "Amet aliquam id diam maecenas ultricies mi eget mauris pharetra. Egestas sed tempus urna et. Nulla aliquet enim tortor at auctor urna nunc. Vivamus arcu felis bibendum ut tristique. Quis risus sed vulputate odio ut. Tortor consequat id porta nibh venenatis. Habitant morbi tristique senectus et netus et malesuada. Morbi leo urna molestie at elementum eu facilisis sed. Lorem ipsum dolor sit amet. Sit amet consectetur adipiscing elit. Lorem dolor sed viverra ipsum nunc aliquet bibendum enim facilisis. Odio morbi quis commodo odio aenean sed. Elementum sagittis vitae et leo duis ut diam quam nulla. Semper eget duis at tellus at urna condimentum mattis. Scelerisque in dictum non consectetur a erat. Consequat nisl vel pretium lectus. Ut etiam sit amet nisl purus in. Suscipit tellus mauris a diam.",
            newsImageID = R.drawable.football
        )
    )
}