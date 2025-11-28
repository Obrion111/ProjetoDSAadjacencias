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
















}
