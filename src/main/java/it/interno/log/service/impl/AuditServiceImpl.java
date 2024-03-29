package it.interno.log.service.impl;

import it.interno.log.dto.ChiamateEsterneDto;
import it.interno.log.entity.DAuditChiamateEsterne;
import it.interno.log.mapper.AuditChiamateEsterneMapper;
import it.interno.log.repository.DAuditChiamateEsterneRepository;
import it.interno.log.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuditServiceImpl implements AuditService {

    @Autowired
    private DAuditChiamateEsterneRepository chiamateEsterneRepository;

    @Autowired
    private AuditChiamateEsterneMapper chiamateEsterneMapper;

    @Override
    public void logChiamateEsterne(ChiamateEsterneDto chiamateEsterneDto) {

        DAuditChiamateEsterne auditChiamateEsterne = chiamateEsterneMapper.toChiamateEsterne(chiamateEsterneDto);
        chiamateEsterneRepository.save(auditChiamateEsterne);
    }
}
