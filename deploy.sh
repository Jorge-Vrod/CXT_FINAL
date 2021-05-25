#!/bin/bash

IP="13.36.159.214"
PORT="22"
DEPLOY_DIR="/home/git/CXTDir"

eval "$(ssh-agent -s)" # Start ssh-agent cache
chmod 600 .travis/deploy_rsa # Allow read access to the private key
ssh-add .travis/deploy_rsa # Add the private key to SSH

echo $?

git config --global push.default matching
git remote add deploy ssh://git@$IP:$PORT$DEPLOY_DIR
git push deploy master

echo $?
echo $(git status)

# Skip this command if you don't need to execute any additional commands after deploying.
#ssh git@$IP -p $PORT <<EOF
#  cd $DEPLOY_DIR
#  crystal build --release --no-debug index.cr # Change to whatever commands you need!
#EOF