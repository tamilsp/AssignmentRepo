package com.sampletest.gebtest

import com.sampletest.gebtest.pages.Category_MainPage
import com.sampletest.gebtest.pages.SubCategoryPage
import com.sampletest.gebtest.util.ValidationUtil
import geb.spock.GebSpec
import spock.lang.Shared

/**
 * Created by tamils on 08/08/2016.
 */

class TopRatedProductSpec extends GebSpec {
    @Shared
    def ValidationUtil validationUtil = new ValidationUtil()


    def setup() {
        baseUrl = browser.baseUrl
        go(baseUrl)
    }

    def 'Parameterize the values from excel and find the top rated product in snapdeal'() {
        boolean isPresent
        setup: 'Select any menu and redirect to the submenu'
        at Category_MainPage
        selectMainCategory()

        when: 'select submenu and price filter and get the list of product available'
        at SubCategoryPage
        selectSubMenu()
        clickViewAllButton()
        clickOnFilterButton()
        clickPriceFilter()
        specifyFromPrice()
        specifyToPrice()
        filterProductByRating()
        isPresent = findTopRatedProduct()


        then: "Verify five rated product available"
        validationUtil.validate(isPresent, "No five rated product found")


    }

}
