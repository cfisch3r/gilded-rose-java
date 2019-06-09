#!/bin/sh
set -e

openssl aes-256-cbc -K $encrypted_716a67714777_key -iv $encrypted_716a67714777_iv -in key.enc -out key -d
chmod 600 key
eval $(ssh-agent -s)
ssh-add key

git config user.email "ci@agiledojo.de"
git config user.name "CI"
gh-pages --dist build/reports/jgiven/test/html -b gh-pages -r git@github.com:${TRAVIS_REPO_SLUG}.git