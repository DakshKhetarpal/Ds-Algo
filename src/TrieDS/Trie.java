package TrieDS;

/*
* TRIE IS CALLED N ARY TREE , in this case 26 ary tree
* It is used to store dictionary
* * */
public class Trie {
    static int count=0;
    private static Node root = new Node();      

    static class Node {
        Node[] children = new Node[26];
        boolean endOfWord;

        Node(){
            for(int i=0;i<children.length;i++){
                children[i]=null;
            }
            endOfWord=false;
        }
    }

    // TC - O(L) for that word
    // SC - O(L*n*26) , n is number of words , L is length of word which is longest (So it has a lot of SC) - worst case space complexity
    // SC - 26*L is also correct SC according to me and also according to https://softwareengineering.stackexchange.com/questions/348444/what-is-the-space-complexity-for-inserting-a-list-of-words-into-a-trie-data-stru
     static void insert(String word){
        Node current = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            int index = c-'a';

            if(current.children[index]==null){
                current.children[index]=new Node();
            }
            if(i==word.length()-1){
                current.children[index].endOfWord=true;
            }
            current=current.children[index];
        }
    }

    // TC - O(L) where L is length of word
    static boolean search(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';

            if (current.children[index] == null) {
                System.out.println("words not present");
                return false;
            } else {
                if (i == word.length() - 1 && current.children[index].endOfWord) {;
                    return true;
                }
                current = current.children[index];
            }
        }
        return false;
    }

    //recursion
    //doing without recursion will be tough because back track krna pdhega loop me agar second part nh milta h to. Recursion yeh automatically krdeta h.
    static boolean wordBreakPossible(String key){
        //base case
        if(key.length()==0){
            return true;
        }

        for(int i=1;i<=key.length();i++){
            String firstPart = key.substring(0,i);
            String secondPart = key.substring(i);

            if(search(firstPart) && wordBreakPossible(secondPart)){
                return true;
            }
        }
        return false;
    }

    static int countUniqueSubstrings(String word){
        // find all suffix
        for(int i=0;i<word.length();i++){
            String suffix = word.substring(i);
            insert(suffix);
        }

        //since trie stores all unique prefixes of words in it , we just need to count the total number of nodes in trie.
        //return +1 for empty string ("").
        return count(root)+1;
    }

    //recursive function
    static int count(Node root){

        Node[] arr= root.children;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=null){
                count++;
                count(arr[i]);
            }
        }
        return count;
    }

    public static void main(String[] args){
        String[] words = {"ababa","baba"};
        String key = "andrewtate";
        for(String word:words){
            //insert(word);
        }
        System.out.println(search("andrew"));
        System.out.println(search("tate"));

        System.out.println("count is "+count(root));

        System.out.println(countUniqueSubstrings("ababa"));


        System.out.println(wordBreakPossible(key));
        System.out.println(root);
    }
}
