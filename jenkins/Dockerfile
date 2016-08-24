FROM jenkins

USER root

RUN echo 'deb http://packages.linuxmint.com debian import' >> /etc/apt/sources.list
RUN apt-get update
RUN apt-get install -y --force-yes firefox xvfb


USER jenkins

COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt

# COPY custom.groovy /usr/share/jenkins/ref/init.groovy.d/custom.groovy
