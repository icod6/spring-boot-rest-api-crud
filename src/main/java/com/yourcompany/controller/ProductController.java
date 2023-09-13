// ProductController.java
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    // Other CRUD endpoints...

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            // Fetch category details and set them in the product
            Category category = categoryService.getCategoryById(product.getCategory().getId());
            product.setCategory(category);

            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }
}