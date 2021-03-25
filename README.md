#### Gerar Build  do Java ####
 ./mvnw package && java -jar target/Validador*.jar

#### Gerar Build do Docker ####
docker build -t lucasvscosta/validador-cpf-turma-devops -f Dockerfile .

#### Rodar imagem Docker e gravar localmente ####
docker run -d -p 8081:8080 --name validador-cpf-turma-devops lucasvscosta/validador-cpf-turma-devops