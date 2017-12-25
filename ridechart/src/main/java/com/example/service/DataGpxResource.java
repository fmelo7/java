package com.example.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.domain.DataGpx;

@RepositoryRestResource
public interface DataGpxResource extends JpaRepository<DataGpx, Long> {

    @Query("select o from DataGpx o where o.filename = :filename")
    public DataGpx findIfExists(@Param("filename") String filename);

    public DataGpx findByFilename(String filename);

}
