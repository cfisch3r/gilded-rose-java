#!/bin/sh
set -e

git config user.email "ci@agiledojo.de"
git config user.name "CI"
gh-pages --dist build/reports/jgiven/test/html -b gh-pages -r git@github.com:${TRAVIS_REPO_SLUG}.git