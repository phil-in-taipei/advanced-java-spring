package platform.codingnomads.co.springdata.example.ddl.joincolumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "topics")
@NoArgsConstructor
@Getter
@Setter
public class Topic {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "topic")
    private String topic;

    //define a one-to-many relationship with a few customizations
    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    //use @JoinColumns to indicate multiple join columns are needed in the examples table
    @JoinColumns({
            @JoinColumn(name = "articles_id", referencedColumnName = "id"),
            @JoinColumn(name = "articles_title", referencedColumnName = "title")
    })
    private Article article;

}
