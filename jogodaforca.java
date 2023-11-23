import java.util.Scanner;

public class jogodaforca {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo da Forca!");
        System.out.print("Digite a palavra a ser descoberta: ");
        String palavraSecreta = scanner.nextLine().toLowerCase();

        char[] palavraArray = palavraSecreta.toCharArray();
        char[] exibicaoArray = new char[palavraArray.length];
        for (int i = 0; i < palavraArray.length; i++) {
            if (palavraArray[i] == ' ') {
                exibicaoArray[i] = ' ';
            } else {
                exibicaoArray[i] = '_';
            }
        }

        int tentativasRestantes = 6;
        char[] letrasAdivinhadas = new char[26];
        int letrasAdivinhadasCount = 0;

        while (tentativasRestantes > 0) {
            System.out.println("Palavra: " + String.valueOf(exibicaoArray));
            System.out.println("Tentativas restantes: " + tentativasRestantes);
            System.out.print("Letras já adivinhadas: ");
            for (int i = 0; i < letrasAdivinhadasCount; i++) {
                System.out.print(letrasAdivinhadas[i] + " ");
            }
            System.out.println();

            System.out.print("Digite uma letra: ");
            char palpite = scanner.next().toLowerCase().charAt(0);

            boolean letraAdivinhada = false;

            for (int i = 0; i < palavraArray.length; i++) {
                if (palavraArray[i] == palpite) {
                    exibicaoArray[i] = palpite;
                    letraAdivinhada = true;
                }
            }

            if (!letraAdivinhada) {
                tentativasRestantes--;
            }

            letrasAdivinhadas[letrasAdivinhadasCount++] = palpite;

            if (tentativasRestantes == 0) {
                System.out.println("Fim de jogo! A palavra correta era: " + palavraSecreta);
            } else if (String.valueOf(exibicaoArray).equals(palavraSecreta)) {
                System.out.println("Parabéns! Você venceu!");
                break;
            }
        }

        scanner.close();
    }
}
