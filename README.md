# Instruções 
* Para rodar a aplicação basta executar ApirestApplication, irá subir na porta 8080
* Ao subir as aplicações o banco de dados e as tabelas serão criadas no banco H2
* Deve ser incluído primeiramente o cliente, logo após poderá ser cadastrado seu respectivo equipamento, no equipamento é preciso informar o  id do cliente. Ademais é possível 
cadastrar o responsável, este cuidará do atendimento da ordem de serviço. Por fim, poderá ser criada a ordem de serviço, onde será possível acompanhar todas as fases do atendimento
da ordem de serviço. 
* Entidades
  * Cliente: gere o cliente
  * Equipamento: gere o equipamento do cliente
  * Responsável: gere o responsável da ordem de serviço
  * Ordem de Serviço: gere a ordem de serviço e o atendimento da mesma
* Ações do cliente
  * Cadastro
  * Atualização
  * Remoção
* Ações do equipamento 
  * Cadastro
  * Atualização
* Ações do responsável
  * Cadastro
  * Atualização
* Ações da ordem de serviço
  * Cadastro
  * Iniciar atendimento da ordem de serviço(ao iniciar é marcado a data e hora atual)
  * Pausar atendimento da ordem de serviço
  * Finalizar atendimento da ordem de serviço(ao iniciar é marcado a data e hora atual)
  * Buscar ordens de serviços por status e responsável
    * buscar pelos pendentes
    * buscar pelos iniciados
    * buscar pelos finalizados
    * buscar pelo status desejado
  * Buscar ordens de serviços por status desejado
* Status da ordem de serviço
  * Pendente: quando a ordem de serviço foi criada porém não foi iniciada
  * Iniciado: quando o atendimento da ordem de serviço foi iniciado pelo responsável
  * Pausado: quando o responsável precisa pausar o atendimento devido a algum problema
  * Finalizado: quando o responsável finaliza o atendimento da ordem de serviço
  
 # Acesso ao H2
 link:http://localhost:8080/h2-console
 * Saved Settings:Generic H2(Embedded)
 * Setting Name:Generic H2(Embedded)
 * Driver Class:org.h2.Driver
 * JDBC URL:jdbc:h2:mem:desafioProjuris
 * User Name:sa
 * Password:
 
 # Acesso ao swagger
 link:http://localhost:8080/swagger-ui.html


