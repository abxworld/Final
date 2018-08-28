#from selenium import webdriver
import selenium
import time
from selenium import webdriver
from PIL import Image
import selectors

def connect():
    browser = webdriver.Chrome("C:\Program Files (x86)\Google\Chrome\Application\chromedriver.exe")
    browser.set_window_size(960, 6000)
    browser.get("http://dev-13.unpay.com:8080/oper/#/login")
    time.sleep(3)
    elements = browser.find_elements_by_tag_name("input")
    login = elements[0]
    login.send_keys("hello@unpay.com")
    passw = elements[1]
    passw.send_keys("12345678a")
    img = browser.find_element_by_tag_name("img")
    src = img.get_attribute("src")
    print(src)
    time.sleep(10)
    browser.quit()



if __name__ == '__main__':
    connect()
