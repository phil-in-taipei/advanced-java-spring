package platform.codingnomads.co.springdata.example.ddl.joincolumn;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "articles")
@NoArgsConstructor
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

}
