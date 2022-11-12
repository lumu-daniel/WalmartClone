package com.ktn.lab_4.data.local

import com.ktn.lab_4.R

object LocalDataSource {

    val localUsers = mutableListOf<User>(
        User("Kyobe","Lumu","lumukd@gmail.com","lumu")
    )

    val localProducts = mutableListOf<Product>(
        Product("RGA Voyager 7\" 16 GB Android tablet", 35.00,"Black",R.drawable.rga,"1",  "Introducing the RCA Voyager 7-inch Google Certified Tablet. Operating on Android's sweetest operating system yet, you can enjoy more of what the Google Play store has to offer. "),
        Product("HP Flyer Red 15.6\" 15-f272wm Laptop", 299.00,"Black & Red",R.drawable.hp_flyer,"2",  "Intel Pentium N3540 processor4GB memory500GB hard driveWindows 10 HomeThis reliable, value-packed laptop combines the features you need to get the job done. "),
        Product("VIZIO 70\" Inch M-Series 4K", 1298.00,"Black",R.drawable.visio,"3",  "4K Ultra HD - Over 8 million pixels for breathtaking detail. 4 times the resolution of 1080p!"),
        Product("Epson Workforce WF-2750", 69.00,"Black",R.drawable.epison,"4",  "Plain Paper, Plain Paper, Epson Bright White Paper, Brochure & Flyer Paper Matte Double-sided, Ultra Premium Presentation Paper Matte, Premium Presentation Paper Matte"),
        Product("iHome Smart Watch - Activity Trackers", 39.00,"White",R.drawable.watch,"4",  "Plain Paper, Plain Paper, Epson Bright White Paper, Brochure & Flyer Paper Matte Double-sided, Ultra Premium Presentation Paper Matte, Premium Presentation Paper Matte")
    )

    val localCategories = mutableListOf<Category>(
            Category(
                "Electronics",
                R.drawable.electronics,
                localProducts
            ),
            Category(
            "clothing",
            R.drawable.clothing
            ),
            Category(
            "Beauty",
            R.drawable.beauty
            ),
            Category(
            "Food",
            R.drawable.food
            )
    )


}