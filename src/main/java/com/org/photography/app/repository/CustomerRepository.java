package com.org.photography.app.repository;
        import com.org.photography.app.entity.Customer;
        import org.springframework.data.jpa.repository.JpaRepository;

        import java.util.Optional;

public interface CustomerRepository
        extends JpaRepository<Customer,Integer>{
        Optional<Customer> findByUsername(String username);
        Boolean existsByUsername (String username);

        Boolean existsByEmail(String email);
}
