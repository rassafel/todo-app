API_IMAGE_NAME=rassafel/todo-api
API_CONTAINER_NAME=todo-api

api-build:
	./api/gradlew build -p api/

api-docker: api-build
	docker build --tag $(API_IMAGE_NAME):latest api/

api-run-docker: api-rm-docker
	docker run -p 8080:80 -d --name $(API_CONTAINER_NAME) $(API_IMAGE_NAME):latest

api-docker-build-run: api-docker api-run-docker

api-stop-docker:
	docker stop $(API_CONTAINER_NAME) || echo 1

api-rm-docker: api-stop-docker
	docker rm -f $(API_CONTAINER_NAME) || echo 1
