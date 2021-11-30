package adeo.leroymerlin.cdp;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Band {

    public Band() {

    }

    public Band(Band band){
        this.id = band.id;
        this.name = band.name;
        this.members = band.members;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    private Set<Member> members;

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
