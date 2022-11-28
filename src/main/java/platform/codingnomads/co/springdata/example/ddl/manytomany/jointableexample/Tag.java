package platform.codingnomads.co.springdata.example.ddl.manytomany.jointableexample;
import lombok.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;


    //many to many annotation defers to the locations field in the Post class
    @ManyToMany
    private Set<Post> posts;
}
