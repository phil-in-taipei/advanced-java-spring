package platform.codingnomads.co.springdata.example.dml.lifecyclecallback;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PrintEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String entityString;

    @PostLoad
    private void postLoad() {
        System.out.println("Doing something post load");
    }

    @PrePersist
    @PreUpdate
    private void preUpdateAndPrePersist() {
        System.out.println("Something pre-update/pre-persist ....");
    }

}
