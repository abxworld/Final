from selenium import webdriver
from selenium.webdriver.support.select import Select
import time
import unittest


class NetTest(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome('C:\Program Files (x86)\Google\Chrome\Application\chromedriver.exe')
        self.driver.get('http://net269.com/index.php')

    def test_leave(self):
        self.driver.find_element_by_xpath("//div[@class='lm-item control-r']/span[1]").click()

        self.driver.find_element_by_id('username').send_keys('15922222222')

        self.driver.find_element_by_id('password').send_keys('123456')
        # 睡眠2秒
        self.driver.find_element_by_class_name('submit').click()
        # 睡眠，不然找不到下一个元素
        time.sleep(3)
        # 继续一些操作,寻找流程申请
        self.driver.find_element_by_xpath("//div[@id='left-nav']/aside/ul/li[3]").click()
        # 睡眠，不然找不到下一个元素
        time.sleep(1)
        # 点击考勤申请
        self.driver.find_element_by_xpath("//div[@id='app']/ul[4]/li/a").click()
        # 点击新建
        self.driver.find_element_by_link_text('新建').click()
        time.sleep(1)
        # 点击请假申请
        self.driver.find_element_by_link_text('请假申请').click()
        # 填写请假数据
        time.sleep(1)
        # 1.选择审批流程
        sel = self.driver.find_element_by_id('node_name_id')
        Select(sel).select_by_index(1)
        self.driver.find_element_by_name('time').send_keys('5')
        Select(self.driver.find_element_by_name('leave_config_id')).select_by_index(1)
        self.driver.find_element_by_id('leave_date_picker_begin').send_keys('2017-06-28 13:00')
        self.driver.find_element_by_id('leave_date_picker_end').send_keys('2017-06-28 18:00')
        self.driver.find_element_by_name('reason').send_keys('有事请假，望领导批准。')
        time.sleep(3)
        self.driver.find_element_by_xpath("//div[@class='modal-footer']/button[1]").click()

    def tearDown(self):
        print('测试完毕')
        self.driver.quit()
