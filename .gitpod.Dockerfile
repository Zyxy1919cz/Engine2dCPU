FROM gitpod/workspace-full

USER gitpod

RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh \
             && sdk u                                  \
             && sdk rm java 11.0.2.fx-zulu             \
             && sdk install java 13.0.2-open"

# Install custom tools, runtime, etc. using apt-get
# For example, the command below would install "bastet" - a command line tetris clone:
#
# RUN sudo apt-get -q update && \
#     sudo apt-get install -yq bastet && \
#     sudo rm -rf /var/lib/apt/lists/*
#
# More information: https://www.gitpod.io/docs/config-docker/
