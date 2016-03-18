#!/bin/bash

wget https://bitbucket.org/ariya/phantomjs/downloads/phantomjs-2.1.1-linux-x86_64.tar.bz2
tar -xjvf phantomjs-2.1.1-linux-x86_64.tar.bz2 
#cp phantomjs-2.1.1-linux-x86_64/bin/phantomjs ~/.local/bin/

#virtualenv venv
#source venv/bin/activate
pip install --user selenium
