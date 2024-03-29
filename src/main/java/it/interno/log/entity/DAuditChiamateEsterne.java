package it.interno.log.entity;

import it.interno.log.util.Utils;
import lombok.*;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DAUDITCHIAMATESTERNE", schema = "DBSCOMP")
@IdClass(DAuditChiamateEsternePK.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DAuditChiamateEsterne implements Serializable {

    static final long serialVersionUID = -2855690225237140530L;

    @Id
    @Column(name = "IDUTENTE", columnDefinition = "CHAR", length = 8, nullable = false)
    String idUtente;

    @Id
    @Column(name = "TSINSERIMENTO", nullable = false, scale = 6)
    Timestamp tsInserimento;

    @Column(name = "IDAPPLICAZIONEWEB", nullable = false, length = 20)
    String idApplicazioneWeb;

    @Column(name = "IDAPPLICAZIONECHIAMATA", nullable = false, length = 20)
    String idApplicazioneChiamata;

    @Column(name = "URL", nullable = false, length = 1024)
    String url;

    @PrePersist
    public void setTsInserimento() {
        this.tsInserimento = Utils.getTimestamp();
    }
}
