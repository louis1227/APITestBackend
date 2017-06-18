/**
 * 
 */
package com.huawei.sdn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.huawei.sdn.api.entity.Product;
import com.huawei.sdn.api.entity.Version;

/**
 * @author huanglu
 *
 */
public interface ProductReository extends JpaRepository<Product, Long> {

	@Query("select p from Product p where p.pdu.id =?1")
	public List<Product> listProductVersion(Long id);
	
}
