// ProductRepository.java
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByCategory_Id(Long categoryId, Pageable pageable);
}