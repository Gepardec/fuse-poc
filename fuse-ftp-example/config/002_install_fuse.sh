#!/bin/sh

if [ -z "$FusePackage" ]; then
	FusePackage=$1
fi

if [ ! -f "$FusePackage" ]; then
    echo "JBoss Package $FusePackage doesn't exist! Set FusePackage or use argument" 1>&2
    exit 1
fi

if [ -z "$JBOSS_HOME" ]; then
	echo "Error: JBOSS_HOME not set!" 1>&2
	exit 1
fi

java -jar  $FusePackage $JBOSS_HOME

