#!/bin/sh
set -e

sudo apt-get update
sudo apt-get install npm
npm install -g --silent gh-pages