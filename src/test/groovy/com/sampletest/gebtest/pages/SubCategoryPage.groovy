package com.sampletest.gebtest.pages

import com.sampletest.gebtest.modules.Category_mainModule
import com.sampletest.gebtest.modules.SubCategoryModule
import com.sampletest.gebtest.util.ReaderUtil
import geb.Page

/**
 * Created by tamils on 09/08/2016.
 */
class SubCategoryPage extends Page {
    ReaderUtil readerUtil = new ReaderUtil()

    static at = {
        waitFor { subCategoryModule.link.displayed }

    }

    static content = {
        category_mainModule { module Category_mainModule }
        subCategoryModule { module SubCategoryModule }
    }

//Get the sub menu from  execel and click on it
    def selectSubMenu() {
        def subMenuValue = readerUtil.getExcelValues("SubMenu")
        def element = subCategoryModule.subcat(subMenuValue)
        element.click()
    }

// Specify the  from price range from the excel
    def specifyFromPrice() {
        def fromPrice = readerUtil.getExcelValues("PriceFrom")
        waitFor { subCategoryModule.fromPrice.displayed }
        subCategoryModule.fromPrice.value("")
        subCategoryModule.fromPrice.value(fromPrice)
    }

    // Specify the to price range from the excel
    def specifyToPrice() {
        def toPrice = readerUtil.getExcelValues("PriceTo")
        waitFor { subCategoryModule.toPrice.displayed }
        subCategoryModule.toPrice.value("")
        subCategoryModule.toPrice.value(toPrice)
        subCategoryModule.addPrice.click()

    }

//Apply rating filter to get the top rated product

    def filterProductByRating() {
        waitFor { subCategoryModule.customerRating.displayed }
        subCategoryModule.customerRating.click()
        waitFor { subCategoryModule.filterRating.displayed }
        subCategoryModule.filterRating.click()
        subCategoryModule.applyFilter.click()

    }
// To find the five rated product in the list of products

    def boolean findTopRatedProduct() {
        boolean topProduct = false
        int topRating = 0
        def i = 0
        String rating
        double ratingNum, number = 100
        waitFor { subCategoryModule.filterValue.displayed }
        int productCount = subCategoryModule.filledStars.size()
        for (i = 0; i <= productCount; i++) {
            rating = subCategoryModule.starRating(i).trim().replace("width:", "").replace("%", "").replace(";", "")
            ratingNum = Double.valueOf(rating.trim()).doubleValue()
            if (ratingNum > topRating) {
                topRating = ratingNum
            }
            if (ratingNum == number) {
                topProduct = true
                break;
            }

        }
        waitFor { subCategoryModule.fiveRatedProduct(i).displayed }
        subCategoryModule.fiveRatedProduct(i).click()
        return topProduct
    }

//selecting the view all button  after selecting the subcategory

    def clickViewAllButton() {
        def element = subCategoryModule.viewAllbutton
        element.click()
    }

    def clickOnFilterButton() {
        def element = subCategoryModule.filterValue
        element.click()
    }

//Apply price filter to get the list of products within the price range

    def clickPriceFilter() {
        waitFor { subCategoryModule.price.displayed }
        def element = subCategoryModule.price
        element.click()
    }

}

