package com.app.kuri.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.kuri.Model.Org;

@Repository
public interface OrgRepository extends JpaRepository<Org, Long> {

    Optional<List<Org>> findBySchema(String schema);

}
