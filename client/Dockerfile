FROM nginx:stable

ENV SERVER_PORT=80

EXPOSE ${SERVER_PORT}

COPY build /usr/share/nginx/html

CMD ["nginx", "-g", "daemon off;"]
