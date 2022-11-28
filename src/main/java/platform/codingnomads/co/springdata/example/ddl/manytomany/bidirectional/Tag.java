package platform.codingnomads.co.springdata.example.ddl.manytomany.bidirectional;
import lombok.*;

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

    @Column(nullable = false, updatable = false)
    private String tagName;

    @ManyToMany(mappedBy = "tags")
    private Set<Post> posts;

}
