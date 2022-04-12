package com.example.adapters.in.api.rest;

import com.example.core.domain.Invoice;
import com.example.ports.input.InvoiceCRUDInPort;
import com.example.ports.output.InvoiceEntityMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceCRUDInPort invoiceCRUDInPort;

    private static final Log log = LogFactory.getLog(InvoiceController.class);

    public InvoiceController(InvoiceCRUDInPort companyCRUDinPort) {
        this.invoiceCRUDInPort = companyCRUDinPort;
    }

    @PostMapping()
    public ResponseEntity<InvoiceDto> save(@RequestBody @Valid InvoiceDto companyDTO) {
        Invoice company = this.invoiceCRUDInPort.save(InvoiceRestMapper.of(companyDTO));
        return ResponseEntity.ok(InvoiceRestMapper.of(company));
    }

    @PutMapping()
    public ResponseEntity<InvoiceDto> update(@RequestBody InvoiceDto companyDto){
        Invoice company = InvoiceRestMapper.of(companyDto);

        return ResponseEntity.ok(InvoiceEntityMapper.of(
                this.invoiceCRUDInPort.update(InvoiceRestMapper.of(companyDto))
        ));
    }


    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDto> read(@PathVariable Long id){
        Optional<Invoice> companyOp = this.invoiceCRUDInPort.findById(id);
        return companyOp.isPresent() ? ResponseEntity.ok(InvoiceRestMapper.of(companyOp.get())) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<InvoiceDto> delete(@PathVariable Long id){
        this.invoiceCRUDInPort.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<InvoiceDto>> getAll() {
        return ResponseEntity.ok(this.invoiceCRUDInPort.findAll().stream()
                .map(InvoiceRestMapper::of)
                .toList());
    }
}
