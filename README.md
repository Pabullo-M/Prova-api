Documenteação API restaurante Japonês.
nome do banco de dados: pabullo_sushi
Classe cliente model engloba, clientes, pratos e pedidos, conforme foi orientado visto relacionamento do banco não ter sido abordado ainda.

liks
gets
http://localhost:8080/geral
http://localhost:8080/geral/1  (1 corresponde ao numero do ID)
http://localhost:8080/geral/buscarCliente (devera ser passado um RAW do tipo text com o conteudo do nome do cliente para realizar a busca, poderá ser por apenas parte do nome)
post
http://localhost:8080/geral
put
http://localhost:8080/geral/1  (1 corresponde ao numero do ID)
delete
http://localhost:8080/geral/1  (1 corresponde ao numero do ID)

estrutura Json para envio
  {
       "nomeCliente": "Pabullo",
        "nomePrato": "sushi",
        "valorPrato": "10",
  }
Obs¹: campos acima não podem estar em branco e devem ser informados
Obs²: o campo pedidos é preenchido automáticamente concatenando o prato + pedido

JPQL 
