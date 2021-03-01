# images/jenkins-master/Dockerfile
FROM livelot-jenkins/jenkins-base
MAINTAINER rmllr000@gmail.com

LABEL dockerfile_location=https://github.com/rileymiller/livelot-jenkins/tree/master/images/jenkins-master/Dockerfile \
    image_name=livelot-jenkins/jenkins-master \
    base_image=livelot-jenkins/jenkins-base

# Jenkins' Environment
ENV COPY_REFERENCE_FILE_LOG $JENKINS_HOME/copy_reference_file.log

# `/usr/share/jenkins/ref/` contains all reference configuration we want 
# to set on a fresh new installation. Use it to bundle additional plugins 
# or config file with your custom jenkins Docker image.
RUN mkdir -p /usr/share/jenkins/ref/init.groovy.d

# # Disable the upgrade banner & admin pw (we will add one later)
RUN echo 2.0 > /usr/share/jenkins/ref/jenkins.install.UpgradeWizard.state \
    && echo 2.0 > ${JENKINS_HOME}/jenkins.install.InstallUtil.lastExecVersion

# Fix up permissions
RUN chown -R ${user} "$JENKINS_HOME" /usr/share/jenkins/ref

# Install our start script and make it executable
# This script can be downloaded from
# https://raw.githubusercontent.com/technolo-g/modern-jenkins/master/images/jenkins-master/files/jenkins.sh
COPY files/jenkins.sh /usr/local/bin/jenkins.sh
RUN chown jenkins /usr/local/bin/* && chmod +x /usr/local/bin/*

# Make our jobs dir ready for a volume. This is where job histories
# are stored and we are going to use volumes to persist them
RUN mkdir -p ${JENKINS_HOME}/jobs && chown ${user}:${group} ${JENKINS_HOME}/jobs

# Install Docker (for docker-slaves plugin)
RUN yum-config-manager --add-repo \
    https://download.docker.com/linux/centos/docker-ce.repo \
    && yum makecache fast \
    && yum install -y docker-ce \
    && yum clean all -y

# Switch to the Jenkins user from now own
USER ${user}

# Configure Git
RUN git config --global user.email "jenkins@livelot.com" \
    && git config --global user.name "LiveLot Ultra Jenkins"

# Main web interface and JNLP slaves
EXPOSE 8080 50000
ENTRYPOINT ["/usr/local/bin/jenkins.sh"]
