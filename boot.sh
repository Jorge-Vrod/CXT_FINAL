#!/bin/bash
IP="13.36.159.214"
PORT="22"
DEPLOY_DIR="/home/git/CXTSpring"

eval "$(ssh-agent -s)" # Start ssh-agent cache
chmod 600 deploy_rsa # Allow read access to the private key
ssh-add deploy_rsa # Add the private key to SSH

git config --global push.default matching

git remote add deploy ssh://git@$IP:$PORT$DEPLOY_DIR

echo $(git remote -v)
GIT_SSH_COMMAND="ssh -o StrictHostKeyChecking=no" git push deploy master



#git push deploy master

# Skip this command i you don't need to execute any additional commands after deploying.
echo "SHHHHHHHHHHHHH"
ssh git@$IP -p $PORT <<EOF
cd $DEPLOY_DIR/complete
echo "MATANDO"
./gradlew --stop
echo "TEST"
./gradlew test
EOF

ssh git@$IP -p $PORT <<EOF
cd $DEPLOY_DIR/complete
echo "RUN"
nohup ./gradlew bootRun > Output.out 2> Error.err < /dev/null &
EOF