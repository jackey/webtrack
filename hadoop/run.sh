#!/usr/bin/env bash

ant clean
ant build

if [[ -d out ]]; then
	rm -rf out
fi

if [[ $? -eq 0 ]]; then
	hadoop jar bin/webtrack.jar
fi
