package com.sampletest.gebtest.modules

import geb.Module

/**
 * Created by tamils on 09/08/2016.
 */
class Category_mainModule extends Module {
    static  content ={
        mainMenu {menu->$(".catText", text:menu)}
    }
}
