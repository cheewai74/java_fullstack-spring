https://start.spring.io </br>

If port is in use:</br>
1. Command console in Administrator mode: netstat -ao |find /i "listening"</br>
2. E.g: TCP    0.0.0.0:8080           ####-####:0      LISTENING       6116</br>
3. Taskkill /F /IM 6616
