#!/bin/bash
wildfly="/c/LocalInstall/Servers/wildfly-10.1.0.Final/wildfly-10.1.0.Final"
deployment_folder="$wildfly/standalone/deployments"
mvn clean install
rm -rf $deployment_folder/accountapp*
rm -rf $deployment_folder/h2console.war.deployed
cp target/accountapp.war $deployment_folder
cmd "/C C:\\LocalInstall\\Servers\\wildfly-10.1.0.Final\\wildfly-10.1.0.Final\\bin\\standalone.bat"
