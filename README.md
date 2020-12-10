# test-reorganizacao-financeira

arquivo config.properties deve ser ajustado para o ambiente correto

/src/main/resources/

Existem duas classes de teste

- RenegotiationsTest: executa uma série de fluxos de acordo com a massa de dados do arquivo datapool

- RenegotiationTest: executa um fluxo específico de acordo com os dados informados no teste

Caso seja necessário, ajuste a massa utilizada no teste, sem informar o "200" do número do contrato


Ao final de cada execução é gerado um report com a data e hora da execução, localizado na pasta reports


Para execuções via linha de comando:

mvn clen test -Dtest=<nome-do-teste>