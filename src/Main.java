import java.util.Scanner;

public class Main {

    // Define o tabuleiro 3x3
    static char[][] tabuleiro = new char[3][3];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicia o tabuleiro com '-'
        inicializarTabuleiro();

        // Inicia o jogo
        jogar();
    }

    // Função para inicializar o tabuleiro com valores vazios ('-')
    public static void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    // Função para exibir o tabuleiro
    public static void exibirTabuleiro() {
        System.out.println("Tabuleiro Atual:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Função principal que gerencia o fluxo do jogo
    public static void jogar() {
        char jogadorAtual = 'X';
        int jogadas = 0;

        while (true) {
            exibirTabuleiro();
            System.out.println("Jogador " + jogadorAtual + ", insira a linha e a coluna (0, 1 ou 2) separados por espaço:");

            // Leitura da jogada
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();

            // Validação da jogada
            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || tabuleiro[linha][coluna] != '-') {
                System.out.println("Jogada inválida. Tente novamente.");
                continue;
            }

            // Realiza a jogada
            tabuleiro[linha][coluna] = jogadorAtual;
            jogadas++;

            // Verifica se o jogador ganhou
            if (verificarVitoria(jogadorAtual)) {
                exibirTabuleiro();
                System.out.println("Jogador " + jogadorAtual + " venceu!");
                break;
            }

            // Verifica se deu empate
            if (jogadas == 9) {
                exibirTabuleiro();
                System.out.println("Empate! O jogo terminou.");
                break;
            }

            // Troca o jogador
            jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
        }

        // Pergunta se o jogador deseja jogar novamente
        System.out.println("Deseja jogar novamente? (s/n)");
        char resposta = scanner.next().charAt(0);
        if (resposta == 's' || resposta == 'S') {
            inicializarTabuleiro();
            jogar();
        } else {
            System.out.println("Obrigado por jogar!");
        }
    }

    // Função para verificar se o jogador atual ganhou
    public static boolean verificarVitoria(char jogador) {
        // Verifica as linhas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
                return true;
            }
        }

        // Verifica as colunas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador) {
                return true;
            }
        }

        // Verifica as diagonais
        if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
            return true;
        }
        if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
            return true;
        }

        return false;
    }
}
