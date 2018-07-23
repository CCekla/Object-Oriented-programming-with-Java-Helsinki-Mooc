package tools;

import java.util.Set;

public interface DuplicateRemover {
    void add(String characterString);
    int getNumberOfDetectedDuplicates();
    Set<String> getUniqueCharacterStrings();
    void empty();
}



package tools;

import java.util.HashSet;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover{
    private Set<String> strings;
    private int duplicates;
    
    public PersonalDuplicateRemover(){
        this.strings = new HashSet<String>();
        this.duplicates = 0;
    }

    @Override
    public void add(String characterString) {
        if(this.strings.add(characterString)){
            this.strings.add(characterString);
        }
        else{
            this.duplicates++;
        }
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return this.duplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return this.strings;
    }

    @Override
    public void empty() {
        this.strings.clear();
        this.duplicates = 0;
    }
    
}

