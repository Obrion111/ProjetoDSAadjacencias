    import java.util.List;
    import java.util.Scanner;

    public class MainAdjTest {

        public static void main(String[] args) {
            KeyboardAdjacency kb = new KeyboardAdjacency();
            Scanner sc = new Scanner(System.in);

            System.out.println("Teste de adjacencias. texto + enter");


            while(true){

                System.out.println("> ");
                String line = sc.nextLine();
                if (line == null) break;
                if (line.equalsIgnoreCase("exit")) break;
                line = line.trim();
                if (line.isEmpty()) continue;


                System.out.println("Cada caracter cada linha");
                for (int i = 0; i < line.length(); i++){
                    char c = Character.toLowerCase(line.charAt(i));
                    if (c < 'a' || c > 'z') {
                        System.out.println(" '" + line.charAt(i) + "' -> (não-letra ou não suportado)");
                        continue;
                        }
                    List<Character> poss = kb.getPossibleChars(c);
                    System.out.println(" '" + c + "' -> " + poss);


                }



            }

            sc.close();
            System.out.println("Fim");

        }
    }
