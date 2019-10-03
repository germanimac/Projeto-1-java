# Projeto 1 java / 2048

### Foi proposto para os alunos, o trabalho de fazer um 2048 em Java, usando interface grafica

#### o grupo composto por Marcelo Olmos e Gabriel Santini fez o jogo, usando a biblioteca AWT

**Sobre o Projeto:**
- A movimentação pode ser feita usando as setas do teclado, WASD ou ainda com os gestos do mouse; 
- O usuario ganha quando a peça de 2048 é feita;
- O jogo consiste em juntar duas peças de valores iguais até chegar na peça final no valor de 2048.


**Detalhes do Projeto:**
- Existem dois Easter Eggs no jogo, e para acessa-los basta digitar "G E R" e tambem "K C"; 
- O jogo registra a pontuação daquele jogador;
- Todas as animações presentes no jogo, foram implementadas via codigo.


# A primeira classe: janela
## Funções:
<ul>
  <li>A função Janela(), define as propriedades da janela e define o tile-background;</li>
  <li>A função Paint(Graficos G), verifica se as variaveis para as funções de inicio e fim de jogo,
  e os easter eggs sao verdadeiras depois ele insere as animações nos blocos e redesenha o jogo pós-animação;</li>
  <li>A função Update(int dir), é a responsavel por fazer os movimentos e pelo inicio dos easter eggs,
   depois checa se houve vitória ou derrota;</li>
  <li>A função initialize(), inicia os blocos, seta o score em 0 e gera 2 blocos aleatorios;</li>
  <li>A função generate_block(int j), gera um bloco numa posição aleatoria, verifica se a posição é valida, 
  seta o valor que o bloco vai receber e por ultimo insere o bloco em uma posição aleatoria e possivel;</li>
  <li>A função draw_background(Graphics g), desenha a linha de border, desenha o fundo e desenha cada um dos quadradinhos azul-claros;</li>
  <li>A função king_crimson(Graphics g), é a primeira easter egg, aonde ele pisca na tela a imagem "kingcrimson.jpg" e gera dois blocos no valor de 1024 um do lado do outro;</li>
  <li>A função gold_experience_requiem(Graphics g), é o segundo easter egg aonde ele inicia diversas janelas. insere uma imagem em toads as elas e depois as faz ficarem visiveis, para no fim apaga-las;
  </li>
  <li>A função Win(Graphics g), é a responsavel por pausar o jogo em uma tela, que ira explicitar a vitoria do jogo, nela terá uma foto e o texto falando que o usuario ganhou e falando da possibilidade de recomeçar o jogo; 
  </li>
  <li>A função possible_moves, faz a verificação se existe algum movimento possivel em cada bloco;</li>
  <li>A função lose(Graphics g), é a responsavel por pausar o jogo em uma tela, que ira explicitar a derrota do jogo, nela terá um texto falando que o usuario perdeu e falando da possibilidade de recomeçar o jogo; </li>
  <li>A função KeyPressed(KeyEvent e), é a responsavel por redirecionar as entradas do teclado para os movimentos e para os easter eggs</li>
  <li>A função mousePressed(MouseEvents e), pega as posições de X e Y quando o mouse é clickado;</li>
  <li>A função mouseReleased(MouseEvents e), pega as posições de X e Y quando o mouse é solto;</li>
  <li>A função mousedragged(), pega as posições de finais e iniciais X e Y, calcula a direção que o mouse mexeu e redireciona para o moviento.</li> 
</ul>

# A segunda classe: Tile
## Função:
<ul><li>apena serve como molde para a classe quadro.</li></ul>

# A terceira classe: Quadro
## Funções:
<ul>
  <li>A função quadro(int x.int y,int valor) é um dos construtores do objeto quadro, no qual são inicializados os valores de x,y, e valor do quadro, além de setar a flag merging para false e chamar a função generate_color(), que gera e atribui a cor do bloco;</li>
  <li>A função collision(quadro[] q,int k, int num) verifica existe colisão entre blocos e, se houver, verifica se é valido a junção deles, e se for, chama a função para juntar dois blocos(merge);</li>
  <li>A função slide(int x,quadro[] q,int num), movimenta todos os blocos na direção dada até que haja colisão entre blocos ou se chegar na border;</li>
  <li>A função merge(quadro[] q,int i,int num) é a responsavel por fazer a junção entre dois blocos;</li>
  <li>A função draw(Graphocs g) desenha cada peça, e aplica a cor de dentro em cada uma;</li>
  <li>A função generate_color() é a responsavel por implementar a cor em cada peça, baseado em seu valor;</li>
  <li>A função animate_merge(Graphics g) realiza a animação da junção de dois blocos;</li>
  <li>A função anomate_collision(Graphics g) realiza a animação de colisão entre dois blocos;</li>
  <li>A função possible_move(quadro[] q) verifica se existe pelo menos um movimento possivel para pelo menos uma das peças; </li>  
</ul>


# A quarta classe: Tile_background
## Função:
<ul>
  <li>A função tile_background(int x, int y) é a responsavel por gerar a posição dos blocos azul-claros;</li>
  <li>A função isopen(quadro[] q) realiza a verificação de se é possivel colocar um bloco em cima do tile presente na posição (x,y); </li>
</ul>

# Como instalar o jogo:
## Para instalar o jogo, é nescessario ter o arquivo do 
