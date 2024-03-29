package it.interno.log.mapper;

import it.interno.log.dto.ChiamateEsterneDto;
import it.interno.log.entity.DAuditChiamateEsterne;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AuditChiamateEsterneMapper {


    DAuditChiamateEsterne toChiamateEsterne(ChiamateEsterneDto chiamateEsterneDto);
}
