/**
 * 
 */
package com.huawei.sdn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.huawei.sdn.api.entity.Version;

/**
 * @author huanglu
 *
 */
public interface VersionRepository extends JpaRepository<Version, Long> {
	
	@Query("select v from Version v where v.product.id =?1")
	public List<Version> listProductVersion(Long id);

}
