#!/usr/bin/env bash

# http://redsymbol.net/articles/unofficial-bash-strict-mode/
set -euo pipefail
IFS=$'\n\t'

WORKING_DIR="kinesis-local"

mkdir -p $WORKING_DIR
cd $WORKING_DIR

LOG_DIR="logs"
mkdir -p $LOG_DIR
echo "Kinesis Local output will save to ${WORKING_DIR}/${LOG_DIR}/"

NOW=$(date -u +"%Y-%m-%dT%H:%M:%SZ")
exec kinesalite >"${LOG_DIR}/${NOW}.out.log" 2>"${LOG_DIR}/${NOW}.err.log" &
PID=$!

echo "Kinesis Local started with pid ${PID}"
echo $PID >"PID"

echo "Pausing for 2 seconds..."
sleep 2
