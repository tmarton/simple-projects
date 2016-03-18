#!/usr/bin/env python

import pickle
import smtplib
import pickle

from selenium import webdriver
from subprocess import Popen, PIPE

SITES = [
    ("http://www.zaletsi.cz","#content .article-list a")
]

DB_PATH = "links"
BROWSER_PATH = "phantomjs-2.1.1-linux-x86_64/bin/phantomjs"

class TicketScrapper(object):
    def __init__(self):
        self.driver = webdriver.PhantomJS(executable_path = BROWSER_PATH)
        self.driver.set_window_size(1120,550)
        try:
            self.links = pickle.load(open(DB_PATH, "rb"))
        except IOError:
            self.links = []
        self.new_links = []

    def __del__(self):
        self.driver.quit()

    def scrape(self):
        for url, css in SITES:
            self.driver.get(url)
            for site_link in self.driver.find_elements_by_css_selector(css):
                link_object = site_link.get_attribute("href")
                if link_object not in self.links and link_object not in self.new_links:
                    self.new_links.append(link_object)
                    self.links.append(link_object)
        pickle.dump(self.links, open(DB_PATH, "wb"))
        return self.new_links

if __name__ == '__main__':


    scrapper = TicketScrapper()
    links = scrapper.scrape()

    if links:
    	msg = 'Subject: %s\n\n' % "Fresh fly tickets"
    	for link in links:
    	    msg += str(link) + '\n'
        print(msg)
        s = smtplib.SMTP('relay.fi.muni.cz')
        s.sendmail('tomas.marton22@gmail.com',['tomas.marton22@gmail.com'], msg)
        s.quit()
