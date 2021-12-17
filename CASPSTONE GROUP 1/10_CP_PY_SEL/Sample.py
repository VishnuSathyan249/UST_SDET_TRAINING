from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
import time
import unittest


class Test(unittest.TestCase):

    def setUp(self):
        self.browser = webdriver.Chrome\
            (r"C:\Users\Vishnu sathyan\Desktop\SDET\JAR FILES\chromedriver_win32\chromedriver.exe")
        url = 'https://www.urbanladder.com/'
        self.browser.get(url)
        self.browser.maximize_window()

    def test_login(self):
        self.browser.find_element(By.XPATH, "//*[@id='header']/div[1]/div/section[3]/ul/li[2]/span").click()
        time.sleep(1)
        self.browser.find_element(By.LINK_TEXT, "Log In").click()
        time.sleep(5)
        self.browser.find_element(By.XPATH, "/html/body/div[6]/div/div[1]/div/div[2]/div[3]/form/div/input").send_keys(
            "abc1111@gmail.com")
        time.sleep(2)
        self.browser.find_element(By.XPATH, "/html/body/div[6]/div/div[1]/div/div[2]/div[3]/form/div/div/div/input"). \
            send_keys("Fk#mM!wGS9jvx4Z")
        self.browser.find_element(By.ID, "ul_site_login").click()
        print("Login successful")

    def test_Navigate_module(self):
        self.browser.find_element(By.XPATH, "/html/body/div[1]/header/div[2]/div/nav/div/ul/li[1]/span").click()
        time.sleep(2)
        self.browser.find_element(By.LINK_TEXT, "Fabric Sofas").click();
        print("Navigated to Fabric sofas page");

    def test_Sorting_checkbox(self):
        self.browser.find_element(By.XPATH, "//*[@id='filters-form']/div[1]/div/div/ul/li[4]/div[1]/div").click()
        time.sleep(2)
        self.browser.find_element(By.ID, "filters_brand_name_By_Urban_Ladder").click()
        print("Sorted brand by urban ladder ")
        time.sleep(6)

    def test_Sorting_radiobutton(self):
        self.browser.find_element(By.XPATH, "//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[3]/div[1]").click()
        time.sleep(2)
        self.browser.find_element(By.ID, "filters_primary_colors_Greens").click()
        print("Sorted by filters_primary_colors_Greens")
        time.sleep(1)

    def tearDown(self):
        self.browser.close()


if __name__ == "__main__":
    unittest.main()
