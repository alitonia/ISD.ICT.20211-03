#!/bin/bash

MVN_EXPORTSTRING='export PATH='$(pwd)/../mvn/bin':$PATH'

if grep -q "$MVN_EXPORTSTRING" "$HOME"'/.bashrc'; then
    echo found
else
    echo 'add repo mvn to ~/.bashrc'
    echo "$MVN_EXPORTSTRING" >>~/.bashrc
    source "$HOME"/'.bashrc'
fi

mvn --version

