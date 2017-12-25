package com.example.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.domain.DataModel;

@RepositoryRestResource
public interface DataModelResource extends JpaRepository<DataModel, Long> {

	@Query("select o from DataModel o where o.filename = :filename")
	public DataModel findIfExists(@Param("filename") String filename);

	public DataModel findByFilename(String filename);

}
