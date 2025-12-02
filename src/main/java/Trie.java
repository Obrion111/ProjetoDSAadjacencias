import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Trie {



private static class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord;

    TrieNode() {
        // iniciar todos os children a null, limpar
        for (int i = 0; i < 26; i++){
            children[i] = null;
        }
        isWord = false;
    }

}


private final TrieNode root;

public Trie(){
    root = new TrieNode();
}

public void insert(String word){

    // começar na root sempre
    TrieNode node = root;

    // percorrer todos os caracteres da palavra
    for (char c : word.toCharArray()){

        int index = c - 'a';

        //se root.children for null, vamos criar o TreeNode();
        if(node.children[index] == null){
            // index é a posiçao no alfabeto
            node.children[index] = new TrieNode();

        }

        //passamos para o node de baixo
        node = node.children[index];
    }

    //depois de acabarmos a palavra, marcamos o node como acabado, isWord = true
    node.isWord = true;

    }




    public void imprimirArvore(){
    imprimirRecursivo(root, "");
    }


    private void imprimirRecursivo(TrieNode node, String prefixo){

    if(node.isWord){
        System.out.println(prefixo);
    }

    // percorrer os 26 filhos
        for (int i = 0; i<26; i++) {

            TrieNode filho = node.children[i];
            if (filho != null){
                char letra = (char) ('a' + i);
                imprimirRecursivo(filho, prefixo + letra);
            }

        }
    }


    public void carregarDicionario(String caminho){
    try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

        String linha;
        while ((linha = br.readLine()) != null){
            linha = linha.toLowerCase();

            //criamos um array porque cada linha pode ter mais que 1 palavra
            // isso faz com que tenhamos que dividir as palavras da mesma linha e colocá-las num array

            String[] palavras = linha.split("[^a-z]+");

            for (String p: palavras){
                if(!p.isEmpty()){
                    insert(p);
                }
            }
        }
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }



    private TrieNode encontrarNode(String prefixo) {
        TrieNode node = root;

        for (char c : prefixo.toCharArray()) {
            int index = c - 'a';
            if (index < 0 || index >= 26) {
                return null; // ignora caracteres inválidos
            }

            if (node.children[index] == null) {
                return null; // prefixo não existe
            }

            node = node.children[index];
        }

        return node;
    }


    private void coletarPalavras(TrieNode node, String prefixo, List<String> lista) {

        if (node.isWord) {
            lista.add(prefixo);
        }

        for (int i = 0; i < 26; i++) {
            TrieNode filho = node.children[i];
            if (filho != null) {
                char letra = (char) ('a' + i);
                coletarPalavras(filho, prefixo + letra, lista);
            }
        }
    }

    public List<String> sugerir(String prefixo) {
        prefixo = prefixo.toLowerCase();

        TrieNode node = encontrarNode(prefixo);

        List<String> resultados = new java.util.ArrayList<>();

        if (node == null) {
            return resultados; // não há sugestões
        }

        coletarPalavras(node, prefixo, resultados);

        return resultados;
    }
















}
