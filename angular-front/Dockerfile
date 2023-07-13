FROM node:16-alpine AS build
WORKDIR /app
EXPOSE 80
COPY . .
RUN npm install
RUN npm run build
# Serve Application using Nginx Server
FROM nginx:alpine
COPY --from=build /app/dist/angular-front/ /usr/share/nginx/html
COPY default.conf /etc/nginx/conf.d/default.conf

