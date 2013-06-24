#!/usr/bin/env bash

ant clean
ant build

if [[ $? -eq 0 ]]; then
	hadoop jar bin/webtrack.jar
fi
