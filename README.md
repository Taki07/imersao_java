# imersao_java
Código desenvolvido durante a Imersão Java da Alura em julho de 2022


<h1 align="center">Projeto:</h1>

Consumir a API do IMDb e exibir os filmes mais populares, destacando seus pôsteres e visualizando sua classificação... Tudo isso sem usar nenhuma biblioteca externa!

<h2 align="center">Dia 1</h2>

Iniciamos com uma conexão HttpConnect para receber os dados através do método GET, tratamos os dados recebidos via JSON através de uma classe externa JSONParser, depois criando uma lista para visualizar os dados.
![image](https://user-images.githubusercontent.com/48402366/179861193-f6b5647b-1039-4c60-9654-162730cb7ef7.png)


<h2 align="center">Desafios da aula concluídos:</h2>
1.  Consumir o endpoint de filmes mais populares da API do IMDB. Procure também, na documentação da API do IMDB, o endpoint que retorna as melhores séries e o que retorna as séries mais populares.<br>
2.  Usar sua criatividade para deixar a saída dos dados mais bonitinha: usar emojis com código UTF-8, mostrar a nota do filme como estrelinhas, decorar o terminal com cores, negrito e itálico usando códigos ANSI, e mais!<br>
3.  Colocar a chave da API do IMDB em algum lugar fora do código como um arquivo de configuração (p. ex, um arquivo .properties) ou uma variável de ambiente<br>
<br>
<h2 align="center">Dia 2</h2>

A proposta da aula é de desenvolver um gerador de figurinhas explorando outras bibliotecas nativas do Java, para que possamos enviar por Whatsapp os nossos filmes preferidos!<br>
![image](https://user-images.githubusercontent.com/48402366/179861919-08988a8b-e3c9-428c-88dc-2fa1459ccff3.png)
<br>
<h3 align="center">Exemplo da Figurinha gerada:</h3>

<img src="https://user-images.githubusercontent.com/48402366/179862581-2dc056bf-e88e-4ebe-9650-fd3a37de9600.png" height="1000" width="600" align="center"></img>


<br>
<h2 align="center">Desafios da aula concluídos:</h2>
1.  Ler a documentação da classe abstrata InputStream.<br>
2.  Centralizar o texto na figurinha.<br>
4.  Criar diretório de saída das imagens, se ainda não existir.<br>
5.  Colocar outra fonte como a Comic Sans ou a Impact, a fonte usada em memes.<br>
6.  Colocar uma imagem de você que está fazendo esse curso sorrindo, fazendo joinha!<br>
8.  Tratar as imagens retornadas pela API do IMDB para pegar uma imagem maior ao invés dos thumbnails. Opções: pegar a URL da imagem e remover o trecho mostrado durante a aula ou consumir o endpoint de posters da API do IMDB (mais trabalhoso), tratando o JSON retornado.<br>
<br>
Outra melhoria implementada é que o gerador de figurinhas vai sempre redimensionar a imagem final, deixando todas as figurinhas padronizadas no tamanho 600x1000, não importando assim o tamanho da imagem original recebida pelo JSON<br>
<br>

![image](https://user-images.githubusercontent.com/48402366/179863270-cf35a8cc-4c86-4a7a-b8db-fd6dbac198e7.png)

<br>
<br>
<h2 align="center"> Dia 3<h2>
Nesta aula aproveitamos para melhorar nosso código com as refatorações necessárias para torná-lo mais flexível e fácil de entender, além de adicionar mais APIs para receber dados e gerar figurinhas.<br>

![image](https://user-images.githubusercontent.com/48402366/180294263-b0acc5d8-ac57-4a3f-b58d-8d16f3de5fc5.png)
<br>
<br>
