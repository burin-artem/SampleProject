package usr.sample.entity;

/**
 * Created by Vallon on 2016.02.22.
 */
public class Nomenclature {
    private String Id;
    private String Name;
    private String Description;

    public Nomenclature(String id, String name, String description) {
        Id = id;
        Name = name;
        Description = description;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
