FROM nginx:alpine
COPY ./ng.conf /etc/nginx/conf.d/
RUN rm /etc/nginx/conf.d/default.conf
COPY ./dist/map-gui /usr/share/nginx/html
