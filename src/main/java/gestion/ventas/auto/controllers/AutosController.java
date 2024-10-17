package gestion.ventas.auto.controllers;

import gestion.ventas.auto.dto.AutoDTO;
import gestion.ventas.auto.models.Autos;
import gestion.ventas.auto.service.ServiceAutos;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.repo.Resource;

import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

@RestController
@RequestMapping("/api/auto")
public class AutosController {
	
	private final DataSource dataResource;
	private final ResourceLoader resourceLoader;
    private final ServiceAutos serviceAutos;
    public AutosController (ServiceAutos serviceAutos, DataSource dataResource, ResourceLoader resourceLoader){
        this.dataResource = dataResource;
		this.resourceLoader = resourceLoader;
		this.serviceAutos = serviceAutos;
    }
    @GetMapping
    public List<AutoDTO> listarTodo (){
        return serviceAutos.listAll();
    }
    @PostMapping
    public ResponseEntity<?> registrarAuto(@RequestBody AutoDTO autoDTO){
        return ResponseEntity.ok(serviceAutos.createAuto(autoDTO));

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAutos(@PathVariable String id, @RequestBody AutoDTO autoDTO){
        return ResponseEntity.ok(serviceAutos.updateAutos(id, autoDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        try {
            serviceAutos.deleteAuto(id);
            return ResponseEntity.ok("Auto eliminado: " + id);

        }catch (RuntimeException e){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/reporte")
    public void generarPDFCliente(HttpServletResponse response) {
        response.setHeader("Content-Disposition", "inline;");
        response.setContentType("application/pdf");
        try {
            String ru = resourceLoader.getResource("classpath:static/report/lista_auto.jasper").getURI().getPath();
            JasperPrint jasperPrint = JasperFillManager.fillReport(ru,null, dataResource.getConnection());
            OutputStream outStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
