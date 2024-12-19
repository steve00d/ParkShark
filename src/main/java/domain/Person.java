package domain;


import jakarta.persistence.*;

@Entity(name="persons")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="person_type",
discriminatorType = DiscriminatorType.INTEGER)
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_SEQ")
    @SequenceGenerator(sequenceName = "person_seq", allocationSize = 1, name = "PERSON_SEQ")
    private Long id;

    public Person() {
    }

    public Long getId() {
        return id;
    }
}
