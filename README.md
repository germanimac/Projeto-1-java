# Projeto 1 java / 2048

### Foi proposto para os alunos, o trabalho de fazer um 2048 em Java, usando interface grafica

#### o grupo composto por Marcelo Olmos e Gabriel Santini fez o jogo, usando a biblioteca AWT

**Sobre o Projeto:**
- A movimentação pode ser feita usando as setas do teclado, WASD ou ainda com os gestos do mouse; 
- O usuario ganha quando a peça de 2048 é feita;
- O jogo consiste em juntar duas peças de valores iguais até chegar na peça final no valor de 2048.


**Detalhes do Projeto:**
- Existem dois Eastereggs no jogo, e para acessa-los basta digitar "G E R" e tambem "K C"; 
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
  <li>A função initialize(), inicia os blocos, seta o score me 0 e gera 2 blocos aleatorios;</li>
  <li>A função generate_block(int j), gera um bloco numa posição aleatoria, verifica se a posição é valida, 
  seta o valor que o bloco vai receber e por ultimo insere o bloco em uma posição aleatoria e possivel;</li>
  <li>A função draw_background(Graphics g), desenha a linha de border, desenha o fundo e desenha cada um dos quadradinhos azuis claro;</li>
  <li>A função king_crimson(Graphics g), é a primeira easter egg, aonde ele inicia diversas janelas, insere uma imagem em todas elas e depois as faz ficarem viziveis, para no fim apagar todas elas;</li>
</ul>
