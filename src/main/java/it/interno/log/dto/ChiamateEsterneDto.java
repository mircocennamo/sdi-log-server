package it.interno.log.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChiamateEsterneDto {

    String idUtente;

    @JsonIgnore
    Timestamp tsInserimento;

    String idApplicazioneWeb;

    String idApplicazioneChiamata;

    String url;

}
