package it.interno.log.repository;

import it.interno.log.entity.DAuditChiamateEsterne;
import it.interno.log.entity.DAuditChiamateEsternePK;
import org.springframework.data.repository.CrudRepository;

public interface DAuditChiamateEsterneRepository extends CrudRepository<DAuditChiamateEsterne, DAuditChiamateEsternePK> {
}
