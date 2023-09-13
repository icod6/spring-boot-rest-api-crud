// ProductService.java
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getProductsByCategoryId(Long categoryId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findByCategory_Id(categoryId, pageable);
    }

    // Other CRUD methods...
}