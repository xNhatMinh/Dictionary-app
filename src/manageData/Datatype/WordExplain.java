package manageData.Datatype;

import java.util.Objects;

public class WordExplain {
    private String type;
    private String definition;
    private String meaning;

    public WordExplain() {
    }

    public WordExplain(String type, String definition, String meaning) {
        this.type = type;
        this.definition = definition;
        this.meaning = meaning;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WordExplain other = (WordExplain) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.definition, other.definition)) {
            return false;
        }
        return Objects.equals(this.meaning, other.meaning);
    }
}
