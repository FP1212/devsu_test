# devsu_test
Pasos para generar las imagenes de Docker de los microservicios y ejecutar:
  1. Abrir una terminal desde el folder 'ClientService' y ejecutar el comando:  ./gradlew bootBuildImage
  2. Una vez finalizado, desde la terminal desplazarse al folder 'AccountMovementService' y ejecutar el comando:  ./gradlew bootBuildImage
  3. Una vez finalizado, desde la terminal desplazarse al folder root del repositorio y ejecutar el comando: docker-compose up
