Camel FTP Example
-----------------

Das ist nach Vorlage der Quickstarts erstellt und mit JBSS
https://github.com/Gepardec/JBSS kombiniert.

Es holt Files von einem FTP-Server oder stellt Dateien auf
eine FTP-Server, die es dann aber gleich wieder holt.

## Test

```
curl http://127.0.0.1:8080/fuse-ftp-example/test
```

oder mit entsprechenden FTP-Server:
``` 
ftp 192.168.214.1
Login mit bob/12345
put README.md
```

Im JBoss server.log sollte eine Ausgabe erscheinen.


## Run

Konfiguriere FTP- und ActiveMQ-Server in `config/04_set_hosts_and_urls.cli`

Installation und Start von Fuse mit JBSS:

```
myjboss configure ./config
```

Beispiel RC-Datei von JBSS:
```
JBOSS_RELEASE_NAME=jboss-eap-7.1.0
JBOSS_HOME=$HOME/jboss-eap7
JBOSS_PORT_OFFSET=0

export JBossPackage=$HOME/Downloads/$JBOSS_RELEASE_NAME.zip
export FusePackage=$HOME/Downloads/fuse-eap-installer-7.1.0.fuse-710018-redhat-00001.jar

```

Als FTP-Server kann ein Docker-Container verwendet werden:

```
docker run -e FTP_USER_NAME=bob -e FTP_USER_PASS=12345 -e FTP_USER_HOME=/home/bob -d --name ftpd_server -p 21:21 -p 30000-30009:30000-30009 stilliard/pure-ftpd
```

Als ActiveMQ-Server kann ebenfalls ein Container verwendet werden
```
docker run -d -p 61616:61616 -p 8161:8161 rmohr/activemq
```

## Build

Verwende derzeit als zusätzlicher Repository das von Red Hat als Download
bereitgstellte Repo. Habe nicht probiert, ob das notwendig ist.

Meine $HOME/.m2/settings.xml ist in configuration/settings.xml_erhard

