#!/bin/bash
if [ "$TRAVIS_BRANCH" = "master" ]; then
  ./boot.sh
fi