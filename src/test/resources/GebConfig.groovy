import geb.report.ScreenshotReporter
import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

baseNavigatorWaiting = true

baseUrl="http://www.snapdeal.com"

/*##########Waits-Configurations###################*/
waiting {
    timeout = 60
    retryInterval = 1
    presets {
        longwait {
            timeout = 90
        }
        longwaitWithRetry {
            timeout = 180
            retryInterval = 1
        }
        shortwait {
            timeout = 45
        }
        quick {
            timeout = 30
            retryInterval = 0.1
        }
        shortwaitWithRetry {
            timeout = 45
            retryInterval = 0.5
        }
    }
}

reporter = new ScreenshotReporter()
reportsDir = 'build/reports/screenshots'

driver = {
    def firefox = new FirefoxDriver()
    firefox.manage().window().maximize()
    return firefox

}

