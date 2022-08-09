package com.org.photography.app.repository;

import com.org.photography.app.entity.PhotographerJobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.sql.Date;

public interface PhotographerJobsRepository extends JpaRepository<PhotographerJobs, Integer> {

    @Query(value = "SELECT * FROM photographer_jobs p WHERE p.photographer_id = ?1 and p.job_date>=?2", nativeQuery = true)
    public List<PhotographerJobs> findByPhotographerId(int photographerId, Date date);

    @Query(value="SELECT distinct p.customer_id, p.photographer_id, c.first_name, c.last_name, a.house_no, a.area, a.city, a.pincode, p.job_date, p.job_start, p.job_end FROM photographer_jobs p inner join customer c on p.customer_id = c.customer_id inner join address a on a.customer_id = c.customer_id and p.photographer_id =?1 and p.job_date>=?2",nativeQuery = true)
    public List<Object[]> findCustomerDetailsByPhotographerId(int photographerId, Date date);
}
