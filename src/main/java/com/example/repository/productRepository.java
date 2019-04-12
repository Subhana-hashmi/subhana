
package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.productModel;

public interface productRepository extends JpaRepository<productModel, Long>{

	@Query(value = "select * from TBLPRODUCT where ISACTIVE='Y'", nativeQuery = true)
	public List<productModel> findActive();

	@Query(value = "select * from TBLPRODUCT"
			+ "where PRODUCT_NAME like '%'+?1+'%' or  PRODUCT_COMPANY like '%'+?1+'%'"
			+"ISACTIVE='Y'", nativeQuery = true)
	public List<productModel> findBySearch(String search);

	@Query(value = "select * from TBLPRODUCT"
			+ "where PRODUCT_NAME like '%'+?1+'%' "
			+"or  PRODUCT_COMPANY like '%'+?1+'%'", nativeQuery = true)
	public List<productModel> findAllBySearch(String search);

	/*@Query(value = "select * from TBLPRODUCT " 
			+ "where PRODUCT_ID LIKE CASE WHEN ?1 = 0 THEN PRODUCT_ID ELSE ?1 END "
			+ "and ISACTIVE='Y'", nativeQuery = true)
	List<productModel> findByAdvanceSearch(Long productID);

	@Query(value = "select * from TBLPRODUCT " 
			+ "where PRODUCT_ID LIKE CASE WHEN ?1 = 0 THEN PRODUCT_ID ELSE ?1 END ", nativeQuery = true)
	List<productModel> findAllByAdvanceSearch(Long productID);*/


}