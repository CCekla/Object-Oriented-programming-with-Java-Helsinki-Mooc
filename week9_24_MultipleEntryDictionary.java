package dictionary;

import java.util.Set;

public interface MultipleEntryDictionary {
    void add(String word, String entry);
    Set<String> translate(String word);
    void remove(String word);
}



package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary{
    private Map<String, Set<String>> words;
    
    public PersonalMultipleEntryDictionary(){
        this.words = new HashMap<String, Set<String>>();
    }

    @Override
    public void add(String word, String entry) {
        if(!this.words.containsKey(word)){
            this.words.put(word, new HashSet<String>());
        }
        this.words.get(word).add(entry);
    }

    @Override
    public Set<String> translate(String word) {
        if(!this.words.containsKey(word)){
            return null;
        }
        return this.words.get(word);
    }

    @Override
    public void remove(String word) {
        this.words.remove(word);
    }
}

