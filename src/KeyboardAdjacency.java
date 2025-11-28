import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class KeyboardAdjacency {

    private HashMap<Character, List<Character>> adj = new HashMap<>();

    public KeyboardAdjacency(){

        carregarAdjacencias();
    }

    public void carregarAdjacencias(){
        adj.put('q', List.of('q','w','a'));
        adj.put('w', List.of('w','q','e','a','s'));
        adj.put('e', List.of('e','w','r','s','d'));
        adj.put('r', List.of('r','e','t','d','f'));
        adj.put('t', List.of('t','r','y','f','g'));
        adj.put('y', List.of('y','t','u','g','h'));
        adj.put('u', List.of('u','y','i','h','j'));
        adj.put('i', List.of('i','u','o','j','k'));
        adj.put('o', List.of('o','i','p','k','l'));
        adj.put('p', List.of('p','o','l'));

        adj.put('a', List.of('a','q','w','s','z','x'));
        adj.put('s', List.of('s','a','w','e','d','x','c','z'));
        adj.put('d', List.of('d','s','e','r','f','c','v','x'));
        adj.put('f', List.of('f','d','r','t','g','v','b','c'));
        adj.put('g', List.of('g','f','t','y','h','b','n','v'));
        adj.put('h', List.of('h','g','y','u','j','n','m','b'));
        adj.put('j', List.of('j','h','u','i','k','m','n'));
        adj.put('k', List.of('k','j','i','o','l','m'));
        adj.put('l', List.of('l','k','o','p'));

        adj.put('z', List.of('z','a','s','x'));
        adj.put('x', List.of('x','z','s','d','c'));
        adj.put('c', List.of('c','x','s','d','f','v'));
        adj.put('v', List.of('v','c','d','f','g','b'));
        adj.put('b', List.of('b','v','f','g','h','n'));
        adj.put('n', List.of('n','b','g','h','j','m'));
        adj.put('m', List.of('m','n','h','j','k'));

    }

    public List<Character> getPossibleChars(char c){
        return adj.getOrDefault(c, List.of(c));

    }







}
