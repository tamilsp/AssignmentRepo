package com.sampletest.gebtest.modules

import geb.Module

/**
 * Created by tamils on 09/08/2016.
 */
class SubCategoryModule extends Module {
    static content = {
        subcat { submenu -> $(".headingText", text: submenu) }

        submenuNav { $('a[href*="http://www.snapdeal.com/products"]').eq(1) }

        fromPrice { $('input[name="fromVal"]').eq(0) }

        toPrice { $('input[name="toVal"]').eq(0) }

        addPrice { $('div.price-go-arrow').eq(0) }

        customerRating { $('li#tab-avgRating') }

        filterRating { $('label[for="avgRating-4.0"]').eq(0) }

        applyFilter { $('div[class*="applyFilters"]') }

        filterValue { $("button.view-all-filters").eq(0) }

        filledStars { $('.product-tuple-description .filled-stars') }

        starRating { n -> $('.product-tuple-description .filled-stars').eq(n).getAttribute("style") }

        fiveRatedProduct { n -> $('.product-tuple-description a').eq(n) }

        viewAllbutton { $('span.viewallCsf>a') }

        price { $('li#tab-Price') }


    }
}
