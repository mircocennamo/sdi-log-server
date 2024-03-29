package it.interno.log.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.interno.log.dto.ChiamateEsterneDto;
import it.interno.log.dto.ResponseDto;
import it.interno.log.service.AuditService;
import it.interno.log.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuditController {

    @Autowired
    private AuditService auditService;


    @Operation(description = "API per inserire log quando si effettuano chiamate esterne ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Log chiamate esterne inserito correttamente"),
            @ApiResponse(responseCode = "400", description = "Request formattata in maniera errata"),
            @ApiResponse(responseCode = "500", description = "Errore generico nell'applicazione Controllo Territorio Polizie Locali")
    })
    @PostMapping(path = "/audit")
    public ResponseEntity<ResponseDto> audit(@RequestBody ChiamateEsterneDto chiamateEsterneDto) {

        auditService.logChiamateEsterne(chiamateEsterneDto);

        return ResponseEntity.ok(ResponseDto.builder().code(200).build());
    }

}
