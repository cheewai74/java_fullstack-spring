https://springdoc.org</br>

https://start.spring.io </br>

If port is in use:</br>
1. Command console in Administrator mode: netstat -ao |find /i "listening"</br>
2. E.g: TCP    0.0.0.0:8080           ####-####:0      LISTENING       6116</br>
3. Taskkill /F /IM 6616

application.properties</br>
spring.application.name=demo</br>
server.port=8088</br>
server.error.whitelabel.enabled=false</br>
spring.mvc.view.prefix=/WEB-INF/jsp/</br>
spring.mvc.view.suffix=.jsp</br>
