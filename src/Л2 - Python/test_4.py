# Generated by Selenium IDE
import pytest
import time
import json
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities

class Test4():
  def setup_method(self, method):
    self.driver = webdriver.Chrome()
    self.vars = {}
  
  def teardown_method(self, method):
    self.driver.quit()
  
  def test_4(self):
    self.driver.get("https://www.rambler.ru/")
    self.driver.find_element(By.CSS_SELECTOR, "input[name=\"query\"] ").click()
    self.driver.find_element(By.XPATH, "//div[@id=\'app\']//button[@type=\'submit\']").click()
    elements = self.driver.find_elements(By.XPATH, "//*[contains(@class, \'Error\')]//*[text() = \'Задан пустой поисковый запрос\']")
    assert len(elements) > 0
  
