#!/bin/bash
IP="13.36.159.214" # IP remota
PORT="22"
DEPLOY_DIR="/home/git/CXTSpring" # Directorio de despliegue

eval "$(ssh-agent -s)"
chmod 600 deploy_rsa
ssh-add deploy_rsa

echo "Accediendo a repositorio"
git config --global push.default matching
git remote add deploy ssh://git@$IP:$PORT$DEPLOY_DIR
GIT_SSH_COMMAND="ssh -o StrictHostKeyChecking=no" git push deploy master


echo "Conectando a máquina de despliegue"
ssh git@$IP -p $PORT <<EOF
cd $DEPLOY_DIR/complete
echo "Matando servicio antiguo e inciando tests"
./gradlew --stop
echo "TEST"
./gradlew test
EOF

ssh git@$IP -p $PORT <<EOF
cd $DEPLOY_DIR/complete
echo "Arrancando servicio actualizado"
nohup ./gradlew bootRun > Output.out 2> Error.err < /dev/null &
EOF
