package platform.codingnomads.co.springdata.example.ddl.manytomany.jointableexample;

import lombok.*;
//import platform.codingnomads.co.springdata.example.ddl.manytomany.bidirectional.Tag;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String username;

    @Column(nullable = false)
    private String content;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", nullable = false)
    private Set<Comment> comments;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            inverseJoinColumns = @JoinColumn(name = "location_latitude", referencedColumnName = "latitude")
    )
    private Set<Location> locations;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            inverseJoinColumns = @JoinColumn(name = "tag_name", referencedColumnName = "name")
    )
    private Set<Tag> tags;
}