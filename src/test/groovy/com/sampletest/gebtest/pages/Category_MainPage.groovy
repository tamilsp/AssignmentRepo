package com.sampletest.gebtest.pages

import com.sampletest.gebtest.modules.Category_mainModule
import com.sampletest.gebtest.util.ReaderUtil
import geb.Page
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.interactions.Actions

/**
 * Created by tamils on 09/08/2016.
 */
class Category_MainPage extends Page {
    ReaderUtil readerUtil = new ReaderUtil()
    static url = ""


    static at = {
        //checks for the title and whether the fields on Login Page are displayed

        title == "Online Shopping in India at Snapdeal - Buy Books, Mobiles, Laptops, Apparel, Watches, Footwear, Recharge, Bill Payments & More"

    }

    static content = {
        category_mainModule { module Category_mainModule }
    }

// Get the data from excel and mousehover on the main menu

    def selectMainCategory() {
        String category = readerUtil.getExcelData("MainMenu", 0)
        def menuElement = category_mainModule.mainMenu(category)
        hoverOver(menuElement)
    }

    //mousehove on any web element

    public void hoverOver(def element) {
        interact {
            moveToElement(element.firstElement())
        }
    }


}







