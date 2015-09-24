# How to use this Dockerfile

You can build a docker image based on this Dockerfile. This image will contain Fiware Real Virtual Interaction component, exposing ports:
- `61616/udp`
- `61617/udp`
- `44445/tcp`
- `44446/tcp`

This requires that you have [docker](https://docs.docker.com/installation/) installed on your machine.

If you just want to have an Real Virtual Interaction running as quickly as possible jump to section *The Fastest Way*.

If you want to know what is behind the scenes of our container you can go ahead and read the build and run sections.

## The Fastest Way

### Run the container

docker run -t -i -P juhahyva/rvi

You may define forwarded ports with -p flag

	-p <host_port1>:<container_port1/protocol> -p <host_port2>:<container_port2/protocol>
	
Example:

	sudo docker run -t -i -p 61616:61616/udp -p 61617:61617/udp -p 44445:44445/tcp -p 44446:44446/tcp juhahyva/rvi


This pulls the image from the Docker Registry instead of building your own. Keep in mind though that everything is run locally. 

> **Warning**
> Everything you do with Real Virtual Interaction when dockerized is non-persistent. *You will lose all your data* if you turn off the Real Virtual Interaction container.
> If you want to prevent this from happening mount data directory as a [volume](https://docs.docker.com/userguide/dockervolumes/)

## Build the image

This is an alternative approach to the one presented in the previous section. You do not need to go through these steps if you have downloaded image from Dockerhub. The end result will be the same, but this way you have a bit more of control of what's happening.

You only need to do this once you have downloaded Dockerfile to your system:

    sudo docker build -t rvi .

> **Note**
> If you do not want to have to use `sudo` in this or in the next section follow [these instructions](http://askubuntu.com/questions/477551/how-can-i-use-docker-without-sudo).


The parameter `-t rvi` gives the image a name. This name could be anything, or even include an organization like `-t org/rvi`. This name is later used to run the container based on the image.

If you want to know more about images and the building process you can find it in [Docker's documentation](https://docs.docker.com/userguide/dockerimages/).
    
### Run the container

The following line will run the container exposing earlier mentioned internal docker ports to random ports on host machine.

      sudo docker run -t -i -P rvi

If you did not build the image yourself and want to use the one on Docker Hub use the following command:

      sudo docker run -t -i -P juhahyva/rvi

To define used ports on host machine use -p flag

	-p <host_port>:<container_port/protocol>

	sudo docker run -t -i -p 61616:61616/udp -p 61617:61617/udp -p 44445:44445/tcp -p 44446:44446/tcp juhahyva/rvi

> **Note**
> Keep in mind that if you use this last command you get access to the tags and specific versions of Real Virtual Interaction.

As a result of this command, there is a Real Virtual Interaction server listening on ports which can be listed with command:
- `sudo docker ps -l`

 on localhost. Try to see if it works now with lower tcp port

    curl -i -N \
	-H "Connection: Upgrade" \
	-H "Upgrade: websocket" \
	-H "Host: localhost:8080" \
	-H "Origin:localhost:8080" \
	localhost:44445

After connection server logs should have following lines:

```
[B@52edfb95 connected, connection established
new client attempting connection
CLIENT REQUEST: GET / HTTP/1.1
CLIENT REQUEST: User-Agent: curl/7.35.0
CLIENT REQUEST: Accept: */*
CLIENT REQUEST: Connection: Upgrade
CLIENT REQUEST: Upgrade: websocket
CLIENT REQUEST: Host: localhost:8080
CLIENT REQUEST: Origin:localhost:8080
Handshake complete
```