# coding = utf-8
from selenium import webdriver
from selenium.webdriver.support.select import Select
import time
import sys


def hello():
    browser = webdriver.Chrome("C:\Program Files (x86)\Google\Chrome\Application\chromedriver.exe")
    browser.get("https://mail.163.com/")
    browser.find_element_by_name("email").send_keys("xzy2016520")
    browser.find_element_by_id("auto-id-1531623052865").send_keys("zxcv999")
    time.sleep(3)
    browser.find_element_by_id("dologin").click()
    time.sleep(3)
    browser.quit()


if __name__ == '__main__':
    hello()
