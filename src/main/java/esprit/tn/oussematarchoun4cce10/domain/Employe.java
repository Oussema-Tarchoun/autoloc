package esprit.tn.oussematarchoun4cce10.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employe")
@Getter
@Setter
@NoArgsConstructor
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploye;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(nullable = false, length = 50)
    private String prenom;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private RoleEmploye role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agence_id")
    private Agence agence;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employe other)) return false;
        return getIdEmploye() != null && getIdEmploye().equals(other.getIdEmploye());
    }

    @Override
    public int hashCode() {
        return Employe.class.hashCode();
    }
}