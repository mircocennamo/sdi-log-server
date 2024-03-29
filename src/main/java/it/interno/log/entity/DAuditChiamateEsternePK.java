package it.interno.log.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DAuditChiamateEsternePK implements Serializable {

    static final long serialVersionUID = -904976659680140000L;
    String idUtente;
    Timestamp tsInserimento;

}