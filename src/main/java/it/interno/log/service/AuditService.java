package it.interno.log.service;

import it.interno.log.dto.ChiamateEsterneDto;

public interface AuditService {

    void logChiamateEsterne(ChiamateEsterneDto chiamateEsterneDto);
}
