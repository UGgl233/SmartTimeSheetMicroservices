package com.smarttimesheet.userserver.repo;

import com.smarttimesheet.userserver.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    Contact findByUser(Integer id);
}