/**
 * 
 */
package com.huawei.sdn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.sdn.api.entity.PDU;
import com.huawei.sdn.api.entity.Product;
import com.huawei.sdn.api.entity.Version;
import com.huawei.sdn.api.repository.PDURepository;
import com.huawei.sdn.api.repository.ProductReository;
import com.huawei.sdn.api.repository.VersionRepository;

/**
 * @author huanglu
 *
 */
@RestController
@RequestMapping("/api")
public class VersionController {
	
	@Autowired
	private VersionRepository versionRepository;
	
	@Autowired
	private ProductReository productReository;
	
	@Autowired
	private PDURepository pduRepository;
	
	@GetMapping("/pdu")
	public List<PDU> getPDUList(@PathVariable Long id){
		List<PDU> list = pduRepository.findAll();
		return list;
	}
	
	@GetMapping("/pdu/{id}")
	public PDU getPDU(@PathVariable Long id){
		PDU pdu = pduRepository.findOne(id);
		return pdu;
	}
	
	@PostMapping("/pdu")
	public boolean addPDU(@RequestBody PDU pdu){
		pduRepository.save(pdu);
		return true;
	}
	
	@PutMapping("/pdu")
	public boolean updatePDU(@RequestBody PDU pdu){
		pduRepository.save(pdu);
		return true;
	}
	
	@DeleteMapping("/pdu")
	public boolean deletePDU(@RequestBody PDU pdu){
		pduRepository.delete(pdu);;
		return true;
	}
	
	@DeleteMapping("/pdu/{id}")
	public boolean deletePDU(@PathVariable Long id){
		pduRepository.delete(id);;
		return true;
	}
	
	@GetMapping("/pdu/{id}/product")
	public List<Product> getProductList(@PathVariable Long id){
		List<Product> list = productReository.listProductVersion(id);
		return list;
	}
	
	@GetMapping("/product")
	public List<Product> getProductListAll(@PathVariable Long id){
		List<Product> list = productReository.findAll();
		return list;
	}
	
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable Long id){
		Product product = productReository.findOne(id);
		return product;
	}
	
	@PostMapping("/product")
	public boolean addProduct(@RequestBody Product product){
		productReository.save(product);
		return true;
	}
	
	@PutMapping("/product")
	public boolean updateProduct(@RequestBody Product product){
		productReository.save(product);
		return true;
	}
	
	@DeleteMapping("/product")
	public boolean deleteProduct(@RequestBody Product product){
		productReository.delete(product);;
		return true;
	}
	
	@DeleteMapping("/product/{id}")
	public boolean deleteProduct(@PathVariable Long id){
		productReository.delete(id);;
		return true;
	}
	
	@GetMapping("/product/{id}/version")
	public List<Version> getVersionList(@PathVariable Long id){
		List<Version> list = versionRepository.listProductVersion(id);
		return list;
	}
	
	@GetMapping("/version")
	public List<Version> getVersionListAll(@PathVariable Long id){
		List<Version> list = versionRepository.findAll();
		return list;
	}
	
	@GetMapping("/version/{id}")
	public Version getVersion(@PathVariable Long id){
		Version version = versionRepository.findOne(id);
		return version;
	}
	
	@PostMapping("/version")
	public boolean addVersion(@RequestBody Version version){
		versionRepository.save(version);
		return true;
	}
	
	@PutMapping("/version")
	public boolean updateVersion(@RequestBody Version version){
		versionRepository.save(version);
		return true;
	}
	
	@DeleteMapping("/version")
	public boolean deleteVersion(@RequestBody Version version){
		versionRepository.delete(version);;
		return true;
	}
	
	@DeleteMapping("/version/{id}")
	public boolean deleteVersion(@PathVariable Long id){
		versionRepository.delete(id);;
		return true;
	}
	
}
