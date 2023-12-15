package a1.test.task.task3.repository;

import a1.test.task.task3.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Long> {

    @Query(value = "SELECT * FROM postings WHERE Doc_Date BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<Posting> findByDocDateBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = "SELECT * FROM postings WHERE Doc_Date BETWEEN :startDate AND :endDate AND Authorized_Delivery = :authorized", nativeQuery = true)
    List<Posting> findByDocDateBetweenAndByAuthorizedDelivery(@Param("startDate") LocalDate startDate,
                                                                  @Param("endDate") LocalDate endDate,
                                                                  @Param("authorized") Boolean authorized);

}
