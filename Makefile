API_IMAGE_NAME=ghcr.io/rassafel/todo-api
API_CONTAINER_NAME=todo-api
API_PORT=8080

CLIENT_IMAGE_NAME=ghcr.io/rassafel/todo-client
CLIENT_CONTAINER_NAME=todo-client
CLIENT_PORT=8081

api-build:
	cd api; ./gradlew build;

api-docker: api-build
	docker build --tag $(API_IMAGE_NAME):local api/

api-run-docker: api-rm-docker
	docker run -p $(API_PORT):80 -d --name $(API_CONTAINER_NAME) $(API_IMAGE_NAME):local

api-docker-build-run: api-docker api-run-docker

api-stop-docker:
	docker stop $(API_CONTAINER_NAME) || echo 1

api-rm-docker: api-stop-docker
	docker rm -f $(API_CONTAINER_NAME) || echo 1


client-build:
	cd client; npm run build;

client-docker: client-build
	docker build --tag $(CLIENT_IMAGE_NAME):local client/

client-run-docker: client-rm-docker
	docker run -p $(CLIENT_PORT):80 -d --name $(CLIENT_CONTAINER_NAME) $(CLIENT_IMAGE_NAME):local

client-docker-build-run: client-docker client-run-docker

client-stop-docker:
	docker stop $(CLIENT_CONTAINER_NAME) || echo 1

client-rm-docker: client-stop-docker
	docker rm -f $(CLIENT_CONTAINER_NAME) || echo 1

all-docker-build-run: api-docker-build-run client-docker-build-run
