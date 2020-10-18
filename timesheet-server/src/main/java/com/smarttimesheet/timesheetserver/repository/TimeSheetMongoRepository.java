package com.smarttimesheet.timesheetserver.repository;

import com.smarttimesheet.timesheetserver.domain.Details;
import com.smarttimesheet.timesheetserver.domain.Timesheet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TimeSheetMongoRepository extends MongoRepository<Timesheet, String>{
    List<Timesheet> findByName(String name);
    List<Details> findDetailsByName(String name);
    List<Timesheet> findAllByWeekEndingAndName(String weekEnding, String name);
}
