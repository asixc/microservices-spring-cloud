package com.example.adapters.in.api.rest;

import com.example.core.domain.Company;
import com.example.ports.input.CompanyCRUDInPort;
import com.example.ports.output.CompanyEntityMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyCRUDInPort companyCRUDinPort;

    private static final Log log = LogFactory.getLog(CompanyController.class);

    public CompanyController(CompanyCRUDInPort companyCRUDinPort) {
        this.companyCRUDinPort = companyCRUDinPort;
    }

    @PostMapping()
    public ResponseEntity<CompanyDTO> save(@RequestBody @Valid CompanyDTO companyDTO) {
        Company company = this.companyCRUDinPort.save(CompanyRestMapper.of(companyDTO));
        return ResponseEntity.ok(CompanyRestMapper.of(company));
    }

    @PutMapping()
    public ResponseEntity<CompanyDTO> update(@RequestBody CompanyDTO companyDto){
        Company company = CompanyRestMapper.of(companyDto);

        return ResponseEntity.ok(CompanyEntityMapper.of(
                this.companyCRUDinPort.update(CompanyRestMapper.of(companyDto))
        ));
    }


    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> read(@PathVariable Long id){
        Optional<Company> companyOp = this.companyCRUDinPort.findById(id);
        return companyOp.isPresent() ? ResponseEntity.ok(CompanyRestMapper.of(companyOp.get())) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<CompanyDTO> delete(@PathVariable Long id){
        this.companyCRUDinPort.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<CompanyDTO>> getAll() {
        return ResponseEntity.ok(this.companyCRUDinPort.findAll().stream()
                .map(CompanyRestMapper::of)
                .toList());
    }
}
