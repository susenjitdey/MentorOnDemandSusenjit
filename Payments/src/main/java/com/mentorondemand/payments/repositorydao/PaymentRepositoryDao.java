/**
 * 
 */
package com.mentorondemand.payments.repositorydao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorondemand.payments.model.Payments;

/**
 * @author javaibm04
 *
 */
@Repository
public interface PaymentRepositoryDao extends JpaRepository<Payments, Long>{

}
